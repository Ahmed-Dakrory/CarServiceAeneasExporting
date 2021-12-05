package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.PrimeFaces;

import main.com.carService.car.car;
import main.com.carService.car.carAppServiceImpl;
import main.com.carService.consignee.consignee;
import main.com.carService.consignee.consigneeAppServiceImpl;
import main.com.carService.custom.custom;
import main.com.carService.custom.customAppServiceImpl;
import main.com.carService.customCommodity.commoditiy;
import main.com.carService.customCommodity.commoditiyAppServiceImpl;
import main.com.carService.customTransportation.customtransportation;
import main.com.carService.customTransportation.customtransportationAppServiceImpl;
import main.com.carService.docreciept.ReportFileGeneration;
import main.com.carService.docreciept.docreciept;
import main.com.carService.docreciept.docrecieptAppServiceImpl;
import main.com.carService.loginNeeds.user;


@ManagedBean(name = "customBean")
@SessionScoped
public class customBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236769354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	

	private List<custom> customListForThisUser;
	private List<docreciept> docReceiptListForThisUser;

	@ManagedProperty(value = "#{customFacadeImpl}")
	private customAppServiceImpl customFacade;
	

	@ManagedProperty(value = "#{consigneeFacadeImpl}")
	private consigneeAppServiceImpl consigneeFacade;
	
	

	@ManagedProperty(value = "#{commoditiyFacadeImpl}")
	private commoditiyAppServiceImpl commoditiyFacade;
	

	@ManagedProperty(value = "#{docrecieptFacadeImpl}")
	private docrecieptAppServiceImpl docrecieptFacade;
	

	@ManagedProperty(value = "#{customtransportationFacadeImpl}")
	private customtransportationAppServiceImpl customtransportationFacade;
	
	private user theUserOfThisAccount;
	

	private docreciept selectedDocReceipt;
	

	private custom selectedCustomData;

	private Map<Integer, String> ports;
	private Map<Integer, String> modeTrans;
	private Map<Integer, String> inbondTypes;
	
	private String edaString="";
	

	private List<consignee> listOfConsignees;
	

	private Integer usppiIdUsedForSelector;
	private Integer ulConsigneeIdUsedForSelector;
	private Integer interConsigneeIdUsedForSelector;
	private Integer frightForwardedIdUsedForSelector;
	private Integer customSettingsId;
	
	

	private List<commoditiy> listOfCommodities;
	private commoditiy addedNewCommoditiy;
	

	private List<customtransportation> listOfTransportations;
	private customtransportation addedNewTransportations;
	

	private List<car> carsForthisAccountCustoms;

	@ManagedProperty(value = "#{carFacadeImpl}")
	private carAppServiceImpl carFacade;
	
	private Integer selectedCarIdToBeAddedInCommodities;
	
	@PostConstruct
	public void init() {

		ports=new LinkedHashMap<Integer,String>();
		modeTrans=new LinkedHashMap<Integer,String>();
		inbondTypes=new LinkedHashMap<Integer,String>();
		fillPorts();
		fillModeTrans();
		fillInbondTypes();
		refresh();
		
		
	}
	
	
	public String getFormatedDate(Calendar c) {
		String dateTime="";
		if(c!=null) {
			String[] monthNames = {"Jan", "Feb", "Mar", "April", "May", "Jun", "Jul", "Aug", "Sep", "Octo", "Nov", "Dec"};
		    
		dateTime = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) +"/"+
				   String.valueOf(monthNames[c.get(Calendar.MONTH)]) +"/"+
				   String.valueOf(c.get(Calendar.YEAR));
		}
		return dateTime;
	}


	public String getPortValue(Integer i) {
		String value=ports.get(i);
		
		return value;
		
	}
	
	public String getModeTransValue(Integer i) {
		String value=modeTrans.get(i);
		
		return value;
		
	}
	
	
	
	public String getInbondTypesValue(Integer i) {
		String value=inbondTypes.get(i);
		
		return value;
		
	}
	


	public void refresh(){

		theUserOfThisAccount = loginBean.getTheUserOfThisAccount();
		customListForThisUser = customFacade.getAllByUserId(theUserOfThisAccount.getId());
		
		if(theUserOfThisAccount.getRole()==user.ROLE_MAIN) {
			listOfConsignees = consigneeFacade.getAllByMainAccountIdOfParentShipper(theUserOfThisAccount.getId());
			docReceiptListForThisUser=docrecieptFacade.getAllByMainId(theUserOfThisAccount.getId());
			carsForthisAccountCustoms=carFacade.getAllForMainUser(theUserOfThisAccount.getId());
		}else {
			docReceiptListForThisUser=docrecieptFacade.getAllByUserId(theUserOfThisAccount.getId());
			if(theUserOfThisAccount.getRole()==user.ROLE_SHIPPER) {
			carsForthisAccountCustoms=carFacade.getAllForShipper(theUserOfThisAccount.getId());
			}
		}
		
	}


	
	
	
	public void goToAddNewDocReceipt() {
		selectedCustomData =new custom();
		
		selectedDocReceipt=new docreciept();
		
		
		edaString = "";
		usppiIdUsedForSelector = -1;
		interConsigneeIdUsedForSelector = -1;
		ulConsigneeIdUsedForSelector = -1;
		frightForwardedIdUsedForSelector = -1;
		
		listOfCommodities = new ArrayList<commoditiy>();
		listOfTransportations = new ArrayList<customtransportation>();
		
		
		

		addedNewCommoditiy =new commoditiy();

		int numberOfCommodities = listOfCommodities.size();
		addedNewCommoditiy.setIsLine("Y");
		addedNewCommoditiy.setLineNum(numberOfCommodities+1);
		addedNewCommoditiy.setDocReceiptId(selectedDocReceipt);
		
		
		addedNewTransportations =new customtransportation();
		
		int numberOfTransportations = listOfTransportations.size();
		addedNewTransportations.setLineNum(numberOfTransportations+1);
		addedNewTransportations.setDocReceiptId(selectedDocReceipt);
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/shipmentList/editShipment.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
public void selectDocReceipt(int id) {
		
		edaString = "";
		usppiIdUsedForSelector = -1;
		interConsigneeIdUsedForSelector = -1;
		ulConsigneeIdUsedForSelector = -1;
		frightForwardedIdUsedForSelector = -1;
		customSettingsId = -1;
		
		selectedDocReceipt=docrecieptFacade.getById(id);
		
		
		selectedCustomData = customFacade.getByDocReceiptId(id);
		if(selectedCustomData==null) {
			selectedCustomData = new custom();	
		}
		
		
		selectedCustomData.setScac(selectedDocReceipt.getScac());
		selectedCustomData.setVn(selectedDocReceipt.getVn());
		selectedCustomData.setBn(selectedDocReceipt.getBn());
		selectedCustomData.setSrn(selectedDocReceipt.getSrn());
		selectedCustomData.setSoldEnRoute(selectedDocReceipt.getSoldEnRoute());
		selectedCustomData.setConsigneeType(selectedDocReceipt.getConsigneeType());
		

		selectedCustomData.setSt(selectedDocReceipt.getPortOfExportState());
		selectedCustomData.setPou(selectedDocReceipt.getPortOfDestination());
		selectedCustomData.setCod(selectedDocReceipt.getCountryOfDestination());
		selectedCustomData.setIbt(selectedDocReceipt.getIbt());
		selectedCustomData.setRt(selectedDocReceipt.getRt());
		selectedCustomData.setRcc(selectedDocReceipt.getRcc());
		selectedCustomData.setHaz(selectedDocReceipt.getHaz());
		selectedCustomData.setMot(selectedDocReceipt.getMot());
		
		
		edaString = getStringFromCalendar(selectedDocReceipt.getDate());
		
		
		if(selectedDocReceipt.getUsppiId()!=null) {
			usppiIdUsedForSelector = selectedDocReceipt.getUsppiId().getId();
		}
		
		if(selectedDocReceipt.getIntermConsignee()!=null) {
			interConsigneeIdUsedForSelector = selectedDocReceipt.getIntermConsignee().getId();
		}
		
		if(selectedDocReceipt.getUltiConsignee()!=null) {
			ulConsigneeIdUsedForSelector = selectedDocReceipt.getUltiConsignee().getId();
		}
		
		if(selectedDocReceipt.getFreightForwarderId()!=null) {
			frightForwardedIdUsedForSelector = selectedDocReceipt.getFreightForwarderId().getId();
		}
		
		
		
		 
		
		

		listOfCommodities = commoditiyFacade.getAllByDocReceiptId(id);
		listOfTransportations = customtransportationFacade.getAllByDocReceiptId(id);
		
		

		addedNewCommoditiy =new commoditiy();
		addedNewTransportations =new customtransportation();
		

		if(listOfCommodities==null) {
			listOfCommodities = new ArrayList<commoditiy>();
		}else {
			if(listOfCommodities.get(0).getCustomId()!=null) {

				if(listOfCommodities.get(0).getCustomId()!=null) {
				addedNewCommoditiy.setCustomId(listOfCommodities.get(0).getCustomId());
				}
			}
		}
		
		if(listOfTransportations==null) {
			listOfTransportations = new ArrayList<customtransportation>();
		}else {
			if(listOfTransportations.get(0).getCustomId()!=null) {
				if(listOfTransportations.get(0).getCustomId()!=null) {
					
				addedNewTransportations.setCustomId(listOfTransportations.get(0).getCustomId());
				}
			}
		}
		
		
		int numberOfCommodities = listOfCommodities.size();
		addedNewCommoditiy.setIsLine("Y");
		addedNewCommoditiy.setLineNum(numberOfCommodities+1);
		addedNewCommoditiy.setDocReceiptId(selectedDocReceipt);
		
		
		addedNewTransportations =new customtransportation();
		addedNewTransportations.setDocReceiptId(selectedDocReceipt);

		int numberOfTransportations = listOfTransportations.size();
		addedNewTransportations.setLineNum(numberOfTransportations+1);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/shipmentList/editShipment.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void updateTheSelectedDocReceiptData() {

	

	consignee ultimConsignee = consigneeFacade.getById(ulConsigneeIdUsedForSelector);
	consignee usppi = consigneeFacade.getById(usppiIdUsedForSelector);
	consignee interConsignee = consigneeFacade.getById(interConsigneeIdUsedForSelector);
	consignee frightForConsignee = consigneeFacade.getById(frightForwardedIdUsedForSelector);
	

	selectedCustomData.setFreightForwardedId(frightForConsignee);
	selectedCustomData.setInterConsigneeId(interConsignee);
	selectedCustomData.setUsppiId(usppi);
	selectedCustomData.setUlConsigneeId(ultimConsignee);
	selectedCustomData.setUserId(theUserOfThisAccount);
	selectedCustomData.setEda(setCalendarFromString(edaString));
	
	
	selectedDocReceipt.setDate(setCalendarFromString(edaString));

	selectedDocReceipt.setFreightForwarderId(frightForConsignee);
	selectedDocReceipt.setUltiConsignee(ultimConsignee);
	selectedDocReceipt.setIntermConsignee(interConsignee);
	selectedDocReceipt.setUsppiId(usppi);

	selectedDocReceipt.setUserId(theUserOfThisAccount);
	selectedDocReceipt.setMainId(theUserOfThisAccount.getMainUserId());
	

	selectedDocReceipt.setScac(selectedCustomData.getScac());
	selectedDocReceipt.setVn(selectedCustomData.getVn());
	selectedDocReceipt.setBn(selectedCustomData.getBn());
	selectedDocReceipt.setSrn(selectedCustomData.getSrn());
	selectedDocReceipt.setSoldEnRoute(selectedCustomData.getSoldEnRoute());
	selectedDocReceipt.setConsigneeType(selectedCustomData.getConsigneeType());

	selectedDocReceipt.setPortOfExportState(selectedCustomData.getSt());
	selectedDocReceipt.setPortOfDestination(selectedCustomData.getPou());
	selectedDocReceipt.setCountryOfDestination(selectedCustomData.getCod());
	selectedDocReceipt.setIbt(selectedCustomData.getIbt());
	selectedDocReceipt.setRt(selectedCustomData.getRt());
	selectedDocReceipt.setRcc(selectedCustomData.getRcc());
	selectedDocReceipt.setHaz(selectedCustomData.getHaz());
	selectedDocReceipt.setMot(selectedCustomData.getMot());
	
	
	docrecieptFacade.adddocreciept(selectedDocReceipt);
	selectedCustomData.setDoReceiptId(selectedDocReceipt);
	
	for(int i=0;i<listOfCommodities.size();i++) {
		listOfCommodities.get(i).setDocReceiptId(selectedDocReceipt);
		
		commoditiyFacade.addcommoditiy(listOfCommodities.get(i));
	}
	
	for(int i=0;i<listOfTransportations.size();i++) {
		listOfTransportations.get(i).setDocReceiptId(selectedDocReceipt);
		
		customtransportationFacade.addcustomtransportation(listOfTransportations.get(i));
	}
	
	PrimeFaces.current().executeScript("new PNotify({\r\n" + 
			"			title: 'Success',\r\n" + 
			"			text: 'Your DocReceipt done.',\r\n" + 
			"			type: 'success'\r\n" + 
			"		});");

	
	try {
		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/admin/shipmentList/docReceiptList.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public void submitTheSelectedDocReceiptData() {

	consignee ultimConsignee = consigneeFacade.getById(ulConsigneeIdUsedForSelector);
	consignee usppi = consigneeFacade.getById(usppiIdUsedForSelector);
	consignee interConsignee = consigneeFacade.getById(interConsigneeIdUsedForSelector);
	consignee frightForConsignee = consigneeFacade.getById(frightForwardedIdUsedForSelector);
	

	selectedCustomData.setFreightForwardedId(frightForConsignee);
	selectedCustomData.setInterConsigneeId(interConsignee);
	selectedCustomData.setUsppiId(usppi);
	selectedCustomData.setUlConsigneeId(ultimConsignee);
	selectedCustomData.setUserId(theUserOfThisAccount);
	selectedCustomData.setEda(setCalendarFromString(edaString));
	
	
	selectedDocReceipt.setDate(setCalendarFromString(edaString));

	selectedDocReceipt.setFreightForwarderId(frightForConsignee);
	selectedDocReceipt.setUltiConsignee(ultimConsignee);
	selectedDocReceipt.setIntermConsignee(interConsignee);
	selectedDocReceipt.setUsppiId(usppi);

	selectedDocReceipt.setUserId(theUserOfThisAccount);
	selectedDocReceipt.setMainId(theUserOfThisAccount.getMainUserId());
	

	selectedDocReceipt.setScac(selectedCustomData.getScac());
	selectedDocReceipt.setVn(selectedCustomData.getVn());
	selectedDocReceipt.setBn(selectedCustomData.getBn());
	selectedDocReceipt.setSrn(selectedCustomData.getSrn());
	selectedDocReceipt.setSoldEnRoute(selectedCustomData.getSoldEnRoute());
	selectedDocReceipt.setConsigneeType(selectedCustomData.getConsigneeType());

	selectedDocReceipt.setPortOfExportState(selectedCustomData.getSt());
	selectedDocReceipt.setPortOfDestination(selectedCustomData.getPou());
	selectedDocReceipt.setCountryOfDestination(selectedCustomData.getCod());
	selectedDocReceipt.setIbt(selectedCustomData.getIbt());
	selectedDocReceipt.setRt(selectedCustomData.getRt());
	selectedDocReceipt.setRcc(selectedCustomData.getRcc());
	selectedDocReceipt.setHaz(selectedCustomData.getHaz());
	selectedDocReceipt.setMot(selectedCustomData.getMot());
	
	
	docrecieptFacade.adddocreciept(selectedDocReceipt);
	selectedCustomData.setDoReceiptId(selectedDocReceipt);
	customFacade.addcustom(selectedCustomData);
	
	for(int i=0;i<listOfCommodities.size();i++) {
		listOfCommodities.get(i).setDocReceiptId(selectedDocReceipt);
		listOfCommodities.get(i).setCustomId(selectedCustomData);
		commoditiyFacade.addcommoditiy(listOfCommodities.get(i));
	}
	
	for(int i=0;i<listOfTransportations.size();i++) {
		listOfTransportations.get(i).setDocReceiptId(selectedDocReceipt);

		listOfTransportations.get(i).setCustomId(selectedCustomData);
		customtransportationFacade.addcustomtransportation(listOfTransportations.get(i));
	}
	
	PrimeFaces.current().executeScript("new PNotify({\r\n" + 
			"			title: 'Success',\r\n" + 
			"			text: 'Your DocReceipt done.',\r\n" + 
			"			type: 'success'\r\n" + 
			"		});");

	try {
		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/admin/customs/customRequest/editCustom.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void generateFile(){
	 HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet();
	    
	    ReportFileGeneration reportFileGeneration=new ReportFileGeneration(this,listOfCommodities,loginBean,selectedDocReceipt,workbook, sheet);
	    
	    reportFileGeneration.generateReport();

	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    externalContext.setResponseContentType("application/vnd.ms-excel");
	    externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"my.xls\"");

	    try {
			workbook.write(externalContext.getResponseOutputStream());
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	    facesContext.responseComplete();
}

	public void addCarToCommodities() {
		car selectedCarToBeAddedInInvoice= carFacade.getById(selectedCarIdToBeAddedInCommodities);
		addedNewCommoditiy.setIt_15("Y");//yes flag for car
		addedNewCommoditiy.setIt_17(selectedCarToBeAddedInInvoice.getUuid());//uuid -->vin
		addedNewCommoditiy.setIt_18(selectedCarToBeAddedInInvoice.getTitleNumber());//title number
		addedNewCommoditiy.setIt_7(String.valueOf(selectedCarToBeAddedInInvoice.getWeight()));//weight
		addedNewCommoditiy.setIt_4("1");//Quantity
		addedNewCommoditiy.setIt_2(String.valueOf(selectedCarToBeAddedInInvoice.getValueOfGood()));//price
		addedNewCommoditiy.setDescription(selectedCarToBeAddedInInvoice.getYear()+" "+selectedCarToBeAddedInInvoice.getMake()+" "+selectedCarToBeAddedInInvoice.getModel());//price
		
		
		

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs:addedNewCommodiy3");
		
	}
	
	
	public void updateTheSelectedCustomsData() {

		

		consignee ultimConsignee = consigneeFacade.getById(ulConsigneeIdUsedForSelector);
		consignee usppi = consigneeFacade.getById(usppiIdUsedForSelector);
		consignee interConsignee = consigneeFacade.getById(interConsigneeIdUsedForSelector);
		consignee frightForConsignee = consigneeFacade.getById(frightForwardedIdUsedForSelector);
		
		
		selectedCustomData.setEda(setCalendarFromString(edaString));
		selectedCustomData.setFreightForwardedId(frightForConsignee);
		selectedCustomData.setUlConsigneeId(ultimConsignee);
		selectedCustomData.setInterConsigneeId(interConsignee);
		selectedCustomData.setUsppiId(usppi);
		
		selectedCustomData.setUserId(theUserOfThisAccount);
		
		customFacade.addcustom(selectedCustomData);
		
		
		
		for(int i=0;i<listOfCommodities.size();i++) {
			listOfCommodities.get(i).setCustomId(selectedCustomData);
			commoditiyFacade.addcommoditiy(listOfCommodities.get(i));
		}
		
		for(int i=0;i<listOfTransportations.size();i++) {
			listOfTransportations.get(i).setCustomId(selectedCustomData);
			customtransportationFacade.addcustomtransportation(listOfTransportations.get(i));
		}
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Custom Updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customRequest/customList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cancel() {
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customSettings/customSettingsList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void cancelCustom() {
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customRequest/customList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	public void cancelDocReceipt() {
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/shipmentList/docReceiptList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	public void addTheNewcustomTransportation() {
		listOfTransportations.add(addedNewTransportations);

		addedNewTransportations =new customtransportation();
		addedNewTransportations.setCustomId(selectedCustomData);
		addedNewTransportations.setLineNum(listOfTransportations.size()+1);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Transportation has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs2");
	}
	
	public void addTheNewcustomTransportationDocReceipt() {
		listOfTransportations.add(addedNewTransportations);

		addedNewTransportations =new customtransportation();
		addedNewTransportations.setDocReceiptId(selectedDocReceipt);
		addedNewTransportations.setLineNum(listOfTransportations.size()+1);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Transportation has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs2");
	}
	
	
	public void addTheNewCommodity() {
		listOfCommodities.add(addedNewCommoditiy);

		addedNewCommoditiy =new commoditiy();
		addedNewCommoditiy.setCustomId(selectedCustomData);
		addedNewCommoditiy.setLineNum(listOfCommodities.size()+1);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Commodity has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs:addedNewCommodiy3");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs:commodities");
	}
	
	
	public void addTheNewCommodityForDocReceipt() {
		listOfCommodities.add(addedNewCommoditiy);

		addedNewCommoditiy =new commoditiy();
		addedNewCommoditiy.setDocReceiptId(selectedDocReceipt);
		addedNewCommoditiy.setLineNum(listOfCommodities.size()+1);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Commodity has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs:addedNewCommodiy3");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tabs:commodities");
	}
	
	public void goToAddNewCustomData() {
		
		selectedCustomData =new custom();
		
		edaString = "";
		usppiIdUsedForSelector = -1;
		interConsigneeIdUsedForSelector = -1;
		ulConsigneeIdUsedForSelector = -1;
		frightForwardedIdUsedForSelector = -1;
		
			listOfCommodities = new ArrayList<commoditiy>();
			listOfTransportations = new ArrayList<customtransportation>();
		
		
		

		addedNewCommoditiy =new commoditiy();
		addedNewCommoditiy.setCustomId(selectedCustomData);

		int numberOfCommodities = listOfCommodities.size();
		addedNewCommoditiy.setIsLine("Y");
		addedNewCommoditiy.setLineNum(numberOfCommodities+1);
		
		
		addedNewTransportations =new customtransportation();
		addedNewTransportations.setCustomId(selectedCustomData);
		
		int numberOfTransportations = listOfTransportations.size();
		addedNewTransportations.setLineNum(numberOfTransportations+1);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customRequest/editCustom.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void selectcustom(int id) {
		
		edaString = "";
		usppiIdUsedForSelector = -1;
		interConsigneeIdUsedForSelector = -1;
		ulConsigneeIdUsedForSelector = -1;
		frightForwardedIdUsedForSelector = -1;
		customSettingsId = -1;
		
		selectedCustomData = customFacade.getById(id);
		
		

		
		
		edaString = getStringFromCalendar(selectedCustomData.getEda());
		
		
		if(selectedCustomData.getUsppiId()!=null) {
			usppiIdUsedForSelector = selectedCustomData.getUsppiId().getId();
		}
		
		if(selectedCustomData.getInterConsigneeId()!=null) {
			interConsigneeIdUsedForSelector = selectedCustomData.getInterConsigneeId().getId();
		}
		
		if(selectedCustomData.getUlConsigneeId()!=null) {
			ulConsigneeIdUsedForSelector = selectedCustomData.getUlConsigneeId().getId();
		}
		
		if(selectedCustomData.getFreightForwardedId()!=null) {
			frightForwardedIdUsedForSelector = selectedCustomData.getFreightForwardedId().getId();
		}
		
		
		

		listOfCommodities = commoditiyFacade.getAllByCustomId(id);
		listOfTransportations = customtransportationFacade.getAllByCustomId(id);
		
		

		addedNewCommoditiy =new commoditiy();
		addedNewCommoditiy.setCustomId(selectedCustomData);

		if(listOfCommodities==null) {
			listOfCommodities = new ArrayList<commoditiy>();
		}
		
		if(listOfTransportations==null) {
			listOfTransportations = new ArrayList<customtransportation>();
		}
		
		
		int numberOfCommodities = listOfCommodities.size();
		addedNewCommoditiy.setIsLine("Y");
		addedNewCommoditiy.setLineNum(numberOfCommodities+1);
		
		
		addedNewTransportations =new customtransportation();
		addedNewTransportations.setCustomId(selectedCustomData);

		int numberOfTransportations = listOfTransportations.size();
		addedNewTransportations.setLineNum(numberOfTransportations+1);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customRequest/editCustom.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void submitDataOfForm() {

		consignee ultimConsignee = consigneeFacade.getById(ulConsigneeIdUsedForSelector);
		consignee usppi = consigneeFacade.getById(usppiIdUsedForSelector);
		consignee interConsignee = consigneeFacade.getById(interConsigneeIdUsedForSelector);
		consignee frightForConsignee = consigneeFacade.getById(frightForwardedIdUsedForSelector);
		
		
		selectedCustomData.setEda(setCalendarFromString(edaString));
		selectedCustomData.setFreightForwardedId(frightForConsignee);
		selectedCustomData.setUlConsigneeId(ultimConsignee);
		selectedCustomData.setInterConsigneeId(interConsignee);
		selectedCustomData.setUsppiId(usppi);
		
		selectedCustomData.setUserId(theUserOfThisAccount);
		
		customFacade.addcustom(selectedCustomData);
		
		
		
		for(int i=0;i<listOfCommodities.size();i++) {
			listOfCommodities.get(i).setCustomId(selectedCustomData);
			commoditiyFacade.addcommoditiy(listOfCommodities.get(i));
		}
		
		for(int i=0;i<listOfTransportations.size();i++) {
			listOfTransportations.get(i).setCustomId(selectedCustomData);
			customtransportationFacade.addcustomtransportation(listOfTransportations.get(i));
		}

		PrimeFaces.current().executeScript("doRefreshAndSubmit();");
	}
	
	public void submitDataOfFormDocReceipt() {

		consignee ultimConsignee = consigneeFacade.getById(ulConsigneeIdUsedForSelector);
		consignee usppi = consigneeFacade.getById(usppiIdUsedForSelector);
		consignee interConsignee = consigneeFacade.getById(interConsigneeIdUsedForSelector);
		consignee frightForConsignee = consigneeFacade.getById(frightForwardedIdUsedForSelector);
		
		
		
		selectedCustomData.setEda(setCalendarFromString(edaString));
		selectedCustomData.setFreightForwardedId(frightForConsignee);
		selectedCustomData.setUlConsigneeId(ultimConsignee);
		selectedCustomData.setInterConsigneeId(interConsignee);
		selectedCustomData.setUsppiId(usppi);
		
		selectedCustomData.setUserId(theUserOfThisAccount);
		
		customFacade.addcustom(selectedCustomData);
		
		
		
		for(int i=0;i<listOfCommodities.size();i++) {
			listOfCommodities.get(i).setCustomId(selectedCustomData);
			commoditiyFacade.addcommoditiy(listOfCommodities.get(i));
		}
		
		for(int i=0;i<listOfTransportations.size();i++) {
			listOfTransportations.get(i).setCustomId(selectedCustomData);
			customtransportationFacade.addcustomtransportation(listOfTransportations.get(i));
		}

		PrimeFaces.current().executeScript("doRefreshAndSubmit();");
	}
	
	public String getTimeDateFormat(Calendar date) {
		String dateTimeFormat = getStringFormatCalendar(date);
		
		return dateTimeFormat;
	}

	public String getStringFromCalendar(Calendar calendar) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		String returnedCalendarString="";
		
			if(calendar!=null) {
				returnedCalendarString=formatter.format(calendar.getTime());
			}
		return returnedCalendarString;
	}
	
	public String getStringFormatCalendar(Calendar calendar) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyMMdd"); 
		String returnedCalendarString="";
		
			if(calendar!=null) {
				returnedCalendarString=formatter.format(calendar.getTime());
			}
		return returnedCalendarString;
	}
	
	private Calendar setCalendarFromString(String dateTime) {

		Calendar cal = null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		try {
			if(!dateTime.equals("")) {
				cal=Calendar.getInstance();
				Date date=formatter.parse(dateTime);
				cal.setTime(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return cal;
	}
	
	/*
	 * 
	 * the Getter and setter for the bean
	 */
	
	
	
	

	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}


	

	public customtransportationAppServiceImpl getCustomtransportationFacade() {
		return customtransportationFacade;
	}


	public void setCustomtransportationFacade(customtransportationAppServiceImpl customtransportationFacade) {
		this.customtransportationFacade = customtransportationFacade;
	}


	public List<customtransportation> getListOfTransportations() {
		return listOfTransportations;
	}


	public void setListOfTransportations(List<customtransportation> listOfTransportations) {
		this.listOfTransportations = listOfTransportations;
	}


	public customtransportation getAddedNewTransportations() {
		return addedNewTransportations;
	}


	public void setAddedNewTransportations(customtransportation addedNewTransportations) {
		this.addedNewTransportations = addedNewTransportations;
	}


	public commoditiyAppServiceImpl getCommoditiyFacade() {
		return commoditiyFacade;
	}


	public List<docreciept> getDocReceiptListForThisUser() {
		return docReceiptListForThisUser;
	}


	public void setDocReceiptListForThisUser(List<docreciept> docReceiptListForThisUser) {
		this.docReceiptListForThisUser = docReceiptListForThisUser;
	}


	public void setCommoditiyFacade(commoditiyAppServiceImpl commoditiyFacade) {
		this.commoditiyFacade = commoditiyFacade;
	}


	public List<commoditiy> getListOfCommodities() {
		return listOfCommodities;
	}


	public void setListOfCommodities(List<commoditiy> listOfCommodities) {
		this.listOfCommodities = listOfCommodities;
	}


	public Integer getUsppiIdUsedForSelector() {
		return usppiIdUsedForSelector;
	}


	public void setUsppiIdUsedForSelector(Integer usppiIdUsedForSelector) {
		this.usppiIdUsedForSelector = usppiIdUsedForSelector;
	}


	public Integer getUlConsigneeIdUsedForSelector() {
		return ulConsigneeIdUsedForSelector;
	}


	public void setUlConsigneeIdUsedForSelector(Integer ulConsigneeIdUsedForSelector) {
		this.ulConsigneeIdUsedForSelector = ulConsigneeIdUsedForSelector;
	}


	public Integer getInterConsigneeIdUsedForSelector() {
		return interConsigneeIdUsedForSelector;
	}


	public void setInterConsigneeIdUsedForSelector(Integer interConsigneeIdUsedForSelector) {
		this.interConsigneeIdUsedForSelector = interConsigneeIdUsedForSelector;
	}


	public Integer getFrightForwardedIdUsedForSelector() {
		return frightForwardedIdUsedForSelector;
	}


	public void setFrightForwardedIdUsedForSelector(Integer frightForwardedIdUsedForSelector) {
		this.frightForwardedIdUsedForSelector = frightForwardedIdUsedForSelector;
	}


	public String getEdaString() {
		return edaString;
	}


	public void setEdaString(String edaString) {
		this.edaString = edaString;
	}





	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}





	public List<car> getCarsForthisAccountCustoms() {
		return carsForthisAccountCustoms;
	}


	public void setCarsForthisAccountCustoms(List<car> carsForthisAccountCustoms) {
		this.carsForthisAccountCustoms = carsForthisAccountCustoms;
	}


	public user getTheUserOfThisAccount() {
		return theUserOfThisAccount;
	}


	public void setTheUserOfThisAccount(user theUserOfThisAccount) {
		this.theUserOfThisAccount = theUserOfThisAccount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

public Map<Integer, String> getPorts() {
		return ports;
	}


	public void setPorts(Map<Integer, String> ports) {
		this.ports = ports;
	}





public Map<Integer, String> getModeTrans() {
		return modeTrans;
	}


	public void setModeTrans(Map<Integer, String> modeTrans) {
		this.modeTrans = modeTrans;
	}











public docrecieptAppServiceImpl getDocrecieptFacade() {
		return docrecieptFacade;
	}


	public void setDocrecieptFacade(docrecieptAppServiceImpl docrecieptFacade) {
		this.docrecieptFacade = docrecieptFacade;
	}


	public docreciept getSelectedDocReceipt() {
		return selectedDocReceipt;
	}


	public void setSelectedDocReceipt(docreciept selectedDocReceipt) {
		this.selectedDocReceipt = selectedDocReceipt;
	}


public carAppServiceImpl getCarFacade() {
		return carFacade;
	}


	public void setCarFacade(carAppServiceImpl carFacade) {
		this.carFacade = carFacade;
	}


	public Integer getSelectedCarIdToBeAddedInCommodities() {
		return selectedCarIdToBeAddedInCommodities;
	}


	public void setSelectedCarIdToBeAddedInCommodities(Integer selectedCarIdToBeAddedInCommodities) {
		this.selectedCarIdToBeAddedInCommodities = selectedCarIdToBeAddedInCommodities;
	}


public commoditiy getAddedNewCommoditiy() {
		return addedNewCommoditiy;
	}


	public void setAddedNewCommoditiy(commoditiy addedNewCommoditiy) {
		this.addedNewCommoditiy = addedNewCommoditiy;
	}



	public Integer getCustomSettingsId() {
		return customSettingsId;
	}


	public void setCustomSettingsId(Integer customSettingsId) {
		this.customSettingsId = customSettingsId;
	}


	public custom getSelectedCustomData() {
		return selectedCustomData;
	}


	public void setSelectedCustomData(custom selectedCustomData) {
		this.selectedCustomData = selectedCustomData;
	}


public List<custom> getCustomListForThisUser() {
		return customListForThisUser;
	}





	public void setCustomListForThisUser(List<custom> customListForThisUser) {
		this.customListForThisUser = customListForThisUser;
	}





	public customAppServiceImpl getCustomFacade() {
		return customFacade;
	}





	public void setCustomFacade(customAppServiceImpl customFacade) {
		this.customFacade = customFacade;
	}





public Map<Integer, String> getInbondTypes() {
		return inbondTypes;
	}





	public void setInbondTypes(Map<Integer, String> inbondTypes) {
		this.inbondTypes = inbondTypes;
	}





public consigneeAppServiceImpl getConsigneeFacade() {
		return consigneeFacade;
	}


	public void setConsigneeFacade(consigneeAppServiceImpl consigneeFacade) {
		this.consigneeFacade = consigneeFacade;
	}




	public List<consignee> getListOfConsignees() {
		return listOfConsignees;
	}


	public void setListOfConsignees(List<consignee> listOfConsignees) {
		this.listOfConsignees = listOfConsignees;
	}


public void fillPorts1() {
	ports.put(40901,"Aabenraa - Denmark");
	ports.put(40311,"Aagotnes - Norway");
	ports.put(40903,"Aalborg - Denmark");
	ports.put(40301,"Aalesund - Norway");
	ports.put(40300,"Aalvik - Norway");
	ports.put(40300,"Aandalsnes - Norway");
	ports.put(40302,"Aardal - Norway");
	ports.put(40302,"Aardalstangen - Norway");
	ports.put(40906,"Aarhus - Denmark");
	ports.put(23640,"Abaco-Snake Cay - Bahamas");
	ports.put(50700,"Abadan - Iran");
	ports.put(35198,"Abaetetuba - Brazil");
	ports.put(44911,"ABAKAN - RUSSIA");
	ports.put(58800,"Abashiri - Japan");
	ports.put(60200,"Abbot Point - Australia");
	ports.put(41650,"Aberdeen - United Kingdom");
	ports.put(3003,"ABERDEEN,HOQUIAM - United States");
	ports.put(74825,"Abidjan - Ivory Coast");
	ports.put(40587,"Abo - Finland");
	ports.put(75300,"Abonnema - Nigeria");
	ports.put(20100,"Abryos - Mexico");
	ports.put(52000,"Abu al Bu Koosh - United Arab Em");
	ports.put(52001,"Abu Dhabi - United Arab Em");
	ports.put(72905,"Abu Kir Bay - Egypt");
	ports.put(72905,"Abu Qir - Egypt");
	ports.put(52001,"Abu Zabi - United Arab Em");
	ports.put(72999,"Abu Zanimah - Egypt");
	ports.put(72999,"Abu Zenima - Egypt");
	ports.put(72905,"Abukir - Egypt");
	ports.put(21101,"Acajutla - El Salvador");
	ports.put(20101,"Acapulco - Mexico");
	ports.put(74901,"Accra - Ghana");
	ports.put(35700,"Acevedo - Argentina");
	ports.put(41253,"Acton Grange - United Kingdom");
	ports.put(51715,"Ad Dammam - Saudi Arabia");
	ports.put(72949,"Adabiya - Egypt");
	ports.put(48903,"Adalia - Turkey");
	ports.put(48938,"Adana - Turkey");
	ports.put(5584,"ADDISON USER FEE AIRPORT - United States");
	ports.put(60201,"Adelaide - Australia");
	ports.put(52101,"Aden - Yemen");
	ports.put(30700,"Adicora - Venezuela");
	ports.put(24871,"Admiralty Bay - St. Vincent");
	ports.put(5310,"Afganistan - Afganistan");
	ports.put(71403,"Agadir - Morocco");
	ports.put(47099,"Agua Amarga - Spain");
	ports.put(4901,"AGUADILLA - United States");
	ports.put(22389,"Aguadulce - Costa Rica");
	ports.put(22581,"Aguadulce - Panama");
	ports.put(47099,"Aguilas - Spain");
	ports.put(40122,"Ahus - Sweden");
	ports.put(50725,"Ahvaz - Iran");
	ports.put(50725,"Ahwaz - Iran");
	ports.put(58860,"Aia port - Japan");
	ports.put(48400,"Aigion - Greece");
	ports.put(72932,"Ain Sukhna - Egypt");
	ports.put(58823,"Aioi - Japan");
	ports.put(2773,"AIR CARGO HANDLING SERVICES, INC. - United States");
	ports.put(2871,"AIR CARGO HANDLING SERVICES,SAN FRANCISCO - United States");
	ports.put(4774,"AIR FRANCE - United States");
	ports.put(4181,"AIRBORNE AIR PARK, WILMINGTON - United States");
	ports.put(48400,"Aiyion - Greece");
	ports.put(42796,"Ajaccio - France");
	ports.put(52000,"Ajman - United Arab Em");
	ports.put(75300,"Akassa - Nigeria");
	ports.put(58832,"Akita Ko - Japan");
	ports.put(40038,"Akranes - Iceland");
	ports.put(4112,"AKRON - United States");
	ports.put(44911,"Aktau - Kazakhstan");
	ports.put(44911,"AKTOBE - KAZAKHSTAN");
	ports.put(40039,"Akureyri - Iceland");
	ports.put(50505,"Al Bakir - Iraq");
	ports.put(50525,"Al Basrah - Iraq");
	ports.put(50500,"Al Faw - Iraq");
	ports.put(51323,"Al Fuhayhil - Kuwait");
	ports.put(51723,"Al Juaymah - Saudi Arabia");
	ports.put(51720,"Al Jubail - Saudi Arabia");
	ports.put(51712,"Al Khobar - Saudi Arabia");
	ports.put(51712,"Al Khubar - Saudi Arabia");
	ports.put(51321,"Al Kuwayt - Kuwait");
	ports.put(50215,"Al Ladhiqiyah - Syria");
	ports.put(72300,"Al Mahdiyah - Tunisia");
	ports.put(52502,"Al Manamah Harbor - Bahrain");
	ports.put(52125,"Al Mokha - Yemen");
	ports.put(52100,"Al Mukalla - Yemen");
	ports.put(72999,"Al Quasayr - Egypt");
	ports.put(2813,"ALAMEDA - United States");
	ports.put(4810,"Albania - Albania");
	ports.put(60200,"Albany - Australia");
	ports.put(1002,"ALBANY - United States");
	ports.put(47100,"Albufeira - Portugal");
	ports.put(2407,"ALBURQUERQUE - United States");
	ports.put(3104,"ALCAN - United States");
	ports.put(47051,"Alcanar - Spain");
	ports.put(47099,"Alcudia - Spain");
	ports.put(46239,"Aleksandrovski - Russia");
	ports.put(35198,"Alenquer - Brazil");
	ports.put(12203,"Alert Bay, BC - Canada");
	ports.put(48931,"Alexandretta - Turkey");
	ports.put(72901,"Alexandria - Egypt");
	ports.put(5402,"ALEXANDRIA - United States");
	ports.put(708,"ALEXANDRIA BAY - United States");
	ports.put(48400,"Alexandroupolis - Greece");
	ports.put(46239,"Alexandrovsk - Russia");
	ports.put(47031,"Algeciras - Spain");
	ports.put(72101,"Alger - Algeria");
	ports.put(7210,"Algeria - Algeria");
	ports.put(72101,"Algiers - Algeria");
	ports.put(8525,"Algoma, ONT - Canada");
	ports.put(3814,"ALGONAC - United States");
	ports.put(48900,"Aliaga - Turkey");
	ports.put(48915,"Aliaga - Turkey");
	ports.put(47057,"Alicante - Spain");
	ports.put(4777,"ALITALIA - United States");
	ports.put(48449,"Aliver - Greece");
	ports.put(48449,"Aliveri - Greece");
	ports.put(62227,"All Caroline Islands Ports - Kiribati");
	ports.put(30198,"All Colombia Amazon Region Ports - Colombia");
	ports.put(78900,"All Comoros Ports - Comoros");
	ports.put(42796,"All Corsica Ports - France");
	ports.put(37200,"All Falkland Islands Ports - Falk Is");
	ports.put(40985,"All Faroe Islands Ports - Faroe");
	ports.put(79060,"All French Southern and Antartic Lands - French So and Art");
	ports.put(62215,"All Gilbert Islands Ports - Kiribati");
	ports.put(76489,"All Guinea-Bissau Ports - Guinea Bissau");
	ports.put(68190,"All Marshall Island Ports - Marshall Is");
	ports.put(56064,"All Moluccas Ports - Indonesia");
	ports.put(48100,"All Other Albania Ports - Albania");
	ports.put(72100,"All Other Algeria Ports - Algeria");
	ports.put(76299,"All Other Angola Ports - Angola");
	ports.put(35700,"All Other Argentina Ports - Argentina");
	ports.put(60200,"All Other Australia Ports - Australia");
	ports.put(47150,"All Other Azores Ports - Portugal");
	ports.put(23600,"All Other Bahamas Ports - Bahamas");
	ports.put(52500,"All Other Bahrain Ports - Bahrain");
	ports.put(53800,"All Other Bangladesh Ports - Bangladesh");
	ports.put(42300,"All Other Belgium Ports - Belgium");
	ports.put(76100,"All Other Benin ports - Benin");
	ports.put(23299,"All Other Bermuda Ports - Bermuda");
	ports.put(35198,"All Other Brazil Ports North of Recife - Brazil");
	ports.put(35199,"All Other Brazil Ports South of Recife - Brazil");
	ports.put(78100,"All Other British Indian Ocean Territory - Brit Ind Ocean");
	ports.put(56100,"All Other Brunei Ports - Brunei");
	ports.put(54600,"All Other Burma Ports - Burma");
	ports.put(24300,"All Other Caicos Islands - Turks Is");
	ports.put(74299,"All Other Cameroon Ports - Cameroon");
	ports.put(13400,"All Other Canada Atlantic Region Ports - Canada");
	ports.put(9000,"All Other Canada Great Lakes Region Ports - Canada");
	ports.put(12200,"All Other Canada Pacific Region Ports - Canada");
	ports.put(47070,"All Other Canary Islands Ports - Spain");
	ports.put(76499,"All Other Cape Verde Ports - Cape Verde");
	ports.put(24400,"All Other Cayman Island Ports - Cayman Isl");
	ports.put(33700,"All Other Chile Ports - Chile");
	ports.put(58300,"All Other China (Taiwan) Ports - China Taiwan");
	ports.put(30199,"All Other Colombia West Coast Region Ports - Colombia");
	ports.put(30100,"All Other Colombian Caribbean Region Ports - Colombia");
	ports.put(76300,"All Other Congo(Brazzaville) Ports - Congo Brazzaville");
	ports.put(76600,"All Other Congo(Kinshasha) Ports - Congo Kinshasha");
	ports.put(22300,"All Other Costa Rica Caribbean Region Ports - Costa Rica");
	ports.put(22399,"All Other Costa Rica West Coast Region Ports - Costa Rica");
	ports.put(47998,"All Other Croatia Ports - Croatia");
	ports.put(23900,"All Other Cuba Ports - Cuba");
	ports.put(49199,"All Other Cyprus Ports - Cyprus");
	ports.put(40900,"All Other Denmark Ports - Denmark");
	ports.put(24700,"All Other Dominican Republic Ports - Dominican Republic");
	ports.put(33100,"All Other Ecuador Ports - Ecuador");
	ports.put(72900,"All Other Egypt Mediterranean Region Ports - Egypt");
	ports.put(72999,"All Other Egypt Red Sea Region Ports - Egypt");
	ports.put(21199,"All Other El Salvador Ports - El Salvador");
	ports.put(41398,"All Other England South and East Coast Ports - United Kingdom");
	ports.put(41299,"All Other England West Coast Ports - United Kingdom");
	ports.put(73800,"All Other Equatorial Guinea Ports - Equatorial Gui");
	ports.put(77419,"All Other Eritrea Ports - Eritrea");
	ports.put(44700,"All Other Estonia Ports - Estonia");
	ports.put(68630,"All Other Fiji Islands Ports - Fiji");
	ports.put(40500,"All Other Finland Ports - Finland");
	ports.put(42700,"All Other France Atlantic Region Ports - France");
	ports.put(42799,"All Other France Mediterranean Region Ports - France");
	ports.put(31700,"All Other French Guiana Ports - French Guiana");
	ports.put(75500,"All Other Gabon Ports - Gabon");
	ports.put(75099,"All Other Gambia Ports - Gambia");
	ports.put(46357,"All Other Georgia Ports - Georgia");
	ports.put(42899,"All Other Germany Atlantic Region Ports - Germany");
	ports.put(42800,"All Other Germany Baltic Region Ports - Germany");
	ports.put(74900,"All Other Ghana Ports - Ghana");
	ports.put(48400,"All Other Greece Ports - Greece");
	ports.put(10100,"All Other Greenland - Greenland");
	ports.put(28300,"All Other Guadeloupe Ports - Guadeloupe");
	ports.put(20500,"All Other Guatemala Caribbean Region Ports - Guatemala");
	ports.put(20599,"All Other Guatemala West Coast Region Ports - Guatemala");
	ports.put(74699,"All Other Guinea Ports - Guinea");
	ports.put(31200,"All Other Guyana Ports - Guyana");
	ports.put(24500,"All Other Haiti Ports - Haiti");
	ports.put(21500,"All Other Honduras Caribbean Region Ports - Honduras");
	ports.put(21599,"All Other Honduras West Coast Region Ports - Honduras");
	ports.put(40000,"All Other Iceland Ports - Iceland");
	ports.put(53398,"All Other India East Coast Ports - India");
	ports.put(53300,"All other India West Coast Ports - India");
	ports.put(56000,"All Other Indonesia Ports - Indonesia");
	ports.put(50700,"All Other Iran Ports - Iran");
	ports.put(50500,"All Other Iraq Ports - Iraq");
	ports.put(41900,"All Other Ireland Ports - Ireland");
	ports.put(50800,"All Other Israel Mediterranean Area Ports - Israel");
	ports.put(47598,"All Other Italy East Coast Ports - Italy");
	ports.put(47500,"All Other Italy West Coast Ports - Italy");
	ports.put(74899,"All Other Ivory Coast Ports - Ivory Coast");
	ports.put(24100,"All Other Jamaica Ports - Jamaica");
	ports.put(58800,"All Other Japan Ports - Japan");
	ports.put(56058,"All Other Java Ports - Indonesia");
	ports.put(51100,"All Other Jordan Ports - Jordan");
	ports.put(56020,"All Other Kalimantan Ports - Indonesia");
	ports.put(77999,"All Other Kenya Ports - Kenya");
	ports.put(51300,"All Other Kuwait Ports - Kuwait");
	ports.put(15298,"All Other Labrador Ports - Canada");
	ports.put(44900,"All Other Latvia Ports - Latvia");
	ports.put(50400,"All Other Lebanon Ports - Lebanon");
	ports.put(24800,"All Other Leeward Islands - Unknown");
	ports.put(76500,"All Other Liberia Ports - Liberia");
	ports.put(72500,"All Other Libya Ports - Libya");
	ports.put(45100,"All Other Lithuania Ports - Lithuania");
	ports.put(78800,"All Other Madagascar Ports - Madagascar");
	ports.put(55700,"All Other Malaysia Ports - Malaysia");
	ports.put(47300,"All Other Malta Ports - Malta");
	ports.put(28399,"All Other Martinique Ports - Martinique");
	ports.put(74100,"All Other Mauritania Ports - Mauritania");
	ports.put(78500,"All Other Mauritius Ports - Mauritius");
	ports.put(20195,"All Other Mexico East Coast Region Ports - Mexico");
	ports.put(20100,"All Other Mexico West Coast Region Ports - Mexico");
	ports.put(71400,"All Other Morocco Atlantic Region Ports - Morocco");
	ports.put(71499,"All Other Morocco Mediterranean Ports - Morocco");
	ports.put(78700,"All Other Mozambique Ports - Mozambique");
	ports.put(79299,"All Other Namibia Ports - Namibia");
	ports.put(27700,"All Other Netherlands Antilles Ports - Neth Antilles");
	ports.put(42100,"All Other Netherlands Ports - Netherlands");
	ports.put(64100,"All Other New Caledonia Ports - New Caledonia");
	ports.put(61400,"All Other New Zealand Ports - New Zealand");
	ports.put(15200,"All Other Newfoundland Ports - Canada");
	ports.put(21900,"All Other Nicaragua Caribbean Region Ports - Nicaragua");
	ports.put(21999,"All Other Nicaragua West Coast Region Ports - Nicaragua");
	ports.put(75300,"All Other Nigeria Ports - Nigeria");
	ports.put(57900,"All Other North Korea Ports - North Korea");
	ports.put(41800,"All Other Northern Ireland Ports - United Kingdom");
	ports.put(40300,"All Other Norway Ports - Norway");
	ports.put(52300,"All Other Oman Ports - Oman");
	ports.put(68699,"All Other Pacific Islands, N.E.C. Ports - Unknown");
	ports.put(53599,"All Other Pakistan Ports - Pakistan");
	ports.put(22500,"All Other Panama Caribbean Region Ports - Panama");
	ports.put(22599,"All Other Panama West Coast Region Ports - Panama");
	ports.put(60400,"All Other Papua New Guinea Ports - Papua New Guinea");
	ports.put(35300,"All Other Paraguay Ports - Paraguay");
	ports.put(57000,"All Other Peoples Republic of China Ports - China");
	ports.put(33300,"All Other Peru Ports - Peru");
	ports.put(56500,"All Other Philippines Ports - Philippines");
	ports.put(45500,"All Other Poland Ports - Poland");
	ports.put(48700,"All Other Ports in Bulgaria - Bulgaria");
	ports.put(47100,"All Other Portugal Ports - Portugal");
	ports.put(51800,"All Other Qatar Ports - Qatar");
	ports.put(79100,"All Other Republic of South Africa Ports - South Africa");
	ports.put(48500,"All Other Romania Ports - Romania");
	ports.put(46220,"All Other Russia Baltic Region Ports - Russia");
	ports.put(46250,"All Other Russia Black Sea Region Ports - Russia");
	ports.put(46239,"All Other Russia Eastern Region Ports - Russia");
	ports.put(46200,"All Other Russia Siberia Region Ports - Russia");
	ports.put(76495,"All Other Sao Tome and Principe Ports - Sao Tome and Princip");
	ports.put(47569,"All Other Sardinia Ports - Italy");
	ports.put(51700,"All Other Saudi Arabia Ports - Saudi Arabia");
	ports.put(41698,"All Other Scotland East Coast Ports - United Kingdom");
	ports.put(41600,"All Other Scotland West Coast Ports - United Kingdom");
	ports.put(74499,"All Other Senegal Ports - Senegal");
	ports.put(78000,"All Other Seychelles Ports - Seychelles");
	ports.put(47558,"All Other Sicily Ports - Italy");
	ports.put(74799,"All Other Sierra Leone Ports - Sierra Leone");
	ports.put(55900,"All Other Singapore Ports - Singapore");
	ports.put(47999,"All Other Slovenia Ports - Slovenia");
	ports.put(64178,"All Other Society Islands Ports - French Polyn");
	ports.put(77099,"All Other Somalia Eastern Region Ports - Somalia");
	ports.put(77000,"All Other Somalia Northern Region Ports - Somalia");
	ports.put(58000,"All Other South Korea Ports - South Korea");
	ports.put(56899,"All Other Southern Asia, N.E.C. Ports - Unknown");
	ports.put(62299,"All Other Southern Pacific Islands - Unknown");
	ports.put(47000,"All Other Spain Atlantic Region Ports North of Por - Spain");
	ports.put(47049,"All Other Spain Atlantic Region Ports Southeast of B- Spain");
	ports.put(47099,"All Other Spain Mediterranean Region Ports - Spain");
	ports.put(47095,"All other Spanish Africa N.E.C. Ports - Spain");
	ports.put(54200,"All Other Sri Lanka Ports - Sri Lanka");
	ports.put(91149,"All Other St. Croix Virgin Islands - US Virgin Is");
	ports.put(56030,"All Other Sulawesi Ports - Indonesia");
	ports.put(56099,"All Other Sumatra Ports - Indonesia");
	ports.put(31500,"All Other Suriname Ports - Suriname");
	ports.put(40100,"All Other Sweden Ports - Sweden");
	ports.put(50200,"All Other Syria Ports - Syria");
	ports.put(78399,"All Other Tanzania Ports - Tanzania");
	ports.put(60299,"All Other Tasmania Ports - Australia");
	ports.put(54900,"All Other Thailand Ports - Thailand");
	ports.put(75200,"All Other Togo Ports - Togo");
	ports.put(27400,"All Other Trinidad Ports - Trinidad");
	ports.put(72300,"All Other Tunisia Ports - Tunisia");
	}

public void fillPorts2() {

	ports.put(48999,"All Other Turkey Black Sea and Sea of Marmara Port - Turkey");
	ports.put(48900,"All Other Turkey Mediterranean Region Ports - Turkey");
	ports.put(24399,"All Other Turks Islands Ports - Turks Is");
	ports.put(46279,"All Other Ukraine Ports - Ukraine");
	ports.put(52000,"All Other United Arab Emirates Ports - United Arab Em");
	ports.put(35500,"All Other Uruguay Ports - Uruguay");
	ports.put(30700,"All Other Venezuela Ports - Venezuela");
	ports.put(55200,"All Other Viet Nam Ports - Vietnam");
	ports.put(91195,"All Other Virgin Islands Ports - US Virgin Is");
	ports.put(41400,"All Other Wales Ports - United Kingdom");
	ports.put(56025,"All Other West New Guinea Ports - Indonesia");
	ports.put(73700,"All Other Western Sahara Ports - Western Sahara");
	ports.put(61500,"All Other Western Samoa Ports - Samoa");
	ports.put(24899,"All Other Windward Island Ports - Unknown");
	ports.put(52100,"All Other Yemen Ports - Yemen");
	ports.put(55500,"All Ports in Cambodia - Cambodia");
	ports.put(62200,"All Solomon Islands Ports - Solomon Is");
	ports.put(75899,"All St. Helena Ports - St. Helena");
	ports.put(68682,"All Tonga Islands Ports - Tonga");
	ports.put(98000,"All United States Outlying Islands - US Outlying Is");
	ports.put(64131,"All Wallis and Futuna Ports - Wallis");
	ports.put(1181,"ALLENTOWN,BETHLEHEM,EASTON AIRPORT - United States");
	ports.put(53301,"Alleppey - India");
	ports.put(24165,"Alligator Pond - Jamaica");
	ports.put(56019,"Alluth Kalimantan - Indonesia");
	ports.put(40549,"ALMATY - Kazakhstan");
	ports.put(44911,"Almaty - Kazakhstan");
	ports.put(5700,"Almaty - KAZAKHSTAN");
	ports.put(44911,"Almaty - KZ");
	ports.put(45101,"ALMATY one - Kazakhstan");
	ports.put(47059,"Almeria - Spain");
	ports.put(22501,"Almirante - Panama");
	ports.put(61481,"Alofi - Niue");
	ports.put(60432,"Alotau - Papua New Guinea");
	ports.put(3843,"ALPENA - United States");
	ports.put(17005,"Alpharetta - United States");
	ports.put(42103,"Alphen aan den Rijn - Netherlands");
	ports.put(30700,"Altagracia - Venezuela");
	ports.put(20193,"Altamira - Mexico");
	ports.put(20100,"Altata - Mexico");
	ports.put(42899,"Altona - Germany");
	ports.put(20195,"Alvarado - Mexico");
	ports.put(20153,"Alvaro Obregon - Mexico");
	ports.put(40300,"Alvik - Norway");
	ports.put(58813,"Amagasaki - Japan");
	ports.put(60433,"Amamapare - Papua New Guinea");
	ports.put(21551,"Amapala - Honduras");
	ports.put(5502,"AMARILLO - United States");
	ports.put(35198,"Amarracao - Brazil");
	ports.put(46239,"Ambarchik - Russia");
	ports.put(48945,"Ambarli - Turkey");
	ports.put(42703,"Ambes - France");
	ports.put(56064,"Ambon - Indonesia");
	ports.put(76299,"Ambriz - Angola");
	ports.put(3410,"AMBROSE - United States");
	ports.put(9510,"American Samoa - American Samoa");
	ports.put(1703,"AMERICUS,  - United States");
	ports.put(3504,"Amherstburg, ONT - Canada");
	ports.put(57069,"Amoy - China");
	ports.put(56041,"Ampenan - Indonesia");
	ports.put(42105,"Amsterdam - Netherlands");
	ports.put(30704,"Amuay Bay - Venezuela");
	ports.put(3010,"ANACORTES - United States");
	ports.put(46239,"Anadyr - Russia");
	ports.put(3126,"ANCHORAGE - United States");
	ports.put(33301,"Ancon - Peru");
	ports.put(47571,"Ancona - Italy");
	ports.put(33700,"Ancud - Chile");
	ports.put(40300,"Andalsnes - Norway");
	ports.put(4271,"Andorra - Andorra");
	ports.put(2502,"ANDRADE - United States");
	ports.put(24700,"Andres - Dominican Republic");
	ports.put(23672,"Andros Island - Bahamas");
	ports.put(60276,"Androssan - Australia");
	ports.put(75200,"Anecho - Togo");
	ports.put(60431,"Anewa Bay - Papua New Guinea");
	ports.put(7620,"Angola - Angola");
	ports.put(47150,"Angra do Heroismo - Portugal");
	ports.put(35107,"Angra dos Reis - Brazil");
	ports.put(2481,"Anguilla - Anguilla");
	ports.put(24821,"Anguilla - Anguilla");
	ports.put(72123,"Annaba - Algeria");
	ports.put(1301,"ANNAPOLIS - United States");
	ports.put(24100,"Annotto Bay - Jamaica");
	ports.put(24500,"Anse du Clerc - Haiti");
	ports.put(24500,"Anse-DHainault - Haiti");
	ports.put(78800,"Antalaha - Madagascar");
	ports.put(48903,"Antalya - Turkey");
	ports.put(75315,"Antan Terminal - Nigeria");
	ports.put(2484,"Antigua and Barbuda - Antigua and Barbuda");
	ports.put(23900,"Antilla - Cuba");
	ports.put(3413,"ANTLER - United States");
	ports.put(33703,"Antofagasta - Chile");
	ports.put(35159,"Antonina - Brazil");
	ports.put(78800,"Antsirana - Madagascar");
	ports.put(78800,"Antsiranana - Madagascar");
	ports.put(42305,"Antwerp - Belgium");
	ports.put(42305,"Anvers - Belgium");
	ports.put(47500,"Anzio - Italy");
	ports.put(54902,"Ao Phuket - Thailand");
	ports.put(58844,"Aomori - Japan");
	ports.put(75313,"Apapa - Nigeria");
	ports.put(61501,"Apia - Samoa");
	ports.put(51105,"Aqaba - Jordan");
	ports.put(24500,"Aquin - Haiti");
	ports.put(35199,"Aracaju - Brazil");
	ports.put(35198,"Aracati - Brazil");
	ports.put(56500,"Aras-Asan - Philippines");
	ports.put(35115,"Aratu - Brazil");
	ports.put(23630,"Arawak Cay - Bahamas");
	ports.put(42700,"Arcachon - France");
	ports.put(46200,"Archangel - Russia");
	ports.put(22599,"Archipel. de Las Perlas - Panama");
	ports.put(40302,"Ardal - Norway");
	ports.put(41600,"Ardrossan - United Kingdom");
	ports.put(35198,"Areia Branca - Brazil");
	ports.put(40300,"Arendal - Norway");
	ports.put(15213,"Argentia, NFLD - Canada");
	ports.put(3570,"Argentina - Argentina");
	ports.put(48400,"Argostolion - Greece");
	ports.put(47070,"Arguinequin - Spain");
	ports.put(33706,"Arica - Chile");
	ports.put(56040,"Arjuna Terminal - Indonesia");
	ports.put(46200,"Arkhangelsk - Russia");
	ports.put(41916,"Arklow - Ireland");
	ports.put(46239,"Arkovo Bereg - Russia");
	ports.put(21902,"Arlen Siu - Nicaragua");
	ports.put(4631,"Armenia - Armenia");
	ports.put(22587,"Armuelles - Panama");
	ports.put(40100,"Arnoviken - Sweden");
	ports.put(47070,"Arrecife - Spain");
	ports.put(56064,"Aru Bay - Indonesia");
	ports.put(2779,"Aruba - Aruba");
	ports.put(52003,"Arzanah Island - United Arab Em");
	ports.put(72105,"Arzew - Algeria");
	ports.put(72105,"Arziw - Algeria");
	ports.put(72519,"As Sidr - Libya");
	ports.put(72315,"As Sukhayrah - Tunisia");
	ports.put(50810,"Ascalon - Israel");
	ports.put(77405,"Aseb - Eritrea");
	ports.put(52070,"Ash Shariqah - United Arab Em");
	ports.put(51350,"Ash Shuaiba - Kuwait");
	ports.put(50805,"Ashdod - Israel");
	ports.put(44911,"Ashgabad - Turkmenistan");
	ports.put(50810,"Ashkelon - Israel");
	ports.put(3602,"ASHLAND - United States");
	ports.put(4108,"ASHTABULA - United States");
	ports.put(72300,"Ashtart Terminal - Tunisia");
	ports.put(40940,"Asnaes - Denmark");
	ports.put(40940,"Asnaesvaerkets Havn - Denmark");
	ports.put(48453,"Aspropirgos - Greece");
	ports.put(48453,"Aspropyrgos - Greece");
	ports.put(77405,"Assab - Eritrea");
	ports.put(40900,"Assens - Denmark");
	ports.put(44911,"Astana - Kazakhstan");
	ports.put(5700,"ASTANA - KAZAKHSTAN");
	ports.put(2901,"ASTORIA - United States");
	ports.put(35301,"Asuncion - Paraguay");
	ports.put(48903,"Atalia - Turkey");
	ports.put(33300,"Atico - Peru");
	ports.put(1704,"ATLANTA - United States");
	ports.put(58800,"Atsumi - Japan");
	ports.put(56006,"Attaka - Indonesia");
	ports.put(48903,"Attalea - Turkey");
	ports.put(61401,"Auckland - New Zealand");
	ports.put(41906,"Aughinish - Ireland");
	ports.put(47542,"Augusta - Italy");
	ports.put(13846,"Aulds Cove, NS - Canada");
	ports.put(5506,"AUSTIN - United States");
	ports.put(6021,"Australia - Australia");
	ports.put(4330,"Austria - Austria");
	ports.put(24509,"Aux Cayes - Haiti");
	ports.put(61461,"Avatiu - New Zealand");
	ports.put(47130,"Aveiro - Portugal");
	ports.put(47003,"Aviles - Spain");
	ports.put(2012,"AVONDALE - United States");
	ports.put(41201,"Avonmouth - United Kingdom");
	ports.put(74900,"Axim - Ghana");
	ports.put(48402,"Ayia Marina - Greece");
	ports.put(48454,"Ayia Trias - Greece");
	ports.put(48405,"Ayios Nikolaos - Greece");
	ports.put(41600,"Ayr - United Kingdom");
	ports.put(4632,"Azerbaijan - Azerbaijan");
	ports.put(24700,"Azua - Dominican Republic");
	ports.put(56500,"Bacalod - Philippines");
	ports.put(30700,"Bachaquero - Venezuela");
	ports.put(13400,"Back Bay, NB - Canada");
	ports.put(13855,"Baddeck, CBI - Canada");
	ports.put(15298,"Baffin Island, NL - Canada");
	ports.put(50501,"Baghdad - Iraq");
	ports.put(47505,"Bagnoli - Italy");
	ports.put(35710,"Bagual - Argentina");
	ports.put(2360,"Bahamas - Bahamas");
	ports.put(35701,"Bahia Blanca - Argentina");
	ports.put(30704,"Bahia de Amuay - Venezuela");
	ports.put(33101,"Bahia de Caraquez - Ecuador");
	ports.put(33300,"Bahia de Eten - Peru");
	ports.put(24731,"Bahia de Las Calderas - Dominican Republic");
	ports.put(22565,"Bahia de Las Minas - Panama");
	ports.put(22315,"Bahia de Moin - Costa Rica");
	ports.put(23900,"Bahia de Nuevitas - Cuba");
	ports.put(20100,"Bahia de Todos Santos - Mexico");
	ports.put(30741,"Bahia Guanta - Venezuela");
	ports.put(23900,"Bahia Honda - Cuba");
	ports.put(23900,"Bahia Sama - Cuba");
	ports.put(20100,"Bahia Tortugas - Mexico");
	ports.put(20100,"Bahias Ballenas - Mexico");
	ports.put(5250,"Bahrain - Bahrain");
	ports.put(13481,"Baie Comeau, QUE - Canada");
	ports.put(64100,"Baie de Kouaoua - New Caledonia");
	ports.put(64100,"Baie de Poro - New Caledonia");
	ports.put(28399,"Baie du Galion - Martinique");
	ports.put(64100,"Baie Ugue - New Caledonia");
	ports.put(56503,"Bais - Philippines");
	ports.put(53351,"Baj-Baj - India");
	ports.put(30708,"Bajo Grande - Venezuela");
	ports.put(47923,"Bakar - Croatia");
	ports.put(46337,"Baku - Azerbaijan");
	ports.put(33109,"Balao - Ecuador");
	ports.put(33109,"Balao Terminal - Ecuador");
	ports.put(42799,"Balaruc - France");
	ports.put(42799,"Balaruc les Bains - France");
	ports.put(22575,"Balboa - Panama");
	ports.put(56007,"Balikpapan - Indonesia");
	ports.put(40300,"Ballangen - Norway");
	ports.put(20100,"Ballenas Bay - Mexico");
	ports.put(56042,"Balongan Terminal - Indonesia");
	ports.put(1303,"BALTIMORE - United States");
	ports.put(1305,"BALTIMORE WASHINGTON AIRPORT - United States");
	ports.put(54902,"Ban Tha Rua - Thailand");
	ports.put(76600,"Banana - Congo Kinshasha");
	ports.put(50730,"Bandar Abbas - Iran");
	ports.put(50700,"Bandar E Lengeh - Iran");
	ports.put(50739,"Bandar E Mah Shahr - Iran");
	ports.put(50770,"Bandar Khomeini - Iran");
	ports.put(50739,"Bandar Mahshahr - Iran");
	ports.put(50700,"Bandar Shadid Beheshti - Iran");
	ports.put(50730,"Bandar Shahid Rejaie - Iran");
	ports.put(50739,"Bandar-e-Mashur - Iran");
	ports.put(50700,"Bandar-e-Shahpur - Iran");
	ports.put(40900,"Bandholm - Denmark");
	ports.put(48963,"Bandirma - Turkey");
	ports.put(23900,"Banes - Cuba");
	ports.put(54901,"Bangkok - Thailand");
	ports.put(5380,"Bangladesh - Bangladesh");
	ports.put(41802,"Bangor - United Kingdom");
	ports.put(102,"BANGOR - United States");
	ports.put(50200,"Banias - Syria");
	ports.put(50200,"Baniyas - Syria");
	ports.put(56013,"Banjarmasin - Indonesia");
	ports.put(56013,"Banjer Masin - Indonesia");
	ports.put(75041,"Banjul - Gambia");
	ports.put(56058,"Banjuwangi - Indonesia");
	ports.put(56058,"Banyuwangi - Indonesia");
	ports.put(72301,"Banzart - Tunisia");
	ports.put(47901,"BAR - MONTENEGRO");
	ports.put(47901,"Bar - Serbia");
	ports.put(112,"BAR HARBOR - United States");
	ports.put(23900,"Baracoa - Cuba");
	ports.put(24713,"Barahona - Dominican Republic");
	ports.put(31230,"Barama - Guyana");
	ports.put(31230,"Baramanni - Guyana");
	ports.put(35159,"Barao de Teffe - Brazil");
	ports.put(2720,"Barbados - Barbados");
	ports.put(27703,"Barcadera - Aruba");
	ports.put(35121,"Barcarena - Brazil");
	ports.put(47061,"Barcelona - Spain");
	ports.put(47578,"Bari - Italy");
	ports.put(47579,"Barletta - Italy");
	ports.put(44911,"BARNAUL - Russia");
	ports.put(30104,"Barranquilla - Colombia");
	ports.put(47126,"Barreiro - Portugal");
	ports.put(41401,"Barri - United Kingdom");
	ports.put(35199,"Barro do Riacho - Brazil");
	ports.put(41299,"Barrow in Furness - United Kingdom");
	ports.put(41401,"Barry - United Kingdom");
	ports.put(41398,"Barton - United Kingdom");
	ports.put(42157,"BASEL - SWITZERLAND");
	ports.put(42870,"Basel - Switzerland");
	ports.put(50525,"Basra - Iraq");
	ports.put(50525,"Basrah - Iraq");
	ports.put(28315,"Basse Terre - Guadeloupe");
	ports.put(42701,"Bassens - France");
	ports.put(24835,"Basseterre, St. Kitts - St. Kitts Nevis");
	ports.put(42796,"Bastia - France");
	ports.put(57003,"Basuo - China");
	ports.put(73800,"Bata - Equatorial Gui");
	ports.put(56507,"Bataan - Philippines");
	ports.put(56506,"Batangas - Philippines");
	ports.put(111,"BATH - United States");
	ports.put(1653,"Bath, ONT - Canada");
	ports.put(75041,"Bathurst - Gambia");
	ports.put(13458,"Bathurst, NB - Canada");
	ports.put(3805,"BATLE CREEK - United States");
	ports.put(2004,"BATON ROUGE - United States");
	ports.put(46320,"BATUMI - GEORGIA");
	ports.put(46321,"BATUMI - GEORGIA");
	ports.put(46321,"Batumi - Georgia");
	ports.put(46321,"Batumiyskava Bukhta - Georgia");
	ports.put(56504,"Bauan - Philippines");
	ports.put(3424,"BAUDETTE - United States");
	ports.put(15205,"Bay Roberts, NFLD - Canada");
	ports.put(42702,"Bayonne - France");
	ports.put(33300,"Bayovar - Peru");
	ports.put(50401,"Bayrut - Lebanon");
	ports.put(13459,"Bayside, NB - Canada");
	ports.put(12215,"Beale Cove, BC - Canada");
	ports.put(1511,"BEAUFORT-MOREHEAD CITY - United States");
	ports.put(1806,"Beauharnoi, QUE - Canada");
	ports.put(2104,"BEAUMONT - United States");
	ports.put(60299,"Beauty Point - Australia");
	ports.put(13435,"Beaver Harbour, NB - Canada");
	ports.put(41211,"Bebington - United Kingdom");
	ports.put(42703,"Bec Dambes - France");
	ports.put(13441,"Becancour, QUE - Canada");
	ports.put(53305,"Bedi - India");
	ports.put(206,"BEECHER FALLS - United States");
	ports.put(57076,"Bei Hai - China");
	ports.put(57016,"Bei Jao - China");
	ports.put(57076,"Beihai - China");
	ports.put(57005,"Beilun - China");
	ports.put(78701,"Beira - Mozambique");
	ports.put(50401,"Beirut - Lebanon");
	ports.put(72107,"Bejaia - Algeria");
	ports.put(4622,"Belarus - Belarus");
	ports.put(56073,"Belawan - Indonesia");
	ports.put(35121,"Belem - Brazil");
	ports.put(41801,"Belfast - United Kingdom");
	ports.put(132,"BELFAST - United States");
	ports.put(4231,"Belgium - Belgium");
	ports.put(47909,"BELGRADE - SERBIA");
	ports.put(47923,"BELGRADE - SERBIA");
	ports.put(46277,"Belgrod-Dnestrovskiy - Ukraine");
	ports.put(56001,"Beliling - Indonesia");
	ports.put(56099,"Belinju - Indonesia");
	ports.put(56099,"Belinyu - Indonesia");
	ports.put(2080,"Belize - Belize");
	ports.put(20801,"Belize - Belize");
	ports.put(60290,"Bell Bay - Australia");
	ports.put(12216,"Bella Coola, BC - Canada");
	ports.put(13442,"Belledune, NB - Canada");
	ports.put(3005,"BELLINGHAM - United States");
	ports.put(41400,"Bellport - United Kingdom");
	ports.put(72501,"Benghazi - Libya");
	ports.put(56079,"Bengkulu - Indonesia");
	ports.put(76299,"Benguela - Angola");
	ports.put(72123,"Beni Saf - Algeria");
	ports.put(7610,"Benin - Benin");
	ports.put(56002,"Benoa - Indonesia");
	ports.put(77001,"Berbera - Somalia");
	ports.put(46278,"Berdyansk - Ukraine");
	ports.put(40311,"Bergen - Norway");
	ports.put(2320,"Bermuda - Bermuda");
	ports.put(42773,"Berre - France");
	ports.put(41359,"Berwick - United Kingdom");
	ports.put(41359,"Berwick upon Tweed - United Kingdom");
	ports.put(72105,"Bethioua - Algeria");
	ports.put(62215,"Betio - Kiribati");
	ports.put(53396,"Beypore - India");
	ports.put(50401,"Beyrouth - Lebanon");
	ports.put(53303,"Bhavnagar - India");
	ports.put(53398,"Bheemunipatnam - India");
	ports.put(54902,"Bhuket - Thailand");
	ports.put(5682,"Bhutan - Bhutan");
	ports.put(41299,"Bideford - United Kingdom");
	ports.put(20802,"Big Creek - Belize");
	ports.put(47005,"Bilbao - Spain");
	ports.put(56074,"Bima - Indonesia");
	ports.put(56074,"Bima Terminal - Indonesia");
	ports.put(23683,"Bimini Island - Bahamas");
	ports.put(55732,"Bintulu - Malaysia");
	ports.put(41207,"Birkenhead - United Kingdom");
	ports.put(1904,"BIRMINGHAM - United States");
	ports.put(1111,"BISHKEK - KIRGIZISTAN");
	ports.put(44911,"BISHKEK - KYRGYZSTAN");
	ports.put(45101,"BISHKEK - Kyrgyzstan");
	ports.put(45101,"BISHKEK - KYRGYZSTAN");
	ports.put(57047,"Bishkek - Kyrgyzstan");
	ports.put(56508,"Bislig - Philippines");
	ports.put(76489,"Bissau - Guinea Bissau");
	ports.put(56028,"Bitung - Indonesia");
	ports.put(72301,"Bizerta - Tunisia");
	ports.put(72301,"Bizerte - Tunisia");
	ports.put(40562,"Bjorneborg - Finland");
	ports.put(24100,"Black River - Jamaica");
	ports.put(13450,"Blacks Harbor, NB - Canada");
	ports.put(3004,"BLAINE - United States");
	ports.put(56099,"Blang Lancang - Indonesia");
	ports.put(42705,"Blaye - France");
	ports.put(42899,"Blexen - Germany");
	ports.put(13400,"Bliss Harbor, NB - Canada");
	ports.put(4101,"Bloomingto - United States");
	ports.put(12214,"Blubber Bay, BC - Canada");
	ports.put(24100,"Bluefields - Jamaica");
	ports.put(21901,"Bluefields - Nicaragua");
	ports.put(4184,"BLUEGRASS AIRPORT,LEXINGTON - United States");
	ports.put(61403,"Bluff Harbor - New Zealand");
	ports.put(42899,"Blumenthal - Germany");
	ports.put(41398,"Blyth - United Kingdom");
	ports.put(35198,"Boa Vista - Brazil");
	ports.put(30700,"Bobures - Venezuela");
	ports.put(24721,"Boca Chica - Dominican Republic");
	ports.put(1807,"BOCA GRANDE - United States");
	ports.put(13829,"Boca Sec, NB - Canada");
	ports.put(22500,"Bocas del Toro - Panama");
	ports.put(40369,"Bodo - Norway");
	ports.put(40337,"Bogen - Norway");
	ports.put(40337,"Bogen Bay - Norway");
	ports.put(40900,"Bogense - Denmark");
	ports.put(56500,"Bogo - Philippines");
	ports.put(2907,"BOISE - United States");
	ports.put(3350,"Bolivia - Bolivia");
	ports.put(40100,"Bollsta - Sweden");
	ports.put(76638,"Boma - Congo Kinshasha");
	ports.put(53312,"Bombay - India");
	ports.put(72123,"Bona - Algeria");
	ports.put(74201,"Bonaberi - Cameroon");
	ports.put(15200,"Bonavista, NFLD - Canada");
	ports.put(72123,"Bone - Algeria");
	ports.put(58800,"Bonin Islands - Japan");
	ports.put(75322,"Bonny - Nigeria");
	ports.put(56077,"Bontang - Indonesia");
	ports.put(56077,"Bontang Bay - Indonesia");
	ports.put(74799,"Bonthe - Sierra Leone");
	ports.put(23941,"Boqueron - Cuba");
	ports.put(64178,"Bora Bora - French Polyn");
	ports.put(42707,"Bordeaux - France");
	ports.put(40334,"Borg Hbr. - Norway");
	ports.put(56020,"Borneo - Indonesia");
	ports.put(40900,"Bornholm - Denmark");
	ports.put(64178,"Boro Boro - French Polyn");
	ports.put(4793,"Bosnia-Hercegovina - Bosnia-Hercegovina");
	ports.put(41398,"Boston - United Kingdom");
	ports.put(401,"BOSTON - United States");
	ports.put(60205,"Botany Bay - Australia");
	ports.put(48931,"Botas Terminal - Turkey");
	ports.put(42115,"Botlek - Netherlands");
	ports.put(7930,"Botswana - Botswana");
	ports.put(15214,"Botwood, NFLD - Canada");
	ports.put(42735,"Boucau - France");
	ports.put(42708,"Boulogne - France");
	ports.put(3015,"BOUNDARY - United States");
	ports.put(48702,"Bourgas - Bulgaria");
	ports.put(60200,"Bowen - Australia");
	ports.put(41600,"Bowling - United Kingdom");
	ports.put(9665,"Bowmanville, ONT - Canada");
	ports.put(41684,"Braefoot Bay - United Kingdom");
	ports.put(48500,"Braila - Romania");
	ports.put(42867,"Brake - Germany");
	ports.put(75320,"Brass - Nigeria");
	ports.put(75320,"Brass Terminal - Nigeria");
	ports.put(3510,"Brazil - Brazil");
	ports.put(42869,"Bremen - Germany");
	ports.put(42870,"Bremerhaven - Germany");
	ports.put(45101,"Brest - BELARUS");
	ports.put(42709,"Brest - France");
	ports.put(35123,"Breves - Brazil");
	ports.put(40313,"Brevik - Norway");
	ports.put(9000,"Bridgeburg, ONT - Canada");
	ports.put(410,"BRIDGEPORT - United States");
	ports.put(27201,"Bridgetown - Barbados");
	ports.put(13400,"Bridgetown, NS - Canada");
	ports.put(127,"BRIDGEWATER - United States");
	ports.put(13850,"Bridgewater, NS - Canada");
	ports.put(27400,"Brighton - Trinidad");
	ports.put(5301,"BRIGHTON,  - United States");
	ports.put(47583,"Brindisi - Italy");
	ports.put(60210,"Brisbane - Australia");
	ports.put(41211,"Bristol - United Kingdom");
	ports.put(7810,"British Indian Ocean Terr - British Indian Ocean Terr");
	ports.put(2482,"British Virgin Islands - British Virgin Islands");
	ports.put(1528,"Britt, ONT - Canada");
	ports.put(41398,"Brixham - United Kingdom");
	ports.put(1694,"Brockville, ONT - Canada");
	ports.put(40100,"Brofjorden - Sweden");
	ports.put(31500,"Brokopondo - Suriname");
	ports.put(41214,"Bromsborough - United Kingdom");
	ports.put(1001,"BROOKLYN - United States");
	ports.put(60200,"Broome - Australia");
	ports.put(23600,"Browns Cays - Bahamas");
	ports.put(2301,"BROWNSVILLE-CAMERON COUNTY - United States");
	ports.put(8526,"Bruce Mines, ONT - Canada");
	ports.put(42311,"Bruges - Belgium");
	ports.put(42311,"Brugge - Belgium");
	ports.put(22599,"Bruja Point - Panama");
	ports.put(5610,"Brunei - Brunei");
	ports.put(42871,"Brunsbuttel - Germany");
	ports.put(1701,"BRUNSWICK - United States");
	ports.put(42315,"Brussels - Belgium");
	ports.put(42315,"Bruxelles - Belgium");
	ports.put(56514,"Buayan - Philippines");
	ports.put(76505,"Buchanan - Liberia");
	ports.put(58860,"Buckner Bay - Japan");
	ports.put(42870,"BUDAPEST - HUNGARY");
	ports.put(53351,"Budge-Budge - India");
	ports.put(30151,"Buenaventura - Colombia");
	ports.put(35705,"Buenos Aires - Argentina");
	ports.put(901,"BUFFALO-NIAGARA FALLS - United States");
	ports.put(46250,"Bukhta Severnaya - Russia");
	ports.put(58014,"Bukpyung - South Korea");
	ports.put(56500,"Bulan - Philippines");
	ports.put(56001,"Buleleng - Indonesia");
	ports.put(4870,"Bulgaria - Bulgaria");
	ports.put(15201,"Bull Arm, NFLD - Canada");
	ports.put(27725,"Bullen Baai - Neth Antilles");
	ports.put(27725,"Bullen Bay - Neth Antilles");
	ports.put(60213,"Bunbury - Australia");
	ports.put(60214,"Bundaberg - Australia");
	ports.put(72913,"Bur Said - Egypt");
	ports.put(40100,"Burea - Sweden");
	ports.put(48702,"Burgas - Bulgaria");
	ports.put(15200,"Burgeo, NFLD - Canada");
	ports.put(7600,"Burkina - Burkina");
	ports.put(1601,"BURLINGTON - United States");
	ports.put(4192,"BURLINGTON AIR EXPRESS, CONSIGNMENT FACILITY, TOLEDO - United States");
	ports.put(5460,"Burma (Myanmar) - Burma (Myanmar)");
	ports.put(12495,"Burnaby, BC - Canada");
	ports.put(60291,"Burnie - Australia");
	ports.put(41698,"Burntisland - United Kingdom");
	ports.put(7670,"Burundi - Burundi");
	ports.put(75300,"Burutu - Nigeria");
	ports.put(58023,"Busan - South Korea");
	ports.put(50700,"Bushehr - Iran");
	ports.put(50700,"Bushire - Iran");
	ports.put(62215,"Butaritari - Kiribati");
	ports.put(12200,"Butedale, BC - Canada");
	ports.put(3305,"BUTTE - United States");
	ports.put(55705,"Butterworth - Malaysia");
	ports.put(56513,"Butuan - Philippines");
	ports.put(42880,"Butzfleth - Germany");
	ports.put(56500,"Cabadbaran - Philippines");
	ports.put(23900,"Cabanas - Cuba");
	ports.put(35127,"Cabedelo - Brazil");
	ports.put(30700,"Cabimas - Venezuela");
	ports.put(76231,"Cabinda - Angola");
	ports.put(23900,"Cabo Cruz - Cuba");
	ports.put(21900,"Cabo Gracias a Dios - Nicaragua");
	ports.put(24727,"Cabo Rojo - Dominican Republic");
	ports.put(20144,"Cabo San Lucas - Mexico");
	ports.put(13410,"Cacouna, QUE - Canada");
	ports.put(56500,"Cadiz - Philippines");
	ports.put(47035,"Cadiz - Spain");
	ports.put(42711,"Caen - France");
	ports.put(56514,"Cagayan de Oro - Philippines");
	ports.put(47563,"Cagliari - Italy");
	ports.put(55200,"CAI MEP - VIETNAM");
	ports.put(23900,"Caibarien - Cuba");
	ports.put(23941,"Caimanera - Cuba");
	ports.put(60200,"Cairns - Australia");
	ports.put(75330,"Calabar - Nigeria");
	ports.put(42713,"Calais - France");
	ports.put(115,"CALAIS - United States");
	ports.put(48421,"Calamata - Greece");
	ports.put(56500,"Calapan - Philippines");
	ports.put(53353,"Calcutta - India");
	ports.put(33708,"Caldera - Chile");
	ports.put(22361,"Caldera - Costa Rica");
	ports.put(24731,"Caldera Bay - Dominican Republic");
	ports.put(33716,"Caleta Barquito - Chile");
	ports.put(33700,"Caleta Buena - Chile");
	ports.put(35703,"Caleta Cordova - Argentina");
	ports.put(35703,"Caleta Olivares - Argentina");
	ports.put(35703,"Caleta Olivia - Argentina");
	ports.put(33765,"Caleta Patillos - Chile");
	ports.put(2503,"CALEXICO - United States");
	ports.put(2507,"CALEXICO-EAST - United States");
	ports.put(20161,"Calica - Mexico");
	ports.put(53300,"Calicut - India");
	ports.put(33303,"Callao - Peru");
	ports.put(55205,"Cam Pha - Vietnam");
	ports.put(55207,"Cam Rahn Bay - Vietnam");
	ports.put(55207,"Cam Ranh Bay - Vietnam");
	ports.put(5550,"Cambodia - Cambodia");
	ports.put(1302,"CAMBRIDGE - United States");
	ports.put(1107,"CAMDEN - United States");
	ports.put(7420,"Cameroon - Cameroon");
	ports.put(35198,"Camocim - Brazil");
	ports.put(35711,"Campana - Argentina");
	ports.put(12207,"Campbell River, BC - Canada");
	ports.put(13444,"Campbellton, NB - Canada");
	ports.put(20155,"Campeche - Mexico");
	ports.put(13445,"Campobello, NB - Canada");
	ports.put(1220,"Canada - Canada");
	ports.put(48999,"Canak - Turkey");
	ports.put(48999,"Canakkale - Turkey");
	ports.put(20162,"Cancun - Mexico");
	ports.put(48400,"Canea - Greece");
	ports.put(42775,"Cannes - France");
	ports.put(47541,"Canneto - Italy");
	ports.put(41398,"Canvey - United Kingdom");
	ports.put(41398,"Canvey Island - United Kingdom");
	ports.put(74298,"Cap  Limboh - Cameroon");
	ports.put(78800,"Cap Diego - Madagascar");
	ports.put(24513,"Cap Haitien - Haiti");
	ports.put(74298,"Cap Limboah - Cameroon");
	ports.put(75505,"Cap Lopez - Gabon");
	ports.put(12213,"Cape Beale, BC - Canada");
	ports.put(74900,"Cape Coast - Ghana");
	ports.put(23900,"Cape Cruz - Cuba");
	ports.put(47000,"Cape Finisterre - Spain");
	ports.put(75505,"Cape Lopez - Gabon");
	ports.put(76500,"Cape Palmas - Liberia");
	ports.put(79101,"Cape Town - South Africa");
	ports.put(7643,"Cape Verde - Cape Verde");
	ports.put(706,"CAPE VINCENT - United States");
	ports.put(42100,"Capelle - Netherlands");
	ports.put(42100,"Capelle aan den Ijssel - Netherlands");
	ports.put(2715,"CAPITAN - United States");
	ports.put(30745,"Caracas - Venezuela");
	ports.put(27725,"Caracas Baai - Neth Antilles");
	ports.put(27725,"Caracas Bay - Neth Antilles");
	ports.put(15206,"Carbonear, NFLD - Canada");
	ports.put(47062,"Carboneras - Spain");
	ports.put(3421,"CARBURY - United States");
	ports.put(23900,"Cardenas - Cuba");
	ports.put(41487,"Cardiff - United Kingdom");
	ports.put(1705,"Cardinal, ONT - Canada");
	ports.put(30772,"Caripito - Venezuela");
	ports.put(40100,"Carlskrona - Sweden");
	ports.put(20157,"Carmen - Mexico");
	ports.put(42784,"Caronte - France");
	ports.put(2830,"CARQUINEZ STRAIT - United States");
	ports.put(33700,"Carrizal Bajo - Chile");
	ports.put(30107,"Cartagena - Colombia");
	ports.put(47063,"Cartagena - Spain");
	ports.put(1001,"Carteret - United States");
	ports.put(30721,"Carupano - Venezuela");
	ports.put(71401,"Casablanca - Morocco");
	ports.put(23900,"Casilda - Cuba");
	ports.put(33300,"Casma - Peru");
	ports.put(56500,"Castanas - Philippines");
	ports.put(23684,"Castaway Cay - Bahamas");
	ports.put(47558,"Castellamare del Golfo - Italy");
	ports.put(47500,"Castellammare di Stabia - Italy");
	ports.put(47068,"Castellon - Spain");
	ports.put(47068,"Castellon de la Plana - Spain");
	ports.put(41900,"Castletown - Ireland");
	ports.put(24865,"Castries - St. Lucia");
	ports.put(23620,"Cat Cay - Bahamas");
	ports.put(23660,"Cat Island - Bahamas");
	ports.put(56500,"Catabangan - Philippines");
	ports.put(48400,"Catacolon - Greece");
	ports.put(47548,"Catania - Italy");
	ports.put(56500,"Catanuan - Philippines");
	ports.put(24722,"Caucedo - Dominican Republic");
	ports.put(48427,"Cavala - Greece");
	ports.put(31700,"Cayenne - French Guiana");
	ports.put(24415,"Cayman Brac - Cayman Isl");
	ports.put(2440,"Cayman Islands - Cayman Islands");
	ports.put(20152,"Cayo Arcas - Mexico");
	ports.put(20152,"Cayo Arcos Terminal - Mexico");
	ports.put(23900,"Cayo Santa Maria - Cuba");
	ports.put(2641,"Cayuga, ONT - Canada");
	ports.put(35133,"Ceara - Brazil");
	ports.put(56520,"Cebu - Philippines");
	ports.put(23900,"Ceiba Hueca - Cuba");
	ports.put(7540,"Central African Republic - Central African Republic");
	ports.put(20100,"Cerralvo Island - Mexico");
	ports.put(33300,"Cerro Azul - Peru");
	ports.put(20104,"Cerros Island - Mexico");
	ports.put(47096,"Ceuta - Spain");
	ports.put(48931,"Ceyhan Terminal - Turkey");
	ports.put(33700,"Chacabuco - Chile");
	ports.put(7560,"Chad - Chad");
	ports.put(27400,"Chaguaramas - Trinidad");
	ports.put(50700,"Chah Bahar - Iran");
	ports.put(33300,"Chala - Peru");
	ports.put(48400,"Chalkis - Greece");
	ports.put(53820,"Chalna - Bangladesh");
	ports.put(20599,"Champerico - Guatemala");
	ports.put(712,"CHAMPLAIN-ROUSES POINT - United States");
	ports.put(20195,"Champoton - Mexico");
	ports.put(48999,"Chanak - Turkey");
	ports.put(48999,"Chanaq - Turkey");
	ports.put(33716,"Chanaral - Chile");
	ports.put(33300,"Chancay - Peru");
	ports.put(13445,"Chance Harbor, NB - Canada");
	ports.put(13466,"Chandler, QUE - Canada");
	ports.put(57000,"Chang Sha - China");
	ports.put(58000,"Changhang - South Korea");
	ports.put(23900,"Chaparra - Cuba");
	ports.put(22587,"Charco Azul - Panama");
	ports.put(1409,"CHARLESTON - United States");
	ports.put(24837,"Charlestown, Nevis Is. - St. Kitts Nevis");
	ports.put(1512,"CHARLOTTE - United States");
	ports.put(91155,"Charlotte Amalie, St. Th - US Virgin Is");
	ports.put(5101,"CHARLOTTE AMALIE,VIRGIN ISLANDS - United States");
	ports.put(14471,"Charlottetown, PEI - Canada");
	ports.put(41398,"Chatham - United Kingdom");
	ports.put(13460,"Chatham, NB - Canada");
	ports.put(2008,"CHATTANOOGA - United States");
	ports.put(57055,"Chefoo - China");
	ports.put(58000,"Cheju - South Korea");
	ports.put(44911,"Chelyabinsk - RUSSIA");
	ports.put(45101,"Chelyabinsk - RUSSIA");
	ports.put(12229,"Chemainus, BC - Canada");
	ports.put(57000,"Chen Chiang - China");
	ports.put(58015,"Chen Hai - South Korea");
	ports.put(57009,"Chen Huang Tao - China");
	ports.put(57000,"Cheng Ling Chi - China");
	ports.put(57000,"Chenglin - China");
	ports.put(57000,"Chenglingji - China");
	ports.put(53357,"Chennai - India");
	ports.put(42715,"Cherbourg - France");
	ports.put(72100,"Cherchell - Algeria");
	ports.put(56035,"Cheribon - Indonesia");
	ports.put(46279,"Chernomorsk - Ukraine");
	ports.put(23640,"Cherokee Sound - Bahamas");
	ports.put(1102,"CHESTER - United States");
	ports.put(20174,"Chetumal - Mexico");
	ports.put(58301,"Chi Lung - China Taiwan");
	ports.put(58818,"Chiba - Japan");
	ports.put(58818,"Chibako - Japan");
	ports.put(3901,"CHICAGO - United States");
	ports.put(33300,"Chicama - Peru");
	ports.put(30700,"Chichiriviche - Venezuela");
	ports.put(33300,"Chiclayo - Peru");
	ports.put(13473,"Chicoutimi, QUE - Canada");
	ports.put(33300,"Chilca - Peru");
	ports.put(3370,"Chile - Chile");
	ports.put(58301,"Chilung - China Taiwan");
	ports.put(22599,"Chiman - Panama");
	ports.put(33300,"Chimbote - Peru");
	ports.put(44911,"CHIMKENT - KAZ");
	ports.put(45101,"Chimkent - KAZAKHSTAN");
	ports.put(57047,"Chimkent - KAZAKHSTAN");
	ports.put(57009,"Chin Wang Tao - China");
	ports.put(57009,"Chin Wangtao - China");
	ports.put(5700,"China - China");
	ports.put(33300,"Chincha Islands - Peru");
	ports.put(78700,"Chinde - Mozambique");
	ports.put(57000,"Ching Kiang - China");
	ports.put(57047,"Ching Tao - China");
	ports.put(58015,"Chinhae - South Korea");
	ports.put(57000,"Chinkiang - China");
	ports.put(57900,"Chinnanpo - North Korea");
	ports.put(47581,"Chioggia - Italy");
	ports.put(48455,"Chios - Greece");
	ports.put(22520,"Chiriqui Grande Terminal - Panama");
	ports.put(77099,"Chisimaio - Somalia");
	ports.put(53827,"Chittagong - Bangladesh");
	ports.put(57067,"Chiwan - China");
	ports.put(61405,"Christchurch - New Zealand");
	ports.put(91115,"Christiansted, St. Croix - US Virgin Is");
	ports.put(5104,"CHRISTIANSTED,VIRGIN ISLANDS - United States");
	ports.put(6024,"Christmas Island - Christmas Island");
	ports.put(62225,"Christmas Island - Kiribati");
	ports.put(23641,"Chub Cay - Bahamas");
	ports.put(54900,"Chuk Samet - Thailand");
	ports.put(14001,"Churchill, MAN - Canada");
	ports.put(68205,"Chuuk - Micronesia");
	ports.put(23900,"Cienfuegos - Cuba");
	ports.put(56056,"Cigading - Indonesia");
	ports.put(56036,"Cilacap - Indonesia");
	ports.put(47000,"Cillero - Spain");
	ports.put(4102,"CINCINNATI-LAWRENCEBURG - United States");
	ports.put(56037,"Cinta Terminal - Indonesia");
	ports.put(56035,"Cirebon - Indonesia");
	ports.put(30725,"Ciudad Bolivar - Venezuela");
	ports.put(20195,"Ciudad Camargo - Mexico");
	ports.put(20195,"Ciudad Chetumal - Mexico");
	ports.put(20157,"Ciudad de Carmen - Mexico");
	ports.put(24737,"Ciudad Trujillo - Dominican Republic");
	ports.put(47519,"Civitavecchia - Italy");
	ports.put(75898,"Clarence Bay, Ascension Is - St. Helena");
	ports.put(60281,"Clarence River - Australia");
	ports.put(23635,"Clarence Town - Bahamas");
	ports.put(15224,"Clarenville, NFLD - Canada");
	ports.put(20100,"Clarion Island - Mexico");
	ports.put(13476,"Clarke City, QUE - Canada");
	ports.put(13451,"Clarke Harbour, NS - Canada");
	ports.put(13451,"Clarkes Harbour, NS - Canada");
	ports.put(1527,"Clarkson, ONT - Canada");
	ports.put(56500,"Claveria - Philippines");
	ports.put(714,"CLAYTON - United States");
	ports.put(4101,"CLEVELAND - United States");
	ports.put(23675,"Clifton Pier - Bahamas");
	ports.put(23675,"Clifton Point - Bahamas");
	ports.put(64195,"Clipperton Island - French Polyn");
	ports.put(41615,"Clyde - United Kingdom");
	ports.put(20171,"Coatzacoalcos - Mexico");
	ports.put(41905,"Cobh - Ireland");
	ports.put(53398,"Cocanada - India");
	ports.put(53333,"Cochin - India");
	ports.put(24310,"Cockburn harbor - Turks Is");
	ports.put(23640,"Coco Cay - Bahamas");
	ports.put(22399,"Coco Islands - Costa Rica");
	ports.put(22517,"Coco Solo - Panama");
	ports.put(6023,"Cocos (Keeling) Island - Cocos (Keeling) Island");
	ports.put(73800,"Cogo - Equatorial Gui");
	ports.put(15226,"Coleys Point, NFLD - Canada");
	ports.put(72100,"Collo - Algeria");
	ports.put(3010,"Colombia - Colombia");
	ports.put(54201,"Colombo - Sri Lanka");
	ports.put(54201,"Colombo Harbor - Sri Lanka");
	ports.put(22519,"Colon - Panama");
	ports.put(30700,"Coloncha - Venezuela");
	ports.put(35500,"Colonia - Uruguay");
	ports.put(22301,"Colorado Bar - Costa Rica");
	ports.put(1604,"COLUMBIA - United States");
	ports.put(2406,"COLUMBUS - United States");
	ports.put(13481,"Comeau Bay, QUE - Canada");
	ports.put(15229,"Come-by-Chance, NFLD - Canada");
	ports.put(47300,"Comino Island - Malta");
	ports.put(35702,"Comodoro Rivadavia - Argentina");
	ports.put(7890,"Comoros - Comoros");
	ports.put(74619,"Conakri - Guinea");
	ports.put(74619,"Conakry - Guinea");
	ports.put(35700,"Concepcion del Uruguay - Argentina");
	ports.put(15220,"Conception Bay, NFLD - Canada");
	ports.put(33305,"Conchan - Peru");
	ports.put(7630,"Congo (Brazzaville) - Congo (Brazzaville)");
	ports.put(7660,"Congo (Kinshasa) - Congo (Kinshasa)");
	ports.put(4109,"CONNEAUT - United States");
	ports.put(48511,"Constanta - Romania");
	ports.put(48945,"Constantinople - Turkey");
	ports.put(48511,"Constantza - Romania");
	ports.put(48500,"CONSTANZA - ROMANIA");
	ports.put(13482,"Contrecoeur, QUE - Canada");
	ports.put(6142,"Cook Islands - Cook Islands");
	ports.put(2903,"COOS BAY - United States");
	ports.put(40948,"Copenhagen - Denmark");
	ports.put(33721,"Coquimbo - Chile");
	ports.put(5103,"CORAL BAY,VIRGIN ISLANDS - United States");
	ports.put(47000,"Corcubion - Spain");
	ports.put(48456,"Corfu - Greece");
	ports.put(48410,"Corinth - Greece");
	ports.put(21951,"Corinto - Nicaragua");
	ports.put(41905,"Cork - Ireland");
	ports.put(21900,"Corn Islands - Nicaragua");
	ports.put(15231,"Corner Brook, NFLD - Canada");
	ports.put(1784,"Cornwall, ONT - Canada");
	ports.put(30765,"Coro - Venezuela");
	ports.put(56500,"Coron - Philippines");
	ports.put(33700,"Coronel - Chile");
	ports.put(5312,"CORPUS CHRISTI - United States");
	ports.put(33700,"Corral - Chile");
	ports.put(42796,"Corsica - France");
	ports.put(47021,"Corunna - Spain");
	ports.put(5517,"Corunna, ONT - Canada");
	ports.put(41352,"Coryton - United Kingdom");
	ports.put(20100,"Costa Maya - Mexico");
	ports.put(2230,"Costa Rica - Costa Rica");
	ports.put(56500,"Cotabato - Philippines");
	ports.put(76101,"Cotonou - Benin");
	ports.put(4191,"COURIER HUB AIRBORNE EXPRESS,WILMINGTON - United States");
	ports.put(5515,"Courtright, ONT - Canada");
	ports.put(30110,"Covenas - Colombia");
	ports.put(12231,"Cowichan Bay, BC - Canada");
	ports.put(20173,"Cozumel Island - Mexico");
	ports.put(3429,"CRANE LAKE - United States");
	ports.put(1304,"CRISFIELD - United States");
	ports.put(22518,"Cristobal - Panama");
	ports.put(4791,"Croatia - Croatia");
	ports.put(2815,"CROCKETT - United States");
	ports.put(12234,"Crofton, BC - Canada");
	ports.put(47582,"Crotone - Italy");
	ports.put(91160,"Cruz Bay, St. John I. - US Virgin Is");
	ports.put(5102,"CRUZ BAY,VIRGIN ISLANDS - United States");
	ports.put(33700,"Cruz Grande - Chile");
	ports.put(2390,"Cuba - Cuba");
	ports.put(53398,"Cuddalore - India");
	ports.put(76299,"Cuio - Angola");
	ports.put(24866,"Cul de Sac - St. Lucia");
	ports.put(20100,"Culiacan - Mexico");
	ports.put(30769,"Cumana - Venezuela");
	ports.put(30766,"Cumarebo - Venezuela");
	ports.put(21137,"Cutuco - El Salvador");
	ports.put(42873,"Cuxhaven - Germany");
	ports.put(4910,"Cyprus - Cyprus");
	ports.put(4351,"Czech Republic - Czech Republic");
	ports.put(55204,"Da Nang - Vietnam");
	ports.put(56099,"Dabo - Indonesia");
	ports.put(56522,"Dadiangas - Philippines");
	ports.put(58030,"Daesan - South Korea");
	ports.put(41320,"Dagenham - United Kingdom");
	ports.put(57017,"Dagu,Tanggu - China");
	ports.put(56500,"Dahican - Philippines");
	ports.put(56500,"Dahikan - Philippines");
	ports.put(56500,"Dahikan Bay - Philippines");
	ports.put(23931,"Daiquiri Bay - Cuba");
	ports.put(57051,"Dairen - China");
	ports.put(74473,"Dakar - Senegal");
	ports.put(73700,"Dakhla - Western Sahara");
	ports.put(13484,"Dalhousie, NB - Canada");
	ports.put(57051,"Dalian - China");
	ports.put(57051,"Dalian - China");
	ports.put(5501,"DALLAS,FT. WORTH - United States");
	ports.put(60212,"Dalrymple Bay - Australia");
	ports.put(3106,"DALTON CACHE - United States");
	ports.put(24500,"Dame Marie - Haiti");
	ports.put(72912,"DAMIETTA - EGYPT");
	ports.put(72912,"Damietta - Egypt");
	ports.put(51715,"Damman - Saudi Arabia");
	ports.put(60218,"Dampier - Australia");
	ports.put(20803,"Dangriga - Belize");
	ports.put(3012,"DANVILLE - United States");
	ports.put(45511,"Danzig - Poland");
	ports.put(78351,"Dar es Salaam - Tanzania");
	ports.put(48941,"Darcia - Turkey");
	ports.put(48941,"Darica - Turkey");
	ports.put(22599,"Darien - Panama");
	ports.put(41398,"Dartmouth - United Kingdom");
	ports.put(13485,"Dartmouth, NS - Canada");
	ports.put(60220,"Darwin - Australia");
	ports.put(52030,"Das - United Arab Em");
	ports.put(52030,"Das Island - United Arab Em");
	ports.put(56523,"Davao - Philippines");
	ports.put(3908,"DAVENPORT,IA-ROCK ISLAND,MOLINE - United States");
	ports.put(22599,"David - Panama");
	ports.put(502,"DAVISVILLE - United States");
	ports.put(4104,"DAYTON - United States");
	ports.put(1884,"DAYTONA BEACH AIRPORT - United States");
	ports.put(13400,"Deadmans Harbour, NB - Canada");
	ports.put(42700,"Deauville - France");
	ports.put(48400,"Dedeh Agatch - Greece");
	ports.put(13475,"Deer Island, NB - Canada");
	ports.put(75300,"Degema - Nigeria");
	ports.put(31707,"Degrad des Cannes - French Guiana");
	ports.put(3322,"DEL BONITA - United States");
	ports.put(2302,"DEL RIO - United States");
	ports.put(42116,"Delfzijl - Netherlands");
	ports.put(42116,"Delfzyl - Netherlands");
	ports.put(72100,"Dellys - Algeria");
	ports.put(12496,"Delta BC - Canada");
	ports.put(31201,"Demerara - Guyana");
	ports.put(42100,"Den Helder - Netherlands");
	ports.put(47099,"Denia - Spain");
	ports.put(4099,"Denmark - Denmark");
	ports.put(3307,"DENVER - United States");
	ports.put(6695,"Depot Harbor, ONT - Canada");
	ports.put(209,"DERBY LINE - United States");
	ports.put(48942,"Derince - Turkey");
	ports.put(48942,"Derince Burnu - Turkey");
	ports.put(48942,"Derindje - Turkey");
	ports.put(3907,"DES MOINES - United States");
	ports.put(23941,"Deseo - Cuba");
	ports.put(2009,"DESTREHAN - United States");
	ports.put(3819,"DETOUR - United States");
	ports.put(3801,"DETROIT - United States");
	ports.put(3807,"DETROIT METROPOLITAN AIRPORT - United States");
	ports.put(60299,"Devonport - Australia");
	ports.put(41398,"Devonport - United Kingdom");
	ports.put(51717,"Dhahran - Saudi Arabia");
	ports.put(4194,"DHL EXPRESS IN WILMINGTON - United States");
	ports.put(3073,"DHL WORLDWIDE EXPRESS - United States");
	ports.put(4772,"DHL,JAMAICA - United States");
	ports.put(2770,"DHL,LOS ANGELES - United States");
	ports.put(5271,"DHL,MIAMI FL - United States");
	ports.put(2870,"DHL,SAN FRANCISCO - United States");
	ports.put(51730,"Dhuba - Saudi Arabia");
	ports.put(35700,"Diamante - Argentina");
	ports.put(78101,"Diego Garcia - Brit Ind Ocean");
	ports.put(78800,"Diego Suarez - Madagascar");
	ports.put(42736,"Dieppe - France");
	ports.put(13420,"Digby, NS - Canada");
	ports.put(48905,"Dikili - Turkey");
	ports.put(41900,"Dingle - Ireland");
	ports.put(56500,"Dipolog - Philippines");
	ports.put(13400,"Dipper Harbor, NB - Canada");
	ports.put(56033,"Djakarta - Indonesia");
	ports.put(56078,"Djambi - Indonesia");
	ports.put(76345,"Djeno Terminal - Congo Brazzaville");
	ports.put(7770,"Djibouti - Djibouti");
	ports.put(77701,"Djibouti - Djibouti");
	ports.put(72100,"Djidjelli - Algeria");
	ports.put(40000,"Djupivogur - Iceland");
	ports.put(46277,"Dnestrovskiy - Ukraine");
	ports.put(51813,"Doha - Qatar");
	ports.put(2486,"Dominica - Dominica");
	ports.put(2470,"Dominican Republic - Dominican Republic");
	ports.put(40100,"Domjou - Sweden");
	ports.put(40100,"Domsjo - Sweden");
	ports.put(42723,"Donges - France");
	ports.put(57003,"Dongfeng - China");
	ports.put(57056,"Dongguan - China");
	ports.put(58014,"Donghae - South Korea");
	ports.put(13493,"Donnacona, QUE - Canada");
	ports.put(56500,"Donsol - Philippines");
	ports.put(42117,"Dordrecht - Netherlands");
	ports.put(20154,"Dos Bocas - Mexico");
	ports.put(74201,"Douala - Cameroon");
	ports.put(2601,"DOUGLAS - United States");
	ports.put(41337,"Dover - United Kingdom");
	ports.put(40321,"Drammen - Norway");
	ports.put(47558,"Drepanon - Italy");
	ports.put(41919,"Drogheda - Ireland");
	ports.put(52005,"Dubai - United Arab Em");
	ports.put(52005,"Dubayy - United Arab Em");
	ports.put(41911,"Dublin - Ireland");
	ports.put(47902,"Dubrovnik - Croatia");
	ports.put(42700,"Duclair - France");
	ports.put(47906,"Dugi Rat - Croatia");
	ports.put(3601,"DULUTH - United States");
	ports.put(56525,"Dumaguete - Philippines");
	ports.put(56075,"Dumai - Indonesia");
	ports.put(41600,"Dumbarton - United Kingdom");
	ports.put(12246,"Duncan Bay, BC - Canada");
	ports.put(23636,"Duncan Town - Bahamas");
	ports.put(41921,"Dundalk - Ireland");
	ports.put(12200,"Dundas Island, BC - Canada");
	ports.put(41659,"Dundee - United Kingdom");
	ports.put(61407,"Dunedin - New Zealand");
	ports.put(42727,"Dunkerque - France");
	ports.put(42727,"Dunkirk - France");
	ports.put(2645,"Dunnville, ONT - Canada");
	ports.put(3422,"DUNSEITH - United States");
	ports.put(33131,"Duran - Ecuador");
	ports.put(48109,"Durazzo - Albania");
	ports.put(79113,"Durban - South Africa");
	ports.put(1503,"DURHAM - United States");
	ports.put(48109,"Durres - Albania");
	ports.put(44911,"Dushanbe - Tajikistan");
	ports.put(4775,"DWORKIN,COSELL COURIER - United States");
	ports.put(40100,"Dynas - Sweden");
	ports.put(78900,"Dzaoudzi, Mayotte Is - Comoros");
	ports.put(3385,"EAGLE COUNTY USER FEE AIRPORT - United States");
	ports.put(2303,"EAGLE PASS - United States");
	ports.put(15223,"Earls Island, NLFD - Canada");
	ports.put(79125,"East London - South Africa");
	ports.put(5601,"East Timor - East Timor");
	ports.put(72947,"East Zeit Terminal - Egypt");
	ports.put(33700,"Easter Island - Chile");
	ports.put(41216,"Eastham - United Kingdom");
	ports.put(3302,"EASTPORT - United States");
	ports.put(68190,"Ebeye - Marshall Is");
	ports.put(58800,"Ebisu - Japan");
	ports.put(3310,"Ecuador - Ecuador");
	ports.put(41675,"Edinburg - United Kingdom");
	ports.put(2381,"EDINBURG USER FEE AIRPORT, EDINBURG - United States");
	ports.put(41675,"Edinburgh - United Kingdom");
	ports.put(42132,"Eemshaven - Netherlands");
	ports.put(40325,"Egersund - Norway");
	ports.put(7290,"Egypt - Egypt");
	ports.put(50871,"Eilat - Israel");
	ports.put(50871,"Eilath - Israel");
	ports.put(42874,"Einswarden - Germany");
	ports.put(40549,"Ekaterinburg - Russia");
	ports.put(72906,"El Alamein - Egypt");
	ports.put(21901,"El Bluff - Nicaragua");
	ports.put(30735,"El Chaure - Venezuela");
	ports.put(20195,"El Cuyo - Mexico");
	ports.put(72901,"El Dekheila - Egypt");
	ports.put(72101,"El Djazair - Algeria");
	ports.put(47022,"El Ferrol - Spain");
	ports.put(47022,"El Ferrol del Caudillo - Spain");
	ports.put(47099,"El Grao - Spain");
	ports.put(30774,"El Guamache - Venezuela");
	ports.put(72906,"El Hamra Oil Terminal - Egypt");
	ports.put(72925,"El Ismailiya - Egypt");
	ports.put(71400,"El Jadida - Morocco");
	ports.put(71415,"El Jorf Lasfar - Morocco");
	ports.put(72500,"El Khoms - Libya");
	ports.put(30737,"El Palito - Venezuela");
	ports.put(2402,"EL PASO - United States");
	ports.put(72999,"El Qoseir - Egypt");
	ports.put(72999,"El Quseir - Egypt");
	ports.put(22599,"El Real - Panama");
	ports.put(2110,"El Salvador - El Salvador");
	ports.put(20142,"El Sauzal - Mexico");
	ports.put(2711,"EL SEGUNDO - United States");
	ports.put(30739,"El Tablazo - Venezuela");
	ports.put(50871,"Elat - Israel");
	ports.put(48445,"Elefsis - Greece");
	ports.put(48445,"Eleusis - Greece");
	ports.put(23619,"Eleuthera Island - Bahamas");
	ports.put(48445,"Elevsis - Greece");
	ports.put(12237,"Elk Falls, BC - Canada");
	ports.put(41227,"Ellesmere - United Kingdom");
	ports.put(74900,"Elmina - Ghana");
	ports.put(42868,"Elsfleth - Germany");
	ports.put(40900,"Elsinore - Denmark");
	ports.put(42875,"Emden - Germany");
	ports.put(4195,"EMERY WORLD WIDE COURIER,DAYTON - United States");
	ports.put(4773,"EMERY WORLDWIDE - United States");
	ports.put(68190,"Enewetak Atoll - Marshall Is");
	ports.put(68190,"Enewotok - Marshall Is");
	ports.put(15207,"Englee Harbor, NFLD - Canada");
	ports.put(1803,"ENGLEWOOD - United States");
	ports.put(62223,"English Harbor - Kiribati");
	ports.put(20108,"Ensenada - Mexico");
	ports.put(23900,"Ensenada Santa Maria - Cuba");
	ports.put(23900,"Ensenda de Mora - Cuba");
	ports.put(40908,"Enstead - Denmark");
	ports.put(40908,"Ensteadvaerket - Denmark");
	ports.put(40908,"Ensted - Denmark");
	ports.put(40908,"Enstedvaerkets Havn - Denmark");
	ports.put(68190,"Entwetak - Marshall Is");
	ports.put(7380,"Equatorial Guinea - Equatorial Guinea");
	ports.put(48943,"Eregli - Turkey");
	ports.put(48943,"Eregli Anatolia - Turkey");
	ports.put(4106,"ERIE - United States");
	ports.put(41231,"Erith - United Kingdom");
	ports.put(7741,"Eritrea - Eritrea");
	ports.put(42300,"Ertvelde - Belgium");
	ports.put(72519,"Es Sider - Libya");
	ports.put(40919,"Esbjerg - Denmark");
	ports.put(47063,"Escombreras - Spain");
	ports.put(75345,"Escravos - Nigeria");
	ports.put(75345,"Escravos Oil Terminal - Nigeria");
	ports.put(40000,"Eskifjordhur - Iceland");
	ports.put(40000,"Eskifjordur - Iceland");
	ports.put(33121,"Esmeraldas - Ecuador");
	ports.put(60282,"Esperance - Australia");
	ports.put(20100,"Espiritu Santo - Mexico");
	ports.put(12200,"Esquimalt, BC - Canada");
	ports.put(24163,"Esquivel - Jamaica");
	ports.put(71400,"Essaquira - Morocco");
	ports.put(40100,"Essvik - Sweden");
	ports.put(40100,"Essviken - Sweden");
	ports.put(4470,"Estonia - Estonia");
	ports.put(42773,"Etang de Berre - France");
	ports.put(33300,"Eten - Peru");
	ports.put(7749,"Ethiopia - Ethiopia");
	ports.put(2802,"EUREKA - United States");
	ports.put(42118,"Europoort - Netherlands");
	ports.put(3006,"EVERETT - United States");
	ports.put(31268,"Everton - Guyana");
	ports.put(23621,"Exuma - Bahamas");
	ports.put(40327,"Eydehamn - Norway");
	ports.put(2404,"FABENS - United States");
	ports.put(10100,"Faeringehavn - Greenland");
	ports.put(40300,"Fagerstrand - Norway");
	ports.put(40100,"Fagervik - Sweden");
	ports.put(51323,"Fahaheel - Kuwait");
	ports.put(3111,"FAIRBANKS - United States");
	ports.put(4111,"FAIRPORT - United States");
	ports.put(4904,"FAJARDO - United States");
	ports.put(40121,"Falkenberg - Sweden");
	ports.put(3720,"Falkland Islands - Falkland Islands");
	ports.put(407,"FALL RIVER - United States");
	ports.put(24100,"Falmouth - Jamaica");
	ports.put(41328,"Falmouth - United Kingdom");
	ports.put(49199,"Famagusta - Cyprus");
	ports.put(72999,"Fanara - Egypt");
	ports.put(57044,"Fang Cheng - China");
	ports.put(57044,"Fangcheng - China");
	ports.put(50500,"Fao - Iraq");
	ports.put(78800,"Farafangana - Madagascar");
	ports.put(47100,"Faro - Portugal");
	ports.put(4091,"Faroe Islands - Faroe Islands");
	ports.put(40329,"Farsund - Norway");
	ports.put(41600,"Faslane - United Kingdom");
	ports.put(52040,"Fateh Terminal - United Arab Em");
	ports.put(41329,"Fawley - United Kingdom");
	ports.put(42700,"Fecamp - France");
	ports.put(4770,"FEDERAL EXPRESS, JAMAICA - United States");
	ports.put(4671,"FEDERAL EXPRESS, NEWARK - United States");
	ports.put(3195,"FEDERAL EXPRESS,ANCHORAGE - United States");
	ports.put(4198,"FEDERAL EXPRESS,INDIANAPOLIS - United States");
	ports.put(2095,"FEDERAL EXPRESS,MEMPHIS - United States");
	ports.put(2895,"FEDERAL EXPRESS,OAKLAND - United States");
	ports.put(4280,"Federal Republic of Germany - Federal Republic of Germany");
	ports.put(6820,"Fedrated States of Micronesia - Fedrated States of Micronesia");
	ports.put(41323,"Felixstowe - United Kingdom");
	ports.put(78800,"Fenerive - Madagascar");
	ports.put(41900,"Fenit - Ireland");
	ports.put(46279,"Feodosia - Ukraine");
	ports.put(46279,"Feodosiya - Ukraine");
	ports.put(1805,"FERNANDINA BEACH - United States");
	ports.put(47022,"Ferrol - Spain");
	ports.put(3013,"FERRY - United States");
	ports.put(3844,"FERRYSBURG - United States");
	ports.put(48900,"Fethiye - Turkey");
	ports.put(47135,"Figueira da Foz - Portugal");
	ports.put(6863,"Fiji - Fiji");
	ports.put(48900,"Finike - Turkey");
	ports.put(4050,"Finland - Finland");
	ports.put(41698,"Finnart oil terminal - United Kingdom");
	ports.put(60400,"Finsch Harbor - Papua New Guinea");
	ports.put(41698,"Firth of Forth - United Kingdom");
	ports.put(8528,"Fisher Harbour, ONT - Canada");
	ports.put(47923,"Fiume - Croatia");
	ports.put(47500,"Fiumicino - Italy");
	ports.put(41299,"Fleetwood - United Kingdom");
	ports.put(42800,"Flensburg - Germany");
	ports.put(40340,"Floro - Norway");
	ports.put(41680,"Flotta - United Kingdom");
	ports.put(42185,"Flushing - Netherlands");
	ports.put(24500,"Fond la Grange - Haiti");
	ports.put(57015,"Foochou - China");
	ports.put(57015,"Foochow - China");
	ports.put(75349,"Forcados - Nigeria");
	ports.put(75349,"Forcados Terminal - Nigeria");
	ports.put(27705,"Fort Baii - Neth Antilles");
	ports.put(27705,"Fort Bay - Neth Antilles");
	ports.put(28351,"Fort de France - Martinique");
	ports.put(107,"FORT FAIRFIELD - United States");
	ports.put(9000,"Fort Frances, ONT - Canada");
	ports.put(110,"FORT KENT - United States");
	ports.put(5555,"FORT LAUDE - United States");
	ports.put(24514,"Fort Liberte - Haiti");
	ports.put(1822,"FORT MYERS AIRPORT - United States");
	ports.put(5205,"FORT PIERCE - United States");
	ports.put(4183,"FORT WAYNE AIRPORT - United States");
	ports.put(41600,"Fort William - United Kingdom");
	ports.put(9662,"Fort Williams, ONT - Canada");
	ports.put(35133,"Fortaleza - Brazil");
	ports.put(3417,"FORTUNA - United States");
	ports.put(15208,"Fortune, NL - Canada");
	ports.put(42776,"Fos - France");
	ports.put(42776,"FOS Sur Mer - France");
	ports.put(41332,"Fowey - United Kingdom");
	ports.put(13400,"Fox River, QUE - Canada");
	ports.put(41913,"Foynes - Ireland");
	ports.put(4279,"France - France");
	ports.put(40100,"Frano - Sweden");
	ports.put(12261,"Fraser River, BC - Canada");
	ports.put(41698,"Fraserburgh - United Kingdom");
	ports.put(35500,"Fray Bentos - Uruguay");
	ports.put(40921,"Fredericia - Denmark");
	ports.put(10100,"Frederikshaab - Greenland");
	ports.put(40909,"Frederikshavn - Denmark");
	ports.put(40334,"Frederikstad - Norway");
	ports.put(91145,"Frederiksted, St. Croix - US Virgin Is");
	ports.put(5105,"FREDERIKSTED,VIRGIN ISLANDS - United States");
	ports.put(40520,"Fredrikshamn - Finland");
	ports.put(40334,"Fredrikstad - Norway");
	ports.put(5311,"FREEPORT - United States");
	ports.put(23645,"Freeport, Grand Bahama I - Bahamas");
	ports.put(23299,"Freeport, Ireland Island - Bermuda");
	ports.put(74751,"Freetown - Sierra Leone");
	ports.put(60222,"Fremantle - Australia");
	ports.put(3170,"French Guiana - French Guiana");
	ports.put(6414,"French Polynesia - French Polynesia");
	ports.put(7905,"French Southern and Antarctic Lands - French Southern and Antarctic Lands");
	ports.put(23600,"Fresh Creek - Bahamas");
	ports.put(2803,"FRESNO - United States");
	ports.put(3014,"FRIDAY HARBOR - United States");
	ports.put(15298,"Frobisher Bay, NL - Canada");
	ports.put(1410,"FRONT ROYAL - United States");
	ports.put(20153,"Frontera - Mexico");
	ports.put(3020,"FRONTIER - United States");
	ports.put(5210,"FT. LAUDERDALE,HOLLYWOOD INTERNATIONAL AIRPORT - United States");
	ports.put(57015,"Fuchou - China");
	ports.put(40985,"Fuglefjord - Faroe");
	ports.put(52077,"Fujairah - United Arab Em");
	ports.put(52077,"Fujaireh - United Arab Em");
	ports.put(58803,"Fukuyama - Japan");
	ports.put(58821,"Funabashi - Japan");
	ports.put(62231,"Funafuti Atoll - Tuvalu");
	ports.put(58868,"Funagawa - Japan");
	ports.put(58868,"Funakawa - Japan");
	ports.put(58868,"Funakawa Ko - Japan");
	ports.put(47101,"Funchal - Portugal");
	ports.put(40985,"Funglafjordur - Faroe");
	ports.put(57011,"FUQING, FUJIAN - CHINA");
	ports.put(40100,"Furogrund - Sweden");
	ports.put(40100,"Furuogrund - Sweden");
	ports.put(58824,"Fushiki - Japan");
	ports.put(58824,"Fushiki Toyama - Japan");
	ports.put(57015,"Fuzhou - China");
	ports.put(57015,"Fuzhou - China");
	ports.put(72305,"Gabes - Tunisia");
	ports.put(7550,"Gabon - Gabon");
	ports.put(40115,"Gaddvik - Sweden");
	ports.put(47525,"Gaeta - Italy");
	ports.put(40116,"Gafle - Sweden");
	ports.put(33100,"Galapagos Islands - Ecuador");
	ports.put(48500,"Galati - Romania");
	ports.put(48500,"Galatz - Romania");
	ports.put(27410,"Galeota Point - Trinidad");
	ports.put(28399,"Galion - Martinique");
	ports.put(27727,"Galisbay - Neth Antilles");
	ports.put(54200,"Galle - Sri Lanka");
	ports.put(54200,"Galle Harbor - Sri Lanka");
	ports.put(28399,"Gallion Bay - Martinique");
	ports.put(48999,"Gallipoli - Turkey");
	ports.put(5310,"GALVESTON - United States");
	ports.put(41900,"Galway - Ireland");
	ports.put(58883,"Gamagori - Japan");
	ports.put(75503,"Gamba - Gabon");
	ports.put(7500,"Gambia - Gambia");
	ports.put(22500,"Gamboa - Panama");
	ports.put(40500,"Gamlakarleby - Finland");
	ports.put(42331,"Gand - Belgium");
	ports.put(47093,"Gandia - Spain");
	ports.put(12494,"Ganges, BC - Canada");
	ports.put(41600,"Gare Lock - United Kingdom");
	ports.put(41600,"Gareloch - United Kingdom");
	ports.put(41600,"Garelochhead - United Kingdom");
	ports.put(1092,"GARNERVILL - United States");
	ports.put(74297,"Garoua - Cameroon");
	ports.put(47099,"Garrucha - Spain");
	ports.put(41299,"Garston - United Kingdom");
	ports.put(3905,"GARY - United States");
	ports.put(56500,"Gasan - Philippines");
	ports.put(13819,"Gaspe, QUE - Canada");
	ports.put(2772,"GATEWAY FREIGHT SERVICES, LAX - United States");
	ports.put(33700,"Gatico - Chile");
	ports.put(22500,"Gatun - Panama");
	ports.put(40116,"Gavle - Sweden");
	ports.put(5082,"Gaza Strip Administered by Israel - Gaza Strip Administered by Israel");
	ports.put(50769,"Gazireh Ye Lavan - Iran");
	ports.put(45511,"Gdansk - Poland");
	ports.put(45505,"Gdynia - Poland");
	ports.put(48944,"Gebze - Turkey");
	ports.put(60225,"Geelong - Australia");
	ports.put(40116,"Gefle - Sweden");
	ports.put(72999,"Geisum Terminal - Egypt");
	ports.put(47543,"Gela - Italy");
	ports.put(48999,"Gelibolu - Turkey");
	ports.put(48947,"Gemlik - Turkey");
	ports.put(56500,"General MacArthur - Philippines");
	ports.put(33373,"General San Martin - Peru");
	ports.put(4419,"GENEVA - Switzerland");
	ports.put(47527,"Genoa - Italy");
	ports.put(47527,"Genova - Italy");
	ports.put(42331,"Gent - Belgium");
	ports.put(24410,"Georgetown - Cayman Isl");
	ports.put(31201,"Georgetown - Guyana");
	ports.put(1602,"GEORGETOWN - United States");
	ports.put(75898,"Georgetown, Ascension Is - St. Helena");
	ports.put(4633,"Georgia - Georgia");
	ports.put(60224,"Geraldton - Australia");
	ports.put(40116,"Gevle - Sweden");
	ports.put(7490,"Ghana - Ghana");
	ports.put(72142,"Ghazaouet - Algeria");
	ports.put(72142,"Ghazawet - Algeria");
	ports.put(48947,"Ghemlik - Turkey");
	ports.put(42331,"Ghent - Belgium");
	ports.put(23900,"Gibara - Cuba");
	ports.put(4720,"Gibraltar - Gibraltar");
	ports.put(47201,"Gibraltar - Gibraltar");
	ports.put(47017,"Gijon - Spain");
	ports.put(56500,"Gingoog - Philippines");
	ports.put(47536,"Gioia Tauro - Italy");
	ports.put(48931,"Giova - Turkey");
	ports.put(48946,"Giresun - Turkey");
	ports.put(61408,"Gisborne - New Zealand");
	ports.put(51719,"Gizan - Saudi Arabia");
	ports.put(62200,"Gizo - Solomon Is");
	ports.put(60231,"Gladstone - Australia");
	ports.put(41623,"Glasgow - United Kingdom");
	ports.put(4603,"Glassboro - United States");
	ports.put(2709,"Glendale - United States");
	ports.put(40900,"Glostrup - Denmark");
	ports.put(41299,"Gloucester - United Kingdom");
	ports.put(404,"GLOUCESTER - United States");
	ports.put(1113,"GLOUCESTER CITY - United States");
	ports.put(53340,"Goa - India");
	ports.put(48925,"Gocek - Turkey");
	ports.put(6533,"Goderich, ONT - Canada");
	ports.put(10100,"Godhavn - Greenland");
	ports.put(10125,"Godthaab - Greenland");
	ports.put(10125,"Godthab - Greenland");
	ports.put(48931,"Gokova - Turkey");
	ports.put(48931,"Gokova Iskelesi - Turkey");
	ports.put(48999,"Golcuk - Turkey");
	ports.put(12275,"Gold River, BC - Canada");
	ports.put(13452,"Gold River, NS - Canada");
	ports.put(22363,"Golfito - Costa Rica");
	ports.put(47565,"Golfo de Palmas - Italy");
	ports.put(22525,"Golfo de Parita - Panama");
	ports.put(22599,"Golfo de San Miguel - Panama");
	ports.put(22399,"Golfo Dulce - Costa Rica");
	ports.put(48931,"Golovasi Terminal - Turkey");
	ports.put(45101,"GOMEL - BELARUS");
	ports.put(4622,"GOMEL - BELARUS");
	ports.put(24588,"Gonaives - Haiti");
	ports.put(12493,"Gooch Island, BC - Canada");
	ports.put(2014,"GOOD HOPE - United States");
	ports.put(41335,"Goole - United Kingdom");
	ports.put(23640,"Gorda Cay - Bahamas");
	ports.put(56030,"Gorontalo - Indonesia");
	ports.put(40117,"Goteborg - Sweden");
	ports.put(40117,"Gothenburg - Sweden");
	ports.put(27715,"Goto oil terminal - Neth Antilles");
	ports.put(41600,"Gourock - United Kingdom");
	ports.put(60227,"Gove - Australia");
	ports.put(23623,"Governors Harbour - Bahamas");
	ports.put(47300,"Gozo Island - Malta");
	ports.put(3304,"GRAET FALLS - United States");
	ports.put(2010,"GRAMERCY - United States");
	ports.put(15209,"Grand Bank, NFLD - Canada");
	ports.put(74899,"Grand Bassam - Ivory Coast");
	ports.put(24410,"Grand Cayman - Cayman Isl");
	ports.put(3427,"GRAND FORKS - United States");
	ports.put(13829,"Grand Harbor, NB - Canada");
	ports.put(3816,"GRAND HAVEN - United States");
	ports.put(74899,"Grand Lahou - Ivory Coast");
	ports.put(74899,"Grand Lahu - Ivory Coast");
	ports.put(13829,"Grand Manan Island, NB - Canada");
	ports.put(76100,"Grand Popo - Benin");
	ports.put(3613,"GRAND PORTAGE - United States");
	ports.put(3806,"GRAND RAPIDS - United States");
	ports.put(24320,"Grand Turks - Turks Is");
	ports.put(24882,"Grande Anse - Grenada");
	ports.put(41665,"Grangemouth - United Kingdom");
	ports.put(41698,"Granton - United Kingdom");
	ports.put(42123,"Gravenhage - Netherlands");
	ports.put(41398,"Gravesend - United Kingdom");
	ports.put(23640,"Great Abaco Island - Bahamas");
	ports.put(23643,"Great Harbour Cay - Bahamas");
	ports.put(23653,"Great Inagua - Bahamas");
	ports.put(23642,"Great Stirrup Cay - Bahamas");
	ports.put(41398,"Great Yarmouth - United Kingdom");
	ports.put(3982,"GREATER ROCKFORD AIRPORT - United States");
	ports.put(4840,"Greece - Greece");
	ports.put(3703,"GREEN BAY - United States");
	ports.put(24100,"Green Island - Jamaica");
	ports.put(23640,"Green Turtle Cay - Bahamas");
	ports.put(41336,"Greenhite - United Kingdom");
	ports.put(41336,"Greenhithe - United Kingdom");
	ports.put(41625,"Greenock - United Kingdom");
	ports.put(41922,"Greenore - Ireland");
	ports.put(76500,"Greenville - Liberia");
	ports.put(2011,"GREENVILLE - United States");
	ports.put(9000,"Greenville, ONT - Canada");
	ports.put(1603,"GREENVILLE-SPARTANBURG - United States");
	ports.put(41398,"Greenwich - United Kingdom");
	ports.put(40900,"Grenaa - Denmark");
	ports.put(2489,"Grenada - Grenada");
	ports.put(56034,"Gresik - Indonesia");
	ports.put(61400,"Greymouth - New Zealand");
	ports.put(41398,"Grimsby - United Kingdom");
	ports.put(40300,"Grimstad - Norway");
	ports.put(44911,"GRODNO - Belarus");
	ports.put(45101,"GRODNO - BELARUS");
	ports.put(42100,"Groningen - Netherlands");
	ports.put(13820,"Gros Cacouna, QUE - Canada");
	ports.put(13820,"Groscacouna, QUE - Canada");
	ports.put(40002,"Grundarfjordur - Iceland");
	ports.put(40002,"Grundartangi - Iceland");
	ports.put(20100,"Guadalupe Island - Mexico");
	ports.put(2831,"Guadeloupe - Guadeloupe");
	ports.put(9350,"Guam - Guam");
	ports.put(93501,"Guam Island - Guam");
	ports.put(21535,"Guanaja - Honduras");
	ports.put(57071,"Guangzhou - China");
	ports.put(57071,"Guangzhou - China");
	ports.put(4905,"GUANICA - United States");
	ports.put(33700,"Guanillo - Chile");
	ports.put(30741,"Guanta - Venezuela");
	ports.put(23941,"Guantanamo Bay - Cuba");
	ports.put(30742,"Guaranao - Venezuela");
	ports.put(2050,"Guatemala - Guatemala");
	ports.put(23979,"Guayabal - Cuba");
	ports.put(33735,"Guayacan - Chile");
	ports.put(4912,"GUAYANILLA - United States");
	ports.put(33131,"Guayaquil - Ecuador");
	ports.put(20113,"Guaymas - Mexico");
	ports.put(48999,"Gueldjuk - Turkey");
	ports.put(7460,"Guinea - Guinea");
	ports.put(7642,"Guinea-Bissau - Guinea-Bissau");
	ports.put(30700,"Guiria - Venezuela");
	ports.put(40300,"Guldsmedvik - Norway");
	ports.put(40910,"Gulfhavn - Denmark");
	ports.put(1902,"GULFPORT - United States");
	ports.put(23683,"Gun Cay - Bahamas");
	ports.put(58028,"Gunsan - South Korea");
	ports.put(28319,"Gustavia - Guadeloupe");
	ports.put(20195,"Gutierrez Zamorra - Mexico");
	ports.put(3120,"Guyana - Guyana");
	ports.put(68682,"Haapai - Tonga");
	ports.put(42100,"Haarlem - Netherlands");
	ports.put(40300,"Haavik - Norway");
	ports.put(58808,"Hachinohe - Japan");
	ports.put(50815,"Hadera - Israel");
	ports.put(40911,"Haderslev - Denmark");
	ports.put(40001,"Hafnarfjordhur - Iceland");
	ports.put(40001,"Hafnarfjordur - Iceland");
	ports.put(55201,"Hai Phong - Vietnam");
	ports.put(50801,"Haifa - Israel");
	ports.put(57012,"Haikou - China");
	ports.put(24741,"Haina - Dominican Republic");
	ports.put(55201,"Haiphong - Vietnam");
	ports.put(2450,"Haiti - Haiti");
	ports.put(58825,"Hakata - Japan");
	ports.put(58826,"Hakodate - Japan");
	ports.put(40342,"Halden - Norway");
	ports.put(53354,"Haldia - India");
	ports.put(23624,"Half Moon Cay - Bahamas");
	ports.put(13841,"Halifax, NS - Canada");
	ports.put(40118,"Hallstavik - Sweden");
	ports.put(40119,"Halmstad - Sweden");
	ports.put(40120,"Halsingborg - Sweden");
	ports.put(51800,"Halul Island - Qatar");
	ports.put(51800,"HAMAD PORT - QATAR");
	ports.put(41374,"Hamble - United Kingdom");
	ports.put(42879,"Hamburg - Germany");
	ports.put(23201,"Hamilton - Bermuda");
	ports.put(1520,"Hamilton, ONT - Canada");
	ports.put(40520,"Hamina - Finland");
	ports.put(40549,"Hamina* - Finland");
	ports.put(40336,"Hammerfest - Norway");
	ports.put(52000,"Hamriyah Terminal - United Arab Em");
	ports.put(58800,"Handa - Japan");
	ports.put(40523,"Hango - Finland");
	ports.put(40523,"Hanko - Finland");
	ports.put(57013,"Hankow - China");
	ports.put(3408,"HANNAH - United States");
	ports.put(3415,"HANSBORO - United States");
	ports.put(40900,"Hansted - Denmark");
	ports.put(40900,"Hanstholm - Denmark");
	ports.put(13848,"Hantsport, NS - Canada");
	ports.put(64178,"Hao - French Polyn");
	ports.put(58800,"Haramaci - Japan");
	ports.put(40100,"Harare - Sweden");
	ports.put(15210,"Harbour Breton, NFLD - Canada");
	ports.put(15232,"Harbour Grace, NFLD - Canada");
	ports.put(23619,"Harbour Island - Bahamas");
	ports.put(42881,"Harburg - Germany");
	ports.put(42300,"Haren - Belgium");
	ports.put(42100,"Haren - Netherlands");
	ports.put(40100,"Hargshamn - Sweden");
	ports.put(42100,"Harlingen - Netherlands");
	ports.put(12407,"Harmac, BC - Canada");
	ports.put(40100,"Harnosand - Sweden");
	ports.put(76500,"Harper - Liberia");
	ports.put(1109,"HARRISBURG - United States");
	ports.put(41323,"Harrogate - United Kingdom");
	ports.put(40300,"Harstad - Norway");
	ports.put(411,"HARTFORD - United States");
	ports.put(41338,"Hartlepool - United Kingdom");
	ports.put(12200,"Hartley Bay, BC - Canada");
	ports.put(12200,"Hartley, BC - Canada");
	ports.put(41398,"Harwich - United Kingdom");
	ports.put(58800,"Hashihama - Japan");
	ports.put(60237,"Hasting - Australia");
	ports.put(40345,"Haugesund - Norway");
	ports.put(23944,"Havana - Cuba");
	ports.put(61400,"Hawkes Bay - New Zealand");
	ports.put(48999,"Hay Darpasa - Turkey");
	ports.put(60212,"Hay Point - Australia");
	ports.put(48999,"Haydarpasa - Turkey");
	ports.put(6029,"Heard and McDonald Islands - Heard and McDonald Islands");
	ports.put(3481,"HECTOR INTERNATIONAL AIRPORT, FARGO - United States");
	ports.put(42100,"Helder - Netherlands");
	ports.put(40120,"Helsingborg - Sweden");
	ports.put(40525,"Helsingfors - Finland");
	ports.put(40900,"Helsingor - Denmark");
	ports.put(40525,"Helsinki - Finland");
	ports.put(42385,"Hemiksem - Belgium");
	ports.put(48411,"Heraklion - Greece");
	ports.put(20100,"Hermosillo - Mexico");
	ports.put(40100,"Hernosand - Sweden");
	ports.put(40348,"Heroen - Norway");
	ports.put(9669,"Heron Bay, ONT - Canada");
	ports.put(42800,"Herrenwyck - Germany");
	ports.put(91125,"Hess Oil Term. St. Croix - US Virgin Is");
	ports.put(15201,"Hibernia, NFLD - Canada");
	ports.put(1509,"Hickory - United States");
	ports.put(2305,"HIDALGO,PHARR - United States");
	ports.put(58828,"Higashi Harima - Japan");
	ports.put(58800,"Higashi Iwase - Japan");
	ports.put(58828,"Higashiharima Ko - Japan");
	ports.put(99900,"High Seas - Unknown");
	ports.put(99930,"High Seas,Gulf of Mexico - Unknown");
	ports.put(99910,"High Seas,North Atlantic - Unknown");
	ports.put(99940,"High Seas,North Pacific - Unknown");
	ports.put(99920,"High Seas,South Atlantic - Unknown");
	ports.put(99950,"High Seas,South Pacific - Unknown");
	ports.put(212,"HIGHGATE SPRINGS,ALBURG - United States");
	ports.put(3202,"HILO - United States");
	ports.put(40500,"Himanko - Finland");
	ports.put(58871,"Himeji - Japan");
	ports.put(58871,"Himezi - Japan");
	ports.put(42385,"Himixen - Belgium");
	ports.put(56500,"Hinigaran - Philippines");
	ports.put(58845,"Hiro - Japan");
	ports.put(58830,"Hirohata - Japan");
	ports.put(58831,"Hiroshima - Japan");
	ports.put(58869,"Hitachi - Japan");
	ports.put(58869,"Hitachi Ko - Japan");
	ports.put(58869,"Hitaki Ko - Japan");
	ports.put(55224,"Ho Chi Minh City - Vietnam");
	ports.put(60295,"Hobart - Australia");
	ports.put(40912,"Hobro - Denmark");
	ports.put(52115,"Hodeidah - Yemen");
	ports.put(40123,"Hoganas - Sweden");
	ports.put(40913,"Holbaek - Denmark");
	ports.put(40320,"Holla - Norway");
	ports.put(1001,"HOLLAND, O - United States");
	ports.put(40300,"Holmestrand - Norway");
	ports.put(40127,"Holmsund - Sweden");
	ports.put(12200,"Holsteinborg, BC - Canada");
	ports.put(10100,"Holsteinsborg - Greenland");
	ports.put(42825,"Holtenau - Germany");
	ports.put(41415,"Holyhead - United Kingdom");
	ports.put(15245,"Holyrood, NFLD - Canada");
	ports.put(55202,"Hon Gai - Vietnam");
	ports.put(55202,"Hon Gay - Vietnam");
	ports.put(56530,"Hondagua - Philippines");
	ports.put(2150,"Honduras - Honduras");
	ports.put(42700,"Honfleur - France");
	ports.put(5820,"Hong Kong - Hong Kong");
	ports.put(58201,"Hong Kong - Hong Kong");
	ports.put(62200,"Honiara - Solomon Is");
	ports.put(40300,"Honningsvaag - Norway");
	ports.put(40300,"Honningsvag - Norway");
	ports.put(3201,"HONOLULU - United States");
	ports.put(3205,"HONOLULU INTL. AIRPORT - United States");
	ports.put(42100,"Hook of Holland - Netherlands");
	ports.put(48900,"Hopa - Turkey");
	ports.put(1408,"HOPEWELL - United States");
	ports.put(50700,"Hormuz Terminal - Iran");
	ports.put(40100,"Hornesfors - Sweden");
	ports.put(47099,"Hornillo - Spain");
	ports.put(40914,"Horsens - Denmark");
	ports.put(47150,"Horta - Portugal");
	ports.put(40300,"Horten - Norway");
	ports.put(106,"HOULTON - United States");
	ports.put(41668,"Hound Point - United Kingdom");
	ports.put(41668,"Houndpoint - United Kingdom");
	ports.put(5301,"HOUSTON - United States");
	ports.put(5309,"HOUSTON INTERCONTINENTAL AIRPORT,HOUSTON - United States");
	ports.put(91125,"Hovic, St. Croix - US Virgin Is");
	ports.put(12208,"Howie Sound, BC - Canada");
	ports.put(57069,"Hsia Men - China");
	ports.put(57017,"Hsin Kang - China");
	ports.put(57017,"Hsinkang - China");
	ports.put(57000,"Hu lu Tao - China");
	ports.put(33300,"Huacho - Peru");
	ports.put(58312,"Hualien - China Taiwan");
	ports.put(57072,"Huangpu - China");
	ports.put(33300,"Huarmey - Peru");
	ports.put(33739,"Huasco - Chile");
	ports.put(21900,"Huaunta - Nicaragua");
	ports.put(40100,"Hudiksvall - Sweden");
	ports.put(47044,"Huelva - Spain");
	ports.put(41341,"Hull - United Kingdom");
	ports.put(57000,"Huludao Gang - China");
	ports.put(57000,"Hulutao - China");
	ports.put(4906,"HUMACAO - United States");
	ports.put(42300,"Humbeek - Belgium");
	ports.put(4370,"Hungary - Hungary");
	ports.put(57900,"Hungnam - North Korea");
	ports.put(41627,"Hunterston - United Kingdom");
	ports.put(1910,"HUNTSVILLE - United States");
	ports.put(4117,"HURON - United States");
	ports.put(48475,"Iali - Greece");
	ports.put(35700,"Ibicuy - Argentina");
	ports.put(47067,"Ibiza - Spain");
	ports.put(4000,"Iceland - Iceland");
	ports.put(40129,"Iggesund - Sweden");
	ports.put(42190,"Ijmuiden - Netherlands");
	ports.put(24500,"Ile de la Gonave - Haiti");
	ports.put(35137,"Ilheus - Brazil");
	ports.put(46271,"Ilichevsk - Ukraine");
	ports.put(56531,"Iligan - Philippines");
	ports.put(33335,"Ilo - Peru");
	ports.put(56532,"Iloilo - Philippines");
	ports.put(46271,"Ilyichevsk - Ukraine");
	ports.put(58802,"Imari - Japan");
	ports.put(35178,"Imbituba - Brazil");
	ports.put(41342,"Immingham - United Kingdom");
	ports.put(47500,"Imperia - Italy");
	ports.put(58029,"Inchon - South Korea");
	ports.put(5330,"India - India");
	ports.put(4110,"INDIANAPOLIS - United States");
	ports.put(5600,"Indonesia - Indonesia");
	ports.put(48999,"Inebolu - Turkey");
	ports.put(40527,"Inga - Finland");
	ports.put(40527,"Inkoo - Finland");
	ports.put(5270,"INTERNATIONAL COURIER ASSOCIATION - United States");
	ports.put(3604,"INTERNATIONAL FALLS,RANIER - United States");
	ports.put(8500,"International Organizations - International Organizations");
	ports.put(41698,"Invergordon - United Kingdom");
	ports.put(41698,"Inverkeithing - United Kingdom");
	ports.put(41674,"Inverkip - United Kingdom");
	ports.put(41683,"Inverness - United Kingdom");
	ports.put(41398,"Ipswich - United Kingdom");
	ports.put(33741,"Iquique - Chile");
	ports.put(8954,"IQUIQUE - CHILI");
	ports.put(33337,"Iquitos - Peru");
	ports.put(58800,"Irago - Japan");
	ports.put(58800,"Irago Zaki - Japan");
	ports.put(48411,"Iraklion - Greece");
	ports.put(5070,"Iran - Iran");
	ports.put(5050,"Iraq - Iraq");
	ports.put(4190,"Ireland - Ireland");
	ports.put(44911,"IRKUTSK - RUSSIA");
	ports.put(41630,"Irvine - United Kingdom");
	ports.put(41630,"Irvine Harbor - United Kingdom");
	ports.put(56590,"Isabel - Philippines");
	ports.put(23937,"Isabela del Sagua - Cuba");
	ports.put(40000,"Isafjordhur - Iceland");
	ports.put(40000,"Isafjordur - Iceland");
	ports.put(48928,"Isdemir - Turkey");
	ports.put(58829,"Ishinomaki - Japan");
	ports.put(48931,"Iskenderun - Turkey");
	ports.put(20104,"Isla Cedros - Mexico");
	ports.put(20195,"Isla de Lobos - Mexico");
	ports.put(23900,"Isla de Pinos - Cuba");
	ports.put(20100,"Isla Maria Cleofas - Mexico");
	ports.put(20100,"Isla Maria Madre - Mexico");
	ports.put(20100,"Isla Maria Magdalena - Mexico");
	ports.put(20179,"Isla Mujeres - Mexico");
	ports.put(22599,"Isla Parida - Panama");
	ports.put(21535,"Isla Roatan - Honduras");
	ports.put(30130,"Isla San Andres - Colombia");
	ports.put(20100,"Isla Socorro - Mexico");
	ports.put(21500,"Isla Utila - Honduras");
	ports.put(20128,"Islas Coronados - Mexico");
	ports.put(22399,"Islas de Coco - Costa Rica");
	ports.put(21900,"Islas de Maiz - Nicaragua");
	ports.put(33300,"Islas Lobos de Afuera - Peru");
	ports.put(33300,"Islas Lobos de Tierra - Peru");
	ports.put(23900,"Isle of Pines - Cuba");
	ports.put(72925,"Ismailia - Egypt");
	ports.put(5081,"Israel - Israel");
	ports.put(48945,"Istanbul - Turkey");
	ports.put(20599,"Istapa - Guatemala");
	ports.put(35139,"Itacoatiara - Brazil");
	ports.put(35138,"Itajai - Brazil");
	ports.put(35138,"Itajay - Brazil");
	ports.put(4759,"Italy - Italy");
	ports.put(35135,"Itaqui - Brazil");
	ports.put(48457,"Itea - Greece");
	ports.put(58800,"Itozaki - Japan");
	ports.put(10100,"Ivigtut - Greenland");
	ports.put(7480,"Ivory Coast - Ivory Coast");
	ports.put(58833,"Iwakuni - Japan");
	ports.put(58833,"Iwakuni Ko - Japan");
	ports.put(58812,"Iyo Mishima - Japan");
	ports.put(58812,"Iyoshima - Japan");
	ports.put(48939,"Izmir - Turkey");
	ports.put(48940,"Izmit - Turkey");
	ports.put(20599,"Iztapa - Guatemala");
	
}

public void fillPorts3() {
	ports.put(104,"JACKMAN - United States");
	ports.put(12200,"Jackson Bay, BC - Canada");
	ports.put(1803,"JACKSONVILLE - United States");
	ports.put(24537,"Jacmel - Haiti");
	ports.put(54200,"Jaffna - Sri Lanka");
	ports.put(56500,"Jagna - Philippines");
	ports.put(24741,"Jaina - Dominican Republic");
	ports.put(56033,"Jakarta - Indonesia");
	ports.put(10100,"Jakobshavn - Greenland");
	ports.put(40500,"Jakobstad - Finland");
	ports.put(2410,"Jamaica - Jamaica");
	ports.put(56078,"Jambi - Indonesia");
	ports.put(75899,"Jamestown, St. Helena - St. Helena");
	ports.put(53305,"Jamnagar - India");
	ports.put(5880,"Japan - Japan");
	ports.put(41398,"Jarrow - United Kingdom");
	ports.put(53313,"Jawaharlal Nehru - India");
	ports.put(51800,"Jazirath Halul - Qatar");
	ports.put(50700,"Jazireh ye Khark - Iran");
	ports.put(52051,"Jebel Ali - United Arab Em");
	ports.put(52050,"Jebel Dhanna - United Arab Em");
	ports.put(51721,"Jeddah - Saudi Arabia");
	ports.put(24500,"Jeremie - Haiti");
	ports.put(12217,"Jervis Inlet, BC - Canada");
	ports.put(57000,"Jiangmen - China");
	ports.put(57080,"Jiangyin - China");
	ports.put(51721,"Jidda - Saudi Arabia");
	ports.put(72100,"Jijel - Algeria");
	ports.put(56500,"Jimenez - Philippines");
	ports.put(3101,"JINEAU - United States");
	ports.put(58015,"Jinhae - South Korea");
	ports.put(58029,"Jinsen - South Korea");
	ports.put(57000,"Jiu Jiang - China");
	ports.put(57077,"Jiuzhou - China");
	ports.put(35127,"Joao Pessoa - Brazil");
	ports.put(4911,"JOBOS - United States");
	ports.put(4701,"JOHN F. KENNEDY AIRPORT, JFK - United States");
	ports.put(55707,"Johore - Malaysia");
	ports.put(55707,"Johore Bahru - Malaysia");
	ports.put(56500,"Jolo - Philippines");
	ports.put(122,"JONESPORT - United States");
	ports.put(5110,"Jordan - Jordan");
	ports.put(71415,"Jorf Lasfar - Morocco");
	ports.put(40300,"Jorpeland - Norway");
	ports.put(30743,"Jose - Venezuela");
	ports.put(35500,"Jose Ignacio Terminal - Uruguay");
	ports.put(56591,"Jose Panganiban - Philippines");
	ports.put(51723,"Juaymah Oil Terminal - Saudi Arabia");
	ports.put(51720,"Jubail - Saudi Arabia");
	ports.put(23900,"Jucaro - Cuba");
	ports.put(51721,"Judda - Saudi Arabia");
	ports.put(10100,"Julianchaab - Greenland");
	ports.put(10100,"Julianehaab - Greenland");
	ports.put(46275,"Juzhny - Ukraine");
	ports.put(40300,"Kaarsto - Norway");
	ports.put(58807,"Kagoshima - Japan");
	ports.put(3203,"KAHULUI - United States");
	ports.put(3206,"KAILUA-KONA - United States");
	ports.put(55751,"Kajang - Malaysia");
	ports.put(53398,"Kakinada - India");
	ports.put(53398,"Kakinada Bay - India");
	ports.put(58828,"Kakogawa - Japan");
	ports.put(2909,"KALAMA - United States");
	ports.put(48421,"Kalamai - Greece");
	ports.put(48425,"Kalamaki - Greece");
	ports.put(48421,"Kalamata - Greece");
	ports.put(48412,"Kali Limenes - Greece");
	ports.put(56058,"Kali Pekalongan - Indonesia");
	ports.put(56020,"Kalimantan - Indonesia");
	ports.put(46213,"Kaliningrad - Russia");
	ports.put(3324,"KALISPELL - United States");
	ports.put(40100,"Kalix - Sweden");
	ports.put(48400,"Kalloni - Greece");
	ports.put(40100,"Kalmar - Sweden");
	ports.put(48412,"Kaloi limniones - Greece");
	ports.put(40940,"Kalundborg - Denmark");
	ports.put(58834,"Kamaishi - Japan");
	ports.put(40300,"Kambo - Norway");
	ports.put(46239,"Kamchatka - Russia");
	ports.put(55500,"Kampong Saom - Cambodia");
	ports.put(55500,"Kampot - Cambodia");
	ports.put(74625,"Kamsar - Guinea");
	ports.put(58809,"Kanado - Japan");
	ports.put(58862,"Kanda - Japan");
	ports.put(5310,"Kandahar - Afganistan");
	ports.put(53307,"Kandla - India");
	ports.put(58836,"Kanokawa - Japan");
	ports.put(4501,"KANSAS CITY - United States");
	ports.put(58309,"Kao Hsiung - China Taiwan");
	ports.put(58309,"Kaohsiung - China Taiwan");
	ports.put(74499,"Kaolak - Senegal");
	ports.put(53550,"Karachi - Pakistan");
	ports.put(53550,"Karachi Harbor - Pakistan");
	ports.put(40549,"KARAGANDA - Kazakhstan");
	ports.put(44911,"KARAGANDA - Kazakhstan");
	ports.put(45101,"Karaganda - KAZAKHSTAN");
	ports.put(5700,"KARAGANDA - KAZAKHSTAN");
	ports.put(58870,"Karatsu - Japan");
	ports.put(48449,"Karavos - Greece");
	ports.put(47911,"Kardeljevo - Croatia");
	ports.put(53398,"Karikal - India");
	ports.put(40132,"Karlsborg - Sweden");
	ports.put(40133,"Karlshamn - Sweden");
	ports.put(40100,"Karlskrona - Sweden");
	ports.put(40100,"Karlstad - Sweden");
	ports.put(40100,"Karskar - Sweden");
	ports.put(40300,"Karsto - Norway");
	ports.put(58837,"Kasaoka - Japan");
	ports.put(58839,"Kashima - Japan");
	ports.put(58839,"Kashima Ko - Japan");
	ports.put(58801,"Kashiwazaki - Japan");
	ports.put(56023,"Kasim - Indonesia");
	ports.put(40500,"Kasko - Finland");
	ports.put(47931,"Kastel Sucurac - Croatia");
	ports.put(40900,"Kastrup - Denmark");
	ports.put(48458,"Katakolon - Greece");
	ports.put(54929,"Katang - Thailand");
	ports.put(56019,"Katawaringin - Indonesia");
	ports.put(48427,"Kavala - Greece");
	ports.put(60400,"Kavieng - Papua New Guinea");
	ports.put(60400,"Kavieng Harbor - Papua New Guinea");
	ports.put(58842,"Kawanoe - Japan");
	ports.put(58838,"Kawasaki - Japan");
	ports.put(4634,"Kazakhstan - Kazakhstan");
	ports.put(58301,"Keelung - China Taiwan");
	ports.put(40000,"Keflavik - Iceland");
	ports.put(58804,"Keihin - Japan");
	ports.put(55751,"Kelang - Malaysia");
	ports.put(40543,"Kemi - Finland");
	ports.put(48947,"Kemlik - Turkey");
	ports.put(56022,"Kendiri - Indonesia");
	ports.put(71400,"Kenitra - Morocco");
	ports.put(3018,"KENMORE AIR HARBOR - United States");
	ports.put(7790,"Kenya - Kenya");
	ports.put(46274,"Kerch - Ukraine");
	ports.put(55716,"Kereth - Malaysia");
	ports.put(48456,"Kerkyra - Greece");
	ports.put(46274,"Kertch - Ukraine");
	ports.put(58871,"Kesennuma - Japan");
	ports.put(58871,"Kesennuma Ko - Japan");
	ports.put(3102,"KETCHIKAN - United States");
	ports.put(5202,"KEY WEST - United States");
	ports.put(5250,"KHALIFA BIN SALMAN - BAHRAIN");
	ports.put(48400,"Khalkis - Greece");
	ports.put(48400,"Khania - Greece");
	ports.put(50771,"Kharg Island - Iran");
	ports.put(51300,"Khawr Al Ama - Kuwait");
	ports.put(51300,"Khor al Ami - Kuwait");
	ports.put(50570,"Khor al Zubair - Iraq");
	ports.put(52060,"Khor Fakkan - United Arab Em");
	ports.put(50560,"Khor-al-Amaya - Iraq");
	ports.put(50700,"Khorramshahr - Iran");
	ports.put(50700,"Khosrowabad - Iran");
	ports.put(53820,"Khulna - Bangladesh");
	ports.put(56066,"Kidjang - Indonesia");
	ports.put(42825,"Kiel - Germany");
	ports.put(60400,"Kieta - Papua New Guinea");
	ports.put(58815,"Kiire - Japan");
	ports.put(58301,"Kiirun - China Taiwan");
	ports.put(77913,"Kilindini - Kenya");
	ports.put(41345,"Killingholme - United Kingdom");
	ports.put(78399,"Kilwa Kivinje - Tanzania");
	ports.put(58827,"Kimitsu - Japan");
	ports.put(51715,"King Abdul Aziz Port - Saudi Arabia");
	ports.put(51732,"KING ABDULLAH PORT - Saudi Arabia");
	ports.put(51730,"King Fahd Port - Saudi Arabia");
	ports.put(41398,"Kings Lynn - United Kingdom");
	ports.put(41343,"Kings North - United Kingdom");
	ports.put(2981,"KINGSLEY FIELD,KLAMATH FALLS - United States");
	ports.put(41343,"Kingsnorth - United Kingdom");
	ports.put(24128,"Kingston - Jamaica");
	ports.put(1670,"Kingston, ONT - Canada");
	ports.put(24871,"Kingstown - St. Vincent");
	ports.put(3506,"Kingsville, ONT - Canada");
	ports.put(58872,"Kinuura - Japan");
	ports.put(6226,"Kiribati - Kiribati");
	ports.put(40300,"Kirkenes - Norway");
	ports.put(41698,"Kirkwall, Orkney Is - United Kingdom");
	ports.put(58827,"Kisarazu - Japan");
	ports.put(58827,"Kisarazu Ko - Japan");
	ports.put(58800,"Kishiwada - Japan");
	ports.put(77099,"Kismaayo - Somalia");
	ports.put(77099,"Kismayu - Somalia");
	ports.put(58817,"Kita Kyushu - Japan");
	ports.put(58817,"Kitakyushu - Japan");
	ports.put(12287,"Kitimat, BC - Canada");
	ports.put(57000,"Kiukiang - China");
	ports.put(44911,"KIZILORDA - Kazakhstan");
	ports.put(40915,"Kjoge - Denmark");
	ports.put(45101,"Klaipeda - Belarus (Grodno)");
	ports.put(45101,"Klaipeda - Belarus (Grodno)");
	ports.put(4622,"Klaipeda - Grodno - Belarus");
	ports.put(45101,"Klaipeda - Lithuania");
	ports.put(45101,"Klaipeda - Novopolotsk - Belarus");
	ports.put(45101,"KLAIPEDA , ALMATI, KZ - KAZAKHSTAN");
	ports.put(45101,"Klaipeda , Pavlodar - Kazakhstan");
	ports.put(45102,"KLAIPEDA -GOMEL- BELARUS - BELARUS");
	ports.put(1234,"KLAIPEDA-MINSK - BELARUS");
	ports.put(40985,"Klaksvik - Faroe");
	ports.put(2016,"KNOXVILLE - United States");
	ports.put(54920,"Ko Sichang - Thailand");
	ports.put(58840,"Kobe - Japan");
	ports.put(40948,"Kobenhavn - Denmark");
	ports.put(58873,"Kochi - Japan");
	ports.put(40915,"Koge - Denmark");
	ports.put(40500,"Kokkola - Finland");
	ports.put(75361,"Koko - Nigeria");
	ports.put(60400,"Kokopo - Papua New Guinea");
	ports.put(44911,"Kokshetau - KAZAKHSTAN");
	ports.put(58841,"Kokura - Japan");
	ports.put(58841,"Kokura Ko - Japan");
	ports.put(53300,"Kolachel - India");
	ports.put(56500,"Kolambugan - Philippines");
	ports.put(40916,"Kolding - Denmark");
	ports.put(74201,"Kole Terminal - Cameroon");
	ports.put(48400,"Kolpos Kallonis - Greece");
	ports.put(46239,"Kolyma River - Russia");
	ports.put(58882,"Komatsujima - Japan");
	ports.put(58882,"Komatsushima - Japan");
	ports.put(74619,"Konakri - Guinea");
	ports.put(46213,"Konigsberg - Russia");
	ports.put(58301,"Koolung - China Taiwan");
	ports.put(47909,"Kopar - Slovenia");
	ports.put(47909,"Koper - Slovenia");
	ports.put(40300,"Kopervik - Norway");
	ports.put(40100,"Kopmanholmen - Sweden");
	ports.put(5800,"Korea, South - Korea, South");
	ports.put(48410,"Korinthos - Greece");
	ports.put(68394,"Koror - Palau");
	ports.put(46236,"Korsakov - Russia");
	ports.put(40917,"Korsor - Denmark");
	ports.put(42870,"KOSICE - SLOVAKIA");
	ports.put(72999,"Kossier - Egypt");
	ports.put(44911,"Kostanay - Kazakhstan");
	ports.put(55752,"Kota Kinabalu - Malaysia");
	ports.put(40549,"Kotka - Finland");
	ports.put(42870,"KOTKA - Germany");
	ports.put(40549,"Kotka - United States");
	ports.put(64100,"Kouaoua - New Caledonia");
	ports.put(40532,"Koverhar - Finland");
	ports.put(46220,"Kovisto - Russia");
	ports.put(58270,"Kowloon - Hong Kong");
	ports.put(53300,"Kozhikode - India");
	ports.put(75200,"Kpeme - Togo");
	ports.put(54900,"Krabi - Thailand");
	ports.put(40300,"Kragero - Norway");
	ports.put(27715,"Kralendijk - Neth Antilles");
	ports.put(40100,"Kramfors - Sweden");
	ports.put(44911,"Krasnoyarsk - Russia");
	ports.put(74213,"Kribi - Cameroon");
	ports.put(40363,"Kristiansand N - Norway");
	ports.put(40364,"Kristiansand S - Norway");
	ports.put(40100,"Kristinehamn - Sweden");
	ports.put(46215,"Kronstadt - Russia");
	ports.put(55742,"Kuala Selangor - Malaysia");
	ports.put(56076,"Kuala Tanjung - Indonesia");
	ports.put(55711,"Kuala Terengganu - Malaysia");
	ports.put(55715,"Kuantan - Malaysia");
	ports.put(55713,"Kuching - Malaysia");
	ports.put(58843,"Kudamatsu - Japan");
	ports.put(58028,"Kunsan - South Korea");
	ports.put(58028,"Kunson - South Korea");
	ports.put(58845,"Kure - Japan");
	ports.put(58844,"Kuroishi - Japan");
	ports.put(58846,"Kushiro - Japan");
	ports.put(5130,"Kuwait - Kuwait");
	ports.put(51321,"Kuwait - Kuwait");
	ports.put(75389,"Kwa Ibo Terminal - Nigeria");
	ports.put(68190,"Kwajalein - Marshall Is");
	ports.put(58031,"Kwangyang - South Korea");
	ports.put(60234,"Kwinana - Australia");
	ports.put(48400,"Kyllini - Greece");
	ports.put(48459,"Kymassi - Greece");
	ports.put(40918,"Kyndby - Denmark");
	ports.put(40918,"Kyndbyvaerkets Havn - Denmark");
	ports.put(4635,"Kyrgyzstan - Kyrgyzstan");
	ports.put(21900,"La Barra de Rio Grande - Nicaragua");
	ports.put(27400,"La Brea - Trinidad");
	ports.put(21515,"La Ceiba - Honduras");
	ports.put(30700,"La Ceiba - Venezuela");
	ports.put(47021,"La Coruna - Spain");
	ports.put(24553,"La Fitteau - Haiti");
	ports.put(72310,"La Goulette - Tunisia");
	ports.put(30745,"La Guaira - Venezuela");
	ports.put(23944,"La Habana - Cuba");
	ports.put(23937,"La Isabela de Sagua - Cuba");
	ports.put(33136,"La Libertad - Ecuador");
	ports.put(21199,"La Libertad - El Salvador");
	ports.put(42700,"La Mailleraye - France");
	ports.put(42799,"La Nouvelle - France");
	ports.put(42733,"La Pallice - France");
	ports.put(22577,"La Palma - Panama");
	ports.put(33340,"La Pampilla - Peru");
	ports.put(20105,"La Paz - Mexico");
	ports.put(35737,"La Plata - Argentina");
	ports.put(24743,"La Romana - Dominican Republic");
	ports.put(30753,"La Salina - Venezuela");
	ports.put(47070,"La Salineta - Spain");
	ports.put(42799,"La Seyne - France");
	ports.put(42799,"La Seyne sur Mer - France");
	ports.put(72315,"La Skhira - Tunisia");
	ports.put(72315,"La Skira - Tunisia");
	ports.put(47531,"La Spezia - Italy");
	ports.put(28399,"La Trinite - Martinique");
	ports.put(21137,"La Union - El Salvador");
	ports.put(73701,"Laayoune - Western Sahara");
	ports.put(24515,"Labadee - Haiti");
	ports.put(68630,"Labasa - Fiji");
	ports.put(55717,"Labuan - Malaysia");
	ports.put(12209,"Ladysmith, BC - Canada");
	ports.put(60441,"Lae - Papua New Guinea");
	ports.put(54930,"Laem Chabang - Thailand");
	ports.put(24553,"Lafiteau - Haiti");
	ports.put(48400,"Lagos - Greece");
	ports.put(75367,"Lagos - Nigeria");
	ports.put(47100,"Lagos - Portugal");
	ports.put(22520,"Laguna de Chiriqui - Panama");
	ports.put(21900,"Laguna de Perlas - Nicaragua");
	ports.put(20157,"Laguna de Terminos - Mexico");
	ports.put(20100,"Laguna San Ignacio - Mexico");
	ports.put(30700,"Lagunillas - Venezuela");
	ports.put(55725,"Lahad Datu - Malaysia");
	ports.put(2017,"LAKE CHARLES - United States");
	ports.put(1530,"Lakeview, ONT - Canada");
	ports.put(56038,"Lalang Terminal - Indonesia");
	ports.put(68630,"Lambasa - Fiji");
	ports.put(5515,"Lambton, ONT - Canada");
	ports.put(56500,"Lamon Anchorage - Philippines");
	ports.put(5515,"Lampton, ONT - Canada");
	ports.put(77999,"Lamu, Lamu Is - Kenya");
	ports.put(3430,"LANCASTER - United States");
	ports.put(41249,"Lands End - United Kingdom");
	ports.put(40300,"Langesund - Norway");
	ports.put(40300,"Langstein - Norway");
	ports.put(40150,"Lanskrona - Sweden");
	ports.put(5530,"Laos - Laos");
	ports.put(40504,"LappajarviI - Finland");
	ports.put(40504,"Lappohja - Finland");
	ports.put(71400,"Larache - Morocco");
	ports.put(56500,"Larap Bay - Philippines");
	ports.put(2304,"LAREDO - United States");
	ports.put(49133,"Larnaca - Cyprus");
	ports.put(41800,"Larne - United Kingdom");
	ports.put(40335,"Larvik - Norway");
	ports.put(24731,"Las Calderas - Dominican Republic");
	ports.put(22565,"Las Minas Bay - Panama");
	ports.put(47071,"Las Palmas - Spain");
	ports.put(30755,"Las Piedras - Venezuela");
	ports.put(33797,"Las Salinas - Chile");
	ports.put(2722,"LAS VEGAS - United States");
	ports.put(50215,"Latakia - Syria");
	ports.put(50215,"Lattakia - Syria");
	ports.put(4490,"Latvia - Latvia");
	ports.put(60297,"Launceston - Australia");
	ports.put(1305,"LAUREL - United States");
	ports.put(3016,"LAURIER - United States");
	ports.put(68630,"Lautoka - Fiji");
	ports.put(68630,"Lautoka Harbor - Fiji");
	ports.put(50769,"Lavan Island - Iran");
	ports.put(42780,"Lavera - France");
	ports.put(56010,"Lawe Lawe Terminal - Indonesia");
	ports.put(416,"LAWRENCE - United States");
	ports.put(20107,"Lazaro Cardenas - Mexico");
	ports.put(42735,"Le Boucau - France");
	ports.put(28399,"Le Francois - Martinique");
	ports.put(42737,"Le Havre - France");
	ports.put(28399,"Le Lamentin - Martinique");
	ports.put(28399,"Le Marin - Martinique");
	ports.put(24500,"Le Mole St. Nicholas - Haiti");
	ports.put(42700,"Le Petit Quevilly - France");
	ports.put(28399,"Le Robert - Martinique");
	ports.put(42700,"Le Trait (River Seine) - France");
	ports.put(42700,"Le Treport - France");
	ports.put(42742,"Le Verdon - France");
	ports.put(3508,"Leamington, ONT - Canada");
	ports.put(56500,"Lebak - Philippines");
	ports.put(5040,"Lebanon - Lebanon");
	ports.put(181,"LEBANON AIRPORT - United States");
	ports.put(33700,"Lebu - Chile");
	ports.put(41323,"LEEDS - United Kingdom");
	ports.put(41323,"LEEDS VIA FELIXSTOWE - United Kingdom");
	ports.put(43323,"Leeds via Felixstowe - United Kingdom");
	ports.put(56542,"Legaspi - Philippines");
	ports.put(47537,"Leghorn - Italy");
	ports.put(41675,"Leith - United Kingdom");
	ports.put(47123,"Leixoes - Portugal");
	ports.put(56041,"Lembar - Indonesia");
	ports.put(23961,"Lengua de Pajaro - Cuba");
	ports.put(46215,"Leningrad - Russia");
	ports.put(24500,"Leogane - Haiti");
	ports.put(7990,"Lesotho - Lesotho");
	ports.put(30198,"Leticia - Colombia");
	ports.put(1832,"Levis, QUE - Canada");
	ports.put(68630,"Levuka - Fiji");
	ports.put(56500,"Leyte - Philippines");
	ports.put(56099,"Lhokseumawe - Indonesia");
	ports.put(56500,"Lianga - Philippines");
	ports.put(58201,"LIANHUASHAN - CHINA");
	ports.put(57025,"Lianyungang - China");
	ports.put(7650,"Liberia - Liberia");
	ports.put(75501,"Libreville - Gabon");
	ports.put(7250,"Libya - Libya");
	ports.put(47558,"Licata - Italy");
	ports.put(47595,"Lido - Italy");
	ports.put(4411,"Liechtenstein - Liechtenstein");
	ports.put(57025,"Lien Yin Chiang - China");
	ports.put(60217,"Liezen - Australia");
	ports.put(33300,"Lima - Peru");
	ports.put(49135,"Limassol - Cyprus");
	ports.put(56592,"Limay - Philippines");
	ports.put(74298,"Limbe - Cameroon");
	ports.put(74298,"Limboh Terminal - Cameroon");
	ports.put(41904,"Limerick - Ireland");
	ports.put(118,"LIMESTONE - United States");
	ports.put(40143,"Limhamn - Sweden");
	ports.put(48400,"Limin Sirou - Greece");
	ports.put(22313,"Limon - Costa Rica");
	ports.put(21519,"Limon - Honduras");
	ports.put(48400,"Limon Zakinthou - Greece");
	ports.put(31215,"Linden - Guyana");
	ports.put(78399,"Lindi - Tanzania");
	ports.put(40900,"Lindo - Denmark");
	ports.put(50700,"Lingah - Iran");
	ports.put(50700,"Lingeh - Iran");
	ports.put(47541,"Lipari - Italy");
	ports.put(33751,"Lirquen - Chile");
	ports.put(47125,"Lisboa - Portugal");
	ports.put(47125,"Lisbon - Portugal");
	ports.put(4510,"Lithuania - Lithuania");
	ports.put(6748,"Little Current, ONT - Canada");
	ports.put(13884,"Little Narrows, CBI - Canada");
	ports.put(24165,"Little Pedro Bluff - Jamaica");
	ports.put(75200,"Little Popo - Togo");
	ports.put(2003,"LITTLE ROCK,NORTH LITTLE ROCK - United States");
	ports.put(41398,"Littlehampton - United Kingdom");
	ports.put(41251,"Liverpool - United Kingdom");
	ports.put(13887,"Liverpool, NS - Canada");
	ports.put(20500,"Livingston - Guatemala");
	ports.put(47537,"Livorno - Italy");
	ports.put(40100,"Ljusne - Sweden");
	ports.put(41400,"Llanelli - United Kingdom");
	ports.put(41400,"Llanelly - United Kingdom");
	ports.put(76274,"Lobito - Angola");
	ports.put(33300,"Lobos de Afuera - Peru");
	ports.put(33300,"Lobos de Tierra - Peru");
	ports.put(62200,"Lofung - Solomon Is");
	ports.put(417,"LOGAN AIRPORT - United States");
	ports.put(40900,"Logstor - Denmark");
	ports.put(33300,"Lomas - Peru");
	ports.put(76288,"Lombo - Angola");
	ports.put(76288,"Lombo Terminal - Angola");
	ports.put(75291,"Lome - Togo");
	ports.put(41352,"London - United Kingdom");
	ports.put(41815,"Londonderry - United Kingdom");
	ports.put(24100,"Long Bay - Jamaica");
	ports.put(2709,"LONG BEACH - United States");
	ports.put(15255,"Long Harbor, NFLD - Canada");
	ports.put(23635,"Long Island - Bahamas");
	ports.put(15260,"Long Pond Manuels, NFLD - Canada");
	ports.put(24163,"Longs Wharf - Jamaica");
	ports.put(2905,"LONGVIEW - United States");
	ports.put(4121,"LORAINE - United States");
	ports.put(42743,"Lorient - France");
	ports.put(46222,"Lorino - Russia");
	ports.put(2704,"LOS ANGELES - United States");
	ports.put(2720,"LOS ANGELES INTL. AIRPORT, LAX, LOS ANGELES - United States");
	ports.put(33700,"Los Vilos - Chile");
	ports.put(33700,"Lota - Chile");
	ports.put(13437,"Louisburg, NS - Canada");
	ports.put(4115,"LOUISVILLE - United States");
	ports.put(40533,"Loviisa - Finland");
	ports.put(40533,"Lovisa - Finland");
	ports.put(1850,"LOWELL. - United States");
	ports.put(41398,"Lowestoft - United Kingdom");
	ports.put(57052,"Lu Shun - China");
	ports.put(76278,"Luanda - Angola");
	ports.put(5503,"LUBBOCK - United States");
	ports.put(24100,"Lucea - Jamaica");
	ports.put(75515,"Lucina Terminal - Gabon");
	ports.put(60200,"Lucinda - Australia");
	ports.put(57051,"Luda - China");
	ports.put(79299,"Luderitz - Namibia");
	ports.put(62201,"Luganville - Vanuatu");
	ports.put(35198,"Luis Correia - Brazil");
	ports.put(2602,"LUKEVILLE - United States");
	ports.put(40142,"Lulea - Sweden");
	ports.put(56100,"Lumut - Brunei");
	ports.put(55709,"Lumut - Malaysia");
	ports.put(13851,"Lunenburg, NS - Canada");
	ports.put(24774,"Luperon - Dominican Republic");
	ports.put(57052,"Lushun - China");
	ports.put(4239,"Luxembourg - Luxembourg");
	ports.put(3023,"LYNDEN - United States");
	ports.put(41698,"Lyness, Orkney Is - United Kingdom");
	ports.put(40300,"Lyngen - Norway");
	ports.put(40377,"Lysaker - Norway");
	ports.put(40100,"Lysekil - Sweden");
	ports.put(61415,"Lyttelton - New Zealand");
	ports.put(40372,"Maaloy - Norway");
	ports.put(54903,"Mab Ta Pud - Thailand");
	ports.put(5660,"Macao - Macao");
	ports.put(56649,"Macao - Macau");
	ports.put(35165,"Macapa - Brazil");
	ports.put(56027,"Macassar - Indonesia");
	ports.put(56649,"Macau - Macau");
	ports.put(4794,"Macedonia (Skopje) - Macedonia (Skopje)");
	ports.put(35141,"Maceio - Brazil");
	ports.put(13400,"Maces Bay, NB - Canada");
	ports.put(60204,"Mackay - Australia");
	ports.put(3820,"MACKINAC ISLAND - United States");
	ports.put(56500,"Maco - Philippines");
	ports.put(7880,"Madagascar - Madagascar");
	ports.put(60400,"Madang - Papua New Guinea");
	ports.put(109,"MADAWASKA - United States");
	ports.put(53357,"Madras - India");
	ports.put(35113,"Madre de Deus - Brazil");
	ports.put(35740,"Madryn - Argentina");
	ports.put(46232,"Magadan - Russia");
	ports.put(46232,"Magadansky - Russia");
	ports.put(56500,"Magallanes - Philippines");
	ports.put(20174,"Mahahual - Mexico");
	ports.put(78800,"Mahajanga - Madagascar");
	ports.put(53300,"Mahe - India");
	ports.put(72300,"Mahedia - Tunisia");
	ports.put(3416,"MAIDA - United States");
	ports.put(8000,"MAIL SHIPMENT - United States");
	ports.put(42700,"Mailleraye - France");
	ports.put(42899,"Mainz - Germany");
	ports.put(58848,"Maizuru - Japan");
	ports.put(58848,"Maizuru Ko - Japan");
	ports.put(47066,"Majorca - Spain");
	ports.put(78800,"Majunga - Madagascar");
	ports.put(68190,"Majuro Atoll - Marshall Is");
	ports.put(56649,"Makao - Macau");
	ports.put(56500,"Makar - Philippines");
	ports.put(56027,"Makassar - Indonesia");
	ports.put(64181,"Makatea - French Polyn");
	ports.put(58800,"Makiyama - Japan");
	ports.put(33300,"Mala - Peru");
	ports.put(73801,"Malabo - Equatorial Gui");
	ports.put(55700,"Malacca - Malaysia");
	ports.put(47076,"Malaga - Spain");
	ports.put(7970,"Malawi - Malawi");
	ports.put(5570,"Malaysia - Malaysia");
	ports.put(5683,"Maldives - Maldives");
	ports.put(56805,"Male, Male Island - Maldives");
	ports.put(35137,"Malhado - Brazil");
	ports.put(7450,"Mali - Mali");
	ports.put(56000,"Malili - Indonesia");
	ports.put(56500,"Malitbog - Philippines");
	ports.put(40143,"Malmo - Sweden");
	ports.put(76282,"Malongo Oil Terminal - Angola");
	ports.put(4730,"Malta - Malta");
	ports.put(56500,"Mambulao - Philippines");
	ports.put(30125,"Mamonal - Colombia");
	ports.put(56030,"Manado - Indonesia");
	ports.put(78800,"Manakara - Madagascar");
	ports.put(52502,"Manama - Bahrain");
	ports.put(78800,"Mananjari - Madagascar");
	ports.put(78800,"Mananjary - Madagascar");
	ports.put(78800,"Mananzhari - Madagascar");
	ports.put(23900,"Manati - Cuba");
	ports.put(35144,"Manaus - Brazil");
	ports.put(33100,"Manchala - Ecuador");
	ports.put(41253,"Manchester - United Kingdom");
	ports.put(24100,"Manchioneal - Jamaica");
	ports.put(53300,"Mandvi - India");
	ports.put(47582,"Manfredonia - Italy");
	ports.put(53343,"Mangalore - India");
	ports.put(56500,"Mangarin - Philippines");
	ports.put(33100,"Manglaralto - Ecuador");
	ports.put(61416,"Mangonui - New Zealand");
	ports.put(4601,"Manheim - United States");
	ports.put(56549,"Manila - Philippines");
	ports.put(3706,"MANITOWOC - United States");
	ports.put(23979,"Manopla - Cuba");
	ports.put(33151,"Manta - Ecuador");
	ports.put(40551,"Mantyluoto - Finland");
	ports.put(23900,"Manzanillo - Cuba");
	ports.put(24745,"Manzanillo - Dominican Republic");
	ports.put(20120,"Manzanillo - Mexico");
	ports.put(22556,"Manzanillo - Panama");
	ports.put(24745,"Manzanillo Bay - Dominican Republic");
	ports.put(54903,"Map Ta Phut - Thailand");
	ports.put(12200,"Maple Bay, BC - Canada");
	ports.put(78717,"Maputo - Mozambique");
	ports.put(35739,"Mar del Plata - Argentina");
	ports.put(30759,"Maracaibo - Venezuela");
	ports.put(48400,"Marathon - Greece");
	ports.put(9601,"Marathon, ONT - Canada");
	ports.put(23900,"Maravi - Cuba");
	ports.put(42140,"Mardejk - Netherlands");
	ports.put(56500,"Margosatubig - Philippines");
	ports.put(40500,"Mariehamn - Finland");
	ports.put(23900,"Mariel - Cuba");
	ports.put(28320,"Marigot, St. Martin - Guadeloupe");
	ports.put(47000,"Marin - Spain");
	ports.put(47528,"Marina di Carrara - Italy");
	ports.put(46276,"Mariupol - Ukraine");
	ports.put(56545,"Mariveles - Philippines");
	ports.put(1118,"MARKUS HOOK - United States");
	ports.put(53340,"Marmagao Bay - India");
	ports.put(10100,"Marmorilik - Greenland");
	ports.put(64191,"Marquesas Islands - French Polyn");
	ports.put(3809,"MARQUETTE - United States");
	ports.put(72515,"Marsa al Brega - Libya");
	ports.put(72516,"Marsa al Hariga - Libya");
	ports.put(72515,"Marsa el Brega - Libya");
	ports.put(72516,"Marsa el Hariga - Libya");
	ports.put(47558,"Marsala - Italy");
	ports.put(47306,"Marsaxlokk - Malta");
	ports.put(42782,"Marseille - France");
	ports.put(23640,"Marsh Harbour - Bahamas");
	ports.put(6810,"Marshall Islands - Marshall Islands");
	ports.put(2820,"MARTINEZ - United States");
	ports.put(2839,"Martinique - Martinique");
	ports.put(58800,"Marugame - Japan");
	ports.put(15233,"Marystown, NFLD - Canada");
	ports.put(58033,"Masan - South Korea");
	ports.put(56500,"Masao - Philippines");
	ports.put(56500,"Masbate - Philippines");
	ports.put(56554,"Maseru - Philippines");
	ports.put(56552,"Masinloc - Philippines");
	ports.put(52315,"Masirah - Oman");
	ports.put(52315,"Masirah Island - Oman");
	ports.put(1005,"MASPETH - United States");
	ports.put(77409,"Massaua - Eritrea");
	ports.put(77409,"Massawa - Eritrea");
	ports.put(704,"MASSENA - United States");
	ports.put(12210,"Masset, BC - Canada");
	ports.put(53398,"Masulipatam - India");
	ports.put(76637,"Matadi - Congo Kinshasha");
	ports.put(23900,"Matahambre - Cuba");
	ports.put(20195,"Matamoros - Mexico");
	ports.put(14070,"Matane, QUE - Canada");
	ports.put(23900,"Matanzas - Cuba");
	ports.put(30760,"Matanzas - Venezuela");
	ports.put(33354,"Matarani - Peru");
	ports.put(64131,"Mata-Utu, Futuna - Wallis");
	ports.put(52325,"Matrah - Oman");
	ports.put(58800,"Matsue - Japan");
	ports.put(58847,"Matsunaga - Japan");
	ports.put(58806,"Matsushima - Japan");
	ports.put(58800,"Matsuura - Japan");
	ports.put(58849,"Matsuyama - Japan");
	ports.put(23653,"Matthew Town - Bahamas");
	ports.put(56500,"Mauban - Philippines");
	ports.put(7410,"Mauritania - Mauritania");
	ports.put(7850,"Mauritius - Mauritius");
	ports.put(23600,"Mayaguana Island - Bahamas");
	ports.put(4907,"MAYAGUEZ - United States");
	ports.put(23900,"Mayari - Cuba");
	ports.put(7881,"Mayotte - Mayotte");
	ports.put(71400,"Mazagan - Morocco");
	ports.put(20122,"Mazatlan - Mexico");
	ports.put(12200,"McBride Bay, BC - Canada");
	ports.put(31235,"McKenzie - Guyana");
	ports.put(23900,"Media Luna - Cuba");
	ports.put(56500,"Medina - Philippines");
	ports.put(48454,"Megara - Greece");
	ports.put(33700,"Mejillones del Sur - Chile");
	ports.put(55700,"Melaka - Malaysia");
	ports.put(60237,"Melbourne - Australia");
	ports.put(1885,"MELBOURNE REGIONAL AIRPORT - United States");
	ports.put(6766,"Meldrum Bay - Canada");
	ports.put(47095,"Melilla - Spain");
	ports.put(40300,"Melo - Norway");
	ports.put(40300,"Meloy - Norway");
	ports.put(503,"MELVILLE - United States");
	ports.put(40100,"Mem - Sweden");
	ports.put(45101,"Memel - Lithuania");
	ports.put(2006,"MEMPHIS - United States");
	ports.put(72300,"Menzel Bourguiba - Tunisia");
	ports.put(56039,"Merak - Indonesia");
	ports.put(56500,"Mercedes - Philippines");
	ports.put(72100,"Mers El Kebir - Algeria");
	ports.put(72906,"Mersa el Hamra - Egypt");
	ports.put(48938,"Mersin - Turkey");
	ports.put(47558,"Messina - Italy");
	ports.put(10100,"Mesters Vig - Greenland");
	ports.put(10100,"Mestersvig - Greenland");
	ports.put(72100,"Mestghanem - Algeria");
	ports.put(3025,"METALINE FALLS - United States");
	ports.put(13870,"Meteghan, NS - Canada");
	ports.put(41698,"Methil - United Kingdom");
	ports.put(2010,"Mexico - Mexico");
	ports.put(5201,"MIAMI - United States");
	ports.put(5206,"MIAMI INTL. AIRPORT,MIAMI - United States");
	ports.put(9555,"Michipicoten Harbor, ONT - Canada");
	ports.put(9555,"Michipicoten, ONT. - Canada");
	ports.put(42100,"Middelburg - Netherlands");
	ports.put(42100,"Middleburg - Netherlands");
	ports.put(41355,"Middlesbrough - United Kingdom");
	ports.put(5582,"MIDLAND INTERNATIONAL AIRPORT - United States");
	ports.put(58800,"Mihara - Japan");
	ports.put(58851,"Miike - Japan");
	ports.put(78399,"Mikindani - Tanzania");
	ports.put(48460,"Mikonos - Greece");
	ports.put(48449,"Milaki - Greece");
	ports.put(47550,"Milazzo - Italy");
	ports.put(41446,"Milford Haven - United Kingdom");
	ports.put(92013,"Military-Al Zubair - Iraq");
	ports.put(92017,"Military-Aschaffenburg - Germany");
	ports.put(92006,"Military-Bass River Terminal - Nigeria");
	ports.put(92005,"Military-Escravos - Nigeria");
	ports.put(92004,"Military-Germersheim - Germany");
	ports.put(92008,"Military-Guangzhou - China");
	ports.put(92007,"Military-Hsinhaing - China");
	ports.put(92012,"Military-Kajang - Malaysia");
	ports.put(92003,"Military-Mannheim - Germany");
	ports.put(92018,"Military-Mina Qaboos - Oman");
	ports.put(92019,"Military-Muscat - Oman");
	ports.put(92015,"Military-Mykolayiv - Ukraine");
	ports.put(92002,"Military-Naha - Japan");
	ports.put(92014,"Military-Oktyabrsk - Ukraine");
	ports.put(92011,"Military-Port Kelang - Malaysia");
	ports.put(92010,"Military-Quingdao - China");
	ports.put(92016,"Military-Sfax - Tunisia");
	ports.put(92009,"Military-Tainjin - China");
	ports.put(92001,"Military-Yokohama - Japan");
	ports.put(60200,"Milner Bay - Australia");
	ports.put(48468,"Milos Island - Greece");
	ports.put(1303,"Milroy - United States");
	ports.put(1303,"MILROY , B - United States");
	ports.put(1001,"Milton, PA - United States");
	ports.put(3701,"MILWAUKEE - United States");
	ports.put(52320,"Mina Abd Fahl - Oman");
	ports.put(51323,"Mina al Ahmadi - Kuwait");
	ports.put(50505,"Mina al Bakr - Iraq");
	ports.put(52320,"Mina al Fahal - Oman");
	ports.put(72912,"Mina Dumyat - Egypt");
	ports.put(52070,"Mina Khalid - United Arab Em");
	ports.put(52325,"Mina Qaboos - Oman");
	ports.put(52325,"Mina Qabus - Oman");
	ports.put(52330,"Mina Raysut - Oman");
	ports.put(52000,"Mina Saqr - United Arab Em");
	ports.put(51330,"Mina Saud - Kuwait");
	ports.put(52501,"Mina Sulman - Bahrain");
	ports.put(51330,"Mina Suud - Kuwait");
	ports.put(52001,"Mina Zayed - United Arab Em");
	ports.put(58850,"Minamata - Japan");
	ports.put(23900,"Minas de Matahambre - Cuba");
	ports.put(20181,"Minatitlan - Mexico");
	ports.put(76465,"Mindelo - Cape Verde");
	ports.put(22500,"Mindi Dyke - Panama");
	ports.put(3501,"MINNEAPOLIS, ST.PAUL - United States");
	ports.put(1001,"Minnesota - United States");
	ports.put(001,"MINSK - BELARUS");
	ports.put(44911,"Minsk - Belarus");
	ports.put(45101,"Minsk - Belarus");
	ports.put(22599,"Miraflores Locks - Panama");
	ports.put(24559,"Miragoane - Haiti");
	ports.put(55731,"Miri - Malaysia");
	ports.put(58866,"Misaki - Japan");
	ports.put(56556,"Misamis - Philippines");
	ports.put(58812,"Mishima - Japan");
	ports.put(12490,"Mission, BC - Canada");
	ports.put(1530,"Mississauga, ONT - Canada");
	ports.put(41398,"Mistley - United Kingdom");
	ports.put(58852,"Misumi - Japan");
	ports.put(72500,"MISURATA - LIBYA");
	ports.put(58800,"Mitajiri - Japan");
	ports.put(8530,"Mitchell Bay, ONT - Canada");
	ports.put(48462,"Mitilini - Greece");
	ports.put(77409,"Mitsiwa - Eritrea");
	ports.put(48462,"Mitylene - Greece");
	ports.put(58853,"Miya Ko - Japan");
	ports.put(58853,"Miyako - Japan");
	ports.put(58853,"Miyako Ko - Japan");
	ports.put(58854,"Mizushima - Japan");
	ports.put(58854,"Mizusima - Japan");
	ports.put(40370,"Mo i Rana - Norway");
	ports.put(23900,"Moa - Cuba");
	ports.put(76639,"Moanda Terminal - Congo Kinshasha");
	ports.put(1901,"MOBILE - United States");
	ports.put(52125,"Mocha - Yemen");
	ports.put(78700,"Mocimboa de Praia - Mozambique");
	ports.put(31501,"Moengo - Suriname");
	ports.put(42119,"Moerdjik - Netherlands");
	ports.put(77051,"Mogadiscio - Somalia");
	ports.put(77051,"Mogadishu - Somalia");
	ports.put(71400,"Mogador - Morocco");
	ports.put(58835,"Mogi - Japan");
	ports.put(58035,"Mogpo - South Korea");
	ports.put(71418,"Mohammedia - Morocco");
	ports.put(22315,"Moin - Costa Rica");
	ports.put(58835,"Moji - Japan");
	ports.put(52125,"Mokha - Yemen");
	ports.put(58035,"Mokpo - South Korea");
	ports.put(4641,"Moldova - Moldova");
	ports.put(40300,"Moldtustranda - Norway");
	ports.put(47598,"Molfetta - Italy");
	ports.put(33355,"Mollendo - Peru");
	ports.put(47598,"Molo di Bari - Italy");
	ports.put(46200,"Molotovsk - Russia");
	ports.put(77913,"Mombasa - Kenya");
	ports.put(4272,"Monaco - Monaco");
	ports.put(41915,"Money Point - Ireland");
	ports.put(41915,"Moneypoint - Ireland");
	ports.put(47588,"Monfalcone - Italy");
	ports.put(53800,"Mongla - Bangladesh");
	ports.put(5740,"Mongolia - Mongolia");
	ports.put(40373,"Mongstad - Norway");
	ports.put(47598,"Monopoli - Italy");
	ports.put(76529,"Monrovia - Liberia");
	ports.put(14021,"Mont Louis, QUE - Canada");
	ports.put(60440,"Montagu - Papua New Guinea");
	ports.put(14472,"Montague, PEI - Canada");
	ports.put(42797,"Monte Carlo - Monaco");
	ports.put(24700,"Monte Cristi - Dominican Republic");
	ports.put(24145,"Montego Bay - Jamaica");
	ports.put(2805,"MONTEREY - United States");
	ports.put(35525,"Montevideo - Uruguay");
	ports.put(42745,"Montoir - France");
	ports.put(1822,"Montreal - United States");
	ports.put(1822,"Montreal, QUE - Canada");
	ports.put(41681,"Montrose - United Kingdom");
	ports.put(2485,"Montserrat - Montserrat");
	ports.put(24100,"Morant Bay - Jamaica");
	ports.put(3319,"MORGAN - United States");
	ports.put(2001,"MORGAN CITY - United States");
	ports.put(42700,"Morlaix - France");
	ports.put(53340,"Mormugao - India");
	ports.put(7140,"Morocco - Morocco");
	ports.put(78800,"Morombe - Madagascar");
	ports.put(30758,"Moron - Venezuela");
	ports.put(78800,"Morondava - Madagascar");
	ports.put(78900,"Moroni - Comoros");
	ports.put(56064,"Morotai - Indonesia");
	ports.put(1696,"Morrisburg,ONT - Canada");
	ports.put(4681,"MORRISTOWN AIRPORT, NEWARK - United States");
	ports.put(2719,"MORRO - United States");
	ports.put(20104,"Morro Redondo - Mexico");
	ports.put(0001,"Moscow - Russia");
	ports.put(40549,"MOSCOW - RUSSIA");
	ports.put(45101,"Moscow - Russia");
	ports.put(45101,"Moscow - Russia");
	ports.put(47017,"Mosel - Spain");
	ports.put(40371,"Moss - Norway");
	ports.put(79100,"Mossel Baai - South Africa");
	ports.put(79100,"Mossel Bay - South Africa");
	ports.put(35198,"Mossoro - Brazil");
	ports.put(72100,"Mostaganem - Algeria");
	ports.put(47077,"Motril - Spain");
	ports.put(74296,"Moudi Terminal - Cameroon");
	ports.put(61416,"Mount Maunganui - New Zealand");
	ports.put(60239,"Mourilyan Harbour - Australia");
	ports.put(41900,"Moville - Ireland");
	ports.put(7870,"Mozambique - Mozambique");
	ports.put(78725,"Mozambique Island - Mozambique");
	ports.put(78399,"Mtwara - Tanzania");
	ports.put(56151,"Muara Port - Brunei");
	ports.put(52000,"Mubarek Terminal - United Arab Em");
	ports.put(52000,"Mubarras Island - United Arab Em");
	ports.put(35133,"Mucuripe - Brazil");
	ports.put(48951,"Mudania - Turkey");
	ports.put(48951,"Mudanya - Turkey");
	ports.put(52100,"Mukalla - Yemen");
	ports.put(13436,"Mulgrave, NS - Canada");
	ports.put(53312,"Mumbai - India");
	ports.put(4112,"Muncie - United States");
	ports.put(62200,"Munda - Solomon Is");
	ports.put(53306,"Mundra - India");
	ports.put(53800,"Mungla Anchorage - Bangladesh");
	ports.put(35164,"Munguba - Brazil");
	ports.put(40100,"Munksund - Sweden");
	ports.put(56003,"Muntok - Indonesia");
	ports.put(77051,"Muqdisho - Somalia");
	ports.put(20010,"Murfreesbo - United States");
	ports.put(46209,"Murmansk - Russia");
	ports.put(58855,"Muroran - Japan");
	ports.put(51825,"Musayid - Qatar");
	ports.put(52325,"Muscat - Oman");
	ports.put(3815,"MUSKEGON - United States");
	ports.put(52325,"Musqat - Oman");
	ports.put(78900,"Mutsamudu - Comoros");
	ports.put(58861,"Mutsui - Japan");
	ports.put(44702,"Muuga - Estonia");
	ports.put(48460,"Mykonos - Greece");
	ports.put(48449,"Mylaki - Greece");
	ports.put(48462,"Mytilini - Greece");
	ports.put(40552,"Naantali - Finland");
	ports.put(78735,"Nacala - Mozambique");
	ports.put(2603,"NACO - United States");
	ports.put(71417,"Nador - Morocco");
	ports.put(56500,"Naga - Philippines");
	ports.put(53398,"Nagapattinam - India");
	ports.put(58856,"Nagasaki - Japan");
	ports.put(46239,"Nagayeva - Russia");
	ports.put(58857,"Nagoya - Japan");
	ports.put(58857,"Nagoya Ko - Japan");
	ports.put(58860,"Naha - Japan");
	ports.put(58860,"Nakagusku Wan - Japan");
	ports.put(68630,"Nakama - Fiji");
	ports.put(46230,"Nakhodka - Russia");
	ports.put(40922,"Nakskov - Denmark");
	ports.put(56500,"Nalunga Island - Philippines");
	ports.put(76279,"Namibe - Angola");
	ports.put(7920,"Namibia - Namibia");
	ports.put(40300,"Namsos - Norway");
	ports.put(57014,"Nan Ching - China");
	ports.put(12406,"Nanaimo, BC - Canada");
	ports.put(58800,"Nanao - Japan");
	ports.put(57014,"Nanjing - China");
	ports.put(57014,"Nanking - China");
	ports.put(57018,"NANSHA - China");
	ports.put(57018,"NANSHA - China");
	ports.put(42749,"Nantes - France");
	ports.put(6645,"Nanticoke, ONT - Canada");
	ports.put(57074,"Nantong - China");
	ports.put(58892,"Naoetsu - Japan");
	ports.put(58892,"Naoetu - Japan");
	ports.put(61419,"Napier - New Zealand");
	ports.put(47507,"Naples - Italy");
	ports.put(47507,"Napoli - Italy");
	ports.put(54900,"Narathiwat - Thailand");
	ports.put(54900,"Naratives - Thailand");
	ports.put(10100,"Narsarssuak - Greenland");
	ports.put(10100,"Narssarssuaq - Greenland");
	ports.put(40337,"Narvik - Norway");
	ports.put(2007,"NASHVILLE - United States");
	ports.put(3901,"NASHVILLE - United States");
	ports.put(56500,"Nasipit - Philippines");
	ports.put(242,"NASSAU - BAHAMAS");
	ports.put(242,"NASSAU - BAHAMAS");
	ports.put(23661,"Nassau, New Providence I - Bahamas");
	ports.put(56500,"Nasugbu - Philippines");
	ports.put(35157,"Natal - Brazil");
	ports.put(3382,"NATRONA COUNTY INTL. AIRPORT - United States");
	ports.put(48400,"Nauplia - Greece");
	ports.put(6862,"Nauru - Nauru");
	ports.put(68651,"Nauru - Nauru");
	ports.put(20195,"Nautla - Mexico");
	ports.put(53313,"Nava Sheva - India");
	ports.put(53300,"Navlakhi - India");
	ports.put(48400,"Navplion - Greece");
	ports.put(3204,"NAWILIWILI-PORT ALLEN - United States");
	ports.put(48400,"Naxos - Greece");
	ports.put(48400,"Nea Palatia - Greece");
	ports.put(3027,"NEAH BAY - United States");
	ports.put(41486,"Neath - United Kingdom");
	ports.put(3404,"NECHE - United States");
	ports.put(35741,"Necochea - Argentina");
	ports.put(40100,"Nederkalix - Sweden");
	ports.put(53398,"Negapatam - India");
	ports.put(24100,"Negril Harbor - Jamaica");
	ports.put(68682,"Neiafu - Tonga");
	ports.put(61406,"Nelson - New Zealand");
	ports.put(72142,"Nemours - Algeria");
	ports.put(48915,"Nemrut Bay - Turkey");
	ports.put(48400,"Neo Kastro - Greece");
	ports.put(48400,"Neokastron - Greece");
	ports.put(5360,"Nepal - Nepal");
	ports.put(40036,"Neskaupstadur - Iceland");
	ports.put(4210,"Netherlands - Netherlands");
	ports.put(2771,"Netherlands Antilles - Netherlands Antilles");
	ports.put(45500,"Neufahrwasser - Poland");
	ports.put(31202,"New Amsterdam - Guyana");
	ports.put(405,"NEW BEDFORD - United States");
	ports.put(6412,"New Caledonia - New Caledonia");
	ports.put(4601,"NEW CASTLE - United States");
	ports.put(412,"NEW HAVEN - United States");
	ports.put(413,"NEW LONDON - United States");
	ports.put(53343,"New Mangalore - India");
	ports.put(2002,"NEW ORLEANS - United States");
	ports.put(61423,"New Plymouth - New Zealand");
	ports.put(41900,"New Ross - Ireland");
	ports.put(53395,"New Tuticorin - India");
	ports.put(12408,"New Westminster, BC - Canada");
	ports.put(1001,"NEW YORK - United States");
	ports.put(6141,"New Zealand - New Zealand");
	ports.put(4601,"NEWARK - United States");
	ports.put(0002,"Newark - United States of Ame");
	ports.put(60240,"Newcastle - Australia");
	ports.put(41356,"Newcastle on Tyne - United Kingdom");
	ports.put(14037,"Newcastle, NB - Canada");
	ports.put(57000,"Newchang - China");
	ports.put(57000,"Newchwang - China");
	ports.put(41357,"Newhaven - United Kingdom");
	ports.put(41258,"Newport - United Kingdom");
	ports.put(41488,"Newport - United Kingdom");
	ports.put(501,"NEWPORT - United States");
	ports.put(2902,"NEWPORT - United States");
	ports.put(1402,"NEWPORT NEWS - United States");
	ports.put(55208,"Nha Trang - Vietnam");
	ports.put(53313,"Nhava Sheva - India");
	ports.put(2190,"Nicaragua - Nicaragua");
	ports.put(23961,"Nicaro - Cuba");
	ports.put(42786,"Nice - France");
	ports.put(31500,"Nieuw Nickerie - Suriname");
	ports.put(7510,"Niger - Niger");
	ports.put(7530,"Nigeria - Nigeria");
	ports.put(41685,"Nigg Bay - United Kingdom");
	ports.put(3011,"NIGHTHAWK - United States");
	ports.put(23900,"Niguero - Cuba");
	ports.put(58859,"Niigata - Japan");
	ports.put(58858,"Niihama - Japan");
	ports.put(48405,"Nikola - Greece");
	ports.put(40500,"Nikolaistad - Finland");
	ports.put(46279,"Nikolayev - Ukraine");
	ports.put(46239,"Nikolayevsk-Na-Amur - Russia");
	ports.put(57020,"Ning Bo - China");
	ports.put(57020,"Ningpo - China");
	ports.put(3991,"NIPPON COURIER HUB - United States");
	ports.put(35171,"Niteroi - Brazil");
	ports.put(6144,"Niue - Niue");
	ports.put(61481,"Niue Island - Niue");
	ports.put(44911,"NIZHNEVARTOVSK - RUSSIA");
	ports.put(40010,"Njardvik - Iceland");
	ports.put(2604,"NOGALES - United States");
	ports.put(46239,"Nogayevo - Russia");
	ports.put(22500,"Nombre de Dios - Panama");
	ports.put(56500,"Nonoc Island - Philippines");
	ports.put(3420,"NOONAN - United States");
	ports.put(12200,"Nootka, BC - Canada");
	ports.put(42883,"Nordenham - Germany");
	ports.put(1401,"NORFOLK - United States");
	ports.put(4601,"Norfolk - United States");
	ports.put(6022,"Norfolk Island - Norfolk Island");
	ports.put(40100,"Norrbyskar - Sweden");
	ports.put(40956,"Norresundby - Denmark");
	ports.put(40148,"Norrkoping - Sweden");
	ports.put(40149,"Norrsundet - Sweden");
	ports.put(41398,"North & South Shields - United Kingdom");
	ports.put(46239,"North Cape - Russia");
	ports.put(5790,"North Korea - North Korea");
	ports.put(13853,"North Sydney, NS - Canada");
	ports.put(41377,"North Tees - United Kingdom");
	ports.put(9610,"Northern Mariana Islands - Northern Mariana Islands");
	ports.put(3406,"NORTHGATE - United States");
	ports.put(211,"NORTON - United States");
	ports.put(4039,"Norway - Norway");
	ports.put(58800,"Noshiro - Japan");
	ports.put(78800,"Nossi Be - Madagascar");
	ports.put(78800,"Nosy Be - Madagascar");
	ports.put(74165,"Nouadhibou - Mauritania");
	ports.put(74100,"Nouakchott - Mauritania");
	ports.put(64109,"Noumea - New Caledonia");
	ports.put(47905,"Novigrad - Croatia");
	ports.put(76299,"Novo Redondo - Angola");
	ports.put(45101,"NOVOPOLOTSK - BELARUS");
	ports.put(46241,"Novorossiysk - Russia");
	ports.put(44701,"Novosibirsk - RU");
	ports.put(44911,"Novosibirsk - Russia");
	ports.put(45101,"Novosibirsk - Russia");
	ports.put(45500,"Nowy Port - Poland");
	ports.put(3402,"NOYES - United States");
	ports.put(35535,"Nueva Palmira - Uruguay");
	ports.put(23900,"Nuevitas - Cuba");
	ports.put(68682,"Nukualofa - Tonga");
	ports.put(1001,"NY PORT - United States");
	ports.put(1071,"NYACC - United States");
	ports.put(4771,"NYACC, JAMAICA - United States");
	ports.put(40923,"Nyborg - Denmark");
	ports.put(40924,"Nykobing - Denmark");
	ports.put(40100,"Nynashamn - Sweden");
	ports.put(40537,"Nystad - Finland");
	ports.put(12498,"Oak Bay, BC - Canada");
	ports.put(41358,"Oakham Ness - United Kingdom");
	ports.put(2811,"OAKLAND - United States");
	ports.put(3881,"OAKLAND PONTIAC AIRPORT - United States");
	ports.put(6770,"Oakville, ONT - Canada");
	ports.put(40153,"Obbola - Sweden");
	ports.put(35158,"Obidos - Brazil");
	ports.put(47912,"Obrovac - Croatia");
	ports.put(1886,"OCALA REGIONAL AIRPORT - United States");
	ports.put(23665,"Ocean Cay - Bahamas");
	ports.put(24155,"Ocho Rios - Jamaica");
	ports.put(40300,"Odda - Norway");
	ports.put(40300,"Odde - Norway");
	ports.put(40961,"Odense - Denmark");
	ports.put(46275,"Odessa - Ukraine");
	ports.put(56500,"Odiongan - Philippines");
	ports.put(58863,"Ofunato - Japan");
	ports.put(58800,"Ogasawara-Gunto - Japan");
	ports.put(701,"OGDENSBURG - United States");
	ports.put(75517,"Oguendjo Terminal - Gabon");
	ports.put(58800,"Oh - Japan");
	ports.put(27210,"Oistino - Barbados");
	ports.put(58805,"Oita - Japan");
	ports.put(3510,"Ojibway, ONT - Canada");
	ports.put(46239,"Okha - Russia");
	ports.put(58860,"Okinawa Island - Japan");
	ports.put(5504,"OKLAHOMA CITY - United States");
	ports.put(58034,"Okpo - South Korea");
	ports.put(75385,"Okrika - Nigeria");
	ports.put(47569,"Olbia - Italy");
	ports.put(41600,"Old Kilpatrick - United Kingdom");
	ports.put(47100,"Olhao - Portugal");
	ports.put(1601,"Olive Bran - United States");
	ports.put(56585,"Olongapo - Philippines");
	ports.put(56500,"Olutanga Island - Philippines");
	ports.put(3026,"OLYMPIA - United States");
	ports.put(3903,"OMAHA - United States");
	ports.put(58800,"Omakezaki - Japan");
	ports.put(5230,"Oman - Oman");
	ports.put(58800,"Ominato - Japan");
	ports.put(47998,"Omisalj - Croatia");
	ports.put(40520,"Omsk - Russia");
	ports.put(40549,"Omsk - Russia");
	ports.put(40549,"Omsk - Russia");
	ports.put(44911,"Omsk - Russia");
	ports.put(45101,"Omsk - Russia");
	ports.put(58865,"Onagawa - Japan");
	ports.put(58864,"Onahama - Japan");
	ports.put(58864,"Onahama Ko - Japan");
	ports.put(75385,"Onne - Nigeria");
	ports.put(58800,"Onomichi - Japan");
	ports.put(58061,"Onsan - South Korea");
	ports.put(57910,"Onsong - North Korea");
	ports.put(2721,"ONTARIO INT L AIRPORT - United States");
	ports.put(3317,"OPHEIM - United States");
	ports.put(75300,"Opobo - Nigeria");
	ports.put(47133,"Oporto - Portugal");
	ports.put(61400,"Opua - New Zealand");
	ports.put(24100,"Oracabessa - Jamaica");
	ports.put(72179,"Oran - Algeria");
	ports.put(2103,"ORANGE - United States");
	ports.put(27701,"Orangestad - Aruba");
	ports.put(27701,"Oranjestad - Aruba");
	ports.put(47565,"Oristano - Italy");
	ports.put(35198,"Oriximina - Brazil");
	ports.put(1808,"ORLANDO - United States");
	ports.put(1809,"ORLANDO-SANFORD AIRPORT - United States");
	ports.put(48405,"Ormos Ayiou Nikolaou - Greece");
	ports.put(48400,"Ormos Limnis - Greece");
	ports.put(48400,"Ormos Navarinou - Greece");
	ports.put(50700,"Ormuz - Iran");
	ports.put(40155,"Ornskoldsvik - Sweden");
	ports.put(56500,"Oroquieta - Philippines");
	ports.put(3019,"OROVILLE - United States");
	ports.put(40100,"Ortviken - Sweden");
	ports.put(40100,"Orviken - Sweden");
	ports.put(58866,"Osaka - Japan");
	ports.put(9670,"Oshawa, ONT - Canada");
	ports.put(40157,"Oskarshamn - Sweden");
	ports.put(40377,"Oslo - Norway");
	ports.put(42351,"Ostend - Belgium");
	ports.put(42899,"Ostermoor - Germany");
	ports.put(20171,"Ostion - Mexico");
	ports.put(40100,"Ostrand - Sweden");
	ports.put(904,"OSWEGO - United States");
	ports.put(61407,"Otago Harbor - New Zealand");
	ports.put(58867,"Otaru - Japan");
	ports.put(2506,"OTAY MESA STATION - United States");
	ports.put(20800,"Other Belize Ports - Belize");
	ports.put(7238,"Ottawa, ONT - Canada");
	ports.put(9554,"Otter Island, ONT - Canada");
	ports.put(40100,"Otterbacken - Sweden");
	ports.put(40531,"Ouleborg - Finland");
	ports.put(40531,"Oulu - Finland");
	ports.put(68630,"Ovalau Island - Fiji");
	ports.put(6768,"Owen Sound, ONT - Canada");
	ports.put(75521,"Owendo - Gabon");
	ports.put(4116,"OWENSBORO,KY-EVANSVILLE - United States");
	ports.put(40159,"Oxelosund - Sweden");
	ports.put(27701,"Paarden Baai - Aruba");
	ports.put(27701,"Paarden Bay - Aruba");
	ports.put(33700,"Pabellon - Chile");
	ports.put(33300,"Pacasmayo - Peru");
	ports.put(56081,"Padang - Indonesia");
	ports.put(95101,"Pago Pago Harbor - American Samoa");
	ports.put(33363,"Paita - Peru");
	ports.put(20184,"Pajaritos - Mexico");
	ports.put(57076,"Pakho - China");
	ports.put(57076,"Pakhoi - China");
	ports.put(5350,"Pakistan - Pakistan");
	ports.put(47065,"Palamos - Spain");
	ports.put(76283,"Palanca Terminal - Angola");
	ports.put(6830,"Palau - Palau");
	ports.put(44700,"PALDISKI - Estonia");
	ports.put(56083,"Palembang - Indonesia");
	ports.put(24700,"Palenque - Dominican Republic");
	ports.put(47551,"Palermo - Italy");
	ports.put(62207,"Palikulo - Vanuatu");
	ports.put(47066,"Palma de Majorca - Spain");
	ports.put(23900,"Palo Alto - Cuba");
	ports.put(56045,"Palu - Indonesia");
	ports.put(30761,"Palua - Venezuela");
	ports.put(56500,"Pambujan Sur - Philippines");
	ports.put(30700,"Pampatar - Venezuela");
	ports.put(56500,"Panagan - Philippines");
	ports.put(2250,"Panama - Panama");
	ports.put(22519,"Panama Canal - Caribbean - Panama");
	ports.put(22579,"Panama Canal- Pacific - Panama");
	ports.put(22579,"Panama City - Panama");
	ports.put(1818,"PANAMA CITY - United States");
	ports.put(56043,"Panarukan - Indonesia");
	ports.put(48963,"Panderma - Turkey");
	ports.put(56097,"Pandjang - Indonesia");
	ports.put(68682,"Pangai - Tonga");
	ports.put(78399,"Pangani - Tanzania");
	ports.put(56004,"Pangkal Balam - Indonesia");
	ports.put(56085,"Pangkalan Brandan - Indonesia");
	ports.put(56085,"Pangkalan Susu - Indonesia");
	ports.put(56004,"Pangkalpinang - Indonesia");
	ports.put(56004,"Pangkol - Indonesia");
	ports.put(56045,"Pantoloan - Indonesia");
	ports.put(64151,"Papeete, Tahiti - French Polyn");
	ports.put(6040,"Papua New Guinea - Papua New Guinea");
	ports.put(33700,"Papudo - Chile");
	ports.put(35121,"Para - Brazil");
	ports.put(33300,"Paracas Bay - Peru");
	ports.put(53371,"Paradip - India");
	ports.put(3530,"Paraguay - Paraguay");
	ports.put(22599,"Paraiso - Panama");
	ports.put(31523,"Paramaribo - Suriname");
	ports.put(33300,"Paramonga - Peru");
	ports.put(35159,"Paranagua - Brazil");
	ports.put(31524,"Paranam - Suriname");
	ports.put(24831,"Parham Harbour, Antigua - Antigua");
	ports.put(22599,"Parida Island - Panama");
	ports.put(42737,"Paris - France");
	ports.put(22525,"Parita - Panama");
	ports.put(35163,"Parnahyba - Brazil");
	ports.put(35163,"Parnaiba - Brazil");
	ports.put(48400,"Paros - Greece");
	ports.put(6697,"Parry Sound, ONT - Canada");
	ports.put(47027,"Pasages - Spain");
	ports.put(47027,"Pasajes - Spain");
	ports.put(1903,"PASCAGOULA - United States");
	ports.put(55707,"Pasir Gudang - Malaysia");
	ports.put(56058,"Pasuruan - Indonesia");
	ports.put(54900,"Patani - Thailand");
	ports.put(40500,"Pateniemi - Finland");
	ports.put(33765,"Patillos - Chile");
	ports.put(48451,"Patrai - Greece");
	ports.put(48451,"Patras - Greece");
	ports.put(54900,"Pattani - Thailand");
	ports.put(42751,"Pauillac - France");
	ports.put(1105,"PAULSBORO - United States");
	ports.put(44911,"PAVLODAR - KAZAKHSTAN");
	ports.put(45101,"Pavlodar - KAZAKHSTAN");
	ports.put(5700,"PAVLODAR - KAZAKHSTAN");
	ports.put(22565,"Payardi - Panama");
	ports.put(35500,"Paysandu - Uruguay");
	ports.put(21900,"Pearl City - Nicaragua");
	ports.put(22599,"Pearl Islands - Panama");
	ports.put(78700,"Pebane - Mozambique");
	ports.put(35120,"Pecem - Brazil");
	ports.put(22582,"Pedregal - Panama");
	ports.put(57000,"Pei hai Anchorage - China");
	ports.put(56058,"Pekalongan - Indonesia");
	ports.put(3507,"Pelee Island, ONT - Canada");
	ports.put(3124,"PELICAN - United States");
	ports.put(35199,"Pelotas - Brazil");
	ports.put(78399,"Pemba Island - Tanzania");
	ports.put(3401,"PEMBINA - United States");
	ports.put(41465,"Pembroke - United Kingdom");
	ports.put(1001,"PEMBROKE - United States");
	ports.put(1001,"Pembroke - United States");
	ports.put(33700,"Pena Blanca - Chile");
	ports.put(55735,"Penang - Malaysia");
	ports.put(41400,"Penarth - United Kingdom");
	ports.put(33782,"Penco - Chile");
	ports.put(75380,"Pennington - Nigeria");
	ports.put(75380,"Pennington Terminal - Nigeria");
	ports.put(61460,"Penrhyn - New Zealand");
	ports.put(61460,"Penryn - New Zealand");
	ports.put(1819,"PENSACOLA - United States");
	ports.put(41398,"Penzance - United Kingdom");
	ports.put(3902,"PEORIA - United States");
	ports.put(74799,"Pepel - Sierra Leone");
	ports.put(24745,"Pepillo Salcedo - Dominican Republic");
	ports.put(52100,"Perim Island - Yemen");
	ports.put(35169,"Pernambuco - Brazil");
	ports.put(42151,"Pernis - Netherlands");
	ports.put(60243,"Perth - Australia");
	ports.put(41698,"Perth - United Kingdom");
	ports.put(4602,"PERTH AMBOY - United States");
	ports.put(30775,"Pertigalete - Venezuela");
	ports.put(3330,"Peru - Peru");
	ports.put(33300,"Peruvian Whaling Grounds - Peru");
	ports.put(41640,"Peterhead - United Kingdom");
	ports.put(3112,"PETERSBURG - United States");
	ports.put(42700,"Petit Couronne - France");
	ports.put(24571,"Petit Goave - Haiti");
	ports.put(42700,"Petit Quevilly - France");
	ports.put(44911,"PETROPAVLOVSK - KAZAKHSTAN");
	ports.put(46233,"Petropavlovsk - Russia");
	ports.put(46233,"Petropavlovsk-Kamchatskiy - Russia");
	ports.put(30743,"Petrozuata - Venezuela");
	ports.put(46239,"Pevek - Russia");
	ports.put(1101,"PHILADELPHIA - United States");
	ports.put(1108,"PHILADELPHIA INTL. AIRPORT - United States");
	ports.put(5650,"Philippines - Philippines");
	ports.put(27726,"Philipsborough - Neth Antilles");
	ports.put(27726,"Philipsburgh - Neth Antilles");
	ports.put(55500,"Phnom Pehn - Cambodia");
	ports.put(55500,"Phnom Penh - Cambodia");
	ports.put(2605,"PHOENIX - United States");
	ports.put(54902,"Phuket - Thailand");
	ports.put(61400,"Picton - New Zealand");
	ports.put(1652,"Picton, ONT - Canada");
	ports.put(13854,"Pictou, NS - Canada");
	ports.put(3316,"PIEGAN - United States");
	ports.put(40500,"Pietarsaari - Finland");
	ports.put(23900,"Pilon Harbor - Cuba");
	ports.put(48463,"Pilos - Greece");
	ports.put(33371,"Pimentel - Peru");
	ports.put(56500,"Pinamalayan - Philippines");
	ports.put(55735,"Pinang - Malaysia");
	ports.put(3425,"PINECREEK - United States");
	ports.put(1601,"PINEVILLE - United States");
	ports.put(45101,"PINSK - Belarus");
	ports.put(47515,"Piombino - Italy");
	ports.put(48452,"Piraeus - Greece");
	ports.put(48452,"Piraieus - Greece");
	ports.put(48452,"Piraievs - Greece");
	ports.put(47910,"Piran - Slovenia");
	ports.put(47910,"Pirano - Slovenia");
	ports.put(33700,"Pisagua - Chile");
	ports.put(33373,"Pisco - Peru");
	ports.put(6225,"Pitcairn Island - Pitcairn Island");
	ports.put(62211,"Pitcairn Islands - Pitcairn");
	ports.put(40100,"Pitea - Sweden");
	ports.put(1104,"PITTSBURGH - United States");
	ports.put(56087,"Plaju - Indonesia");
	ports.put(56500,"Plaridel - Philippines");
	ports.put(47911,"Ploce - Croatia");
	ports.put(48400,"Plomarion - Greece");
	ports.put(24845,"Plymouth - Montserrat");
	ports.put(41360,"Plymouth - United Kingdom");
	ports.put(406,"PLYMOUTH - United States");
	ports.put(58055,"Pohang - South Korea");
	ports.put(58055,"Pohang Hang - South Korea");
	ports.put(68207,"Pohnpei - Micronesia");
	ports.put(22599,"Point Bruja - Panama");
	ports.put(74165,"Point Central - Mauritania");
	ports.put(27420,"Point Fortin - Trinidad");
	ports.put(27410,"Point Galeota - Trinidad");
	ports.put(27425,"Point Lisas - Trinidad");
	ports.put(22599,"Point Mala - Panama");
	ports.put(3017,"POINT ROBERTS - United States");
	ports.put(20100,"Point Tosca - Mexico");
	ports.put(14065,"Point Tupper, CBI - Canada");
	ports.put(35166,"Point Ubu - Brazil");
	ports.put(27415,"Pointe a Pierre - Trinidad");
	ports.put(28313,"Pointe a Pitre - Guadeloupe");
	ports.put(14066,"Pointe Au Pic, QUE - Canada");
	ports.put(1823,"Pointe aux Trembles, ONT - Canada");
	ports.put(79051,"Pointe des Galets - Reunion");
	ports.put(76350,"Pointe Noire - Congo Brazzaville");
	ports.put(13476,"Pointe Noire, QUE - Canada");
	ports.put(47920,"Pola - Croatia");
	ports.put(4550,"Poland - Poland");
	ports.put(45513,"Police - Poland");
	ports.put(56500,"Polillo - Philippines");
	ports.put(68207,"Ponape - Micronesia");
	ports.put(4908,"PONCE - United States");
	ports.put(53398,"Pondicherry - India");
	ports.put(35168,"Ponta da Madeira - Brazil");
	ports.put(47151,"Ponta Delgada - Portugal");
	ports.put(35166,"Ponta do Ubu - Brazil");
	ports.put(56500,"Pontevedra - Philippines");
	ports.put(56011,"Pontianak - Indonesia");
	ports.put(41398,"Poole - United Kingdom");
	ports.put(53300,"Porbandar - India");
	ports.put(12200,"Porcher Island, BC - Canada");
	ports.put(40562,"Pori - Finland");
	ports.put(30700,"Porlamar - Venezuela");
	ports.put(64100,"Poro - New Caledonia");
	ports.put(56578,"Poro - Philippines");
	ports.put(56500,"Poro Island - Philippines");
	ports.put(40378,"Porsgrunn - Norway");
	ports.put(12202,"Port Alberni, BC - Canada");
	ports.put(47099,"Port Alfaques - Spain");
	ports.put(14069,"Port Alfred, QUE - Canada");
	ports.put(12422,"Port Alice, BC - Canada");
	ports.put(60249,"Port Alma - Australia");
	ports.put(23672,"Port Andros - Bahamas");
	ports.put(3007,"PORT ANGELES - United States");
	ports.put(24100,"Port Antonio - Jamaica");
	ports.put(57052,"Port Arthur - China");
	ports.put(2101,"PORT ARTHUR - United States");
	ports.put(9662,"Port Arthur, ONT - Canada");
	ports.put(24579,"Port au Prince - Haiti");
	ports.put(74899,"Port Bouet - Ivory Coast");
	ports.put(24128,"Port Bustamante - Jamaica");
	ports.put(55205,"Port Campha - Vietnam");
	ports.put(1816,"PORT CANAVERAL - United States");
	ports.put(14073,"Port Cartier, QUE - Canada");
	ports.put(61431,"Port Chalmers - New Zealand");
	ports.put(12204,"Port Clements, BC - Canada");
	ports.put(2641,"Port Colborne, ONT - Canada");
	ports.put(1530,"Port Credit, ONT - Canada");
	ports.put(42784,"Port de Bouc - France");
	ports.put(24585,"Port de Paix - Haiti");
	ports.put(55753,"Port Dickson - Malaysia");
	ports.put(35120,"Port do Pecem - Brazil");
	ports.put(12420,"Port Edward, BC - Canada");
	ports.put(79145,"Port Elizabeth - South Africa");
	ports.put(24163,"Port Esquivel - Jamaica");
	ports.put(74165,"Port Etienne - Mauritania");
	ports.put(5203,"PORT EVERGLADES - United States");
	ports.put(75525,"Port Gentil - Gabon");
	ports.put(28319,"Port Gustave - Guadeloupe");
	ports.put(75385,"Port Harcourt - Nigeria");
	ports.put(12211,"Port Hardy, BC - Canada");
	ports.put(13849,"Port Hawkesbury, NS - Canada");
	ports.put(60219,"Port Hedland - Australia");
	ports.put(91125,"Port Hess, St. Croix - US Virgin Is");
	ports.put(56500,"Port Holland - Philippines");
	ports.put(2713,"PORT HUENEME - United States");
	ports.put(3802,"PORT HURON - United States");
	ports.put(35135,"Port Itaqui - Brazil");
	ports.put(42755,"Port Jerome - France");
	ports.put(1700,"Port Johnstown, ONT - Canada");
	ports.put(24165,"Port Kaiser - Jamaica");
	ports.put(48400,"Port Kaloni - Greece");
	ports.put(53307,"Port Kandla - India");
	ports.put(55751,"Port Kelang - Malaysia");
	ports.put(60252,"Port Kembla - Australia");
	ports.put(42799,"Port La Nouvelle - France");
	ports.put(5313,"PORT LAVACA - United States");
	ports.put(76288,"Port Lombo - Angola");
	ports.put(78501,"Port Louis - Mauritius");
	ports.put(23646,"Port Lucaya - Bahamas");
	ports.put(71400,"Port Lyautey - Morocco");
	ports.put(61415,"Port Lyttelton - New Zealand");
	ports.put(13430,"Port Maitland, NS - Canada");
	ports.put(1821,"PORT MANATEE - United States");
	ports.put(12426,"Port Mann, BC - Canada");
	ports.put(24100,"Port Maria - Jamaica");
	ports.put(12428,"Port Mellon, BC - Canada");
	ports.put(12430,"Port Moody, BC - Canada");
	ports.put(24100,"Port Morant - Jamaica");
	ports.put(60447,"Port Moresby - Papua New Guinea");
	ports.put(53551,"Port Muhammad Bin Qasim - Pakistan");
	ports.put(79113,"Port Natal - South Africa");
	ports.put(23650,"Port Nelson - Bahamas");
	ports.put(79100,"Port Nollath - South Africa");
	ports.put(13420,"Port of Digby, NS - Canada");
	ports.put(27431,"Port of Spain - Trinidad");
	ports.put(53300,"Port Okha - India");
	ports.put(56556,"Port Ozamis - Philippines");
	ports.put(60258,"Port Pirie - Australia");
	ports.put(91151,"Port Purcell, Rd Harbor - US Virgin Is");
	ports.put(53551,"Port Qasim - Pakistan");
	ports.put(52005,"Port Rashid - United Arab Em");
	ports.put(55200,"Port Redon - Vietnam");
	ports.put(24167,"Port Rhoades - Jamaica");
	ports.put(24100,"Port Royal - Jamaica");
	ports.put(72913,"Port Said - Egypt");
	ports.put(42785,"Port Saint Louis - France");
	ports.put(2707,"PORT SAN LUIS - United States");
	ports.put(47049,"Port Santa Maria - Spain");
	ports.put(35165,"Port Santana - Brazil");
	ports.put(12444,"Port Simpson, BC - Canada");
	ports.put(37200,"Port Stanley, E Falklnd - Falk Is");
	ports.put(2566,"Port Stanley, ONT - Canada");
	ports.put(1001,"PORT STREE - United States");
	ports.put(73201,"Port Sudan - Sudan");
	ports.put(2005,"PORT SULPHUR - United States");
	ports.put(52325,"Port Sultan Qaboos - Oman");
	ports.put(55751,"Port Swettenham - Malaysia");
	ports.put(41477,"Port Talbot - United Kingdom");
	ports.put(23900,"Port Tarafa - Cuba");
	ports.put(20100,"Port Telzo - Mexico");
	ports.put(3008,"PORT TOWNSEND - United States");
	ports.put(42799,"Port Vendres - France");
	ports.put(78083,"Port Victoria - Seychelles");
	ports.put(62209,"Port Vila - Vanuatu");
	ports.put(55700,"Port Weld - Malaysia");
	ports.put(9663,"Port Weller, ONT - Canada");
	ports.put(9671,"Port Whitby, ONT - Canada");
	ports.put(3403,"PORTAL - United States");
	ports.put(41262,"Portbury - United Kingdom");
	ports.put(35198,"Portel - Brazil");
	ports.put(3308,"PORTHILL - United States");
	ports.put(47500,"Portici - Italy");
	ports.put(47100,"Portimao - Portugal");
	ports.put(60261,"Portland - Australia");
	ports.put(41398,"Portland - United Kingdom");
	ports.put(101,"PORTLAND - United States");
	ports.put(2904,"PORTLAND - United States");
	ports.put(2910,"PORTLAND INTERNATIONAL AIRPORT - United States");
	ports.put(47133,"Porto - Portugal");
	ports.put(35167,"Porto Alegre - Brazil");
	ports.put(76299,"Porto Alexandre - Angola");
	ports.put(76299,"Porto Amboim - Angola");
	ports.put(47584,"Porto Corsini - Italy");
	ports.put(47123,"Porto de Leixoes - Portugal");
	ports.put(47127,"Porto de Sines - Portugal");
	ports.put(47554,"Porto Empedocle - Italy");
	ports.put(76465,"Porto Grande - Cape Verde");
	ports.put(47595,"Porto Marghara - Italy");
	ports.put(76475,"Porto Praia - Cape Verde");
	ports.put(47500,"Porto Santo Stefano - Italy");
	ports.put(47561,"Porto Torres - Italy");
	ports.put(42796,"Porto Vecchio - France");
	ports.put(47568,"Porto Vesme - Italy");
	ports.put(22555,"Portobelo - Panama");
	ports.put(35199,"Portocel - Brazil");
	ports.put(47568,"Portocuso - Italy");
	ports.put(47500,"Portoferraio - Italy");
	ports.put(47515,"Portovecchio de Piombino - Italy");
	ports.put(24852,"Portsmouth - Dominica");
	ports.put(41398,"Portsmouth - United Kingdom");
	ports.put(131,"PORTSMOUTH - United States");
	ports.put(4710,"Portugal - Portugal");
	ports.put(40534,"Porvoo - Finland");
	ports.put(47500,"Possuoli - Italy");
	ports.put(46337,"Poti - Georgia");
	ports.put(12441,"Powell River, BC - Canada");
	ports.put(30100,"Pozos Colorados - Colombia");
	ports.put(47500,"Pozzuoli - Italy");
	ports.put(42870,"Prague - Czech Republic");
	ports.put(4351,"Prague - Czech Republic");
	ports.put(76475,"Praia - Cape Verde");
	ports.put(47152,"Praia - Portugal");
	ports.put(47152,"Praia de Vitoria - Portugal");
	ports.put(35160,"Praia Mole - Brazil");
	ports.put(1700,"Prescott, ONT - Canada");
	ports.put(2403,"PRESIDIO - United States");
	ports.put(3842,"PRESQUE ISLAND - United States");
	ports.put(41264,"Preston - United Kingdom");
	ports.put(48400,"Preveza - Greece");
	ports.put(46220,"Primorsk - Russia");
	ports.put(12442,"Prince Rupert, BC - Canada");
	ports.put(21900,"Prinzapolca - Nicaragua");
	ports.put(47555,"Priolo - Italy");
	ports.put(56058,"Probolinggo - Indonesia");
	ports.put(20185,"Progreso - Mexico");
	ports.put(2309,"PROGRESSO - United States");
	ports.put(502,"PROVIDENCE - United States");
	ports.put(24311,"Providenciales - Turks Is");
	ports.put(46237,"Provideniya - Russia");
	ports.put(409,"PROVINCETOWN - United States");
	ports.put(48461,"Psachna - Greece");
	ports.put(21900,"Pto. Cabo Gracias a Dios - Nicaragua");
	ports.put(23900,"Pto. Cayo Grande de Moa - Cuba");
	ports.put(35779,"Pto. General San Martin - Argentina");
	ports.put(20171,"Pto. Libre de Pto Mexico - Mexico");
	ports.put(20104,"Pto. Venustiano Carranza - Mexico");
	ports.put(53398,"Puduchcheri - India");
	ports.put(20100,"Puerto Angel - Mexico");
	ports.put(22587,"Puerto Armuelles - Panama");
	ports.put(20513,"Puerto Barrios - Guatemala");
	ports.put(33300,"Puerto Bayovar - Peru");
	ports.put(22555,"Puerto Bello - Panama");
	ports.put(30121,"Puerto Bolivar - Colombia");
	ports.put(33159,"Puerto Bolivar - Ecuador");
	ports.put(35779,"Puerto Borghio - Argentina");
	ports.put(30764,"Puerto Cabello - Venezuela");
	ports.put(21925,"Puerto Cabezas - Nicaragua");
	ports.put(21527,"Puerto Castilla - Honduras");
	ports.put(30131,"Puerto Colombia - Colombia");
	ports.put(21531,"Puerto Cortes - Honduras");
	ports.put(30700,"Puerto Cumarebo - Venezuela");
	ports.put(30700,"Puerto de Hierro - Venezuela");
	ports.put(47071,"Puerto de la Luz - Spain");
	ports.put(33751,"Puerto de Lirquen - Chile");
	ports.put(47099,"Puerto de los Alfaques - Spain");
	ports.put(20194,"Puerto de Morales - Mexico");
	ports.put(47083,"Puerto de Sagunto - Spain");
	ports.put(47049,"Puerto de Santa Maria - Spain");
	ports.put(47070,"Puerto del Rosario - Spain");
	ports.put(35745,"Puerto Deseado - Argentina");
	ports.put(30140,"Puerto Drummond - Colombia");
	ports.put(21199,"Puerto El Triunfo - El Salvador");
	ports.put(30700,"Puerto Espiritu - Venezuela");
	ports.put(21500,"Puerto Este - Honduras");
	ports.put(33300,"Puerto Eten - Peru");
	ports.put(23937,"Puerto General Peraza - Cuba");
	ports.put(22363,"Puerto Golfito - Costa Rica");
	ports.put(30700,"Puerto Gorda - Venezuela");
	ports.put(21552,"Puerto Henecan - Honduras");
	ports.put(21900,"Puerto Isabel - Nicaragua");
	ports.put(30743,"Puerto Jose - Venezuela");
	ports.put(20195,"Puerto Juarez - Mexico");
	ports.put(30771,"Puerto La Cruz - Venezuela");
	ports.put(24745,"Puerto Libertador - Dominican Republic");
	ports.put(22313,"Puerto Limon - Costa Rica");
	ports.put(20195,"Puerto Lobos - Mexico");
	ports.put(20193,"Puerto Madero - Mexico");
	ports.put(35740,"Puerto Madryn - Argentina");
	ports.put(22556,"Puerto Manzanillo - Panama");
	ports.put(21999,"Puerto Masachapa - Nicaragua");
	ports.put(20505,"Puerto Matias de Galves - Guatemala");
	ports.put(20171,"Puerto Mexico - Mexico");
	ports.put(30763,"Puerto Miranda - Venezuela");
	ports.put(33700,"Puerto Montt - Chile");
	ports.put(20194,"Puerto Morales - Mexico");
	ports.put(20104,"Puerto Morro Redondo - Mexico");
	ports.put(33132,"Puerto Nuevo - Ecuador");
	ports.put(30768,"Puerto Ordaz - Venezuela");
	ports.put(23900,"Puerto Padre - Cuba");
	ports.put(24700,"Puerto Palenque - Dominican Republic");
	ports.put(24773,"Puerto Plata - Dominican Republic");
	ports.put(35700,"Puerto Quequen - Argentina");
	ports.put(20506,"Puerto Quetzal - Guatemala");
	ports.put(56500,"Puerto Real - Philippines");
	ports.put(9030,"Puerto Rico - Puerto Rico");
	ports.put(35779,"Puerto San Lorenzo - Argentina");
	ports.put(20100,"Puerto San Quintin - Mexico");
	ports.put(21999,"Puerto Sandino - Nicaragua");
	ports.put(30769,"Puerto Sucre - Venezuela");
	ports.put(23900,"Puerto Tarafa - Cuba");
	ports.put(9000,"Puerto to US - Puerto to US");
	ports.put(20143,"Puerto Vallarta - Mexico");
	ports.put(22300,"Puerto Vargas - Costa Rica");
	ports.put(24700,"Puerto Viejo de Azua - Dominican Republic");
	ports.put(35300,"Puerto Villeta - Paraguay");
	ports.put(23900,"Puerto Vita - Cuba");
	ports.put(30100,"Puerto Zuniga - Colombia");
	ports.put(47920,"Pula - Croatia");
	ports.put(55950,"Pulau Bukom - Singapore");
	ports.put(55709,"Pulau Lumut - Malaysia");
	ports.put(56065,"Pulau Sambu - Indonesia");
	ports.put(55901,"Pulau Sebarok - Singapore");
	ports.put(55950,"Pulum Bukum - Singapore");
	ports.put(56569,"Pulupandan - Philippines");
	ports.put(33100,"Puna - Ecuador");
	ports.put(33770,"Punta Arenas - Chile");
	ports.put(30700,"Punta Camacho - Venezuela");
	ports.put(30770,"Punta Cardon - Venezuela");
	ports.put(30737,"Punta Chavez - Venezuela");
	ports.put(30767,"Punta Cuchillo - Venezuela");
	ports.put(35537,"Punta del Este - Uruguay");
	ports.put(20100,"Punta Escondida - Mexico");
	ports.put(20800,"Punta Gorda - Belize");
	ports.put(23900,"Punta Gorda - Cuba");
	ports.put(21900,"Punta Gorda - Nicaragua");
	ports.put(30700,"Punta Gorda - Venezuela");
	ports.put(22599,"Punta Mala - Panama");
	ports.put(22386,"Punta Morales - Costa Rica");
	ports.put(30773,"Punta Palmas - Venezuela");
	ports.put(33700,"Punta Patache - Chile");
	ports.put(33300,"Punta Pescadores - Peru");
	ports.put(30700,"Punta Piedras - Venezuela");
	ports.put(20100,"Punta Prieta - Mexico");
	ports.put(22381,"Punta Quepos - Costa Rica");
	ports.put(35700,"Punta Quilla - Argentina");
	ports.put(20100,"Punta San Juanico - Mexico");
	ports.put(20100,"Punta Santo Tomas - Mexico");
	ports.put(24738,"Punta Torrecilla - Dominican Republic");
	ports.put(20173,"Punta Venado - Mexico");
	ports.put(22387,"Puntarenas - Costa Rica");
	ports.put(41398,"Purfleet - United Kingdom");
	ports.put(48944,"Pursan - Turkey");
	ports.put(58023,"Pusan - South Korea");
	ports.put(48463,"Pylos - Greece");
	ports.put(58032,"Pyongtaek - South Korea");
	ports.put(58032,"Pyungtaek - South Korea");
	ports.put(52312,"Qalhat - Oman");
	ports.put(5180,"Qatar - Qatar");
	ports.put(57047,"Qingdao - China");
	ports.put(57009,"Qinhuangdao Gang - China");
	ports.put(75389,"Qua Iboe Terminal - Nigeria");
	ports.put(57071,"Quangzhou - China");
	ports.put(57071,"Quanzhou - China");
	ports.put(20513,"Quatema - Guatemala");
	ports.put(75389,"Que Iboe - Nigeria");
	ports.put(14094,"Quebec, QUE - Canada");
	ports.put(41900,"Queenstown - Ireland");
	ports.put(78700,"Quelimane - Mozambique");
	ports.put(22381,"Quepos - Costa Rica");
	ports.put(53300,"Quilon - India");
	ports.put(57047,"Quingdao - China");
	ports.put(33775,"Quintero - Chile");
	ports.put(40535,"Raahe - Finland");
	ports.put(71400,"Rabat - Morocco");
	ports.put(60449,"Rabaul - Papua New Guinea");
	ports.put(3708,"RACINE - United States");
	ports.put(47540,"Rada di Vado - Italy");
	ports.put(42754,"Radicatel - France");
	ports.put(23636,"Ragged Island - Bahamas");
	ports.put(47902,"Ragusa - Croatia");
	ports.put(64178,"Raiatea Island - French Polyn");
	ports.put(3301,"RAIMOND - United States");
	ports.put(21902,"Rama - Nicaragua");
	ports.put(15211,"Ramea, NFLD - Canada");
	ports.put(40925,"Randers - Denmark");
	ports.put(54601,"Rangoon - Burma");
	ports.put(61461,"Rarotonga Island - New Zealand");
	ports.put(51700,"Ras Al Khafji - Saudi Arabia");
	ports.put(52000,"Ras al Khaimah - United Arab Em");
	ports.put(52000,"Ras al Khaymah - United Arab Em");
	ports.put(51727,"Ras at Tannurah - Saudi Arabia");
	ports.put(72999,"Ras Budran - Egypt");
	ports.put(72939,"Ras Gharib - Egypt");
	ports.put(51814,"Ras Laffan - Qatar");
	ports.put(72520,"Ras Lanuf - Libya");
	ports.put(72940,"Ras Shukheir - Egypt");
	ports.put(72945,"Ras Sudr - Egypt");
	ports.put(51727,"Ras Tanura - Saudi Arabia");
	ports.put(40000,"Raufarhofn - Iceland");
	ports.put(40571,"Rauma - Finland");
	ports.put(47584,"Ravenna - Italy");
	ports.put(61400,"Ravensbourne - New Zealand");
	ports.put(54903,"Rayong - Thailand");
	ports.put(35169,"Recife - Brazil");
	ports.put(13400,"Red Head, NB - Canada");
	ports.put(41362,"Redcar - United Kingdom");
	ports.put(2821,"REDWOOD CITY - United States");
	ports.put(47500,"Reggio di Calabria - Italy");
	ports.put(23944,"Regla - Cuba");
	ports.put(1506,"REIDSVILLE - United States");
	ports.put(40379,"Rekefjord - Norway");
	ports.put(42899,"Rendsburg - Germany");
	ports.put(46279,"Reni - Ukraine");
	ports.put(2833,"RENO - United States");
	ports.put(5210,"Republic of Yemen - Republic of Yemen");
	ports.put(7904,"Reunion - Reunion");
	ports.put(73801,"Rey Malabo - Equatorial Gui");
	ports.put(40037,"Reykjavik - Iceland");
	ports.put(48400,"Rhodes - Greece");
	ports.put(47000,"Ribadesella - Spain");
	ports.put(79155,"Richards Bay - South Africa");
	ports.put(13454,"Richardson Island, NB - Canada");
	ports.put(13454,"Richardson, NB - Canada");
	ports.put(203,"RICHFORD - United States");
	ports.put(2812,"RICHMOND - United States");
	ports.put(12497,"Richmond, BC - Canada");
	ports.put(1404,"RICHMOND-PETERSBURG - United States");
	ports.put(41370,"Ridham Dock - United Kingdom");
	ports.put(42300,"Rieme - Belgium");
	ports.put(35198,"Riga - Kazakhstan");
	ports.put(4634,"Riga - Kostanay - Kazakhstan");
	ports.put(44911,"Riga - Latvia");
	ports.put(44911,"Riga - Tula - Latvia");
	ports.put(47923,"Rijeka - Croatia");
	ports.put(14068,"Rimouski QUE - Canada");
	ports.put(41905,"Ringaskiddy - Ireland");
	ports.put(73800,"Rio Benito - Equatorial Gui");
	ports.put(24100,"Rio Bueno - Jamaica");
	ports.put(30700,"Rio Chico - Venezuela");
	ports.put(35171,"Rio de Janeiro - Brazil");
	ports.put(35700,"Rio Gallegos - Argentina");
	ports.put(35173,"Rio Grande - Brazil");
	ports.put(21900,"Rio Grande - Nicaragua");
	ports.put(2307,"RIO GRANDE CITY - United States");
	ports.put(24741,"Rio Haina - Dominican Republic");
	ports.put(22599,"Rio Hato - Panama");
	ports.put(24741,"Rio Jaina - Dominican Republic");
	ports.put(30700,"Rio Sico - Venezuela");
	ports.put(60299,"Risdon - Australia");
	ports.put(40300,"Risor - Norway");
	ports.put(35702,"Rivadavia - Argentina");
	ports.put(76500,"River Cess - Liberia");
	ports.put(51715,"RIYADH DRY PORT - Saudi Arabia");
	ports.put(57024,"Rizhao - China");
	ports.put(24815,"Road Harbour, Tortola - British Virgin");
	ports.put(24815,"Road Town, Tortola Island - British Virgin");
	ports.put(21535,"Roatan Island - Honduras");
	ports.put(12489,"Roberts Bank, BC - Canada");
	ports.put(76500,"Robertsport - Liberia");
	ports.put(24500,"Roche a Bateau - Haiti");
	ports.put(42757,"Rochefort - France");
	ports.put(41398,"Rochester - United Kingdom");
	ports.put(903,"ROCHESTER - United States");
	ports.put(3909,"ROCKFORD AIRPORT, ROCKFORD - United States");
	ports.put(121,"ROCKLAND - United States");
	ports.put(2643,"Rockport, ONT - Canada");
	ports.put(24175,"Rocky Point - Jamaica");
	ports.put(1697,"Rocky Point, ONT - Canada");
	ports.put(48400,"Rodhos - Greece");
	ports.put(22599,"Rodman - Panama");
	ports.put(48999,"Rodosto - Turkey");
	ports.put(3818,"ROGERS CITY - United States");
	ports.put(2982,"ROGUE VALLEY,MEDFORD AIRPORT - United States");
	ports.put(2310,"ROMA - United States");
	ports.put(4850,"Romania - Romania");
	ports.put(56500,"Romblon Island - Philippines");
	ports.put(40926,"Ronne - Denmark");
	ports.put(40100,"Ronneby - Sweden");
	ports.put(40161,"Ronnsker - Sweden");
	ports.put(3318,"ROOSVILLE - United States");
	ports.put(35771,"Rosario - Argentina");
	ports.put(20125,"Rosarito - Mexico");
	ports.put(47099,"Rosas - Spain");
	ports.put(3426,"ROSEAU - United States");
	ports.put(41900,"Rosslare - Ireland");
	ports.put(42811,"Rostock - Germany");
	ports.put(41698,"Rosyth - United Kingdom");
	ports.put(47049,"Rota - Spain");
	ports.put(42157,"Rotterdam - Netherlands");
	ports.put(42759,"Rouen - France");
	ports.put(42700,"Rouen Quevilly - France");
	ports.put(24851,"Rouseau - Dominica");
	ports.put(74499,"Rufisque - Senegal");
	ports.put(23650,"Rum Cay - Bahamas");
	ports.put(58820,"Rumoi - Japan");
	ports.put(41299,"Runcorn - United Kingdom");
	ports.put(14095,"Rupert Inlet, QUE - Canada");
	ports.put(4621,"Russia - Russia");
	ports.put(52050,"Ruwais - United Arab Em");
	ports.put(7690,"Rwanda - Rwanda");
	ports.put(57000,"Ryojun Ko - China");
	ports.put(56099,"Sabang - Indonesia");
	ports.put(2102,"SABINE - United States");
	ports.put(2816,"SACRAMENTO - United States");
	ports.put(2881,"SACRAMENTO INTERNATIONAL AIRPORT - United States");
	ports.put(72948,"Safaga - Egypt");
	ports.put(71419,"Saffi - Morocco");
	ports.put(71419,"Safi - Morocco");
	ports.put(58800,"Saganoseki - Japan");
	ports.put(3804,"SAGINAW,BAY CITY,FLINT - United States");
	ports.put(23979,"Sagua de Tanamo - Cuba");
	ports.put(23937,"Sagua la Grande - Cuba");
	ports.put(47083,"Sagunto - Spain");
	ports.put(50400,"Saida - Lebanon");
	ports.put(55224,"Saigon - Vietnam");
	ports.put(58819,"Saiki - Japan");
	ports.put(58819,"Saiki Ko - Japan");
	ports.put(40536,"Saimaa Canal - Finland");
	ports.put(14426,"Saint Andrews, NB - Canada");
	ports.put(15212,"Saint Anthony, NL - Canada");
	ports.put(28319,"Saint Bartholomew - Guadeloupe");
	ports.put(1690,"Saint Catharines, ONT - Canada");
	ports.put(79052,"Saint Denis - Reunion");
	ports.put(14427,"Saint George, NB - Canada");
	ports.put(23251,"Saint Georges - Bermuda");
	ports.put(48400,"Saint Georges Bay - Greece");
	ports.put(14429,"Saint Jean, QUE - Canada");
	ports.put(14428,"Saint John, NB - Canada");
	ports.put(15282,"Saint Johns, NFLD - Canada");
	ports.put(14429,"Saint Johns, QUE - Canada");
	ports.put(31700,"Saint Laurent - French Guiana");
	ports.put(15283,"Saint Lawrence, NFLD - Canada");
	ports.put(24500,"Saint Louis du Sud - Haiti");
	ports.put(42700,"Saint Malo - France");
	ports.put(24591,"Saint Marc - Haiti");
	ports.put(28300,"Saint Martin - Guadeloupe");
	ports.put(42762,"Saint Nazaire - France");
	ports.put(3181,"SAINT PAUL AIRPORT,ANCHORAGE - United States");
	ports.put(28399,"Saint Pierre - Martinique");
	ports.put(42799,"Saint Raphael - France");
	ports.put(14438,"Saint Stephen, NB - Canada");
	ports.put(91155,"Saint Thomas, St. Thomas - US Virgin Is");
	ports.put(96165,"Saipan - Northern Marian");
	ports.put(58800,"Saitosaki - Japan");
	ports.put(58800,"Saitozaki - Japan");
	ports.put(58874,"Sakai - Japan");
	ports.put(58874,"Sakai Ko - Japan");
	ports.put(58875,"Sakaide - Japan");
	ports.put(58875,"Sakaide Ko - Japan");
	ports.put(58876,"Sakata - Japan");
	ports.put(76499,"Sal Island - Cape Verde");
	ports.put(52330,"Salalah - Oman");
	ports.put(60400,"Salamaua - Papua New Guinea");
	ports.put(48400,"Salamis - Greece");
	ports.put(60400,"Salamoa - Papua New Guinea");
	ports.put(33377,"Salaverry - Peru");
	ports.put(56000,"Salawati - Indonesia");
	ports.put(79100,"Saldanha Bay - South Africa");
	ports.put(52100,"Saleef - Yemen");
	ports.put(408,"SALEM - United States");
	ports.put(47538,"Salerno - Italy");
	ports.put(41253,"Salford - United Kingdom");
	ports.put(20129,"Salina Cruz - Mexico");
	ports.put(33115,"Salinas - Ecuador");
	ports.put(40100,"Saljfviken - Sweden");
	ports.put(48471,"Salonika - Greece");
	ports.put(24399,"Salt Cay - Turks Is");
	ports.put(41398,"Salt End - United Kingdom");
	ports.put(3303,"SALT LAKE CITY - United States");
	ports.put(40380,"Salten - Norway");
	ports.put(74900,"Saltpond - Ghana");
	ports.put(35181,"Salvador - Brazil");
	ports.put(24720,"Samana - Dominican Republic");
	ports.put(60400,"Samarai - Papua New Guinea");
	ports.put(56012,"Samarinda - Indonesia");
	ports.put(44911,"SAMARQAND - UZBEKISTAN");
	ports.put(56020,"Sambas - Indonesia");
	ports.put(78800,"Sambava - Madagascar");
	ports.put(58065,"Samil - South Korea");
	ports.put(48464,"Samos - Greece");
	ports.put(48967,"Samsun - Turkey");
	ports.put(30130,"San Andres - Colombia");
	ports.put(35700,"San Antonio - Argentina");
	ports.put(33779,"San Antonio - Chile");
	ports.put(35300,"San Antonio - Paraguay");
	ports.put(5507,"SAN ANTONIO - United States");
	ports.put(20100,"San Blas - Mexico");
	ports.put(47036,"San Ciprian - Spain");
	ports.put(2501,"SAN DIEGO - United States");
	ports.put(47088,"San Feliu de Guixols - Spain");
	ports.put(30780,"San Felix - Venezuela");
	ports.put(56578,"San Fernando - Philippines");
	ports.put(27443,"San Fernando - Trinidad");
	ports.put(2809,"SAN FRANCISCO - United States");
	ports.put(2801,"SAN FRANCISCO INTL. AIRPORT, SAN FRANCISCO - United States");
	ports.put(20100,"San Geronimo - Mexico");
	ports.put(48100,"San Giovanni di Medua - Albania");
	ports.put(20100,"San Ignacio - Mexico");
	ports.put(20100,"San Jeronimo - Mexico");
	ports.put(2828,"SAN JOAQUIN RIVER - United States");
	ports.put(20577,"San Jose - Guatemala");
	ports.put(56500,"San Jose de Buenavista - Philippines");
	ports.put(20100,"San Jose del Cabo - Mexico");
	ports.put(2834,"SAN JOSE INTL.,SAN FRANCISCO - United States");
	ports.put(4909,"SAN JUAN - United States");
	ports.put(47003,"San Juan de Nieva - Spain");
	ports.put(21999,"San Juan del Sur - Nicaragua");
	ports.put(4913,"SAN JUAN INTL. AIRPORT - United States");
	ports.put(35779,"San Lorenzo - Argentina");
	ports.put(33100,"San Lorenzo - Ecuador");
	ports.put(21551,"San Lorenzo - Honduras");
	ports.put(30700,"San Lorenzo - Venezuela");
	ports.put(20144,"San Lucas - Mexico");
	ports.put(2608,"SAN LUIS - United States");
	ports.put(20135,"San Marcos Island - Mexico");
	ports.put(4751,"San Marino - San Marino");
	ports.put(12200,"San Mateo, BC - Canada");
	ports.put(22599,"San Miguel Gulf - Panama");
	ports.put(35781,"San Nicolas - Argentina");
	ports.put(33380,"San Nicolas - Peru");
	ports.put(27702,"San Nicolas Bay - Aruba");
	ports.put(2829,"SAN PABLO BAY - United States");
	ports.put(35785,"San Pedro - Argentina");
	ports.put(20800,"San Pedro - Belize");
	ports.put(74827,"San Pedro - Ivory Coast");
	ports.put(2709,"San Pedro - United States");
	ports.put(24791,"San Pedro de Macoris - Dominican Republic");
	ports.put(23900,"San Ramon - Cuba");
	ports.put(20100,"San Roque Island - Mexico");
	ports.put(23600,"San Salvador - Bahamas");
	ports.put(21199,"San Salvador - El Salvador");
	ports.put(21199,"san salvador - el salvador");
	ports.put(47000,"San Sebastian - Spain");
	ports.put(35700,"San Sebastian Bay - Argentina");
	ports.put(57070,"San T Ou - China");
	ports.put(33780,"San Vicente - Chile");
	ports.put(2504,"SAN YSIDRO - United States");
	ports.put(55706,"Sandakan - Malaysia");
	ports.put(40166,"Sandarne - Sweden");
	ports.put(40300,"Sandefjord - Norway");
	ports.put(40100,"Sandhamn - Sweden");
	ports.put(40381,"Sandnes - Norway");
	ports.put(13400,"Sandy Cove, NS - Canada");
	ports.put(56520,"Sangi - Philippines");
	ports.put(2606,"SANSABE - United States");
	ports.put(24720,"Santa Barbara de Samana - Dominican Republic");
	ports.put(20100,"Santa Catarina - Mexico");
	ports.put(35167,"Santa Clara - Brazil");
	ports.put(35700,"Santa Cruz - Argentina");
	ports.put(56593,"Santa Cruz - Philippines");
	ports.put(56500,"Santa Cruz (Davao Gulf) - Philippines");
	ports.put(47072,"Santa Cruz de La Palma - Spain");
	ports.put(47073,"Santa Cruz de Tenerife - Spain");
	ports.put(23983,"Santa Cruz del Sur - Cuba");
	ports.put(33100,"Santa Elena - Ecuador");
	ports.put(35791,"Santa Fe - Argentina");
	ports.put(73801,"Santa Isabel - Equatorial Gui");
	ports.put(23900,"Santa Lucia - Cuba");
	ports.put(56500,"Santa Maria - Philippines");
	ports.put(30140,"Santa Marta - Colombia");
	ports.put(47556,"Santa Panagia - Italy");
	ports.put(20141,"Santa Rosalia - Mexico");
	ports.put(2408,"SANTA TERESA - United States");
	ports.put(2481,"SANTA TERESA AIRPORT, DONA ANA COUNTY - United States");
	ports.put(56016,"Santan Terminal - Indonesia");
	ports.put(35165,"Santana - Brazil");
	ports.put(47013,"Santander - Spain");
	ports.put(35198,"Santarem - Brazil");
	ports.put(33776,"Santiago - Chile");
	ports.put(23900,"Santiago de Cuba - Cuba");
	ports.put(62207,"Santo - Vanuatu");
	ports.put(24737,"Santo Domingo - Dominican Republic");
	ports.put(20505,"Santo Tomas - Guatemala");
	ports.put(20505,"Santo Tomas de Castilla - Guatemala");
	ports.put(20100,"Santo Tomas Point - Mexico");
	ports.put(35177,"Santos - Brazil");
	ports.put(35179,"Sao Francisco do Sul - Brazil");
	ports.put(35135,"Sao Luiz de Maranhao - Brazil");
	ports.put(35198,"Sao Miguel dos Macaos - Brazil");
	ports.put(35177,"Sao Paulo - Brazil");
	ports.put(35175,"Sao Sebastio - Brazil");
	ports.put(76491,"Sao Tome (St. Thomas) - Sao Tome and Princip");
	ports.put(7644,"Sao Tome and Principe - Sao Tome and Principe");
	ports.put(75383,"Sapele - Nigeria");
	ports.put(56500,"Sarangani Bay - Philippines");
	ports.put(56500,"Sarangani Island - Philippines");
	ports.put(1883,"SARASOTA-BRADENTON AIRPORT - United States");
	ports.put(3409,"SARLES - United States");
	ports.put(5520,"Sarnia, ONT - Canada");
	ports.put(40300,"Sarpsborg - Norway");
	ports.put(47567,"Sarroch Oil Terminal - Italy");
	ports.put(42100,"Sas Van Gent - Netherlands");
	ports.put(58816,"Sasebo - Japan");
	ports.put(74899,"Sassandra - Ivory Coast");
	ports.put(42100,"Sasvanghent - Netherlands");
	ports.put(54900,"Satahib - Thailand");
	ports.put(54900,"Satahip - Thailand");
	ports.put(54900,"Sattahip - Thailand");
	ports.put(40383,"Sauda - Norway");
	ports.put(5170,"Saudi Arabia - Saudi Arabia");
	ports.put(3803,"SAULT STE MARIE - United States");
	ports.put(8525,"Sault Ste. Marie, ONT - Canada");
	ports.put(20142,"Sauzal - Mexico");
	ports.put(24185,"Savanna La Mar - Jamaica");
	ports.put(1703,"SAVANNAH - United States");
	ports.put(47517,"Savona - Italy");
	ports.put(68628,"Savu - Fiji");
	ports.put(41698,"Scalloway,Shetland Is - United Kingdom");
	ports.put(27451,"Scarborough - Trinidad");
	ports.put(42306,"Schelde - Belgium");
	ports.put(42306,"Schelde Terminal - Belgium");
	ports.put(42100,"Schiedam - Netherlands");
	ports.put(3309,"SCOBEY - United States");
	ports.put(3507,"Scudder, ONT - Canada");
	ports.put(41269,"Seaforth - United Kingdom");
	ports.put(13829,"Seal Cove, NB - Canada");
	ports.put(41377,"Seal Sands - United Kingdom");
	ports.put(152,"SEARSPORT - United States");
	ports.put(3001,"SEATTLE - United States");
	ports.put(3029,"SEATTLE, TACOMA INTL. AIRPORT - United States");
	ports.put(55901,"Sebarok - Singapore");
	ports.put(12219,"Sechelt, BC - Canada");
	ports.put(13829,"Seelys Basin, NB - Canada");
	ports.put(13829,"Seelys Cove, NB - Canada");
	ports.put(13829,"Seelys Head, NB - Canada");
	ports.put(58898,"Seibu - Japan");
	ports.put(55700,"Sejingkat - Malaysia");
	ports.put(55742,"Selangor - Malaysia");
	ports.put(2827,"SELBY - United States");
	ports.put(42300,"Selzaete - Belgium");
	ports.put(56051,"Semarang - Indonesia");
	ports.put(76102,"Seme Terminal - Benin");
	ports.put(44911,"Semipalatinsk - KAZAKHSTAN");
	ports.put(45101,"Semipalatinsk - KAZAKHSTAN");
	ports.put(58897,"Sendai - Japan");
	ports.put(7440,"Senegal - Senegal");
	ports.put(56009,"Senipah Terminal - Indonesia");
	ports.put(56500,"Sepaco - Philippines");
	ports.put(35185,"Sepetiba Bay - Brazil");
	ports.put(14444,"Sept Iles, QUE - Canada");
	ports.put(55900,"Serangoon Harbor - Singapore");
	ports.put(4799,"Serbia and Montenegro - Serbia and Montenegro");
	ports.put(56150,"Seria - Brunei");
	ports.put(48465,"Serifos - Greece");
	ports.put(24500,"Seringue - Haiti");
	ports.put(48465,"Seriphos - Greece");
	ports.put(48465,"Seriphos Island - Greece");
	ports.put(6767,"Serpent Harbor, ONT - Canada");
	ports.put(42789,"Sete - France");
	ports.put(47141,"Setubal - Portugal");
	ports.put(46279,"Sevastopol - Ukraine");
	ports.put(14444,"Seven Islands, QUE - Canada");
	ports.put(46200,"Severodvinsk - Russia");
	ports.put(47039,"Sevilla - Spain");
	ports.put(47039,"Seville - Spain");
	ports.put(7800,"Seychelles - Seychelles");
	ports.put(40000,"Seydhisfjordhur - Iceland");
	ports.put(40000,"Seydisfjordur - Iceland");
	ports.put(72337,"Sfax - Tunisia");
	ports.put(42123,"sGravenhage - Netherlands");
	ports.put(57070,"Shan T ou - China");
	ports.put(57035,"Shang hai - China");
	ports.put(57035,"Shanghai - China");
	ports.put(57070,"Shantou - China");
	ports.put(52070,"Sharjah - United Arab Em");
	ports.put(41299,"Sharpness - United Kingdom");
	ports.put(3707,"SHEBOYGAN - United States");
	ports.put(41370,"Sheerness - United Kingdom");
	ports.put(13888,"Sheet Harbour, NS - Canada");
	ports.put(57018,"Shekou - China");
	ports.put(13455,"Shelburne, NS - Canada");
	ports.put(41371,"Shellhaven - United Kingdom");
	ports.put(48100,"Shengjin - Albania");
	ports.put(74799,"Sherbro - Sierra Leone");
	ports.put(3414,"SHERWOOD - United States");
	ports.put(47925,"Shibenik - Croatia");
	ports.put(58800,"Shibusi-Wan - Japan");
	ports.put(41398,"Shields - United Kingdom");
	ports.put(41398,"Shields Harbor - United Kingdom");
	ports.put(58800,"Shikama - Japan");
	ports.put(58800,"Shikamacho - Japan");
	ports.put(58301,"Shilong - China Taiwan");
	ports.put(58878,"Shimizu - Japan");
	ports.put(58814,"Shimonoseki - Japan");
	ports.put(58879,"Shimotsu - Japan");
	ports.put(58877,"Shiogama - Japan");
	ports.put(2018,"SHREVEPORT-BOSSIER CITY - United States");
	ports.put(51350,"Shuaiba - Kuwait");
	ports.put(51300,"Shuwaikh - Kuwait");
	ports.put(56500,"Siain - Philippines");
	ports.put(47925,"Sibenik - Croatia");
	ports.put(56099,"Sibolga - Indonesia");
	ports.put(56017,"Sibuco Bay - Indonesia");
	ports.put(47925,"Sibvenico - Croatia");
	ports.put(72914,"Sidi Kerir - Egypt");
	ports.put(12468,"Sidney, BC - Canada");
	ports.put(50400,"Sidon - Lebanon");
	ports.put(7470,"Sierra Leone - Sierra Leone");
	ports.put(56500,"Siete Pecados - Philippines");
	ports.put(40000,"Siglufjordhur - Iceland");
	ports.put(40000,"Siglufjordur - Iceland");
	ports.put(55500,"Sihanoukville - Cambodia");
	ports.put(55700,"Sijingkat - Malaysia");
	ports.put(40100,"Sikea - Sweden");
	ports.put(53305,"Sikka - India");
	ports.put(56500,"Silay - Philippines");
	ports.put(14092,"Sillery, QUE - Canada");
	ports.put(41299,"Silloth - United Kingdom");
	ports.put(3614,"SILVER BAY - United States");
	ports.put(58878,"Simizu - Japan");
	ports.put(79100,"Simonstown - South Africa");
	ports.put(58879,"Simotu - Japan");
	ports.put(47127,"Sines - Portugal");
	ports.put(5590,"Singapore - Singapore");
	ports.put(55976,"Singapore - Singapore");
	ports.put(64131,"Singave, Futuna - Wallis");
	ports.put(56020,"Singkawang - Indonesia");
	ports.put(56099,"Singkep Island - Indonesia");
	ports.put(76500,"Sinoe - Liberia");
	ports.put(27730,"Sint Eustatius - Neth Antilles");
	ports.put(27702,"Sint Nicolaas Baai - Aruba");
	ports.put(47558,"Siracusa - Italy");
	ports.put(50700,"Sirri Island - Iran");
	ports.put(72520,"Sirtica Terminal - Libya");
	ports.put(3115,"SITKA - United States");
	ports.put(52500,"Sitra - Bahrain");
	ports.put(52500,"Sitrah - Bahrain");
	ports.put(40900,"Sjaelland - Denmark");
	ports.put(40900,"Sjaellands Odde - Denmark");
	ports.put(40900,"Skagen - Denmark");
	ports.put(3103,"SKAGWAY - United States");
	ports.put(48476,"Skaramanga - Greece");
	ports.put(48476,"Skaramanga Bay - Greece");
	ports.put(48100,"Skele e Vlores - Albania");
	ports.put(40124,"Skelleftea - Sweden");
	ports.put(40124,"Skelleftehamn - Sweden");
	ports.put(40385,"Skien - Norway");
	ports.put(72189,"Skikda - Algeria");
	ports.put(40100,"Skogholl - Sweden");
	ports.put(40534,"Skoldvik - Finland");
	ports.put(40100,"Skonvik - Sweden");
	ports.put(40100,"Skutskar - Sweden");
	ports.put(9000,"Slate Islands, ONT - Canada");
	ports.put(41900,"Sligo - Ireland");
	ports.put(40100,"Slite - Sweden");
	ports.put(4359,"Slovakia - Slovakia");
	ports.put(4792,"Slovenia - Slovenia");
	ports.put(42165,"Sluiskil - Netherlands");
	ports.put(42165,"Sluiskill - Netherlands");
	ports.put(31523,"Smalkalden - Suriname");
	ports.put(20100,"Socorro Island - Mexico");
	ports.put(58899,"Sodegaura - Japan");
	ports.put(40174,"Soderhamn - Sweden");
	ports.put(905,"SODUS POINT - United States");
	ports.put(56099,"Soengaigerong - Indonesia");
	ports.put(56053,"Soerabaja - Indonesia");
	ports.put(56053,"Soerabaya - Indonesia");
	ports.put(52300,"Sohar - Oman");
	ports.put(52335,"Sohar - Oman");
	ports.put(47931,"Solin - Croatia");
	ports.put(6223,"Solomon Islands - Solomon Islands");
	ports.put(7700,"Somalia - Somalia");
	ports.put(5512,"Sombra, ONT - Canada");
	ports.put(24823,"Sombrero Island - Anguilla");
	ports.put(21999,"Somoza - Nicaragua");
	ports.put(40300,"Son - Norway");
	ports.put(40900,"Sonderborg - Denmark");
	ports.put(56099,"Songei Gerong - Indonesia");
	ports.put(54927,"Songkhla - Thailand");
	ports.put(54927,"Songkhla Harbor - Thailand");
	ports.put(8525,"Soo, ONT - Canada");
	ports.put(12205,"Sooke, BC - Canada");
	ports.put(40100,"Soraker - Sweden");
	ports.put(14466,"Sorel, QUE - Canada");
	ports.put(56023,"Sorong - Indonesia");
	ports.put(47500,"Sorrento - Italy");
	ports.put(56500,"Sorsogon - Philippines");
	ports.put(48406,"Souda Bay - Greece");
	ports.put(48406,"Soudha - Greece");
	ports.put(14467,"Souris, PEI - Canada");
	ports.put(72357,"Sousee - Tunisia");
	ports.put(7910,"South Africa - South Africa");
	ports.put(37200,"South Georgia - Falk Is");
	ports.put(37200,"South Orkneys - Falk Is");
	ports.put(12200,"South Pender Island, BC - Canada");
	ports.put(23645,"South Riding Point - Bahamas");
	ports.put(37200,"South Sandwich Islands - Falk Is");
	ports.put(37200,"South Shetlands - Falk Is");
	ports.put(2783,"SOUTHERN CALIFORNIA LOGISTICS AIRPORT VICTORVILLE - United States");
	ports.put(4120,"Southhampton - United Kingdom");
	ports.put(4120,"Southhampton - United Kingdom");
	ports.put(41374,"Southhampton - United Kingdom");
	ports.put(4601,"Southlake - United States");
	ports.put(46239,"Sovetskaya Gavan - Russia");
	ports.put(76281,"Soyo Oil Terminal - Angola");
	ports.put(76281,"Soyo-Quinfuquena term. - Angola");
	ports.put(4700,"Spain - Spain");
	ports.put(47931,"Spalato - Croatia");
	ports.put(23622,"Spanish Wells - Bahamas");
	ports.put(27213,"Speightstown - Barbados");
	ports.put(13400,"Spences Island, NS - Canada");
	ports.put(40398,"Spitsbergen - Sv Jm Islands");
	ports.put(47931,"Split - Croatia");
	ports.put(6767,"Spragge, ONT - Canada");
	ports.put(402,"SPRINGFIELD - United States");
	ports.put(4505,"SPRINGFIELD - United States");
	ports.put(12208,"Squamish, BC - Canada");
	ports.put(5420,"Sri Lanka - Sri Lanka");
	ports.put(54905,"Sri Racha - Thailand");
	ports.put(54905,"Sriracha - Thailand");
	ports.put(7580,"St Helena - St Helena");
	ports.put(2483,"St Kitts and Nevis - St Kitts and Nevis");
	ports.put(2487,"St Lucia - St Lucia");
	ports.put(2488,"St Vincent and the Grenadines - St Vincent and the Grenadines");
	ports.put(201,"ST. ALBANS - United States");
	ports.put(14426,"St. Andrews, NB - Canada");
	ports.put(28300,"St. Anne - Guadeloupe");
	ports.put(24100,"St. Anns Bay - Jamaica");
	ports.put(15212,"St. Anthony, NFLD - Canada");
	ports.put(28319,"St. Barthelemy - Guadeloupe");
	ports.put(28319,"St. Bartholomew - Guadeloupe");
	ports.put(28319,"St. Barths - Guadeloupe");
	ports.put(1690,"St. Catharines, ONT - Canada");
	ports.put(91149,"St. Croix - US Virgin Is");
	ports.put(79052,"St. Denis - Reunion");
	ports.put(27730,"St. Eustatius - Neth Antilles");
	ports.put(24881,"St. George - Grenada");
	ports.put(23251,"St. Georges - Bermuda");
	ports.put(24881,"St. Georges - Grenada");
	ports.put(48400,"St. Georges Bay - Greece");
	ports.put(3405,"ST. JOHN - United States");
	ports.put(24831,"St. Johns, Antigua - Antigua");
	ports.put(15282,"St. Johns, NFLD - Canada");
	ports.put(4502,"ST. JOSEPH - United States");
	ports.put(31700,"St. Laurent - French Guiana");
	ports.put(15283,"St. Lawrence, NFLD - Canada");
	ports.put(4503,"ST. LOUIS - United States");
	ports.put(42785,"St. Louis du Rhon - France");
	ports.put(27727,"St. Maarten - Neth Antilles");
	ports.put(42700,"St. Malo - France");
	ports.put(24591,"St. Marc - Haiti");
	ports.put(28300,"St. Martin - Guadeloupe");
	ports.put(27727,"St. Martin - Neth Antilles");
	ports.put(27725,"St. Michiels Bay - Neth Antilles");
	ports.put(42762,"St. Nazaire - France");
	ports.put(27702,"St. Nicolaas - Aruba");
	ports.put(40549,"St. Petersburg - Finland");
	ports.put(40549,"St. Petersburg - Russia");
	ports.put(46215,"St. Petersburg - Russia");
	ports.put(1814,"ST. PETERSBURG - United States");
	ports.put(28399,"St. Pierre - Martinique");
	ports.put(16101,"St. Pierre - St. Pierre,Miq");
	ports.put(42799,"St. Raphael - France");
	ports.put(14090,"St. Romuald, QUE - Canada");
	ports.put(2013,"ST. ROSE - United States");
	ports.put(91155,"ST. Thomas - US Virgin Is");
	ports.put(47073,"Sta. Cruz de Tenerife - Spain");
	ports.put(42879,"Stade - Germany");
	ports.put(42879,"Stadersand - Germany");
	ports.put(56020,"Stagen - Indonesia");
	ports.put(41227,"Stanlow - United Kingdom");
	ports.put(20803,"Stann Creek - Belize");
	ports.put(12475,"Stanovan, BC - Canada");
	ports.put(40387,"Stavanger - Norway");
	ports.put(40900,"Stege - Denmark");
	ports.put(40300,"Steilene - Norway");
	ports.put(40300,"Steinkjer - Norway");
	ports.put(40176,"Stenungsund - Sweden");
	ports.put(15285,"Stephenville, NL - Canada");
	ports.put(45507,"Stettin - Poland");
	ports.put(12200,"Steveston, BC - Canada");
	ports.put(61400,"Stewart Island - New Zealand");
	ports.put(12478,"Stewart, BC - Canada");
	ports.put(40971,"Stigsnaes - Denmark");
	ports.put(40971,"Stigsnaesvaerkets Havn - Denmark");
	ports.put(40100,"Stocka - Sweden");
	ports.put(40179,"Stockholm - Sweden");
	ports.put(41398,"Stockton - United Kingdom");
	ports.put(2810,"STOCKTON - United States");
	ports.put(40180,"Stockvik - Sweden");
	ports.put(40549,"ST-PETERSBURG - Russia");
	ports.put(42800,"Stralsund - Germany");
	ports.put(48400,"Stratoni - Greece");
	ports.put(40927,"Struer - Denmark");
	ports.put(40900,"Stubbekobing - Denmark");
	ports.put(40311,"Sture - Norway");
	ports.put(58302,"Su Ao - China Taiwan");
	ports.put(58302,"Suao - China Taiwan");
	ports.put(35170,"Suape - Brazil");
	ports.put(56585,"Subic Bay - Philippines");
	ports.put(7320,"Sudan - Sudan");
	ports.put(56053,"Suerbaja - Indonesia");
	ports.put(72949,"Suez - Egypt");
	ports.put(2831,"SUISUN BAY - United States");
	ports.put(56021,"Sukarnapura - Indonesia");
	ports.put(46350,"Sukhumi - Georgia");
	ports.put(48500,"Sulina - Romania");
	ports.put(41682,"Sullom Voe - United Kingdom");
	ports.put(52325,"Sultan Qaboos - Oman");
	ports.put(3009,"SUMAS - United States");
	ports.put(14470,"Summerside, PEI - Canada");
	ports.put(41376,"Sunderland - United Kingdom");
	ports.put(40182,"Sundsvall - Sweden");
	ports.put(56066,"Sungai Kolak - Indonesia");
	ports.put(56099,"Sungai Pakning - Indonesia");
	ports.put(56099,"Sungaigerong - Indonesia");
	ports.put(56099,"Sungaipakning - Indonesia");
	ports.put(56099,"Sungei Pakning - Indonesia");
	ports.put(40390,"Sunndalsora - Norway");
	ports.put(33385,"Supe - Peru");
	ports.put(3608,"SUPERIOR - United States");
	ports.put(52310,"Sur - Oman");
	ports.put(56053,"Surabaia - Indonesia");
	ports.put(56053,"Surabaja - Indonesia");
	ports.put(56053,"Surabaya - Indonesia");
	ports.put(1601,"Surgoinsvi - United States");
	ports.put(56500,"Surigao - Philippines");
	ports.put(3150,"Suriname - Suriname");
	ports.put(72357,"Susa - Tunisia");
	ports.put(47923,"Susak - Croatia");
	ports.put(47923,"Susaka - Croatia");
	ports.put(58822,"Susaki - Japan");
	ports.put(41398,"Sutton Harbor - United Kingdom");
	ports.put(68628,"Suva - Fiji");
	ports.put(68628,"Suva Harbor - Fiji");
	ports.put(40398,"Svalbard, Jan Mayen Isl - Sv Jm Islands");
	ports.put(4031,"Svalbard, Jan Mayen Island - Svalbard, Jan Mayen Island");
	ports.put(40100,"Svartvik - Sweden");
	ports.put(40392,"Svelgen - Norway");
	ports.put(40928,"Svendborg - Denmark");
	ports.put(40300,"Svolvaer - Norway");
	ports.put(41485,"Swansea - United Kingdom");
	ports.put(57070,"Swatou - China");
	ports.put(57070,"Swatow - China");
	ports.put(7950,"Swaziland - Swaziland");
	ports.put(4010,"Sweden - Sweden");
	ports.put(3310,"SWEETGRASS - United States");
	ports.put(972,"SWIFT SURE COURIER SERVICES, LTD. - United States");
	ports.put(45512,"Swinemunde - Poland");
	ports.put(45512,"Swinoujscie - Poland");
	ports.put(4776,"SWISS AIR - United States");
	ports.put(4419,"Switzerland - Switzerland");
	ports.put(60267,"Sydney - Australia");
	ports.put(13852,"Sydney, NS - Canada");
	ports.put(48400,"Syra - Greece");
	ports.put(47558,"Syracuse - Italy");
	ports.put(906,"SYRACUSE - United States");
	ports.put(5020,"Syria - Syria");
	ports.put(48466,"Syros - Greece");
	ports.put(45507,"Szczecin - Poland");
	ports.put(56588,"Tabaco - Philippines");
	ports.put(72300,"Tabarca - Tunisia");
	ports.put(72300,"Tabarqah - Tunisia");
	ports.put(22599,"Taboga Island - Panama");
	ports.put(58800,"Tachibana - Japan");
	ports.put(56589,"Tacloban - Philippines");
	ports.put(3002,"TACOMA - United States");
	ports.put(46242,"Taganrog - Russia");
	ports.put(56500,"Tagbilaran - Philippines");
	ports.put(58880,"Tagonoura - Japan");
	ports.put(56500,"Tagubanham Island - Philippines");
	ports.put(56500,"Tagum - Philippines");
	ports.put(64178,"Tahaa - French Polyn");
	ports.put(12482,"Tahsis, BC - Canada");
	ports.put(58303,"Tai Chung - China Taiwan");
	ports.put(58304,"Taibei - China Taiwan");
	ports.put(58303,"Taichung - China Taiwan");
	ports.put(58305,"Tai-Nan - China Taiwan");
	ports.put(58305,"Tainan - China Taiwan");
	ports.put(58304,"Taipei - China Taiwan");
	ports.put(56500,"Taisan - Philippines");
	ports.put(5830,"Taiwan - Taiwan");
	ports.put(4642,"Tajikistan - Tajikistan");
	ports.put(58800,"Takamatsu - Japan");
	ports.put(58800,"Taketoyo - Japan");
	ports.put(74985,"Takoradi - Ghana");
	ports.put(76284,"Takula - Angola");
	ports.put(76284,"Takula Terminal - Angola");
	ports.put(33389,"Talara - Peru");
	ports.put(33781,"Talcahuano - Chile");
	ports.put(44701,"Tallinn - Estonia");
	ports.put(56500,"Talomo - Philippines");
	ports.put(33700,"Taltal - Chile");
	ports.put(58800,"Tama - Japan");
	ports.put(78845,"Tamatave - Madagascar");
	ports.put(1801,"TAMPA - United States");
	ports.put(20193,"Tampico - Mexico");
	ports.put(58311,"Tamsui - China Taiwan");
	ports.put(58800,"Tanabe - Japan");
	ports.put(23979,"Tanamo - Cuba");
	ports.put(56594,"Tandoc - Philippines");
	ports.put(78379,"Tanga - Tanzania");
	ports.put(71425,"Tanger - Morocco");
	ports.put(71425,"Tangier - Morocco");
	ports.put(57030,"Tanjiajing - China");
	ports.put(55700,"Tanjong Mani - Malaysia");
	ports.put(56005,"Tanjong Pandan - Indonesia");
	ports.put(55750,"Tanjung Pelepas - Malaysia");
	ports.put(56033,"Tanjung Priok - Indonesia");
	ports.put(56005,"Tanjungpandan - Indonesia");
	ports.put(56000,"Tanjunguban - Indonesia");
	ports.put(7830,"Tanzania - Tanzania");
	ports.put(61443,"Taoranga - New Zealand");
	ports.put(47558,"Taormina - Italy");
	ports.put(56018,"Tarakan - Indonesia");
	ports.put(56018,"Tarakan Island - Indonesia");
	ports.put(47585,"Taranto - Italy");
	ports.put(30198,"Tarapaca - Colombia");
	ports.put(44911,"Taraz - Kazakhstan");
	ports.put(41920,"Tarbert - Ireland");
	ports.put(41920,"Tarbert Island - Ireland");
	ports.put(47032,"Tarifa - Spain");
	ports.put(47092,"Tarragona - Spain");
	ports.put(50220,"Tartous - Syria");
	ports.put(50220,"Tartus - Syria");
	ports.put(48900,"Tas Oudjou - Turkey");
	ports.put(44911,"TASHKENT - UZBEKISTAN");
	ports.put(5700,"Tashkent - Uzbekistan");
	ports.put(48900,"Tash-Uju - Turkey");
	ports.put(48900,"Tasucu - Turkey");
	ports.put(40300,"Tau - Norway");
	ports.put(61443,"Tauranga - New Zealand");
	ports.put(54600,"Tavoy - Burma");
	ports.put(55700,"Tawao - Malaysia");
	ports.put(55700,"Tawau - Malaysia");
	ports.put(75503,"Tchatamba - Gabon");
	ports.put(35107,"Tebig - Brazil");
	ports.put(2505,"TECATE - United States");
	ports.put(20195,"Tecolutla - Mexico");
	ports.put(41377,"Tees - United Kingdom");
	ports.put(41377,"Teesport - United Kingdom");
	ports.put(56055,"Tegal - Indonesia");
	ports.put(50700,"Teheran - Iran");
	ports.put(50700,"Tehran - Iran");
	ports.put(41398,"Teignmouth - United Kingdom");
	ports.put(41398,"Teignmouth Harbor - United Kingdom");
	ports.put(48999,"Tekirdag - Turkey");
	ports.put(50845,"Tel Aviv Yafo - Israel");
	ports.put(21543,"Tela - Honduras");
	ports.put(53300,"Tellicherry - India");
	ports.put(56081,"Teluk Bayur - Indonesia");
	ports.put(74990,"Tema - Ghana");
	ports.put(27446,"Tembladora - Trinidad");
	ports.put(47073,"Tenerife - Spain");
	ports.put(72100,"Tenes - Algeria");
	ports.put(33109,"Tepre - Ecuador");
	ports.put(47155,"Terceira Island - Portugal");
	ports.put(42300,"Terdonck Cluysen - Belgium");
	ports.put(42300,"Terdouk - Belgium");
	ports.put(35198,"Termisa Terminal - Brazil");
	ports.put(56064,"Ternate - Indonesia");
	ports.put(42171,"Terneuzen - Netherlands");
	ports.put(47543,"Terranova - Italy");
	ports.put(47543,"Terranova di Sicilia - Italy");
	ports.put(47569,"Terranova Pausania - Italy");
	ports.put(12206,"Texada, BC - Canada");
	ports.put(5306,"TEXAS CITY - United States");
	ports.put(5490,"Thailand - Thailand");
	ports.put(41378,"Thames Haven - United Kingdom");
	ports.put(41351,"Thamesport - United Kingdom");
	ports.put(55224,"Thanh Pho Ho Chi Minh - Vietnam");
	ports.put(42123,"The Hague - Netherlands");
	ports.put(8527,"Thessalon, ONT - Canada");
	ports.put(48471,"Thessaloniki - Greece");
	ports.put(64100,"Thio - New Caledonia");
	ports.put(40900,"Thisted - Denmark");
	ports.put(40000,"Thorlakshofn - Iceland");
	ports.put(2649,"Thorold, ONT - Canada");
	ports.put(40985,"Thorshavn - Faroe");
	ports.put(14474,"Three Rivers, QUE - Canada");
	ports.put(10101,"Thule - Greenland");
	ports.put(9662,"Thunder Bay, ONT - Canada");
	ports.put(60200,"Thursday Island - Australia");
	ports.put(57043,"Tianjin - China");
	ports.put(57043,"Tianjinxin Gang - China");
	ports.put(24500,"Tiburon - Haiti");
	ports.put(57043,"Tienching - China");
	ports.put(57043,"Tientsin - China");
	ports.put(74298,"Tiko - Cameroon");
	ports.put(46239,"Tiksi - Russia");
	ports.put(41380,"Tilbury - United Kingdom");
	ports.put(61445,"Timaru - New Zealand");
	ports.put(56067,"Timor - Indonesia");
	ports.put(75367,"Tin Can Island - Nigeria");
	ports.put(96169,"Tinian - Northern Marian");
	ports.put(56036,"Tjilatjap - Indonesia");
	ports.put(56035,"Tjirebon - Indonesia");
	ports.put(20195,"Tlacotalpan - Mexico");
	ports.put(2775,"TNT EXPRESS WORLDWIDE LA - United States");
	ports.put(971,"TNT SKYPAK, BUFFALO - United States");
	ports.put(2872,"TNT SKYPAL, SAN FRANCISCO - United States");
	ports.put(4778,"TNT SKYPATH,  JFK AIRPORT - United States");
	ports.put(78845,"Toamasina - Madagascar");
	ports.put(27400,"Tobago - Trinidad");
	ports.put(58881,"Tobata - Japan");
	ports.put(72500,"Tobruch - Libya");
	ports.put(72500,"Tobruk - Libya");
	ports.put(33788,"Tocopilla - Chile");
	ports.put(40300,"Tofte - Norway");
	ports.put(7520,"Togo - Togo");
	ports.put(6143,"Tokelau - Tokelau");
	ports.put(61471,"Tokelau - Tokelau");
	ports.put(58885,"Tokuyama - Japan");
	ports.put(58886,"Tokyo - Japan");
	ports.put(78800,"Tolaguaro - Madagascar");
	ports.put(4105,"TOLEDO-SANDUSKY - United States");
	ports.put(78800,"Toliara - Madagascar");
	ports.put(78800,"Toliary - Madagascar");
	ports.put(40500,"Tolkis - Finland");
	ports.put(40500,"Tolkkinen - Finland");
	ports.put(58811,"Tomakomai - Japan");
	ports.put(76299,"Tombua - Angola");
	ports.put(33700,"Tome - Chile");
	ports.put(40549,"Tomsk - Russia");
	ports.put(6864,"Tonga - Tonga");
	ports.put(58014,"Tonghae - South Korea");
	ports.put(42700,"Tonnay Charente - France");
	ports.put(22599,"Tonosi - Panama");
	ports.put(40300,"Tonsberg - Norway");
	ports.put(20106,"Topolobampo - Mexico");
	ports.put(40531,"Toppila - Finland");
	ports.put(40500,"Tornea - Finland");
	ports.put(40500,"Tornio - Finland");
	ports.put(1535,"Toronto, ONT - Canada");
	ports.put(48932,"Toros Gubre - Turkey");
	ports.put(47500,"Torre Annunziata - Italy");
	ports.put(24738,"Torrecilla - Dominican Republic");
	ports.put(47090,"Torrevieja - Spain");
	ports.put(40985,"Torshavn - Faroe");
	ports.put(42790,"Toulon - France");
	ports.put(55204,"Tourane - Vietnam");
	ports.put(10100,"Tovkusoak - Greenland");
	ports.put(10100,"Tovqussaq - Greenland");
	ports.put(60273,"Townsville - Australia");
	ports.put(58810,"Toyama - Japan");
	ports.put(58883,"Toyohashi - Japan");
	ports.put(58883,"Toyohasi - Japan");
	ports.put(48999,"Trabzon - Turkey");
	ports.put(1807,"Tracy, QUE - Canada");
	ports.put(41900,"Tralee - Ireland");
	ports.put(35161,"Tramandai - Brazil");
	ports.put(47598,"Trani - Italy");
	ports.put(47558,"Trapani - Italy");
	ports.put(23644,"Treasure Cay - Bahamas");
	ports.put(48999,"Trebizond - Turkey");
	ports.put(40185,"Trelleborg - Sweden");
	ports.put(2082,"TRI-CITY USERFEE AIRPORT, BLOUNTVILLE - United States");
	ports.put(47587,"Trieste");
	ports.put(47587,"Trieste - Italy");
	ports.put(47587,"Trieste - Italy");
	ports.put(54205,"Trincomalee - Sri Lanka");
	ports.put(54205,"Trincomali - Sri Lanka");
	ports.put(2740,"Trinidad and Tobago - Trinidad and Tobago");
	ports.put(50400,"Tripoli - Lebanon");
	ports.put(72525,"Tripoli - Libya");
	ports.put(14474,"Trois Rivieres, QUE - Canada");
	ports.put(40100,"Trollhattan - Sweden");
	ports.put(40100,"Trollhatte Canal - Sweden");
	ports.put(35176,"Trombetas - Brazil");
	ports.put(40338,"Tromso - Norway");
	ports.put(40397,"Trondheim - Norway");
	ports.put(41600,"Troon - United Kingdom");
	ports.put(715,"TROUT RIVER - United States");
	ports.put(21500,"Trujillo - Honduras");
	ports.put(33300,"Trujillo - Peru");
	ports.put(68205,"Truk, Truk Islands - Micronesia");
	ports.put(41398,"Truro - United Kingdom");
	ports.put(57075,"Tsamkong - China");
	ports.put(57047,"Tsingtao - China");
	ports.put(58889,"Tsukumi - Japan");
	ports.put(58800,"Tsuruga - Japan");
	ports.put(46245,"Tuapse - Russia");
	ports.put(35160,"Tubarao - Brazil");
	ports.put(40900,"Tuborg - Denmark");
	ports.put(40900,"Tuborg Havn - Denmark");
	ports.put(30700,"Tucacas - Venezuela");
	ports.put(2609,"TUCSON - United States");
	ports.put(13470,"Tuktoyaktuk, NWT - Canada");
	ports.put(62200,"Tulaghi - Solomon Is");
	ports.put(62200,"Tulagi - Solomon Is");
	ports.put(48500,"Tulcea - Romania");
	ports.put(78800,"Tulear - Madagascar");
	ports.put(5505,"TULSA - United States");
	ports.put(30152,"Tumaco - Colombia");
	ports.put(23900,"Tunas de Zaza - Cuba");
	ports.put(72373,"Tunis - Tunisia");
	ports.put(7230,"Tunisia - Tunisia");
	ports.put(30145,"Turbo - Colombia");
	ports.put(30700,"Turiamo - Venezuela");
	ports.put(4890,"Turkey - Turkey");
	ports.put(4643,"Turkmenistan - Turkmenistan");
	ports.put(40587,"Turku - Finland");
	ports.put(3306,"TURNER - United States");
	ports.put(1703,"Tuscumbia  - United States");
	ports.put(53395,"Tuticorin - India");
	ports.put(35163,"Tutoia - Brazil");
	ports.put(35163,"Tutoya - Brazil");
	ports.put(48940,"Tutunciftlik - Turkey");
	ports.put(6227,"Tuvalu - Tuvalu");
	ports.put(20197,"Tuxpan - Mexico");
	ports.put(40985,"Tvoroyri - Faroe");
	ports.put(12208,"Twin Creeks, BC - Canada");
	ports.put(41398,"Tynemouth - United Kingdom");
	ports.put(58888,"Ube - Japan");
	ports.put(12218,"Ucuelet, BC - Canada");
	ports.put(40188,"Uddevalla - Sweden");
	ports.put(7780,"Uganda - Uganda");
	ports.put(58800,"Ujina - Japan");
	ports.put(56027,"Ujung Pandang - Indonesia");
	ports.put(75323,"Ukpokiti - Nigeria");
	ports.put(4623,"Ukraine - Ukraine");
	ports.put(57047,"ULAN BATOR - MONGOLIA");
	ports.put(40531,"Uleaborg - Finland");
	ports.put(40100,"Ulfvik - Sweden");
	ports.put(58061,"Ulsan - South Korea");
	ports.put(907,"ULTICA - United States");
	ports.put(40100,"Ulvvik - Sweden");
	ports.put(40125,"Umea - Sweden");
	ports.put(58850,"Umedo - Japan");
	ports.put(50570,"Umm Qasr - Iraq");
	ports.put(51825,"Umm Said - Qatar");
	ports.put(8220,"Unidentified Countries - Unidentified Countries");
	ports.put(12491,"Union Bay, BC - Canada");
	ports.put(5200,"United Arab Emirates - United Arab Emirates");
	ports.put(4120,"United Kingdom - United Kingdom");
	ports.put(58884,"Uno - Japan");
	ports.put(58884,"Uno Ko - Japan");
	ports.put(3502,"UPS SIOUX FALL - United States");
	ports.put(3196,"UPS,ANCHORAGE - United States");
	ports.put(3295,"UPS,HONOLULU AIRPORT - United States");
	ports.put(4196,"UPS,LOUISVILLE - United States");
	ports.put(5295,"UPS,MIAMI INTL AIRPORT - United States");
	ports.put(4670,"UPS,NEWARK - United States");
	ports.put(2795,"UPS,ONTARIO - United States");
	ports.put(1195,"UPS,PHILADELPHIA - United States");
	ports.put(3071,"UPS,SEATTLE - United States");
	ports.put(3095,"UPS,SEATTLE - United States");
	ports.put(44911,"URALSK - KAZAKHSTAN");
	ports.put(40100,"Ursviken - Sweden");
	ports.put(35198,"Urucara - Brazil");
	ports.put(3550,"Uruguay - Uruguay");
	ports.put(9800,"US minor outlying Islands - US minor outlying Islands");
	ports.put(35700,"Ushuaia - Argentina");
	ports.put(46250,"UST LUGA - RUSSIA");
	ports.put(46272,"Ust-Dunaisk - Ukraine");
	ports.put(46272,"Ust-Dunaysk - Ukraine");
	ports.put(44911,"UST-KAMENOGORSK - KAZAKHSTAN");
	ports.put(40191,"Utansjo - Sweden");
	ports.put(21515,"Utila Bay - Honduras");
	ports.put(40537,"Uusikaupunki - Finland");
	ports.put(60440,"Uvol - Papua New Guinea");
	ports.put(4644,"Uzbekistan - Uzbekistan");
	ports.put(48943,"Uzunkum - Turkey");
	ports.put(40985,"Vaag - Faroe");
	ports.put(40538,"Vaasa - Finland");
	ports.put(22599,"Vacamonte - Panama");
	ports.put(47539,"Vada - Italy");
	ports.put(47540,"Vado Ligure - Italy");
	ports.put(40985,"Vagur - Faroe");
	ports.put(40100,"Vaja - Sweden");
	ports.put(40300,"Vaksdal - Norway");
	ports.put(3107,"VALDEZ - United States");
	ports.put(33700,"Valdivia - Chile");
	ports.put(47094,"Valencia - Spain");
	ports.put(41900,"Valencia Harvor - Ireland");
	ports.put(50700,"Valfajor Two Terminal - Iran");
	ports.put(40500,"Valko - Finland");
	ports.put(40500,"Valkom - Finland");
	ports.put(47305,"Valletta - Malta");
	ports.put(14067,"Valleyfield, QUE - Canada");
	ports.put(48100,"Vallona - Albania");
	ports.put(40196,"Vallvik - Sweden");
	ports.put(33797,"Valparaiso - Chile");
	ports.put(12492,"Van Anda, BC - Canada");
	ports.put(108,"VAN BUREN - United States");
	ports.put(105,"VANCEBORO - United States");
	ports.put(2908,"VANCOUVER - United States");
	ports.put(12493,"Vancouver, BC - Canada");
	ports.put(46234,"Vanino - Russia");
	ports.put(6224,"Vanuatu - Vanuatu");
	ports.put(60200,"Varanus Oil Terminal - Australia");
	ports.put(40100,"Varberg - Sweden");
	ports.put(48707,"Varna - Bulgaria");
	ports.put(40500,"Vasa - Finland");
	ports.put(49134,"Vassiliko - Cyprus");
	ports.put(40192,"Vasteras - Sweden");
	ports.put(40194,"Vastervik - Sweden");
	ports.put(68630,"Vatia Point - Fiji");
	ports.put(4752,"Vatican City - Vatican City");
	ports.put(42899,"Vegesach - Germany");
	ports.put(42899,"Vegesack - Germany");
	ports.put(40929,"Veile - Denmark");
	ports.put(40929,"Vejle - Denmark");
	ports.put(42190,"Velsen - Netherlands");
	ports.put(47595,"Venezia - Italy");
	ports.put(3070,"Venezuela - Venezuela");
	ports.put(47595,"Venice - Italy");
	ports.put(44951,"Ventspils - Latvia");
	ports.put(2712,"VENTURA - United States");
	ports.put(20199,"Veracruz - Mexico");
	ports.put(53347,"Veraval - India");
	ports.put(42742,"Verdon - France");
	ports.put(40985,"Vestmanhavn - Faroe");
	ports.put(40985,"Vestmann - Faroe");
	ports.put(40040,"Vestmannaeyjar - Iceland");
	ports.put(46220,"Viborg - Russia");
	ports.put(2015,"VICKSBURG - United States");
	ports.put(35195,"Victoria - Brazil");
	ports.put(74298,"Victoria - Cameroon");
	ports.put(55717,"Victoria - Malaysia");
	ports.put(78083,"Victoria - Seychelles");
	ports.put(6682,"Victoria Harbor, ONT - Canada");
	ports.put(12494,"Victoria, BC - Canada");
	ports.put(13456,"Victoria, PEI - Canada");
	ports.put(56500,"Victorias - Philippines");
	ports.put(5520,"Vietnam - Vietnam");
	ports.put(24867,"Vieux Fort - St. Lucia");
	ports.put(40100,"Vifstavarf - Sweden");
	ports.put(47029,"Vigo - Spain");
	ports.put(46220,"Viipuri - Russia");
	ports.put(35121,"Vila do Conde - Brazil");
	ports.put(47150,"Vila do Porto - Portugal");
	ports.put(47100,"Vila Real de San Antonio - Portugal");
	ports.put(73700,"Villa Cisneros - Western Sahara");
	ports.put(35795,"Villa Constitucion - Argentina");
	ports.put(47000,"Villagarcia - Spain");
	ports.put(47000,"Villagarcia de Arosa - Spain");
	ports.put(42799,"Villefranche - France");
	ports.put(42700,"Villequier - France");
	ports.put(35300,"Villeta - Paraguay");
	ports.put(45101,"VILNIUS - Lithuania");
	ports.put(45101,"VILNIUS - Lithuania");
	ports.put(45101,"Vilnus - Lithuania");
	ports.put(42300,"Vilvoorde - Belgium");
	ports.put(42300,"Vilvorde - Belgium");
	ports.put(47099,"Vinaroz - Spain");
	ports.put(44951,"Vindau - Latvia");
	ports.put(44951,"Vindava - Latvia");
	ports.put(40100,"Vinga - Sweden");
	ports.put(56500,"Virac - Philippines");
	ports.put(24813,"Virgin  Gorda - British Virgin");
	ports.put(9110,"Virgin Islands of the United States - Virgin Islands of the United States");
	ports.put(53399,"Visakhapatnam - India");
	ports.put(53399,"Vishakhapatnam - India");
	ports.put(45101,"VITEBSK - BEL");
	ports.put(001,"Vitebsk - Belarus");
	ports.put(001,"Vitebsk - Belarus");
	ports.put(56500,"Vito - Philippines");
	ports.put(35195,"Vitoria - Brazil");
	ports.put(40100,"Vivstava - Sweden");
	ports.put(42181,"Vlaardingen - Netherlands");
	ports.put(46238,"Vladivostok - Russia");
	ports.put(42185,"Vlissingen - Netherlands");
	ports.put(48100,"Vlore - Albania");
	ports.put(48100,"Volore - Albania");
	ports.put(48473,"Volos - Greece");
	ports.put(44911,"VORONEJ - RUSSIA");
	ports.put(44911,"Voronezh - Russia");
	ports.put(48400,"Vostitza - Greece");
	ports.put(48400,"Vostizza - Greece");
	ports.put(46231,"Vostochnyy - Russia");
	ports.put(47998,"Vranjic - Croatia");
	ports.put(68630,"Vunda Point - Fiji");
	ports.put(55206,"Vung Tau - Vietnam");
	ports.put(46220,"Vyborg - Russia");
	ports.put(72999,"Wadi Feiran - Egypt");
	ports.put(31500,"Wageningen - Suriname");
	ports.put(72179,"Wahran - Algeria");
	ports.put(58890,"Wakamatsu - Japan");
	ports.put(58890,"Wakamatsu Ko - Japan");
	ports.put(58891,"Wakayama - Japan");
	ports.put(58800,"Wakkanai - Japan");
	ports.put(3407,"WALHALLA - United States");
	ports.put(23667,"Walker Cay - Bahamas");
	ports.put(9605,"Walkerville, ONT - Canada");
	ports.put(40500,"Walkom - Finland");
	ports.put(60200,"Wallaroo - Australia");
	ports.put(40197,"Wallhamn - Sweden");
	ports.put(6413,"Wallis and Futuna - Wallis and Futuna");
	ports.put(41398,"Wallsend - United Kingdom");
	ports.put(79286,"Walvis Baai - Namibia");
	ports.put(79286,"Walvis Bay - Namibia");
	ports.put(61400,"Wanganui - New Zealand");
	ports.put(41805,"Warren Point - United Kingdom");
	ports.put(41805,"Warrenpoint - United Kingdom");
	ports.put(75387,"Warri - Nigeria");
	ports.put(60200,"Warrnambool - Australia");
	ports.put(3423,"WARROAD - United States");
	ports.put(45505,"Warszawa - Poland");
	ports.put(1001,"Washington - United States");
	ports.put(62220,"Washington Island - Kiribati");
	ports.put(5401,"WASHINGTON,DC (INCLUDES DULLES AIRPORT) - United States");
	ports.put(41910,"Waterford - Ireland");
	ports.put(12420,"Watson Island, BC - Canada");
	ports.put(3981,"WAUKEGAN REGIONAL AIRPORT - United States");
	ports.put(57000,"Wei hai - China");
	ports.put(57000,"Weihai - China");
	ports.put(60275,"Weipa - Australia");
	ports.put(2645,"Welland, ONT - Canada");
	ports.put(61447,"Wellington - New Zealand");
	ports.put(13457,"Welshpool, NB - Canada");
	ports.put(57021,"Wenzhow - China");
	ports.put(5083,"West Bank Administered by Israel - West Bank Administered by Israel");
	ports.put(23647,"West End - Bahamas");
	ports.put(5204,"WEST PALM BEACH - United States");
	ports.put(2811,"WEST SACRA - United States");
	ports.put(3301,"West Valle - United States");
	ports.put(7370,"Western Sahara - Western Sahara");
	ports.put(6150,"Western Samoa - Western Samoa");
	ports.put(60280,"Westernport - Australia");
	ports.put(3419,"WESTHOPE - United States");
	ports.put(40040,"Westman Isles - Iceland");
	ports.put(61400,"Westport - New Zealand");
	ports.put(60450,"Wewak - Papua New Guinea");
	ports.put(41398,"Weymouth - United Kingdom");
	ports.put(61400,"Whakatane - New Zealand");
	ports.put(23600,"Whale Cay - Bahamas");
	ports.put(57072,"Whampoa - China");
	ports.put(15230,"Whiffen Head, NFLD - Canada");
	ports.put(9671,"Whitby, ONT - Canada");
	ports.put(12200,"White Rock,BC - Canada");
	ports.put(9667,"Whitefish River, ONT - Canada");
	ports.put(3312,"WHITETAIL - United States");
	ports.put(3321,"WHITLASH - United States");
	ports.put(12488,"Whonnock, BC - Canada");
	ports.put(12488,"Whonok, BC - Canada");
	ports.put(60200,"Whyalla - Australia");
	ports.put(9000,"Wiarton, ONT - Canada");
	ports.put(4504,"WICHITA - United States");
	ports.put(3323,"WILDHORSE - United States");
	ports.put(42891,"Wilhelmshaven - Germany");
	ports.put(1106,"WILKES-BARRE,SCRANTON - United States");
	ports.put(27725,"Willemstad - Neth Antilles");
	ports.put(60200,"Williamstown - Australia");
	ports.put(3882,"WILLOW RUN AIRPORT - United States");
	ports.put(1103,"WILMINGTON - United States");
	ports.put(1234,"WILMINGTON - United States");
	ports.put(1501,"WILMINGTON - United States");
	ports.put(13400,"Wilsons Beach, NB - Canada");
	ports.put(3512,"Windsor, ONT - Canada");
	ports.put(1502,"WINSTON-SALEM - United States");
	ports.put(41398,"Wisbech - United Kingdom");
	ports.put(42835,"Wismar - Germany");
	ports.put(15200,"Witless Bay, NFLD - Canada");
	ports.put(57900,"Wonsan - North Korea");
	ports.put(24853,"Woodbridge Bay - Dominica");
	ports.put(12212,"Woodfibre, BC - Canada");
	ports.put(13829,"Woodwards Cove, NB - Canada");
	ports.put(403,"WORCESTER - United States");
	ports.put(41299,"Workington - United Kingdom");
	ports.put(3105,"WRANGELL - United States");
	ports.put(57000,"Wu Hu - China");
	ports.put(57013,"Wuhan - China");
	ports.put(57000,"Wuhu - China");
	ports.put(60200,"Wyndham - Australia");
	ports.put(20195,"Xcalac - Mexico");
	ports.put(57069,"Xiamen - China");
	ports.put(57017,"Xingang - China");
	ports.put(57017,"XINGANG - China");
	ports.put(57017,"XINGANG - CHINA");
	ports.put(58809,"Yaene - Japan");
	ports.put(3081,"YAKIMA AIR TERMINAL,YAKIMA - United States");
	ports.put(48475,"Yali - Greece");
	ports.put(48475,"Yali Island - Greece");
	ports.put(48971,"Yalova - Turkey");
	ports.put(46279,"Yalta - Ukraine");
	ports.put(60281,"Yamba - Australia");
	ports.put(51730,"Yambo - Saudi Arabia");
	ports.put(51730,"Yanbu - Saudi Arabia");
	ports.put(62200,"Yandina - Solomon Is");
	ports.put(46208,"Yandraknnot - Russia");
	ports.put(54601,"Yangon - Burma");
	ports.put(57055,"Yantai - China");
	ports.put(57078,"Yantian - China");
	ports.put(68209,"Yap - Micronesia");
	ports.put(48999,"Yarimca - Turkey");
	ports.put(41398,"Yarmouth - United Kingdom");
	ports.put(41398,"Yarmouth Harbor - United Kingdom");
	ports.put(13847,"Yarmouth, NS - Canada");
	ports.put(60237,"Yarraville - Australia");
	ports.put(58887,"Yatsushiro - Japan");
	ports.put(58887,"Yatsusiro - Japan");
	ports.put(20100,"Yavaros - Mexico");
	ports.put(58893,"Yawata - Japan");
	ports.put(44701,"Yekaterinburg - Russia");
	ports.put(51730,"Yenbo - Saudi Arabia");
	ports.put(57055,"Yentai - China");
	ports.put(58065,"Yeosu - South Korea");
	ports.put(48400,"Yerakini - Greece");
	ports.put(46337,"YEREVAN - ARMENIA");
	ports.put(57053,"Yingkou - China");
	ports.put(40591,"Ykspihlaja - Finland");
	ports.put(42190,"Ymuiden - Netherlands");
	ports.put(58894,"Yokkaichi - Japan");
	ports.put(58894,"Yokkaiti - Japan");
	ports.put(58895,"Yokohama - Japan");
	ports.put(58896,"Yokosuka - Japan");
	ports.put(76330,"Yombo - Congo Brazzaville");
	ports.put(58065,"Yosu - South Korea");
	ports.put(3810,"Ypsilanti - United States");
	ports.put(40100,"Ystad - Sweden");
	ports.put(58800,"Yuki - Japan");
	ports.put(23900,"Yumuri - Cuba");
	ports.put(48900,"Yumurtalik - Turkey");
	ports.put(58800,"Yura - Japan");
	ports.put(12345,"YUZHNY - RUSSIAN");
	ports.put(46275,"Yuzhnyy - Ukraine");
	ports.put(40591,"Yxpila - Finland");
	ports.put(42100,"Zaandam - Netherlands");
	ports.put(47933,"Zadar - Croatia");
	ports.put(73802,"Zafira - Equatorial Gui");
	ports.put(48467,"Zakinthos - Greece");
	ports.put(7940,"Zambia - Zambia");
	ports.put(56597,"Zamboanga - Philippines");
	ports.put(48467,"Zante - Greece");
	ports.put(78387,"Zanzibar - Tanzania");
	ports.put(35796,"Zarate - Argentina");
	ports.put(72590,"Zavia - Libya");
	ports.put(72590,"Zawia Oil Terminal - Libya");
	ports.put(42381,"Zeebrugge - Belgium");
	ports.put(72947,"Zeit Bay Terminal - Egypt");
	ports.put(47900,"Zelenika - Serbia");
	ports.put(42300,"Zelzate - Belgium");
	ports.put(57075,"Zhangjiagang - China");
	ports.put(57075,"Zhanjiang - China");
	ports.put(57075,"Zhanjiang gang - China");
	ports.put(46276,"Zhdanov - Ukraine");
	ports.put(57075,"Zhenjiang - China");
	ports.put(57079,"Zhongshan - China");
	ports.put(57077,"Zhuhai - China");
	ports.put(74499,"Ziguinchor - Senegal");
	ports.put(7960,"Zimbabwe - Zimbabwe");
	ports.put(52000,"Zirku Island - United Arab Em");
	ports.put(48900,"Zonguldak - Turkey");
	ports.put(72591,"Zuara - Libya");
	ports.put(72595,"Zuetina - Libya");
	ports.put(72591,"Zuwarah - Libya");
	ports.put(42300,"Zwijndrecht - Belgium");
	ports.put(42300,"Zwyndrecht - Belgium");


}
	
private void fillModeTrans() {
	// TODO Auto-generated method stub

	modeTrans.put(10,"VESSEL, NON-CONTAINERIZED");
	modeTrans.put(11,"VESSEL, CONTAINERIZED");
	modeTrans.put(12,"BARGE");
	modeTrans.put(20,"RAIL");
	modeTrans.put(21,"RAIL, CONTAINERIZED");
	modeTrans.put(30,"TRUCK");
	modeTrans.put(31,"TRUCK, CONTAINERIZED");
	modeTrans.put(32,"AUTO");
	modeTrans.put(33,"PEDESTRIAN");
	modeTrans.put(34,"ROAD, OTHER");
	modeTrans.put(40,"AIR");
	modeTrans.put(41,"AIR, CONTAINERIZED");
	modeTrans.put(50,"MAIL");
	modeTrans.put(60,"PASSENGER, HAND-CARRIED");
	modeTrans.put(70,"FIXED TRANSPORT INSTALLATIONS");
}










private void fillInbondTypes() {
	// TODO Auto-generated method stub
	inbondTypes.put(36,"WAREHOUSE WITHDRAWAL FOR IE");
	inbondTypes.put(37,"WAREHOUSE WITHDRAWAL FOR T AND E");
	inbondTypes.put(67,"FOREIGN TRADE ZONE WITHDRAWAL FOR IE");
	inbondTypes.put(68,"FOREIGN TRADE ZONE WITHDRAWAL FOR T AND E");
	inbondTypes.put(70,"MERCHANDISE NOT SHIPPED INBOND");
}












	public void fillPorts() {
		fillPorts1();
		fillPorts2();
		fillPorts3();
	
	}
}
