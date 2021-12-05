package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.carService.car.car;
import main.com.carService.car.carAppServiceImpl;
import main.com.carService.invoice.invoice;
import main.com.carService.invoice.invoiceAppServiceImpl;
import main.com.carService.invoice.invoiceDTO;
import main.com.carService.invoiceCars.invoiceCar;
import main.com.carService.invoiceCars.invoiceCarAppServiceImpl;
import main.com.carService.loginNeeds.user;
import main.com.carService.moneyBox.moneybox;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_details;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperAppServiceImpl;
import main.com.carService.tools.Constants;
import main.com.carService.vendor.vendor;
import main.com.carService.vendor.vendorAppServiceImpl;


@ManagedBean(name = "vendorBean")
@SessionScoped
public class vendorBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{vendorFacadeImpl}")
	private vendorAppServiceImpl vendorFacade;
	
	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	
	private List<vendor> allvendors;
	
	private vendor selectedvendor;
	
	private vendor addNewvendor;
	
	

	
	@ManagedProperty(value = "#{invoiceFacadeImpl}")
	private invoiceAppServiceImpl invoiceFacade;
	
	@ManagedProperty(value = "#{invoiceCarFacadeImpl}")
	private invoiceCarAppServiceImpl invoiceCarFacade;

	@ManagedProperty(value = "#{carFacadeImpl}")
	private carAppServiceImpl carFacade;
	
	
	private vendor vendorForInvoice;
	private invoice invoiceData;
	private List<car> carsForthisAccount;
	private List<car> carsForInvoice;
	private Integer selectedCarIdToBeAddedInInvoice;
	private Float carFeesInvoice;
	

	private List<invoiceDTO> allInvoice;
	private String dateLower;
	private String dateHigh;
	private float totalFees;
	@PostConstruct
	public void init() {
		
		refresh();
		
		selectedvendor=new vendor();
		addNewvendor=new vendor();
		user userId=new user();
		addNewvendor.setUserId(userId);
		shipper shipper_of_this_account=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewvendor.setParentId(shipper_of_this_account);
		

		invoiceData=new invoice();
	}
	
	
	public void refresh(){
		System.out.println("Ahmed Done");
		
	    
	    

		carsForthisAccount=new ArrayList<car>();
		carsForInvoice=new ArrayList<car>();
		
		
		
		//Get All Vendors For The Shipper
		//
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_SHIPPER) {
		shipper shipper_of_this_account=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
			allvendors=vendorFacade.getAllByParentId(shipper_of_this_account.getId());
			
			
			
			List<car> wareHouseMain = carFacade.getAllWareHouseForShipper(shipper_of_this_account.getId());
			List<car> dryCargoMain = carFacade.getAllDryCargoForShipper(shipper_of_this_account.getId());
			List<car> transitMain = carFacade.getAllFrightInTransitForShipper(shipper_of_this_account.getId());

			if(wareHouseMain!=null)
				carsForthisAccount.addAll(wareHouseMain);
			
			if(dryCargoMain!=null)
				carsForthisAccount.addAll(dryCargoMain);
			
			if(transitMain!=null)
				carsForthisAccount.addAll(transitMain);
			
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
			allvendors=vendorFacade.getAllByParentIdForUser(loginBean.getTheUserOfThisAccount().getId());
			
		}else {
			allvendors=new ArrayList<vendor>();
		}
		
		
		
		
		
	}
	
	
	public void getAllInvoicesBetweenDates() {
		totalFees = 0;
		Calendar lowDate = setCalendarFromString(dateLower);
		Calendar highDate = setCalendarFromString(dateHigh);
		
		allInvoice =new ArrayList<invoiceDTO>();
		List<invoice> allInvoicesForThisMainAccount =new ArrayList<invoice>();
		if(lowDate == null || highDate ==null) {
			allInvoicesForThisMainAccount = invoiceFacade.getAllByUserId(loginBean.getTheUserOfThisAccount().getId());
			
		}else {
		allInvoicesForThisMainAccount = invoiceFacade.getAllByUserIdBetweenDates(loginBean.getTheUserOfThisAccount().getId(),lowDate,highDate);
		}
		if(allInvoicesForThisMainAccount!=null) {
		if(allInvoicesForThisMainAccount.size()>0) {
		for(int i=0;i<allInvoicesForThisMainAccount.size();i++) {
			int totalFeesForInvoice = 0;
			List<invoiceCar> allCarsForThisInvoice = invoiceCarFacade.getAllByinvoiceId(allInvoicesForThisMainAccount.get(i).getId());
			for(int j=0;j<allCarsForThisInvoice.size();j++) {
				car selectedCar = allCarsForThisInvoice.get(j).getCarId();
				
				float landCost=0;
				float Seacost=0;
				float Commision=0;
				float Fees=0;
				
				
				if(selectedCar.getLandcost()!=null) landCost=selectedCar.getLandcost();
				if(selectedCar.getSeacost()!=null) Seacost=selectedCar.getSeacost();
				if(selectedCar.getCommision()!=null) Commision=selectedCar.getCommision();
				if(selectedCar.getFees()!=null) Fees=selectedCar.getFees();
				
						
				float totalForCar=(float) (landCost+Seacost
						+Commision+Fees);
				
				
				//This for total Fees Without Transfer
				totalFeesForInvoice+=totalForCar;
				
				
				//This for the total Fees With Transfer

				float trFees = 0;
				trFees=allInvoicesForThisMainAccount.get(i).getTransferFees();
			

				totalFees = totalFees + totalForCar + (totalForCar/100*trFees);
			}

			float wireFees = allInvoicesForThisMainAccount.get(i).getWireFees();

			totalFees = totalFees + wireFees;
			invoiceDTO invoicedto =new invoiceDTO();
			invoicedto.setCarsForInvoice(allCarsForThisInvoice);
			invoicedto.setInvoice(allInvoicesForThisMainAccount.get(i));
			invoicedto.setTotalPrice(totalFeesForInvoice);
			invoicedto.setNumberOfCars(allCarsForThisInvoice.size());
			
			allInvoice.add(invoicedto);
		}
		}
		}
		
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/invoice/invoiceList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Calendar setCalendarFromString(String cargoRecievedDate2) {

		Calendar cal = null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		try {
			if(cargoRecievedDate2!=null) {
			if(!cargoRecievedDate2.equals("")) {
				cal=Calendar.getInstance();
				Date date=formatter.parse(cargoRecievedDate2);
				cal.setTime(date);
			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return cal;
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
	
	
	public void addCarToInvoice() {
		car selectedCarToBeAddedInInvoice= carFacade.getById(selectedCarIdToBeAddedInInvoice);
		carsForInvoice.add(selectedCarToBeAddedInInvoice);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCarInInvoice(int indexInList) {
		carsForInvoice.remove(indexInList);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private void resetTheTotalAmountOFMoneyBoxs(invoice lastInvoice) {
		
		moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
		Integer idTrans= invoiceData.getTransactionId().getId();
		
		if(idTrans !=null) {
			moneybox_transaction_details M_B_T = loginBean.getMoneybox_transaction_detailsDataFacede().getById(idTrans);
			moneybox mBofThisVendor = loginBean.getMoneyBoxDataFacede().getById(M_B_T.getMoneyBoxId().getId());
			float amountToReturn = M_B_T.getAmount();
			
			mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney() - amountToReturn);
			
			mBofThisVendor.setAvailableMoney(mBofThisVendor.getAvailableMoney()+ amountToReturn);
			mBofThisVendor.setTotalUsed(mBofThisVendor.getTotalUsed()-amountToReturn);

			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisVendor);

			try {
				loginBean.getMoneybox_transaction_detailsDataFacede().delete(M_B_T);
				invoiceData.setTransactionId(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Problem While update!',\r\n" + 
						"			text: 'Please try Again!',\r\n" + 
						"			type: 'error',\r\n" + 
						"			left:\"1%\"\r\n" + 
						"		});");
				e.printStackTrace();
			}		
		}
		
		
	}


public void updateTheInvoice() {
	System.out.println("Ahmed: Data");
	invoice lastInvoice = invoiceFacade.getById(invoiceData.getId());
	List<invoiceCar> lastInvoiceCars = invoiceCarFacade.getAllByinvoiceId(invoiceData.getId());

	System.out.println("Ahmed: Data2");
	for(int i = 0;i<lastInvoiceCars.size();i++) {
		
		try {
			System.out.println("Ahmed: "+lastInvoiceCars.get(i).getCarId().getId());
			invoiceCarFacade.delete(lastInvoiceCars.get(i));
		} catch (Exception e) {
			System.out.println("Error: ");
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Problem While update!',\r\n" + 
					"			text: 'Please try Again!',\r\n" + 
					"			type: 'error',\r\n" + 
					"			left:\"1%\"\r\n" + 
					"		});");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Modify the MoneyBox
	if(lastInvoice.isPayedOrNot()) {
		//Modify the moneyBox
		resetTheTotalAmountOFMoneyBoxs(lastInvoice);

	}
	
	
	//add the invoice and the car list
	
	
	invoiceData.setDate(Calendar.getInstance());

	System.out.println("Ahmed:4 Data");
	invoiceFacade.addinvoice(invoiceData);
	carFeesInvoice=(float) 0;
	System.out.println("AhmedMohamed:"+ String.valueOf(carsForInvoice.size()));
	for(int i=0;i<carsForInvoice.size();i++) {
		invoiceCar carinvoice=new invoiceCar();
		carinvoice.setCarId(carsForInvoice.get(i));
		carinvoice.setInvoiceId(invoiceData);
		
		invoiceCarFacade.addinvoiceCar(carinvoice);
		float landCost=carsForInvoice.get(i).getLandcost();
		float Seacost=carsForInvoice.get(i).getSeacost();
		float Commision=carsForInvoice.get(i).getCommision();
		float Fees=carsForInvoice.get(i).getFees();
				
		float totalForCar=(float) (landCost+Seacost
				+Commision+Fees);
		
		carFeesInvoice+=totalForCar;
	}
	moneybox mBofThisVendor = loginBean.getMoneyBoxDataFacede().getByUserId(vendorForInvoice.getUserId().getId());
	moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
	
	moneybox_transaction_details M_B_T = new moneybox_transaction_details();
	
	M_B_T.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Payment.getType());
	M_B_T.setAmountBefore(mBofMainAccount.getAvailableMoney());
	
	float amount_Of_This_Invoice = invoiceData.getWireFees()+carFeesInvoice+(invoiceData.getTransferFees()/100*carFeesInvoice);
	
	M_B_T.setAmount(amount_Of_This_Invoice);
	M_B_T.setDate(new Date());
	M_B_T.setMoneyBoxId(mBofThisVendor);
	
	
	if(invoiceData.isPayedOrNot()) {
		loginBean.getMoneybox_transaction_detailsDataFacede().addmoneybox_transaction_details(M_B_T);
		mBofThisVendor.setTotalUsed(mBofThisVendor.getTotalUsed()+amount_Of_This_Invoice);
		mBofThisVendor.setAvailableMoney(mBofThisVendor.getAvailableMoney()-amount_Of_This_Invoice);
		 
		
		mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney()+amount_Of_This_Invoice);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisVendor);
		
		
		invoiceData.setTransactionId(M_B_T);
		invoiceFacade.addinvoice(invoiceData);
		
	}
	
	
	try {
		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/vendor/invoice/invoice.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	public void getTheInvoiceData(int invoiceId) {
		invoiceData = invoiceFacade.getById(invoiceId);
		

		vendorForInvoice=vendorFacade.getByUserId(invoiceData.getUserIdCustomer().getId());
carsForthisAccount=new ArrayList<car>();
		
		List<car> wareHouseMain = carFacade.getAllWareHouseForVendor(vendorForInvoice.getId());
		List<car> dryCargoMain = carFacade.getAllDryCargoForVendor(vendorForInvoice.getId());
		List<car> transitMain = carFacade.getAllFrightInTransitForVendor(vendorForInvoice.getId());

		if(wareHouseMain!=null)
			carsForthisAccount.addAll(wareHouseMain);
			
		if(dryCargoMain!=null)
			carsForthisAccount.addAll(dryCargoMain);
			
		if(transitMain!=null)
			carsForthisAccount.addAll(transitMain);
			
		
		List<invoiceCar> listOfCarsInvoices = invoiceCarFacade.getAllByinvoiceId(invoiceId);
		carsForInvoice = new ArrayList<car>();
		for(int i = 0;i<listOfCarsInvoices.size();i++) {
			carsForInvoice.add(carFacade.getById(listOfCarsInvoices.get(i).getCarId().getId()));
		}
		
		

		try {

			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/invoice/invoiceEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void saveInvoiceData() {

		invoiceData.setUserIdCustomer(vendorForInvoice.getUserId());
		invoiceData.setUserIdIssuer(loginBean.getTheUserOfThisAccount());
		invoiceData.setRole(user.ROLE_VENDOR);
		invoiceData.setDate(Calendar.getInstance());
		
		invoiceFacade.addinvoice(invoiceData);
		carFeesInvoice=(float) 0;
		for(int i=0;i<carsForInvoice.size();i++) {
			invoiceCar carinvoice=new invoiceCar();
			carinvoice.setCarId(carsForInvoice.get(i));
			carinvoice.setInvoiceId(invoiceData);
			
			invoiceCarFacade.addinvoiceCar(carinvoice);
			float landCost=carsForInvoice.get(i).getLandcost();
			float Seacost=carsForInvoice.get(i).getSeacost();
			float Commision=carsForInvoice.get(i).getCommision();
			float Fees=carsForInvoice.get(i).getFees();
					
			float totalForCar=(float) (landCost+Seacost
					+Commision+Fees);
			
			carFeesInvoice+=totalForCar;
		}
		moneybox mBofThisVendor = loginBean.getMoneyBoxDataFacede().getByUserId(vendorForInvoice.getUserId().getId());
		moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
		
		moneybox_transaction_details M_B_T = new moneybox_transaction_details();
		M_B_T.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Payment.getType());
		M_B_T.setAmountBefore(mBofMainAccount.getAvailableMoney());
		
		float amount_Of_This_Invoice = invoiceData.getWireFees()+carFeesInvoice+(invoiceData.getTransferFees()/100*carFeesInvoice);
		
		M_B_T.setAmount(amount_Of_This_Invoice);
		M_B_T.setDate(new Date());
		M_B_T.setMoneyBoxId(mBofThisVendor);
		
		if(invoiceData.isPayedOrNot()) {
			loginBean.getMoneybox_transaction_detailsDataFacede().addmoneybox_transaction_details(M_B_T);
			mBofThisVendor.setTotalUsed(mBofThisVendor.getTotalUsed()+amount_Of_This_Invoice);
			mBofThisVendor.setAvailableMoney(mBofThisVendor.getAvailableMoney()-amount_Of_This_Invoice);
			 
			
			mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney()+amount_Of_This_Invoice);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisVendor);

			invoiceData.setTransactionId(M_B_T);
			invoiceFacade.addinvoice(invoiceData);
		}
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/invoice/invoice.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void invoiceDetails(int vendorId) {
		

		invoiceData=new invoice();
		vendorForInvoice=vendorFacade.getById(vendorId);
		moneybox mB= loginBean.getThisAccountMoneyBox();
		
		invoiceData.setBankAccountNumber(mB.getBankAccountNumber());
		invoiceData.setBankAddress(mB.getBankAddress());
		invoiceData.setBankName(mB.getBankName());
		invoiceData.setBankTelephone(mB.getBankTelephone());
		

		carsForthisAccount=new ArrayList<car>();
		
		List<car> wareHouseMain = carFacade.getAllWareHouseForVendor(vendorId);
		List<car> dryCargoMain = carFacade.getAllDryCargoForVendor(vendorId);
		List<car> transitMain = carFacade.getAllFrightInTransitForVendor(vendorId);

		if(wareHouseMain!=null)
			carsForthisAccount.addAll(wareHouseMain);
			
		if(dryCargoMain!=null)
			carsForthisAccount.addAll(dryCargoMain);
			
		if(transitMain!=null)
			carsForthisAccount.addAll(transitMain);
			
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/invoice/invoiceAdd.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void goToAddNewvendor() {
		addNewvendor=new vendor();
		user userId=new user();
		addNewvendor.setUserId(userId);
		shipper shipper_of_this_account=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		addNewvendor.setParentId(shipper_of_this_account);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/vendorAddNew.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectvendor(int idvendor) {
		selectedvendor=vendorFacade.getById(idvendor);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/vendorEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void saveNewvendorData() {
		user userNew= addNewvendor.getUserId();
		
		boolean isValid=checkValidForUser(addNewvendor);
		if(isValid) {
			boolean checkUserName = checkUserNameIsExist(addNewvendor.getUserId().getUserName());
			if(checkUserName) {
		userNew.setDate(Calendar.getInstance());
		userNew.setRole(user.ROLE_VENDOR);
		userNew.setPassword(new  Md5PasswordEncoder().encodePassword(userNew.getUserName(),userNew.getUserName()));
		userNew.setMainUserId(loginBean.getTheMainUserOfThisAccount());
		
		
		loginBean.getUserDataFacede().adduser(userNew);
		

		moneybox mB = new moneybox();
		mB.setActive(true);
		mB.setUserId(userNew);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mB);
		
		shipper shipper_of_this_account=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewvendor.setParentId(shipper_of_this_account);
		vendorFacade.addvendor(addNewvendor);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your vendor has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		Constants.sendEmailNewAccount(addNewvendor.getUserId().getFirstName(),addNewvendor.getUserId().getEmail(),addNewvendor.getUserId().getUserName());
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/vendorList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else {
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Check this ',\r\n" + 
						"			text: 'This userName is already Registered',\r\n" + 
						"			left:\"2%\"\r\n" + 
						"		});");
			}
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}

	private boolean checkUserNameIsExist(String userName) {
		// TODO Auto-generated method stub
		
		user the_user=loginBean.getUserDataFacede().getByUserName(userName);
		if(the_user!=null) {
			return false;
		}
		return true;
	}

	private boolean checkValidForUser(vendor addNewvendor2) {
		// TODO Auto-generated method stub
		if(addNewvendor2.getUserId().getCompany().equals("")||addNewvendor2.getUserId().getCompany()==null) {
			return false;
		}
		
		if(addNewvendor2.getUserId().getUserName().equals("")||addNewvendor2.getUserId().getUserName()==null) {
			return false;
		}
		
		if(addNewvendor2.getUserId().getFirstName().equals("")||addNewvendor2.getUserId().getFirstName()==null) {
			return false;
		}
		
		if(addNewvendor2.getUserId().getLastName().equals("")||addNewvendor2.getUserId().getLastName()==null) {
			return false;
		}
		
		if(addNewvendor2.getUserId().getEmail().equals("")||addNewvendor2.getUserId().getEmail()==null) {
			return false;
		}
		
		return true;
	}

	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/vendorList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateData() {

		boolean isValid=checkValidForUser(selectedvendor);
		if(isValid) {
		loginBean.getUserDataFacede().adduser(selectedvendor.getUserId());
		
		vendorFacade.addvendor(selectedvendor);

		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your data has been updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
			
		}
	}

	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public vendorAppServiceImpl getvendorFacade() {
		return vendorFacade;
	}

	public void setvendorFacade(vendorAppServiceImpl vendorFacade) {
		this.vendorFacade = vendorFacade;
	}

	public List<vendor> getAllvendors() {
		return allvendors;
	}

	public void setAllvendors(List<vendor> allvendors) {
		this.allvendors = allvendors;
	}

	public vendor getSelectedvendor() {
		return selectedvendor;
	}

	public void setSelectedvendor(vendor selectedvendor) {
		this.selectedvendor = selectedvendor;
	}

	public vendor getAddNewvendor() {
		return addNewvendor;
	}

	public void setAddNewvendor(vendor addNewvendor) {
		this.addNewvendor = addNewvendor;
	}

	public vendorAppServiceImpl getVendorFacade() {
		return vendorFacade;
	}

	public void setVendorFacade(vendorAppServiceImpl vendorFacade) {
		this.vendorFacade = vendorFacade;
	}

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}

	public invoiceAppServiceImpl getInvoiceFacade() {
		return invoiceFacade;
	}

	public void setInvoiceFacade(invoiceAppServiceImpl invoiceFacade) {
		this.invoiceFacade = invoiceFacade;
	}

	public invoiceCarAppServiceImpl getInvoiceCarFacade() {
		return invoiceCarFacade;
	}

	public void setInvoiceCarFacade(invoiceCarAppServiceImpl invoiceCarFacade) {
		this.invoiceCarFacade = invoiceCarFacade;
	}

	public carAppServiceImpl getCarFacade() {
		return carFacade;
	}

	public void setCarFacade(carAppServiceImpl carFacade) {
		this.carFacade = carFacade;
	}

	
	public vendor getVendorForInvoice() {
		return vendorForInvoice;
	}

	public void setVendorForInvoice(vendor vendorForInvoice) {
		this.vendorForInvoice = vendorForInvoice;
	}

	public invoice getInvoiceData() {
		return invoiceData;
	}

	public void setInvoiceData(invoice invoiceData) {
		this.invoiceData = invoiceData;
	}

	public List<car> getCarsForthisAccount() {
		return carsForthisAccount;
	}

	public void setCarsForthisAccount(List<car> carsForthisAccount) {
		this.carsForthisAccount = carsForthisAccount;
	}

	public List<car> getCarsForInvoice() {
		return carsForInvoice;
	}

	public void setCarsForInvoice(List<car> carsForInvoice) {
		this.carsForInvoice = carsForInvoice;
	}

	public Integer getSelectedCarIdToBeAddedInInvoice() {
		return selectedCarIdToBeAddedInInvoice;
	}

	public void setSelectedCarIdToBeAddedInInvoice(Integer selectedCarIdToBeAddedInInvoice) {
		this.selectedCarIdToBeAddedInInvoice = selectedCarIdToBeAddedInInvoice;
	}

	public Float getCarFeesInvoice() {
		return carFeesInvoice;
	}

	public void setCarFeesInvoice(Float carFeesInvoice) {
		this.carFeesInvoice = carFeesInvoice;
	}

	public List<invoiceDTO> getAllInvoice() {
		return allInvoice;
	}

	public void setAllInvoice(List<invoiceDTO> allInvoice) {
		this.allInvoice = allInvoice;
	}

	public String getDateLower() {
		return dateLower;
	}

	public void setDateLower(String dateLower) {
		this.dateLower = dateLower;
	}

	public String getDateHigh() {
		return dateHigh;
	}

	public void setDateHigh(String dateHigh) {
		this.dateHigh = dateHigh;
	}

	public float getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(float totalFees) {
		this.totalFees = totalFees;
	}

	
	
	

	
	
}
