package main.com.carService.Beans;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

import helpers.retrofit.mainFiles.APIClient;
import helpers.retrofit.mainFiles.APIInterface;
import helpers.retrofit.mainFiles.OrderOutDetails;
import main.com.carService.loginNeeds.user;
import main.com.carService.mainTwo.mainTwo;
import main.com.carService.mainTwo.mainTwoAppServiceImpl;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperAppServiceImpl;
import main.com.carService.tools.Constants;
import main.com.carService.vendor.vendor;
import main.com.carService.vendor.vendorAppServiceImpl;
import retrofit2.Call;
import main.com.carService.car.car;
import main.com.carService.car.carAppServiceImpl;
import main.com.carService.carImage.carimage;
import main.com.carService.carImage.carimageAppServiceImpl;
import main.com.carService.consignee.consignee;
import main.com.carService.consignee.consigneeAppServiceImpl;
import main.com.carService.customer.customer;
import main.com.carService.customer.customerAppServiceImpl;


@ManagedBean(name = "carBean")
@SessionScoped
public class carBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{consigneeFacadeImpl}")
	private consigneeAppServiceImpl consigneeFacade;

	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	

	@ManagedProperty(value = "#{mainTwoFacadeImpl}")
	private mainTwoAppServiceImpl mainTwoFacade;
	

	@ManagedProperty(value = "#{carFacadeImpl}")
	private carAppServiceImpl carFacade;
	

	@ManagedProperty(value = "#{vendorFacadeImpl}")
	private vendorAppServiceImpl vendorFacade;
	

	@ManagedProperty(value = "#{customerFacadeImpl}")
	private customerAppServiceImpl customerFacade;
	
	@ManagedProperty(value = "#{carimageFacadeImpl}")
	private carimageAppServiceImpl carimageFacade;
	
	private int selectedCarState=0; 
	private List<car> allCars;
	private List<car> allSelectedCars;
	private List<consignee> allconsignees;
	private List<mainTwo> allMainTwo;
	private List<shipper> allshipper;
	private List<vendor> allvendor;
	private List<customer> allcustomer;
	
	private car selectedCar;
	private car addNewCar;
	
	
	private List<String> carStates;
	

	private  String cargoRecievedDate;
	private  String releaseDate;
	private  String stRecievedDate;
	private  String etdDate;
	private  String etaDate;
	private  String storageStartDate;
	private  String storageEndDate;

	private int mainTwoSelectedId;
	private int shipperSelectedId;
	private int vendorSelectedId;
	private int customerSelectedId;

	private List<String> images;
	private List<String> docs;
	private List<String> pdfs;
	private List<String> loadingImages;
	
	
	
	private List<String> images_deleted;
	private List<String> docs_deleted;
	private List<String> pdfs_deleted;
	private List<String> loadingImages_deleted;
	

	private Map<Integer, String> distinationMap;
	private Map<Integer, String> origineMap;
	
	

	private List<String> visibilityOptions;
	
	
	private int consigneeId;
	private consignee selectedConsignee;

	private  Integer titleRecievedSelected;
	private boolean progress=false;
	
	private String pdfView="";
	
	
	private List<car> allCarsToContainer;
	private String containerName;
	private String containerLink;
	private String countryForContainer;
	private String portForContainer;
	private String stateForContainer;
	private Integer shipperIdOFContainer;
	
	
	private int numberOfAny = 0;
	@PostConstruct
	public void init() {
		distinationMap=new LinkedHashMap<Integer,String>();
		origineMap=new LinkedHashMap<Integer,String>();
		fillMap();
		
		visibilityOptions = new ArrayList<String>();
		
		for(int i=0;i<14;i++) {
			visibilityOptions.add("true");
		}
		
		carStates = new ArrayList<String>();
		for(int i=0;i<car.stateString.length;i++) {
			carStates.add(car.stateString[i]);
		}
		refresh();
		
		

		selectedCarState=0;
	}
	
	
	
	public void releaseVariablesForMain() {
		images=new ArrayList<String>();
		docs=new ArrayList<String>();
		pdfs=new ArrayList<String>();
		loadingImages=new ArrayList<String>();

		images_deleted=new ArrayList<String>();
		docs_deleted=new ArrayList<String>();
		pdfs_deleted=new ArrayList<String>();
		loadingImages_deleted=new ArrayList<String>();
		cargoRecievedDate="";
		titleRecievedSelected=0;
		releaseDate="";
		stRecievedDate="";
		etdDate="";
		etaDate="";
		storageStartDate="";
		storageEndDate="";
		
		addNewCar=new car();
		user userId=new user();
		shipper shipperID=new shipper();

		addNewCar.setMainId(userId);
		addNewCar.setShipperId(shipperID);

		allCars=new ArrayList<car>();
		
		filterCarBySelectFirstTime();
	}
	
	public void releaseVariablesForMainTwo() {
		images=new ArrayList<String>();
		docs=new ArrayList<String>();
		pdfs=new ArrayList<String>();
		loadingImages=new ArrayList<String>();

		images_deleted=new ArrayList<String>();
		docs_deleted=new ArrayList<String>();
		pdfs_deleted=new ArrayList<String>();
		loadingImages_deleted=new ArrayList<>();
		cargoRecievedDate="";
		titleRecievedSelected=0;
		releaseDate="";
		stRecievedDate="";
		etdDate="";
		etaDate="";
		storageStartDate="";
		storageEndDate="";
		
		addNewCar=new car();
		user userId=new user();
		shipper shipperID=new shipper();

		addNewCar.setMainId(userId);
		addNewCar.setShipperId(shipperID);

		allCars=new ArrayList<car>();
		
		filterCarBySelectFirstTime();
		
	}
	public void releaseVariablesForShipper() {
		images=new ArrayList<String>();
		docs=new ArrayList<String>();
		pdfs=new ArrayList<String>();
		loadingImages=new ArrayList<String>();

		images_deleted=new ArrayList<String>();
		docs_deleted=new ArrayList<String>();
		pdfs_deleted=new ArrayList<String>();
		loadingImages_deleted=new ArrayList<>();
		cargoRecievedDate="";
		titleRecievedSelected=0;
		releaseDate="";
		stRecievedDate="";
		etdDate="";
		etaDate="";
		storageStartDate="";
		storageEndDate="";
		consigneeId=-1;
		
		addNewCar=new car();
		vendor vendorNew=new vendor();
		
		selectedConsignee=new consignee();

		addNewCar.setVendorId(vendorNew);
		
		filterCarBySelectFirstTime();
	}
	
	
	public void releaseVariablesForRemind() {
		images=new ArrayList<String>();
		docs=new ArrayList<String>();
		pdfs=new ArrayList<String>();
		loadingImages=new ArrayList<String>();

		images_deleted=new ArrayList<String>();
		docs_deleted=new ArrayList<String>();
		pdfs_deleted=new ArrayList<String>();
		loadingImages_deleted=new ArrayList<>();
		consigneeId=-1;
		
		
		selectedConsignee=new consignee();

		
		filterCarBySelectFirstTime();
	}
	
	
	public void refresh(){
		mainTwoSelectedId=-1;
		shipperSelectedId=-1;
		vendorSelectedId=-1;
		customerSelectedId=-1;
		
		progress=false;
		int role=loginBean.getTheUserOfThisAccount().getRole();
		if(role==user.ROLE_MAIN) {
			releaseVariablesForMain();
			addNewCar.setMainId(loginBean.getTheUserOfThisAccount());
			allshipper = shipperFacade.getAllByParentId(loginBean.getTheUserOfThisAccount().getId());
			allvendor=vendorFacade.getAllByParentIdForUser(loginBean.getTheUserOfThisAccount().getId());
			allMainTwo=mainTwoFacade.getAllByParentId(loginBean.getTheUserOfThisAccount().getId());
		}else if(role==user.ROLE_MAIN2) {
			releaseVariablesForMainTwo();
			mainTwo mainTwoOfThisAccount=mainTwoFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			addNewCar.setMainTwoId(mainTwoOfThisAccount);
			addNewCar.setMainId(mainTwoOfThisAccount.getParentId());
			allshipper = shipperFacade.getAllByParentId(mainTwoOfThisAccount.getParentId().getId());
			allvendor=vendorFacade.getAllByParentIdForUser(mainTwoOfThisAccount.getParentId().getId());
			
		}else if(role==user.ROLE_SHIPPER) {
			releaseVariablesForShipper();
			shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			addNewCar.setShipperId(shipperOfThisAccount);
			addNewCar.setMainId(shipperOfThisAccount.getParentId());
			allvendor=vendorFacade.getAllByParentId(shipperOfThisAccount.getId());
			allconsignees=consigneeFacade.getAllByParentId(shipperOfThisAccount.getId());
			
		}else if(role==user.ROLE_VENDOR) {
			releaseVariablesForRemind();
			vendor vendorOfThisAccount=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			allcustomer=customerFacade.getAllByParentId(vendorOfThisAccount.getId());
			
		}else if(role==user.ROLE_CUSTOMER) {
			releaseVariablesForRemind();
			
			
		}else if(role==user.ROLE_CONGSIGNEE) {
			releaseVariablesForRemind();
			
			
		}
		
	}
	
	
	public void openImageLink() {
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("imagesOfCarId")[0]);
				if(id!=null){
					selectedCar=carFacade.getById(id);
					

					images=new ArrayList<String>();
					docs=new ArrayList<String>();
					pdfs=new ArrayList<String>();
					loadingImages=new ArrayList<String>();

					images_deleted=new ArrayList<String>();
					docs_deleted=new ArrayList<String>();
					pdfs_deleted=new ArrayList<String>();
					loadingImages_deleted=new ArrayList<>();
					
					List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
					List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
					List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
					List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
					
					if(imagesOfCar!=null) {
						for(int i=0;i<imagesOfCar.size();i++) {
							images.add(imagesOfCar.get(i).getUrl());
						}
					}
					if(docsOfCar!=null){
						for(int i=0;i<docsOfCar.size();i++) {
							docs.add(docsOfCar.get(i).getUrl());
						}
					}
					
					
					if(pdfsOfCar!=null){
						for(int i=0;i<pdfsOfCar.size();i++) {
							pdfs.add(pdfsOfCar.get(i).getUrl());
						}
					}
					
					
					if(imageLoadingOfCar!=null){
						for(int i=0;i<imageLoadingOfCar.size();i++) {
							loadingImages.add(imageLoadingOfCar.get(i).getUrl());
						}
					}
					
					FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainPanel");
					
				}
			}
		catch(Exception ex){
			 
		}
		
	}
	
	public void theloaderFirst() {
		
			progress=true;
			refreshUpdatecCarData();
		
	}
	public void refreshUpdatecCarData() {

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtModel");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtMake");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtYear");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtAssemblyCountry");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtBodyStyle");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtEngineType");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:ctl00_BodyHolder_txtEngineLiters");
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:searchButton");
	}
	
	public void getCarWithVinNew() {
		if(!addNewCar.getUuid().equals("")) {
			
		APIInterface apiInterface = APIClient.getClient(addNewCar.getUuid()+"/").create(APIInterface.class);
		  Call<OrderOutDetails> call = apiInterface.performOrder();
	        try {
	        	OrderOutDetails car= call.execute().body();

	        	addNewCar.setMake(car.Results.get(0).Make);
	        	addNewCar.setModel(car.Results.get(0).Model);
	        	addNewCar.setYear(car.Results.get(0).ModelYear);
	        	addNewCar.setAssemlyCountry(car.Results.get(0).PlantCountry);
	        	addNewCar.setBodyStyle(car.Results.get(0).DriveType);
	        	addNewCar.setEngineLiters(car.Results.get(0).DisplacementL);
	        	addNewCar.setEngineType(car.Results.get(0).EngineConfiguration+"- "+car.Results.get(0).EngineCylinders+" Cylinders");


				progress=false;
				refreshUpdatecCarData();
	          	  
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				progress=false;
				refreshUpdatecCarData();
			}
		}else {
			progress=false;
			refreshUpdatecCarData();
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Please enter the Vin number',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}
	
	public void filterCarBySelectFirstTime() {

		allCars=new ArrayList<car>();
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
			numberOfAny = loginBean.getTheUserOfThisAccount().getId();
			/*if(selectedCarState==0) {
				//This for warehouse

				allCars = carFacade.getAllWareHouseForMainUser(loginBean.getTheUserOfThisAccount().getId());

				
				

			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForMainUser(loginBean.getTheUserOfThisAccount().getId());

				
				
			

			}else if(selectedCarState==2) {
				
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForMainUser(loginBean.getTheUserOfThisAccount().getId());

				
				
				

			}else if(selectedCarState==4) {
				
				// this for freight in transit

				allCars = carFacade.getAllFrightSentForPaymentForMainUser(loginBean.getTheUserOfThisAccount().getId());

				
				
				

			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForMainUser(loginBean.getTheUserOfThisAccount().getId());
				
				

			}*/
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_SHIPPER) {

			shipper shipperNewId=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			numberOfAny = shipperNewId.getId();
			/*if(selectedCarState==0) {
				//This for warehouse
				allCars = carFacade.getAllWareHouseForShipper(shipperNewId.getId());

				
				

			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForShipper(shipperNewId.getId());

				
				
				
			}else if(selectedCarState==2) {
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForShipper(shipperNewId.getId());


			}else if(selectedCarState==4) {
				// this for freight sent for payment

				allCars = carFacade.getAllFrightSentForPaymentForShipper(shipperNewId.getId());

				

			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForShipper(shipperNewId.getId());
				

			}*/
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN2) {

			mainTwo mainTwoId=mainTwoFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			numberOfAny = mainTwoId.getId();
			/*if(selectedCarState==0) {
				//This for warehouse
				allCars = carFacade.getAllWareHouseForMainUserTwo(mainTwoId.getId());

				
			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForMainUserTwo(mainTwoId.getId());

				
			}else if(selectedCarState==2) {
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForMainUserTwo(mainTwoId.getId());

				
			}else if(selectedCarState==4) {
				// this for freight sent for payment

				allCars = carFacade.getAllFrightSentForPaymentForMainUserTwo(mainTwoId.getId());

				
				
			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForMainUserTwo(mainTwoId.getId());
				
			}*/
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_VENDOR) {

			vendor vendorNewId=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			numberOfAny = vendorNewId.getId();
			/*if(selectedCarState==0) {
				//This for warehouse
				allCars = carFacade.getAllWareHouseForVendor(vendorNewId.getId());

			
			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForVendor(vendorNewId.getId());

			}else if(selectedCarState==2) {
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForVendor(vendorNewId.getId());

			}else if(selectedCarState==4) {
				// this for freight Sent

				allCars = carFacade.getAllFrightSentForPaymentForVendor(vendorNewId.getId());

			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForVendor(vendorNewId.getId());
				
			}*/
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_CUSTOMER) {

			customer customerNewId=customerFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			numberOfAny = customerNewId.getId();
			/*if(selectedCarState==0) {
				//This for warehouse
				allCars = carFacade.getAllWareHouseForCustomer(customerNewId.getId());

			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForCustomer(customerNewId.getId());

			}else if(selectedCarState==2) {
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForCustomer(customerNewId.getId());

			}else if(selectedCarState==4) {
				// this for freight in transit

				allCars = carFacade.getAllFrightSentForPaymentForCustomer(customerNewId.getId());

			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForCustomer(customerNewId.getId());
				
			}*/
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_CONGSIGNEE) {

			List<consignee> consigneeNewId=consigneeFacade.getAllByUserId(loginBean.getTheUserOfThisAccount().getId());
			
			
			for(int i=0;i<consigneeNewId.size();i++ ) {
				numberOfAny = consigneeNewId.get(i).getId();
			/*if(selectedCarState==0) {
				//This for warehouse
				allCars = carFacade.getAllWareHouseForConsignee(consigneeNewId.get(i).getId());

			}else if(selectedCarState==1) {
				// this for dry cargo

				allCars = carFacade.getAllDryCargoForConsignee(consigneeNewId.get(i).getId());

			}else if(selectedCarState==2) {
				// this for freight in transit

				allCars = carFacade.getAllFrightInTransitForConsignee(consigneeNewId.get(i).getId());

			}else if(selectedCarState==4) {
				// this for freight Sent

				allCars = carFacade.getAllFrightSentForPaymentForConsignee(consigneeNewId.get(i).getId());

			}else if(selectedCarState==3) {
				//this for all

				allCars = carFacade.getAllForConsignee(consigneeNewId.get(i).getId());
				
			}*/
			
		}
		}
		
		
		
		
		
	}
	
	
	public void filterCarBySelect() {
		filterCarBySelectFirstTime();
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToAddNewcarShipper() {
		refresh();
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/car/vitView.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectConsignee() {
		selectedConsignee = consigneeFacade.getById(consigneeId);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:consigneePanel");
		
	}
	/**
	 * 
	 * save date for the shipper
	 */
	//Save the New Car with the shipper Account
		public void saveNewCarDatashipper() {
			
			addNewCar.setCommentToSend("");
			addNewCar.setContainerLink("");
			addNewCar.setEmailToSendComment("");
			boolean isValid=checkValidForCar(addNewCar);
			//boolean checkVendor=checkVendorIsExist(addNewCar.getVendorId());
			//if(isValid&&checkVendor) {
			if(isValid) {
				boolean checkCar = checkCarIsExist(addNewCar.getUuid());
				
				if(checkCar) {
			consignee consigneeNew=consigneeFacade.getById(consigneeId);
			addNewCar.setConsigneeId(consigneeNew);
			addNewCar.setState(car.STATE_WARE_HOUSE_1);
			carFacade.addcar(addNewCar);
			
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Success',\r\n" + 
					"			text: 'Your car has been added.',\r\n" + 
					"			type: 'success'\r\n" + 
					"		});");
			
			try {
				FacesContext.getCurrentInstance()
				   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}else {
					PrimeFaces.current().executeScript("new PNotify({\r\n" + 
							"			title: 'Check this ',\r\n" + 
							"			text: 'This car is already Registered',\r\n" + 
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

		public boolean checkCustomerIsExist(customer customerExist) {
			if(customerExist!=null) {
				if(customerExist.getId()!=null&&customerExist.getId()!=-1) {
					
				return true;

				}
				}
			
			return false;
		}
		
		public boolean checkVendorIsExist(vendor vendorExist) {
			if(vendorExist!=null) {
				if(vendorExist.getId()!=null&&vendorExist.getId()!=-1) {
					
				return true;

				}
				}
			
			return false;
		}
		public void refreshSelectedCarMain() {
			List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
			List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
			List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
			List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
			
			if(imagesOfCar!=null) {
				for(int i=0;i<imagesOfCar.size();i++) {
					images.add(imagesOfCar.get(i).getUrl());
				}
			}
			if(docsOfCar!=null){
				for(int i=0;i<docsOfCar.size();i++) {
					docs.add(docsOfCar.get(i).getUrl());
				}
			}
			
			
			if(pdfsOfCar!=null){
				for(int i=0;i<pdfsOfCar.size();i++) {
					pdfs.add(pdfsOfCar.get(i).getUrl());
				}
			}
			
			if(imageLoadingOfCar!=null){
				for(int i=0;i<imageLoadingOfCar.size();i++) {
					loadingImages.add(imageLoadingOfCar.get(i).getUrl());
				}
			}
			
			cargoRecievedDate=getStringFromCalendar(selectedCar.getCargoRecieved());
			releaseDate=getStringFromCalendar(selectedCar.getReleaseDate());
			stRecievedDate=getStringFromCalendar(selectedCar.getStRecieved());
			etdDate=getStringFromCalendar(selectedCar.getEtd());
			etaDate=getStringFromCalendar(selectedCar.getEta());
			storageStartDate=getStringFromCalendar(selectedCar.getStorageStartDate());
			storageEndDate=getStringFromCalendar(selectedCar.getStorageEndDate());

			titleRecievedSelected=selectedCar.getTitleRecieved();
			if(selectedCar.getShipperId()!=null) {
				shipperSelectedId=selectedCar.getShipperId().getId();
				}
			if(selectedCar.getMainTwoId()!=null) {
				mainTwoSelectedId = selectedCar.getMainTwoId().getId();
			}
			if(selectedCar.getVendorId()!=null) {
				vendorSelectedId=selectedCar.getVendorId().getId();
				}
		}
		public void selectCarForMain(int idcar) {
			refresh();

			selectedCar=carFacade.getById(idcar);
			refreshSelectedCarMain();
			try {
				FacesContext.getCurrentInstance()
				   .getExternalContext().redirect("/pages/secured/shipper/car/vitViewEdit.jsf?faces-redirect=true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		/*
		 * 
		 * 
		 * Select Car For Main Two
		 */
		public void refreshSelectedCarMainTwo() {
			
			List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
			List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
			List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
			List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
			
			if(imagesOfCar!=null) {
				for(int i=0;i<imagesOfCar.size();i++) {
					images.add(imagesOfCar.get(i).getUrl());
				}
			}
			if(docsOfCar!=null){
				for(int i=0;i<docsOfCar.size();i++) {
					docs.add(docsOfCar.get(i).getUrl());
				}
			}
			
			
			if(pdfsOfCar!=null){
				for(int i=0;i<pdfsOfCar.size();i++) {
					pdfs.add(pdfsOfCar.get(i).getUrl());
				}
			}
			
			if(imageLoadingOfCar!=null){
				for(int i=0;i<imageLoadingOfCar.size();i++) {
					loadingImages.add(imageLoadingOfCar.get(i).getUrl());
				}
			}
			
			
			cargoRecievedDate=getStringFromCalendar(selectedCar.getCargoRecieved());
			releaseDate=getStringFromCalendar(selectedCar.getReleaseDate());
			stRecievedDate=getStringFromCalendar(selectedCar.getStRecieved());
			etdDate=getStringFromCalendar(selectedCar.getEtd());
			etaDate=getStringFromCalendar(selectedCar.getEta());
			storageStartDate=getStringFromCalendar(selectedCar.getStorageStartDate());
			storageEndDate=getStringFromCalendar(selectedCar.getStorageEndDate());

			titleRecievedSelected=selectedCar.getTitleRecieved();
			if(selectedCar.getShipperId()!=null) {
				shipperSelectedId=selectedCar.getShipperId().getId();
				}
			
			if(selectedCar.getVendorId()!=null) {
				vendorSelectedId=selectedCar.getVendorId().getId();
				}
		}
		public void selectCarForMainTwo(int idcar) {
			refresh();
			selectedCar=carFacade.getById(idcar);
			refreshSelectedCarMainTwo();
			try {
				FacesContext.getCurrentInstance()
				   .getExternalContext().redirect("/pages/secured/mainTwo/car/vitViewEdit.jsf?faces-redirect=true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	/**
	 * 
	 * shipper
	 */
		
		public void refreshSelectedCarShipper() {
			selectedConsignee=selectedCar.getConsigneeId();
			if(selectedConsignee!=null)
				consigneeId=selectedConsignee.getId();
			if(selectedCar.getVendorId()==null) {
				vendor vendorNew=new vendor();
		
				selectedCar.setVendorId(vendorNew);
			}else {
				vendorSelectedId=selectedCar.getVendorId().getId();
			}
			
			List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
			List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
			List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
			List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
			
			if(imagesOfCar!=null) {
				for(int i=0;i<imagesOfCar.size();i++) {
					images.add(imagesOfCar.get(i).getUrl());
				}
			}
			if(docsOfCar!=null){
				for(int i=0;i<docsOfCar.size();i++) {
					docs.add(docsOfCar.get(i).getUrl());
				}
			}
			
			
			if(pdfsOfCar!=null){
				for(int i=0;i<pdfsOfCar.size();i++) {
					pdfs.add(pdfsOfCar.get(i).getUrl());
				}
			}
			
			if(imageLoadingOfCar!=null){
				for(int i=0;i<imageLoadingOfCar.size();i++) {
					loadingImages.add(imageLoadingOfCar.get(i).getUrl());
				}
			}
			
				
		}
	public void selectCarForShipper(int idcar) {
		refresh();
		
		selectedCar=carFacade.getById(idcar);
		refreshSelectedCarShipper();
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/car/EditInventory.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public void updateCarForShipper() {

		boolean isValid=checkValidForCar(selectedCar);

		//boolean checkVendor=checkVendorIsExist(selectedCar.getVendorId());
		//if(isValid&&checkVendor) {
		if(isValid) {
			vendor itemV= vendorFacade.getById(selectedCar.getVendorId().getId());	
			selectedCar.setVendorId(itemV);
			
		consignee consigneeNew=consigneeFacade.getById(consigneeId);
		selectedCar.setConsigneeId(consigneeNew);
		carFacade.addcar(selectedCar);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your car has been updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}



public void updateCarForCustomer() {
	
	boolean isValid=checkValidForCar(selectedCar);

	boolean checkCustomer=checkCustomerIsExist(selectedCar.getCustomerId());
	if(isValid&&checkCustomer) {
		
	customer customerMain = customerFacade.getById(selectedCar.getCustomerId().getId());
	selectedCar.setCustomerId(customerMain);
	consignee consigneeNew=consigneeFacade.getById(consigneeId);
	selectedCar.setConsigneeId(consigneeNew);
	carFacade.addcar(selectedCar);
	
	PrimeFaces.current().executeScript("new PNotify({\r\n" + 
			"			title: 'Success',\r\n" + 
			"			text: 'Your car has been updated.',\r\n" + 
			"			type: 'success'\r\n" + 
			"		});");
	
	
	try {
		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}else {
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Check this ',\r\n" + 
				"			text: 'Check the Madatory fields',\r\n" + 
				"			left:\"2%\"\r\n" + 
				"		});");
	}
}
	
	
	
	
	
	
	
	/**
	 * vendor 
	 */
	
public void refreshSelectedCarVendor() {
	selectedConsignee=selectedCar.getConsigneeId();
	if(selectedConsignee!=null)
		consigneeId=selectedConsignee.getId();
	if(selectedCar.getCustomerId()==null) {
		customer customerNew=new customer();

		selectedCar.setCustomerId(customerNew);
	}else {
		customerSelectedId=selectedCar.getCustomerId().getId();
	}
	
	List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
	List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
	List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
	List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
	
	if(imagesOfCar!=null) {
		for(int i=0;i<imagesOfCar.size();i++) {
			images.add(imagesOfCar.get(i).getUrl());
		}
	}
	if(docsOfCar!=null){
		for(int i=0;i<docsOfCar.size();i++) {
			docs.add(docsOfCar.get(i).getUrl());
		}
	}
	
	
	if(pdfsOfCar!=null){
		for(int i=0;i<pdfsOfCar.size();i++) {
			pdfs.add(pdfsOfCar.get(i).getUrl());
		}
	}
	
	if(imageLoadingOfCar!=null){
		for(int i=0;i<imageLoadingOfCar.size();i++) {
			loadingImages.add(imageLoadingOfCar.get(i).getUrl());
		}
	}
	
	
}
	public void selectCarForVendor(int idcar) {
		refresh();
		selectedCar=carFacade.getById(idcar);
		refreshSelectedCarVendor();
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/customer/car/EditInventory.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCarForVendor() {
		
		boolean isValid=checkValidForCar(selectedCar);
		if(isValid) {
			
			customer itemCus= customerFacade.getById(selectedCar.getCustomerId().getId());	
			selectedCar.setCustomerId(itemCus);
		carFacade.addcar(selectedCar);
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your car has been updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}

	
	
	/**
	 * customer 
	 */
	
	public void refreshSelectedCarCustomerOrConsignee(){
		selectedConsignee=selectedCar.getConsigneeId();
		if(selectedConsignee!=null)
			consigneeId=selectedConsignee.getId();
		if(selectedCar.getCustomerId()==null) {
			customer customerNew=new customer();
	
			selectedCar.setCustomerId(customerNew);
		}else {
			customerSelectedId=selectedCar.getCustomerId().getId();
		}
		
		List<carimage> imagesOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PIC);
		List<carimage> docsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_DOC);
		List<carimage> pdfsOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_PDFS);
		List<carimage> imageLoadingOfCar =carimageFacade.getAllByCarIdAndType(selectedCar.getId(), carimage.TYPE_Loading);
		
		if(imagesOfCar!=null) {
			for(int i=0;i<imagesOfCar.size();i++) {
				images.add(imagesOfCar.get(i).getUrl());
			}
		}
		if(docsOfCar!=null){
			for(int i=0;i<docsOfCar.size();i++) {
				docs.add(docsOfCar.get(i).getUrl());
			}
		}
		
		
		if(pdfsOfCar!=null){
			for(int i=0;i<pdfsOfCar.size();i++) {
				pdfs.add(pdfsOfCar.get(i).getUrl());
			}
		}
		
		if(imageLoadingOfCar!=null){
			for(int i=0;i<imageLoadingOfCar.size();i++) {
				loadingImages.add(imageLoadingOfCar.get(i).getUrl());
			}
		}
		
	}
	public void selectCarForCustomerOrConsignee(int idcar) {
		refresh();
		selectedCar=carFacade.getById(idcar);
		refreshSelectedCarCustomerOrConsignee();
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/car/Inventory.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Save the New Car with the main Account
	public void saveNewCarDataMain() {
		loginBean.getTheUserOfThisAccount();
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN2) {
			addNewCar.setCommentToSend("");
			addNewCar.setEmailToSendComment("");
		}
		addNewCar.setTitleRecieved(titleRecievedSelected);
		
		addNewCar.setCargoRecieved(setCalendarFromString(cargoRecievedDate));
		addNewCar.setReleaseDate(setCalendarFromString(releaseDate));
		addNewCar.setStRecieved(setCalendarFromString(stRecievedDate));
		addNewCar.setEtd(setCalendarFromString(etdDate));
		addNewCar.setEta(setCalendarFromString(etaDate));
		addNewCar.setStorageStartDate(setCalendarFromString(storageStartDate));
		addNewCar.setStorageEndDate(setCalendarFromString(storageEndDate));
		
		//Set the selected Main Two
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
		addNewCar.setMainTwoId(mainTwoFacade.getById(mainTwoSelectedId));
		}
		
		//Set the selected shipper
		addNewCar.setShipperId(shipperFacade.getById(shipperSelectedId));
		
		//Set the selected Vendor
		addNewCar.setVendorId(vendorFacade.getById(vendorSelectedId));
		
		boolean isValid=checkValidForCar(addNewCar);
		if(isValid) {
			boolean checkCar = checkCarIsExist(addNewCar.getUuid());
			if(checkCar) {
		
		carFacade.addcar(addNewCar);
		
		for(int i=0;i<images_deleted.size();i++) {
			carimage cImage=new carimage();
			cImage.setCarId(addNewCar);
			cImage.setUrl(images_deleted.get(i));
			cImage.setType(carimage.TYPE_PIC);
			cImage.setDeleted(true);
			carimageFacade.addcarimage(cImage);
			addNewCar.setPhotoExist(false);

		}
		
		for(int i=0;i<docs_deleted.size();i++) {
			carimage cDocs=new carimage();
			cDocs.setCarId(addNewCar);
			cDocs.setUrl(docs_deleted.get(i));
			cDocs.setType(carimage.TYPE_DOC);
			cDocs.setDeleted(true);
			carimageFacade.addcarimage(cDocs);
			addNewCar.setDocExist(false);
		}
		
		for(int i=0;i<pdfs_deleted.size();i++) {
			carimage cPDFs=new carimage();
			cPDFs.setCarId(addNewCar);
			cPDFs.setUrl(pdfs_deleted.get(i));
			cPDFs.setType(carimage.TYPE_PDFS);
			cPDFs.setDeleted(true);
			carimageFacade.addcarimage(cPDFs);
			addNewCar.setDocExist(false);
		}
		
		
		for(int i=0;i<loadingImages_deleted.size();i++) {
			carimage cPDFs=new carimage();
			cPDFs.setCarId(addNewCar);
			cPDFs.setUrl(loadingImages_deleted.get(i));
			cPDFs.setType(carimage.TYPE_Loading);
			cPDFs.setDeleted(true);
			carimageFacade.addcarimage(cPDFs);
		}
		
		
		for(int i=0;i<images.size();i++) {
			carimage cImage=new carimage();
			cImage.setCarId(addNewCar);
			cImage.setUrl(images.get(i));
			cImage.setType(carimage.TYPE_PIC);
			carimageFacade.addcarimage(cImage);
			addNewCar.setPhotoExist(true);

		}
		
		for(int i=0;i<docs.size();i++) {
			carimage cDocs=new carimage();
			cDocs.setCarId(addNewCar);
			cDocs.setUrl(docs.get(i));
			cDocs.setType(carimage.TYPE_DOC);
			carimageFacade.addcarimage(cDocs);
			addNewCar.setDocExist(true);
		}
		
		for(int i=0;i<pdfs.size();i++) {
			carimage cPDFs=new carimage();
			cPDFs.setCarId(addNewCar);
			cPDFs.setUrl(pdfs.get(i));
			cPDFs.setType(carimage.TYPE_PDFS);
			carimageFacade.addcarimage(cPDFs);
			addNewCar.setDocExist(true);
		}
		
		
		for(int i=0;i<loadingImages.size();i++) {
			carimage cPDFs=new carimage();
			cPDFs.setCarId(addNewCar);
			cPDFs.setUrl(loadingImages.get(i));
			cPDFs.setType(carimage.TYPE_Loading);
			carimageFacade.addcarimage(cPDFs);
		}
		
		
		
		addNewCar.setStorageStartDate(Calendar.getInstance());
		carFacade.addcar(addNewCar);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your car has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else {
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Check this ',\r\n" + 
						"			text: 'This car is already Registered',\r\n" + 
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

	public String getStringFromCalendar(Calendar calendar) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		String returnedCalendarString="";
		
			if(calendar!=null) {
				returnedCalendarString=formatter.format(calendar.getTime());
			}
		return returnedCalendarString;
	}
	
	private Calendar setCalendarFromString(String cargoRecievedDate2) {

		Calendar cal = null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		try {
			if(!cargoRecievedDate2.equals("")) {
				cal=Calendar.getInstance();
				Date date=formatter.parse(cargoRecievedDate2);
				cal.setTime(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return cal;
	}

	private boolean checkCarIsExist(String vinId) {
		// TODO Auto-generated method stub
		
		car theCar=carFacade.getByVin(vinId);
		if(theCar!=null) {
			return false;
		}
		return true;
	}

	public String getTheDestination(Integer codeCountry) {
		String country=distinationMap.get(codeCountry);
		
		return country;
		
	}
	
private Map<Integer, String> origineMap2=new LinkedHashMap<Integer,String>();
	
	public String getTheOrigin2(Integer codeCountry) {
		origineMap2.put(-1, "----");
		origineMap2.put(381, "TX");
		origineMap2.put(117, "CA");
		origineMap2.put(371, "FL");
		origineMap2.put(1, "NY");
		origineMap2.put(39, "GA");
		origineMap2.put(391, "IN");
		
		String country=origineMap2.get(codeCountry);
		
		return country;
		
	}
	
	
	public String getTheOrigin(Integer codeCountry) {
		String country=origineMap.get(codeCountry);
		
		return country;
		
	}
	
	private boolean checkValidForCar(car addNewCar) {
		// TODO Auto-generated method stub
		
		if(addNewCar.getUuid().equals("")||addNewCar.getUuid()==null) {
			return false;
		}
	
		
		
		return true;
	}

	/*
	public String saveImageToDirectory(byte[] image,String directory) {
		String fileName="";
		
		try {
			File file=File.createTempFile("img", ".png",new File(directory));
			ByteArrayInputStream bis = new ByteArrayInputStream(image);
			BufferedImage bImage=ImageIO.read(bis);
			ImageIO.write(bImage, "png", file);
			fileName = file.getName();
		}catch(IOException e) {
			
		}
		
		return fileName;
	}

*/
	private BufferedImage scaleImage(BufferedImage bufferedImage, int size) {
        double boundSize = size;
           int origWidth = bufferedImage.getWidth();
           int origHeight = bufferedImage.getHeight();
           double scale;
           if (origHeight > origWidth)
               scale = boundSize / origHeight;
           else
               scale = boundSize / origWidth;
            //* Don't scale up small images.
           if (scale > 1.0)
               return (bufferedImage);
           int scaledWidth = (int) (scale * origWidth);
           int scaledHeight = (int) (scale * origHeight);
           
           BufferedImage after = new BufferedImage(origWidth, origHeight, BufferedImage.TYPE_INT_ARGB);
           AffineTransform at = new AffineTransform();
           at.scale(scale, scale);
           AffineTransformOp scaleOp = 
              new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
           after = scaleOp.filter(bufferedImage, after);
           
           BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
           Graphics2D g = scaledBI.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
           g.drawImage(after, 0, 0, null);
           g.dispose();
           return (scaledBI);
   }
	public String savePdfToDirectory(byte[] pdf,String directory) {
		String fileName="";
		try {
			File file=File.createTempFile("pdf", ".pdf", new File(directory));
			OutputStream out = new FileOutputStream(file);
			out.write(pdf);
			out.close();
			 
		       
			
			
			fileName=file.getName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileName;
		
	}
	public String saveImageToDirectory(byte[] image,String directory) {
		String fileName="";
		try {
			File file=File.createTempFile("img", ".jpg", new File(directory));
		      byte [] data = image;
		      ByteArrayInputStream bis = new ByteArrayInputStream(data);
		      BufferedImage bImage2;
			bImage2 = ImageIO.read(bis);
			
			
			 
		        OutputStream os = new FileOutputStream(file);
			
			// create a BufferedImage as the result of decoding the supplied InputStream
	        BufferedImage image2=scaleImage(bImage2, 800);
			// get all image writers for JPG format
	        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
	 
	        float quality = 0.5f;
	        ImageWriter writer = (ImageWriter) writers.next();
	        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	        writer.setOutput(ios);
	 
	        ImageWriteParam param = writer.getDefaultWriteParam();
	 
	        // compress to a given quality
	        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	        param.setCompressionQuality(quality);
	 
	        // appends a complete image stream containing a single image and
	        //associated stream and image metadata and thumbnails to the output
	        writer.write(null, new IIOImage(image2, null, null), param);
	 
	     // close all streams
	        os.close();
	        ios.close();
	        writer.dispose();
			
			
			fileName=file.getName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileName;
	      
	}
	public void previewImage(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		images.add(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanel");
	}
	
	public void previewFile(FileUploadEvent event) {
		byte[] fileDoc =event.getFile().getContents();
		String fileName =saveImageToDirectory(fileDoc, System.getProperty("catalina.base")+"/images/");
		docs.add(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:docsPanel");
	}
	
	public void previewFilePdf(FileUploadEvent event) {
		byte[] fileDoc =event.getFile().getContents();
		String fileName =savePdfToDirectory(fileDoc, System.getProperty("catalina.base")+"/pdfs/");
		pdfs.add(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:pdfdocsPanel");
	}
	
	public void previewLoadingImage(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		loadingImages.add(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:LoadingimagesPanel");
	}
	
	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isLandStatuesDiffMoreThan15Day(Calendar storeStart,Calendar storeEnd,String inlandStatues) {
		if(inlandStatues.toLowerCase().equalsIgnoreCase("OK")) {
			return false;
		}
		if(Math.abs(getNumberOfDays(storeStart,storeEnd))>15) {
		return true;
		}
		return false;
	}
	
	public boolean isTheRemainingDays30Day(Calendar ETA) {
		if(ETA!=null) {
		if(getNumberOfDays(Calendar.getInstance(),ETA)<=Constants.Notifcation_Period) {
			return true;
		}
		}
		return false;
		
	}
	
	/**
	 * Get the days Difference in the store
	 */
	public int getNumberOfDays(Calendar storeStart,Calendar storeEnd) {
		int difference= 0;
		if(storeStart!=null) {
		if(storeEnd!=null) {
			LocalDate datebefore=LocalDate.of(storeStart.get(Calendar.YEAR), storeStart.get(Calendar.MONTH)+1, storeStart.get(Calendar.DAY_OF_MONTH));
			LocalDate dateAfter=LocalDate.of(storeEnd.get(Calendar.YEAR), storeEnd.get(Calendar.MONTH)+1, storeEnd.get(Calendar.DAY_OF_MONTH));
			difference =(int) ChronoUnit.DAYS.between(datebefore, dateAfter);
		}else {
			Calendar nowCal=Calendar.getInstance();
			LocalDate datebefore=LocalDate.of(storeStart.get(Calendar.YEAR), storeStart.get(Calendar.MONTH)+1, storeStart.get(Calendar.DAY_OF_MONTH));
			LocalDate dateAfter=LocalDate.of(nowCal.get(Calendar.YEAR), nowCal.get(Calendar.MONTH)+1, nowCal.get(Calendar.DAY_OF_MONTH));
			difference =(int) ChronoUnit.DAYS.between(datebefore, dateAfter);
		}
		}
		return difference;
	}
	//Used To update the car with the main account
	public void updateDataMain() {


		selectedCar.setTitleRecieved(titleRecievedSelected);
		
		selectedCar.setCargoRecieved(setCalendarFromString(cargoRecievedDate));
		selectedCar.setReleaseDate(setCalendarFromString(releaseDate));
		selectedCar.setStRecieved(setCalendarFromString(stRecievedDate));
		selectedCar.setEtd(setCalendarFromString(etdDate));
		selectedCar.setEta(setCalendarFromString(etaDate));
		selectedCar.setStorageStartDate(setCalendarFromString(storageStartDate));
		selectedCar.setStorageEndDate(setCalendarFromString(storageEndDate));

		//Set the selected shipper
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
			selectedCar.setMainTwoId(mainTwoFacade.getById(mainTwoSelectedId));
		}
		//Set the selected shipper
		selectedCar.setShipperId(shipperFacade.getById(shipperSelectedId));
		

		//Set the selected shipper
		selectedCar.setVendorId(vendorFacade.getById(vendorSelectedId));
		
		boolean isValid=checkValidForCar(selectedCar);
		if(isValid) {
		
			
		carFacade.addcar(selectedCar);
		for(int i=0;i<images_deleted.size();i++) {
			carimage cImage=new carimage();
			cImage.setCarId(selectedCar);
			cImage.setUrl(images_deleted.get(i));
			cImage.setType(carimage.TYPE_PIC);
			cImage.setDeleted(true);
			carimageFacade.addcarimage(cImage);
			selectedCar.setPhotoExist(false);

		}
		
		for(int i=0;i<docs_deleted.size();i++) {
			carimage cDocs=new carimage();
			cDocs.setCarId(selectedCar);
			cDocs.setUrl(docs_deleted.get(i));
			cDocs.setType(carimage.TYPE_DOC);
			cDocs.setDeleted(true);
			carimageFacade.addcarimage(cDocs);
			selectedCar.setDocExist(false);
		}
		
		for(int i=0;i<pdfs_deleted.size();i++) {
			carimage cPDFs=new carimage();
			cPDFs.setCarId(selectedCar);
			cPDFs.setUrl(pdfs_deleted.get(i));
			cPDFs.setType(carimage.TYPE_PDFS);
			cPDFs.setDeleted(true);
			carimageFacade.addcarimage(cPDFs);
			selectedCar.setDocExist(false);
		}
		for(int i=0;i<loadingImages_deleted.size();i++) {
			carimage cImage=new carimage();
			cImage.setCarId(selectedCar);
			cImage.setUrl(loadingImages_deleted.get(i));
			cImage.setType(carimage.TYPE_Loading);
			cImage.setDeleted(true);
			carimageFacade.addcarimage(cImage);

		}
		
		for(int i=0;i<images.size();i++) {
			carimage cImage=new carimage();
			cImage.setCarId(selectedCar);
			cImage.setUrl(images.get(i));
			cImage.setType(carimage.TYPE_PIC);
			carimageFacade.addcarimage(cImage);
			selectedCar.setPhotoExist(true);
		}
		
		for(int i=0;i<docs.size();i++) {
			carimage cDocs=new carimage();
			cDocs.setCarId(selectedCar);
			cDocs.setUrl(docs.get(i));
			cDocs.setType(carimage.TYPE_DOC);
			carimageFacade.addcarimage(cDocs);
			selectedCar.setDocExist(true);
		}
		
		for(int i=0;i<pdfs.size();i++) {
			carimage cpdfs=new carimage();
			cpdfs.setCarId(selectedCar);
			cpdfs.setUrl(pdfs.get(i));
			cpdfs.setType(carimage.TYPE_PDFS);
			carimageFacade.addcarimage(cpdfs);
			selectedCar.setDocExist(true);
		}
		
		
		for(int i=0;i<loadingImages.size();i++) {
			carimage cpdfs=new carimage();
			cpdfs.setCarId(selectedCar);
			cpdfs.setUrl(loadingImages.get(i));
			cpdfs.setType(carimage.TYPE_Loading);
			carimageFacade.addcarimage(cpdfs);
		}
		


		carFacade.addcar(selectedCar);
			
		
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your car has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");


		System.out.println("Ahmed Mail Old 1");
		if(selectedCar.isSendMailUpdate()) {

		sendUpdateToAll(selectedCar);
		}else {
			System.out.println("Ahmed Mail");
		}
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}

	
	
	public void previewImageMain(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		selectedCar.setMainUrl(fileName);
		selectedCar.setPhotoExist(true);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanelMain");
	}
	
	
	public void addImageMain(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		addNewCar.setMainUrl(fileName);
		addNewCar.setPhotoExist(true);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanelMain");
	}
private void sendUpdateToAll(car selectedCar2) {
		
		shipper shipperObject =selectedCar2.getShipperId();
		shipper shipperIdMail =null;
		if(shipperObject!=null) {
			Integer shipperId = shipperObject.getId();
			shipperIdMail=shipperFacade.getById(shipperId);
		}
		
		
		
		vendor vendorObject =selectedCar2.getVendorId();
		vendor vendorIdMail =null;
		if(vendorObject!=null) {
			Integer vendorId = vendorObject.getId();
			vendorIdMail=vendorFacade.getById(vendorId);
		}
		
		
		consignee consigneeObject=selectedCar2.getConsigneeId();
		consignee consigneeIdMail =null;
		if(consigneeObject!=null) {
			Integer consigneeId = consigneeObject.getId();
			consigneeIdMail=consigneeFacade.getById(consigneeId);
		}
		
		
		
		customer customerObject=selectedCar2.getCustomerId();
		customer customerIdMail =null;
		if(customerObject!=null) {
			Integer customerId = customerObject.getId();
			customerIdMail=customerFacade.getById(customerId);
		}
		
		
		
		mainTwo mainTwoObject = selectedCar2.getMainTwoId();
		mainTwo mainTwoIdMail =null;
		if(mainTwoObject!=null) {
			Integer mainTwoId = mainTwoObject.getId();
			mainTwoIdMail=mainTwoFacade.getById(mainTwoId);
		}
		
		if(mainTwoIdMail!=null)
			Constants.sendEmailUpdateFormatCar(selectedCar2,mainTwoIdMail.getUserId().getFirstName(), mainTwoIdMail.getUserId().getEmail(), mainTwoIdMail.getUserId().getEmail());
		
		
		if(shipperIdMail!=null)
			Constants.sendEmailUpdateFormatCar(selectedCar2,shipperIdMail.getUserId().getFirstName(), shipperIdMail.getUserId().getEmail(), shipperIdMail.getUserId().getEmail());
		
		
		
		if(vendorIdMail!=null)
			Constants.sendEmailUpdateFormatCar(selectedCar2,vendorIdMail.getUserId().getFirstName(), vendorIdMail.getUserId().getEmail(), vendorIdMail.getUserId().getEmail());
		
		if(consigneeIdMail!=null)
			Constants.sendEmailUpdateFormatCar(selectedCar2,consigneeIdMail.getUserId().getFirstName(), consigneeIdMail.getUserId().getEmail(), consigneeIdMail.getUserId().getEmail());
		
		if(customerIdMail!=null)
			Constants.sendEmailUpdateFormatCar(selectedCar2,customerIdMail.getUserId().getFirstName(), customerIdMail.getUserId().getEmail(), customerIdMail.getUserId().getEmail());
	}


public void setCarsContainerDetails() {
	shipper shipper=shipperFacade.getById(Integer.valueOf(shipperIdOFContainer));
	
	for(car car: allCarsToContainer) {
		car.setContainer(containerName);
		car.setContainerLink(containerLink);
		car.setDestination(Integer.valueOf(countryForContainer));
		car.setShipperId(shipper);
		car.setState(Integer.valueOf(stateForContainer));
		carFacade.addcar(car);
	}
	
	
	PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Cars Has Been Modified\", \"success\");");
	
	 try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}



public void visiblityShowing() {
	FacesContext context = FacesContext.getCurrentInstance();
	 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
	 String key = (String) map.get("key");
	 String value = (String) map.get("value");
	 visibilityOptions.set(Integer.valueOf(key),value);
}

public void openUUID() {
	FacesContext context = FacesContext.getCurrentInstance();
	 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
	 int id = Integer.parseInt((String) map.get("carUUID"));
	 
	 
	 if(loginBean.getTheUserOfThisAccount().getRole().equals(0)) {
		 selectCarForMain(id);
	 }else if(loginBean.getTheUserOfThisAccount().getRole().equals(5)) {
		 selectCarForMainTwo(id);
	 }else if(loginBean.getTheUserOfThisAccount().getRole().equals(1)) {
		 selectCarForShipper(id);
	 }else if(loginBean.getTheUserOfThisAccount().getRole().equals(2)) {
		 selectCarForVendor(id);
	 }else if(loginBean.getTheUserOfThisAccount().getRole().equals(3)) {
		 selectCarForCustomerOrConsignee(id);
	 }else if(loginBean.getTheUserOfThisAccount().getRole().equals(4)) {
		 selectCarForCustomerOrConsignee(id);
	 }
	 
	 
}
public void openDialogForVins() {
	FacesContext context = FacesContext.getCurrentInstance();
	 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
	 String carsId = (String) map.get("carsId");
	 String[] carsIdArray = carsId.split(",");
	 allCarsToContainer =new ArrayList<car>();
	 containerName="";
	 containerLink="";
	 shipperIdOFContainer=-1;
	 countryForContainer="";
	 stateForContainer="";
	 for (String a : carsIdArray) {
		 System.out.println(a);
		 car newCar = carFacade.getById(Integer.valueOf(a));
		 allCarsToContainer.add(newCar);
		 
		 
		 
	 }
	 FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("formOfDialog");
		
	 PrimeFaces.current().executeScript("runFromBackEndToReloadDialog();");
		
	 
}


public void deleteCar() {
	 FacesContext context = FacesContext.getCurrentInstance();
	 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
	 Integer carId = Integer.valueOf((String) map.get("carId"));
	 
	 car deletedCar = carFacade.getById(carId);
	 deletedCar.setDeleted(true);
	 carFacade.addcar(deletedCar);
	 
		PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Car Has Been Deleted\", \"success\");");
		
	 try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
}
	public void deleteFile() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		 Integer typeOfFile = Integer.valueOf((String) map.get("typeOfFile"));
		 String fileURL = (String) map.get("fileURL");

			System.out.println(fileURL);
			System.out.println(typeOfFile);
		if(typeOfFile==carimage.TYPE_DOC) {
				removeFileFromDoc(fileURL);
			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:docsPanel");
			PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Document Has Been Deleted\", \"success\");");
		}else if(typeOfFile==carimage.TYPE_PDFS) {
			
				removeFileFromPdf(fileURL);
			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:pdfdocsPanel");
			PrimeFaces.current().executeScript("swal(\"Action Done\", \"The PDF Has Been Deleted\", \"success\");");
		}else if(typeOfFile==carimage.TYPE_PIC) {
			
			removeFileFromImages(fileURL);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanel");
		PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Image Has Been Deleted\", \"success\");");
		}else if(typeOfFile==carimage.TYPE_Loading) {
			
			removeFileFromLoadingImages(fileURL);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:LoadingimagesPanel");
		PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Loading Image Has Been Deleted\", \"success\");");
		}
		
	}
	
	private void removeFileFromImages(String fileURL) {
		// TODO Auto-generated method stub
		for(int i=0;i<images.size();i++) {
			if(images.get(i).equalsIgnoreCase(fileURL)) {
				images.remove(i);
				images_deleted.add(fileURL);
				return;
			}
		}
	}

	private void removeFileFromPdf(String fileURL) {
		// TODO Auto-generated method stub
		for(int i=0;i<pdfs.size();i++) {
			if(pdfs.get(i).equalsIgnoreCase(fileURL)) {
				pdfs.remove(i);
				pdfs_deleted.add(fileURL);
				return;
			}
		}
	}
	
	private void removeFileFromLoadingImages(String fileURL) {
		// TODO Auto-generated method stub
		for(int i=0;i<loadingImages.size();i++) {
			if(loadingImages.get(i).equalsIgnoreCase(fileURL)) {
				loadingImages.remove(i);
				loadingImages_deleted.add(fileURL);
				return;
			}
		}
	}

	private void removeFileFromDoc(String fileURL) {
		// TODO Auto-generated method stub
		for(int i=0;i<docs.size();i++) {
			if(docs.get(i).equalsIgnoreCase(fileURL)) {
				docs.remove(i);
				docs_deleted.add(fileURL);
				return;
			}
		}
	}
	
	

	public void refreshDataForCarDependsOnRole() {
		refresh();
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_CONGSIGNEE||loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_CUSTOMER) {
			refreshSelectedCarCustomerOrConsignee();
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
			refreshSelectedCarMain();
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN2) {
			refreshSelectedCarMainTwo();
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_VENDOR) {
			refreshSelectedCarVendor();
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_SHIPPER) {
			refreshSelectedCarShipper();
		}
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
	/**
	 * the main setters and getters
	 */
	////////////////////////////////////////////////////////////////////////////
	//////////////////////Setters And Getters / ////////////////////////////////
	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<consignee> getAllconsignees() {
		return allconsignees;
	}

	public void setAllconsignees(List<consignee> allconsignees) {
		this.allconsignees = allconsignees;
	}

	
	public consigneeAppServiceImpl getconsigneeFacade() {
		return consigneeFacade;
	}

	public void setconsigneeFacade(consigneeAppServiceImpl consigneeFacade) {
		this.consigneeFacade = consigneeFacade;
	}

	public consigneeAppServiceImpl getConsigneeFacade() {
		return consigneeFacade;
	}

	public void setConsigneeFacade(consigneeAppServiceImpl consigneeFacade) {
		this.consigneeFacade = consigneeFacade;
	}

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}

	public carAppServiceImpl getCarFacade() {
		return carFacade;
	}

	public void setCarFacade(carAppServiceImpl carFacade) {
		this.carFacade = carFacade;
	}

	public List<car> getAllCars() {
		return allCars;
	}

	public void setAllCars(List<car> allCars) {
		this.allCars = allCars;
	}

	public car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public car getAddNewCar() {
		return addNewCar;
	}

	public void setAddNewCar(car addNewCar) {
		this.addNewCar = addNewCar;
	}

	public vendorAppServiceImpl getVendorFacade() {
		return vendorFacade;
	}

	public void setVendorFacade(vendorAppServiceImpl vendorFacade) {
		this.vendorFacade = vendorFacade;
	}

	public customerAppServiceImpl getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(customerAppServiceImpl customerFacade) {
		this.customerFacade = customerFacade;
	}

	
	
	public List<mainTwo> getAllMainTwo() {
		return allMainTwo;
	}

	public void setAllMainTwo(List<mainTwo> allMainTwo) {
		this.allMainTwo = allMainTwo;
	}

	public List<shipper> getAllshipper() {
		return allshipper;
	}

	public void setAllshipper(List<shipper> allshipper) {
		this.allshipper = allshipper;
	}

	public List<vendor> getAllvendor() {
		return allvendor;
	}

	public void setAllvendor(List<vendor> allvendor) {
		this.allvendor = allvendor;
	}

	public String getPdfView() {
		return pdfView;
	}

	public void setPdfView(String pdfView) {
		this.pdfView = pdfView;
	}

	public List<customer> getAllcustomer() {
		return allcustomer;
	}

	public void setAllcustomer(List<customer> allcustomer) {
		this.allcustomer = allcustomer;
	}

	public String getCargoRecievedDate() {
		return cargoRecievedDate;
	}

	public void setCargoRecievedDate(String cargoRecievedDate) {
		this.cargoRecievedDate = cargoRecievedDate;
	}

	

	public Integer getTitleRecievedSelected() {
		return titleRecievedSelected;
	}

	public void setTitleRecievedSelected(Integer titleRecievedSelected) {
		this.titleRecievedSelected = titleRecievedSelected;
	}

	
	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStRecievedDate() {
		return stRecievedDate;
	}

	public void setStRecievedDate(String stRecievedDate) {
		this.stRecievedDate = stRecievedDate;
	}

	public String getEtdDate() {
		return etdDate;
	}

	public void setEtdDate(String etdDate) {
		this.etdDate = etdDate;
	}

	public String getEtaDate() {
		return etaDate;
	}

	public void setEtaDate(String etaDate) {
		this.etaDate = etaDate;
	}

	public String getStorageStartDate() {
		return storageStartDate;
	}

	public void setStorageStartDate(String storageStartDate) {
		this.storageStartDate = storageStartDate;
	}

	public String getStorageEndDate() {
		return storageEndDate;
	}

	public void setStorageEndDate(String storageEndDate) {
		this.storageEndDate = storageEndDate;
	}

	
	
	public int getMainTwoSelectedId() {
		return mainTwoSelectedId;
	}

	public void setMainTwoSelectedId(int mainTwoSelectedId) {
		this.mainTwoSelectedId = mainTwoSelectedId;
	}

	public int getShipperSelectedId() {
		return shipperSelectedId;
	}

	public void setShipperSelectedId(int shipperSelectedId) {
		this.shipperSelectedId = shipperSelectedId;
	}

	public int getVendorSelectedId() {
		return vendorSelectedId;
	}

	public void setVendorSelectedId(int vendorSelectedId) {
		this.vendorSelectedId = vendorSelectedId;
	}

	public int getCustomerSelectedId() {
		return customerSelectedId;
	}

	public void setCustomerSelectedId(int customerSelectedId) {
		this.customerSelectedId = customerSelectedId;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getDocs() {
		return docs;
	}

	public void setDocs(List<String> docs) {
		this.docs = docs;
	}

	
	public List<String> getPdfs() {
		return pdfs;
	}

	public void setPdfs(List<String> pdfs) {
		this.pdfs = pdfs;
	}

	
	
	public List<String> getLoadingImages() {
		return loadingImages;
	}



	public void setLoadingImages(List<String> loadingImages) {
		this.loadingImages = loadingImages;
	}



	public List<String> getLoadingImages_deleted() {
		return loadingImages_deleted;
	}



	public void setLoadingImages_deleted(List<String> loadingImages_deleted) {
		this.loadingImages_deleted = loadingImages_deleted;
	}



	public int getNumberOfAny() {
		return numberOfAny;
	}



	public void setNumberOfAny(int numberOfAny) {
		this.numberOfAny = numberOfAny;
	}



	public carimageAppServiceImpl getCarimageFacade() {
		return carimageFacade;
	}

	public void setCarimageFacade(carimageAppServiceImpl carimageFacade) {
		this.carimageFacade = carimageFacade;
	}

	public List<String> getCarStates() {
		return carStates;
	}

	public void setCarStates(List<String> carStates) {
		this.carStates = carStates;
	}

	
	
	
	public mainTwoAppServiceImpl getMainTwoFacade() {
		return mainTwoFacade;
	}

	public void setMainTwoFacade(mainTwoAppServiceImpl mainTwoFacade) {
		this.mainTwoFacade = mainTwoFacade;
	}

	public boolean isProgress() {
		return progress;
	}

	public void setProgress(boolean progress) {
		this.progress = progress;
	}

	public Map<Integer, String> getDistinationMap() {
		return distinationMap;
	}

	public void setDistinationMap(Map<Integer, String> distinationMap) {
		this.distinationMap = distinationMap;
	}

	
	public int getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
	}

	public Map<Integer, String> getOrigineMap() {
		return origineMap;
	}

	public void setOrigineMap(Map<Integer, String> origineMap) {
		this.origineMap = origineMap;
	}

	
	
	public consignee getSelectedConsignee() {
		return selectedConsignee;
	}

	public void setSelectedConsignee(consignee selectedConsignee) {
		this.selectedConsignee = selectedConsignee;
	}

	public int getSelectedCarState() {
		return selectedCarState;
	}

	public void setSelectedCarState(int selectedCarState) {
		this.selectedCarState = selectedCarState;
	}

	
	
	public List<car> getAllSelectedCars() {
		return allSelectedCars;
	}

	public void setAllSelectedCars(List<car> allSelectedCars) {
		this.allSelectedCars = allSelectedCars;
	}

	public List<String> getImages_deleted() {
		return images_deleted;
	}

	public void setImages_deleted(List<String> images_deleted) {
		this.images_deleted = images_deleted;
	}

	public List<String> getDocs_deleted() {
		return docs_deleted;
	}

	public void setDocs_deleted(List<String> docs_deleted) {
		this.docs_deleted = docs_deleted;
	}

	public List<String> getPdfs_deleted() {
		return pdfs_deleted;
	}

	public void setPdfs_deleted(List<String> pdfs_deleted) {
		this.pdfs_deleted = pdfs_deleted;
	}

	public List<car> getAllCarsToContainer() {
		return allCarsToContainer;
	}

	public void setAllCarsToContainer(List<car> allCarsToContainer) {
		this.allCarsToContainer = allCarsToContainer;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public String getContainerLink() {
		return containerLink;
	}

	public void setContainerLink(String containerLink) {
		this.containerLink = containerLink;
	}

	public String getCountryForContainer() {
		return countryForContainer;
	}

	public void setCountryForContainer(String countryForContainer) {
		this.countryForContainer = countryForContainer;
	}

	public String getPortForContainer() {
		return portForContainer;
	}

	public void setPortForContainer(String portForContainer) {
		this.portForContainer = portForContainer;
	}

	
	public String getStateForContainer() {
		return stateForContainer;
	}



	public void setStateForContainer(String stateForContainer) {
		this.stateForContainer = stateForContainer;
	}



	public Integer getShipperIdOFContainer() {
		return shipperIdOFContainer;
	}

	public void setShipperIdOFContainer(Integer shipperIdOFContainer) {
		this.shipperIdOFContainer = shipperIdOFContainer;
	}

	
	
	public List<String> getVisibilityOptions() {
		return visibilityOptions;
	}



	public void setVisibilityOptions(List<String> visibilityOptions) {
		this.visibilityOptions = visibilityOptions;
	}



	public void fillMap() {
		fillMap1();
		fillMap2();
		fillMap3();
	}
	
	void fillMap3() {
		origineMap.put(-1, "----");
		origineMap.put(381, "TX");
		origineMap.put(117, "CA");
		origineMap.put(371, "FL");
		origineMap.put(1, "NY");
		origineMap.put(39, "GA");
		origineMap.put(391, "IN");
	}
	void fillMap1() {
		distinationMap.put(1, "Not Selected DESTINATION");   	
		distinationMap.put(1531,"Aabenraa - Denmark - 40901");
		distinationMap.put(1412,"Aagotnes - Norway - 40311");
		distinationMap.put(1532,"Aalborg - Denmark - 40903");
		distinationMap.put(1408,"Aalesund - Norway - 40301");
		distinationMap.put(1365,"Aalvik - Norway - 40300");
		distinationMap.put(1366,"Aandalsnes - Norway - 40300");
		distinationMap.put(1409,"Aardal - Norway - 40302");
		distinationMap.put(1410,"Aardalstangen - Norway - 40302");
		distinationMap.put(1533,"Aarhus - Denmark - 40906");
		distinationMap.put(587,"Abaco-Snake Cay - Bahamas - 23640");
		distinationMap.put(2532,"Abadan - Iran - 50700");
		distinationMap.put(1156,"Abaetetuba - Brazil - 35198");
		distinationMap.put(4374,"ABAKAN - RUSSIA - 44911");
		distinationMap.put(3257,"Abashiri - Japan - 58800");
		distinationMap.put(3446,"Abbot Point - Australia - 60200");
		distinationMap.put(1724,"Aberdeen - United Kingdom - 41650");
		distinationMap.put(4593,"ABERDEEN/HOQUIAM - United States - 3003");
		distinationMap.put(3803,"Abidjan - Ivory Coast - 74825");
		distinationMap.put(1504,"Abo - Finland - 40587");
		distinationMap.put(3827,"Abonnema - Nigeria - 75300");
		distinationMap.put(320,"Abryos - Mexico - 20100");
		distinationMap.put(2618,"Abu al Bu Koosh - United Arab Em - 52000");
		distinationMap.put(2629,"Abu Dhabi - United Arab Em - 52001");
		distinationMap.put(3724,"Abu Kir Bay - Egypt - 72905");
		distinationMap.put(3725,"Abu Qir - Egypt - 72905");
		distinationMap.put(2628,"Abu Zabi - United Arab Em - 52001");
		distinationMap.put(3746,"Abu Zanimah - Egypt - 72999");
		distinationMap.put(3747,"Abu Zenima - Egypt - 72999");
		distinationMap.put(3726,"Abukir - Egypt - 72905");
		distinationMap.put(445,"Acajutla - El Salvador - 21101");
		distinationMap.put(357,"Acapulco - Mexico - 20101");
		distinationMap.put(3816,"Accra - Ghana - 74901");
		distinationMap.put(1190,"Acevedo - Argentina - 35700");
		distinationMap.put(1592,"Acton Grange - United Kingdom - 41253");
		distinationMap.put(2591,"Ad Dammam - Saudi Arabia - 51715");
		distinationMap.put(3744,"Adabiya - Egypt - 72949");
		distinationMap.put(2437,"Adalia - Turkey - 48903");
		distinationMap.put(2455,"Adana - Turkey - 48938");
		distinationMap.put(4819,"ADDISON USER FEE AIRPORT - United States - 5584");
		distinationMap.put(3461,"Adelaide - Australia - 60201");
		distinationMap.put(2652,"Aden - Yemen - 52101");
		distinationMap.put(896,"Adicora - Venezuela - 30700");
		distinationMap.put(802,"Admiralty Bay - St. Vincent - 24871");
		distinationMap.put(4182,"Afganistan - Afganistan - 5310");
		distinationMap.put(3647,"Agadir - Morocco - 71403");
		distinationMap.put(2138,"Agua Amarga - Spain - 47099");
		distinationMap.put(4777,"AGUADILLA - United States - 4901");
		distinationMap.put(506,"Aguadulce - Costa Rica - 22389");
		distinationMap.put(537,"Aguadulce - Panama - 22581");
		distinationMap.put(2139,"Aguilas - Spain - 47099");
		distinationMap.put(1332,"Ahus - Sweden - 40122");
		distinationMap.put(2551,"Ahvaz - Iran - 50725");
		distinationMap.put(2552,"Ahwaz - Iran - 50725");
		distinationMap.put(3381,"Aia port - Japan - 58860");
		distinationMap.put(2310,"Aigion - Greece - 48400");
		distinationMap.put(3737,"Ain Sukhna - Egypt - 72932");

		distinationMap.put(3327,"Aioi - Japan - 58823");
		distinationMap.put(4551,"AIR CARGO HANDLING SERVICES, INC. - United States - 2773");
		distinationMap.put(4576,"AIR CARGO HANDLING SERVICES,SAN FRANCISCO - United States - 2871");
		distinationMap.put(4772,"AIR FRANCE - United States - 4774");
		distinationMap.put(4748,"AIRBORNE AIR PARK, WILMINGTON - United States - 4181");
		distinationMap.put(2311,"Aiyion - Greece - 48400");
		distinationMap.put(1922,"Ajaccio - France - 42796");
		distinationMap.put(2619,"Ajman - United Arab Em - 52000");
		distinationMap.put(3831,"Akassa - Nigeria - 75300");
		distinationMap.put(3341,"Akita Ko - Japan - 58832");
		distinationMap.put(1253,"Akranes - Iceland - 40038");
		distinationMap.put(4742,"AKRON - United States - 4112");
		distinationMap.put(4345,"Aktau - Kazakhstan - 44911");
		distinationMap.put(4365,"AKTOBE - KAZAKHSTAN - 44911");
		distinationMap.put(1254,"Akureyri - Iceland - 40039");
		distinationMap.put(2524,"Al Bakir - Iraq - 50505");
		distinationMap.put(2526,"Al Basrah - Iraq - 50525");
		distinationMap.put(2520,"Al Faw - Iraq - 50500");
		distinationMap.put(2580,"Al Fuhayhil - Kuwait - 51323");
		distinationMap.put(2602,"Al Juaymah - Saudi Arabia - 51723");
		distinationMap.put(2596,"Al Jubail - Saudi Arabia - 51720");
		distinationMap.put(2589,"Al Khobar - Saudi Arabia - 51712");
		distinationMap.put(2590,"Al Khubar - Saudi Arabia - 51712");
		distinationMap.put(2578,"Al Kuwayt - Kuwait - 51321");
		distinationMap.put(2508,"Al Ladhiqiyah - Syria - 50215");
		distinationMap.put(3689,"Al Mahdiyah - Tunisia - 72300");
		distinationMap.put(2679,"Al Manamah Harbor - Bahrain - 52502");
		distinationMap.put(2656,"Al Mokha - Yemen - 52125");
		distinationMap.put(2647,"Al Mukalla - Yemen - 52100");
		distinationMap.put(3748,"Al Quasayr - Egypt - 72999");
		distinationMap.put(4563,"ALAMEDA - United States - 2813");
		distinationMap.put(4161,"Albania - Albania - 4810");
		distinationMap.put(3447,"Albany - Australia - 60200");
		distinationMap.put(4423,"ALBANY - United States - 1002");
		distinationMap.put(2150,"Albufeira - Portugal - 47100");
		distinationMap.put(4520,"ALBURQUERQUE - United States - 2407");
		distinationMap.put(4623,"ALCAN - United States - 3104");
		distinationMap.put(2102,"Alcanar - Spain - 47051");
		distinationMap.put(2140,"Alcudia - Spain - 47099");
		distinationMap.put(2021,"Aleksandrovski - Russia - 46239");
		distinationMap.put(1157,"Alenquer - Brazil - 35198");
		distinationMap.put(121,"Alert Bay, BC - Canada - 12203");
		distinationMap.put(2446,"Alexandretta - Turkey - 48931");
		distinationMap.put(3722,"Alexandria - Egypt - 72901");
		distinationMap.put(4810,"ALEXANDRIA - United States - 5402");
		distinationMap.put(4870,"ALEXANDRIA BAY - United States - 0708");
		distinationMap.put(2312,"Alexandroupolis - Greece - 48400");
		distinationMap.put(2022,"Alexandrovsk - Russia - 46239");
		distinationMap.put(2091,"Algeciras - Spain - 47031");
		distinationMap.put(3667,"Alger - Algeria - 72101");
		distinationMap.put(4235,"Algeria - Algeria - 7210");
		distinationMap.put(3668,"Algiers - Algeria - 72101");
		distinationMap.put(57,"Algoma, ONT - Canada - 08525");
		distinationMap.put(4711,"ALGONAC - United States - 3814");
		distinationMap.put(2427,"Aliaga - Turkey - 48900");
		distinationMap.put(2442,"Aliaga - Turkey - 48915");
		distinationMap.put(2103,"Alicante - Spain - 47057");
		distinationMap.put(4775,"ALITALIA - United States - 4777");
		distinationMap.put(2371,"Aliver - Greece - 48449");
		distinationMap.put(2372,"Aliveri - Greece - 48449");
		distinationMap.put(3580,"All Caroline Islands Ports - Kiribati - 62227");
		distinationMap.put(892,"All Colombia Amazon Region Ports - Colombia - 30198");
		distinationMap.put(3995,"All Comoros Ports - Comoros - 78900");
		distinationMap.put(1923,"All Corsica Ports - France - 42796");
		distinationMap.put(1227,"All Falkland Islands Ports - Falk Is - 37200");
		distinationMap.put(1570,"All Faroe Islands Ports - Faroe - 40985");
		distinationMap.put(4002,"All French Southern and Antartic Lands - French So and Art - 79060");
		distinationMap.put(3574,"All Gilbert Islands Ports - Kiribati - 62215");
		distinationMap.put(3904,"All Guinea-Bissau Ports - Guinea Bissau - 76489");
		distinationMap.put(3604,"All Marshall Island Ports - Marshall Is - 68190");
		distinationMap.put(2929,"All Moluccas Ports - Indonesia - 56064");
		distinationMap.put(2301,"All Other Albania Ports - Albania - 48100");
		distinationMap.put(3657,"All Other Algeria Ports - Algeria - 72100");
		distinationMap.put(3888,"All Other Angola Ports - Angola - 76299");
		distinationMap.put(1191,"All Other Argentina Ports - Argentina - 35700");
		distinationMap.put(3449,"All Other Australia Ports - Australia - 60200");
		distinationMap.put(2170,"All Other Azores Ports - Portugal - 47150");
		distinationMap.put(569,"All Other Bahamas Ports - Bahamas - 23600");
		distinationMap.put(2675,"All Other Bahrain Ports - Bahrain - 52500");
		distinationMap.put(2741,"All Other Bangladesh Ports - Bangladesh - 53800");
		distinationMap.put(1828,"All Other Belgium Ports - Belgium - 42300");
		distinationMap.put(3871,"All Other Benin ports - Benin - 76100");
		distinationMap.put(567,"All Other Bermuda Ports - Bermuda - 23299");
		distinationMap.put(1158,"All Other Brazil Ports North of Recife - Brazil - 35198");
		distinationMap.put(1172,"All Other Brazil Ports South of Recife - Brazil - 35199");
		distinationMap.put(3947,"All Other British Indian Ocean Territory - Brit Ind Ocean - 78100");
		distinationMap.put(2970,"All Other Brunei Ports - Brunei - 56100");
		distinationMap.put(2755,"All Other Burma Ports - Burma - 54600");
		distinationMap.put(715,"All Other Caicos Islands - Turks Is - 24300");
		distinationMap.put(3787,"All Other Cameroon Ports - Cameroon - 74299");
		distinationMap.put(178,"All Other Canada Atlantic Region Ports - Canada - 13400");
		distinationMap.put(64,"All Other Canada Great Lakes Region Ports - Canada - 09000");
		distinationMap.put(104,"All Other Canada Pacific Region Ports - Canada - 12200");
		distinationMap.put(2115,"All Other Canary Islands Ports - Spain - 47070");
		distinationMap.put(3908,"All Other Cape Verde Ports - Cape Verde - 76499");
		distinationMap.put(721,"All Other Cayman Island Ports - Cayman Isl - 24400");
		distinationMap.put(1046,"All Other Chile Ports - Chile - 33700");
		distinationMap.put(3238,"All Other China (Taiwan) Ports - China Taiwan - 58300");
		distinationMap.put(895,"All Other Colombia West Coast Region Ports - Colombia - 30199");
		distinationMap.put(876,"All Other Colombian Caribbean Region Ports - Colombia - 30100");
		distinationMap.put(3896,"All Other Congo(Brazzaville) Ports - Congo Brazzaville - 76300");
		distinationMap.put(3919,"All Other Congo(Kinshasha) Ports - Congo Kinshasha - 76600");
		distinationMap.put(492,"All Other Costa Rica Caribbean Region Ports - Costa Rica - 22300");
		distinationMap.put(507,"All Other Costa Rica West Coast Region Ports - Costa Rica - 22399");
		distinationMap.put(2297,"All Other Croatia Ports - Croatia - 47998");
		distinationMap.put(617,"All Other Cuba Ports - Cuba - 23900");
		distinationMap.put(2503,"All Other Cyprus Ports - Cyprus - 49199");
		distinationMap.put(1508,"All Other Denmark Ports - Denmark - 40900");
		distinationMap.put(753,"All Other Dominican Republic Ports - Dominican Republic - 24700");
		distinationMap.put(981,"All Other Ecuador Ports - Ecuador - 33100");
		distinationMap.put(3721,"All Other Egypt Mediterranean Region Ports - Egypt - 72900");
		distinationMap.put(3749,"All Other Egypt Red Sea Region Ports - Egypt - 72999");
		distinationMap.put(448,"All Other El Salvador Ports - El Salvador - 21199");
		distinationMap.put(1647,"All Other England South and East Coast Ports - United Kingdom - 41398");
		distinationMap.put(1599,"All Other England West Coast Ports - United Kingdom - 41299");
		distinationMap.put(3762,"All Other Equatorial Guinea Ports - Equatorial Gui - 73800");
		distinationMap.put(3938,"All Other Eritrea Ports - Eritrea - 77419");
		distinationMap.put(1971,"All Other Estonia Ports - Estonia - 44700");
		distinationMap.put(3620,"All Other Fiji Islands Ports - Fiji - 68630");
		distinationMap.put(1455,"All Other Finland Ports - Finland - 40500");
		distinationMap.put(1856,"All Other France Atlantic Region Ports - France - 42700");
		distinationMap.put(1928,"All Other France Mediterranean Region Ports - France - 42799");
		distinationMap.put(976,"All Other French Guiana Ports - French Guiana - 31700");
		distinationMap.put(3857,"All Other Gabon Ports - Gabon - 75500");
		distinationMap.put(3821,"All Other Gambia Ports - Gambia - 75099");
		distinationMap.put(2067,"All Other Georgia Ports - Georgia - 46357");
		distinationMap.put(1962,"All Other Germany Atlantic Region Ports - Germany - 42899");
		distinationMap.put(1939,"All Other Germany Baltic Region Ports - Germany - 42800");
		distinationMap.put(3811,"All Other Ghana Ports - Ghana - 74900");
		distinationMap.put(2313,"All Other Greece Ports - Greece - 48400");
		distinationMap.put(85,"All Other Greenland - Greenland - 10100");
		distinationMap.put(851,"All Other Guadeloupe Ports - Guadeloupe - 28300");
		distinationMap.put(425,"All Other Guatemala Caribbean Region Ports - Guatemala - 20500");
		distinationMap.put(434,"All Other Guatemala West Coast Region Ports - Guatemala - 20599");
		distinationMap.put(3797,"All Other Guinea Ports - Guinea - 74699");
		distinationMap.put(959,"All Other Guyana Ports - Guyana - 31200");
		distinationMap.put(725,"All Other Haiti Ports - Haiti - 24500");
		

		
		distinationMap.put(451,"All Other Honduras Caribbean Region Ports - Honduras - 21500");
		distinationMap.put(467,"All Other Honduras West Coast Region Ports - Honduras - 21599");
		distinationMap.put(1233,"All Other Iceland Ports - Iceland - 40000");
		distinationMap.put(2722,"All Other India East Coast Ports - India - 53398");
		distinationMap.put(2681,"All other India West Coast Ports - India - 53300");
		distinationMap.put(2849,"All Other Indonesia Ports - Indonesia - 56000");
		distinationMap.put(2533,"All Other Iran Ports - Iran - 50700");
		distinationMap.put(2521,"All Other Iraq Ports - Iraq - 50500");
		distinationMap.put(1760,"All Other Ireland Ports - Ireland - 41900");
		distinationMap.put(2562,"All Other Israel Mediterranean Area Ports - Israel - 50800");
		distinationMap.put(2264,"All Other Italy East Coast Ports - Italy - 47598");
		distinationMap.put(2184,"All Other Italy West Coast Ports - Italy - 47500");
		distinationMap.put(3805,"All Other Ivory Coast Ports - Ivory Coast - 74899");
		distinationMap.put(684,"All Other Jamaica Ports - Jamaica - 24100");
		distinationMap.put(3258,"All Other Japan Ports - Japan - 58800");
		distinationMap.put(2922,"All Other Java Ports - Indonesia - 56058");
		distinationMap.put(2572,"All Other Jordan Ports - Jordan - 51100");
		distinationMap.put(2876,"All Other Kalimantan Ports - Indonesia - 56020");
		distinationMap.put(3942,"All Other Kenya Ports - Kenya - 77999");
		distinationMap.put(2575,"All Other Kuwait Ports - Kuwait - 51300");
		distinationMap.put(316,"All Other Labrador Ports - Canada - 15298");
		distinationMap.put(1974,"All Other Latvia Ports - Latvia - 44900");
		distinationMap.put(2513,"All Other Lebanon Ports - Lebanon - 50400");
		distinationMap.put(785,"All Other Leeward Islands - Unknown - 24800");
		distinationMap.put(3910,"All Other Liberia Ports - Liberia - 76500");
		distinationMap.put(3703,"All Other Libya Ports - Libya - 72500");
		distinationMap.put(1979,"All Other Lithuania Ports - Lithuania - 45100");
		distinationMap.put(3970,"All Other Madagascar Ports - Madagascar - 78800");
		distinationMap.put(2806,"All Other Malaysia Ports - Malaysia - 55700");
		distinationMap.put(2179,"All Other Malta Ports - Malta - 47300");
		distinationMap.put(865,"All Other Martinique Ports - Martinique - 28399");
		distinationMap.put(3770,"All Other Mauritania Ports - Mauritania - 74100");
		distinationMap.put(3959,"All Other Mauritius Ports - Mauritius - 78500");
		distinationMap.put(408,"All Other Mexico East Coast Region Ports - Mexico - 20195");
		distinationMap.put(321,"All Other Mexico West Coast Region Ports - Mexico - 20100");
		distinationMap.put(3637,"All Other Morocco Atlantic Region Ports - Morocco - 71400");
		distinationMap.put(3656,"All Other Morocco Mediterranean Ports - Morocco - 71499");
		distinationMap.put(3961,"All Other Mozambique Ports - Mozambique - 78700");
		distinationMap.put(4017,"All Other Namibia Ports - Namibia - 79299");
		distinationMap.put(825,"All Other Netherlands Antilles Ports - Neth Antilles - 27700");
		distinationMap.put(1788,"All Other Netherlands Ports - Netherlands - 42100");
		distinationMap.put(3583,"All Other New Caledonia Ports - New Caledonia - 64100");
		distinationMap.put(3524,"All Other New Zealand Ports - New Zealand - 61400");
		distinationMap.put(282,"All Other Newfoundland Ports - Canada - 15200");
		distinationMap.put(468,"All Other Nicaragua Caribbean Region Ports - Nicaragua - 21900");
		distinationMap.put(487,"All Other Nicaragua West Coast Region Ports - Nicaragua - 21999");
		distinationMap.put(3828,"All Other Nigeria Ports - Nigeria - 75300");
		distinationMap.put(3200,"All Other North Korea Ports - North Korea - 57900");
		distinationMap.put(1753,"All Other Northern Ireland Ports - United Kingdom - 41800");
		distinationMap.put(1367,"All Other Norway Ports - Norway - 40300");
		distinationMap.put(2659,"All Other Oman Ports - Oman - 52300");
		distinationMap.put(3636,"All Other Pacific Islands, N.E.C. Ports - Unknown - 68699");
		distinationMap.put(2740,"All Other Pakistan Ports - Pakistan - 53599");
		distinationMap.put(511,"All Other Panama Caribbean Region Ports - Panama - 22500");
		distinationMap.put(542,"All Other Panama West Coast Region Ports - Panama - 22599");
		distinationMap.put(3505,"All Other Papua New Guinea Ports - Papua New Guinea - 60400");
		distinationMap.put(1177,"All Other Paraguay Ports - Paraguay - 35300");
		distinationMap.put(3096,"All Other Peoples Republic of China Ports - China - 57000");
		distinationMap.put(1000,"All Other Peru Ports - Peru - 33300");
		distinationMap.put(2974,"All Other Philippines Ports - Philippines - 56500");
		distinationMap.put(1982,"All Other Poland Ports - Poland - 45500");
		distinationMap.put(2423,"All Other Ports in Bulgaria - Bulgaria - 48700");
		distinationMap.put(2151,"All Other Portugal Ports - Portugal - 47100");
		distinationMap.put(2611,"All Other Qatar Ports - Qatar - 51800");
		distinationMap.put(4003,"All Other Republic of South Africa Ports - South Africa - 79100");
		distinationMap.put(2415,"All Other Romania Ports - Romania - 48500");
		distinationMap.put(2004,"All Other Russia Baltic Region Ports - Russia - 46220");
		distinationMap.put(2040,"All Other Russia Black Sea Region Ports - Russia - 46250");
		distinationMap.put(2023,"All Other Russia Eastern Region Ports - Russia - 46239");
		distinationMap.put(1993,"All Other Russia Siberia Region Ports - Russia - 46200");
		distinationMap.put(3907,"All Other Sao Tome and Principe Ports - Sao Tome and Princip - 76495");
		distinationMap.put(2245,"All Other Sardinia Ports - Italy - 47569");
		distinationMap.put(2587,"All Other Saudi Arabia Ports - Saudi Arabia - 51700");
		distinationMap.put(1739,"All Other Scotland East Coast Ports - United Kingdom - 41698");
		distinationMap.put(1704,"All Other Scotland West Coast Ports - United Kingdom - 41600");
		distinationMap.put(3789,"All Other Senegal Ports - Senegal - 74499");
		distinationMap.put(3944,"All Other Seychelles Ports - Seychelles - 78000");
		distinationMap.put(2228,"All Other Sicily Ports - Italy - 47558");
		distinationMap.put(3799,"All Other Sierra Leone Ports - Sierra Leone - 74799");
		distinationMap.put(2842,"All Other Singapore Ports - Singapore - 55900");
		distinationMap.put(2300,"All Other Slovenia Ports - Slovenia - 47999");
		distinationMap.put(3595,"All Other Society Islands Ports - French Polyn - 64178");
		distinationMap.put(3929,"All Other Somalia Eastern Region Ports - Somalia - 77099");
		distinationMap.put(3924,"All Other Somalia Northern Region Ports - Somalia - 77000");
		distinationMap.put(3205,"All Other South Korea Ports - South Korea - 58000");
		distinationMap.put(3095,"All Other Southern Asia, N.E.C. Ports - Unknown - 56899");
		distinationMap.put(3582,"All Other Southern Pacific Islands - Unknown - 62299");
		distinationMap.put(2068,"All Other Spain Atlantic Region Ports North of Por - Spain - 47000");
		distinationMap.put(2098,"All Other Spain Atlantic Region Ports Southeast of+B2566 - Spain - 47049");
		distinationMap.put(2141,"All Other Spain Mediterranean Region Ports - Spain - 47099");
		distinationMap.put(2135,"All other Spanish Africa N.E.C. Ports - Spain - 47095");
		distinationMap.put(2747,"All Other Sri Lanka Ports - Sri Lanka - 54200");
		distinationMap.put(4024,"All Other St. Croix Virgin Islands - US Virgin Is - 91149");
		distinationMap.put(2891,"All Other Sulawesi Ports - Indonesia - 56030");
		distinationMap.put(2955,"All Other Sumatra Ports - Indonesia - 56099");
		distinationMap.put(968,"All Other Suriname Ports - Suriname - 31500");
		distinationMap.put(1257,"All Other Sweden Ports - Sweden - 40100");
		distinationMap.put(2505,"All Other Syria Ports - Syria - 50200");
		distinationMap.put(3952,"All Other Tanzania Ports - Tanzania - 78399");
		distinationMap.put(3501,"All Other Tasmania Ports - Australia - 60299");
		distinationMap.put(2759,"All Other Thailand Ports - Thailand - 54900");
		distinationMap.put(3822,"All Other Togo Ports - Togo - 75200");
		distinationMap.put(811,"All Other Trinidad Ports - Trinidad - 27400");
		distinationMap.put(3684,"All Other Tunisia Ports - Tunisia - 72300");
		distinationMap.put(2483,"All Other Turkey Black Sea and Sea of Marmara Port - Turkey - 48999");
		distinationMap.put(2428,"All Other Turkey Mediterranean Region Ports - Turkey - 48900");
		distinationMap.put(719,"All Other Turks Islands Ports - Turks Is - 24399");
		distinationMap.put(2056,"All Other Ukraine Ports - Ukraine - 46279");
		distinationMap.put(2620,"All Other United Arab Emirates Ports - United Arab Em - 52000");
		distinationMap.put(1182,"All Other Uruguay Ports - Uruguay - 35500");
		distinationMap.put(897,"All Other Venezuela Ports - Venezuela - 30700");
		distinationMap.put(2784,"All Other Viet Nam Ports - Vietnam - 55200");
		distinationMap.put(4031,"All Other Virgin Islands Ports - US Virgin Is - 91195");
		distinationMap.put(1689,"All Other Wales Ports - United Kingdom - 41400");
		distinationMap.put(2886,"All Other West New Guinea Ports - Indonesia - 56025");
		distinationMap.put(3758,"All Other Western Sahara Ports - Western Sahara - 73700");
		distinationMap.put(3559,"All Other Western Samoa Ports - Samoa - 61500");
		distinationMap.put(807,"All Other Windward Island Ports - Unknown - 24899");
		distinationMap.put(2648,"All Other Yemen Ports - Yemen - 52100");
		distinationMap.put(2801,"All Ports in Cambodia - Cambodia - 55500");
		distinationMap.put(3561,"All Solomon Islands Ports - Solomon Is - 62200");
		distinationMap.put(3869,"All St. Helena Ports - St. Helena - 75899");
		distinationMap.put(3631,"All Tonga Islands Ports - Tonga - 68682");
		distinationMap.put(4055,"All United States Outlying Islands - US Outlying Is - 98000");
		distinationMap.put(3591,"All Wallis and Futuna Ports - Wallis - 64131");
		distinationMap.put(4436,"ALLENTOWN/BETHLEHEM/EASTON AIRPORT - United States - 1181");
		distinationMap.put(2692,"Alleppey - India - 53301");
		distinationMap.put(709,"Alligator Pond - Jamaica - 24165");
		distinationMap.put(2874,"Alluth Kalimantan - Indonesia - 56019");
		distinationMap.put(4321,"ALMATY - Kazakhstan - 40549");
		distinationMap.put(4339,"Almaty - Kazakhstan - 44911");
		distinationMap.put(4395,"Almaty - KAZAKHSTAN - 5700");
		distinationMap.put(4340,"Almaty - KZ - 44911");
		distinationMap.put(4323,"ALMATY 1 - Kazakhstan - 45101");
		distinationMap.put(2104,"Almeria - Spain - 47059");
		distinationMap.put(517,"Almirante - Panama - 22501");
		distinationMap.put(3557,"Alofi - Niue - 61481");
		distinationMap.put(3516,"Alotau - Papua New Guinea - 60432");
		distinationMap.put(4718,"ALPENA - United States - 3843");
		distinationMap.put(4897,"Alpharetta - United States - 17005");
		distinationMap.put(1804,"Alphen aan den Rijn - Netherlands - 42103");
		distinationMap.put(898,"Altagracia - Venezuela - 30700");
		distinationMap.put(403,"Altamira - Mexico - 20193");
		distinationMap.put(322,"Altata - Mexico - 20100");
		distinationMap.put(1963,"Altona - Germany - 42899");
		distinationMap.put(409,"Alvarado - Mexico - 20195");
		distinationMap.put(382,"Alvaro Obregon - Mexico - 20153");
		distinationMap.put(1368,"Alvik - Norway - 40300");
		distinationMap.put(3314,"Amagasaki - Japan - 58813");
		distinationMap.put(3517,"Amamapare - Papua New Guinea - 60433");
		distinationMap.put(464,"Amapala - Honduras - 21551");
		distinationMap.put(4812,"AMARILLO - United States - 5502");
		distinationMap.put(1159,"Amarracao - Brazil - 35198");
		distinationMap.put(2024,"Ambarchik - Russia - 46239");
		distinationMap.put(2472,"Ambarli - Turkey - 48945");
		distinationMap.put(1877,"Ambes - France - 42703");
		distinationMap.put(2930,"Ambon - Indonesia - 56064");
		distinationMap.put(3889,"Ambriz - Angola - 76299");
		distinationMap.put(4672,"AMBROSE - United States - 3410");
		distinationMap.put(4299,"American Samoa - American Samoa - 9510");
		distinationMap.put(4898,"AMERICUS,  - United States - 1703");
		distinationMap.put(32,"Amherstburg, ONT - Canada - 03504");
		distinationMap.put(3172,"Amoy - China - 57069");
		distinationMap.put(2907,"Ampenan - Indonesia - 56041");
		distinationMap.put(1805,"Amsterdam - Netherlands - 42105");
		distinationMap.put(921,"Amuay Bay - Venezuela - 30704");
		distinationMap.put(4600,"ANACORTES - United States - 3010");
		distinationMap.put(2025,"Anadyr - Russia - 46239");
		distinationMap.put(4631,"ANCHORAGE - United States - 3126");
		distinationMap.put(1030,"Ancon - Peru - 33301");
		distinationMap.put(2248,"Ancona - Italy - 47571");
		distinationMap.put(1069,"Ancud - Chile - 33700");
		distinationMap.put(1369,"Andalsnes - Norway - 40300");
		distinationMap.put(4123,"Andorra - Andorra - 4271");
		distinationMap.put(4524,"ANDRADE - United States - 2502");
		distinationMap.put(754,"Andres - Dominican Republic - 24700");
		distinationMap.put(610,"Andros Island - Bahamas - 23672");
		distinationMap.put(3492,"Androssan - Australia - 60276");
		distinationMap.put(3823,"Anecho - Togo - 75200");
		distinationMap.put(3515,"Anewa Bay - Papua New Guinea - 60431");
		distinationMap.put(4260,"Angola - Angola - 7620");
		distinationMap.put(2171,"Angra do Heroismo - Portugal - 47150");
		distinationMap.put(1093,"Angra dos Reis - Brazil - 35107");
		distinationMap.put(4082,"Anguilla - Anguilla - 2481");
		distinationMap.put(789,"Anguilla - Anguilla - 24821");
		distinationMap.put(3674,"Annaba - Algeria - 72123");
		distinationMap.put(4438,"ANNAPOLIS - United States - 1301");
		distinationMap.put(685,"Annotto Bay - Jamaica - 24100");
		distinationMap.put(726,"Anse du Clerc - Haiti - 24500");
		distinationMap.put(727,"Anse-D&#39;Hainault - Haiti - 24500");
		distinationMap.put(3971,"Antalaha - Madagascar - 78800");
		distinationMap.put(2438,"Antalya - Turkey - 48903");
		distinationMap.put(3834,"Antan Terminal - Nigeria - 75315");
		distinationMap.put(4085,"Antigua and Barbuda - Antigua and Barbuda - 2484");
		distinationMap.put(618,"Antilla - Cuba - 23900");
		distinationMap.put(4673,"ANTLER - United States - 3413");
		distinationMap.put(1070,"Antofagasta - Chile - 33703");
		distinationMap.put(1122,"Antonina - Brazil - 35159");
		distinationMap.put(3972,"Antsirana - Madagascar - 78800");
		distinationMap.put(3973,"Antsiranana - Madagascar - 78800");
		distinationMap.put(1841,"Antwerp - Belgium - 42305");
		distinationMap.put(1842,"Anvers - Belgium - 42305");
		distinationMap.put(2185,"Anzio - Italy - 47500");
		distinationMap.put(2770,"Ao Phuket - Thailand - 54902");
		distinationMap.put(3357,"Aomori - Japan - 58844");
		distinationMap.put(3833,"Apapa - Nigeria - 75313");
		distinationMap.put(3560,"Apia - Samoa - 61501");
		distinationMap.put(2574,"Aqaba - Jordan - 51105");
		distinationMap.put(728,"Aquin - Haiti - 24500");
		distinationMap.put(1173,"Aracaju - Brazil - 35199");
		distinationMap.put(1160,"Aracati - Brazil - 35198");
		distinationMap.put(2975,"Aras-Asan - Philippines - 56500");
		distinationMap.put(1096,"Aratu - Brazil - 35115");
		distinationMap.put(582,"Arawak Cay - Bahamas - 23630");
		distinationMap.put(1857,"Arcachon - France - 42700");
		distinationMap.put(1994,"Archangel - Russia - 46200");
		distinationMap.put(543,"Archipel. de Las Perlas - Panama - 22599");
		distinationMap.put(1411,"Ardal - Norway - 40302");
		distinationMap.put(1705,"Ardrossan - United Kingdom - 41600");
		distinationMap.put(1161,"Areia Branca - Brazil - 35198");
		distinationMap.put(1370,"Arendal - Norway - 40300");
		distinationMap.put(297,"Argentia, NFLD - Canada - 15213");
		distinationMap.put(4109,"Argentina - Argentina - 3570");
		distinationMap.put(2314,"Argostolion - Greece - 48400");
		distinationMap.put(2116,"Arguinequin - Spain - 47070");
		distinationMap.put(1071,"Arica - Chile - 33706");
		
		
		distinationMap.put(2906,"Arjuna Terminal - Indonesia - 56040");
		distinationMap.put(1995,"Arkhangelsk - Russia - 46200");
		distinationMap.put(1782,"Arklow - Ireland - 41916");
		distinationMap.put(2026,"Arkovo Bereg - Russia - 46239");
		distinationMap.put(483,"Arlen Siu - Nicaragua - 21902");
		distinationMap.put(4140,"Armenia - Armenia - 4631");
		distinationMap.put(539,"Armuelles - Panama - 22587");
		distinationMap.put(1258,"Arnoviken - Sweden - 40100");
		distinationMap.put(2117,"Arrecife - Spain - 47070");
		distinationMap.put(2931,"Aru Bay - Indonesia - 56064");
		distinationMap.put(4094,"Aruba - Aruba - 2779");
		distinationMap.put(2631,"Arzanah Island - United Arab Em - 52003");
		distinationMap.put(3670,"Arzew - Algeria - 72105");
		distinationMap.put(3671,"Arziw - Algeria - 72105");
		distinationMap.put(3711,"As Sidr - Libya - 72519");
		distinationMap.put(3696,"As Sukhayrah - Tunisia - 72315");
		distinationMap.put(2566,"Ascalon - Israel - 50810");
		distinationMap.put(3933,"Aseb - Eritrea - 77405");
		distinationMap.put(2642,"Ash Shariqah - United Arab Em - 52070");
		distinationMap.put(2585,"Ash Shuaiba - Kuwait - 51350");
		distinationMap.put(2564,"Ashdod - Israel - 50805");
		distinationMap.put(4352,"Ashgabad - Turkmenistan - 44911");
		distinationMap.put(2565,"Ashkelon - Israel - 50810");
		distinationMap.put(4693,"ASHLAND - United States - 3602");
		distinationMap.put(4738,"ASHTABULA - United States - 4108");
		distinationMap.put(3685,"Ashtart Terminal - Tunisia - 72300");
		distinationMap.put(1561,"Asnaes - Denmark - 40940");
		distinationMap.put(1562,"Asnaesvaerkets Havn - Denmark - 40940");
		distinationMap.put(2381,"Aspropirgos - Greece - 48453");
		distinationMap.put(2382,"Aspropyrgos - Greece - 48453");
		distinationMap.put(3934,"Assab - Eritrea - 77405");
		distinationMap.put(1509,"Assens - Denmark - 40900");
		distinationMap.put(4376,"Astana - Kazakhstan - 44911");
		distinationMap.put(4398,"ASTANA - KAZAKHSTAN - 5700");
		distinationMap.put(4580,"ASTORIA - United States - 2901");
		distinationMap.put(1181,"Asuncion - Paraguay - 35301");
		distinationMap.put(2439,"Atalia - Turkey - 48903");
		distinationMap.put(1001,"Atico - Peru - 33300");
		distinationMap.put(4461,"ATLANTA - United States - 1704");
		distinationMap.put(3259,"Atsumi - Japan - 58800");
		distinationMap.put(2862,"Attaka - Indonesia - 56006");
		distinationMap.put(2440,"Attalea - Turkey - 48903");
		distinationMap.put(3534,"Auckland - New Zealand - 61401");
		distinationMap.put(1776,"Aughinish - Ireland - 41906");
		distinationMap.put(2218,"Augusta - Italy - 47542");
		distinationMap.put(238,"Auld&#39;s Cove, NS - Canada - 13846");
		distinationMap.put(4816,"AUSTIN - United States - 5506");
		distinationMap.put(4209,"Australia - Australia - 6021");
		distinationMap.put(4127,"Austria - Austria - 4330");
		distinationMap.put(739,"Aux Cayes - Haiti - 24509");
		distinationMap.put(3554,"Avatiu - New Zealand - 61461");
		distinationMap.put(2165,"Aveiro - Portugal - 47130");
		distinationMap.put(2077,"Aviles - Spain - 47003");
		distinationMap.put(4494,"AVONDALE - United States - 2012");
		distinationMap.put(1581,"Avonmouth - United Kingdom - 41201");
		distinationMap.put(3812,"Axim - Ghana - 74900");
		distinationMap.put(2350,"Ayia Marina - Greece - 48402");
		distinationMap.put(2383,"Ayia Trias - Greece - 48454");
		distinationMap.put(2351,"Ayios Nikolaos - Greece - 48405");
		distinationMap.put(1706,"Ayr - United Kingdom - 41600");
		distinationMap.put(4141,"Azerbaijan - Azerbaijan - 4632");
		distinationMap.put(755,"Azua - Dominican Republic - 24700");
		distinationMap.put(2976,"Bacalod - Philippines - 56500");
		distinationMap.put(899,"Bachaquero - Venezuela - 30700");
		distinationMap.put(179,"Back Bay, NB - Canada - 13400");
		distinationMap.put(247,"Baddeck, CBI - Canada - 13855");
		distinationMap.put(317,"Baffin Island, NL - Canada - 15298");
		distinationMap.put(2523,"Baghdad - Iraq - 50501");
		distinationMap.put(2197,"Bagnoli - Italy - 47505");
		distinationMap.put(1209,"Bagual - Argentina - 35710");
		distinationMap.put(4075,"Bahamas - Bahamas - 2360");
		distinationMap.put(1202,"Bahia Blanca - Argentina - 35701");
		distinationMap.put(922,"Bahia de Amuay - Venezuela - 30704");
		distinationMap.put(988,"Bahia de Caraquez - Ecuador - 33101");
		distinationMap.put(1002,"Bahia de Eten - Peru - 33300");
		distinationMap.put(766,"Bahia de Las Calderas - Dominican Republic - 24731");
		distinationMap.put(530,"Bahia de Las Minas - Panama - 22565");
		distinationMap.put(497,"Bahia de Moin - Costa Rica - 22315");
		distinationMap.put(619,"Bahia de Nuevitas - Cuba - 23900");
		distinationMap.put(323,"Bahia de Todos Santos - Mexico - 20100");
		distinationMap.put(930,"Bahia Guanta - Venezuela - 30741");
		distinationMap.put(620,"Bahia Honda - Cuba - 23900");
		distinationMap.put(621,"Bahia Sama - Cuba - 23900");
		distinationMap.put(324,"Bahia Tortugas - Mexico - 20100");
		distinationMap.put(325,"Bahias Ballenas - Mexico - 20100");
		distinationMap.put(4181,"Bahrain - Bahrain - 5250");
		distinationMap.put(220,"Baie Comeau, QUE - Canada - 13481");
		distinationMap.put(3584,"Baie de Kouaoua - New Caledonia - 64100");
		distinationMap.put(3585,"Baie de Poro - New Caledonia - 64100");
		distinationMap.put(866,"Baie du Galion - Martinique - 28399");
		distinationMap.put(3586,"Baie Ugue - New Caledonia - 64100");
		distinationMap.put(3055,"Bais - Philippines - 56503");
		distinationMap.put(2712,"Baj-Baj - India - 53351");
		distinationMap.put(923,"Bajo Grande - Venezuela - 30708");
		distinationMap.put(2286,"Bakar - Croatia - 47923");
		distinationMap.put(4302,"Baku - Azerbaijan - 46337");
		distinationMap.put(989,"Balao - Ecuador - 33109");
		distinationMap.put(990,"Balao Terminal - Ecuador - 33109");
		distinationMap.put(1929,"Balaruc - France - 42799");
		distinationMap.put(1930,"Balaruc les Bains - France - 42799");
		distinationMap.put(533,"Balboa - Panama - 22575");
		distinationMap.put(2863,"Balikpapan - Indonesia - 56007");
		distinationMap.put(1371,"Ballangen - Norway - 40300");
		distinationMap.put(326,"Ballenas Bay - Mexico - 20100");
		distinationMap.put(2909,"Balongan Terminal - Indonesia - 56042");
		distinationMap.put(4440,"BALTIMORE - United States - 1303");
		distinationMap.put(4442,"BALTIMORE WASHINGTON AIRPORT - United States - 1305");
		distinationMap.put(2771,"Ban Tha Rua - Thailand - 54902");
		distinationMap.put(3920,"Banana - Congo Kinshasha - 76600");
		distinationMap.put(2553,"Bandar Abbas - Iran - 50730");
		distinationMap.put(2534,"Bandar E Lengeh - Iran - 50700");
		distinationMap.put(2555,"Bandar E Mah Shahr - Iran - 50739");
		distinationMap.put(2560,"Bandar Khomeini - Iran - 50770");
		distinationMap.put(2556,"Bandar Mahshahr - Iran - 50739");
		distinationMap.put(2536,"Bandar Shadid Beheshti - Iran - 50700");
		distinationMap.put(2554,"Bandar Shahid Rejaie - Iran - 50730");
		distinationMap.put(2557,"Bandar-e-Mashur - Iran - 50739");
		distinationMap.put(2537,"Bandar-e-Shahpur - Iran - 50700");
		distinationMap.put(1510,"Bandholm - Denmark - 40900");
		distinationMap.put(2479,"Bandirma - Turkey - 48963");
		distinationMap.put(622,"Banes - Cuba - 23900");
		distinationMap.put(2769,"Bangkok - Thailand - 54901");
		distinationMap.put(4186,"Bangladesh - Bangladesh - 5380");
		distinationMap.put(1756,"Bangor - United Kingdom - 41802");
		distinationMap.put(4822,"BANGOR - United States - 0102");
		distinationMap.put(2506,"Banias - Syria - 50200");
		distinationMap.put(2507,"Baniyas - Syria - 50200");
		distinationMap.put(2868,"Banjarmasin - Indonesia - 56013");
		distinationMap.put(2869,"Banjer Masin - Indonesia - 56013");
		distinationMap.put(3819,"Banjul - Gambia - 75041");
		distinationMap.put(2923,"Banjuwangi - Indonesia - 56058");
		distinationMap.put(2924,"Banyuwangi - Indonesia - 56058");
		distinationMap.put(3691,"Banzart - Tunisia - 72301");
		distinationMap.put(4965,"BAR - MONTENEGRO - 47901");
		distinationMap.put(2270,"Bar - Serbia - 47901");
		distinationMap.put(4832,"BAR HARBOR - United States - 0112");
		distinationMap.put(623,"Baracoa - Cuba - 23900");
		distinationMap.put(760,"Barahona - Dominican Republic - 24713");
		distinationMap.put(964,"Barama - Guyana - 31230");
		distinationMap.put(965,"Baramanni - Guyana - 31230");
		distinationMap.put(1121,"Barao de Teffe - Brazil - 35159");
		distinationMap.put(4091,"Barbados - Barbados - 2720");
		distinationMap.put(833,"Barcadera - Aruba - 27703");
		distinationMap.put(1099,"Barcarena - Brazil - 35121");
		distinationMap.put(2105,"Barcelona - Spain - 47061");
		distinationMap.put(2249,"Bari - Italy - 47578");
		distinationMap.put(2250,"Barletta - Italy - 47579");
		distinationMap.put(4959,"BARNAUL - Russia - 44911");
		distinationMap.put(879,"Barranquilla - Colombia - 30104");
		distinationMap.put(2162,"Barreiro - Portugal - 47126");
		distinationMap.put(1694,"Barri - United Kingdom - 41401");
		distinationMap.put(1174,"Barro do Riacho - Brazil - 35199");
		distinationMap.put(1600,"Barrow in Furness - United Kingdom - 41299");
		distinationMap.put(1695,"Barry - United Kingdom - 41401");
		distinationMap.put(1648,"Barton - United Kingdom - 41398");
		distinationMap.put(4405,"BASEL - SWITZERLAND - 42157");
		distinationMap.put(4947,"Basel - Switzerland - 42870");
		distinationMap.put(2527,"Basra - Iraq - 50525");
		distinationMap.put(2528,"Basrah - Iraq - 50525");
		distinationMap.put(856,"Basse Terre - Guadeloupe - 28315");
		distinationMap.put(1875,"Bassens - France - 42701");
		distinationMap.put(793,"Basseterre, St. Kitts - St. Kitts Nevis - 24835");
		distinationMap.put(1924,"Bastia - France - 42796");
		distinationMap.put(3118,"Basuo - China - 57003");
		distinationMap.put(3763,"Bata - Equatorial Gui - 73800");
		distinationMap.put(3058,"Bataan - Philippines - 56507");
		distinationMap.put(3057,"Batangas - Philippines - 56506");
		distinationMap.put(4831,"BATH - United States - 0111");
		distinationMap.put(9,"Bath, ONT - Canada - 01653");
		distinationMap.put(3820,"Bathurst - Gambia - 75041");
		distinationMap.put(211,"Bathurst, NB - Canada - 13458");
		distinationMap.put(4707,"BATLE CREEK - United States - 3805");
		distinationMap.put(4486,"BATON ROUGE - United States - 2004");
		distinationMap.put(4407,"BATUMI - GEORGIA - 46320");
		distinationMap.put(4408,"BATUMI - GEORGIA - 46321");
		distinationMap.put(2063,"Batumi - Georgia - 46321");
		distinationMap.put(2064,"Batumiyskava Bukhta - Georgia - 46321");
		distinationMap.put(3056,"Bauan - Philippines - 56504");
		distinationMap.put(4683,"BAUDETTE - United States - 3424");
		distinationMap.put(288,"Bay Roberts, NFLD - Canada - 15205");
		distinationMap.put(1876,"Bayonne - France - 42702");
		distinationMap.put(1003,"Bayovar - Peru - 33300");
		distinationMap.put(2517,"Bayrut - Lebanon - 50401");
		distinationMap.put(212,"Bayside, NB - Canada - 13459");
		distinationMap.put(135,"Beale Cove, BC - Canada - 12215");
		distinationMap.put(4453,"BEAUFORT-MOREHEAD CITY - United States - 1511");
		distinationMap.put(20,"Beauharnoi, QUE - Canada - 01806");
		distinationMap.put(4506,"BEAUMONT - United States - 2104");
		distinationMap.put(3502,"Beauty Point - Australia - 60299");
		distinationMap.put(194,"Beaver Harbour, NB - Canada - 13435");
		distinationMap.put(1583,"Bebington - United Kingdom - 41211");
		distinationMap.put(1878,"Bec d&#39; Ambes - France - 42703");
		distinationMap.put(1879,"Bec Dambes - France - 42703");
		distinationMap.put(197,"Becancour, QUE - Canada - 13441");
		distinationMap.put(2694,"Bedi - India - 53305");
		distinationMap.put(4844,"BEECHER FALLS - United States - 0206");
		distinationMap.put(3191,"Bei Hai - China - 57076");
		distinationMap.put(3135,"Bei Jao - China - 57016");
		distinationMap.put(3192,"Beihai - China - 57076");
		distinationMap.put(3120,"Beilun - China - 57005");
		distinationMap.put(3966,"Beira - Mozambique - 78701");
		distinationMap.put(2518,"Beirut - Lebanon - 50401");
		distinationMap.put(3673,"Bejaia - Algeria - 72107");
		distinationMap.put(4138,"Belarus - Belarus - 4622");
		distinationMap.put(2938,"Belawan - Indonesia - 56073");
		distinationMap.put(1100,"Belem - Brazil - 35121");
		distinationMap.put(1755,"Belfast - United Kingdom - 41801");
		distinationMap.put(4839,"BELFAST - United States - 0132");
		distinationMap.put(4121,"Belgium - Belgium - 4231");
		distinationMap.put(4351,"BELGRADE - SERBIA - 47909");
		distinationMap.put(4386,"BELGRADE - SERBIA - 47923");
		distinationMap.put(2053,"Belgrod-Dnestrovskiy - Ukraine - 46277");
		distinationMap.put(2853,"Beliling - Indonesia - 56001");
		distinationMap.put(2956,"Belinju - Indonesia - 56099");
		distinationMap.put(2957,"Belinyu - Indonesia - 56099");
		distinationMap.put(4068,"Belize - Belize - 2080");
		distinationMap.put(441,"Belize - Belize - 20801");
		distinationMap.put(3497,"Bell Bay - Australia - 60290");
		distinationMap.put(136,"Bella Coola, BC - Canada - 12216");
		distinationMap.put(198,"Belledune, NB - Canada - 13442");
		distinationMap.put(4595,"BELLINGHAM - United States - 3005");
		distinationMap.put(1690,"Bellport - United Kingdom - 41400");
		distinationMap.put(3706,"Benghazi - Libya - 72501");
		distinationMap.put(2947,"Bengkulu - Indonesia - 56079");
		distinationMap.put(3890,"Benguela - Angola - 76299");
		distinationMap.put(3675,"Beni Saf - Algeria - 72123");
		distinationMap.put(4259,"Benin - Benin - 7610");
		distinationMap.put(2855,"Benoa - Indonesia - 56002");
		distinationMap.put(3925,"Berbera - Somalia - 77001");
		distinationMap.put(2055,"Berdyansk - Ukraine - 46278");
		distinationMap.put(1414,"Bergen - Norway - 40311");
		distinationMap.put(4074,"Bermuda - Bermuda - 2320");
		distinationMap.put(1907,"Berre - France - 42773");
		distinationMap.put(1631,"Berwick - United Kingdom - 41359");
		distinationMap.put(1632,"Berwick upon Tweed - United Kingdom - 41359");
		distinationMap.put(3672,"Bethioua - Algeria - 72105");
		distinationMap.put(3575,"Betio - Kiribati - 62215");
		distinationMap.put(2721,"Beypore - India - 53396");
		distinationMap.put(2519,"Beyrouth - Lebanon - 50401");
		distinationMap.put(2693,"Bhavnagar - India - 53303");
		distinationMap.put(2723,"Bheemunipatnam - India - 53398");
		distinationMap.put(2772,"Bhuket - Thailand - 54902");
		distinationMap.put(4200,"Bhutan - Bhutan - 5682");
		distinationMap.put(1601,"Bideford - United Kingdom - 41299");
		distinationMap.put(442,"Big Creek - Belize - 20802");
		distinationMap.put(2079,"Bilbao - Spain - 47005");
		distinationMap.put(2939,"Bima - Indonesia - 56074");
		distinationMap.put(2940,"Bima Terminal - Indonesia - 56074");
		distinationMap.put(614,"Bimini Island - Bahamas - 23683");
		distinationMap.put(2830,"Bintulu - Malaysia - 55732");
		distinationMap.put(1582,"Birkenhead - United Kingdom - 41207");
		distinationMap.put(4481,"BIRMINGHAM - United States - 1904");
		distinationMap.put(4312,"BISHKEK - KIRGIZISTAN - 01111");
		distinationMap.put(4338,"BISHKEK - KYRGYZSTAN - 44911");
		distinationMap.put(4313,"BISHKEK - Kyrgyzstan - 45101");
		distinationMap.put(4363,"BISHKEK - KYRGYZSTAN - 45101");
		distinationMap.put(4415,"Bishkek - Kyrgyzstan - 57047");
		distinationMap.put(3059,"Bislig - Philippines - 56508");
		distinationMap.put(3905,"Bissau - Guinea Bissau - 76489");
		distinationMap.put(2890,"Bitung - Indonesia - 56028");
		distinationMap.put(3692,"Bizerta - Tunisia - 72301");
		distinationMap.put(3693,"Bizerte - Tunisia - 72301");
		distinationMap.put(1501,"Bjorneborg - Finland - 40562");
		distinationMap.put(686,"Black River - Jamaica - 24100");
		distinationMap.put(202,"Blacks Harbor, NB - Canada - 13450");
		distinationMap.put(4594,"BLAINE - United States - 3004");
		distinationMap.put(2958,"Blang Lancang - Indonesia - 56099");
		distinationMap.put(1880,"Blaye - France - 42705");
		distinationMap.put(1964,"Blexen - Germany - 42899");
		distinationMap.put(180,"Bliss Harbor, NB - Canada - 13400");
		distinationMap.put(4889,"Bloomingto - United States - 4101");
		distinationMap.put(134,"Blubber Bay, BC - Canada - 12214");
		distinationMap.put(687,"Bluefields - Jamaica - 24100");
		distinationMap.put(481,"Bluefields - Nicaragua - 21901");
		distinationMap.put(4750,"BLUEGRASS AIRPORT,LEXINGTON - United States - 4184");
		distinationMap.put(3535,"Bluff Harbor - New Zealand - 61403");
		distinationMap.put(1965,"Blumenthal - Germany - 42899");
		distinationMap.put(1649,"Blyth - United Kingdom - 41398");
		distinationMap.put(1162,"Boa Vista - Brazil - 35198");
		distinationMap.put(900,"Bobures - Venezuela - 30700");
		distinationMap.put(763,"Boca Chica - Dominican Republic - 24721");
		distinationMap.put(4465,"BOCA GRANDE - United States - 1807");
		distinationMap.put(229,"Boca Sec, NB - Canada - 13829");
		distinationMap.put(512,"Bocas del Toro - Panama - 22500");
		distinationMap.put(1436,"Bodo - Norway - 40369");
		distinationMap.put(1426,"Bogen - Norway - 40337");
		distinationMap.put(1428,"Bogen Bay - Norway - 40337");
		distinationMap.put(1511,"Bogense - Denmark - 40900");
		distinationMap.put(2977,"Bogo - Philippines - 56500");
		distinationMap.put(4585,"BOISE - United States - 2907");
		distinationMap.put(4104,"Bolivia - Bolivia - 3350");
		distinationMap.put(1259,"Bollsta - Sweden - 40100");
		distinationMap.put(3922,"Boma - Congo Kinshasha - 76638");
		distinationMap.put(2700,"Bombay - India - 53312");
		distinationMap.put(3676,"Bona - Algeria - 72123");
		distinationMap.put(3775,"Bonaberi - Cameroon - 74201");
		distinationMap.put(283,"Bonavista, NFLD - Canada - 15200");
		distinationMap.put(3677,"Bone - Algeria - 72123");
		distinationMap.put(3260,"Bonin Islands - Japan - 58800");
		distinationMap.put(3837,"Bonny - Nigeria - 75322");
		distinationMap.put(2943,"Bontang - Indonesia - 56077");
		distinationMap.put(2944,"Bontang Bay - Indonesia - 56077");
		distinationMap.put(3800,"Bonthe - Sierra Leone - 74799");
		distinationMap.put(670,"Boqueron - Cuba - 23941");
		distinationMap.put(3596,"Bora Bora - French Polyn - 64178");
		distinationMap.put(1881,"Bordeaux - France - 42707");
		distinationMap.put(1421,"Borg Hbr. - Norway - 40334");
		distinationMap.put(2877,"Borneo - Indonesia - 56020");
		distinationMap.put(1512,"Bornholm - Denmark - 40900");
		distinationMap.put(3597,"Boro Boro - French Polyn - 64178");
		distinationMap.put(4158,"Bosnia-Hercegovina - Bosnia-Hercegovina - 4793");
		distinationMap.put(1650,"Boston - United Kingdom - 41398");
		distinationMap.put(4849,"BOSTON - United States - 0401");
		distinationMap.put(3463,"Botany Bay - Australia - 60205");
		distinationMap.put(2447,"Botas Terminal - Turkey - 48931");
		distinationMap.put(1806,"Botlek - Netherlands - 42115");
		distinationMap.put(4287,"Botswana - Botswana - 7930");
		distinationMap.put(298,"Botwood, NFLD - Canada - 15214");
		distinationMap.put(1891,"Boucau - France - 42735");
		distinationMap.put(1882,"Boulogne - France - 42708");
		distinationMap.put(4605,"BOUNDARY - United States - 3015");
		distinationMap.put(2424,"Bourgas - Bulgaria - 48702");
		distinationMap.put(3450,"Bowen - Australia - 60200");
		distinationMap.put(1707,"Bowling - United Kingdom - 41600");
		distinationMap.put(79,"Bowmanville, ONT - Canada - 09665");
		distinationMap.put(1737,"Braefoot Bay - United Kingdom - 41684");
		distinationMap.put(2416,"Braila - Romania - 48500");
		distinationMap.put(1947,"Brake - Germany - 42867");
		distinationMap.put(3835,"Brass - Nigeria - 75320");
		distinationMap.put(3836,"Brass Terminal - Nigeria - 75320");
		distinationMap.put(4106,"Brazil - Brazil - 3510");
		distinationMap.put(1949,"Bremen - Germany - 42869");
		distinationMap.put(1950,"Bremerhaven - Germany - 42870");
		distinationMap.put(4359,"Brest - BELARUS - 45101");
		distinationMap.put(1883,"Brest - France - 42709");
		distinationMap.put(1103,"Breves - Brazil - 35123");
		distinationMap.put(1415,"Brevik - Norway - 40313");
		distinationMap.put(65,"Bridgeburg, ONT - Canada - 09000");
		distinationMap.put(4858,"BRIDGEPORT - United States - 0410");
		distinationMap.put(808,"Bridgetown - Barbados - 27201");
		distinationMap.put(181,"Bridgetown, NS - Canada - 13400");
		distinationMap.put(4837,"BRIDGEWATER - United States - 0127");
		distinationMap.put(242,"Bridgewater, NS - Canada - 13850");
		distinationMap.put(812,"Brighton - Trinidad - 27400");
		distinationMap.put(4900,"BRIGHTON,  - United States - 5301");
		distinationMap.put(2254,"Brindisi - Italy - 47583");
		distinationMap.put(3464,"Brisbane - Australia - 60210");
		distinationMap.put(1584,"Bristol - United Kingdom - 41211");
		distinationMap.put(4276,"British Indian Ocean Terr - British Indian Ocean Terr - 7810");
		distinationMap.put(4083,"British Virgin Islands - British Virgin Islands - 2482");
		distinationMap.put(3,"Britt, ONT - Canada - 01528");
		distinationMap.put(1651,"Brixham - United Kingdom - 41398");
		distinationMap.put(13,"Brockville, ONT - Canada - 01694");
		distinationMap.put(1260,"Brofjorden - Sweden - 40100");
		distinationMap.put(969,"Brokopondo - Suriname - 31500");
		distinationMap.put(1585,"Bromsborough - United Kingdom - 41214");
		distinationMap.put(4937,"BROOKLYN - United States - 1001");
		distinationMap.put(3451,"Broome - Australia - 60200");
		distinationMap.put(570,"Browns Cays - Bahamas - 23600");
		distinationMap.put(4507,"BROWNSVILLE-CAMERON COUNTY - United States - 2301");
		distinationMap.put(60,"Bruce Mines, ONT - Canada - 08526");
		distinationMap.put(1845,"Bruges - Belgium - 42311");
		distinationMap.put(1846,"Brugge - Belgium - 42311");
		distinationMap.put(544,"Bruja Point - Panama - 22599");
		distinationMap.put(4197,"Brunei - Brunei - 5610");
		distinationMap.put(1951,"Brunsbuttel - Germany - 42871");
		distinationMap.put(4459,"BRUNSWICK - United States - 1701");
		distinationMap.put(1847,"Brussels - Belgium - 42315");
		distinationMap.put(1848,"Bruxelles - Belgium - 42315");
		distinationMap.put(3061,"Buayan - Philippines - 56514");
		distinationMap.put(3917,"Buchanan - Liberia - 76505");
		distinationMap.put(3382,"Buckner Bay - Japan - 58860");
		distinationMap.put(4962,"BUDAPEST - HUNGARY - 42870");
		distinationMap.put(2713,"Budge-Budge - India - 53351");
		distinationMap.put(890,"Buenaventura - Colombia - 30151");
		distinationMap.put(1208,"Buenos Aires - Argentina - 35705");
		distinationMap.put(4874,"BUFFALO-NIAGARA FALLS - United States - 0901");
		distinationMap.put(2041,"Bukhta Severnaya - Russia - 46250");
		distinationMap.put(3208,"Bukpyung - South Korea - 58014");
		distinationMap.put(2978,"Bulan - Philippines - 56500");
		distinationMap.put(2854,"Buleleng - Indonesia - 56001");
		distinationMap.put(4164,"Bulgaria - Bulgaria - 4870");
		distinationMap.put(286,"Bull Arm, NFLD - Canada - 15201");
		distinationMap.put(838,"Bullen Baai - Neth Antilles - 27725");
		distinationMap.put(839,"Bullen Bay - Neth Antilles - 27725");
		distinationMap.put(3467,"Bunbury - Australia - 60213");
		distinationMap.put(3468,"Bundaberg - Australia - 60214");
		distinationMap.put(3732,"Bur Said - Egypt - 72913");
		distinationMap.put(1261,"Burea - Sweden - 40100");
		distinationMap.put(2425,"Burgas - Bulgaria - 48702");
		distinationMap.put(284,"Burgeo, NFLD - Canada - 15200");
		distinationMap.put(4258,"Burkina - Burkina - 7600");
		distinationMap.put(4918,"BURLINGTON - United States - 1601");
		distinationMap.put(4752,"BURLINGTON AIR EXPRESS, CONSIGNMENT FACILITY, TOLEDO - United States - 4192");
		distinationMap.put(4188,"Burma (Myanmar) - Burma (Myanmar) - 5460");
		distinationMap.put(174,"Burnaby, BC - Canada - 12495");
		distinationMap.put(3498,"Burnie - Australia - 60291");
		distinationMap.put(1740,"Burntisland - United Kingdom - 41698");
		distinationMap.put(4267,"Burundi - Burundi - 7670");
		distinationMap.put(3829,"Burutu - Nigeria - 75300");
		distinationMap.put(3214,"Busan - South Korea - 58023");
		distinationMap.put(2538,"Bushehr - Iran - 50700");
		distinationMap.put(2539,"Bushire - Iran - 50700");
		distinationMap.put(3576,"Butaritari - Kiribati - 62215");
		distinationMap.put(105,"Butedale, BC - Canada - 12200");
		distinationMap.put(4646,"BUTTE - United States - 3305");
		distinationMap.put(2815,"Butterworth - Malaysia - 55705");
		distinationMap.put(3060,"Butuan - Philippines - 56513");
		distinationMap.put(1958,"Butzfleth - Germany - 42880");
		distinationMap.put(2979,"Cabadbaran - Philippines - 56500");
		distinationMap.put(624,"Cabanas - Cuba - 23900");
		distinationMap.put(1105,"Cabedelo - Brazil - 35127");
		distinationMap.put(901,"Cabimas - Venezuela - 30700");
		distinationMap.put(3875,"Cabinda - Angola - 76231");
		distinationMap.put(625,"Cabo Cruz - Cuba - 23900");
		distinationMap.put(469,"Cabo Gracias a Dios - Nicaragua - 21900");
		distinationMap.put(765,"Cabo Rojo - Dominican Republic - 24727");
		distinationMap.put(379,"Cabo San Lucas - Mexico - 20144");
		distinationMap.put(190,"Cacouna, QUE - Canada - 13410");
		distinationMap.put(2980,"Cadiz - Philippines - 56500");
		distinationMap.put(2093,"Cadiz - Spain - 47035");
		distinationMap.put(1884,"Caen - France - 42711");
		distinationMap.put(3062,"Cagayan de Oro - Philippines - 56514");
		distinationMap.put(2239,"Cagliari - Italy - 47563");
		distinationMap.put(4981,"CAI MEP - VIETNAM - 55200");
		distinationMap.put(626,"Caibarien - Cuba - 23900");
		distinationMap.put(671,"Caimanera - Cuba - 23941");
		distinationMap.put(3452,"Cairns - Australia - 60200");
		distinationMap.put(3839,"Calabar - Nigeria - 75330");
		distinationMap.put(1885,"Calais - France - 42713");
		distinationMap.put(4833,"CALAIS - United States - 0115");
		distinationMap.put(2362,"Calamata - Greece - 48421");
		distinationMap.put(2981,"Calapan - Philippines - 56500");
		distinationMap.put(2714,"Calcutta - India - 53353");
		distinationMap.put(1072,"Caldera - Chile - 33708");
		distinationMap.put(499,"Caldera - Costa Rica - 22361");
		distinationMap.put(767,"Caldera Bay - Dominican Republic - 24731");
		distinationMap.put(1073,"Caleta Barquito - Chile - 33716");
		distinationMap.put(1047,"Caleta Buena - Chile - 33700");
		distinationMap.put(1205,"Caleta Cordova - Argentina - 35703");
		distinationMap.put(1206,"Caleta Olivares - Argentina - 35703");
		distinationMap.put(1207,"Caleta Olivia - Argentina - 35703");
		distinationMap.put(1081,"Caleta Patillos - Chile - 33765");
		distinationMap.put(4525,"CALEXICO - United States - 2503");
		distinationMap.put(4529,"CALEXICO-EAST - United States - 2507");
		distinationMap.put(389,"Calica - Mexico - 20161");
		distinationMap.put(2682,"Calicut - India - 53300");
		distinationMap.put(1031,"Callao - Peru - 33303");
		distinationMap.put(2792,"Cam Pha - Vietnam - 55205");
		distinationMap.put(2795,"Cam Rahn Bay - Vietnam - 55207");
		distinationMap.put(2796,"Cam Ranh Bay - Vietnam - 55207");
		distinationMap.put(4192,"Cambodia - Cambodia - 5550");
		distinationMap.put(4439,"CAMBRIDGE - United States - 1302");
		distinationMap.put(4431,"CAMDEN - United States - 1107");
		distinationMap.put(4243,"Cameroon - Cameroon - 7420");
		distinationMap.put(1163,"Camocim - Brazil - 35198");
		distinationMap.put(1210,"Campana - Argentina - 35711");
		distinationMap.put(125,"Campbell River, BC - Canada - 12207");
		distinationMap.put(199,"Campbellton, NB - Canada - 13444");
		distinationMap.put(385,"Campeche - Mexico - 20155");
		distinationMap.put(200,"Campobello, NB - Canada - 13445");
		distinationMap.put(4064,"Canada - Canada - 1220");
		distinationMap.put(2485,"Canak - Turkey - 48999");
		distinationMap.put(2484,"Canakkale - Turkey - 48999");
		distinationMap.put(390,"Cancun - Mexico - 20162");
		distinationMap.put(2315,"Canea - Greece - 48400");
		distinationMap.put(1909,"Cannes - France - 42775");
		distinationMap.put(2216,"Canneto - Italy - 47541");
		distinationMap.put(1652,"Canvey - United Kingdom - 41398");
		distinationMap.put(1653,"Canvey Island - United Kingdom - 41398");
		distinationMap.put(3781,"Cap  Limboh - Cameroon - 74298");
		distinationMap.put(3974,"Cap Diego - Madagascar - 78800");
		distinationMap.put(740,"Cap Haitien - Haiti - 24513");
		distinationMap.put(3782,"Cap Limboah - Cameroon - 74298");
		distinationMap.put(3861,"Cap Lopez - Gabon - 75505");
		distinationMap.put(133,"Cape Beale, BC - Canada - 12213");
		distinationMap.put(3813,"Cape Coast - Ghana - 74900");
		distinationMap.put(627,"Cape Cruz - Cuba - 23900");
		distinationMap.put(2069,"Cape Finisterre - Spain - 47000");
		distinationMap.put(3862,"Cape Lopez - Gabon - 75505");
		distinationMap.put(3911,"Cape Palmas - Liberia - 76500");
		distinationMap.put(4009,"Cape Town - South Africa - 79101");
		distinationMap.put(4263,"Cape Verde - Cape Verde - 7643");
		distinationMap.put(4869,"CAPE VINCENT - United States - 0706");
		distinationMap.put(1789,"Capelle - Netherlands - 42100");
		distinationMap.put(1790,"Capelle aan den Ijssel - Netherlands - 42100");
		distinationMap.put(4544,"CAPITAN - United States - 2715");
		distinationMap.put(936,"Caracas - Venezuela - 30745");
		distinationMap.put(840,"Caracas Baai - Neth Antilles - 27725");
		distinationMap.put(841,"Caracas Bay - Neth Antilles - 27725");
		distinationMap.put(289,"Carbonear, NFLD - Canada - 15206");
		distinationMap.put(2106,"Carboneras - Spain - 47062");
		distinationMap.put(4680,"CARBURY - United States - 3421");
		distinationMap.put(628,"Cardenas - Cuba - 23900");
		distinationMap.put(1702,"Cardiff - United Kingdom - 41487");
		distinationMap.put(18,"Cardinal, ONT - Canada - 01705");
		distinationMap.put(954,"Caripito - Venezuela - 30772");
		distinationMap.put(1262,"Carlskrona - Sweden - 40100");
		distinationMap.put(386,"Carmen - Mexico - 20157");
		distinationMap.put(1915,"Caronte - France - 42784");
		distinationMap.put(4571,"CARQUINEZ STRAIT - United States - 2830");
		distinationMap.put(1048,"Carrizal Bajo - Chile - 33700");
		distinationMap.put(880,"Cartagena - Colombia - 30107");
		distinationMap.put(2107,"Cartagena - Spain - 47063");
		distinationMap.put(4909,"Carteret - United States - 1001");
		distinationMap.put(924,"Carupano - Venezuela - 30721");
		distinationMap.put(3646,"Casablanca - Morocco - 71401");
		distinationMap.put(629,"Casilda - Cuba - 23900");
		distinationMap.put(1004,"Casma - Peru - 33300");
		distinationMap.put(2982,"Castanas - Philippines - 56500");
		distinationMap.put(616,"Castaway Cay - Bahamas - 23684");
		distinationMap.put(2229,"Castellamare del Golfo - Italy - 47558");
		distinationMap.put(2186,"Castellammare di Stabia - Italy - 47500");
		distinationMap.put(2113,"Castellon - Spain - 47068");
		distinationMap.put(2114,"Castellon de la Plana - Spain - 47068");
		distinationMap.put(1761,"Castletown - Ireland - 41900");
		distinationMap.put(799,"Castries - St. Lucia - 24865");
		distinationMap.put(577,"Cat Cay - Bahamas - 23620");
		distinationMap.put(606,"Cat Island - Bahamas - 23660");
		distinationMap.put(2983,"Catabangan - Philippines - 56500");
		distinationMap.put(2316,"Catacolon - Greece - 48400");
		distinationMap.put(2222,"Catania - Italy - 47548");
		distinationMap.put(2984,"Catanuan - Philippines - 56500");
		distinationMap.put(764,"Caucedo - Dominican Republic - 24722");
		distinationMap.put(2366,"Cavala - Greece - 48427");
		distinationMap.put(977,"Cayenne - French Guiana - 31700");
		distinationMap.put(724,"Cayman Brac - Cayman Isl - 24415");
		distinationMap.put(4079,"Cayman Islands - Cayman Islands - 2440");
		distinationMap.put(380,"Cayo Arcas - Mexico - 20152");
		distinationMap.put(381,"Cayo Arcos Terminal - Mexico - 20152");
		distinationMap.put(630,"Cayo Santa Maria - Cuba - 23900");
		distinationMap.put(26,"Cayuga, ONT - Canada - 02641");
		distinationMap.put(1106,"Ceara - Brazil - 35133");
		distinationMap.put(3063,"Cebu - Philippines - 56520");
		distinationMap.put(631,"Ceiba Hueca - Cuba - 23900");
		distinationMap.put(4254,"Central African Republic - Central African Republic - 7540");
		distinationMap.put(327,"Cerralvo Island - Mexico - 20100");
		distinationMap.put(1005,"Cerro Azul - Peru - 33300");
		distinationMap.put(358,"Cerros Island - Mexico - 20104");
		distinationMap.put(2137,"Ceuta - Spain - 47096");
		distinationMap.put(2450,"Ceyhan Terminal - Turkey - 48931");
		distinationMap.put(1049,"Chacabuco - Chile - 33700");
		distinationMap.put(4256,"Chad - Chad - 7560");
		distinationMap.put(813,"Chaguaramas - Trinidad - 27400");
		distinationMap.put(2540,"Chah Bahar - Iran - 50700");
		distinationMap.put(1006,"Chala - Peru - 33300");
		distinationMap.put(2317,"Chalkis - Greece - 48400");
		distinationMap.put(2744,"Chalna - Bangladesh - 53820");
		distinationMap.put(435,"Champerico - Guatemala - 20599");
		distinationMap.put(4871,"CHAMPLAIN-ROUSES POINT - United States - 0712");
		distinationMap.put(410,"Champoton - Mexico - 20195");
		distinationMap.put(2486,"Chanak - Turkey - 48999");
		distinationMap.put(2487,"Chanaq - Turkey - 48999");
		distinationMap.put(1074,"Chanaral - Chile - 33716");
		distinationMap.put(1019,"Chancay - Peru - 33300");
		distinationMap.put(201,"Chance Harbor, NB - Canada - 13445");
		distinationMap.put(214,"Chandler, QUE - Canada - 13466");
		distinationMap.put(3097,"Chang Sha - China - 57000");
		distinationMap.put(3206,"Changhang - South Korea - 58000");
		distinationMap.put(632,"Chaparra - Cuba - 23900");
		distinationMap.put(540,"Charco Azul - Panama - 22587");
		distinationMap.put(4447,"CHARLESTON - United States - 1409");
		distinationMap.put(794,"Charlestown, Nevis Is. - St. Kitts Nevis - 24837");
		distinationMap.put(4454,"CHARLOTTE - United States - 1512");
		distinationMap.put(4027,"Charlotte Amalie, St. Th - US Virgin Is - 91155");
		distinationMap.put(4787,"CHARLOTTE AMALIE,VIRGIN ISLANDS - United States - 5101");
		distinationMap.put(278,"Charlottetown, PEI - Canada - 14471");
		distinationMap.put(1654,"Chatham - United Kingdom - 41398");
		distinationMap.put(213,"Chatham, NB - Canada - 13460");
		distinationMap.put(4490,"CHATTANOOGA - United States - 2008");
		distinationMap.put(3167,"Chefoo - China - 57055");
		distinationMap.put(3207,"Cheju - South Korea - 58000");
		distinationMap.put(4413,"Chelyabinsk - RUSSIA - 44911");
		distinationMap.put(4396,"Chelyabinsk - RUSSIA - 45101");
		distinationMap.put(140,"Chemainus, BC - Canada - 12229");
		distinationMap.put(3098,"Chen Chiang - China - 57000");
		distinationMap.put(3211,"Chen Hai - South Korea - 58015");
		distinationMap.put(3121,"Chen Huang Tao - China - 57009");
		distinationMap.put(3099,"Cheng Ling Chi - China - 57000");
		distinationMap.put(3100,"Chenglin - China - 57000");
		distinationMap.put(3101,"Chenglingji - China - 57000");
		distinationMap.put(2716,"Chennai - India - 53357");
		distinationMap.put(1886,"Cherbourg - France - 42715");
		distinationMap.put(3658,"Cherchell - Algeria - 72100");
		distinationMap.put(2898,"Cheribon - Indonesia - 56035");
		distinationMap.put(4986,"Chernomorsk - Ukraine - 46279");
		distinationMap.put(588,"Cherokee Sound - Bahamas - 23640");
		distinationMap.put(4426,"CHESTER - United States - 1102");
		distinationMap.put(397,"Chetumal - Mexico - 20174");
		distinationMap.put(3239,"Chi Lung - China Taiwan - 58301");
		distinationMap.put(3320,"Chiba - Japan - 58818");
		distinationMap.put(3321,"Chibako - Japan - 58818");
		distinationMap.put(4722,"CHICAGO - United States - 3901");
		distinationMap.put(1007,"Chicama - Peru - 33300");
		distinationMap.put(902,"Chichiriviche - Venezuela - 30700");
		distinationMap.put(1008,"Chiclayo - Peru - 33300");
		distinationMap.put(216,"Chicoutimi, QUE - Canada - 13473");
		distinationMap.put(1009,"Chilca - Peru - 33300");
		distinationMap.put(4105,"Chile - Chile - 3370");
		distinationMap.put(3240,"Chilung - China Taiwan - 58301");
		distinationMap.put(545,"Chiman - Panama - 22599");
		distinationMap.put(1010,"Chimbote - Peru - 33300");
		distinationMap.put(4342,"CHIMKENT - KAZ - 44911");
		distinationMap.put(4400,"Chimkent - KAZAKHSTAN - 45101");
		distinationMap.put(4409,"Chimkent - KAZAKHSTAN - 57047");
		distinationMap.put(3122,"Chin Wang Tao - China - 57009");
		distinationMap.put(3123,"Chin Wangtao - China - 57009");
		distinationMap.put(4202,"China - China - 5700");
		distinationMap.put(1011,"Chincha Islands - Peru - 33300");
		distinationMap.put(3962,"Chinde - Mozambique - 78700");
		distinationMap.put(3102,"Ching Kiang - China - 57000");
		distinationMap.put(3156,"Ching Tao - China - 57047");
		distinationMap.put(3212,"Chinhae - South Korea - 58015");
		distinationMap.put(3103,"Chinkiang - China - 57000");
		distinationMap.put(3201,"Chinnanpo - North Korea - 57900");
		distinationMap.put(2251,"Chioggia - Italy - 47581");
		distinationMap.put(2385,"Chios - Greece - 48455");
		distinationMap.put(522,"Chiriqui Grande Terminal - Panama - 22520");
		distinationMap.put(3930,"Chisimaio - Somalia - 77099");
		distinationMap.put(2746,"Chittagong - Bangladesh - 53827");
		distinationMap.put(3171,"Chiwan - China - 57067");
		distinationMap.put(3536,"Christchurch - New Zealand - 61405");
		distinationMap.put(4019,"Christiansted, St. Croix - US Virgin Is - 91115");
		distinationMap.put(4790,"CHRISTIANSTED,VIRGIN ISLANDS - United States - 5104");
		distinationMap.put(4212,"Christmas Island - Christmas Island - 6024");
		distinationMap.put(3579,"Christmas Island - Kiribati - 62225");
		distinationMap.put(594,"Chub Cay - Bahamas - 23641");
		distinationMap.put(2760,"Chuk Samet - Thailand - 54900");
		distinationMap.put(252,"Churchill, MAN - Canada - 14001");
		distinationMap.put(3611,"Chuuk - Micronesia - 68205");
		distinationMap.put(633,"Cienfuegos - Cuba - 23900");
		distinationMap.put(2921,"Cigading - Indonesia - 56056");
		distinationMap.put(2901,"Cilacap - Indonesia - 56036");
		distinationMap.put(2070,"Cillero - Spain - 47000");
		distinationMap.put(4733,"CINCINNATI-LAWRENCEBURG - United States - 4102");
		distinationMap.put(2903,"Cinta Terminal - Indonesia - 56037");
		distinationMap.put(2899,"Cirebon - Indonesia - 56035");
		distinationMap.put(925,"Ciudad Bolivar - Venezuela - 30725");
		distinationMap.put(411,"Ciudad Camargo - Mexico - 20195");
		distinationMap.put(412,"Ciudad Chetumal - Mexico - 20195");
		distinationMap.put(387,"Ciudad de Carmen - Mexico - 20157");
		distinationMap.put(769,"Ciudad Trujillo - Dominican Republic - 24737");
		distinationMap.put(2203,"Civitavecchia - Italy - 47519");
		distinationMap.put(3867,"Clarence Bay, Ascension Is - St. Helena - 75898");
		distinationMap.put(3495,"Clarence River - Australia - 60281");
		distinationMap.put(583,"Clarence Town - Bahamas - 23635");
		distinationMap.put(301,"Clarenville, NFLD - Canada - 15224");
		distinationMap.put(328,"Clarion Island - Mexico - 20100");
		distinationMap.put(218,"Clarke City, QUE - Canada - 13476");
		distinationMap.put(203,"Clarke Harbour, NS - Canada - 13451");
		distinationMap.put(204,"Clarke&#39;s Harbour, NS - Canada - 13451");
		distinationMap.put(2,"Clarkson, ONT - Canada - 01527");
		distinationMap.put(2985,"Claveria - Philippines - 56500");
		distinationMap.put(4872,"CLAYTON - United States - 0714");
		distinationMap.put(4732,"CLEVELAND - United States - 4101");
		distinationMap.put(612,"Clifton Pier - Bahamas - 23675");
		distinationMap.put(613,"Clifton Point - Bahamas - 23675");
		distinationMap.put(3603,"Clipperton Island - French Polyn - 64195");
		distinationMap.put(1717,"Clyde - United Kingdom - 41615");
		distinationMap.put(391,"Coatzacoalcos - Mexico - 20171");
		distinationMap.put(1773,"Cobh - Ireland - 41905");
		distinationMap.put(2724,"Cocanada - India - 53398");
		distinationMap.put(2705,"Cochin - India - 53333");
		distinationMap.put(716,"Cockburn harbor - Turks Is - 24310");
		distinationMap.put(589,"Coco Cay - Bahamas - 23640");
		distinationMap.put(508,"Coco Islands - Costa Rica - 22399");
		distinationMap.put(518,"Coco Solo - Panama - 22517");
		distinationMap.put(4211,"Cocos (Keeling) Island - Cocos (Keeling) Island - 6023");
		distinationMap.put(3764,"Cogo - Equatorial Gui - 73800");
		distinationMap.put(302,"Coley&#39;s Point, NFLD - Canada - 15226");
		distinationMap.put(3659,"Collo - Algeria - 72100");
		distinationMap.put(4097,"Colombia - Colombia - 3010");
		distinationMap.put(2751,"Colombo - Sri Lanka - 54201");
		distinationMap.put(2752,"Colombo Harbor - Sri Lanka - 54201");
		distinationMap.put(520,"Colon - Panama - 22519");
		distinationMap.put(904,"Coloncha - Venezuela - 30700");
		distinationMap.put(1183,"Colonia - Uruguay - 35500");
		distinationMap.put(494,"Colorado Bar - Costa Rica - 22301");
		distinationMap.put(4458,"COLUMBIA - United States - 1604");
		distinationMap.put(4519,"COLUMBUS - United States - 2406");
		distinationMap.put(221,"Comeau Bay, QUE - Canada - 13481");
		distinationMap.put(303,"Come-by-Chance, NFLD - Canada - 15229");
		distinationMap.put(2180,"Comino Island - Malta - 47300");
		distinationMap.put(1203,"Comodoro Rivadavia - Argentina - 35702");
		distinationMap.put(4282,"Comoros - Comoros - 7890");
		distinationMap.put(3793,"Conakri - Guinea - 74619");
		distinationMap.put(3794,"Conakry - Guinea - 74619");
		distinationMap.put(1192,"Concepcion del Uruguay - Argentina - 35700");
		distinationMap.put(299,"Conception Bay, NFLD - Canada - 15220");
		distinationMap.put(1032,"Conchan - Peru - 33305");
		distinationMap.put(4261,"Congo (Brazzaville) - Congo (Brazzaville) - 7630");
		distinationMap.put(4266,"Congo (Kinshasa) - Congo (Kinshasa) - 7660");
		distinationMap.put(4739,"CONNEAUT - United States - 4109");
		distinationMap.put(2421,"Constanta - Romania - 48511");
		distinationMap.put(2470,"Constantinople - Turkey - 48945");
		distinationMap.put(2422,"Constantza - Romania - 48511");
		distinationMap.put(4304,"CONSTANZA - ROMANIA - 48500");
		distinationMap.put(222,"Contrecoeur, QUE - Canada - 13482");
		distinationMap.put(4216,"Cook Islands - Cook Islands - 6142");
		distinationMap.put(4582,"COOS BAY - United States - 2903");
		distinationMap.put(1564,"Copenhagen - Denmark - 40948");
		distinationMap.put(1075,"Coquimbo - Chile - 33721");
		distinationMap.put(4789,"CORAL BAY,VIRGIN ISLANDS - United States - 5103");
		distinationMap.put(2071,"Corcubion - Spain - 47000");
		distinationMap.put(2386,"Corfu - Greece - 48456");
		distinationMap.put(2356,"Corinth - Greece - 48410");
		distinationMap.put(486,"Corinto - Nicaragua - 21951");
		distinationMap.put(1774,"Cork - Ireland - 41905");
		distinationMap.put(470,"Corn Islands - Nicaragua - 21900");
		distinationMap.put(305,"Corner Brook, NFLD - Canada - 15231");
		distinationMap.put(19,"Cornwall, ONT - Canada - 01784");
		distinationMap.put(946,"Coro - Venezuela - 30765");
		distinationMap.put(2986,"Coron - Philippines - 56500");
		distinationMap.put(1050,"Coronel - Chile - 33700");
		distinationMap.put(4807,"CORPUS CHRISTI - United States - 5312");
		distinationMap.put(1051,"Corral - Chile - 33700");
		distinationMap.put(1925,"Corsica - France - 42796");
		distinationMap.put(2083,"Corunna - Spain - 47021");
		distinationMap.put(43,"Corunna, ONT - Canada - 05517");
		distinationMap.put(1625,"Coryton - United Kingdom - 41352");
		distinationMap.put(329,"Costa Maya - Mexico - 20100");
		distinationMap.put(4072,"Costa Rica - Costa Rica - 2230");
		distinationMap.put(2987,"Cotabato - Philippines - 56500");
		distinationMap.put(3873,"Cotonou - Benin - 76101");
		distinationMap.put(4751,"COURIER HUB AIRBORNE EXPRESS,WILMINGTON - United States - 4191");
		distinationMap.put(40,"Courtright, ONT - Canada - 05515");
		distinationMap.put(881,"Covenas - Colombia - 30110");
		distinationMap.put(141,"Cowichan Bay, BC - Canada - 12231");
		distinationMap.put(395,"Cozumel Island - Mexico - 20173");
		distinationMap.put(4687,"CRANE LAKE - United States - 3429");
		distinationMap.put(4441,"CRISFIELD - United States - 1304");
		distinationMap.put(519,"Cristobal - Panama - 22518");
		distinationMap.put(4156,"Croatia - Croatia - 4791");
		distinationMap.put(4564,"CROCKETT - United States - 2815");
		distinationMap.put(142,"Crofton, BC - Canada - 12234");
		distinationMap.put(2252,"Crotone - Italy - 47582");
		distinationMap.put(4030,"Cruz Bay, St. John I. - US Virgin Is - 91160");
		distinationMap.put(4788,"CRUZ BAY,VIRGIN ISLANDS - United States - 5102");
		distinationMap.put(1052,"Cruz Grande - Chile - 33700");
		distinationMap.put(4076,"Cuba - Cuba - 2390");
		distinationMap.put(2725,"Cuddalore - India - 53398");
		distinationMap.put(3891,"Cuio - Angola - 76299");
		distinationMap.put(800,"Cul de Sac - St. Lucia - 24866");
		distinationMap.put(330,"Culiacan - Mexico - 20100");
		distinationMap.put(950,"Cumana - Venezuela - 30769");
		distinationMap.put(947,"Cumarebo - Venezuela - 30766");
		distinationMap.put(446,"Cutuco - El Salvador - 21137");
		distinationMap.put(1952,"Cuxhaven - Germany - 42873");
		distinationMap.put(4166,"Cyprus - Cyprus - 4910");
		distinationMap.put(4128,"Czech Republic - Czech Republic - 4351");
		distinationMap.put(2790,"Da Nang - Vietnam - 55204");
		distinationMap.put(2959,"Dabo - Indonesia - 56099");
		distinationMap.put(3065,"Dadiangas - Philippines - 56522");
		distinationMap.put(3221,"Daesan - South Korea - 58030");
		distinationMap.put(1609,"Dagenham - United Kingdom - 41320");
		distinationMap.put(3136,"Dagu/Tanggu - China - 57017");
		distinationMap.put(2988,"Dahican - Philippines - 56500");
		distinationMap.put(2989,"Dahikan - Philippines - 56500");
		distinationMap.put(2990,"Dahikan Bay - Philippines - 56500");
		distinationMap.put(665,"Daiquiri Bay - Cuba - 23931");
		distinationMap.put(3160,"Dairen - China - 57051");
		distinationMap.put(3788,"Dakar - Senegal - 74473");
		distinationMap.put(3759,"Dakhla - Western Sahara - 73700");
		distinationMap.put(223,"Dalhousie, NB - Canada - 13484");
		distinationMap.put(4335,"Dalian - China - 57051");
		distinationMap.put(3161,"Dalian - China - 57051");
		distinationMap.put(4811,"DALLAS/FT. WORTH - United States - 5501");
		distinationMap.put(3465,"Dalrymple Bay - Australia - 60212");
		distinationMap.put(4625,"DALTON CACHE - United States - 3106");
		distinationMap.put(729,"Dame Marie - Haiti - 24500");
		distinationMap.put(4419,"DAMIETTA - EGYPT - 72912");
		distinationMap.put(3730,"Damietta - Egypt - 72912");
		distinationMap.put(2592,"Damman - Saudi Arabia - 51715");
		distinationMap.put(3470,"Dampier - Australia - 60218");
		distinationMap.put(443,"Dangriga - Belize - 20803");
		distinationMap.put(4602,"DANVILLE - United States - 3012");
		distinationMap.put(1988,"Danzig - Poland - 45511");
		distinationMap.put(3949,"Dar es Salaam - Tanzania - 78351");
		distinationMap.put(2460,"Darcia - Turkey - 48941");
		distinationMap.put(2461,"Darica - Turkey - 48941");
		distinationMap.put(546,"Darien - Panama - 22599");
		distinationMap.put(1655,"Dartmouth - United Kingdom - 41398");
		distinationMap.put(224,"Dartmouth, NS - Canada - 13485");
		distinationMap.put(3472,"Darwin - Australia - 60220");
		distinationMap.put(2635,"Das - United Arab Em - 52030");
		distinationMap.put(2636,"Das Island - United Arab Em - 52030");
		distinationMap.put(3066,"Davao - Philippines - 56523");
		distinationMap.put(4727,"DAVENPORT,IA-ROCK ISLAND/MOLINE - United States - 3908");
		distinationMap.put(547,"David - Panama - 22599");
		distinationMap.put(4884,"DAVISVILLE - United States - 0502");
		distinationMap.put(4735,"DAYTON - United States - 4104");
		distinationMap.put(4475,"DAYTONA BEACH AIRPORT - United States - 1884");
		distinationMap.put(182,"Deadmans Harbour, NB - Canada - 13400");
		distinationMap.put(1858,"Deauville - France - 42700");
		distinationMap.put(2318,"Dedeh Agatch - Greece - 48400");
		distinationMap.put(217,"Deer Island, NB - Canada - 13475");
		distinationMap.put(3830,"Degema - Nigeria - 75300");
		distinationMap.put(980,"Degrad des Cannes - French Guiana - 31707");
		distinationMap.put(4658,"DEL BONITA - United States - 3322");
		distinationMap.put(4508,"DEL RIO - United States - 2302");
		distinationMap.put(1807,"Delfzijl - Netherlands - 42116");
		distinationMap.put(1808,"Delfzyl - Netherlands - 42116");
		distinationMap.put(3660,"Dellys - Algeria - 72100");
		distinationMap.put(175,"Delta BC - Canada - 12496");
		distinationMap.put(960,"Demerara - Guyana - 31201");
		distinationMap.put(1791,"Den Helder - Netherlands - 42100");
		distinationMap.put(2146,"Denia - Spain - 47099");
		distinationMap.put(4117,"Denmark - Denmark - 4099");
		distinationMap.put(4648,"DENVER - United States - 3307");
		distinationMap.put(48,"Depot Harbor, ONT - Canada - 06695");
		distinationMap.put(4846,"DERBY LINE - United States - 0209");
		distinationMap.put(2462,"Derince - Turkey - 48942");
		distinationMap.put(2463,"Derince Burnu - Turkey - 48942");
		distinationMap.put(2464,"Derindje - Turkey - 48942");
		distinationMap.put(4726,"DES MOINES - United States - 3907");
		distinationMap.put(673,"Deseo - Cuba - 23941");
		distinationMap.put(4491,"DESTREHAN - United States - 2009");
		distinationMap.put(4715,"DETOUR - United States - 3819");
		distinationMap.put(4703,"DETROIT - United States - 3801");
		distinationMap.put(4709,"DETROIT METROPOLITAN AIRPORT - United States - 3807");
		distinationMap.put(3503,"Devonport - Australia - 60299");
		distinationMap.put(1656,"Devonport - United Kingdom - 41398");
		distinationMap.put(2594,"Dhahran - Saudi Arabia - 51717");
		distinationMap.put(4753,"DHL EXPRESS IN WILMINGTON - United States - 4194");
		distinationMap.put(4617,"DHL WORLDWIDE EXPRESS - United States - 3073");
		distinationMap.put(4770,"DHL,JAMAICA - United States - 4772");
		distinationMap.put(4549,"DHL,LOS ANGELES - United States - 2770");
		distinationMap.put(4800,"DHL,MIAMI FL - United States - 5271");
		distinationMap.put(4575,"DHL,SAN FRANCISCO - United States - 2870");
		distinationMap.put(2606,"Dhuba - Saudi Arabia - 51730");
		distinationMap.put(1193,"Diamante - Argentina - 35700");
		distinationMap.put(3948,"Diego Garcia - Brit Ind Ocean - 78101");
		distinationMap.put(3975,"Diego Suarez - Madagascar - 78800");
		distinationMap.put(1893,"Dieppe - France - 42736");
		distinationMap.put(191,"Digby, NS - Canada - 13420");
		distinationMap.put(2441,"Dikili - Turkey - 48905");
		distinationMap.put(1762,"Dingle - Ireland - 41900");
		distinationMap.put(2991,"Dipolog - Philippines - 56500");
		distinationMap.put(183,"Dipper Harbor, NB - Canada - 13400");
		distinationMap.put(2894,"Djakarta - Indonesia - 56033");
		distinationMap.put(2945,"Djambi - Indonesia - 56078");
		distinationMap.put(3898,"Djeno Terminal - Congo Brazzaville - 76345");
		distinationMap.put(4272,"Djibouti - Djibouti - 7770");
		distinationMap.put(3939,"Djibouti - Djibouti - 77701");
		distinationMap.put(3661,"Djidjelli - Algeria - 72100");
		distinationMap.put(1234,"Djupivogur - Iceland - 40000");
		distinationMap.put(2054,"Dnestrovskiy - Ukraine - 46277");
		distinationMap.put(2614,"Doha - Qatar - 51813");
		distinationMap.put(4087,"Dominica - Dominica - 2486");
		distinationMap.put(4081,"Dominican Republic - Dominican Republic - 2470");
		distinationMap.put(1263,"Domjou - Sweden - 40100");
		distinationMap.put(1264,"Domsjo - Sweden - 40100");
		distinationMap.put(1887,"Donges - France - 42723");
		distinationMap.put(3119,"Dongfeng - China - 57003");
		distinationMap.put(3170,"Dongguan - China - 57056");
		distinationMap.put(3209,"Donghae - South Korea - 58014");
		distinationMap.put(225,"Donnacona, QUE - Canada - 13493");
		distinationMap.put(2992,"Donsol - Philippines - 56500");
		distinationMap.put(1809,"Dordrecht - Netherlands - 42117");
		distinationMap.put(384,"Dos Bocas - Mexico - 20154");
		distinationMap.put(3776,"Douala - Cameroon - 74201");
		distinationMap.put(4530,"DOUGLAS - United States - 2601");
		distinationMap.put(1617,"Dover - United Kingdom - 41337");
		distinationMap.put(1417,"Drammen - Norway - 40321");
		distinationMap.put(2231,"Drepanon - Italy - 47558");
		distinationMap.put(1783,"Drogheda - Ireland - 41919");
		distinationMap.put(2632,"Dubai - United Arab Em - 52005");
		distinationMap.put(2633,"Dubayy - United Arab Em - 52005");
		distinationMap.put(1778,"Dublin - Ireland - 41911");
		distinationMap.put(2271,"Dubrovnik - Croatia - 47902");
		distinationMap.put(1859,"Duclair - France - 42700");
		distinationMap.put(2274,"Dugi Rat - Croatia - 47906");
		distinationMap.put(4692,"DULUTH - United States - 3601");
		distinationMap.put(3067,"Dumaguete - Philippines - 56525");
		distinationMap.put(2941,"Dumai - Indonesia - 56075");
		distinationMap.put(1708,"Dumbarton - United Kingdom - 41600");
		distinationMap.put(144,"Duncan Bay, BC - Canada - 12246");
		distinationMap.put(585,"Duncan Town - Bahamas - 23636");
		distinationMap.put(1786,"Dundalk - Ireland - 41921");
		distinationMap.put(106,"Dundas Island, BC - Canada - 12200");
		distinationMap.put(1725,"Dundee - United Kingdom - 41659");
		distinationMap.put(3538,"Dunedin - New Zealand - 61407");
		distinationMap.put(1888,"Dunkerque - France - 42727");
		distinationMap.put(1889,"Dunkirk - France - 42727");
		distinationMap.put(29,"Dunnville, ONT - Canada - 02645");
		distinationMap.put(4681,"DUNSEITH - United States - 3422");
		distinationMap.put(994,"Duran - Ecuador - 33131");
		distinationMap.put(2308,"Durazzo - Albania - 48109");
		distinationMap.put(4010,"Durban - South Africa - 79113");
		distinationMap.put(4451,"DURHAM - United States - 1503");
		distinationMap.put(2309,"Durres - Albania - 48109");
		distinationMap.put(4370,"Dushanbe - Tajikistan - 44911");
		distinationMap.put(4773,"DWORKIN/COSELL COURIER - United States - 4775");
		distinationMap.put(1265,"Dynas - Sweden - 40100");
		distinationMap.put(3996,"Dzaoudzi, Mayotte Is - Comoros - 78900");
		distinationMap.put(4662,"EAGLE COUNTY USER FEE AIRPORT - United States - 3385");
		distinationMap.put(4509,"EAGLE PASS - United States - 2303");
		distinationMap.put(300,"Earls Island, NLFD - Canada - 15223");
		distinationMap.put(4012,"East London - South Africa - 79125");
		distinationMap.put(4196,"East Timor - East Timor - 5601");
		distinationMap.put(3741,"East Zeit Terminal - Egypt - 72947");
		distinationMap.put(1053,"Easter Island - Chile - 33700");
		distinationMap.put(1586,"Eastham - United Kingdom - 41216");
		distinationMap.put(4643,"EASTPORT - United States - 3302");
		distinationMap.put(3605,"Ebeye - Marshall Is - 68190");
		distinationMap.put(3261,"Ebisu - Japan - 58800");
		distinationMap.put(4102,"Ecuador - Ecuador - 3310");
		distinationMap.put(1730,"Edinburg - United Kingdom - 41675");
		distinationMap.put(4515,"EDINBURG USER FEE AIRPORT, EDINBURG - United States - 2381");
		distinationMap.put(1731,"Edinburgh - United Kingdom - 41675");
		distinationMap.put(1815,"Eemshaven - Netherlands - 42132");
		distinationMap.put(1418,"Egersund - Norway - 40325");
		distinationMap.put(4238,"Egypt - Egypt - 7290");
		distinationMap.put(2569,"Eilat - Israel - 50871");
		distinationMap.put(2570,"Eilath - Israel - 50871");
		distinationMap.put(1953,"Einswarden - Germany - 42874");
		distinationMap.put(4311,"Ekaterinburg - Russia - 40549");
		distinationMap.put(3727,"El Alamein - Egypt - 72906");
		distinationMap.put(482,"El Bluff - Nicaragua - 21901");
		distinationMap.put(926,"El Chaure - Venezuela - 30735");
		distinationMap.put(413,"El Cuyo - Mexico - 20195");
		distinationMap.put(3723,"El Dekheila - Egypt - 72901");
		distinationMap.put(3669,"El Djazair - Algeria - 72101");
		distinationMap.put(2085,"El Ferrol - Spain - 47022");
		distinationMap.put(2086,"El Ferrol del Caudillo - Spain - 47022");
		distinationMap.put(2142,"El Grao - Spain - 47099");
		distinationMap.put(956,"El Guamache - Venezuela - 30774");
		distinationMap.put(3728,"El Hamra Oil Terminal - Egypt - 72906");
		distinationMap.put(3735,"El Ismailiya - Egypt - 72925");
		

		distinationMap.put(3638,"El Jadida - Morocco - 71400");
		distinationMap.put(3648,"El Jorf Lasfar - Morocco - 71415");
		distinationMap.put(4341,"El Khoms - Libya - 72500");
		distinationMap.put(927,"El Palito - Venezuela - 30737");
		distinationMap.put(4516,"EL PASO - United States - 2402");
		distinationMap.put(3750,"El Qoseir - Egypt - 72999");
		distinationMap.put(3751,"El Quseir - Egypt - 72999");
		distinationMap.put(548,"El Real - Panama - 22599");
		distinationMap.put(4069,"El Salvador - El Salvador - 2110");
		distinationMap.put(375,"El Sauzal - Mexico - 20142");
		distinationMap.put(4541,"EL SEGUNDO - United States - 2711");
		distinationMap.put(929,"El Tablazo - Venezuela - 30739");
		distinationMap.put(2571,"Elat - Israel - 50871");
		distinationMap.put(2368,"Elefsis - Greece - 48445");
		distinationMap.put(2369,"Eleusis - Greece - 48445");
		distinationMap.put(575,"Eleuthera Island - Bahamas - 23619");
		distinationMap.put(2370,"Elevsis - Greece - 48445");
		distinationMap.put(143,"Elk Falls, BC - Canada - 12237");
		distinationMap.put(1587,"Ellesmere - United Kingdom - 41227");
		distinationMap.put(3814,"Elmina - Ghana - 74900");
		distinationMap.put(1948,"Elsfleth - Germany - 42868");
		distinationMap.put(1513,"Elsinore - Denmark - 40900");
		distinationMap.put(1954,"Emden - Germany - 42875");
		distinationMap.put(4754,"EMERY WORLD WIDE COURIER,DAYTON - United States - 4195");
		distinationMap.put(4771,"EMERY WORLDWIDE - United States - 4773");
		distinationMap.put(3606,"Enewetak Atoll - Marshall Is - 68190");
		distinationMap.put(3607,"Enewotok - Marshall Is - 68190");
		distinationMap.put(290,"Englee Harbor, NFLD - Canada - 15207");
		distinationMap.put(4914,"ENGLEWOOD - United States - 1803");
		distinationMap.put(3578,"English Harbor - Kiribati - 62223");
		distinationMap.put(366,"Ensenada - Mexico - 20108");
		distinationMap.put(634,"Ensenada Santa Maria - Cuba - 23900");
		distinationMap.put(635,"Ensenda de Mora - Cuba - 23900");
		distinationMap.put(1537,"Enstead - Denmark - 40908");
		distinationMap.put(1534,"Ensteadvaerket - Denmark - 40908");
		distinationMap.put(1535,"Ensted - Denmark - 40908");
		distinationMap.put(1536,"Enstedvaerkets Havn - Denmark - 40908");
		distinationMap.put(3608,"Entwetak - Marshall Is - 68190");
		distinationMap.put(4241,"Equatorial Guinea - Equatorial Guinea - 7380");
		distinationMap.put(2465,"Eregli - Turkey - 48943");
		distinationMap.put(2466,"Eregli Anatolia - Turkey - 48943");
		distinationMap.put(4737,"ERIE - United States - 4106");
		distinationMap.put(1589,"Erith - United Kingdom - 41231");
		distinationMap.put(4270,"Eritrea - Eritrea - 7741");
		distinationMap.put(1829,"Ertvelde - Belgium - 42300");
		distinationMap.put(3712,"Es Sider - Libya - 72519");
		distinationMap.put(1550,"Esbjerg - Denmark - 40919");
		distinationMap.put(2108,"Escombreras - Spain - 47063");
		distinationMap.put(3840,"Escravos - Nigeria - 75345");
		distinationMap.put(3841,"Escravos Oil Terminal - Nigeria - 75345");
		distinationMap.put(1235,"Eskifjordhur - Iceland - 40000");
		distinationMap.put(1236,"Eskifjordur - Iceland - 40000");
		distinationMap.put(993,"Esmeraldas - Ecuador - 33121");
		distinationMap.put(3496,"Esperance - Australia - 60282");
		distinationMap.put(331,"Espiritu Santo - Mexico - 20100");
		distinationMap.put(107,"Esquimalt, BC - Canada - 12200");
		distinationMap.put(706,"Esquivel - Jamaica - 24163");
		distinationMap.put(3639,"Essaquira - Morocco - 71400");
		distinationMap.put(1266,"Essvik - Sweden - 40100");
		distinationMap.put(1267,"Essviken - Sweden - 40100");
		distinationMap.put(4133,"Estonia - Estonia - 4470");
		distinationMap.put(1908,"Etang de Berre - France - 42773");
		distinationMap.put(1012,"Eten - Peru - 33300");
		distinationMap.put(4271,"Ethiopia - Ethiopia - 7749");
		distinationMap.put(4556,"EUREKA - United States - 2802");
		distinationMap.put(1810,"Europoort - Netherlands - 42118");
		distinationMap.put(4596,"EVERETT - United States - 3006");
		distinationMap.put(967,"Everton - Guyana - 31268");
		distinationMap.put(578,"Exuma - Bahamas - 23621");
		distinationMap.put(1419,"Eydehamn - Norway - 40327");
		distinationMap.put(4518,"FABENS - United States - 2404");
		distinationMap.put(86,"Faeringehavn - Greenland - 10100");
		distinationMap.put(1372,"Fagerstrand - Norway - 40300");
		distinationMap.put(1268,"Fagervik - Sweden - 40100");
		distinationMap.put(2581,"Fahaheel - Kuwait - 51323");
		distinationMap.put(4627,"FAIRBANKS - United States - 3111");
		distinationMap.put(4741,"FAIRPORT - United States - 4111");
		distinationMap.put(4778,"FAJARDO - United States - 4904");
		distinationMap.put(1331,"Falkenberg - Sweden - 40121");
		distinationMap.put(4110,"Falkland Islands - Falkland Islands - 3720");
		distinationMap.put(4855,"FALL RIVER - United States - 0407");
		distinationMap.put(688,"Falmouth - Jamaica - 24100");
		distinationMap.put(1611,"Falmouth - United Kingdom - 41328");
		distinationMap.put(2504,"Famagusta - Cyprus - 49199");
		distinationMap.put(3752,"Fanara - Egypt - 72999");
		distinationMap.put(3154,"Fang Cheng - China - 57044");
		distinationMap.put(3155,"Fangcheng - China - 57044");
		distinationMap.put(2522,"Fao - Iraq - 50500");
		distinationMap.put(3976,"Farafangana - Madagascar - 78800");
		distinationMap.put(2152,"Faro - Portugal - 47100");
		distinationMap.put(4116,"Faroe Islands - Faroe Islands - 4091");
		distinationMap.put(1420,"Farsund - Norway - 40329");
		distinationMap.put(1709,"Faslane - United Kingdom - 41600");
		distinationMap.put(2637,"Fateh Terminal - United Arab Em - 52040");
		distinationMap.put(1612,"Fawley - United Kingdom - 41329");
		distinationMap.put(1860,"Fecamp - France - 42700");
		distinationMap.put(4768,"FEDERAL EXPRESS, JAMAICA - United States - 4770");
		distinationMap.put(4765,"FEDERAL EXPRESS, NEWARK - United States - 4671");
		distinationMap.put(4633,"FEDERAL EXPRESS,ANCHORAGE - United States - 3195");
		distinationMap.put(4756,"FEDERAL EXPRESS,INDIANAPOLIS - United States - 4198");
		distinationMap.put(4502,"FEDERAL EXPRESS,MEMPHIS - United States - 2095");
		distinationMap.put(4579,"FEDERAL EXPRESS,OAKLAND - United States - 2895");
		distinationMap.put(4126,"Federal Republic of Germany - Federal Republic of Germany - 4280");
		distinationMap.put(4229,"Fedrated States of Micronesia - Fedrated States of Micronesia - 6820");
		distinationMap.put(1610,"Felixstowe - United Kingdom - 41323");
		distinationMap.put(3977,"Fenerive - Madagascar - 78800");
		distinationMap.put(1763,"Fenit - Ireland - 41900");
		distinationMap.put(2057,"Feodosia - Ukraine - 46279");
		distinationMap.put(2058,"Feodosiya - Ukraine - 46279");
		distinationMap.put(4464,"FERNANDINA BEACH - United States - 1805");
		distinationMap.put(2087,"Ferrol - Spain - 47022");
		distinationMap.put(4603,"FERRY - United States - 3013");
		distinationMap.put(4719,"FERRYSBURG - United States - 3844");
		distinationMap.put(2431,"Fethiye - Turkey - 48900");
		distinationMap.put(2168,"Figueira da Foz - Portugal - 47135");
		distinationMap.put(4232,"Fiji - Fiji - 6863");
		distinationMap.put(2429,"Finike - Turkey - 48900");
		distinationMap.put(4115,"Finland - Finland - 4050");
		distinationMap.put(1741,"Finnart oil terminal - United Kingdom - 41698");
		distinationMap.put(3506,"Finsch Harbor - Papua New Guinea - 60400");
		distinationMap.put(1742,"Firth of Forth - United Kingdom - 41698");
		distinationMap.put(62,"Fisher Harbour, ONT - Canada - 08528");
		distinationMap.put(2284,"Fiume - Croatia - 47923");
		distinationMap.put(2187,"Fiumicino - Italy - 47500");
		distinationMap.put(1602,"Fleetwood - United Kingdom - 41299");
		distinationMap.put(1940,"Flensburg - Germany - 42800");
		distinationMap.put(1430,"Floro - Norway - 40340");
		distinationMap.put(1733,"Flotta - United Kingdom - 41680");
		distinationMap.put(1823,"Flushing - Netherlands - 42185");
		distinationMap.put(730,"Fond la Grange - Haiti - 24500");
		distinationMap.put(3131,"Foochou - China - 57015");
		distinationMap.put(3132,"Foochow - China - 57015");
		distinationMap.put(3842,"Forcados - Nigeria - 75349");
		distinationMap.put(3843,"Forcados Terminal - Nigeria - 75349");
		distinationMap.put(834,"Fort Baii - Neth Antilles - 27705");
		distinationMap.put(835,"Fort Bay - Neth Antilles - 27705");
		distinationMap.put(864,"Fort de France - Martinique - 28351");
		distinationMap.put(4827,"FORT FAIRFIELD - United States - 0107");
		distinationMap.put(66,"Fort Frances, ONT - Canada - 09000");
		distinationMap.put(4830,"FORT KENT - United States - 0110");
		distinationMap.put(4887,"FORT LAUDE - United States - 5555");
		distinationMap.put(741,"Fort Liberte - Haiti - 24514");
		distinationMap.put(4473,"FORT MYERS AIRPORT - United States - 1822");
		distinationMap.put(4796,"FORT PIERCE - United States - 5205");
		distinationMap.put(4749,"FORT WAYNE AIRPORT - United States - 4183");
		distinationMap.put(1711,"Fort William - United Kingdom - 41600");
		distinationMap.put(75,"Fort Williams, ONT - Canada - 09662");
		distinationMap.put(1107,"Fortaleza - Brazil - 35133");
		distinationMap.put(4677,"FORTUNA - United States - 3417");
		distinationMap.put(291,"Fortune, NL - Canada - 15208");
		distinationMap.put(1910,"Fos - France - 42776");
		distinationMap.put(1911,"FOS Sur Mer - France - 42776");
		distinationMap.put(1613,"Fowey - United Kingdom - 41332");
		distinationMap.put(184,"Fox River, QUE - Canada - 13400");
		distinationMap.put(1779,"Foynes - Ireland - 41913");
		distinationMap.put(4125,"France - France - 4279");
		distinationMap.put(1269,"Frano - Sweden - 40100");
		distinationMap.put(145,"Fraser River, BC - Canada - 12261");
		distinationMap.put(1743,"Fraserburgh - United Kingdom - 41698");
		distinationMap.put(1184,"Fray Bentos - Uruguay - 35500");
		distinationMap.put(1551,"Fredericia - Denmark - 40921");
		distinationMap.put(87,"Frederikshaab - Greenland - 10100");
		distinationMap.put(1538,"Frederikshavn - Denmark - 40909");
		distinationMap.put(1422,"Frederikstad - Norway - 40334");
		distinationMap.put(4023,"Frederiksted, St. Croix - US Virgin Is - 91145");
		distinationMap.put(4791,"FREDERIKSTED,VIRGIN ISLANDS - United States - 5105");
		distinationMap.put(1475,"Fredrikshamn - Finland - 40520");
		distinationMap.put(1423,"Fredrikstad - Norway - 40334");
		distinationMap.put(4806,"FREEPORT - United States - 5311");
		distinationMap.put(598,"Freeport, Grand Bahama I - Bahamas - 23645");
		distinationMap.put(568,"Freeport, Ireland Island - Bermuda - 23299");
		distinationMap.put(3798,"Freetown - Sierra Leone - 74751");
		distinationMap.put(3473,"Fremantle - Australia - 60222");
		distinationMap.put(4101,"French Guiana - French Guiana - 3170");
		distinationMap.put(4227,"French Polynesia - French Polynesia - 6414");
		distinationMap.put(4284,"French Southern and Antarctic Lands - French Southern and Antarctic Lands - 7905");
		distinationMap.put(571,"Fresh Creek - Bahamas - 23600");
		distinationMap.put(4557,"FRESNO - United States - 2803");
		distinationMap.put(4604,"FRIDAY HARBOR - United States - 3014");
		distinationMap.put(318,"Frobisher Bay, NL - Canada - 15298");
		distinationMap.put(4448,"FRONT ROYAL - United States - 1410");
		distinationMap.put(383,"Frontera - Mexico - 20153");
		distinationMap.put(4610,"FRONTIER - United States - 3020");
		distinationMap.put(4798,"FT. LAUDERDALE/HOLLYWOOD INTERNATIONAL AIRPORT - United States - 5210");
		distinationMap.put(3133,"Fuchou - China - 57015");
		distinationMap.put(1571,"Fuglefjord - Faroe - 40985");
		distinationMap.put(2645,"Fujairah - United Arab Em - 52077");
		distinationMap.put(2646,"Fujaireh - United Arab Em - 52077");
		distinationMap.put(3301,"Fukuyama - Japan - 58803");
		distinationMap.put(3325,"Funabashi - Japan - 58821");
		distinationMap.put(3581,"Funafuti Atoll - Tuvalu - 62231");
		distinationMap.put(3395,"Funagawa - Japan - 58868");
		distinationMap.put(3396,"Funakawa - Japan - 58868");
		distinationMap.put(3397,"Funakawa Ko - Japan - 58868");
		distinationMap.put(2157,"Funchal - Portugal - 47101");
		distinationMap.put(1572,"Funglafjordur - Faroe - 40985");
		distinationMap.put(4978,"FUQING - CHINA - ****");
		distinationMap.put(4980,"FUQING, FUJIAN - CHINA - 57011");
		distinationMap.put(1272,"Furogrund - Sweden - 40100");
		distinationMap.put(1273,"Furuogrund - Sweden - 40100");
		distinationMap.put(3329,"Fushiki - Japan - 58824");
		distinationMap.put(3328,"Fushiki Toyama - Japan - 58824");
		distinationMap.put(3134,"Fuzhou - China - 57015");
		distinationMap.put(4979,"Fuzhou - China - 57015");
		distinationMap.put(3694,"Gabes - Tunisia - 72305");
		distinationMap.put(4255,"Gabon - Gabon - 7550");
		distinationMap.put(1320,"Gaddvik - Sweden - 40115");
		distinationMap.put(2204,"Gaeta - Italy - 47525");
		distinationMap.put(1321,"Gafle - Sweden - 40116");
		distinationMap.put(982,"Galapagos Islands - Ecuador - 33100");
		distinationMap.put(2417,"Galati - Romania - 48500");
		distinationMap.put(2418,"Galatz - Romania - 48500");
		distinationMap.put(816,"Galeota Point - Trinidad - 27410");
		distinationMap.put(867,"Galion - Martinique - 28399");
		distinationMap.put(846,"Galisbay - Neth Antilles - 27727");
		distinationMap.put(2748,"Galle - Sri Lanka - 54200");
		distinationMap.put(2749,"Galle Harbor - Sri Lanka - 54200");
		distinationMap.put(868,"Gallion Bay - Martinique - 28399");
		distinationMap.put(2488,"Gallipoli - Turkey - 48999");
		distinationMap.put(4805,"GALVESTON - United States - 5310");
		distinationMap.put(1764,"Galway - Ireland - 41900");
		distinationMap.put(3422,"Gamagori - Japan - 58883");
		distinationMap.put(3859,"Gamba - Gabon - 75503");
		distinationMap.put(4250,"Gambia - Gambia - 7500");
		distinationMap.put(513,"Gamboa - Panama - 22500");
		distinationMap.put(1456,"Gamlakarleby - Finland - 40500");
		distinationMap.put(1849,"Gand - Belgium - 42331");
		distinationMap.put(2133,"Gandia - Spain - 47093");
		distinationMap.put(172,"Ganges, BC - Canada - 12494");
		distinationMap.put(1712,"Gare Lock - United Kingdom - 41600");
		distinationMap.put(1713,"Gareloch - United Kingdom - 41600");
		distinationMap.put(1714,"Garelochhead - United Kingdom - 41600");
		distinationMap.put(4896,"GARNERVILL - United States - 1092");
		distinationMap.put(3780,"Garoua - Cameroon - 74297");
		distinationMap.put(2143,"Garrucha - Spain - 47099");
		distinationMap.put(1603,"Garston - United Kingdom - 41299");
		distinationMap.put(4725,"GARY - United States - 3905");
		distinationMap.put(2993,"Gasan - Philippines - 56500");
		distinationMap.put(226,"Gaspe, QUE - Canada - 13819");
		distinationMap.put(4550,"GATEWAY FREIGHT SERVICES, LAX - United States - 2772");
		distinationMap.put(1054,"Gatico - Chile - 33700");
		distinationMap.put(514,"Gatun - Panama - 22500");
		distinationMap.put(1322,"Gavle - Sweden - 40116");
		distinationMap.put(4172,"Gaza Strip Administered by Israel - Gaza Strip Administered by Israel - 5082");
		distinationMap.put(2558,"Gazireh Ye Lavan - Iran - 50769");
		distinationMap.put(1989,"Gdansk - Poland - 45511");
		distinationMap.put(1985,"Gdynia - Poland - 45505");
		distinationMap.put(2468,"Gebze - Turkey - 48944");
		distinationMap.put(3475,"Geelong - Australia - 60225");
		distinationMap.put(1323,"Gefle - Sweden - 40116");
		distinationMap.put(3753,"Geisum Terminal - Egypt - 72999");
		distinationMap.put(2219,"Gela - Italy - 47543");
		distinationMap.put(2489,"Gelibolu - Turkey - 48999");
		distinationMap.put(2474,"Gemlik - Turkey - 48947");
		distinationMap.put(2994,"General MacArthur - Philippines - 56500");
		distinationMap.put(1040,"General San Martin - Peru - 33373");
		distinationMap.put(4333,"GENEVA - Switzerland - 4419");
		distinationMap.put(2205,"Genoa - Italy - 47527");
		distinationMap.put(2206,"Genova - Italy - 47527");
		distinationMap.put(1850,"Gent - Belgium - 42331");
		distinationMap.put(722,"Georgetown - Cayman Isl - 24410");
		distinationMap.put(961,"Georgetown - Guyana - 31201");
		distinationMap.put(4456,"GEORGETOWN - United States - 1602");
		distinationMap.put(3868,"Georgetown, Ascension Is - St. Helena - 75898");
		distinationMap.put(4142,"Georgia - Georgia - 4633");
		distinationMap.put(3474,"Geraldton - Australia - 60224");
		distinationMap.put(1324,"Gevle - Sweden - 40116");
		distinationMap.put(4249,"Ghana - Ghana - 7490");
		distinationMap.put(3678,"Ghazaouet - Algeria - 72142");
		distinationMap.put(3679,"Ghazawet - Algeria - 72142");
		distinationMap.put(2475,"Ghemlik - Turkey - 48947");
		distinationMap.put(1851,"Ghent - Belgium - 42331");
		distinationMap.put(638,"Gibara - Cuba - 23900");
		distinationMap.put(4151,"Gibraltar - Gibraltar - 4720");
		distinationMap.put(2178,"Gibraltar - Gibraltar - 47201");
		distinationMap.put(2081,"Gijon - Spain - 47017");
		distinationMap.put(2995,"Gingoog - Philippines - 56500");
		distinationMap.put(2209,"Gioia Tauro - Italy - 47536");
		distinationMap.put(2448,"Giova - Turkey - 48931");
		distinationMap.put(2473,"Giresun - Turkey - 48946");
		distinationMap.put(3540,"Gisborne - New Zealand - 61408");
		distinationMap.put(2595,"Gizan - Saudi Arabia - 51719");
		distinationMap.put(3562,"Gizo - Solomon Is - 62200");
		distinationMap.put(3477,"Gladstone - Australia - 60231");
		distinationMap.put(1718,"Glasgow - United Kingdom - 41623");
		distinationMap.put(4904,"Glassboro - United States - 4603");
		distinationMap.put(4917,"Glendale - United States - 2709");
		distinationMap.put(1514,"Glostrup - Denmark - 40900");
		distinationMap.put(1604,"Gloucester - United Kingdom - 41299");
		distinationMap.put(4852,"GLOUCESTER - United States - 0404");
		distinationMap.put(4434,"GLOUCESTER CITY - United States - 1113");
		distinationMap.put(2706,"Goa - India - 53340");
		distinationMap.put(2444,"Gocek - Turkey - 48925");
		distinationMap.put(45,"Goderich, ONT - Canada - 06533");
		distinationMap.put(88,"Godhavn - Greenland - 10100");
		distinationMap.put(102,"Godthaab - Greenland - 10125");
		distinationMap.put(103,"Godthab - Greenland - 10125");
		distinationMap.put(2449,"Gokova - Turkey - 48931");
		distinationMap.put(2451,"Gokova Iskelesi - Turkey - 48931");
		distinationMap.put(2494,"Golcuk - Turkey - 48999");
		distinationMap.put(146,"Gold River, BC - Canada - 12275");
		distinationMap.put(205,"Gold River, NS - Canada - 13452");
		distinationMap.put(500,"Golfito - Costa Rica - 22363");
		distinationMap.put(2240,"Golfo de Palmas - Italy - 47565");
		distinationMap.put(524,"Golfo de Parita - Panama - 22525");
		distinationMap.put(549,"Golfo de San Miguel - Panama - 22599");
		distinationMap.put(509,"Golfo Dulce - Costa Rica - 22399");
		distinationMap.put(2452,"Golovasi Terminal - Turkey - 48931");
		distinationMap.put(4390,"GOMEL - BELARUS - 45101");
		distinationMap.put(4371,"GOMEL - BELARUS - 4622");
		distinationMap.put(750,"Gonaives - Haiti - 24588");
		distinationMap.put(170,"Gooch Island, BC - Canada - 12493");
		distinationMap.put(4496,"GOOD HOPE - United States - 2014");
		distinationMap.put(1614,"Goole - United Kingdom - 41335");
		distinationMap.put(590,"Gorda Cay - Bahamas - 23640");
		distinationMap.put(2892,"Gorontalo - Indonesia - 56030");
		distinationMap.put(1325,"Goteborg - Sweden - 40117");
		distinationMap.put(1326,"Gothenburg - Sweden - 40117");
		distinationMap.put(836,"Goto oil terminal - Neth Antilles - 27715");
		distinationMap.put(1715,"Gourock - United Kingdom - 41600");
		distinationMap.put(3476,"Gove - Australia - 60227");
		distinationMap.put(580,"Governor&#39;s Harbour - Bahamas - 23623");
		distinationMap.put(2181,"Gozo Island - Malta - 47300");
		distinationMap.put(4645,"GRAET FALLS - United States - 3304");
		distinationMap.put(4492,"GRAMERCY - United States - 2010");
		distinationMap.put(292,"Grand Bank, NFLD - Canada - 15209");
		distinationMap.put(3807,"Grand Bassam - Ivory Coast - 74899");
		distinationMap.put(723,"Grand Cayman - Cayman Isl - 24410");
		distinationMap.put(4686,"GRAND FORKS - United States - 3427");
		distinationMap.put(230,"Grand Harbor, NB - Canada - 13829");
		distinationMap.put(4713,"GRAND HAVEN - United States - 3816");
		distinationMap.put(3808,"Grand Lahou - Ivory Coast - 74899");
		distinationMap.put(3809,"Grand Lahu - Ivory Coast - 74899");
		distinationMap.put(231,"Grand Manan Island, NB - Canada - 13829");
		distinationMap.put(3872,"Grand Popo - Benin - 76100");
		distinationMap.put(4696,"GRAND PORTAGE - United States - 3613");
		distinationMap.put(4708,"GRAND RAPIDS - United States - 3806");
		distinationMap.put(718,"Grand Turks - Turks Is - 24320");
		distinationMap.put(806,"Grande Anse - Grenada - 24882");
		distinationMap.put(1726,"Grangemouth - United Kingdom - 41665");
		distinationMap.put(1744,"Granton - United Kingdom - 41698");
		distinationMap.put(1812,"Gravenhage - Netherlands - 42123");
		distinationMap.put(1657,"Gravesend - United Kingdom - 41398");
		distinationMap.put(591,"Great Abaco Island - Bahamas - 23640");
		distinationMap.put(596,"Great Harbour Cay - Bahamas - 23643");
		distinationMap.put(604,"Great Inagua - Bahamas - 23653");
		distinationMap.put(595,"Great Stirrup Cay - Bahamas - 23642");
		distinationMap.put(1658,"Great Yarmouth - United Kingdom - 41398");
		distinationMap.put(4730,"GREATER ROCKFORD AIRPORT - United States - 3982");
		distinationMap.put(4162,"Greece - Greece - 4840");
		distinationMap.put(4699,"GREEN BAY - United States - 3703");
		distinationMap.put(690,"Green Island - Jamaica - 24100");
		distinationMap.put(592,"Green Turtle Cay - Bahamas - 23640");
		distinationMap.put(1615,"Greenhite - United Kingdom - 41336");
		distinationMap.put(1616,"Greenhithe - United Kingdom - 41336");
		distinationMap.put(1719,"Greenock - United Kingdom - 41625");
		distinationMap.put(1787,"Greenore - Ireland - 41922");
		distinationMap.put(3912,"Greenville - Liberia - 76500");
		distinationMap.put(4493,"GREENVILLE - United States - 2011");
		distinationMap.put(67,"Greenville, ONT - Canada - 09000");
		distinationMap.put(4457,"GREENVILLE-SPARTANBURG - United States - 1603");
		distinationMap.put(1659,"Greenwich - United Kingdom - 41398");
		distinationMap.put(1515,"Grenaa - Denmark - 40900");
		distinationMap.put(4090,"Grenada - Grenada - 2489");
		distinationMap.put(2897,"Gresik - Indonesia - 56034");
		distinationMap.put(3525,"Greymouth - New Zealand - 61400");
		distinationMap.put(1661,"Grimsby - United Kingdom - 41398");
		distinationMap.put(1373,"Grimstad - Norway - 40300");
		distinationMap.put(4325,"GRODNO - Belarus - 44911");
		distinationMap.put(4334,"GRODNO - BELARUS - 45101");
		distinationMap.put(1792,"Groningen - Netherlands - 42100");
		distinationMap.put(227,"Gros Cacouna, QUE - Canada - 13820");
		distinationMap.put(228,"Groscacouna, QUE - Canada - 13820");
		distinationMap.put(1248,"Grundarfjordur - Iceland - 40002");
		distinationMap.put(1249,"Grundartangi - Iceland - 40002");
		distinationMap.put(332,"Guadalupe Island - Mexico - 20100");
		distinationMap.put(4095,"Guadeloupe - Guadeloupe - 2831");
		distinationMap.put(4298,"Guam - Guam - 9350");
		distinationMap.put(4051,"Guam Island - Guam - 93501");
		distinationMap.put(460,"Guanaja - Honduras - 21535");
		distinationMap.put(4382,"Guangzhou - China - 57071");
		distinationMap.put(3180,"Guangzhou - China - 57071");
		distinationMap.put(4779,"GUANICA - United States - 4905");
		distinationMap.put(1055,"Guanillo - Chile - 33700");
		distinationMap.put(931,"Guanta - Venezuela - 30741");
		distinationMap.put(672,"Guantanamo Bay - Cuba - 23941");
		distinationMap.put(932,"Guaranao - Venezuela - 30742");
		distinationMap.put(4067,"Guatemala - Guatemala - 2050");
		distinationMap.put(679,"Guayabal - Cuba - 23979");
		distinationMap.put(1076,"Guayacan - Chile - 33735");
		distinationMap.put(4785,"GUAYANILLA - United States - 4912");
		distinationMap.put(995,"Guayaquil - Ecuador - 33131");
		distinationMap.put(367,"Guaymas - Mexico - 20113");
		distinationMap.put(2490,"Gueldjuk - Turkey - 48999");
		distinationMap.put(4246,"Guinea - Guinea - 7460");
		distinationMap.put(4262,"Guinea-Bissau - Guinea-Bissau - 7642");
		distinationMap.put(905,"Guiria - Venezuela - 30700");
		distinationMap.put(1374,"Guldsmedvik - Norway - 40300");
		distinationMap.put(1539,"Gulfhavn - Denmark - 40910");
		distinationMap.put(4479,"GULFPORT - United States - 1902");
		distinationMap.put(615,"Gun Cay - Bahamas - 23683");
		distinationMap.put(3216,"Gunsan - South Korea - 58028");
		distinationMap.put(857,"Gustavia - Guadeloupe - 28319");
		distinationMap.put(414,"Gutierrez Zamorra - Mexico - 20195");
		distinationMap.put(4099,"Guyana - Guyana - 3120");
		distinationMap.put(3633,"Haapai - Tonga - 68682");
		distinationMap.put(1793,"Haarlem - Netherlands - 42100");
		distinationMap.put(1375,"Haavik - Norway - 40300");
		distinationMap.put(3306,"Hachinohe - Japan - 58808");
		distinationMap.put(2567,"Hadera - Israel - 50815");
		distinationMap.put(1540,"Haderslev - Denmark - 40911");
		distinationMap.put(1246,"Hafnarfjordhur - Iceland - 40001");
		distinationMap.put(1247,"Hafnarfjordur - Iceland - 40001");
		distinationMap.put(2786,"Hai Phong - Vietnam - 55201");
		distinationMap.put(2563,"Haifa - Israel - 50801");
		distinationMap.put(3125,"Haikou - China - 57012");
		distinationMap.put(773,"Haina - Dominican Republic - 24741");
		distinationMap.put(2787,"Haiphong - Vietnam - 55201");
		distinationMap.put(4080,"Haiti - Haiti - 2450");
		distinationMap.put(3330,"Hakata - Japan - 58825");
		distinationMap.put(3331,"Hakodate - Japan - 58826");
		distinationMap.put(1431,"Halden - Norway - 40342");
		distinationMap.put(2715,"Haldia - India - 53354");
		distinationMap.put(581,"Half Moon Cay - Bahamas - 23624");
		distinationMap.put(237,"Halifax, NS - Canada - 13841");
		distinationMap.put(1327,"Hallstavik - Sweden - 40118");
		distinationMap.put(1328,"Halmstad - Sweden - 40119");
		distinationMap.put(1329,"Halsingborg - Sweden - 40120");
		distinationMap.put(2612,"Halul Island - Qatar - 51800");
		distinationMap.put(4984,"HAMAD PORT - QATAR - 51800");
		distinationMap.put(1639,"Hamble - United Kingdom - 41374");
		distinationMap.put(1955,"Hamburg - Germany - 42879");
		distinationMap.put(564,"Hamilton - Bermuda - 23201");
		distinationMap.put(4062,"Hamilton, ONT - Canada - 01520");
		distinationMap.put(1476,"Hamina - Finland - 40520");
		distinationMap.put(4319,"Hamina* - Finland - 40549");
		distinationMap.put(1425,"Hammerfest - Norway - 40336");
		distinationMap.put(2621,"Hamriyah Terminal - United Arab Em - 52000");
		distinationMap.put(3262,"Handa - Japan - 58800");
		distinationMap.put(1477,"Hango - Finland - 40523");
		distinationMap.put(1478,"Hanko - Finland - 40523");
		distinationMap.put(3126,"Hankow - China - 57013");
		distinationMap.put(4670,"HANNAH - United States - 3408");
		distinationMap.put(4675,"HANSBORO - United States - 3415");
		distinationMap.put(1516,"Hansted - Denmark - 40900");
		distinationMap.put(1517,"Hanstholm - Denmark - 40900");
		distinationMap.put(240,"Hantsport, NS - Canada - 13848");
		distinationMap.put(3598,"Hao - French Polyn - 64178");
		distinationMap.put(3263,"Haramaci - Japan - 58800");
		distinationMap.put(1274,"Harare - Sweden - 40100");
		distinationMap.put(293,"Harbour Breton, NFLD - Canada - 15210");
		distinationMap.put(306,"Harbour Grace, NFLD - Canada - 15232");
		distinationMap.put(576,"Harbour Island - Bahamas - 23619");
		distinationMap.put(1959,"Harburg - Germany - 42881");
		distinationMap.put(1830,"Haren - Belgium - 42300");
		distinationMap.put(1795,"Haren - Netherlands - 42100");
		distinationMap.put(1275,"Hargshamn - Sweden - 40100");
		distinationMap.put(1796,"Harlingen - Netherlands - 42100");
		distinationMap.put(149,"Harmac, BC - Canada - 12407");
		distinationMap.put(1276,"Harnosand - Sweden - 40100");
		distinationMap.put(3913,"Harper - Liberia - 76500");
		distinationMap.put(4433,"HARRISBURG - United States - 1109");
		distinationMap.put(4356,"Harrogate - United Kingdom - 41323");
		distinationMap.put(1376,"Harstad - Norway - 40300");
		distinationMap.put(4859,"HARTFORD - United States - 0411");
		distinationMap.put(1618,"Hartlepool - United Kingdom - 41338");
		distinationMap.put(108,"Hartley Bay, BC - Canada - 12200");
		distinationMap.put(109,"Hartley, BC - Canada - 12200");
		distinationMap.put(1662,"Harwich - United Kingdom - 41398");
		distinationMap.put(3264,"Hashihama - Japan - 58800");
		distinationMap.put(3479,"Hasting - Australia - 60237");
		distinationMap.put(1432,"Haugesund - Norway - 40345");
		distinationMap.put(674,"Havana - Cuba - 23944");
		distinationMap.put(3526,"Hawkes Bay - New Zealand - 61400");
		distinationMap.put(2491,"Hay Darpasa - Turkey - 48999");
		distinationMap.put(3466,"Hay Point - Australia - 60212");
		distinationMap.put(2492,"Haydarpasa - Turkey - 48999");
		distinationMap.put(4213,"Heard and McDonald Islands - Heard and McDonald Islands - 6029");
		distinationMap.put(4689,"HECTOR INTERNATIONAL AIRPORT, FARGO - United States - 3481");
		distinationMap.put(1797,"Helder - Netherlands - 42100");
		distinationMap.put(1330,"Helsingborg - Sweden - 40120");
		distinationMap.put(1479,"Helsingfors - Finland - 40525");
		distinationMap.put(1524,"Helsingor - Denmark - 40900");
		distinationMap.put(1480,"Helsinki - Finland - 40525");
		distinationMap.put(1854,"Hemiksem - Belgium - 42385");
		distinationMap.put(2358,"Heraklion - Greece - 48411");
		distinationMap.put(333,"Hermosillo - Mexico - 20100");
		distinationMap.put(1277,"Hernosand - Sweden - 40100");
		distinationMap.put(1433,"Heroen - Norway - 40348");
		distinationMap.put(81,"Heron Bay, ONT - Canada - 09669");
		distinationMap.put(1941,"Herrenwyck - Germany - 42800");
		distinationMap.put(4020,"Hess Oil Term. St. Croix - US Virgin Is - 91125");
		distinationMap.put(287,"Hibernia, NFLD - Canada - 15201");
		distinationMap.put(4892,"Hickory - United States - 1509");
		distinationMap.put(4511,"HIDALGO/PHARR - United States - 2305");
		distinationMap.put(3335,"Higashi Harima - Japan - 58828");
		distinationMap.put(3265,"Higashi Iwase - Japan - 58800");
		distinationMap.put(3336,"Higashiharima Ko - Japan - 58828");
		distinationMap.put(4056,"High Seas - Unknown - 99900");
		distinationMap.put(4059,"High Seas,Gulf of Mexico - Unknown - 99930");
		distinationMap.put(4057,"High Seas,North Atlantic - Unknown - 99910");
		distinationMap.put(4060,"High Seas,North Pacific - Unknown - 99940");
		distinationMap.put(4058,"High Seas,South Atlantic - Unknown - 99920");
		distinationMap.put(4061,"High Seas,South Pacific - Unknown - 99950");
		distinationMap.put(4848,"HIGHGATE SPRINGS/ALBURG - United States - 0212");
		distinationMap.put(4636,"HILO - United States - 3202");
		distinationMap.put(1457,"Himanko - Finland - 40500");
		distinationMap.put(3404,"Himeji - Japan - 58871");
		distinationMap.put(3402,"Himezi - Japan - 58871");
		distinationMap.put(1855,"Himixen - Belgium - 42385");
		distinationMap.put(2996,"Hinigaran - Philippines - 56500");
		distinationMap.put(3359,"Hiro - Japan - 58845");
		distinationMap.put(3339,"Hirohata - Japan - 58830");
		distinationMap.put(3340,"Hiroshima - Japan - 58831");
		distinationMap.put(3398,"Hitachi - Japan - 58869");
		distinationMap.put(3399,"Hitachi Ko - Japan - 58869");
		distinationMap.put(3400,"Hitaki Ko - Japan - 58869");
		distinationMap.put(2798,"Ho Chi Minh City - Vietnam - 55224");
		distinationMap.put(3499,"Hobart - Australia - 60295");
		distinationMap.put(1541,"Hobro - Denmark - 40912");
		distinationMap.put(2655,"Hodeidah - Yemen - 52115");
		distinationMap.put(1333,"Hoganas - Sweden - 40123");
		distinationMap.put(1542,"Holbaek - Denmark - 40913");
		distinationMap.put(1416,"Holla - Norway - 40320");
		distinationMap.put(4912,"HOLLAND, O - United States - 1001");
		distinationMap.put(1377,"Holmestrand - Norway - 40300");
		distinationMap.put(1337,"Holmsund - Sweden - 40127");
		distinationMap.put(110,"Holsteinborg, BC - Canada - 12200");
		distinationMap.put(89,"Holsteinsborg - Greenland - 10100");
		distinationMap.put(1944,"Holtenau - Germany - 42825");
		distinationMap.put(1696,"Holyhead - United Kingdom - 41415");
		distinationMap.put(308,"Holyrood, NFLD - Canada - 15245");
		distinationMap.put(2788,"Hon Gai - Vietnam - 55202");
		distinationMap.put(2789,"Hon Gay - Vietnam - 55202");
		distinationMap.put(3068,"Hondagua - Philippines - 56530");
		distinationMap.put(4070,"Honduras - Honduras - 2150");
		distinationMap.put(1861,"Honfleur - France - 42700");
		distinationMap.put(4206,"Hong Kong - Hong Kong - 5820");
		distinationMap.put(3236,"Hong Kong - Hong Kong - 58201");
		distinationMap.put(3563,"Honiara - Solomon Is - 62200");
		distinationMap.put(1378,"Honningsvaag - Norway - 40300");
		distinationMap.put(1379,"Honningsvag - Norway - 40300");
		distinationMap.put(4635,"HONOLULU - United States - 3201");
		distinationMap.put(4639,"HONOLULU INTL. AIRPORT - United States - 3205");
		distinationMap.put(1798,"Hook of Holland - Netherlands - 42100");
		distinationMap.put(2430,"Hopa - Turkey - 48900");
		distinationMap.put(4446,"HOPEWELL - United States - 1408");
		distinationMap.put(2541,"Hormuz Terminal - Iran - 50700");
		distinationMap.put(1278,"Hornesfors - Sweden - 40100");
		distinationMap.put(2144,"Hornillo - Spain - 47099");
		distinationMap.put(1543,"Horsens - Denmark - 40914");
		distinationMap.put(2172,"Horta - Portugal - 47150");
		distinationMap.put(1388,"Horten - Norway - 40300");
		distinationMap.put(4826,"HOULTON - United States - 0106");
		distinationMap.put(1727,"Hound Point - United Kingdom - 41668");
		distinationMap.put(1728,"Houndpoint - United Kingdom - 41668");
		distinationMap.put(4802,"HOUSTON - United States - 5301");
		distinationMap.put(4804,"HOUSTON INTERCONTINENTAL AIRPORT,HOUSTON - United States - 5309");
		distinationMap.put(4021,"Hovic, St. Croix - US Virgin Is - 91125");
		distinationMap.put(126,"Howie Sound, BC - Canada - 12208");
		distinationMap.put(3173,"Hsia Men - China - 57069");
		distinationMap.put(3137,"Hsin Kang - China - 57017");
		distinationMap.put(3138,"Hsinkang - China - 57017");
		distinationMap.put(3105,"Hu lu Tao - China - 57000");
		distinationMap.put(1013,"Huacho - Peru - 33300");
		distinationMap.put(3256,"Hualien - China Taiwan - 58312");
		distinationMap.put(3183,"Huangpu - China - 57072");
		distinationMap.put(1014,"Huarmey - Peru - 33300");
		distinationMap.put(1077,"Huasco - Chile - 33739");
		distinationMap.put(471,"Huaunta - Nicaragua - 21900");
		distinationMap.put(1279,"Hudiksvall - Sweden - 40100");
		distinationMap.put(2097,"Huelva - Spain - 47044");
		distinationMap.put(1619,"Hull - United Kingdom - 41341");
		distinationMap.put(3104,"Huludao Gang - China - 57000");
		distinationMap.put(3106,"Hulutao - China - 57000");
		distinationMap.put(4780,"HUMACAO - United States - 4906");
		distinationMap.put(1831,"Humbeek - Belgium - 42300");
		distinationMap.put(4130,"Hungary - Hungary - 4370");
		distinationMap.put(3202,"Hungnam - North Korea - 57900");
		distinationMap.put(1720,"Hunterston - United Kingdom - 41627");
		distinationMap.put(4482,"HUNTSVILLE - United States - 1910");
		distinationMap.put(4745,"HURON - United States - 4117");
		distinationMap.put(2410,"Iali - Greece - 48475");
		distinationMap.put(1194,"Ibicuy - Argentina - 35700");
		distinationMap.put(2112,"Ibiza - Spain - 47067");
		distinationMap.put(4111,"Iceland - Iceland - 4000");
		distinationMap.put(1338,"Iggesund - Sweden - 40129");
		distinationMap.put(1825,"Ijmuiden - Netherlands - 42190");
		distinationMap.put(731,"Ile de la Gonave - Haiti - 24500");
		distinationMap.put(1112,"Ilheus - Brazil - 35137");
		distinationMap.put(2042,"Ilichevsk - Ukraine - 46271");
		distinationMap.put(3069,"Iligan - Philippines - 56531");
		distinationMap.put(1033,"Ilo - Peru - 33335");
		distinationMap.put(3070,"Iloilo - Philippines - 56532");
		distinationMap.put(2043,"Ilyichevsk - Ukraine - 46271");
		distinationMap.put(3300,"Imari - Japan - 58802");
		distinationMap.put(1150,"Imbituba - Brazil - 35178");
		distinationMap.put(1620,"Immingham - United Kingdom - 41342");
		distinationMap.put(2188,"Imperia - Italy - 47500");
		distinationMap.put(3220,"Inchon - South Korea - 58029");
		distinationMap.put(4183,"India - India - 5330");
		distinationMap.put(4740,"INDIANAPOLIS - United States - 4110");
		distinationMap.put(4195,"Indonesia - Indonesia - 5600");
		distinationMap.put(2493,"Inebolu - Turkey - 48999");
		distinationMap.put(1481,"Inga - Finland - 40527");
		distinationMap.put(1482,"Inkoo - Finland - 40527");
		distinationMap.put(4799,"INTERNATIONAL COURIER ASSOCIATION - United States - 5270");
		distinationMap.put(4694,"INTERNATIONAL FALLS/RANIER - United States - 3604");
		distinationMap.put(4294,"International Organizations - International Organizations - 8500");
		distinationMap.put(1745,"Invergordon - United Kingdom - 41698");
		distinationMap.put(1746,"Inverkeithing - United Kingdom - 41698");
		distinationMap.put(1729,"Inverkip - United Kingdom - 41674");
		distinationMap.put(1736,"Inverness - United Kingdom - 41683");
		distinationMap.put(1663,"Ipswich - United Kingdom - 41398");
		distinationMap.put(4326,"Iqueque - Chile - CL");
		distinationMap.put(1078,"Iquique - Chile - 33741");
		distinationMap.put(4377,"IQUIQUE - CHILI - 8954");
		distinationMap.put(1034,"Iquitos - Peru - 33337");
		distinationMap.put(3266,"Irago - Japan - 58800");
		distinationMap.put(3267,"Irago Zaki - Japan - 58800");
		distinationMap.put(2359,"Iraklion - Greece - 48411");
		distinationMap.put(4170,"Iran - Iran - 5070");
		distinationMap.put(4169,"Iraq - Iraq - 5050");
		distinationMap.put(4119,"Ireland - Ireland - 4190");
		distinationMap.put(4412,"IRKUTSK - RUSSIA - 44911");
		distinationMap.put(1721,"Irvine - United Kingdom - 41630");
		distinationMap.put(1722,"Irvine Harbor - United Kingdom - 41630");
		distinationMap.put(3085,"Isabel - Philippines - 56590");
		distinationMap.put(666,"Isabela del Sagua - Cuba - 23937");
		distinationMap.put(1237,"Isafjordhur - Iceland - 40000");
		distinationMap.put(1238,"Isafjordur - Iceland - 40000");
		distinationMap.put(2445,"Isdemir - Turkey - 48928");
		distinationMap.put(3338,"Ishinomaki - Japan - 58829");
		distinationMap.put(2453,"Iskenderun - Turkey - 48931");
		distinationMap.put(359,"Isla Cedros - Mexico - 20104");
		distinationMap.put(415,"Isla de Lobos - Mexico - 20195");
		distinationMap.put(636,"Isla de Pinos - Cuba - 23900");
		distinationMap.put(334,"Isla Maria Cleofas - Mexico - 20100");
		distinationMap.put(335,"Isla Maria Madre - Mexico - 20100");
		distinationMap.put(336,"Isla Maria Magdalena - Mexico - 20100");
		distinationMap.put(399,"Isla Mujeres - Mexico - 20179");
		distinationMap.put(550,"Isla Parida - Panama - 22599");
		distinationMap.put(461,"Isla Roatan - Honduras - 21535");
		distinationMap.put(884,"Isla San Andres - Colombia - 30130");
		distinationMap.put(337,"Isla Socorro - Mexico - 20100");
		distinationMap.put(452,"Isla Utila - Honduras - 21500");
		distinationMap.put(371,"Islas Coronados - Mexico - 20128");
		distinationMap.put(510,"Islas de Coco - Costa Rica - 22399");
		distinationMap.put(472,"Islas de Maiz - Nicaragua - 21900");
		distinationMap.put(1015,"Islas Lobos de Afuera - Peru - 33300");
		distinationMap.put(1016,"Islas Lobos de Tierra - Peru - 33300");
		distinationMap.put(637,"Isle of Pines - Cuba - 23900");
		distinationMap.put(3736,"Ismailia - Egypt - 72925");
		distinationMap.put(4171,"Israel - Israel - 5081");
		distinationMap.put(2471,"Istanbul - Turkey - 48945");
		distinationMap.put(436,"Istapa - Guatemala - 20599");
		distinationMap.put(1116,"Itacoatiara - Brazil - 35139");
		distinationMap.put(1114,"Itajai - Brazil - 35138");
		distinationMap.put(1115,"Itajay - Brazil - 35138");
		distinationMap.put(4155,"Italy - Italy - 4759");
		distinationMap.put(1109,"Itaqui - Brazil - 35135");
		distinationMap.put(2388,"Itea - Greece - 48457");
		distinationMap.put(3268,"Itozaki - Japan - 58800");
		distinationMap.put(90,"Ivigtut - Greenland - 10100");
		distinationMap.put(4248,"Ivory Coast - Ivory Coast - 7480");
		distinationMap.put(3342,"Iwakuni - Japan - 58833");
		distinationMap.put(3343,"Iwakuni Ko - Japan - 58833");
		distinationMap.put(3311,"Iyo Mishima - Japan - 58812");
		distinationMap.put(3312,"Iyoshima - Japan - 58812");
		distinationMap.put(2457,"Izmir - Turkey - 48939");
		distinationMap.put(2458,"Izmit - Turkey - 48940");
		distinationMap.put(437,"Iztapa - Guatemala - 20599");
		distinationMap.put(4824,"JACKMAN - United States - 0104");
		distinationMap.put(111,"Jackson Bay, BC - Canada - 12200");
		distinationMap.put(4463,"JACKSONVILLE - United States - 1803");
		distinationMap.put(743,"Jacmel - Haiti - 24537");
		distinationMap.put(2750,"Jaffna - Sri Lanka - 54200");
		distinationMap.put(2997,"Jagna - Philippines - 56500");
		distinationMap.put(774,"Jaina - Dominican Republic - 24741");
		distinationMap.put(2895,"Jakarta - Indonesia - 56033");
		distinationMap.put(91,"Jakobshavn - Greenland - 10100");
		distinationMap.put(1458,"Jakobstad - Finland - 40500");
		distinationMap.put(4077,"Jamaica - Jamaica - 2410");
		distinationMap.put(2946,"Jambi - Indonesia - 56078");
		distinationMap.put(3870,"Jamestown, St. Helena - St. Helena - 75899");
		distinationMap.put(2695,"Jamnagar - India - 53305");
		distinationMap.put(4208,"Japan - Japan - 5880");
		distinationMap.put(1664,"Jarrow - United Kingdom - 41398");
		distinationMap.put(2702,"Jawaharlal Nehru - India - 53313");
		distinationMap.put(2613,"Jazirath Halul - Qatar - 51800");
		distinationMap.put(2542,"Jazireh ye Khark - Iran - 50700");
		distinationMap.put(2640,"Jebel Ali - United Arab Em - 52051");
		distinationMap.put(2638,"Jebel Dhanna - United Arab Em - 52050");
		distinationMap.put(2598,"Jeddah - Saudi Arabia - 51721");
		distinationMap.put(732,"Jeremie - Haiti - 24500");
		distinationMap.put(137,"Jervis Inlet, BC - Canada - 12217");
		distinationMap.put(3107,"Jiangmen - China - 57000");
		distinationMap.put(3199,"Jiangyin - China - 57080");
		distinationMap.put(2599,"Jidda - Saudi Arabia - 51721");
		distinationMap.put(3662,"Jijel - Algeria - 72100");
		distinationMap.put(2998,"Jimenez - Philippines - 56500");
		distinationMap.put(4620,"JINEAU - United States - 3101");
		distinationMap.put(3213,"Jinhae - South Korea - 58015");
		distinationMap.put(3219,"Jinsen - South Korea - 58029");
		distinationMap.put(3108,"Jiu Jiang - China - 57000");
		distinationMap.put(3195,"Jiuzhou - China - 57077");
		distinationMap.put(1104,"Joao Pessoa - Brazil - 35127");
		distinationMap.put(4784,"JOBOS - United States - 4911");
		distinationMap.put(4767,"JOHN F. KENNEDY AIRPORT, JFK - United States - 4701");
		distinationMap.put(2817,"Johore - Malaysia - 55707");
		distinationMap.put(2818,"Johore Bahru - Malaysia - 55707");
		distinationMap.put(2999,"Jolo - Philippines - 56500");
		distinationMap.put(4836,"JONESPORT - United States - 0122");
		distinationMap.put(4174,"Jordan - Jordan - 5110");
		distinationMap.put(3649,"Jorf Lasfar - Morocco - 71415");
		distinationMap.put(1380,"Jorpeland - Norway - 40300");
		distinationMap.put(933,"Jose - Venezuela - 30743");
		distinationMap.put(1185,"Jose Ignacio Terminal - Uruguay - 35500");
		distinationMap.put(3086,"Jose Panganiban - Philippines - 56591");
		distinationMap.put(2603,"Juaymah Oil Terminal - Saudi Arabia - 51723");
		distinationMap.put(2597,"Jubail - Saudi Arabia - 51720");
		distinationMap.put(639,"Jucaro - Cuba - 23900");
		distinationMap.put(2601,"Judda - Saudi Arabia - 51721");
		distinationMap.put(92,"Julianchaab - Greenland - 10100");
		distinationMap.put(93,"Julianehaab - Greenland - 10100");
		distinationMap.put(2048,"Juzhny - Ukraine - 46275");
		distinationMap.put(1381,"Kaarsto - Norway - 40300");
		distinationMap.put(3305,"Kagoshima - Japan - 58807");
		distinationMap.put(4637,"KAHULUI - United States - 3203");
		distinationMap.put(4640,"KAILUA-KONA - United States - 3206");
		distinationMap.put(2836,"Kajang - Malaysia - 55751");
		distinationMap.put(2726,"Kakinada - India - 53398");
		distinationMap.put(2727,"Kakinada Bay - India - 53398");
		distinationMap.put(3337,"Kakogawa - Japan - 58828");
		distinationMap.put(4587,"KALAMA - United States - 2909");
		distinationMap.put(2363,"Kalamai - Greece - 48421");
		distinationMap.put(2365,"Kalamaki - Greece - 48425");
		distinationMap.put(2364,"Kalamata - Greece - 48421");
		distinationMap.put(2360,"Kali Limenes - Greece - 48412");
		distinationMap.put(2925,"Kali Pekalongan - Indonesia - 56058");
		distinationMap.put(2878,"Kalimantan - Indonesia - 56020");
		distinationMap.put(2000,"Kaliningrad - Russia - 46213");
		distinationMap.put(4660,"KALISPELL - United States - 3324");
		distinationMap.put(1280,"Kalix - Sweden - 40100");
		distinationMap.put(2319,"Kalloni - Greece - 48400");
		distinationMap.put(1281,"Kalmar - Sweden - 40100");
		distinationMap.put(2361,"Kaloi limniones - Greece - 48412");
		distinationMap.put(1563,"Kalundborg - Denmark - 40940");
		distinationMap.put(3344,"Kamaishi - Japan - 58834");
		distinationMap.put(1382,"Kambo - Norway - 40300");
		distinationMap.put(2027,"Kamchatka - Russia - 46239");
		distinationMap.put(2802,"Kampong Saom - Cambodia - 55500");
		distinationMap.put(2803,"Kampot - Cambodia - 55500");
		distinationMap.put(3796,"Kamsar - Guinea - 74625");
		distinationMap.put(3307,"Kanado - Japan - 58809");
		distinationMap.put(3387,"Kanda - Japan - 58862");
		distinationMap.put(4958,"Kandahar - Afganistan - 5310");
		distinationMap.put(2698,"Kandla - India - 53307");
		distinationMap.put(3347,"Kanokawa - Japan - 58836");
		distinationMap.put(4757,"KANSAS CITY - United States - 4501");
		distinationMap.put(3253,"Kao Hsiung - China Taiwan - 58309");
		distinationMap.put(3254,"Kaohsiung - China Taiwan - 58309");
		distinationMap.put(3790,"Kaolak - Senegal - 74499");
		distinationMap.put(2736,"Karachi - Pakistan - 53550");
		distinationMap.put(2737,"Karachi Harbor - Pakistan - 53550");
		distinationMap.put(4320,"KARAGANDA - Kazakhstan - 40549");
		distinationMap.put(4353,"KARAGANDA - Kazakhstan - 44911");
		distinationMap.put(4404,"Karaganda - KAZAKHSTAN - 45101");
		distinationMap.put(4394,"KARAGANDA - KAZAKHSTAN - 5700");
		distinationMap.put(3401,"Karatsu - Japan - 58870");
		distinationMap.put(2373,"Karavos - Greece - 48449");
		distinationMap.put(2279,"Kardeljevo - Croatia - 47911");
		distinationMap.put(2728,"Karikal - India - 53398");
		distinationMap.put(1339,"Karlsborg - Sweden - 40132");
		distinationMap.put(1340,"Karlshamn - Sweden - 40133");
		distinationMap.put(1282,"Karlskrona - Sweden - 40100");
		distinationMap.put(1283,"Karlstad - Sweden - 40100");
		distinationMap.put(1284,"Karskar - Sweden - 40100");
		distinationMap.put(1383,"Karsto - Norway - 40300");
		distinationMap.put(3348,"Kasaoka - Japan - 58837");
		distinationMap.put(3350,"Kashima - Japan - 58839");
		distinationMap.put(3351,"Kashima Ko - Japan - 58839");
		distinationMap.put(3299,"Kashiwazaki - Japan - 58801");
		distinationMap.put(2884,"Kasim - Indonesia - 56023");
		distinationMap.put(1459,"Kasko - Finland - 40500");
		distinationMap.put(2292,"Kastel Sucurac - Croatia - 47931");
		distinationMap.put(1518,"Kastrup - Denmark - 40900");
		distinationMap.put(2389,"Katakolon - Greece - 48458");
		distinationMap.put(2782,"Katang - Thailand - 54929");
		distinationMap.put(2875,"Katawaringin - Indonesia - 56019");
		distinationMap.put(2367,"Kavala - Greece - 48427");
		distinationMap.put(3508,"Kavieng - Papua New Guinea - 60400");
		distinationMap.put(3509,"Kavieng Harbor - Papua New Guinea - 60400");
		distinationMap.put(3355,"Kawanoe - Japan - 58842");
		distinationMap.put(3349,"Kawasaki - Japan - 58838");
		distinationMap.put(4143,"Kazakhstan - Kazakhstan - 4634");
		distinationMap.put(3241,"Keelung - China Taiwan - 58301");
		distinationMap.put(1239,"Keflavik - Iceland - 40000");
		distinationMap.put(3302,"Keihin - Japan - 58804");
		distinationMap.put(2837,"Kelang - Malaysia - 55751");
		distinationMap.put(1497,"Kemi - Finland - 40543");
		distinationMap.put(2476,"Kemlik - Turkey - 48947");
		distinationMap.put(2883,"Kendiri - Indonesia - 56022");
		distinationMap.put(3640,"Kenitra - Morocco - 71400");
		distinationMap.put(4608,"KENMORE AIR HARBOR - United States - 3018");
		distinationMap.put(4274,"Kenya - Kenya - 7790");
		distinationMap.put(2046,"Kerch - Ukraine - 46274");
		distinationMap.put(2825,"Kereth - Malaysia - 55716");
		distinationMap.put(2387,"Kerkyra - Greece - 48456");
		distinationMap.put(2047,"Kertch - Ukraine - 46274");
		distinationMap.put(3403,"Kesennuma - Japan - 58871");
		distinationMap.put(3405,"Kesennuma Ko - Japan - 58871");
		distinationMap.put(4621,"KETCHIKAN - United States - 3102");
		distinationMap.put(4793,"KEY WEST - United States - 5202");
		distinationMap.put(4970,"KHALIFA BIN SALMAN - BAHRAIN - 5250");
		distinationMap.put(2320,"Khalkis - Greece - 48400");
		distinationMap.put(2321,"Khania - Greece - 48400");
		distinationMap.put(2561,"Kharg Island - Iran - 50771");
		distinationMap.put(2576,"Khawr Al Ama - Kuwait - 51300");
		distinationMap.put(2577,"Khor al Ami - Kuwait - 51300");
		distinationMap.put(2530,"Khor al Zubair - Iraq - 50570");
		distinationMap.put(2641,"Khor Fakkan - United Arab Em - 52060");
		distinationMap.put(2529,"Khor-al-Amaya - Iraq - 50560");
		distinationMap.put(2535,"Khorramshahr - Iran - 50700");
		distinationMap.put(2543,"Khosrowabad - Iran - 50700");
		distinationMap.put(2745,"Khulna - Bangladesh - 53820");
		distinationMap.put(2935,"Kidjang - Indonesia - 56066");
		distinationMap.put(1945,"Kiel - Germany - 42825");
		distinationMap.put(3510,"Kieta - Papua New Guinea - 60400");
		distinationMap.put(3316,"Kiire - Japan - 58815");
		distinationMap.put(3242,"Kiirun - China Taiwan - 58301");
		distinationMap.put(3940,"Kilindini - Kenya - 77913");
		distinationMap.put(1623,"Killingholme - United Kingdom - 41345");
		distinationMap.put(3953,"Kilwa Kivinje - Tanzania - 78399");
		distinationMap.put(3332,"Kimitsu - Japan - 58827");
		distinationMap.put(2593,"King Abdul Aziz Port - Saudi Arabia - 51715");
		distinationMap.put(4966,"KING ABDULLAH PORT - Saudi Arabia - 51732");
		distinationMap.put(2607,"King Fahd Port - Saudi Arabia - 51730");
		distinationMap.put(1665,"King&#39;s Lynn - United Kingdom - 41398");
		distinationMap.put(1621,"Kings North - United Kingdom - 41343");
		distinationMap.put(4589,"KINGSLEY FIELD,KLAMATH FALLS - United States - 2981");
		distinationMap.put(1622,"Kingsnorth - United Kingdom - 41343");
		distinationMap.put(702,"Kingston - Jamaica - 24128");
		distinationMap.put(10,"Kingston, ONT - Canada - 01670");
		distinationMap.put(803,"Kingstown - St. Vincent - 24871");
		distinationMap.put(33,"Kingsville, ONT - Canada - 03506");
		distinationMap.put(3406,"Kinuura - Japan - 58872");
		distinationMap.put(4223,"Kiribati - Kiribati - 6226");
		distinationMap.put(1384,"Kirkenes - Norway - 40300");
		distinationMap.put(1747,"Kirkwall, Orkney Is - United Kingdom - 41698");
		distinationMap.put(3333,"Kisarazu - Japan - 58827");
		distinationMap.put(3334,"Kisarazu Ko - Japan - 58827");
		distinationMap.put(3269,"Kishiwada - Japan - 58800");
		distinationMap.put(3931,"Kismaayo - Somalia - 77099");
		distinationMap.put(3932,"Kismayu - Somalia - 77099");
		distinationMap.put(3318,"Kita Kyushu - Japan - 58817");
		distinationMap.put(3319,"Kitakyushu - Japan - 58817");
		distinationMap.put(147,"Kitimat, BC - Canada - 12287");
		distinationMap.put(3109,"Kiukiang - China - 57000");
		distinationMap.put(4354,"KIZILORDA - Kazakhstan - 44911");
		distinationMap.put(1544,"Kjoge - Denmark - 40915");
		distinationMap.put(4360,"Klaipeda - Belarus (Grodno) - 45101");
		distinationMap.put(4361,"Klaipeda - Belarus (Grodno) - 45101");
		distinationMap.put(4362,"Klaipeda - Grodno - Belarus - 4622");
		distinationMap.put(1980,"Klaipeda - Lithuania - 45101");
		distinationMap.put(4949,"Klaipeda - Novopolotsk - Belarus - 45101");
		distinationMap.put(4402,"KLAIPEDA / ALMATI, KZ - KAZAKHSTAN - 45101");
		distinationMap.put(4403,"Klaipeda / Pavlodar - Kazakhstan - 45101");
		distinationMap.put(4372,"KLAIPEDA -GOMEL- BELARUS - BELARUS - 45102");
		distinationMap.put(4308,"KLAIPEDA-MINSK - BELARUS - 1234");
		distinationMap.put(1573,"Klaksvik - Faroe - 40985");
		distinationMap.put(4498,"KNOXVILLE - United States - 2016");
		distinationMap.put(2779,"Ko Sichang - Thailand - 54920");
		distinationMap.put(3352,"Kobe - Japan - 58840");
		distinationMap.put(1565,"Kobenhavn - Denmark - 40948");
		distinationMap.put(3407,"Kochi - Japan - 58873");
		distinationMap.put(1545,"Koge - Denmark - 40915");
		distinationMap.put(1460,"Kokkola - Finland - 40500");
		distinationMap.put(3844,"Koko - Nigeria - 75361");
		distinationMap.put(3511,"Kokopo - Papua New Guinea - 60400");
		distinationMap.put(4393,"Kokshetau - KAZAKHSTAN - 44911");
		distinationMap.put(3353,"Kokura - Japan - 58841");
		distinationMap.put(3354,"Kokura Ko - Japan - 58841");
		distinationMap.put(2683,"Kolachel - India - 53300");
		distinationMap.put(3000,"Kolambugan - Philippines - 56500");
		distinationMap.put(1546,"Kolding - Denmark - 40916");
		distinationMap.put(3777,"Kole Terminal - Cameroon - 74201");
		distinationMap.put(2322,"Kolpos Kallonis - Greece - 48400");
		distinationMap.put(2028,"Kolyma River - Russia - 46239");
		distinationMap.put(3420,"Komatsujima - Japan - 58882");
		distinationMap.put(3421,"Komatsushima - Japan - 58882");
		distinationMap.put(3795,"Konakri - Guinea - 74619");
		distinationMap.put(2001,"Konigsberg - Russia - 46213");
		distinationMap.put(3243,"Koolung - China Taiwan - 58301");
		distinationMap.put(2275,"Kopar - Slovenia - 47909");
		distinationMap.put(2276,"Koper - Slovenia - 47909");
		distinationMap.put(1385,"Kopervik - Norway - 40300");
		distinationMap.put(1304,"Kopmanholmen - Sweden - 40100");
		distinationMap.put(4205,"Korea, South - Korea, South - 5800");
		distinationMap.put(2357,"Korinthos - Greece - 48410");
		distinationMap.put(3616,"Koror - Palau - 68394");
		distinationMap.put(2018,"Korsakov - Russia - 46236");
		distinationMap.put(1547,"Korsor - Denmark - 40917");
		distinationMap.put(4305,"KOSICE - SLOVAKIA - 42870");
		distinationMap.put(3754,"Kossier - Egypt - 72999");
		distinationMap.put(4392,"Kostanay - Kazakhstan - 44911");
		distinationMap.put(2840,"Kota Kinabalu - Malaysia - 55752");
		distinationMap.put(1498,"Kotka - Finland - 40549");
		distinationMap.put(4418,"KOTKA - Germany - 42870");
		distinationMap.put(4890,"Kotka - United States - 40549");
		distinationMap.put(3587,"Kouaoua - New Caledonia - 64100");
		distinationMap.put(1487,"Koverhar - Finland - 40532");
		distinationMap.put(2005,"Kovisto - Russia - 46220");
		distinationMap.put(3237,"Kowloon - Hong Kong - 58270");
		distinationMap.put(2684,"Kozhikode - India - 53300");
		distinationMap.put(3824,"Kpeme - Togo - 75200");
		distinationMap.put(2761,"Krabi - Thailand - 54900");
		distinationMap.put(1386,"Kragero - Norway - 40300");
		distinationMap.put(837,"Kralendijk - Neth Antilles - 27715");
		distinationMap.put(1285,"Kramfors - Sweden - 40100");
		distinationMap.put(4387,"Krasnoyarsk - Russia - 44911");
		distinationMap.put(3778,"Kribi - Cameroon - 74213");
		distinationMap.put(1434,"Kristiansand N - Norway - 40363");
		distinationMap.put(1435,"Kristiansand S - Norway - 40364");
		distinationMap.put(1286,"Kristinehamn - Sweden - 40100");
		distinationMap.put(4955,"Kronstadt - Russia - 46215");
		distinationMap.put(2833,"Kuala Selangor - Malaysia - 55742");
		distinationMap.put(2942,"Kuala Tanjung - Indonesia - 56076");
		distinationMap.put(2822,"Kuala Terengganu - Malaysia - 55711");
		distinationMap.put(2824,"Kuantan - Malaysia - 55715");
		distinationMap.put(2823,"Kuching - Malaysia - 55713");
		distinationMap.put(3356,"Kudamatsu - Japan - 58843");
		distinationMap.put(3217,"Kunsan - South Korea - 58028");
		distinationMap.put(3218,"Kunson - South Korea - 58028");
		distinationMap.put(3360,"Kure - Japan - 58845");
		distinationMap.put(3358,"Kuroishi - Japan - 58844");
		distinationMap.put(3361,"Kushiro - Japan - 58846");
		distinationMap.put(4175,"Kuwait - Kuwait - 5130");
		distinationMap.put(2579,"Kuwait - Kuwait - 51321");
		distinationMap.put(3854,"Kwa Ibo Terminal - Nigeria - 75389");
		distinationMap.put(3609,"Kwajalein - Marshall Is - 68190");
		distinationMap.put(3222,"Kwangyang - South Korea - 58031");
		distinationMap.put(3478,"Kwinana - Australia - 60234");
		distinationMap.put(2323,"Kyllini - Greece - 48400");
		distinationMap.put(2390,"Kymassi - Greece - 48459");
		distinationMap.put(1548,"Kyndby - Denmark - 40918");
		distinationMap.put(1549,"Kyndbyvaerkets Havn - Denmark - 40918");
		distinationMap.put(4144,"Kyrgyzstan - Kyrgyzstan - 4635");
		distinationMap.put(473,"La Barra de Rio Grande - Nicaragua - 21900");
		distinationMap.put(814,"La Brea - Trinidad - 27400");
		distinationMap.put(456,"La Ceiba - Honduras - 21515");
		distinationMap.put(906,"La Ceiba - Venezuela - 30700");
		distinationMap.put(2084,"La Coruna - Spain - 47021");
		distinationMap.put(744,"La Fitteau - Haiti - 24553");
		distinationMap.put(3695,"La Goulette - Tunisia - 72310");
		distinationMap.put(937,"La Guaira - Venezuela - 30745");
		distinationMap.put(675,"La Habana - Cuba - 23944");
		distinationMap.put(667,"La Isabela de Sagua - Cuba - 23937");
		distinationMap.put(997,"La Libertad - Ecuador - 33136");
		distinationMap.put(449,"La Libertad - El Salvador - 21199");
		distinationMap.put(1862,"La Mailleraye - France - 42700");
		distinationMap.put(1931,"La Nouvelle - France - 42799");
		distinationMap.put(1890,"La Pallice - France - 42733");
		distinationMap.put(534,"La Palma - Panama - 22577");
		distinationMap.put(1035,"La Pampilla - Peru - 33340");
		distinationMap.put(363,"La Paz - Mexico - 20105");
		distinationMap.put(1211,"La Plata - Argentina - 35737");
		distinationMap.put(777,"La Romana - Dominican Republic - 24743");
		distinationMap.put(938,"La Salina - Venezuela - 30753");
		distinationMap.put(2118,"La Salineta - Spain - 47070");
		distinationMap.put(1932,"La Seyne - France - 42799");
		distinationMap.put(1933,"La Seyne sur Mer - France - 42799");
		distinationMap.put(3697,"La Skhira - Tunisia - 72315");
		distinationMap.put(3698,"La Skira - Tunisia - 72315");
		distinationMap.put(2208,"La Spezia - Italy - 47531");
		distinationMap.put(869,"La Trinite - Martinique - 28399");
		distinationMap.put(447,"La Union - El Salvador - 21137");
		distinationMap.put(3761,"Laayoune - Western Sahara - 73701");
		distinationMap.put(742,"Labadee - Haiti - 24515");
		distinationMap.put(3621,"Labasa - Fiji - 68630");
		distinationMap.put(2827,"Labuan - Malaysia - 55717");
		distinationMap.put(129,"Ladysmith, BC - Canada - 12209");
		distinationMap.put(3520,"Lae - Papua New Guinea - 60441");
		distinationMap.put(2783,"Laem Chabang - Thailand - 54930");
		distinationMap.put(745,"Lafiteau - Haiti - 24553");
		distinationMap.put(2324,"Lagos - Greece - 48400");
		distinationMap.put(3845,"Lagos - Nigeria - 75367");
		distinationMap.put(2153,"Lagos - Portugal - 47100");
		distinationMap.put(523,"Laguna de Chiriqui - Panama - 22520");
		distinationMap.put(474,"Laguna de Perlas - Nicaragua - 21900");
		distinationMap.put(388,"Laguna de Terminos - Mexico - 20157");
		distinationMap.put(338,"Laguna San Ignacio - Mexico - 20100");
		distinationMap.put(907,"Lagunillas - Venezuela - 30700");
		distinationMap.put(2828,"Lahad Datu - Malaysia - 55725");
		distinationMap.put(4499,"LAKE CHARLES - United States - 2017");
		distinationMap.put(4,"Lakeview, ONT - Canada - 01530");
		distinationMap.put(2904,"Lalang Terminal - Indonesia - 56038");
		distinationMap.put(3622,"Lambasa - Fiji - 68630");
		distinationMap.put(41,"Lambton, ONT - Canada - 05515");
		distinationMap.put(3022,"Lamon Anchorage - Philippines - 56500");
		distinationMap.put(42,"Lampton, ONT - Canada - 05515");
		distinationMap.put(3943,"Lamu, Lamu Is - Kenya - 77999");
		distinationMap.put(4688,"LANCASTER - United States - 3430");
		distinationMap.put(1590,"Land&#39;s End - United Kingdom - 41249");
		distinationMap.put(1387,"Langesund - Norway - 40300");
		distinationMap.put(1389,"Langstein - Norway - 40300");
		distinationMap.put(1346,"Lanskrona - Sweden - 40150");
		distinationMap.put(4191,"Laos - Laos - 5530");
		distinationMap.put(1473,"LappajarviI - Finland - 40504");
		distinationMap.put(1474,"Lappohja - Finland - 40504");
		distinationMap.put(3641,"Larache - Morocco - 71400");
		distinationMap.put(3001,"Larap Bay - Philippines - 56500");
		distinationMap.put(4510,"LAREDO - United States - 2304");
		distinationMap.put(2500,"Larnaca - Cyprus - 49133");
		distinationMap.put(1754,"Larne - United Kingdom - 41800");
		distinationMap.put(1424,"Larvik - Norway - 40335");
		distinationMap.put(768,"Las Calderas - Dominican Republic - 24731");
		distinationMap.put(531,"Las Minas Bay - Panama - 22565");
		distinationMap.put(2120,"Las Palmas - Spain - 47071");
		distinationMap.put(939,"Las Piedras - Venezuela - 30755");
		distinationMap.put(1091,"Las Salinas - Chile - 33797");
		distinationMap.put(4548,"LAS VEGAS - United States - 2722");
		distinationMap.put(2509,"Latakia - Syria - 50215");
		distinationMap.put(2510,"Lattakia - Syria - 50215");
		distinationMap.put(4134,"Latvia - Latvia - 4490");
		distinationMap.put(3500,"Launceston - Australia - 60297");
		distinationMap.put(4895,"LAUREL - United States - 1305");
		distinationMap.put(4606,"LAURIER - United States - 3016");
		distinationMap.put(3623,"Lautoka - Fiji - 68630");
		distinationMap.put(3624,"Lautoka Harbor - Fiji - 68630");
		distinationMap.put(2559,"Lavan Island - Iran - 50769");
		distinationMap.put(1913,"L&#39;Avera - France - 42780");
		distinationMap.put(1912,"Lavera - France - 42780");
		distinationMap.put(2865,"Lawe Lawe Terminal - Indonesia - 56010");
		distinationMap.put(4862,"LAWRENCE - United States - 0416");
		distinationMap.put(365,"Lazaro Cardenas - Mexico - 20107");
		distinationMap.put(1892,"Le Boucau - France - 42735");
		distinationMap.put(870,"Le Francois - Martinique - 28399");
		distinationMap.put(1894,"Le Havre - France - 42737");
		distinationMap.put(871,"Le Lamentin - Martinique - 28399");
		distinationMap.put(872,"Le Marin - Martinique - 28399");
		distinationMap.put(733,"Le Mole St. Nicholas - Haiti - 24500");
		distinationMap.put(1863,"Le Petit Quevilly - France - 42700");
		distinationMap.put(873,"Le Robert - Martinique - 28399");
		distinationMap.put(1864,"Le Trait (River Seine) - France - 42700");
		distinationMap.put(1865,"Le Treport - France - 42700");
		distinationMap.put(1895,"Le Verdon - France - 42742");
		distinationMap.put(36,"Leamington, ONT - Canada - 03508");
		distinationMap.put(3002,"Lebak - Philippines - 56500");
		distinationMap.put(4168,"Lebanon - Lebanon - 5040");
		distinationMap.put(4841,"LEBANON AIRPORT - United States - 0181");
		distinationMap.put(1056,"Lebu - Chile - 33700");
		distinationMap.put(4367,"LEEDS - United Kingdom - 41323");
		distinationMap.put(4368,"LEEDS VIA FELIXSTOWE - United Kingdom - 41323");
		distinationMap.put(4369,"Leeds via Felixstowe - United Kingdom - 43323");
		distinationMap.put(3071,"Legaspi - Philippines - 56542");
		distinationMap.put(2210,"Leghorn - Italy - 47537");
		distinationMap.put(1732,"Leith - United Kingdom - 41675");
		distinationMap.put(2158,"Leixoes - Portugal - 47123");
		distinationMap.put(2908,"Lembar - Indonesia - 56041");
		distinationMap.put(677,"Lengua de Pajaro - Cuba - 23961");
		distinationMap.put(2002,"Leningrad - Russia - 46215");
		distinationMap.put(734,"Leogane - Haiti - 24500");
		distinationMap.put(4292,"Lesotho - Lesotho - 7990");
		distinationMap.put(893,"Leticia - Colombia - 30198");
		distinationMap.put(24,"Levis, QUE - Canada - 01832");
		distinationMap.put(3625,"Levuka - Fiji - 68630");
		distinationMap.put(3003,"Leyte - Philippines - 56500");
		distinationMap.put(2960,"Lhokseumawe - Indonesia - 56099");
		distinationMap.put(3004,"Lianga - Philippines - 56500");
		distinationMap.put(4972,"LIANHUASHAN - CHINA - 58201");
		distinationMap.put(3145,"Lianyungang - China - 57025");
		distinationMap.put(4265,"Liberia - Liberia - 7650");
		distinationMap.put(3858,"Libreville - Gabon - 75501");
		distinationMap.put(4237,"Libya - Libya - 7250");
		distinationMap.put(2232,"Licata - Italy - 47558");
		distinationMap.put(2260,"Lido - Italy - 47595");
		distinationMap.put(4131,"Liechtenstein - Liechtenstein - 4411");
		distinationMap.put(3146,"Lien Yin Chiang - China - 57025");
		distinationMap.put(3469,"Liezen - Australia - 60217");
		distinationMap.put(4381,"Lima - Peru - 33300");
		distinationMap.put(2502,"Limassol - Cyprus - 49135");
		distinationMap.put(3087,"Limay - Philippines - 56592");
		distinationMap.put(3783,"Limbe - Cameroon - 74298");
		distinationMap.put(3784,"Limboh Terminal - Cameroon - 74298");
		distinationMap.put(1772,"Limerick - Ireland - 41904");
		distinationMap.put(4834,"LIMESTONE - United States - 0118");
		distinationMap.put(1342,"Limhamn - Sweden - 40143");
		distinationMap.put(2325,"Limin Sirou - Greece - 48400");
		distinationMap.put(495,"Limon - Costa Rica - 22313");
		distinationMap.put(457,"Limon - Honduras - 21519");
		distinationMap.put(2326,"Limon Zakinthou - Greece - 48400");
		distinationMap.put(963,"Linden - Guyana - 31215");
		distinationMap.put(3954,"Lindi - Tanzania - 78399");
		distinationMap.put(1519,"Lindo - Denmark - 40900");
		distinationMap.put(2544,"Lingah - Iran - 50700");
		distinationMap.put(2545,"Lingeh - Iran - 50700");
		distinationMap.put(2217,"Lipari - Italy - 47541");
		distinationMap.put(1079,"Lirquen - Chile - 33751");
		distinationMap.put(2160,"Lisboa - Portugal - 47125");
		distinationMap.put(2161,"Lisbon - Portugal - 47125");
		distinationMap.put(4135,"Lithuania - Lithuania - 4510");
		distinationMap.put(50,"Little Current, ONT - Canada - 06748");
		distinationMap.put(249,"Little Narrows, CBI - Canada - 13884");
		distinationMap.put(710,"Little Pedro Bluff - Jamaica - 24165");
		distinationMap.put(3825,"Little Popo - Togo - 75200");
		distinationMap.put(4485,"LITTLE ROCK/NORTH LITTLE ROCK - United States - 2003");
		distinationMap.put(1666,"Littlehampton - United Kingdom - 41398");
		distinationMap.put(1591,"Liverpool - United Kingdom - 41251");
		distinationMap.put(250,"Liverpool, NS - Canada - 13887");
		distinationMap.put(426,"Livingston - Guatemala - 20500");
		distinationMap.put(2211,"Livorno - Italy - 47537");
		distinationMap.put(1287,"Ljusne - Sweden - 40100");
		distinationMap.put(1691,"Llanelli - United Kingdom - 41400");
		distinationMap.put(1692,"Llanelly - United Kingdom - 41400");
		distinationMap.put(3876,"Lobito - Angola - 76274");
		distinationMap.put(1017,"Lobos de Afuera - Peru - 33300");
		distinationMap.put(1018,"Lobos de Tierra - Peru - 33300");
		distinationMap.put(3564,"Lofung - Solomon Is - 62200");
		distinationMap.put(4863,"LOGAN AIRPORT - United States - 0417");
		distinationMap.put(1520,"Logstor - Denmark - 40900");
		distinationMap.put(1020,"Lomas - Peru - 33300");
		distinationMap.put(3885,"Lombo - Angola - 76288");
		distinationMap.put(3886,"Lombo Terminal - Angola - 76288");
		distinationMap.put(3826,"Lome - Togo - 75291");
		distinationMap.put(1626,"London - United Kingdom - 41352");
		distinationMap.put(1759,"Londonderry - United Kingdom - 41815");
		distinationMap.put(691,"Long Bay - Jamaica - 24100");
		distinationMap.put(4540,"LONG BEACH - United States - 2709");
		distinationMap.put(309,"Long Harbor, NFLD - Canada - 15255");
		distinationMap.put(584,"Long Island - Bahamas - 23635");
		distinationMap.put(310,"Long Pond Manuels, NFLD - Canada - 15260");
		distinationMap.put(707,"Longs Wharf - Jamaica - 24163");
		distinationMap.put(4584,"LONGVIEW - United States - 2905");
		distinationMap.put(4746,"LORAINE - United States - 4121");
		distinationMap.put(1897,"Lorient - France - 42743");
		distinationMap.put(2010,"Lorino - Russia - 46222");
		distinationMap.put(4538,"LOS ANGELES - United States - 2704");
		distinationMap.put(4546,"LOS ANGELES INTL. AIRPORT, LAX, LOS ANGELES - United States - 2720");
		distinationMap.put(1057,"Los Vilos - Chile - 33700");
		distinationMap.put(1058,"Lota - Chile - 33700");
		distinationMap.put(196,"Louisburg, NS - Canada - 13437");
		distinationMap.put(4743,"LOUISVILLE - United States - 4115");
		distinationMap.put(1488,"Loviisa - Finland - 40533");
		distinationMap.put(1489,"Lovisa - Finland - 40533");
		distinationMap.put(4915,"LOWELL - United States - LWL");
		distinationMap.put(4916,"LOWELL. - United States - 01850");
		distinationMap.put(1667,"Lowestoft - United Kingdom - 41398");
		distinationMap.put(3163,"Lu Shun - China - 57052");
		distinationMap.put(3877,"Luanda - Angola - 76278");
		distinationMap.put(4813,"LUBBOCK - United States - 5503");
		distinationMap.put(692,"Lucea - Jamaica - 24100");
		distinationMap.put(3863,"Lucina Terminal - Gabon - 75515");
		distinationMap.put(3453,"Lucinda - Australia - 60200");
		distinationMap.put(3162,"Luda - China - 57051");
		distinationMap.put(4018,"Luderitz - Namibia - 79299");
		distinationMap.put(3569,"Luganville - Vanuatu - 62201");
		distinationMap.put(1164,"Luis Correia - Brazil - 35198");
		distinationMap.put(4531,"LUKEVILLE - United States - 2602");
		distinationMap.put(1341,"Lulea - Sweden - 40142");
		distinationMap.put(2971,"Lumut - Brunei - 56100");
		distinationMap.put(2820,"Lumut - Malaysia - 55709");
		distinationMap.put(243,"Lunenburg, NS - Canada - 13851");
		distinationMap.put(783,"Luperon - Dominican Republic - 24774");
		distinationMap.put(3164,"Lushun - China - 57052");
		distinationMap.put(4122,"Luxembourg - Luxembourg - 4239");
		distinationMap.put(4611,"LYNDEN - United States - 3023");
		distinationMap.put(1748,"Lyness, Orkney Is - United Kingdom - 41698");
		distinationMap.put(1390,"Lyngen - Norway - 40300");
		distinationMap.put(1441,"Lysaker - Norway - 40377");
		distinationMap.put(1288,"Lysekil - Sweden - 40100");
		distinationMap.put(3541,"Lyttelton - New Zealand - 61415");
		distinationMap.put(1439,"Maaloy - Norway - 40372");
		distinationMap.put(2774,"Mab Ta Pud - Thailand - 54903");
		distinationMap.put(4199,"Macao - Macao - 5660");
		distinationMap.put(3091,"Macao - Macau - 56649");
		distinationMap.put(1132,"Macapa - Brazil - 35165");
		distinationMap.put(2887,"Macassar - Indonesia - 56027");
		distinationMap.put(3092,"Macau - Macau - 56649");
		distinationMap.put(4159,"Macedonia (Skopje) - Macedonia (Skopje) - 4794");
		distinationMap.put(1117,"Maceio - Brazil - 35141");
		distinationMap.put(185,"Maces Bay, NB - Canada - 13400");
		distinationMap.put(3462,"Mackay - Australia - 60204");
		distinationMap.put(4716,"MACKINAC ISLAND - United States - 3820");
		distinationMap.put(3005,"Maco - Philippines - 56500");
		distinationMap.put(4280,"Madagascar - Madagascar - 7880");
		distinationMap.put(3507,"Madang - Papua New Guinea - 60400");
		distinationMap.put(4829,"MADAWASKA - United States - 0109");
		distinationMap.put(2717,"Madras - India - 53357");
		distinationMap.put(1095,"Madre de Deus - Brazil - 35113");
		distinationMap.put(1213,"Madryn - Argentina - 35740");
		distinationMap.put(2013,"Magadan - Russia - 46232");
		distinationMap.put(2014,"Magadansky - Russia - 46232");
		distinationMap.put(3006,"Magallanes - Philippines - 56500");
		distinationMap.put(398,"Mahahual - Mexico - 20174");
		distinationMap.put(3978,"Mahajanga - Madagascar - 78800");
		distinationMap.put(2685,"Mahe - India - 53300");
		distinationMap.put(3686,"Mahedia - Tunisia - 72300");
		distinationMap.put(4676,"MAIDA - United States - 3416");
		distinationMap.put(4820,"MAIL SHIPMENT - United States - 8000");
		distinationMap.put(1866,"Mailleraye - France - 42700");
		distinationMap.put(1966,"Mainz - Germany - 42899");
		distinationMap.put(3363,"Maizuru - Japan - 58848");
		distinationMap.put(3364,"Maizuru Ko - Japan - 58848");
		distinationMap.put(2110,"Majorca - Spain - 47066");
		distinationMap.put(3979,"Majunga - Madagascar - 78800");
		distinationMap.put(3610,"Majuro Atoll - Marshall Is - 68190");
		distinationMap.put(3093,"Makao - Macau - 56649");
		distinationMap.put(3007,"Makar - Philippines - 56500");
		distinationMap.put(2888,"Makassar - Indonesia - 56027");
		distinationMap.put(3601,"Makatea - French Polyn - 64181");
		distinationMap.put(3270,"Makiyama - Japan - 58800");
		distinationMap.put(1021,"Mala - Peru - 33300");
		distinationMap.put(3766,"Malabo - Equatorial Gui - 73801");
		distinationMap.put(2807,"Malacca - Malaysia - 55700");
		distinationMap.put(2126,"Malaga - Spain - 47076");
		distinationMap.put(4291,"Malawi - Malawi - 7970");
		distinationMap.put(4193,"Malaysia - Malaysia - 5570");
		distinationMap.put(4201,"Maldives - Maldives - 5683");
		distinationMap.put(3094,"Male, Male Island - Maldives - 56805");
		distinationMap.put(1113,"Malhado - Brazil - 35137");
		distinationMap.put(4245,"Mali - Mali - 7450");
		distinationMap.put(2850,"Malili - Indonesia - 56000");
		distinationMap.put(3008,"Malitbog - Philippines - 56500");
		distinationMap.put(1343,"Malmo - Sweden - 40143");
		distinationMap.put(3881,"Malongo Oil Terminal - Angola - 76282");
		distinationMap.put(4152,"Malta - Malta - 4730");
		distinationMap.put(3009,"Mambulao - Philippines - 56500");
		distinationMap.put(883,"Mamonal - Colombia - 30125");
		distinationMap.put(2893,"Manado - Indonesia - 56030");
		distinationMap.put(3980,"Manakara - Madagascar - 78800");
		distinationMap.put(2680,"Manama - Bahrain - 52502");
		distinationMap.put(3981,"Mananjari - Madagascar - 78800");
		distinationMap.put(3982,"Mananjary - Madagascar - 78800");
		distinationMap.put(3983,"Mananzhari - Madagascar - 78800");
		distinationMap.put(640,"Manati - Cuba - 23900");
		distinationMap.put(1118,"Manaus - Brazil - 35144");
		distinationMap.put(983,"Manchala - Ecuador - 33100");
		distinationMap.put(1593,"Manchester - United Kingdom - 41253");
		distinationMap.put(689,"Manchioneal - Jamaica - 24100");
		distinationMap.put(2687,"Mandvi - India - 53300");
		distinationMap.put(2253,"Manfredonia - Italy - 47582");
		distinationMap.put(2709,"Mangalore - India - 53343");
		distinationMap.put(3010,"Mangarin - Philippines - 56500");
		distinationMap.put(984,"Manglaralto - Ecuador - 33100");
		distinationMap.put(3543,"Mangonui - New Zealand - 61416");
		distinationMap.put(4886,"Manheim - United States - 4601");
		distinationMap.put(3073,"Manila - Philippines - 56549");
		distinationMap.put(4700,"MANITOWOC - United States - 3706");
		distinationMap.put(680,"Manopla - Cuba - 23979");
		distinationMap.put(998,"Manta - Ecuador - 33151");
		distinationMap.put(1499,"Mantyluoto - Finland - 40551");
		distinationMap.put(641,"Manzanillo - Cuba - 23900");
		distinationMap.put(778,"Manzanillo - Dominican Republic - 24745");
		distinationMap.put(368,"Manzanillo - Mexico - 20120");
		distinationMap.put(528,"Manzanillo - Panama - 22556");
		distinationMap.put(779,"Manzanillo Bay - Dominican Republic - 24745");
		distinationMap.put(2775,"Map Ta Phut - Thailand - 54903");
		distinationMap.put(112,"Maple Bay, BC - Canada - 12200");
		distinationMap.put(3967,"Maputo - Mozambique - 78717");
		distinationMap.put(1212,"Mar del Plata - Argentina - 35739");
		distinationMap.put(941,"Maracaibo - Venezuela - 30759");
		distinationMap.put(2327,"Marathon - Greece - 48400");
		distinationMap.put(73,"Marathon, ONT - Canada - 09601");
		distinationMap.put(642,"Maravi - Cuba - 23900");
		distinationMap.put(1816,"Mardejk - Netherlands - 42140");
		distinationMap.put(3011,"Margosatubig - Philippines - 56500");
		distinationMap.put(1461,"Mariehamn - Finland - 40500");
		distinationMap.put(643,"Mariel - Cuba - 23900");
		distinationMap.put(863,"Marigot, St. Martin - Guadeloupe - 28320");
		distinationMap.put(2072,"Marin - Spain - 47000");
		distinationMap.put(2207,"Marina di Carrara - Italy - 47528");
		distinationMap.put(2051,"Mariupol - Ukraine - 46276");
		distinationMap.put(3072,"Mariveles - Philippines - 56545");
		distinationMap.put(4435,"MARKUS HOOK - United States - 1118");
		distinationMap.put(2707,"Marmagao Bay - India - 53340");
		distinationMap.put(94,"Marmorilik - Greenland - 10100");
		distinationMap.put(3602,"Marquesas Islands - French Polyn - 64191");
		distinationMap.put(4710,"MARQUETTE - United States - 3809");
		distinationMap.put(3707,"Marsa al Brega - Libya - 72515");
		distinationMap.put(3709,"Marsa al Hariga - Libya - 72516");
		distinationMap.put(3708,"Marsa el Brega - Libya - 72515");
		distinationMap.put(3710,"Marsa el Hariga - Libya - 72516");
	}
	void fillMap2() {
	
		distinationMap.put(2230,"Marsala - Italy - 47558");
		distinationMap.put(2183,"Marsaxlokk - Malta - 47306");
		distinationMap.put(1914,"Marseille - France - 42782");
		distinationMap.put(593,"Marsh Harbour - Bahamas - 23640");
		distinationMap.put(4228,"Marshall Islands - Marshall Islands - 6810");
		distinationMap.put(4566,"MARTINEZ - United States - 2820");
		distinationMap.put(4096,"Martinique - Martinique - 2839");
		distinationMap.put(3271,"Marugame - Japan - 58800");
		distinationMap.put(307,"Marystown, NFLD - Canada - 15233");
		distinationMap.put(3225,"Masan - South Korea - 58033");
		distinationMap.put(3012,"Masao - Philippines - 56500");
		distinationMap.put(3013,"Masbate - Philippines - 56500");
		distinationMap.put(3075,"Maseru - Philippines - 56554");
		distinationMap.put(3074,"Masinloc - Philippines - 56552");
		distinationMap.put(2662,"Masirah - Oman - 52315");
		distinationMap.put(2663,"Masirah Island - Oman - 52315");
		distinationMap.put(4893,"MASPETH - United States - 1005");
		distinationMap.put(3935,"Massaua - Eritrea - 77409");
		distinationMap.put(3936,"Massawa - Eritrea - 77409");
		distinationMap.put(4868,"MASSENA - United States - 0704");
		distinationMap.put(130,"Masset, BC - Canada - 12210");
		distinationMap.put(2729,"Masulipatam - India - 53398");
		distinationMap.put(3921,"Matadi - Congo Kinshasha - 76637");
		distinationMap.put(644,"Matahambre - Cuba - 23900");
		distinationMap.put(417,"Matamoros - Mexico - 20195");
		distinationMap.put(260,"Matane, QUE - Canada - 14070");
		distinationMap.put(645,"Matanzas - Cuba - 23900");
		distinationMap.put(942,"Matanzas - Venezuela - 30760");
		distinationMap.put(1036,"Matarani - Peru - 33354");
		distinationMap.put(3592,"Mata-Utu, Futuna - Wallis - 64131");
		distinationMap.put(2666,"Matrah - Oman - 52325");
		distinationMap.put(3272,"Matsue - Japan - 58800");
		distinationMap.put(3362,"Matsunaga - Japan - 58847");
		distinationMap.put(3304,"Matsushima - Japan - 58806");
		distinationMap.put(3273,"Matsuura - Japan - 58800");
		distinationMap.put(3365,"Matsuyama - Japan - 58849");
		distinationMap.put(605,"Matthew Town - Bahamas - 23653");
		distinationMap.put(3014,"Mauban - Philippines - 56500");
		distinationMap.put(4242,"Mauritania - Mauritania - 7410");
		distinationMap.put(4278,"Mauritius - Mauritius - 7850");
		distinationMap.put(572,"Mayaguana Island - Bahamas - 23600");
		distinationMap.put(4781,"MAYAGUEZ - United States - 4907");
		distinationMap.put(646,"Mayari - Cuba - 23900");
		distinationMap.put(4281,"Mayotte - Mayotte - 7881");
		distinationMap.put(3642,"Mazagan - Morocco - 71400");
		distinationMap.put(369,"Mazatlan - Mexico - 20122");
		distinationMap.put(113,"McBride Bay, BC - Canada - 12200");
		distinationMap.put(966,"McKenzie - Guyana - 31235");
		distinationMap.put(648,"Media Luna - Cuba - 23900");
		distinationMap.put(3015,"Medina - Philippines - 56500");
		distinationMap.put(2384,"Megara - Greece - 48454");
		distinationMap.put(1059,"Mejillones del Sur - Chile - 33700");
		distinationMap.put(2808,"Melaka - Malaysia - 55700");
		distinationMap.put(3480,"Melbourne - Australia - 60237");
		distinationMap.put(4476,"MELBOURNE REGIONAL AIRPORT - United States - 1885");
		distinationMap.put(51,"Meldrum Bay - Canada - 06766");
		distinationMap.put(2136,"Melilla - Spain - 47095");
		distinationMap.put(1391,"Melo - Norway - 40300");
		distinationMap.put(1392,"Meloy - Norway - 40300");
		distinationMap.put(4866,"MELVILLE - United States - 0503");
		distinationMap.put(1289,"Mem - Sweden - 40100");
		distinationMap.put(1981,"Memel - Lithuania - 45101");
		distinationMap.put(4488,"MEMPHIS - United States - 2006");
		distinationMap.put(3687,"Menzel Bourguiba - Tunisia - 72300");
		distinationMap.put(2905,"Merak - Indonesia - 56039");
		distinationMap.put(3016,"Mercedes - Philippines - 56500");
		distinationMap.put(3663,"Mers El Kebir - Algeria - 72100");
		distinationMap.put(3729,"Mersa el Hamra - Egypt - 72906");
		distinationMap.put(2456,"Mersin - Turkey - 48938");
		distinationMap.put(2233,"Messina - Italy - 47558");
		distinationMap.put(95,"Mesters Vig - Greenland - 10100");
		distinationMap.put(96,"Mestersvig - Greenland - 10100");
		distinationMap.put(3664,"Mestghanem - Algeria - 72100");
		distinationMap.put(4612,"METALINE FALLS - United States - 3025");
		distinationMap.put(248,"Meteghan, NS - Canada - 13870");
		distinationMap.put(1749,"Methil - United Kingdom - 41698");
		distinationMap.put(4066,"Mexico - Mexico - 2010");
		distinationMap.put(4792,"MIAMI - United States - 5201");
		distinationMap.put(4797,"MIAMI INTL. AIRPORT,MIAMI - United States - 5206");
		distinationMap.put(71,"Michipicoten Harbor, ONT - Canada - 09555");
		distinationMap.put(72,"Michipicoten, ONT. - Canada - 09555");
		distinationMap.put(1799,"Middelburg - Netherlands - 42100");
		distinationMap.put(1800,"Middleburg - Netherlands - 42100");
		distinationMap.put(1627,"Middlesbrough - United Kingdom - 41355");
		distinationMap.put(4818,"MIDLAND INTERNATIONAL AIRPORT - United States - 5582");
		distinationMap.put(3274,"Mihara - Japan - 58800");
		distinationMap.put(3368,"Miike - Japan - 58851");
		distinationMap.put(3955,"Mikindani - Tanzania - 78399");
		distinationMap.put(2391,"Mikonos - Greece - 48460");
		distinationMap.put(2374,"Milaki - Greece - 48449");
		distinationMap.put(2223,"Milazzo - Italy - 47550");
		distinationMap.put(1697,"Milford Haven - United Kingdom - 41446");
		distinationMap.put(4044,"Military-Al Zubair - Iraq - 92013");
		distinationMap.put(4048,"Military-Aschaffenburg - Germany - 92017");
		distinationMap.put(4037,"Military-Bass River Terminal - Nigeria - 92006");
		distinationMap.put(4036,"Military-Escravos - Nigeria - 92005");
		distinationMap.put(4035,"Military-Germersheim - Germany - 92004");
		distinationMap.put(4039,"Military-Guangzhou - China - 92008");
		distinationMap.put(4038,"Military-Hsinhaing - China - 92007");
		distinationMap.put(4043,"Military-Kajang - Malaysia - 92012");
		distinationMap.put(4034,"Military-Mannheim - Germany - 92003");
		distinationMap.put(4049,"Military-Mina Qaboos - Oman - 92018");
		distinationMap.put(4050,"Military-Muscat - Oman - 92019");
		distinationMap.put(4046,"Military-Mykolayiv - Ukraine - 92015");
		distinationMap.put(4033,"Military-Naha - Japan - 92002");
		distinationMap.put(4045,"Military-Oktyabrsk - Ukraine - 92014");
		distinationMap.put(4042,"Military-Port Kelang - Malaysia - 92011");
		distinationMap.put(4041,"Military-Quingdao - China - 92010");
		distinationMap.put(4047,"Military-Sfax - Tunisia - 92016");
		distinationMap.put(4040,"Military-Tainjin - China - 92009");
		distinationMap.put(4032,"Military-Yokohama - Japan - 92001");
		distinationMap.put(3448,"Milner Bay - Australia - 60200");
		distinationMap.put(2406,"Milos Island - Greece - 48468");
		distinationMap.put(4942,"Milroy - United States - 1303");
		distinationMap.put(4943,"MILROY / B - United States - 1303");
		distinationMap.put(4924,"Milton, PA - United States - 1001");
		distinationMap.put(4698,"MILWAUKEE - United States - 3701");
		distinationMap.put(2664,"Mina Abd Fahl - Oman - 52320");
		distinationMap.put(2582,"Mina al Ahmadi - Kuwait - 51323");
		distinationMap.put(2525,"Mina al Bakr - Iraq - 50505");
		distinationMap.put(2665,"Mina al Fahal - Oman - 52320");
		distinationMap.put(3731,"Mina Dumyat - Egypt - 72912");
		distinationMap.put(2643,"Mina Khalid - United Arab Em - 52070");
		distinationMap.put(2667,"Mina Qaboos - Oman - 52325");
		distinationMap.put(2668,"Mina Qabus - Oman - 52325");
		distinationMap.put(2673,"Mina Raysut - Oman - 52330");
		distinationMap.put(2622,"Mina Saqr - United Arab Em - 52000");
		distinationMap.put(2583,"Mina Saud - Kuwait - 51330");
		distinationMap.put(2678,"Mina Sulman - Bahrain - 52501");
		distinationMap.put(2584,"Mina Suud - Kuwait - 51330");
		distinationMap.put(2630,"Mina Zayed - United Arab Em - 52001");
		distinationMap.put(3366,"Minamata - Japan - 58850");
		distinationMap.put(649,"Minas de Matahambre - Cuba - 23900");
		distinationMap.put(400,"Minatitlan - Mexico - 20181");
		distinationMap.put(3900,"Mindelo - Cape Verde - 76465");
		distinationMap.put(515,"Mindi Dyke - Panama - 22500");
		distinationMap.put(4690,"MINNEAPOLIS, ST.PAUL - United States - 3501");
		distinationMap.put(4905,"Minnesota - United States - 1001");
		distinationMap.put(4306,"MINSK - BELARUS - 0001");
		distinationMap.put(4307,"Minsk - Belarus - 44911");
		distinationMap.put(4328,"Minsk - Belarus - 45101");
		distinationMap.put(551,"Miraflores Locks - Panama - 22599");
		distinationMap.put(746,"Miragoane - Haiti - 24559");
		distinationMap.put(2829,"Miri - Malaysia - 55731");
		distinationMap.put(3392,"Misaki - Japan - 58866");
		distinationMap.put(3076,"Misamis - Philippines - 56556");
		distinationMap.put(3313,"Mishima - Japan - 58812");
		distinationMap.put(167,"Mission, BC - Canada - 12490");
		distinationMap.put(5,"Mississauga, ONT - Canada - 01530");
		distinationMap.put(1668,"Mistley - United Kingdom - 41398");
		distinationMap.put(3369,"Misumi - Japan - 58852");
		distinationMap.put(4346,"MISURATA - LIBYA - 72500");
		distinationMap.put(3275,"Mitajiri - Japan - 58800");
		distinationMap.put(63,"Mitchell Bay, ONT - Canada - 08530");
		distinationMap.put(2394,"Mitilini - Greece - 48462");
		distinationMap.put(3937,"Mitsiwa - Eritrea - 77409");
		distinationMap.put(2396,"Mitylene - Greece - 48462");
		distinationMap.put(3370,"Miya Ko - Japan - 58853");
		distinationMap.put(3371,"Miyako - Japan - 58853");
		distinationMap.put(3372,"Miyako Ko - Japan - 58853");
		distinationMap.put(3373,"Mizushima - Japan - 58854");
		distinationMap.put(3374,"Mizusima - Japan - 58854");
		distinationMap.put(1437,"Mo i Rana - Norway - 40370");
		distinationMap.put(650,"Moa - Cuba - 23900");
		distinationMap.put(3923,"Moanda Terminal - Congo Kinshasha - 76639");
		distinationMap.put(4478,"MOBILE - United States - 1901");
		distinationMap.put(2657,"Mocha - Yemen - 52125");
		distinationMap.put(3963,"Mocimboa de Praia - Mozambique - 78700");
		distinationMap.put(972,"Moengo - Suriname - 31501");
		distinationMap.put(1811,"Moerdjik - Netherlands - 42119");
		distinationMap.put(3926,"Mogadiscio - Somalia - 77051");
		distinationMap.put(3927,"Mogadishu - Somalia - 77051");
		distinationMap.put(3643,"Mogador - Morocco - 71400");
		distinationMap.put(3345,"Mogi - Japan - 58835");
		distinationMap.put(3227,"Mogpo - South Korea - 58035");
		distinationMap.put(3651,"Mohammedia - Morocco - 71418");
		distinationMap.put(498,"Moin - Costa Rica - 22315");
		distinationMap.put(3346,"Moji - Japan - 58835");
		distinationMap.put(2658,"Mokha - Yemen - 52125");
		distinationMap.put(3228,"Mokpo - South Korea - 58035");
		distinationMap.put(4145,"Moldova - Moldova - 4641");
		distinationMap.put(1393,"Moldtustranda - Norway - 40300");
		distinationMap.put(2265,"Molfetta - Italy - 47598");
		distinationMap.put(1037,"Mollendo - Peru - 33355");
		distinationMap.put(2266,"Molo di Bari - Italy - 47598");
		distinationMap.put(1996,"Molotovsk - Russia - 46200");
		distinationMap.put(3941,"Mombasa - Kenya - 77913");
		distinationMap.put(4124,"Monaco - Monaco - 4272");
		distinationMap.put(1780,"Money Point - Ireland - 41915");
		distinationMap.put(1781,"Moneypoint - Ireland - 41915");
		distinationMap.put(2259,"Monfalcone - Italy - 47588");
		distinationMap.put(2742,"Mongla - Bangladesh - 53800");
		distinationMap.put(4203,"Mongolia - Mongolia - 5740");
		distinationMap.put(1440,"Mongstad - Norway - 40373");
		distinationMap.put(2267,"Monopoli - Italy - 47598");
		distinationMap.put(3918,"Monrovia - Liberia - 76529");
		distinationMap.put(253,"Mont Louis, QUE - Canada - 14021");
		distinationMap.put(3518,"Montagu - Papua New Guinea - 60440");
		distinationMap.put(279,"Montague, PEI - Canada - 14472");
		distinationMap.put(1927,"Monte Carlo - Monaco - 42797");
		distinationMap.put(756,"Monte Cristi - Dominican Republic - 24700");
		distinationMap.put(704,"Montego Bay - Jamaica - 24145");
		distinationMap.put(4558,"MONTEREY - United States - 2805");
		distinationMap.put(1187,"Montevideo - Uruguay - 35525");
		distinationMap.put(1898,"Montoir - France - 42745");
		distinationMap.put(4894,"Montreal - United States - 01822");
		distinationMap.put(22,"Montreal, QUE - Canada - 01822");
		distinationMap.put(1734,"Montrose - United Kingdom - 41681");
		distinationMap.put(4086,"Montserrat - Montserrat - 2485");
		distinationMap.put(693,"Morant Bay - Jamaica - 24100");
		distinationMap.put(4656,"MORGAN - United States - 3319");
		distinationMap.put(4483,"MORGAN CITY - United States - 2001");
		distinationMap.put(1867,"Morlaix - France - 42700");
		distinationMap.put(2708,"Mormugao - India - 53340");
		distinationMap.put(4234,"Morocco - Morocco - 7140");
		distinationMap.put(3988,"Morombe - Madagascar - 78800");
		distinationMap.put(940,"Moron - Venezuela - 30758");
		distinationMap.put(3984,"Morondava - Madagascar - 78800");
		distinationMap.put(3997,"Moroni - Comoros - 78900");
		distinationMap.put(2932,"Morotai - Indonesia - 56064");
		distinationMap.put(14,"Morrisburg,ONT - Canada - 01696");
		distinationMap.put(4766,"MORRISTOWN AIRPORT, NEWARK - United States - 4681");
		distinationMap.put(4545,"MORRO - United States - 2719");
		distinationMap.put(360,"Morro Redondo - Mexico - 20104");
		distinationMap.put(4315,"Moscow - Russia - 00001");
		distinationMap.put(4309,"MOSCOW - RUSSIA - 40549");
		distinationMap.put(4953,"Moscow - Russia - 45101");
		distinationMap.put(4954,"Moscow - Russia - 45101");
		distinationMap.put(2082,"Mosel - Spain - 47017");
		distinationMap.put(1438,"Moss - Norway - 40371");
		distinationMap.put(4004,"Mossel Baai - South Africa - 79100");
		distinationMap.put(4005,"Mossel Bay - South Africa - 79100");
		distinationMap.put(1165,"Mossoro - Brazil - 35198");
		distinationMap.put(3665,"Mostaganem - Algeria - 72100");
		distinationMap.put(2127,"Motril - Spain - 47077");
		distinationMap.put(3779,"Moudi Terminal - Cameroon - 74296");
		distinationMap.put(3544,"Mount Maunganui - New Zealand - 61416");
		distinationMap.put(3482,"Mourilyan Harbour - Australia - 60239");
		distinationMap.put(1765,"Moville - Ireland - 41900");
		distinationMap.put(4279,"Mozambique - Mozambique - 7870");
		distinationMap.put(3968,"Mozambique Island - Mozambique - 78725");
		distinationMap.put(3956,"Mtwara - Tanzania - 78399");
		distinationMap.put(2973,"Muara Port - Brunei - 56151");
		distinationMap.put(2623,"Mubarek Terminal - United Arab Em - 52000");
		distinationMap.put(2624,"Mubarras Island - United Arab Em - 52000");
		distinationMap.put(1108,"Mucuripe - Brazil - 35133");
		distinationMap.put(2477,"Mudania - Turkey - 48951");
		distinationMap.put(2478,"Mudanya - Turkey - 48951");
		distinationMap.put(2649,"Mukalla - Yemen - 52100");
		distinationMap.put(195,"Mulgrave, NS - Canada - 13436");
		distinationMap.put(2701,"Mumbai - India - 53312");
		distinationMap.put(4907,"Muncie - United States - 4112");
		distinationMap.put(3565,"Munda - Solomon Is - 62200");
		distinationMap.put(2697,"Mundra - India - 53306");
		distinationMap.put(2743,"Mungla Anchorage - Bangladesh - 53800");
		distinationMap.put(1131,"Munguba - Brazil - 35164");
		distinationMap.put(1290,"Munksund - Sweden - 40100");
		distinationMap.put(2856,"Muntok - Indonesia - 56003");
		distinationMap.put(3928,"Muqdisho - Somalia - 77051");
		distinationMap.put(4908,"Murfreesbo - United States - 20010");
		distinationMap.put(1999,"Murmansk - Russia - 46209");
		distinationMap.put(3375,"Muroran - Japan - 58855");
		distinationMap.put(2616,"Musayid - Qatar - 51825");
		distinationMap.put(2669,"Muscat - Oman - 52325");
		distinationMap.put(4712,"MUSKEGON - United States - 3815");
		distinationMap.put(2670,"Musqat - Oman - 52325");
		distinationMap.put(3998,"Mutsamudu - Comoros - 78900");
		distinationMap.put(3386,"Mutsui - Japan - 58861");
		distinationMap.put(1973,"Muuga - Estonia - 44702");
		distinationMap.put(2392,"Mykonos - Greece - 48460");
		distinationMap.put(2375,"Mylaki - Greece - 48449");
		distinationMap.put(2395,"Mytilini - Greece - 48462");
		distinationMap.put(1500,"Naantali - Finland - 40552");
		distinationMap.put(3969,"Nacala - Mozambique - 78735");
		distinationMap.put(4532,"NACO - United States - 2603");
		distinationMap.put(3650,"Nador - Morocco - 71417");
		distinationMap.put(3017,"Naga - Philippines - 56500");
		distinationMap.put(2730,"Nagapattinam - India - 53398");
		distinationMap.put(3376,"Nagasaki - Japan - 58856");
		distinationMap.put(2030,"Nagayeva - Russia - 46239");
		distinationMap.put(3377,"Nagoya - Japan - 58857");
		distinationMap.put(3378,"Nagoya Ko - Japan - 58857");
		distinationMap.put(3383,"Naha - Japan - 58860");
		distinationMap.put(3384,"Nakagusku Wan - Japan - 58860");
		distinationMap.put(3626,"Nakama - Fiji - 68630");
		distinationMap.put(2011,"Nakhodka - Russia - 46230");
		distinationMap.put(1552,"Nakskov - Denmark - 40922");
		distinationMap.put(3018,"Nalunga Island - Philippines - 56500");
		distinationMap.put(3878,"Namibe - Angola - 76279");
		distinationMap.put(4286,"Namibia - Namibia - 7920");
		distinationMap.put(1398,"Namsos - Norway - 40300");
		distinationMap.put(3128,"Nan Ching - China - 57014");
		distinationMap.put(148,"Nanaimo, BC - Canada - 12406");
		distinationMap.put(3276,"Nanao - Japan - 58800");
		distinationMap.put(3129,"Nanjing - China - 57014");
		distinationMap.put(3130,"Nanking - China - 57014");
		distinationMap.put(4982,"NANSHA - China - 57018");
		distinationMap.put(4983,"NANSHA - China - 57018");
		distinationMap.put(1899,"Nantes - France - 42749");
		distinationMap.put(46,"Nanticoke, ONT - Canada - 06645");
		distinationMap.put(3185,"Nantong - China - 57074");
		distinationMap.put(3436,"Naoetsu - Japan - 58892");
		distinationMap.put(3437,"Naoetu - Japan - 58892");
		distinationMap.put(3545,"Napier - New Zealand - 61419");
		distinationMap.put(2198,"Naples - Italy - 47507");
		distinationMap.put(2199,"Napoli - Italy - 47507");
		distinationMap.put(2762,"Narathiwat - Thailand - 54900");
		distinationMap.put(2763,"Naratives - Thailand - 54900");
		distinationMap.put(97,"Narsarssuak - Greenland - 10100");
		distinationMap.put(98,"Narssarssuaq - Greenland - 10100");
		distinationMap.put(1427,"Narvik - Norway - 40337");
		distinationMap.put(4489,"NASHVILLE - United States - 2007");
		distinationMap.put(4911,"NASHVILLE - United States - 3901");
		distinationMap.put(3019,"Nasipit - Philippines - 56500");
		distinationMap.put(4976,"NASSAU - BAHAMAS - 242");
		distinationMap.put(4977,"NASSAU - BAHAMAS - 242");
		distinationMap.put(607,"Nassau, New Providence I - Bahamas - 23661");
		distinationMap.put(3021,"Nasugbu - Philippines - 56500");
		distinationMap.put(1119,"Natal - Brazil - 35157");
		distinationMap.put(4661,"NATRONA COUNTY INTL. AIRPORT - United States - 3382");
		distinationMap.put(2328,"Nauplia - Greece - 48400");
		distinationMap.put(4231,"Nauru - Nauru - 6862");
		distinationMap.put(3630,"Nauru - Nauru - 68651");
		distinationMap.put(418,"Nautla - Mexico - 20195");
		distinationMap.put(2703,"Nava Sheva - India - 53313");
		distinationMap.put(2688,"Navlakhi - India - 53300");
		distinationMap.put(2329,"Navplion - Greece - 48400");
		distinationMap.put(4638,"NAWILIWILI-PORT ALLEN - United States - 3204");
		distinationMap.put(2330,"Naxos - Greece - 48400");
		distinationMap.put(2331,"Nea Palatia - Greece - 48400");
		distinationMap.put(4614,"NEAH BAY - United States - 3027");
		distinationMap.put(1701,"Neath - United Kingdom - 41486");
		distinationMap.put(4666,"NECHE - United States - 3404");
		distinationMap.put(1215,"Necochea - Argentina - 35741");
		distinationMap.put(1291,"Nederkalix - Sweden - 40100");
		distinationMap.put(2731,"Negapatam - India - 53398");
		distinationMap.put(694,"Negril Harbor - Jamaica - 24100");
		distinationMap.put(3632,"Neiafu - Tonga - 68682");
		distinationMap.put(3537,"Nelson - New Zealand - 61406");
		distinationMap.put(3680,"Nemours - Algeria - 72142");
		distinationMap.put(2443,"Nemrut Bay - Turkey - 48915");
		distinationMap.put(2332,"Neo Kastro - Greece - 48400");
		distinationMap.put(2333,"Neokastron - Greece - 48400");
		distinationMap.put(4185,"Nepal - Nepal - 5360");
		distinationMap.put(1251,"Neskaupstadur - Iceland - 40036");
		distinationMap.put(4120,"Netherlands - Netherlands - 4210");
		distinationMap.put(4093,"Netherlands Antilles - Netherlands Antilles - 2771");
		distinationMap.put(1983,"Neufahrwasser - Poland - 45500");
		distinationMap.put(962,"New Amsterdam - Guyana - 31202");
		distinationMap.put(4853,"NEW BEDFORD - United States - 0405");
		distinationMap.put(4225,"New Caledonia - New Caledonia - 6412");
		distinationMap.put(4902,"NEW CASTLE - United States - 4601");
		distinationMap.put(4860,"NEW HAVEN - United States - 0412");
		distinationMap.put(4861,"NEW LONDON - United States - 0413");
		distinationMap.put(2710,"New Mangalore - India - 53343");
		distinationMap.put(4484,"NEW ORLEANS - United States - 2002");
		distinationMap.put(3546,"New Plymouth - New Zealand - 61423");
		distinationMap.put(1766,"New Ross - Ireland - 41900");
		distinationMap.put(2719,"New Tuticorin - India - 53395");
		distinationMap.put(150,"New Westminster, BC - Canada - 12408");
		distinationMap.put(4422,"NEW YORK - United States - 1001");
		distinationMap.put(4215,"New Zealand - New Zealand - 6141");
		distinationMap.put(4762,"NEWARK - United States - 4601");
		distinationMap.put(4347,"Newark - United States of Ame - 00002");
		distinationMap.put(3483,"Newcastle - Australia - 60240");
		distinationMap.put(1628,"Newcastle on Tyne - United Kingdom - 41356");
		distinationMap.put(254,"Newcastle, NB - Canada - 14037");
		distinationMap.put(3110,"Newchang - China - 57000");
		distinationMap.put(3111,"Newchwang - China - 57000");
		distinationMap.put(1629,"Newhaven - United Kingdom - 41357");
		distinationMap.put(1595,"Newport - United Kingdom - 41258");
		distinationMap.put(1703,"Newport - United Kingdom - 41488");
		distinationMap.put(4864,"NEWPORT - United States - 0501");
		distinationMap.put(4581,"NEWPORT - United States - 2902");
		distinationMap.put(4444,"NEWPORT NEWS - United States - 1402");
		distinationMap.put(2797,"Nha Trang - Vietnam - 55208");
		distinationMap.put(2704,"Nhava Sheva - India - 53313");
		distinationMap.put(4071,"Nicaragua - Nicaragua - 2190");
		distinationMap.put(678,"Nicaro - Cuba - 23961");
		distinationMap.put(1919,"Nice - France - 42786");
		distinationMap.put(970,"Nieuw Nickerie - Suriname - 31500");
		distinationMap.put(4251,"Niger - Niger - 7510");
		distinationMap.put(4253,"Nigeria - Nigeria - 7530");
		distinationMap.put(1738,"Nigg Bay - United Kingdom - 41685");
		distinationMap.put(4601,"NIGHTHAWK - United States - 3011");
		distinationMap.put(651,"Niguero - Cuba - 23900");
		distinationMap.put(3380,"Niigata - Japan - 58859");
		distinationMap.put(3379,"Niihama - Japan - 58858");
		distinationMap.put(2352,"Nikola - Greece - 48405");
		distinationMap.put(1462,"Nikolaistad - Finland - 40500");
		distinationMap.put(2059,"Nikolayev - Ukraine - 46279");
		distinationMap.put(2031,"Nikolayevsk-Na-Amur - Russia - 46239");
		distinationMap.put(3141,"Ning Bo - China - 57020");
		distinationMap.put(3142,"Ningpo - China - 57020");
		distinationMap.put(4731,"NIPPON COURIER HUB - United States - 3991");
		distinationMap.put(1143,"Niteroi - Brazil - 35171");
		distinationMap.put(4218,"Niue - Niue - 6144");
		distinationMap.put(3558,"Niue Island - Niue - 61481");
		distinationMap.put(4969,"NIZHNEVARTOVSK - RUSSIA - 44911");
		distinationMap.put(1250,"Njardvik - Iceland - 40010");
		distinationMap.put(4533,"NOGALES - United States - 2604");
		distinationMap.put(2032,"Nogayevo - Russia - 46239");
		distinationMap.put(516,"Nombre de Dios - Panama - 22500");
		distinationMap.put(3023,"Nonoc Island - Philippines - 56500");
		distinationMap.put(4679,"NOONAN - United States - 3420");
		distinationMap.put(114,"Nootka, BC - Canada - 12200");
		distinationMap.put(1960,"Nordenham - Germany - 42883");
		distinationMap.put(4443,"NORFOLK - United States - 1401");
		distinationMap.put(4906,"Norfolk - United States - 4601");
		distinationMap.put(4210,"Norfolk Island - Norfolk Island - 6022");
		distinationMap.put(1292,"Norrbyskar - Sweden - 40100");
		distinationMap.put(1566,"Norresundby - Denmark - 40956");
		distinationMap.put(1344,"Norrkoping - Sweden - 40148");
		distinationMap.put(1345,"Norrsundet - Sweden - 40149");
		distinationMap.put(1669,"North &amp; South Shields - United Kingdom - 41398");
		distinationMap.put(2033,"North Cape - Russia - 46239");
		distinationMap.put(4204,"North Korea - North Korea - 5790");
		distinationMap.put(245,"North Sydney, NS - Canada - 13853");
		distinationMap.put(1641,"North Tees - United Kingdom - 41377");
		distinationMap.put(4300,"Northern Mariana Islands - Northern Mariana Islands - 9610");
		distinationMap.put(4668,"NORTHGATE - United States - 3406");
		distinationMap.put(4847,"NORTON - United States - 0211");
		distinationMap.put(4114,"Norway - Norway - 4039");
		distinationMap.put(3277,"Noshiro - Japan - 58800");
		distinationMap.put(3985,"Nossi Be - Madagascar - 78800");
		distinationMap.put(3986,"Nosy Be - Madagascar - 78800");
		distinationMap.put(3772,"Nouadhibou - Mauritania - 74165");
		distinationMap.put(3771,"Nouakchott - Mauritania - 74100");
		distinationMap.put(3590,"Noumea - New Caledonia - 64109");
		distinationMap.put(2273,"Novigrad - Croatia - 47905");
		distinationMap.put(3892,"Novo Redondo - Angola - 76299");
		distinationMap.put(4948,"NOVOPOLOTSK - BELARUS - 45101");
		distinationMap.put(2037,"Novorossiysk - Russia - 46241");
		distinationMap.put(4417,"Novosibirsk - RU - 44701");
		distinationMap.put(4379,"Novosibirsk - Russia - 44911");
		distinationMap.put(4327,"Novosibirsk - Russia - 45101");
		distinationMap.put(1984,"Nowy Port - Poland - 45500");
		distinationMap.put(4664,"NOYES - United States - 3402");
		distinationMap.put(1188,"Nueva Palmira - Uruguay - 35535");
		distinationMap.put(652,"Nuevitas - Cuba - 23900");
		distinationMap.put(3634,"Nukualofa - Tonga - 68682");
		distinationMap.put(4941,"NY PORT - United States - 1001");
		distinationMap.put(4424,"NYACC - United States - 1071");
		distinationMap.put(4769,"NYACC, JAMAICA - United States - 4771");
		distinationMap.put(1553,"Nyborg - Denmark - 40923");
		distinationMap.put(1554,"Nykobing - Denmark - 40924");
		distinationMap.put(1293,"Nynashamn - Sweden - 40100");
		distinationMap.put(1494,"Nystad - Finland - 40537");
		distinationMap.put(177,"Oak Bay, BC - Canada - 12498");
		distinationMap.put(1630,"Oakham Ness - United Kingdom - 41358");
		distinationMap.put(4561,"OAKLAND - United States - 2811");
		distinationMap.put(4720,"OAKLAND/PONTIAC AIRPORT - United States - 3881");
		distinationMap.put(55,"Oakville, ONT - Canada - 06770");
		distinationMap.put(1347,"Obbola - Sweden - 40153");
		distinationMap.put(1120,"Obidos - Brazil - 35158");
		distinationMap.put(2281,"Obrovac - Croatia - 47912");
		distinationMap.put(4477,"OCALA REGIONAL AIRPORT - United States - 1886");
		distinationMap.put(608,"Ocean Cay - Bahamas - 23665");
		distinationMap.put(705,"Ocho Rios - Jamaica - 24155");
		distinationMap.put(1394,"Odda - Norway - 40300");
		distinationMap.put(1395,"Odde - Norway - 40300");
		distinationMap.put(1567,"Odense - Denmark - 40961");
		distinationMap.put(2049,"Odessa - Ukraine - 46275");
		distinationMap.put(3024,"Odiongan - Philippines - 56500");
		distinationMap.put(3388,"Ofunato - Japan - 58863");
		distinationMap.put(3278,"Ogasawara-Gunto - Japan - 58800");
		distinationMap.put(4867,"OGDENSBURG - United States - 0701");
		distinationMap.put(3864,"Oguendjo Terminal - Gabon - 75517");
		distinationMap.put(3279,"Oh - Japan - 58800");
		distinationMap.put(809,"Oistino - Barbados - 27210");
		distinationMap.put(3303,"Oita - Japan - 58805");
		distinationMap.put(37,"Ojibway, ONT - Canada - 03510");
		distinationMap.put(2034,"Okha - Russia - 46239");
		distinationMap.put(3385,"Okinawa Island - Japan - 58860");
		distinationMap.put(4814,"OKLAHOMA CITY - United States - 5504");
		distinationMap.put(3226,"Okpo - South Korea - 58034");
		distinationMap.put(3850,"Okrika - Nigeria - 75385");
		distinationMap.put(2246,"Olbia - Italy - 47569");
		distinationMap.put(1716,"Old Kilpatrick - United Kingdom - 41600");
		distinationMap.put(2154,"Olhao - Portugal - 47100");
		distinationMap.put(4930,"Olive Bran - United States - 1601");
		distinationMap.put(3081,"Olongapo - Philippines - 56585");
		distinationMap.put(3025,"Olutanga Island - Philippines - 56500");
		distinationMap.put(4613,"OLYMPIA - United States - 3026");
		distinationMap.put(4724,"OMAHA - United States - 3903");
		distinationMap.put(3280,"Omakezaki - Japan - 58800");
		distinationMap.put(4180,"Oman - Oman - 5230");
		distinationMap.put(3281,"Ominato - Japan - 58800");
		distinationMap.put(2298,"Omisalj - Croatia - 47998");
		distinationMap.put(4317,"Omsk - Russia - 40520");
		distinationMap.put(4951,"Omsk - Russia - 40549");
		distinationMap.put(4952,"Omsk - Russia - 40549");
		distinationMap.put(4421,"Omsk - Russia - 44911");
		distinationMap.put(4331,"Omsk - Russia - 45101");
		distinationMap.put(3391,"Onagawa - Japan - 58865");
		distinationMap.put(3389,"Onahama - Japan - 58864");
		distinationMap.put(3390,"Onahama Ko - Japan - 58864");
		distinationMap.put(3851,"Onne - Nigeria - 75385");
		distinationMap.put(3282,"Onomichi - Japan - 58800");
		distinationMap.put(3231,"Onsan - South Korea - 58061");
		distinationMap.put(3204,"Onsong - North Korea - 57910");
		distinationMap.put(4547,"ONTARIO INT&#39;L AIRPORT - United States - 2721");
		distinationMap.put(4654,"OPHEIM - United States - 3317");
		distinationMap.put(3832,"Opobo - Nigeria - 75300");
		distinationMap.put(2166,"Oporto - Portugal - 47133");
		distinationMap.put(3532,"Opua - New Zealand - 61400");
		distinationMap.put(695,"Oracabessa - Jamaica - 24100");
		distinationMap.put(3681,"Oran - Algeria - 72179");
		distinationMap.put(4505,"ORANGE - United States - 2103");
		distinationMap.put(826,"Orangestad - Aruba - 27701");
		distinationMap.put(827,"Oranjestad - Aruba - 27701");
		distinationMap.put(2241,"Oristano - Italy - 47565");
		distinationMap.put(1166,"Oriximina - Brazil - 35198");
		distinationMap.put(4987,"Orkanger - Norway - Orkan");
		distinationMap.put(4466,"ORLANDO - United States - 1808");
		distinationMap.put(4467,"ORLANDO-SANFORD AIRPORT - United States - 1809");
		distinationMap.put(2353,"Ormos Ayiou Nikolaou - Greece - 48405");
		distinationMap.put(2334,"Ormos Limnis - Greece - 48400");
		distinationMap.put(2335,"Ormos Navarinou - Greece - 48400");
		distinationMap.put(2546,"Ormuz - Iran - 50700");
		distinationMap.put(1348,"Ornskoldsvik - Sweden - 40155");
		distinationMap.put(3026,"Oroquieta - Philippines - 56500");
		distinationMap.put(4609,"OROVILLE - United States - 3019");
		distinationMap.put(1294,"Ortviken - Sweden - 40100");
		distinationMap.put(1295,"Orviken - Sweden - 40100");
		distinationMap.put(3393,"Osaka - Japan - 58866");
		distinationMap.put(82,"Oshawa, ONT - Canada - 09670");
		distinationMap.put(1349,"Oskarshamn - Sweden - 40157");
		distinationMap.put(1442,"Oslo - Norway - 40377");
		distinationMap.put(1852,"Ostend - Belgium - 42351");
		distinationMap.put(1967,"Ostermoor - Germany - 42899");
		distinationMap.put(392,"Ostion - Mexico - 20171");
		distinationMap.put(1296,"Ostrand - Sweden - 40100");
		distinationMap.put(4876,"OSWEGO - United States - 0904");
		distinationMap.put(3539,"Otago Harbor - New Zealand - 61407");
		distinationMap.put(3394,"Otaru - Japan - 58867");
		distinationMap.put(4528,"OTAY MESA STATION - United States - 2506");
		distinationMap.put(438,"Other Belize Ports - Belize - 20800");
		distinationMap.put(56,"Ottawa, ONT - Canada - 07238");
		distinationMap.put(70,"Otter Island, ONT - Canada - 09554");
		distinationMap.put(1297,"Otterbacken - Sweden - 40100");
		distinationMap.put(1483,"Ouleborg - Finland - 40531");
		distinationMap.put(1484,"Oulu - Finland - 40531");
		distinationMap.put(3627,"Ovalau Island - Fiji - 68630");
		distinationMap.put(54,"Owen Sound, ONT - Canada - 06768");
		distinationMap.put(3865,"Owendo - Gabon - 75521");
		distinationMap.put(4744,"OWENSBORO,KY-EVANSVILLE - United States - 4116");
		distinationMap.put(1350,"Oxelosund - Sweden - 40159");
		distinationMap.put(828,"Paarden Baai - Aruba - 27701");
		distinationMap.put(829,"Paarden Bay - Aruba - 27701");
		distinationMap.put(1060,"Pabellon - Chile - 33700");
		distinationMap.put(1022,"Pacasmayo - Peru - 33300");
		distinationMap.put(2949,"Padang - Indonesia - 56081");
		distinationMap.put(4052,"Pago Pago Harbor - American Samoa - 95101");
		distinationMap.put(1038,"Paita - Peru - 33363");
		distinationMap.put(401,"Pajaritos - Mexico - 20184");
		distinationMap.put(3193,"Pakho - China - 57076");
		distinationMap.put(3194,"Pakhoi - China - 57076");
		distinationMap.put(4184,"Pakistan - Pakistan - 5350");
		distinationMap.put(2109,"Palamos - Spain - 47065");
		distinationMap.put(3882,"Palanca Terminal - Angola - 76283");
		distinationMap.put(4230,"Palau - Palau - 6830");
		distinationMap.put(4416,"PALDISKI - Estonia - 44700");
		distinationMap.put(2950,"Palembang - Indonesia - 56083");
		distinationMap.put(757,"Palenque - Dominican Republic - 24700");
		distinationMap.put(2224,"Palermo - Italy - 47551");
		distinationMap.put(3570,"Palikulo - Vanuatu - 62207");
		distinationMap.put(2111,"Palma de Majorca - Spain - 47066");
		distinationMap.put(653,"Palo Alto - Cuba - 23900");
		distinationMap.put(2911,"Palu - Indonesia - 56045");
		distinationMap.put(943,"Palua - Venezuela - 30761");
		distinationMap.put(3027,"Pambujan Sur - Philippines - 56500");
		distinationMap.put(908,"Pampatar - Venezuela - 30700");
		distinationMap.put(3028,"Panagan - Philippines - 56500");
		distinationMap.put(4073,"Panama - Panama - 2250");
		distinationMap.put(521,"Panama Canal - Caribbean - Panama - 22519");
		distinationMap.put(535,"Panama Canal- Pacific - Panama - 22579");
		distinationMap.put(536,"Panama City - Panama - 22579");
		distinationMap.put(4470,"PANAMA CITY - United States - 1818");
		distinationMap.put(2910,"Panarukan - Indonesia - 56043");
		distinationMap.put(2480,"Panderma - Turkey - 48963");
		distinationMap.put(2954,"Pandjang - Indonesia - 56097");
		distinationMap.put(3635,"Pangai - Tonga - 68682");
		distinationMap.put(3957,"Pangani - Tanzania - 78399");
		distinationMap.put(2857,"Pangkal Balam - Indonesia - 56004");
		distinationMap.put(2951,"Pangkalan Brandan - Indonesia - 56085");
		distinationMap.put(2952,"Pangkalan Susu - Indonesia - 56085");
		distinationMap.put(2858,"Pangkalpinang - Indonesia - 56004");
		distinationMap.put(2859,"Pangkol - Indonesia - 56004");
		distinationMap.put(2912,"Pantoloan - Indonesia - 56045");
		distinationMap.put(3594,"Papeete, Tahiti - French Polyn - 64151");
		distinationMap.put(4214,"Papua New Guinea - Papua New Guinea - 6040");
		distinationMap.put(1061,"Papudo - Chile - 33700");
		distinationMap.put(1101,"Para - Brazil - 35121");
		distinationMap.put(1023,"Paracas Bay - Peru - 33300");
		distinationMap.put(2718,"Paradip - India - 53371");
		distinationMap.put(4107,"Paraguay - Paraguay - 3530");
		distinationMap.put(552,"Paraiso - Panama - 22599");
		distinationMap.put(973,"Paramaribo - Suriname - 31523");
		distinationMap.put(1024,"Paramonga - Peru - 33300");
		distinationMap.put(1123,"Paranagua - Brazil - 35159");
		distinationMap.put(975,"Paranam - Suriname - 31524");
		distinationMap.put(791,"Parham Harbour, Antigua - Antigua - 24831");
		distinationMap.put(553,"Parida Island - Panama - 22599");
		distinationMap.put(4373,"Paris - France - 42737");
		distinationMap.put(525,"Parita - Panama - 22525");
		distinationMap.put(1127,"Parnahyba - Brazil - 35163");
		distinationMap.put(1128,"Parnaiba - Brazil - 35163");
		distinationMap.put(2347,"Paros - Greece - 48400");
		distinationMap.put(49,"Parry Sound, ONT - Canada - 06697");
		distinationMap.put(2088,"Pasages - Spain - 47027");
		distinationMap.put(2089,"Pasajes - Spain - 47027");
		distinationMap.put(4480,"PASCAGOULA - United States - 1903");
		distinationMap.put(2819,"Pasir Gudang - Malaysia - 55707");
		distinationMap.put(2926,"Pasuruan - Indonesia - 56058");
		distinationMap.put(2764,"Patani - Thailand - 54900");
		distinationMap.put(1463,"Pateniemi - Finland - 40500");
		distinationMap.put(1082,"Patillos - Chile - 33765");
		distinationMap.put(2377,"Patrai - Greece - 48451");
		distinationMap.put(2376,"Patras - Greece - 48451");
		distinationMap.put(2765,"Pattani - Thailand - 54900");
		distinationMap.put(1900,"Pauillac - France - 42751");
		distinationMap.put(4429,"PAULSBORO - United States - 1105");
		distinationMap.put(4378,"PAVLODAR - KAZAKHSTAN - 44911");
		distinationMap.put(4401,"Pavlodar - KAZAKHSTAN - 45101");
		distinationMap.put(4397,"PAVLODAR - KAZAKHSTAN - 5700");
		distinationMap.put(532,"Payardi - Panama - 22565");
		distinationMap.put(1186,"Paysandu - Uruguay - 35500");
		distinationMap.put(476,"Pearl City - Nicaragua - 21900");
		distinationMap.put(554,"Pearl Islands - Panama - 22599");
		distinationMap.put(3964,"Pebane - Mozambique - 78700");
		distinationMap.put(1097,"Pecem - Brazil - 35120");
		distinationMap.put(538,"Pedregal - Panama - 22582");
		distinationMap.put(3112,"Pei hai Anchorage - China - 57000");
		distinationMap.put(2927,"Pekalongan - Indonesia - 56058");
		distinationMap.put(34,"Pelee Island, ONT - Canada - 03507");
		distinationMap.put(4630,"PELICAN - United States - 3124");
		distinationMap.put(1175,"Pelotas - Brazil - 35199");
		distinationMap.put(3958,"Pemba Island - Tanzania - 78399");
		distinationMap.put(4663,"PEMBINA - United States - 3401");
		distinationMap.put(1698,"Pembroke - United Kingdom - 41465");
		distinationMap.put(4913,"PEMBROKE - United States - 1001");
		distinationMap.put(4926,"Pembroke - United States - 1001");
		distinationMap.put(1062,"Pena Blanca - Chile - 33700");
		distinationMap.put(2831,"Penang - Malaysia - 55735");
		distinationMap.put(1693,"Penarth - United Kingdom - 41400");
		distinationMap.put(1089,"Penco - Chile - 33782");
		distinationMap.put(3847,"Pennington - Nigeria - 75380");
		distinationMap.put(3848,"Pennington Terminal - Nigeria - 75380");
		distinationMap.put(3552,"Penrhyn - New Zealand - 61460");
		distinationMap.put(3553,"Penryn - New Zealand - 61460");
		distinationMap.put(4471,"PENSACOLA - United States - 1819");
		distinationMap.put(1670,"Penzance - United Kingdom - 41398");
		distinationMap.put(4723,"PEORIA - United States - 3902");
		distinationMap.put(3801,"Pepel - Sierra Leone - 74799");
		distinationMap.put(780,"Pepillo Salcedo - Dominican Republic - 24745");
		distinationMap.put(2650,"Perim Island - Yemen - 52100");
		distinationMap.put(1140,"Pernambuco - Brazil - 35169");
		distinationMap.put(1817,"Pernis - Netherlands - 42151");
		distinationMap.put(3484,"Perth - Australia - 60243");
		distinationMap.put(1750,"Perth - United Kingdom - 41698");
		distinationMap.put(4763,"PERTH AMBOY - United States - 4602");
		distinationMap.put(957,"Pertigalete - Venezuela - 30775");
		distinationMap.put(4103,"Peru - Peru - 3330");
		distinationMap.put(1025,"Peruvian Whaling Grounds - Peru - 33300");
		distinationMap.put(1723,"Peterhead - United Kingdom - 41640");
		distinationMap.put(4628,"PETERSBURG - United States - 3112");
		distinationMap.put(1868,"Petit Couronne - France - 42700");
		distinationMap.put(747,"Petit Goave - Haiti - 24571");
		distinationMap.put(1869,"Petit Quevilly - France - 42700");
		distinationMap.put(4348,"PETROPAVLOVSK - KAZAKHSTAN - 44911");
		distinationMap.put(2015,"Petropavlovsk - Russia - 46233");
		distinationMap.put(2016,"Petropavlovsk-Kamchatskiy - Russia - 46233");
		distinationMap.put(934,"Petrozuata - Venezuela - 30743");
		distinationMap.put(2035,"Pevek - Russia - 46239");
		distinationMap.put(4425,"PHILADELPHIA - United States - 1101");
		distinationMap.put(4432,"PHILADELPHIA INTL. AIRPORT - United States - 1108");
		distinationMap.put(4198,"Philippines - Philippines - 5650");
		distinationMap.put(844,"Philipsborough - Neth Antilles - 27726");
		distinationMap.put(845,"Philipsburgh - Neth Antilles - 27726");
		distinationMap.put(4975,"Phnom Pehn - Cambodia - 55500");
		distinationMap.put(2804,"Phnom Penh - Cambodia - 55500");
		distinationMap.put(4534,"PHOENIX - United States - 2605");
		distinationMap.put(2773,"Phuket - Thailand - 54902");
		distinationMap.put(3527,"Picton - New Zealand - 61400");
		distinationMap.put(8,"Picton, ONT - Canada - 01652");
		distinationMap.put(246,"Pictou, NS - Canada - 13854");
		distinationMap.put(4653,"PIEGAN - United States - 3316");
		distinationMap.put(1464,"Pietarsaari - Finland - 40500");
		distinationMap.put(654,"Pilon Harbor - Cuba - 23900");
		distinationMap.put(2397,"Pilos - Greece - 48463");
		distinationMap.put(1039,"Pimentel - Peru - 33371");
		distinationMap.put(3029,"Pinamalayan - Philippines - 56500");
		distinationMap.put(2832,"Pinang - Malaysia - 55735");
		distinationMap.put(4684,"PINECREEK - United States - 3425");
		distinationMap.put(4910,"PINEVILLE - United States - 1601");
		distinationMap.put(4355,"PINSK - Belarus - 45101");
		distinationMap.put(2200,"Piombino - Italy - 47515");
		distinationMap.put(2378,"Piraeus - Greece - 48452");
		distinationMap.put(2379,"Piraieus - Greece - 48452");
		distinationMap.put(2380,"Piraievs - Greece - 48452");
		distinationMap.put(2277,"Piran - Slovenia - 47910");
		distinationMap.put(2278,"Pirano - Slovenia - 47910");
		distinationMap.put(1063,"Pisagua - Chile - 33700");
		distinationMap.put(1041,"Pisco - Peru - 33373");
		distinationMap.put(4222,"Pitcairn Island - Pitcairn Island - 6225");
		distinationMap.put(3573,"Pitcairn Islands - Pitcairn - 62211");
		distinationMap.put(1271,"Pitea - Sweden - 40100");
		distinationMap.put(4428,"PITTSBURGH - United States - 1104");
		distinationMap.put(2953,"Plaju - Indonesia - 56087");
		distinationMap.put(3030,"Plaridel - Philippines - 56500");
		distinationMap.put(2280,"Ploce - Croatia - 47911");
		distinationMap.put(2336,"Plomarion - Greece - 48400");
		distinationMap.put(795,"Plymouth - Montserrat - 24845");
		distinationMap.put(1633,"Plymouth - United Kingdom - 41360");
		distinationMap.put(4854,"PLYMOUTH - United States - 0406");
		distinationMap.put(3229,"Pohang - South Korea - 58055");
		distinationMap.put(3230,"Pohang Hang - South Korea - 58055");
		distinationMap.put(3613,"Pohnpei - Micronesia - 68207");
		distinationMap.put(555,"Point Bruja - Panama - 22599");
		distinationMap.put(3773,"Point Central - Mauritania - 74165");
		distinationMap.put(819,"Point Fortin - Trinidad - 27420");
		distinationMap.put(817,"Point Galeota - Trinidad - 27410");
		distinationMap.put(820,"Point Lisas - Trinidad - 27425");
		distinationMap.put(556,"Point Mala - Panama - 22599");
		distinationMap.put(4607,"POINT ROBERTS - United States - 3017");
		distinationMap.put(339,"Point Tosca - Mexico - 20100");
		distinationMap.put(255,"Point Tupper, CBI - Canada - 14065");
		distinationMap.put(1135,"Point Ubu - Brazil - 35166");
		distinationMap.put(818,"Pointe a Pierre - Trinidad - 27415");
		distinationMap.put(855,"Pointe a Pitre - Guadeloupe - 28313");
		distinationMap.put(256,"Pointe Au Pic, QUE - Canada - 14066");
		distinationMap.put(23,"Pointe aux Trembles, ONT - Canada - 01823");
		distinationMap.put(3999,"Pointe des Galets - Reunion - 79051");
		distinationMap.put(3899,"Pointe Noire - Congo Brazzaville - 76350");
		distinationMap.put(219,"Pointe Noire, QUE - Canada - 13476");
		distinationMap.put(2282,"Pola - Croatia - 47920");
		distinationMap.put(4136,"Poland - Poland - 4550");
		distinationMap.put(1992,"Police - Poland - 45513");
		distinationMap.put(3031,"Polillo - Philippines - 56500");
		distinationMap.put(3614,"Ponape - Micronesia - 68207");
		distinationMap.put(4782,"PONCE - United States - 4908");
		distinationMap.put(2732,"Pondicherry - India - 53398");
		distinationMap.put(1139,"Ponta da Madeira - Brazil - 35168");
		distinationMap.put(2174,"Ponta Delgada - Portugal - 47151");
		distinationMap.put(1136,"Ponta do Ubu - Brazil - 35166");
		distinationMap.put(3032,"Pontevedra - Philippines - 56500");
		distinationMap.put(2866,"Pontianak - Indonesia - 56011");
		distinationMap.put(1671,"Poole - United Kingdom - 41398");
		distinationMap.put(2689,"Porbandar - India - 53300");
		distinationMap.put(115,"Porcher Island, BC - Canada - 12200");
		distinationMap.put(1502,"Pori - Finland - 40562");
		distinationMap.put(903,"Porlamar - Venezuela - 30700");
		distinationMap.put(3588,"Poro - New Caledonia - 64100");
		distinationMap.put(3079,"Poro - Philippines - 56578");
		distinationMap.put(3033,"Poro Island - Philippines - 56500");
		distinationMap.put(1443,"Porsgrunn - Norway - 40378");
		distinationMap.put(120,"Port Alberni, BC - Canada - 12202");
		distinationMap.put(2145,"Port Alfaques - Spain - 47099");
		distinationMap.put(259,"Port Alfred, QUE - Canada - 14069");
		distinationMap.put(153,"Port Alice, BC - Canada - 12422");
		distinationMap.put(3485,"Port Alma - Australia - 60249");
		distinationMap.put(611,"Port Andros - Bahamas - 23672");
		distinationMap.put(4597,"PORT ANGELES - United States - 3007");
		distinationMap.put(696,"Port Antonio - Jamaica - 24100");
		distinationMap.put(3165,"Port Arthur - China - 57052");
		distinationMap.put(4503,"PORT ARTHUR - United States - 2101");
		distinationMap.put(76,"Port Arthur, ONT - Canada - 09662");
		distinationMap.put(748,"Port au Prince - Haiti - 24579");
		distinationMap.put(3810,"Port Bouet - Ivory Coast - 74899");
		distinationMap.put(703,"Port Bustamante - Jamaica - 24128");
		distinationMap.put(2793,"Port Campha - Vietnam - 55205");
		distinationMap.put(4469,"PORT CANAVERAL - United States - 1816");
		distinationMap.put(261,"Port Cartier, QUE - Canada - 14073");
		distinationMap.put(3547,"Port Chalmers - New Zealand - 61431");
		distinationMap.put(122,"Port Clements, BC - Canada - 12204");
		distinationMap.put(27,"Port Colborne, ONT - Canada - 02641");
		distinationMap.put(6,"Port Credit, ONT - Canada - 01530");
		distinationMap.put(1916,"Port de Bouc - France - 42784");
		distinationMap.put(749,"Port de Paix - Haiti - 24585");
		distinationMap.put(2841,"Port Dickson - Malaysia - 55753");
		distinationMap.put(1098,"Port do Pecem - Brazil - 35120");
		distinationMap.put(151,"Port Edward, BC - Canada - 12420");
		distinationMap.put(4013,"Port Elizabeth - South Africa - 79145");
		distinationMap.put(708,"Port Esquivel - Jamaica - 24163");
		distinationMap.put(3774,"Port Etienne - Mauritania - 74165");
		distinationMap.put(4794,"PORT EVERGLADES - United States - 5203");
		distinationMap.put(3866,"Port Gentil - Gabon - 75525");
		distinationMap.put(858,"Port Gustave - Guadeloupe - 28319");
		distinationMap.put(3852,"Port Harcourt - Nigeria - 75385");
		distinationMap.put(131,"Port Hardy, BC - Canada - 12211");
		distinationMap.put(241,"Port Hawkesbury, NS - Canada - 13849");
		distinationMap.put(3471,"Port Hedland - Australia - 60219");
		distinationMap.put(4022,"Port Hess, St. Croix - US Virgin Is - 91125");
		distinationMap.put(3034,"Port Holland - Philippines - 56500");
		distinationMap.put(4543,"PORT HUENEME - United States - 2713");
		distinationMap.put(4704,"PORT HURON - United States - 3802");
		distinationMap.put(1110,"Port Itaqui - Brazil - 35135");
		distinationMap.put(1902,"Port Jerome - France - 42755");
		distinationMap.put(16,"Port Johnstown, ONT - Canada - 01700");
		distinationMap.put(711,"Port Kaiser - Jamaica - 24165");
		distinationMap.put(2337,"Port Kaloni - Greece - 48400");
		distinationMap.put(2699,"Port Kandla - India - 53307");
		distinationMap.put(2838,"Port Kelang - Malaysia - 55751");
		distinationMap.put(3486,"Port Kembla - Australia - 60252");
		distinationMap.put(1934,"Port La Nouvelle - France - 42799");
		distinationMap.put(4808,"PORT LAVACA - United States - 5313");
		distinationMap.put(3887,"Port Lombo - Angola - 76288");
		distinationMap.put(3960,"Port Louis - Mauritius - 78501");
		distinationMap.put(600,"Port Lucaya - Bahamas - 23646");
		distinationMap.put(3644,"Port Lyautey - Morocco - 71400");
		distinationMap.put(3542,"Port Lyttelton - New Zealand - 61415");
		distinationMap.put(193,"Port Maitland, NS - Canada - 13430");
		distinationMap.put(4472,"PORT MANATEE - United States - 1821");
		distinationMap.put(154,"Port Mann, BC - Canada - 12426");
		distinationMap.put(697,"Port Maria - Jamaica - 24100");
		distinationMap.put(155,"Port Mellon, BC - Canada - 12428");
		distinationMap.put(156,"Port Moody, BC - Canada - 12430");
		distinationMap.put(698,"Port Morant - Jamaica - 24100");
		distinationMap.put(3521,"Port Moresby - Papua New Guinea - 60447");
		distinationMap.put(2738,"Port Muhammad Bin Qasim - Pakistan - 53551");
		distinationMap.put(4011,"Port Natal - South Africa - 79113");
		distinationMap.put(602,"Port Nelson - Bahamas - 23650");
		distinationMap.put(4006,"Port Nollath - South Africa - 79100");
		distinationMap.put(192,"Port of Digby, NS - Canada - 13420");
		distinationMap.put(821,"Port of Spain - Trinidad - 27431");
		distinationMap.put(2690,"Port Okha - India - 53300");
		distinationMap.put(3077,"Port Ozamis - Philippines - 56556");
		distinationMap.put(3487,"Port Pirie - Australia - 60258");
		distinationMap.put(4026,"Port Purcell, Rd Harbor - US Virgin Is - 91151");
		distinationMap.put(2739,"Port Qasim - Pakistan - 53551");
		distinationMap.put(2634,"Port Rashid - United Arab Em - 52005");
		distinationMap.put(2785,"Port Redon - Vietnam - 55200");
		distinationMap.put(712,"Port Rhoades - Jamaica - 24167");
		distinationMap.put(699,"Port Royal - Jamaica - 24100");
		distinationMap.put(3733,"Port Said - Egypt - 72913");
		distinationMap.put(1918,"Port Saint Louis - France - 42785");
		distinationMap.put(4539,"PORT SAN LUIS - United States - 2707");
		distinationMap.put(2099,"Port Santa Maria - Spain - 47049");
		distinationMap.put(1133,"Port Santana - Brazil - 35165");
		distinationMap.put(159,"Port Simpson, BC - Canada - 12444");
		distinationMap.put(1228,"Port Stanley, E Falklnd - Falk Is - 37200");
		distinationMap.put(25,"Port Stanley, ONT - Canada - 02566");
		distinationMap.put(4938,"PORT STREE - United States - 1001");
		distinationMap.put(3757,"Port Sudan - Sudan - 73201");
		distinationMap.put(4487,"PORT SULPHUR - United States - 2005");
		distinationMap.put(2671,"Port Sultan Qaboos - Oman - 52325");
		distinationMap.put(2839,"Port Swettenham - Malaysia - 55751");
		distinationMap.put(1699,"Port Talbot - United Kingdom - 41477");
		distinationMap.put(655,"Port Tarafa - Cuba - 23900");
		distinationMap.put(340,"Port Telzo - Mexico - 20100");
		distinationMap.put(4598,"PORT TOWNSEND - United States - 3008");
		distinationMap.put(1935,"Port Vendres - France - 42799");
		distinationMap.put(3945,"Port Victoria - Seychelles - 78083");
		distinationMap.put(3572,"Port Vila - Vanuatu - 62209");
		distinationMap.put(2809,"Port Weld - Malaysia - 55700");
		distinationMap.put(78,"Port Weller, ONT - Canada - 09663");
		distinationMap.put(83,"Port Whitby, ONT - Canada - 09671");
		distinationMap.put(4665,"PORTAL - United States - 3403");
		distinationMap.put(1596,"Portbury - United Kingdom - 41262");
		distinationMap.put(1167,"Portel - Brazil - 35198");
		distinationMap.put(4649,"PORTHILL - United States - 3308");
		distinationMap.put(2190,"Portici - Italy - 47500");
		distinationMap.put(2155,"Portimao - Portugal - 47100");
		distinationMap.put(3488,"Portland - Australia - 60261");
		distinationMap.put(1672,"Portland - United Kingdom - 41398");
		distinationMap.put(4821,"PORTLAND - United States - 0101");
		distinationMap.put(4583,"PORTLAND - United States - 2904");
		distinationMap.put(4588,"PORTLAND INTERNATIONAL AIRPORT - United States - 2910");
		distinationMap.put(2167,"Porto - Portugal - 47133");
		distinationMap.put(1138,"Porto Alegre - Brazil - 35167");
		distinationMap.put(3893,"Porto Alexandre - Angola - 76299");
		distinationMap.put(3894,"Porto Amboim - Angola - 76299");
		distinationMap.put(2255,"Porto Corsini - Italy - 47584");
		distinationMap.put(2159,"Porto de Leixoes - Portugal - 47123");
		distinationMap.put(2163,"Porto de Sines - Portugal - 47127");
		distinationMap.put(2225,"Porto Empedocle - Italy - 47554");
		distinationMap.put(3901,"Porto Grande - Cape Verde - 76465");
		distinationMap.put(2261,"Porto Marghara - Italy - 47595");
		distinationMap.put(3902,"Porto Praia - Cape Verde - 76475");
		distinationMap.put(2191,"Porto Santo Stefano - Italy - 47500");
		distinationMap.put(2238,"Porto Torres - Italy - 47561");
		distinationMap.put(1926,"Porto Vecchio - France - 42796");
		distinationMap.put(2243,"Porto Vesme - Italy - 47568");
		distinationMap.put(526,"Portobelo - Panama - 22555");
		distinationMap.put(1176,"Portocel - Brazil - 35199");
		distinationMap.put(2244,"Portocuso - Italy - 47568");
		distinationMap.put(2192,"Portoferraio - Italy - 47500");
		distinationMap.put(2201,"Portovecchio de Piombino - Italy - 47515");
		distinationMap.put(797,"Portsmouth - Dominica - 24852");
		distinationMap.put(1673,"Portsmouth - United Kingdom - 41398");
		distinationMap.put(4838,"PORTSMOUTH - United States - 0131");
		distinationMap.put(4150,"Portugal - Portugal - 4710");
		distinationMap.put(1491,"Porvoo - Finland - 40534");
		distinationMap.put(2193,"Possuoli - Italy - 47500");
		distinationMap.put(2065,"Poti - Georgia - 46337");
		distinationMap.put(4406,"POTI - Georgia - GE");
		distinationMap.put(157,"Powell River, BC - Canada - 12441");
		distinationMap.put(877,"Pozos Colorados - Colombia - 30100");
		distinationMap.put(2189,"Pozzuoli - Italy - 47500");
		distinationMap.put(4324,"Prague - Czech Republic - 42870");
		distinationMap.put(4950,"Prague - Czech Republic - 4351");
		distinationMap.put(3903,"Praia - Cape Verde - 76475");
		distinationMap.put(2175,"Praia - Portugal - 47152");
		distinationMap.put(2176,"Praia de Vitoria - Portugal - 47152");
		distinationMap.put(1124,"Praia Mole - Brazil - 35160");
		distinationMap.put(17,"Prescott, ONT - Canada - 01700");
		distinationMap.put(4517,"PRESIDIO - United States - 2403");
		distinationMap.put(4717,"PRESQUE ISLAND - United States - 3842");
		distinationMap.put(1597,"Preston - United Kingdom - 41264");
		distinationMap.put(2338,"Preveza - Greece - 48400");
		distinationMap.put(2006,"Primorsk - Russia - 46220");
		distinationMap.put(158,"Prince Rupert, BC - Canada - 12442");
		distinationMap.put(477,"Prinzapolca - Nicaragua - 21900");
		distinationMap.put(2226,"Priolo - Italy - 47555");
		distinationMap.put(2928,"Probolinggo - Indonesia - 56058");
		distinationMap.put(402,"Progreso - Mexico - 20185");
		distinationMap.put(4513,"PROGRESSO - United States - 2309");
		distinationMap.put(4865,"PROVIDENCE - United States - 0502");
		distinationMap.put(717,"Providenciales - Turks Is - 24311");
		distinationMap.put(2019,"Provideniya - Russia - 46237");
		distinationMap.put(4857,"PROVINCETOWN - United States - 0409");
		distinationMap.put(2393,"Psachna - Greece - 48461");
		distinationMap.put(478,"Pto. Cabo Gracias a Dios - Nicaragua - 21900");
		distinationMap.put(656,"Pto. Cayo Grande de Moa - Cuba - 23900");
		distinationMap.put(1218,"Pto. General San Martin - Argentina - 35779");
		distinationMap.put(393,"Pto. Libre de Pto Mexico - Mexico - 20171");
		distinationMap.put(361,"Pto. Venustiano Carranza - Mexico - 20104");
		distinationMap.put(2733,"Puduchcheri - India - 53398");
		distinationMap.put(341,"Puerto Angel - Mexico - 20100");
		distinationMap.put(541,"Puerto Armuelles - Panama - 22587");
		distinationMap.put(431,"Puerto Barrios - Guatemala - 20513");
		distinationMap.put(1026,"Puerto Bayovar - Peru - 33300");
		distinationMap.put(527,"Puerto Bello - Panama - 22555");
		distinationMap.put(882,"Puerto Bolivar - Colombia - 30121");
		distinationMap.put(999,"Puerto Bolivar - Ecuador - 33159");
		distinationMap.put(1219,"Puerto Borghio - Argentina - 35779");
		distinationMap.put(945,"Puerto Cabello - Venezuela - 30764");
		distinationMap.put(485,"Puerto Cabezas - Nicaragua - 21925");
		distinationMap.put(458,"Puerto Castilla - Honduras - 21527");
		distinationMap.put(886,"Puerto Colombia - Colombia - 30131");
		distinationMap.put(459,"Puerto Cortes - Honduras - 21531");
		distinationMap.put(909,"Puerto Cumarebo - Venezuela - 30700");
		distinationMap.put(910,"Puerto de Hierro - Venezuela - 30700");
		distinationMap.put(2121,"Puerto de la Luz - Spain - 47071");
		distinationMap.put(1080,"Puerto de Lirquen - Chile - 33751");
		distinationMap.put(2147,"Puerto de los Alfaques - Spain - 47099");
		distinationMap.put(406,"Puerto de Morales - Mexico - 20194");
		distinationMap.put(2128,"Puerto de Sagunto - Spain - 47083");
		distinationMap.put(2100,"Puerto de Santa Maria - Spain - 47049");
		distinationMap.put(2119,"Puerto del Rosario - Spain - 47070");
		distinationMap.put(1216,"Puerto Deseado - Argentina - 35745");
		distinationMap.put(887,"Puerto Drummond - Colombia - 30140");
		distinationMap.put(450,"Puerto El Triunfo - El Salvador - 21199");
		distinationMap.put(911,"Puerto Espiritu - Venezuela - 30700");
		distinationMap.put(453,"Puerto Este - Honduras - 21500");
		distinationMap.put(1027,"Puerto Eten - Peru - 33300");
		distinationMap.put(668,"Puerto General Peraza - Cuba - 23937");
		distinationMap.put(501,"Puerto Golfito - Costa Rica - 22363");
		distinationMap.put(912,"Puerto Gorda - Venezuela - 30700");
		distinationMap.put(466,"Puerto Henecan - Honduras - 21552");
		distinationMap.put(475,"Puerto Isabel - Nicaragua - 21900");
		distinationMap.put(935,"Puerto Jose - Venezuela - 30743");
		distinationMap.put(419,"Puerto Juarez - Mexico - 20195");
		distinationMap.put(953,"Puerto La Cruz - Venezuela - 30771");
		distinationMap.put(781,"Puerto Libertador - Dominican Republic - 24745");
		distinationMap.put(496,"Puerto Limon - Costa Rica - 22313");
		distinationMap.put(420,"Puerto Lobos - Mexico - 20195");
		distinationMap.put(404,"Puerto Madero - Mexico - 20193");
		distinationMap.put(1214,"Puerto Madryn - Argentina - 35740");
		distinationMap.put(529,"Puerto Manzanillo - Panama - 22556");
		distinationMap.put(488,"Puerto Masachapa - Nicaragua - 21999");
		distinationMap.put(427,"Puerto Matias de Galves - Guatemala - 20505");
		distinationMap.put(394,"Puerto Mexico - Mexico - 20171");
		distinationMap.put(944,"Puerto Miranda - Venezuela - 30763");
		distinationMap.put(1064,"Puerto Montt - Chile - 33700");
		distinationMap.put(407,"Puerto Morales - Mexico - 20194");
		distinationMap.put(362,"Puerto Morro Redondo - Mexico - 20104");
		distinationMap.put(996,"Puerto Nuevo - Ecuador - 33132");
		distinationMap.put(949,"Puerto Ordaz - Venezuela - 30768");
		distinationMap.put(657,"Puerto Padre - Cuba - 23900");
		distinationMap.put(758,"Puerto Palenque - Dominican Republic - 24700");
		distinationMap.put(782,"Puerto Plata - Dominican Republic - 24773");
		distinationMap.put(1196,"Puerto Quequen - Argentina - 35700");
		distinationMap.put(430,"Puerto Quetzal - Guatemala - 20506");
		distinationMap.put(3035,"Puerto Real - Philippines - 56500");
		distinationMap.put(4296,"Puerto Rico - Puerto Rico - 9030");
		distinationMap.put(1220,"Puerto San Lorenzo - Argentina - 35779");
		distinationMap.put(342,"Puerto San Quintin - Mexico - 20100");
		distinationMap.put(489,"Puerto Sandino - Nicaragua - 21999");
		distinationMap.put(951,"Puerto Sucre - Venezuela - 30769");
		distinationMap.put(658,"Puerto Tarafa - Cuba - 23900");
		distinationMap.put(4295,"Puerto to US - Puerto to US - 9000");
		distinationMap.put(377,"Puerto Vallarta - Mexico - 20143");
		distinationMap.put(493,"Puerto Vargas - Costa Rica - 22300");
		distinationMap.put(759,"Puerto Viejo de Azua - Dominican Republic - 24700");
		distinationMap.put(1178,"Puerto Villeta - Paraguay - 35300");
		distinationMap.put(647,"Puerto Vita - Cuba - 23900");
		distinationMap.put(878,"Puerto Zuniga - Colombia - 30100");
		distinationMap.put(2283,"Pula - Croatia - 47920");
		distinationMap.put(2846,"Pulau Bukom - Singapore - 55950");
		distinationMap.put(2821,"Pulau Lumut - Malaysia - 55709");
		distinationMap.put(2934,"Pulau Sambu - Indonesia - 56065");
		distinationMap.put(2844,"Pulau Sebarok - Singapore - 55901");
		distinationMap.put(2847,"Pulum Bukum - Singapore - 55950");
		distinationMap.put(3078,"Pulupandan - Philippines - 56569");
		distinationMap.put(985,"Puna - Ecuador - 33100");
		distinationMap.put(1083,"Punta Arenas - Chile - 33770");
		distinationMap.put(913,"Punta Camacho - Venezuela - 30700");
		distinationMap.put(952,"Punta Cardon - Venezuela - 30770");
		distinationMap.put(928,"Punta Chavez - Venezuela - 30737");
		distinationMap.put(948,"Punta Cuchillo - Venezuela - 30767");
		distinationMap.put(1189,"Punta del Este - Uruguay - 35537");
		distinationMap.put(343,"Punta Escondida - Mexico - 20100");
		distinationMap.put(439,"Punta Gorda - Belize - 20800");
		distinationMap.put(659,"Punta Gorda - Cuba - 23900");
		distinationMap.put(479,"Punta Gorda - Nicaragua - 21900");
		distinationMap.put(914,"Punta Gorda - Venezuela - 30700");
		distinationMap.put(557,"Punta Mala - Panama - 22599");
		distinationMap.put(504,"Punta Morales - Costa Rica - 22386");
		distinationMap.put(955,"Punta Palmas - Venezuela - 30773");
		distinationMap.put(1065,"Punta Patache - Chile - 33700");
		distinationMap.put(1028,"Punta Pescadores - Peru - 33300");
		distinationMap.put(915,"Punta Piedras - Venezuela - 30700");
		distinationMap.put(344,"Punta Prieta - Mexico - 20100");
		distinationMap.put(502,"Punta Quepos - Costa Rica - 22381");
		distinationMap.put(1197,"Punta Quilla - Argentina - 35700");
		distinationMap.put(345,"Punta San Juanico - Mexico - 20100");
		distinationMap.put(346,"Punta Santo Tomas - Mexico - 20100");
		distinationMap.put(771,"Punta Torrecilla - Dominican Republic - 24738");
		distinationMap.put(396,"Punta Venado - Mexico - 20173");
		distinationMap.put(505,"Puntarenas - Costa Rica - 22387");
		distinationMap.put(1674,"Purfleet - United Kingdom - 41398");
		distinationMap.put(2469,"Pursan - Turkey - 48944");
		distinationMap.put(3215,"Pusan - South Korea - 58023");
		distinationMap.put(2398,"Pylos - Greece - 48463");
		distinationMap.put(3223,"Pyongtaek - South Korea - 58032");
		distinationMap.put(3224,"Pyungtaek - South Korea - 58032");
		distinationMap.put(2661,"Qalhat - Oman - 52312");
		distinationMap.put(4177,"Qatar - Qatar - 5180");
		distinationMap.put(3157,"Qingdao - China - 57047");
		distinationMap.put(3124,"Qinhuangdao Gang - China - 57009");
		distinationMap.put(3855,"Qua Iboe Terminal - Nigeria - 75389");
		distinationMap.put(3181,"Quangzhou - China - 57071");
		distinationMap.put(3182,"Quanzhou - China - 57071");
		distinationMap.put(432,"Quatema - Guatemala - 20513");
		distinationMap.put(3856,"Que Iboe - Nigeria - 75389");
		distinationMap.put(264,"Quebec, QUE - Canada - 14094");
		distinationMap.put(1767,"Queenstown - Ireland - 41900");
		distinationMap.put(3965,"Quelimane - Mozambique - 78700");
		distinationMap.put(503,"Quepos - Costa Rica - 22381");
		distinationMap.put(2686,"Quilon - India - 53300");
		distinationMap.put(3158,"Quingdao - China - 57047");
		distinationMap.put(1084,"Quintero - Chile - 33775");
		distinationMap.put(1492,"Raahe - Finland - 40535");
		distinationMap.put(3645,"Rabat - Morocco - 71400");
		distinationMap.put(3522,"Rabaul - Papua New Guinea - 60449");
		distinationMap.put(4702,"RACINE - United States - 3708");
		distinationMap.put(2214,"Rada di Vado - Italy - 47540");
		distinationMap.put(1901,"Radicatel - France - 42754");
		distinationMap.put(586,"Ragged Island - Bahamas - 23636");
		distinationMap.put(2272,"Ragusa - Croatia - 47902");
		distinationMap.put(3599,"Raiatea Island - French Polyn - 64178");
		distinationMap.put(4642,"RAIMOND - United States - 3301");
		distinationMap.put(484,"Rama - Nicaragua - 21902");
		distinationMap.put(294,"Ramea, NFLD - Canada - 15211");
		distinationMap.put(1555,"Randers - Denmark - 40925");
		distinationMap.put(2757,"Rangoon - Burma - 54601");
		distinationMap.put(3555,"Rarotonga Island - New Zealand - 61461");
		distinationMap.put(2588,"Ras Al Khafji - Saudi Arabia - 51700");
		distinationMap.put(2625,"Ras al Khaimah - United Arab Em - 52000");
		distinationMap.put(2626,"Ras al Khaymah - United Arab Em - 52000");
		distinationMap.put(2604,"Ras at Tannurah - Saudi Arabia - 51727");
		distinationMap.put(3755,"Ras Budran - Egypt - 72999");
		distinationMap.put(3738,"Ras Gharib - Egypt - 72939");
		distinationMap.put(2615,"Ras Laffan - Qatar - 51814");
		distinationMap.put(3713,"Ras Lanuf - Libya - 72520");
		distinationMap.put(3739,"Ras Shukheir - Egypt - 72940");
		distinationMap.put(3740,"Ras Sudr - Egypt - 72945");
		distinationMap.put(2605,"Ras Tanura - Saudi Arabia - 51727");
		distinationMap.put(1240,"Raufarhofn - Iceland - 40000");
		distinationMap.put(1503,"Rauma - Finland - 40571");
		distinationMap.put(2256,"Ravenna - Italy - 47584");
		distinationMap.put(3528,"Ravensbourne - New Zealand - 61400");
		distinationMap.put(2776,"Rayong - Thailand - 54903");
		distinationMap.put(1141,"Recife - Brazil - 35169");
		distinationMap.put(186,"Red Head, NB - Canada - 13400");
		distinationMap.put(1634,"Redcar - United Kingdom - 41362");
		distinationMap.put(4567,"REDWOOD CITY - United States - 2821");
		distinationMap.put(2194,"Reggio di Calabria - Italy - 47500");
		distinationMap.put(676,"Regla - Cuba - 23944");
		distinationMap.put(4452,"REIDSVILLE - United States - 1506");
		distinationMap.put(1444,"Rekefjord - Norway - 40379");
		distinationMap.put(1969,"Rendsburg - Germany - 42899");
		distinationMap.put(2060,"Reni - Ukraine - 46279");
		distinationMap.put(4573,"RENO - United States - 2833");
		distinationMap.put(4179,"Republic of Yemen - Republic of Yemen - 5210");
		distinationMap.put(4283,"Reunion - Reunion - 7904");
		distinationMap.put(3767,"Rey Malabo - Equatorial Gui - 73801");
		distinationMap.put(1252,"Reykjavik - Iceland - 40037");
		distinationMap.put(2339,"Rhodes - Greece - 48400");
		distinationMap.put(2073,"Ribadesella - Spain - 47000");
		distinationMap.put(4014,"Richard&#39;s Bay - South Africa - 79155");
		distinationMap.put(206,"Richardson Island, NB - Canada - 13454");
		distinationMap.put(207,"Richardson, NB - Canada - 13454");
		distinationMap.put(4843,"RICHFORD - United States - 0203");
		distinationMap.put(4562,"RICHMOND - United States - 2812");
		distinationMap.put(176,"Richmond, BC - Canada - 12497");
		distinationMap.put(4445,"RICHMOND-PETERSBURG - United States - 1404");
		distinationMap.put(1635,"Ridham Dock - United Kingdom - 41370");
		distinationMap.put(1832,"Rieme - Belgium - 42300");
		distinationMap.put(4410,"Riga - Kazakhstan - 35198");
		distinationMap.put(4391,"Riga - Kostanay - Kazakhstan - 4634");
		distinationMap.put(1975,"Riga - Latvia - 44911");
		distinationMap.put(4380,"Riga - Tula - Latvia - 44911");
		distinationMap.put(2285,"Rijeka - Croatia - 47923");
		distinationMap.put(258,"Rimouski, QUE - Canada - 14068");
		distinationMap.put(1775,"Ringaskiddy - Ireland - 41905");
		distinationMap.put(3765,"Rio Benito - Equatorial Gui - 73800");
		distinationMap.put(700,"Rio Bueno - Jamaica - 24100");
		distinationMap.put(916,"Rio Chico - Venezuela - 30700");
		distinationMap.put(1144,"Rio de Janeiro - Brazil - 35171");
		distinationMap.put(1195,"Rio Gallegos - Argentina - 35700");
		distinationMap.put(1145,"Rio Grande - Brazil - 35173");
		distinationMap.put(480,"Rio Grande - Nicaragua - 21900");
		distinationMap.put(4512,"RIO GRANDE CITY - United States - 2307");
		distinationMap.put(775,"Rio Haina - Dominican Republic - 24741");
		distinationMap.put(558,"Rio Hato - Panama - 22599");
		distinationMap.put(776,"Rio Jaina - Dominican Republic - 24741");
		distinationMap.put(917,"Rio Sico - Venezuela - 30700");
		distinationMap.put(3504,"Risdon - Australia - 60299");
		distinationMap.put(1396,"Risor - Norway - 40300");
		distinationMap.put(1204,"Rivadavia - Argentina - 35702");
		distinationMap.put(3914,"River Cess - Liberia - 76500");
		distinationMap.put(4358,"RIYADH DRY PORT - Saudi Arabia - 51715");
		distinationMap.put(3144,"Rizhao - China - 57024");
		distinationMap.put(787,"Road Harbour, Tortola - British Virgin - 24815");
		distinationMap.put(788,"Road Town, Tortola Island - British Virgin - 24815");
		distinationMap.put(462,"Roatan Island - Honduras - 21535");
		distinationMap.put(166,"Robert&#39;s Bank, BC - Canada - 12489");
		distinationMap.put(3915,"Robertsport - Liberia - 76500");
		distinationMap.put(735,"Roche a Bateau - Haiti - 24500");
		distinationMap.put(1903,"Rochefort - France - 42757");
		distinationMap.put(1675,"Rochester - United Kingdom - 41398");
		distinationMap.put(4875,"ROCHESTER - United States - 0903");
		distinationMap.put(4728,"ROCKFORD AIRPORT, ROCKFORD - United States - 3909");
		distinationMap.put(4835,"ROCKLAND - United States - 0121");
		distinationMap.put(28,"Rockport, ONT - Canada - 02643");
		distinationMap.put(713,"Rocky Point - Jamaica - 24175");
		distinationMap.put(15,"Rocky Point, ONT - Canada - 01697");
		distinationMap.put(2340,"Rodhos - Greece - 48400");
		distinationMap.put(559,"Rodman - Panama - 22599");
		distinationMap.put(2495,"Rodosto - Turkey - 48999");
		distinationMap.put(4714,"ROGERS CITY - United States - 3818");
		distinationMap.put(4590,"ROGUE VALLEY/MEDFORD AIRPORT - United States - 2982");
		distinationMap.put(4514,"ROMA - United States - 2310");
		distinationMap.put(4163,"Romania - Romania - 4850");
		distinationMap.put(3036,"Romblon Island - Philippines - 56500");
		distinationMap.put(1556,"Ronne - Denmark - 40926");
		distinationMap.put(1298,"Ronneby - Sweden - 40100");
		distinationMap.put(1351,"Ronnsker - Sweden - 40161");
		distinationMap.put(4655,"ROOSVILLE - United States - 3318");
		distinationMap.put(1217,"Rosario - Argentina - 35771");
		distinationMap.put(370,"Rosarito - Mexico - 20125");
		distinationMap.put(2148,"Rosas - Spain - 47099");
		distinationMap.put(4685,"ROSEAU - United States - 3426");
		distinationMap.put(1768,"Rosslare - Ireland - 41900");
		distinationMap.put(1943,"Rostock - Germany - 42811");
		distinationMap.put(1751,"Rosyth - United Kingdom - 41698");
		distinationMap.put(2101,"Rota - Spain - 47049");
		distinationMap.put(1818,"Rotterdam - Netherlands - 42157");
		distinationMap.put(1904,"Rouen - France - 42759");
		distinationMap.put(1870,"Rouen Quevilly - France - 42700");
		distinationMap.put(796,"Rouseau - Dominica - 24851");
		distinationMap.put(3791,"Rufisque - Senegal - 74499");
		distinationMap.put(603,"Rum Cay - Bahamas - 23650");
		distinationMap.put(3324,"Rumoi - Japan - 58820");
		distinationMap.put(1605,"Runcorn - United Kingdom - 41299");
		distinationMap.put(265,"Rupert Inlet, QUE - Canada - 14095");
		distinationMap.put(4137,"Russia - Russia - 4621");
		distinationMap.put(2639,"Ruwais - United Arab Em - 52050");
		distinationMap.put(4268,"Rwanda - Rwanda - 7690");
		distinationMap.put(3113,"Ryojun Ko - China - 57000");
		distinationMap.put(2961,"Sabang - Indonesia - 56099");
		distinationMap.put(4504,"SABINE - United States - 2102");
		distinationMap.put(4565,"SACRAMENTO - United States - 2816");
		distinationMap.put(4578,"SACRAMENTO INTERNATIONAL AIRPORT - United States - 2881");
		distinationMap.put(3743,"Safaga - Egypt - 72948");
		distinationMap.put(3652,"Saffi - Morocco - 71419");
		distinationMap.put(3653,"Safi - Morocco - 71419");
		distinationMap.put(3283,"Saganoseki - Japan - 58800");
		distinationMap.put(4706,"SAGINAW/BAY CITY/FLINT - United States - 3804");
		distinationMap.put(681,"Sagua de Tanamo - Cuba - 23979");
		distinationMap.put(669,"Sagua la Grande - Cuba - 23937");
		distinationMap.put(2129,"Sagunto - Spain - 47083");
		distinationMap.put(2514,"Saida - Lebanon - 50400");
		distinationMap.put(2799,"Saigon - Vietnam - 55224");
		distinationMap.put(3322,"Saiki - Japan - 58819");
		distinationMap.put(3323,"Saiki Ko - Japan - 58819");
		distinationMap.put(1493,"Saimaa Canal - Finland - 40536");
		distinationMap.put(266,"Saint Andrews, NB - Canada - 14426");
		distinationMap.put(296,"Saint Anthony, NL - Canada - 15212");
		distinationMap.put(859,"Saint Bartholomew - Guadeloupe - 28319");
		distinationMap.put(11,"Saint Catharines, ONT - Canada - 01690");
		distinationMap.put(4000,"Saint Denis - Reunion - 79052");
		distinationMap.put(268,"Saint George, NB - Canada - 14427");
		distinationMap.put(565,"Saint Georges - Bermuda - 23251");
		distinationMap.put(2341,"Saint George&#39;s Bay - Greece - 48400");
		distinationMap.put(270,"Saint Jean, QUE - Canada - 14429");
		distinationMap.put(269,"Saint John, NB - Canada - 14428");
		distinationMap.put(311,"Saint John&#39;s, NFLD - Canada - 15282");
		distinationMap.put(271,"Saint Johns, QUE - Canada - 14429");
		distinationMap.put(978,"Saint Laurent - French Guiana - 31700");
		distinationMap.put(313,"Saint Lawrence, NFLD - Canada - 15283");
		distinationMap.put(736,"Saint Louis du Sud - Haiti - 24500");
		distinationMap.put(1871,"Saint Malo - France - 42700");
		distinationMap.put(751,"Saint Marc - Haiti - 24591");
		distinationMap.put(852,"Saint Martin - Guadeloupe - 28300");
		distinationMap.put(1905,"Saint Nazaire - France - 42762");
		distinationMap.put(4632,"SAINT PAUL AIRPORT,ANCHORAGE - United States - 3181");
		distinationMap.put(874,"Saint Pierre - Martinique - 28399");
		distinationMap.put(1936,"Saint Raphael - France - 42799");
		distinationMap.put(272,"Saint Stephen, NB - Canada - 14438");
		distinationMap.put(4028,"Saint Thomas, St. Thomas - US Virgin Is - 91155");
		distinationMap.put(4053,"Saipan - Northern Marian - 96165");
		distinationMap.put(3284,"Saitosaki - Japan - 58800");
		distinationMap.put(3285,"Saitozaki - Japan - 58800");
		distinationMap.put(3408,"Sakai - Japan - 58874");
		distinationMap.put(3409,"Sakai Ko - Japan - 58874");
		distinationMap.put(3410,"Sakaide - Japan - 58875");
		distinationMap.put(3411,"Sakaide Ko - Japan - 58875");
		distinationMap.put(3412,"Sakata - Japan - 58876");
		distinationMap.put(3909,"Sal Island - Cape Verde - 76499");
		distinationMap.put(2674,"Salalah - Oman - 52330");
		distinationMap.put(3512,"Salamaua - Papua New Guinea - 60400");
		distinationMap.put(2342,"Salamis - Greece - 48400");
		distinationMap.put(3513,"Salamoa - Papua New Guinea - 60400");
		distinationMap.put(1042,"Salaverry - Peru - 33377");
		distinationMap.put(2851,"Salawati - Indonesia - 56000");
		distinationMap.put(4007,"Saldanha Bay - South Africa - 79100");
		distinationMap.put(2651,"Saleef - Yemen - 52100");
		distinationMap.put(4856,"SALEM - United States - 0408");
		distinationMap.put(2212,"Salerno - Italy - 47538");
		distinationMap.put(1594,"Salford - United Kingdom - 41253");
		distinationMap.put(372,"Salina Cruz - Mexico - 20129");
		distinationMap.put(992,"Salinas - Ecuador - 33115");
		distinationMap.put(1299,"Saljfviken - Sweden - 40100");
		distinationMap.put(2407,"Salonika - Greece - 48471");
		distinationMap.put(720,"Salt Cay - Turks Is - 24399");
		distinationMap.put(1676,"Salt End - United Kingdom - 41398");
		distinationMap.put(4644,"SALT LAKE CITY - United States - 3303");
		distinationMap.put(1445,"Salten - Norway - 40380");
		distinationMap.put(3815,"Saltpond - Ghana - 74900");
		distinationMap.put(1152,"Salvador - Brazil - 35181");
		distinationMap.put(761,"Samana - Dominican Republic - 24720");
		distinationMap.put(3514,"Samarai - Papua New Guinea - 60400");
		distinationMap.put(2867,"Samarinda - Indonesia - 56012");
		distinationMap.put(4366,"SAMARQAND - UZBEKISTAN - 44911");
		distinationMap.put(2879,"Sambas - Indonesia - 56020");
		distinationMap.put(3987,"Sambava - Madagascar - 78800");
		distinationMap.put(3233,"Samil - South Korea - 58065");
		distinationMap.put(2399,"Samos - Greece - 48464");
		distinationMap.put(2481,"Samsun - Turkey - 48967");
		distinationMap.put(885,"San Andres - Colombia - 30130");
		distinationMap.put(1198,"San Antonio - Argentina - 35700");
		distinationMap.put(1086,"San Antonio - Chile - 33779");
		distinationMap.put(1179,"San Antonio - Paraguay - 35300");
		distinationMap.put(4817,"SAN ANTONIO - United States - 5507");
		distinationMap.put(347,"San Blas - Mexico - 20100");
		distinationMap.put(2094,"San Ciprian - Spain - 47036");
		distinationMap.put(4523,"SAN DIEGO - United States - 2501");
		distinationMap.put(2130,"San Feliu de Guixols - Spain - 47088");
		distinationMap.put(958,"San Felix - Venezuela - 30780");
		distinationMap.put(3080,"San Fernando - Philippines - 56578");
		distinationMap.put(822,"San Fernando - Trinidad - 27443");
		distinationMap.put(4559,"SAN FRANCISCO - United States - 2809");
		distinationMap.put(4555,"SAN FRANCISCO INTL. AIRPORT, SAN FRANCISCO - United States - 2801");
		distinationMap.put(348,"San Geronimo - Mexico - 20100");
		distinationMap.put(2302,"San Giovanni di Medua - Albania - 48100");
		distinationMap.put(349,"San Ignacio - Mexico - 20100");
		distinationMap.put(350,"San Jeronimo - Mexico - 20100");
		distinationMap.put(4569,"SAN JOAQUIN RIVER - United States - 2828");
		distinationMap.put(433,"San Jose - Guatemala - 20577");
		distinationMap.put(3037,"San Jose de Buenavista - Philippines - 56500");
		distinationMap.put(351,"San Jose del Cabo - Mexico - 20100");
		distinationMap.put(4574,"SAN JOSE INTL.,SAN FRANCISCO - United States - 2834");
		distinationMap.put(4783,"SAN JUAN - United States - 4909");
		distinationMap.put(2078,"San Juan de Nieva - Spain - 47003");
		distinationMap.put(490,"San Juan del Sur - Nicaragua - 21999");
		distinationMap.put(4786,"SAN JUAN INTL. AIRPORT - United States - 4913");
		distinationMap.put(1221,"San Lorenzo - Argentina - 35779");
		distinationMap.put(986,"San Lorenzo - Ecuador - 33100");
		distinationMap.put(465,"San Lorenzo - Honduras - 21551");
		distinationMap.put(918,"San Lorenzo - Venezuela - 30700");
		distinationMap.put(378,"San Lucas - Mexico - 20144");
		distinationMap.put(4536,"SAN LUIS - United States - 2608");
		distinationMap.put(373,"San Marcos Island - Mexico - 20135");
		distinationMap.put(4153,"San Marino - San Marino - 4751");
		distinationMap.put(116,"San Mateo, BC - Canada - 12200");
		distinationMap.put(560,"San Miguel Gulf - Panama - 22599");
		distinationMap.put(1222,"San Nicolas - Argentina - 35781");
		distinationMap.put(1043,"San Nicolas - Peru - 33380");
		distinationMap.put(830,"San Nicolas Bay - Aruba - 27702");
		distinationMap.put(4570,"SAN PABLO BAY - United States - 2829");
		distinationMap.put(1223,"San Pedro - Argentina - 35785");
		distinationMap.put(440,"San Pedro - Belize - 20800");
		distinationMap.put(3804,"San Pedro - Ivory Coast - 74827");
		distinationMap.put(4919,"San Pedro - United States - 2709");
		distinationMap.put(784,"San Pedro de Macoris - Dominican Republic - 24791");
		distinationMap.put(660,"San Ramon - Cuba - 23900");
		distinationMap.put(352,"San Roque Island - Mexico - 20100");
		distinationMap.put(573,"San Salvador - Bahamas - 23600");
		distinationMap.put(4956,"San Salvador - El Salvador - 21199");
		distinationMap.put(4957,"san salvador - el salvador - 21199");
		distinationMap.put(2074,"San Sebastian - Spain - 47000");
		distinationMap.put(1199,"San Sebastian Bay - Argentina - 35700");
		distinationMap.put(3175,"San T Ou - China - 57070");
		distinationMap.put(1087,"San Vicente - Chile - 33780");
		distinationMap.put(4526,"SAN YSIDRO - United States - 2504");
		distinationMap.put(2816,"Sandakan - Malaysia - 55706");
		distinationMap.put(1352,"Sandarne - Sweden - 40166");
		distinationMap.put(1399,"Sandefjord - Norway - 40300");
		distinationMap.put(1300,"Sandhamn - Sweden - 40100");
		distinationMap.put(1446,"Sandnes - Norway - 40381");
		distinationMap.put(187,"Sandy Cove, NS - Canada - 13400");
		distinationMap.put(3064,"Sangi - Philippines - 56520");
		distinationMap.put(4535,"SANSABE - United States - 2606");
		distinationMap.put(762,"Santa Barbara de Samana - Dominican Republic - 24720");
		distinationMap.put(353,"Santa Catarina - Mexico - 20100");
		distinationMap.put(1137,"Santa Clara - Brazil - 35167");
		distinationMap.put(1200,"Santa Cruz - Argentina - 35700");
		distinationMap.put(3088,"Santa Cruz - Philippines - 56593");
		distinationMap.put(3038,"Santa Cruz (Davao Gulf) - Philippines - 56500");
		distinationMap.put(2122,"Santa Cruz de La Palma - Spain - 47072");
		distinationMap.put(2123,"Santa Cruz de Tenerife - Spain - 47073");
		distinationMap.put(683,"Santa Cruz del Sur - Cuba - 23983");
		distinationMap.put(987,"Santa Elena - Ecuador - 33100");
		distinationMap.put(1224,"Santa Fe - Argentina - 35791");
		distinationMap.put(3768,"Santa Isabel - Equatorial Gui - 73801");
		distinationMap.put(661,"Santa Lucia - Cuba - 23900");
		distinationMap.put(3039,"Santa Maria - Philippines - 56500");
		distinationMap.put(888,"Santa Marta - Colombia - 30140");
		distinationMap.put(2227,"Santa Panagia - Italy - 47556");
		distinationMap.put(374,"Santa Rosalia - Mexico - 20141");
		distinationMap.put(4521,"SANTA TERESA - United States - 2408");
		distinationMap.put(4522,"SANTA TERESA AIRPORT, DONA ANA COUNTY - United States - 2481");
		distinationMap.put(2870,"Santan Terminal - Indonesia - 56016");
		distinationMap.put(1134,"Santana - Brazil - 35165");
		distinationMap.put(2080,"Santander - Spain - 47013");
		distinationMap.put(1168,"Santarem - Brazil - 35198");
		distinationMap.put(1085,"Santiago - Chile - 33776");
		distinationMap.put(662,"Santiago de Cuba - Cuba - 23900");
		distinationMap.put(3571,"Santo - Vanuatu - 62207");
		distinationMap.put(770,"Santo Domingo - Dominican Republic - 24737");
		distinationMap.put(428,"Santo Tomas - Guatemala - 20505");
		distinationMap.put(429,"Santo Tomas de Castilla - Guatemala - 20505");
		distinationMap.put(354,"Santo Tomas Point - Mexico - 20100");
		distinationMap.put(1148,"Santos - Brazil - 35177");
		distinationMap.put(1151,"Sao Francisco do Sul - Brazil - 35179");
		distinationMap.put(1111,"Sao Luiz de Maranhao - Brazil - 35135");
		distinationMap.put(1169,"Sao Miguel dos Macaos - Brazil - 35198");
		distinationMap.put(1149,"Sao Paulo - Brazil - 35177");
		distinationMap.put(1146,"Sao Sebastio - Brazil - 35175");
		distinationMap.put(3906,"Sao Tome (St. Thomas) - Sao Tome and Princip - 76491");
		distinationMap.put(4264,"Sao Tome and Principe - Sao Tome and Principe - 7644");
		distinationMap.put(3849,"Sapele - Nigeria - 75383");
		distinationMap.put(3040,"Sarangani Bay - Philippines - 56500");
		distinationMap.put(3041,"Sarangani Island - Philippines - 56500");
		distinationMap.put(4474,"SARASOTA-BRADENTON AIRPORT - United States - 1883");
		distinationMap.put(4671,"SARLES - United States - 3409");
		distinationMap.put(44,"Sarnia, ONT - Canada - 05520");
		distinationMap.put(1400,"Sarpsborg - Norway - 40300");
		distinationMap.put(2242,"Sarroch Oil Terminal - Italy - 47567");
		distinationMap.put(1801,"Sas Van Gent - Netherlands - 42100");
		distinationMap.put(3317,"Sasebo - Japan - 58816");
		distinationMap.put(3806,"Sassandra - Ivory Coast - 74899");
		distinationMap.put(1802,"Sasvanghent - Netherlands - 42100");
		distinationMap.put(2766,"Satahib - Thailand - 54900");
		distinationMap.put(2767,"Satahip - Thailand - 54900");
		distinationMap.put(2768,"Sattahip - Thailand - 54900");
		distinationMap.put(1447,"Sauda - Norway - 40383");
		distinationMap.put(4176,"Saudi Arabia - Saudi Arabia - 5170");
		distinationMap.put(4705,"SAULT STE MARIE - United States - 3803");
		distinationMap.put(59,"Sault Ste. Marie, ONT - Canada - 08525");
		distinationMap.put(376,"Sauzal - Mexico - 20142");
		distinationMap.put(714,"Savanna La Mar - Jamaica - 24185");
		distinationMap.put(4460,"SAVANNAH - United States - 1703");
		distinationMap.put(2202,"Savona - Italy - 47517");
		distinationMap.put(3617,"Savu - Fiji - 68628");
		distinationMap.put(1752,"Scalloway,Shetland Is - United Kingdom - 41698");
		distinationMap.put(824,"Scarborough - Trinidad - 27451");
		distinationMap.put(1843,"Schelde - Belgium - 42306");
		distinationMap.put(1844,"Schelde Terminal - Belgium - 42306");
		distinationMap.put(1803,"Schiedam - Netherlands - 42100");
		distinationMap.put(4650,"SCOBEY - United States - 3309");
		distinationMap.put(35,"Scudder, ONT - Canada - 03507");
		distinationMap.put(1598,"Seaforth - United Kingdom - 41269");
		distinationMap.put(232,"Seal Cove, NB - Canada - 13829");
		distinationMap.put(1642,"Seal Sands - United Kingdom - 41377");
		distinationMap.put(4840,"SEARSPORT - United States - 0152");
		distinationMap.put(4591,"SEATTLE - United States - 3001");
		distinationMap.put(4615,"SEATTLE, TACOMA INTL. AIRPORT - United States - 3029");
		distinationMap.put(2845,"Sebarok - Singapore - 55901");
		distinationMap.put(139,"Sechelt, BC - Canada - 12219");
		distinationMap.put(233,"Seelys Basin, NB - Canada - 13829");
		distinationMap.put(234,"Seelys Cove, NB - Canada - 13829");
		distinationMap.put(235,"Seelys Head, NB - Canada - 13829");
		distinationMap.put(3444,"Seibu - Japan - 58898");
		distinationMap.put(2810,"Sejingkat - Malaysia - 55700");
		distinationMap.put(2834,"Selangor - Malaysia - 55742");
		distinationMap.put(4568,"SELBY - United States - 2827");
		distinationMap.put(1833,"Selzaete - Belgium - 42300");
		distinationMap.put(2913,"Semarang - Indonesia - 56051");
		distinationMap.put(3874,"Seme Terminal - Benin - 76102");
		distinationMap.put(4375,"Semipalatinsk - KAZAKHSTAN - 44911");
		distinationMap.put(4411,"Semipalatinsk - KAZAKHSTAN - 45101");
		distinationMap.put(3443,"Sendai - Japan - 58897");
		distinationMap.put(4244,"Senegal - Senegal - 7440");
		distinationMap.put(2864,"Senipah Terminal - Indonesia - 56009");
		distinationMap.put(3042,"Sepaco - Philippines - 56500");
		distinationMap.put(1153,"Sepetiba Bay - Brazil - 35185");
		distinationMap.put(273,"Sept Iles, QUE - Canada - 14444");
		distinationMap.put(2843,"Serangoon Harbor - Singapore - 55900");
		distinationMap.put(4160,"Serbia and Montenegro - Serbia and Montenegro - 4799");
		distinationMap.put(2972,"Seria - Brunei - 56150");
		distinationMap.put(2400,"Serifos - Greece - 48465");
		distinationMap.put(737,"Seringue - Haiti - 24500");
		distinationMap.put(2401,"Seriphos - Greece - 48465");
		distinationMap.put(2402,"Seriphos Island - Greece - 48465");
		distinationMap.put(52,"Serpent Harbor, ONT - Canada - 06767");
		distinationMap.put(1920,"Sete - France - 42789");
		distinationMap.put(2169,"Setubal - Portugal - 47141");
		distinationMap.put(2061,"Sevastopol - Ukraine - 46279");
		distinationMap.put(274,"Seven Islands, QUE - Canada - 14444");
		distinationMap.put(1997,"Severodvinsk - Russia - 46200");
		distinationMap.put(2095,"Sevilla - Spain - 47039");
		distinationMap.put(2096,"Seville - Spain - 47039");
		distinationMap.put(4275,"Seychelles - Seychelles - 7800");
		distinationMap.put(1241,"Seydhisfjordhur - Iceland - 40000");
		distinationMap.put(1242,"Seydisfjordur - Iceland - 40000");
		distinationMap.put(3699,"Sfax - Tunisia - 72337");
		distinationMap.put(1813,"&#39;sGravenhage - Netherlands - 42123");
		distinationMap.put(3176,"Shan T ou - China - 57070");
		distinationMap.put(3148,"Shang hai - China - 57035");
		distinationMap.put(3149,"Shanghai - China - 57035");
		distinationMap.put(3177,"Shantou - China - 57070");
		distinationMap.put(2644,"Sharjah - United Arab Em - 52070");
		distinationMap.put(1606,"Sharpness - United Kingdom - 41299");
		distinationMap.put(4701,"SHEBOYGAN - United States - 3707");
		distinationMap.put(1636,"Sheerness - United Kingdom - 41370");
		distinationMap.put(251,"Sheet Harbour, NS - Canada - 13888");
		distinationMap.put(3140,"Shekou - China - 57018");
		distinationMap.put(208,"Shelburne, NS - Canada - 13455");
		distinationMap.put(1637,"Shellhaven - United Kingdom - 41371");
		distinationMap.put(2303,"Shengjin - Albania - 48100");
		distinationMap.put(3802,"Sherbro - Sierra Leone - 74799");
		distinationMap.put(4674,"SHERWOOD - United States - 3414");
		distinationMap.put(2289,"Shibenik - Croatia - 47925");
		distinationMap.put(3286,"Shibusi-Wan - Japan - 58800");
		distinationMap.put(1677,"Shields - United Kingdom - 41398");
		distinationMap.put(1660,"Shields Harbor - United Kingdom - 41398");
		distinationMap.put(3287,"Shikama - Japan - 58800");
		distinationMap.put(3288,"Shikamacho - Japan - 58800");
		distinationMap.put(3244,"Shilong - China Taiwan - 58301");
		distinationMap.put(3414,"Shimizu - Japan - 58878");
		distinationMap.put(3315,"Shimonoseki - Japan - 58814");
		distinationMap.put(3417,"Shimotsu - Japan - 58879");
		distinationMap.put(3413,"Shiogama - Japan - 58877");
		distinationMap.put(4500,"SHREVEPORT-BOSSIER CITY - United States - 2018");
		distinationMap.put(2586,"Shuaiba - Kuwait - 51350");
		distinationMap.put(4971,"Shuwaikh - Kuwait - 51300");
		distinationMap.put(3020,"Siain - Philippines - 56500");
		distinationMap.put(2290,"Sibenik - Croatia - 47925");
		distinationMap.put(2963,"Sibolga - Indonesia - 56099");
		distinationMap.put(2871,"Sibuco Bay - Indonesia - 56017");
		distinationMap.put(2291,"Sibvenico - Croatia - 47925");
		distinationMap.put(3734,"Sidi Kerir - Egypt - 72914");
		distinationMap.put(160,"Sidney, BC - Canada - 12468");
		distinationMap.put(2515,"Sidon - Lebanon - 50400");
		distinationMap.put(4247,"Sierra Leone - Sierra Leone - 7470");
		distinationMap.put(3043,"Siete Pecados - Philippines - 56500");
		distinationMap.put(1243,"Siglufjordhur - Iceland - 40000");
		distinationMap.put(1244,"Siglufjordur - Iceland - 40000");
		distinationMap.put(2805,"Sihanoukville - Cambodia - 55500");
		distinationMap.put(2811,"Sijingkat - Malaysia - 55700");
		distinationMap.put(1301,"Sikea - Sweden - 40100");
		distinationMap.put(2696,"Sikka - India - 53305");
		distinationMap.put(3044,"Silay - Philippines - 56500");
		distinationMap.put(263,"Sillery, QUE - Canada - 14092");
		distinationMap.put(1607,"Silloth - United Kingdom - 41299");
		distinationMap.put(4697,"SILVER BAY - United States - 3614");
		distinationMap.put(3415,"Simizu - Japan - 58878");
		distinationMap.put(4008,"Simonstown - South Africa - 79100");
		distinationMap.put(3416,"Simotu - Japan - 58879");
		distinationMap.put(2164,"Sines - Portugal - 47127");
		distinationMap.put(4194,"Singapore - Singapore - 5590");
		distinationMap.put(2848,"Singapore - Singapore - 55976");
		distinationMap.put(3593,"Singave, Futuna - Wallis - 64131");
		distinationMap.put(2880,"Singkawang - Indonesia - 56020");
		distinationMap.put(2962,"Singkep Island - Indonesia - 56099");
		distinationMap.put(3916,"Sinoe - Liberia - 76500");
		distinationMap.put(849,"Sint Eustatius - Neth Antilles - 27730");
		distinationMap.put(831,"Sint Nicolaas Baai - Aruba - 27702");
		distinationMap.put(2234,"Siracusa - Italy - 47558");
		distinationMap.put(2547,"Sirri Island - Iran - 50700");
		distinationMap.put(3714,"Sirtica Terminal - Libya - 72520");
		distinationMap.put(4629,"SITKA - United States - 3115");
		distinationMap.put(2676,"Sitra - Bahrain - 52500");
		distinationMap.put(2677,"Sitrah - Bahrain - 52500");
		distinationMap.put(1521,"Sjaelland - Denmark - 40900");
		distinationMap.put(1522,"Sjaellands Odde - Denmark - 40900");
		distinationMap.put(1523,"Skagen - Denmark - 40900");
		distinationMap.put(4622,"SKAGWAY - United States - 3103");
		distinationMap.put(2413,"Skaramanga - Greece - 48476");
		distinationMap.put(2414,"Skaramanga Bay - Greece - 48476");
		distinationMap.put(2304,"Skele e Vlores - Albania - 48100");
		distinationMap.put(1334,"Skelleftea - Sweden - 40124");
		distinationMap.put(1335,"Skelleftehamn - Sweden - 40124");
		distinationMap.put(1448,"Skien - Norway - 40385");
		distinationMap.put(3683,"Skikda - Algeria - 72189");
		distinationMap.put(1302,"Skogholl - Sweden - 40100");
		distinationMap.put(1490,"Skoldvik - Finland - 40534");
		distinationMap.put(1303,"Skonvik - Sweden - 40100");
		distinationMap.put(1305,"Skutskar - Sweden - 40100");
		distinationMap.put(68,"Slate Islands, ONT - Canada - 09000");
		distinationMap.put(1769,"Sligo - Ireland - 41900");
		distinationMap.put(1306,"Slite - Sweden - 40100");
		distinationMap.put(4129,"Slovakia - Slovakia - 4359");
		distinationMap.put(4157,"Slovenia - Slovenia - 4792");
		distinationMap.put(1819,"Sluiskil - Netherlands - 42165");
		distinationMap.put(1820,"Sluiskill - Netherlands - 42165");
		distinationMap.put(974,"Smalkalden - Suriname - 31523");
		distinationMap.put(355,"Socorro Island - Mexico - 20100");
		distinationMap.put(3445,"Sodegaura - Japan - 58899");
		distinationMap.put(1353,"Soderhamn - Sweden - 40174");
		distinationMap.put(4385,"SODERTALJE - Sweden - SODER");
		distinationMap.put(4877,"SODUS POINT - United States - 0905");
		distinationMap.put(2964,"Soengaigerong - Indonesia - 56099");
		distinationMap.put(2914,"Soerabaja - Indonesia - 56053");
		distinationMap.put(2915,"Soerabaya - Indonesia - 56053");
		distinationMap.put(4946,"Sohar - Oman - 52300");
		distinationMap.put(4973,"Sohar - Oman - 52335");
		distinationMap.put(2293,"Solin - Croatia - 47931");
		distinationMap.put(4220,"Solomon Islands - Solomon Islands - 6223");
		distinationMap.put(4269,"Somalia - Somalia - 7700");
		distinationMap.put(39,"Sombra, ONT - Canada - 05512");
		distinationMap.put(790,"Sombrero Island - Anguilla - 24823");
		distinationMap.put(491,"Somoza - Nicaragua - 21999");
		distinationMap.put(1401,"Son - Norway - 40300");
		distinationMap.put(1525,"Sonderborg - Denmark - 40900");
		distinationMap.put(2965,"Songei Gerong - Indonesia - 56099");
		distinationMap.put(2780,"Songkhla - Thailand - 54927");
		distinationMap.put(2781,"Songkhla Harbor - Thailand - 54927");
		distinationMap.put(58,"Soo, ONT - Canada - 08525");
		distinationMap.put(123,"Sooke, BC - Canada - 12205");
		distinationMap.put(1307,"Soraker - Sweden - 40100");
		distinationMap.put(275,"Sorel, QUE - Canada - 14466");
		distinationMap.put(2885,"Sorong - Indonesia - 56023");
		distinationMap.put(2195,"Sorrento - Italy - 47500");
		distinationMap.put(3045,"Sorsogon - Philippines - 56500");
		distinationMap.put(2354,"Souda Bay - Greece - 48406");
		distinationMap.put(2355,"Soudha - Greece - 48406");
		distinationMap.put(276,"Souris, PEI - Canada - 14467");
		distinationMap.put(3700,"Sousee - Tunisia - 72357");
		distinationMap.put(4285,"South Africa - South Africa - 7910");
		distinationMap.put(1229,"South Georgia - Falk Is - 37200");
		distinationMap.put(1230,"South Orkneys - Falk Is - 37200");
		distinationMap.put(117,"South Pender Island, BC - Canada - 12200");
		distinationMap.put(599,"South Riding Point - Bahamas - 23645");
		distinationMap.put(1231,"South Sandwich Islands - Falk Is - 37200");
		distinationMap.put(1232,"South Shetlands - Falk Is - 37200");
		distinationMap.put(4553,"SOUTHERN CALIFORNIA LOGISTICS AIRPORT VICTORVILLE - United States - 2783");
		distinationMap.put(4349,"Southhampton - United Kingdom - 4120");
		distinationMap.put(4350,"Southhampton - United Kingdom - 4120");
		distinationMap.put(1638,"Southhampton - United Kingdom - 41374");
		distinationMap.put(4885,"Southlake - United States - 4601");
		distinationMap.put(2036,"Sovetskaya Gavan - Russia - 46239");
		distinationMap.put(3879,"Soyo Oil Terminal - Angola - 76281");
		distinationMap.put(3880,"Soyo-Quinfuquena term. - Angola - 76281");
		distinationMap.put(4149,"Spain - Spain - 4700");
		distinationMap.put(2294,"Spalato - Croatia - 47931");
		distinationMap.put(579,"Spanish Wells - Bahamas - 23622");
		distinationMap.put(810,"Speightstown - Barbados - 27213");
		distinationMap.put(188,"Spences Island, NS - Canada - 13400");
		distinationMap.put(1453,"Spitsbergen - Sv Jm Islands - 40398");
		distinationMap.put(2295,"Split - Croatia - 47931");
		distinationMap.put(53,"Spragge, ONT - Canada - 06767");
		distinationMap.put(4850,"SPRINGFIELD - United States - 0402");
		distinationMap.put(4761,"SPRINGFIELD - United States - 4505");
		distinationMap.put(127,"Squamish, BC - Canada - 12208");
		distinationMap.put(4187,"Sri Lanka - Sri Lanka - 5420");
		distinationMap.put(2777,"Sri Racha - Thailand - 54905");
		distinationMap.put(2778,"Sriracha - Thailand - 54905");
		distinationMap.put(4257,"St Helena - St Helena - 7580");
		distinationMap.put(4084,"St Kitts and Nevis - St Kitts and Nevis - 2483");
		distinationMap.put(4088,"St Lucia - St Lucia - 2487");
		distinationMap.put(4089,"St Vincent and the Grenadines - St Vincent and the Grenadines - 2488");
		distinationMap.put(4842,"ST. ALBANS - United States - 0201");
		distinationMap.put(267,"St. Andrews, NB - Canada - 14426");
		distinationMap.put(853,"St. Anne - Guadeloupe - 28300");
		distinationMap.put(701,"St. Ann&#39;s Bay - Jamaica - 24100");
		distinationMap.put(295,"St. Anthony, NFLD - Canada - 15212");
		distinationMap.put(860,"St. Barthelemy - Guadeloupe - 28319");
		distinationMap.put(861,"St. Bartholomew - Guadeloupe - 28319");
		distinationMap.put(862,"St. Barth&#39;s - Guadeloupe - 28319");
		distinationMap.put(12,"St. Catharines, ONT - Canada - 01690");
		distinationMap.put(4025,"St. Croix - US Virgin Is - 91149");
		distinationMap.put(4001,"St. Denis - Reunion - 79052");
		distinationMap.put(850,"St. Eustatius - Neth Antilles - 27730");
		distinationMap.put(804,"St. George - Grenada - 24881");
		distinationMap.put(566,"St. Georges - Bermuda - 23251");
		distinationMap.put(805,"St. George&#39;s - Grenada - 24881");
		distinationMap.put(2343,"St. George&#39;s Bay - Greece - 48400");
		distinationMap.put(4667,"ST. JOHN - United States - 3405");
		distinationMap.put(792,"St. John&#39;s, Antigua - Antigua - 24831");
		distinationMap.put(312,"St. John&#39;s, NFLD - Canada - 15282");
		distinationMap.put(4758,"ST. JOSEPH - United States - 4502");
		distinationMap.put(979,"St. Laurent - French Guiana - 31700");
		distinationMap.put(314,"St. Lawrence, NFLD - Canada - 15283");
		distinationMap.put(4759,"ST. LOUIS - United States - 4503");
		distinationMap.put(1917,"St. Louis du Rhon - France - 42785");
		distinationMap.put(847,"St. Maarten - Neth Antilles - 27727");
		distinationMap.put(1872,"St. Malo - France - 42700");
		distinationMap.put(752,"St. Marc - Haiti - 24591");
		distinationMap.put(854,"St. Martin - Guadeloupe - 28300");
		distinationMap.put(848,"St. Martin - Neth Antilles - 27727");
		distinationMap.put(842,"St. Michiel&#39;s Bay - Neth Antilles - 27725");
		distinationMap.put(1906,"St. Nazaire - France - 42762");
		distinationMap.put(832,"St. Nicolaas - Aruba - 27702");
		distinationMap.put(4303,"St. Petersburg - Finland - 40549");
		distinationMap.put(4316,"St. Petersburg - Russia - 40549");
		distinationMap.put(2003,"St. Petersburg - Russia - 46215");
		distinationMap.put(4468,"ST. PETERSBURG - United States - 1814");
		distinationMap.put(875,"St. Pierre - Martinique - 28399");
		distinationMap.put(319,"St. Pierre - St. Pierre/Miq - 16101");
		distinationMap.put(1937,"St. Raphael - France - 42799");
		distinationMap.put(262,"St. Romuald, QUE - Canada - 14090");
		distinationMap.put(4495,"ST. ROSE - United States - 2013");
		distinationMap.put(4029,"ST. Thomas - US Virgin Is - 91155");
		distinationMap.put(2124,"Sta. Cruz de Tenerife - Spain - 47073");
		distinationMap.put(1956,"Stade - Germany - 42879");
		distinationMap.put(1957,"Stadersand - Germany - 42879");
		distinationMap.put(2881,"Stagen - Indonesia - 56020");
		distinationMap.put(1588,"Stanlow - United Kingdom - 41227");
		distinationMap.put(444,"Stann Creek - Belize - 20803");
		distinationMap.put(161,"Stanovan, BC - Canada - 12475");
		distinationMap.put(1449,"Stavanger - Norway - 40387");
		distinationMap.put(1526,"Stege - Denmark - 40900");
		distinationMap.put(1402,"Steilene - Norway - 40300");
		distinationMap.put(1397,"Steinkjer - Norway - 40300");
		distinationMap.put(1354,"Stenungsund - Sweden - 40176");
		distinationMap.put(315,"Stephenville, NL - Canada - 15285");
		distinationMap.put(1986,"Stettin - Poland - 45507");
		distinationMap.put(119,"Steveston, BC - Canada - 12200");
		distinationMap.put(3529,"Stewart Island - New Zealand - 61400");
		distinationMap.put(162,"Stewart, BC - Canada - 12478");
		distinationMap.put(1568,"Stigsnaes - Denmark - 40971");
		distinationMap.put(1569,"Stigsnaesvaerkets Havn - Denmark - 40971");
		distinationMap.put(1308,"Stocka - Sweden - 40100");
		distinationMap.put(1355,"Stockholm - Sweden - 40179");
		distinationMap.put(1678,"Stockton - United Kingdom - 41398");
		distinationMap.put(4560,"STOCKTON - United States - 2810");
		distinationMap.put(1356,"Stockvik - Sweden - 40180");
		distinationMap.put(4322,"ST-PETERSBURG - Russia - 40549");
		distinationMap.put(1942,"Stralsund - Germany - 42800");
		distinationMap.put(2344,"Stratoni - Greece - 48400");
		distinationMap.put(1557,"Struer - Denmark - 40927");
		distinationMap.put(1527,"Stubbekobing - Denmark - 40900");
		distinationMap.put(1413,"Sture - Norway - 40311");
		distinationMap.put(3245,"Su Ao - China Taiwan - 58302");
		distinationMap.put(3246,"Suao - China Taiwan - 58302");
		distinationMap.put(1142,"Suape - Brazil - 35170");
		distinationMap.put(3082,"Subic Bay - Philippines - 56585");
		distinationMap.put(4239,"Sudan - Sudan - 7320");
		distinationMap.put(2917,"Suerbaja - Indonesia - 56053");
		distinationMap.put(3745,"Suez - Egypt - 72949");
		distinationMap.put(4572,"SUISUN BAY - United States - 2831");
		distinationMap.put(2882,"Sukarnapura - Indonesia - 56021");
		distinationMap.put(2066,"Sukhumi - Georgia - 46350");
		distinationMap.put(2419,"Sulina - Romania - 48500");
		distinationMap.put(1735,"Sullom Voe - United Kingdom - 41682");
		distinationMap.put(2672,"Sultan Qaboos - Oman - 52325");
		distinationMap.put(4599,"SUMAS - United States - 3009");
		distinationMap.put(277,"Summerside, PEI - Canada - 14470");
		distinationMap.put(1640,"Sunderland - United Kingdom - 41376");
		distinationMap.put(1357,"Sundsvall - Sweden - 40182");
		distinationMap.put(2936,"Sungai Kolak - Indonesia - 56066");
		distinationMap.put(2966,"Sungai Pakning - Indonesia - 56099");
		distinationMap.put(2967,"Sungaigerong - Indonesia - 56099");
		distinationMap.put(2968,"Sungaipakning - Indonesia - 56099");
		distinationMap.put(2969,"Sungei Pakning - Indonesia - 56099");
		distinationMap.put(1450,"Sunndalsora - Norway - 40390");
		distinationMap.put(1044,"Supe - Peru - 33385");
		distinationMap.put(4695,"SUPERIOR - United States - 3608");
		distinationMap.put(2660,"Sur - Oman - 52310");
		distinationMap.put(2918,"Surabaia - Indonesia - 56053");
		distinationMap.put(2919,"Surabaja - Indonesia - 56053");
		distinationMap.put(2916,"Surabaya - Indonesia - 56053");
		distinationMap.put(4923,"Surgoinsvi - United States - 1601");
		distinationMap.put(3046,"Surigao - Philippines - 56500");
		distinationMap.put(4100,"Suriname - Suriname - 3150");
		distinationMap.put(3701,"Susa - Tunisia - 72357");
		distinationMap.put(2287,"Susak - Croatia - 47923");
		distinationMap.put(2288,"Susaka - Croatia - 47923");
		distinationMap.put(3326,"Susaki - Japan - 58822");
		distinationMap.put(1679,"Sutton Harbor - United Kingdom - 41398");
		distinationMap.put(3618,"Suva - Fiji - 68628");
		distinationMap.put(3619,"Suva Harbor - Fiji - 68628");
		distinationMap.put(1454,"Svalbard, Jan Mayen Isl - Sv Jm Islands - 40398");
		distinationMap.put(4113,"Svalbard, Jan Mayen Island - Svalbard, Jan Mayen Island - 4031");
		distinationMap.put(1309,"Svartvik - Sweden - 40100");
		distinationMap.put(1451,"Svelgen - Norway - 40392");
		distinationMap.put(1558,"Svendborg - Denmark - 40928");
		distinationMap.put(1403,"Svolvaer - Norway - 40300");
		distinationMap.put(1700,"Swansea - United Kingdom - 41485");
		distinationMap.put(3178,"Swatou - China - 57070");
		distinationMap.put(3179,"Swatow - China - 57070");
		distinationMap.put(4289,"Swaziland - Swaziland - 7950");
		distinationMap.put(4112,"Sweden - Sweden - 4010");
		distinationMap.put(4651,"SWEETGRASS - United States - 3310");
		distinationMap.put(4881,"SWIFT SURE COURIER SERVICES, LTD. - United States - 0972");
		distinationMap.put(1990,"Swinemunde - Poland - 45512");
		distinationMap.put(1991,"Swinoujscie - Poland - 45512");
		distinationMap.put(4774,"SWISS AIR - United States - 4776");
		distinationMap.put(4132,"Switzerland - Switzerland - 4419");
		distinationMap.put(3489,"Sydney - Australia - 60267");
		distinationMap.put(244,"Sydney, NS - Canada - 13852");
		distinationMap.put(2345,"Syra - Greece - 48400");
		distinationMap.put(2235,"Syracuse - Italy - 47558");
		distinationMap.put(4878,"SYRACUSE - United States - 0906");
		distinationMap.put(4167,"Syria - Syria - 5020");
		distinationMap.put(2403,"Syros - Greece - 48466");
		distinationMap.put(1987,"Szczecin - Poland - 45507");
		distinationMap.put(3083,"Tabaco - Philippines - 56588");
		distinationMap.put(3688,"Tabarca - Tunisia - 72300");
		distinationMap.put(3690,"Tabarqah - Tunisia - 72300");
		distinationMap.put(561,"Taboga Island - Panama - 22599");
		distinationMap.put(3289,"Tachibana - Japan - 58800");
		distinationMap.put(3084,"Tacloban - Philippines - 56589");
		distinationMap.put(4592,"TACOMA - United States - 3002");
		distinationMap.put(2038,"Taganrog - Russia - 46242");
		distinationMap.put(3047,"Tagbilaran - Philippines - 56500");
		distinationMap.put(3418,"Tagonoura - Japan - 58880");
		distinationMap.put(3048,"Tagubanham Island - Philippines - 56500");
		distinationMap.put(3049,"Tagum - Philippines - 56500");
		distinationMap.put(3600,"Tahaa - French Polyn - 64178");
		distinationMap.put(163,"Tahsis, BC - Canada - 12482");
		distinationMap.put(3247,"Tai Chung - China Taiwan - 58303");
		distinationMap.put(3249,"Taibei - China Taiwan - 58304");
		distinationMap.put(3248,"Taichung - China Taiwan - 58303");
		distinationMap.put(3252,"Tai-Nan - China Taiwan - 58305");
		distinationMap.put(3251,"Tainan - China Taiwan - 58305");
		distinationMap.put(3250,"Taipei - China Taiwan - 58304");
		distinationMap.put(3050,"Taisan - Philippines - 56500");
		distinationMap.put(4207,"Taiwan - Taiwan - 5830");
		distinationMap.put(4146,"Tajikistan - Tajikistan - 4642");
		distinationMap.put(3290,"Takamatsu - Japan - 58800");
		distinationMap.put(3291,"Taketoyo - Japan - 58800");
		distinationMap.put(3817,"Takoradi - Ghana - 74985");
		distinationMap.put(3883,"Takula - Angola - 76284");
		distinationMap.put(3884,"Takula Terminal - Angola - 76284");
		distinationMap.put(1045,"Talara - Peru - 33389");
		distinationMap.put(1088,"Talcahuano - Chile - 33781");
		distinationMap.put(1972,"Tallinn - Estonia - 44701");
		distinationMap.put(3051,"Talomo - Philippines - 56500");
		distinationMap.put(1066,"Taltal - Chile - 33700");
		distinationMap.put(3292,"Tama - Japan - 58800");
		distinationMap.put(3993,"Tamatave - Madagascar - 78845");
		distinationMap.put(4462,"TAMPA - United States - 1801");
		distinationMap.put(405,"Tampico - Mexico - 20193");
		distinationMap.put(3255,"Tamsui - China Taiwan - 58311");
		distinationMap.put(3293,"Tanabe - Japan - 58800");
		distinationMap.put(682,"Tanamo - Cuba - 23979");
		distinationMap.put(3089,"Tandoc - Philippines - 56594");
		distinationMap.put(3950,"Tanga - Tanzania - 78379");
		distinationMap.put(3654,"Tanger - Morocco - 71425");
		distinationMap.put(3655,"Tangier - Morocco - 71425");
		distinationMap.put(3147,"Tanjiajing - China - 57030");
		distinationMap.put(2812,"Tanjong Mani - Malaysia - 55700");
		distinationMap.put(2860,"Tanjong Pandan - Indonesia - 56005");
		distinationMap.put(2835,"Tanjung Pelepas - Malaysia - 55750");
		distinationMap.put(2896,"Tanjung Priok - Indonesia - 56033");
		distinationMap.put(2861,"Tanjungpandan - Indonesia - 56005");
		distinationMap.put(2852,"Tanjunguban - Indonesia - 56000");
		distinationMap.put(4277,"Tanzania - Tanzania - 7830");
		distinationMap.put(3548,"Taoranga - New Zealand - 61443");
		distinationMap.put(2236,"Taormina - Italy - 47558");
		distinationMap.put(2872,"Tarakan - Indonesia - 56018");
		distinationMap.put(2873,"Tarakan Island - Indonesia - 56018");
		distinationMap.put(2257,"Taranto - Italy - 47585");
		distinationMap.put(894,"Tarapaca - Colombia - 30198");
		distinationMap.put(4420,"Taraz - Kazakhstan - 44911");
		distinationMap.put(1784,"Tarbert - Ireland - 41920");
		distinationMap.put(1785,"Tarbert Island - Ireland - 41920");
		distinationMap.put(2092,"Tarifa - Spain - 47032");
		distinationMap.put(2132,"Tarragona - Spain - 47092");
		distinationMap.put(2511,"Tartous - Syria - 50220");
		distinationMap.put(2512,"Tartus - Syria - 50220");
		distinationMap.put(2432,"Tas Oudjou - Turkey - 48900");
		distinationMap.put(4343,"TASHKENT - UZBEKISTAN - 44911");
		distinationMap.put(4399,"Tashkent - Uzbekistan - 5700");
		distinationMap.put(2433,"Tash-Uju - Turkey - 48900");
		distinationMap.put(2434,"Tasucu - Turkey - 48900");
		distinationMap.put(1404,"Tau - Norway - 40300");
		distinationMap.put(3549,"Tauranga - New Zealand - 61443");
		distinationMap.put(2756,"Tavoy - Burma - 54600");
		distinationMap.put(2813,"Tawao - Malaysia - 55700");
		distinationMap.put(2814,"Tawau - Malaysia - 55700");
		distinationMap.put(3860,"Tchatamba - Gabon - 75503");
		distinationMap.put(1094,"Tebig - Brazil - 35107");
		distinationMap.put(4527,"TECATE - United States - 2505");
		distinationMap.put(416,"Tecolutla - Mexico - 20195");
		distinationMap.put(1643,"Tees - United Kingdom - 41377");
		distinationMap.put(1644,"Teesport - United Kingdom - 41377");
		distinationMap.put(2920,"Tegal - Indonesia - 56055");
		distinationMap.put(2548,"Teheran - Iran - 50700");
		distinationMap.put(2549,"Tehran - Iran - 50700");
		distinationMap.put(1680,"Teignmouth - United Kingdom - 41398");
		distinationMap.put(1681,"Teignmouth Harbor - United Kingdom - 41398");
		distinationMap.put(2496,"Tekirdag - Turkey - 48999");
		distinationMap.put(2568,"Tel Aviv Yafo - Israel - 50845");
		distinationMap.put(463,"Tela - Honduras - 21543");
		distinationMap.put(2691,"Tellicherry - India - 53300");
		distinationMap.put(2948,"Teluk Bayur - Indonesia - 56081");
		distinationMap.put(3818,"Tema - Ghana - 74990");
		distinationMap.put(823,"Tembladora - Trinidad - 27446");
		distinationMap.put(2125,"Tenerife - Spain - 47073");
		distinationMap.put(3666,"Tenes - Algeria - 72100");
		distinationMap.put(991,"Tepre - Ecuador - 33109");
		distinationMap.put(2177,"Terceira Island - Portugal - 47155");
		distinationMap.put(1834,"Terdonck Cluysen - Belgium - 42300");
		distinationMap.put(1835,"Terdouk - Belgium - 42300");
		distinationMap.put(1170,"Termisa Terminal - Brazil - 35198");
		distinationMap.put(2933,"Ternate - Indonesia - 56064");
		distinationMap.put(1821,"Terneuzen - Netherlands - 42171");
		distinationMap.put(2220,"Terranova - Italy - 47543");
		distinationMap.put(2221,"Terranova di Sicilia - Italy - 47543");
		distinationMap.put(2247,"Terranova Pausania - Italy - 47569");
		distinationMap.put(124,"Texada, BC - Canada - 12206");
		distinationMap.put(4803,"TEXAS CITY - United States - 5306");
		distinationMap.put(4189,"Thailand - Thailand - 5490");
		distinationMap.put(1645,"Thames Haven - United Kingdom - 41378");
		distinationMap.put(1624,"Thamesport - United Kingdom - 41351");
		distinationMap.put(2800,"Thanh Pho Ho Chi Minh - Vietnam - 55224");
		distinationMap.put(1814,"The Hague - Netherlands - 42123");
		distinationMap.put(61,"Thessalon, ONT - Canada - 08527");
		distinationMap.put(2408,"Thessaloniki - Greece - 48471");
		distinationMap.put(3589,"Thio - New Caledonia - 64100");
		distinationMap.put(1528,"Thisted - Denmark - 40900");
		distinationMap.put(1245,"Thorlakshofn - Iceland - 40000");
		distinationMap.put(31,"Thorold, ONT - Canada - 02649");
		distinationMap.put(1574,"Thorshavn - Faroe - 40985");
		distinationMap.put(280,"Three Rivers, QUE - Canada - 14474");
		distinationMap.put(101,"Thule - Greenland - 10101");
		distinationMap.put(77,"Thunder Bay, ONT - Canada - 09662");
		distinationMap.put(3454,"Thursday Island - Australia - 60200");
		distinationMap.put(3150,"Tianjin - China - 57043");
		distinationMap.put(3151,"Tianjinxin Gang - China - 57043");
		distinationMap.put(738,"Tiburon - Haiti - 24500");
		distinationMap.put(3152,"Tienching - China - 57043");
		distinationMap.put(3153,"Tientsin - China - 57043");
		distinationMap.put(3785,"Tiko - Cameroon - 74298");
		distinationMap.put(2029,"Tiksi - Russia - 46239");
		distinationMap.put(1646,"Tilbury - United Kingdom - 41380");
		distinationMap.put(3550,"Timaru - New Zealand - 61445");
		distinationMap.put(2937,"Timor - Indonesia - 56067");
		distinationMap.put(3846,"Tin Can Island - Nigeria - 75367");
		distinationMap.put(4054,"Tinian - Northern Marian - 96169");
		distinationMap.put(2902,"Tjilatjap - Indonesia - 56036");
		distinationMap.put(2900,"Tjirebon - Indonesia - 56035");
		distinationMap.put(421,"Tlacotalpan - Mexico - 20195");
		distinationMap.put(4552,"TNT EXPRESS WORLDWIDE LA - United States - 2775");
		distinationMap.put(4880,"TNT SKYPAK, BUFFALO - United States - 0971");
		distinationMap.put(4577,"TNT SKYPAL, SAN FRANCISCO - United States - 2872");
		distinationMap.put(4776,"TNT SKYPATH,  JFK AIRPORT - United States - 4778");
		distinationMap.put(3994,"Toamasina - Madagascar - 78845");
		distinationMap.put(815,"Tobago - Trinidad - 27400");
		distinationMap.put(3419,"Tobata - Japan - 58881");
		distinationMap.put(3704,"Tobruch - Libya - 72500");
		distinationMap.put(3705,"Tobruk - Libya - 72500");
		distinationMap.put(1090,"Tocopilla - Chile - 33788");
		distinationMap.put(1405,"Tofte - Norway - 40300");
		distinationMap.put(4252,"Togo - Togo - 7520");
		distinationMap.put(4217,"Tokelau - Tokelau - 6143");
		distinationMap.put(3556,"Tokelau - Tokelau - 61471");
		distinationMap.put(3427,"Tokuyama - Japan - 58885");
		distinationMap.put(3428,"Tokyo - Japan - 58886");
		distinationMap.put(3989,"Tolaguaro - Madagascar - 78800");
		distinationMap.put(4736,"TOLEDO-SANDUSKY - United States - 4105");
		distinationMap.put(3990,"Toliara - Madagascar - 78800");
		distinationMap.put(3991,"Toliary - Madagascar - 78800");
		distinationMap.put(1465,"Tolkis - Finland - 40500");
		distinationMap.put(1466,"Tolkkinen - Finland - 40500");
		distinationMap.put(3310,"Tomakomai - Japan - 58811");
		distinationMap.put(3895,"Tombua - Angola - 76299");
		distinationMap.put(1067,"Tome - Chile - 33700");
		distinationMap.put(4310,"Tomsk - Russia - 40549");
		distinationMap.put(4233,"Tonga - Tonga - 6864");
		distinationMap.put(3210,"Tonghae - South Korea - 58014");
		distinationMap.put(1873,"Tonnay Charente - France - 42700");
		distinationMap.put(562,"Tonosi - Panama - 22599");
		distinationMap.put(1406,"Tonsberg - Norway - 40300");
		distinationMap.put(364,"Topolobampo - Mexico - 20106");
		distinationMap.put(1485,"Toppila - Finland - 40531");
		distinationMap.put(1467,"Tornea - Finland - 40500");
		distinationMap.put(1468,"Tornio - Finland - 40500");
		distinationMap.put(7,"Toronto, ONT - Canada - 01535");
		distinationMap.put(2454,"Toros Gubre - Turkey - 48932");
		distinationMap.put(2196,"Torre Annunziata - Italy - 47500");
		distinationMap.put(772,"Torrecilla - Dominican Republic - 24738");
		distinationMap.put(2131,"Torrevieja - Spain - 47090");
		distinationMap.put(1575,"Torshavn - Faroe - 40985");
		distinationMap.put(1921,"Toulon - France - 42790");
		distinationMap.put(2791,"Tourane - Vietnam - 55204");
		distinationMap.put(99,"Tovkusoak - Greenland - 10100");
		distinationMap.put(100,"Tovqussaq - Greenland - 10100");
		distinationMap.put(3490,"Townsville - Australia - 60273");
		distinationMap.put(3309,"Toyama - Japan - 58810");
		distinationMap.put(3423,"Toyohashi - Japan - 58883");
		distinationMap.put(3424,"Toyohasi - Japan - 58883");
		distinationMap.put(2497,"Trabzon - Turkey - 48999");
		distinationMap.put(21,"Tracy, QUE - Canada - 01807");
		distinationMap.put(1770,"Tralee - Ireland - 41900");
		distinationMap.put(1126,"Tramandai - Brazil - 35161");
		distinationMap.put(2268,"Trani - Italy - 47598");
		distinationMap.put(2237,"Trapani - Italy - 47558");
		distinationMap.put(597,"Treasure Cay - Bahamas - 23644");
		distinationMap.put(2498,"Trebizond - Turkey - 48999");
		distinationMap.put(1358,"Trelleborg - Sweden - 40185");
		distinationMap.put(4501,"TRI-CITY USERFEE AIRPORT, BLOUNTVILLE - United States - 2082");
		distinationMap.put(4961,"Trieste - 39 - 47587");
		distinationMap.put(4960,"Trieste - Italy - 47587");
		distinationMap.put(2258,"Trieste - Italy - 47587");
		distinationMap.put(2754,"Trincomalee - Sri Lanka - 54205");
		distinationMap.put(2753,"Trincomali - Sri Lanka - 54205");
		distinationMap.put(4092,"Trinidad and Tobago - Trinidad and Tobago - 2740");
		distinationMap.put(2516,"Tripoli - Lebanon - 50400");
		distinationMap.put(3715,"Tripoli - Libya - 72525");
		distinationMap.put(281,"Trois Rivieres, QUE - Canada - 14474");
		distinationMap.put(1310,"Trollhattan - Sweden - 40100");
		distinationMap.put(1311,"Trollhatte Canal - Sweden - 40100");
		distinationMap.put(1147,"Trombetas - Brazil - 35176");
		distinationMap.put(1429,"Tromso - Norway - 40338");
		distinationMap.put(1452,"Trondheim - Norway - 40397");
		distinationMap.put(1710,"Troon - United Kingdom - 41600");
		distinationMap.put(4873,"TROUT RIVER - United States - 0715");
		distinationMap.put(454,"Trujillo - Honduras - 21500");
		distinationMap.put(1029,"Trujillo - Peru - 33300");
		distinationMap.put(3612,"Truk, Truk Islands - Micronesia - 68205");
		distinationMap.put(1682,"Truro - United Kingdom - 41398");
		distinationMap.put(3186,"Tsamkong - China - 57075");
		distinationMap.put(3159,"Tsingtao - China - 57047");
		distinationMap.put(3432,"Tsukumi - Japan - 58889");
		distinationMap.put(3294,"Tsuruga - Japan - 58800");
		distinationMap.put(2039,"Tuapse - Russia - 46245");
		distinationMap.put(1125,"Tubarao - Brazil - 35160");
		distinationMap.put(1529,"Tuborg - Denmark - 40900");
		distinationMap.put(1530,"Tuborg Havn - Denmark - 40900");
		distinationMap.put(919,"Tucacas - Venezuela - 30700");
		distinationMap.put(4537,"TUCSON - United States - 2609");
		distinationMap.put(215,"Tuktoyaktuk, NWT - Canada - 13470");
		distinationMap.put(3566,"Tulaghi - Solomon Is - 62200");
		distinationMap.put(3567,"Tulagi - Solomon Is - 62200");
		distinationMap.put(2420,"Tulcea - Romania - 48500");
		distinationMap.put(3992,"Tulear - Madagascar - 78800");
		distinationMap.put(4815,"TULSA - United States - 5505");
		distinationMap.put(891,"Tumaco - Colombia - 30152");
		distinationMap.put(663,"Tunas de Zaza - Cuba - 23900");
		distinationMap.put(3702,"Tunis - Tunisia - 72373");
		distinationMap.put(4236,"Tunisia - Tunisia - 7230");
		distinationMap.put(889,"Turbo - Colombia - 30145");
		distinationMap.put(920,"Turiamo - Venezuela - 30700");
		distinationMap.put(4165,"Turkey - Turkey - 4890");
		distinationMap.put(4147,"Turkmenistan - Turkmenistan - 4643");
		distinationMap.put(1505,"Turku - Finland - 40587");
		distinationMap.put(4647,"TURNER - United States - 3306");
		distinationMap.put(4921,"Tuscumbia  - United States - 1703");
		distinationMap.put(2720,"Tuticorin - India - 53395");
		distinationMap.put(1129,"Tutoia - Brazil - 35163");
		distinationMap.put(1130,"Tutoya - Brazil - 35163");
		distinationMap.put(2459,"Tutunciftlik - Turkey - 48940");
		distinationMap.put(4224,"Tuvalu - Tuvalu - 6227");
		distinationMap.put(423,"Tuxpan - Mexico - 20197");
		distinationMap.put(1576,"Tvoroyri - Faroe - 40985");
		distinationMap.put(128,"Twin Creeks, BC - Canada - 12208");
		distinationMap.put(1683,"Tynemouth - United Kingdom - 41398");
		distinationMap.put(3431,"Ube - Japan - 58888");
		distinationMap.put(138,"Ucuelet, BC - Canada - 12218");
		distinationMap.put(1359,"Uddevalla - Sweden - 40188");
		distinationMap.put(4273,"Uganda - Uganda - 7780");
		distinationMap.put(3295,"Ujina - Japan - 58800");
		distinationMap.put(2889,"Ujung Pandang - Indonesia - 56027");
		distinationMap.put(3838,"Ukpokiti - Nigeria - 75323");
		distinationMap.put(4139,"Ukraine - Ukraine - 4623");
		distinationMap.put(4357,"ULAANBATOR - Mongolia - QINGD");
		distinationMap.put(4364,"ULAN BATOR - MONGOLIA - 57047");
		distinationMap.put(1486,"Uleaborg - Finland - 40531");
		distinationMap.put(1312,"Ulfvik - Sweden - 40100");
		distinationMap.put(3232,"Ulsan - South Korea - 58061");
		distinationMap.put(4879,"ULTICA - United States - 0907");
		distinationMap.put(1313,"Ulvvik - Sweden - 40100");
		distinationMap.put(1336,"Umea - Sweden - 40125");
		distinationMap.put(3367,"Umedo - Japan - 58850");
		distinationMap.put(2531,"Umm Qasr - Iraq - 50570");
		distinationMap.put(2617,"Umm Said - Qatar - 51825");
		distinationMap.put(4293,"Unidentified Countries - Unidentified Countries - 8220");
		distinationMap.put(168,"Union Bay, BC - Canada - 12491");
		distinationMap.put(4178,"United Arab Emirates - United Arab Emirates - 5200");
		distinationMap.put(4118,"United Kingdom - United Kingdom - 4120");
		distinationMap.put(3425,"Uno - Japan - 58884");
		distinationMap.put(3426,"Uno Ko - Japan - 58884");
		distinationMap.put(4691,"UPS SIOUX FALL - United States - 3502");
		distinationMap.put(4634,"UPS,ANCHORAGE - United States - 3196");
		distinationMap.put(4641,"UPS,HONOLULU AIRPORT - United States - 3295");
		distinationMap.put(4755,"UPS,LOUISVILLE - United States - 4196");
		distinationMap.put(4801,"UPS,MIAMI INTL AIRPORT - United States - 5295");
		distinationMap.put(4764,"UPS,NEWARK - United States - 4670");
		distinationMap.put(4554,"UPS,ONTARIO - United States - 2795");
		distinationMap.put(4437,"UPS,PHILADELPHIA - United States - 1195");
		distinationMap.put(4616,"UPS,SEATTLE - United States - 3071");
		distinationMap.put(4619,"UPS,SEATTLE - United States - 3095");
		distinationMap.put(4389,"URALSK - KAZAKHSTAN - 44911");
		distinationMap.put(1270,"Ursviken - Sweden - 40100");
		distinationMap.put(1171,"Urucara - Brazil - 35198");
		distinationMap.put(4108,"Uruguay - Uruguay - 3550");
		distinationMap.put(4301,"US minor outlying Islands - US minor outlying Islands - 9800");
		distinationMap.put(1201,"Ushuaia - Argentina - 35700");
		distinationMap.put(4314,"UST KAMENOGORSK - Russia - Klaip");
		distinationMap.put(4974,"UST LUGA - RUSSIA - 46250");
		distinationMap.put(2044,"Ust-Dunaisk - Ukraine - 46272");
		distinationMap.put(2045,"Ust-Dunaysk - Ukraine - 46272");
		distinationMap.put(4388,"UST-KAMENOGORSK - KAZAKHSTAN - 44911");
		distinationMap.put(1360,"Utansjo - Sweden - 40191");
		distinationMap.put(455,"Utila Bay - Honduras - 21515");
		distinationMap.put(1495,"Uusikaupunki - Finland - 40537");
		distinationMap.put(3519,"Uvol - Papua New Guinea - 60440");
		distinationMap.put(4148,"Uzbekistan - Uzbekistan - 4644");
		distinationMap.put(2467,"Uzunkum - Turkey - 48943");
		distinationMap.put(1577,"Vaag - Faroe - 40985");
		distinationMap.put(1496,"Vaasa - Finland - 40538");
		distinationMap.put(563,"Vacamonte - Panama - 22599");
		distinationMap.put(2213,"Vada - Italy - 47539");
		distinationMap.put(2215,"Vado Ligure - Italy - 47540");
		distinationMap.put(1578,"Vagur - Faroe - 40985");
		distinationMap.put(1314,"Vaja - Sweden - 40100");
		distinationMap.put(1407,"Vaksdal - Norway - 40300");
		distinationMap.put(4626,"VALDEZ - United States - 3107");
		distinationMap.put(1068,"Valdivia - Chile - 33700");
		distinationMap.put(2134,"Valencia - Spain - 47094");
		distinationMap.put(1771,"Valencia Harvor - Ireland - 41900");
		distinationMap.put(2550,"Valfajor Two Terminal - Iran - 50700");
		distinationMap.put(1469,"Valko - Finland - 40500");
		distinationMap.put(1470,"Valkom - Finland - 40500");
		distinationMap.put(2182,"Valletta - Malta - 47305");
		distinationMap.put(257,"Valleyfield, QUE - Canada - 14067");
		distinationMap.put(2305,"Vallona - Albania - 48100");
		distinationMap.put(1363,"Vallvik - Sweden - 40196");
		distinationMap.put(1092,"Valparaiso - Chile - 33797");
		distinationMap.put(169,"Van Anda, BC - Canada - 12492");
		distinationMap.put(4828,"VAN BUREN - United States - 0108");
		distinationMap.put(4825,"VANCEBORO - United States - 0105");
		distinationMap.put(4586,"VANCOUVER - United States - 2908");
		distinationMap.put(171,"Vancouver, BC - Canada - 12493");
		distinationMap.put(2017,"Vanino - Russia - 46234");
		distinationMap.put(4221,"Vanuatu - Vanuatu - 6224");
		distinationMap.put(3455,"Varanus Oil Terminal - Australia - 60200");
		distinationMap.put(1315,"Varberg - Sweden - 40100");
		distinationMap.put(2426,"Varna - Bulgaria - 48707");
		distinationMap.put(1471,"Vasa - Finland - 40500");
		distinationMap.put(2501,"Vassiliko - Cyprus - 49134");
		distinationMap.put(1361,"Vasteras - Sweden - 40192");
		distinationMap.put(1362,"Vastervik - Sweden - 40194");
		distinationMap.put(3628,"Vatia Point - Fiji - 68630");
		distinationMap.put(4154,"Vatican City - Vatican City - 4752");
		distinationMap.put(1968,"Vegesach - Germany - 42899");
		distinationMap.put(1970,"Vegesack - Germany - 42899");
		distinationMap.put(1559,"Veile - Denmark - 40929");
		distinationMap.put(1560,"Vejle - Denmark - 40929");
		distinationMap.put(1826,"Velsen - Netherlands - 42190");
		distinationMap.put(2262,"Venezia - Italy - 47595");
		distinationMap.put(4098,"Venezuela - Venezuela - 3070");
		distinationMap.put(2263,"Venice - Italy - 47595");
		distinationMap.put(1976,"Ventspils - Latvia - 44951");
		distinationMap.put(4542,"VENTURA - United States - 2712");
		distinationMap.put(424,"Veracruz - Mexico - 20199");
		distinationMap.put(2711,"Veraval - India - 53347");
		distinationMap.put(1896,"Verdon - France - 42742");
		distinationMap.put(1579,"Vestmanhavn - Faroe - 40985");
		distinationMap.put(1580,"Vestmann - Faroe - 40985");
		distinationMap.put(1255,"Vestmannaeyjar - Iceland - 40040");
		distinationMap.put(2007,"Viborg - Russia - 46220");
		distinationMap.put(4497,"VICKSBURG - United States - 2015");
		distinationMap.put(1154,"Victoria - Brazil - 35195");
		distinationMap.put(3786,"Victoria - Cameroon - 74298");
		distinationMap.put(2826,"Victoria - Malaysia - 55717");
		distinationMap.put(3946,"Victoria - Seychelles - 78083");
		distinationMap.put(47,"Victoria Harbor, ONT - Canada - 06682");
		distinationMap.put(173,"Victoria, BC - Canada - 12494");
		distinationMap.put(209,"Victoria, PEI - Canada - 13456");
		distinationMap.put(3052,"Victorias - Philippines - 56500");
		distinationMap.put(4190,"Vietnam - Vietnam - 5520");
		distinationMap.put(801,"Vieux Fort - St. Lucia - 24867");
		distinationMap.put(1316,"Vifstavarf - Sweden - 40100");
		distinationMap.put(2090,"Vigo - Spain - 47029");
		distinationMap.put(2008,"Viipuri - Russia - 46220");
		distinationMap.put(1102,"Vila do Conde - Brazil - 35121");
		distinationMap.put(2173,"Vila do Porto - Portugal - 47150");
		distinationMap.put(2156,"Vila Real de San Antonio - Portugal - 47100");
		distinationMap.put(3760,"Villa Cisneros - Western Sahara - 73700");
		distinationMap.put(1225,"Villa Constitucion - Argentina - 35795");
		distinationMap.put(2075,"Villagarcia - Spain - 47000");
		distinationMap.put(2076,"Villagarcia de Arosa - Spain - 47000");
		distinationMap.put(1938,"Villefranche - France - 42799");
		distinationMap.put(1874,"Villequier - France - 42700");
		distinationMap.put(1180,"Villeta - Paraguay - 35300");
		distinationMap.put(4963,"VILNIUS - Lithuania - 45101");
		distinationMap.put(4964,"VILNIUS - Lithuania - 45101");
		distinationMap.put(4967,"Vilnus - Lithuania - 45101");
		distinationMap.put(1836,"Vilvoorde - Belgium - 42300");
		distinationMap.put(1837,"Vilvorde - Belgium - 42300");
		distinationMap.put(2149,"Vinaroz - Spain - 47099");
		distinationMap.put(1977,"Vindau - Latvia - 44951");
		distinationMap.put(1978,"Vindava - Latvia - 44951");
		distinationMap.put(1317,"Vinga - Sweden - 40100");
		distinationMap.put(3053,"Virac - Philippines - 56500");
		distinationMap.put(786,"Virgin  Gorda - British Virgin - 24813");
		distinationMap.put(4297,"Virgin Islands of the United States - Virgin Islands of the United States - 9110");
		distinationMap.put(2734,"Visakhapatnam - India - 53399");
		distinationMap.put(2735,"Vishakhapatnam - India - 53399");
		distinationMap.put(4332,"VITEBSK - BEL - 45101");
		distinationMap.put(4329,"Vitebsk - Belarus - 0001");
		distinationMap.put(4330,"Vitebsk - Belarus - 0001");
		distinationMap.put(3054,"Vito - Philippines - 56500");
		distinationMap.put(1155,"Vitoria - Brazil - 35195");
		distinationMap.put(1318,"Vivstava - Sweden - 40100");
		distinationMap.put(1822,"Vlaardingen - Netherlands - 42181");
		distinationMap.put(2020,"Vladivostok - Russia - 46238");
		distinationMap.put(1824,"Vlissingen - Netherlands - 42185");
		distinationMap.put(2306,"Vlore - Albania - 48100");
		distinationMap.put(2307,"Volore - Albania - 48100");
		distinationMap.put(2409,"Volos - Greece - 48473");
		distinationMap.put(4384,"VORONEJ - RUSSIA - 44911");
		distinationMap.put(4383,"Voronezh - Russia - 44911");
		distinationMap.put(2346,"Vostitza - Greece - 48400");
		distinationMap.put(2348,"Vostizza - Greece - 48400");
		distinationMap.put(2012,"Vostochnyy - Russia - 46231");
		distinationMap.put(2299,"Vranjic - Croatia - 47998");
		distinationMap.put(3629,"Vunda Point - Fiji - 68630");
		distinationMap.put(2794,"Vung Tau - Vietnam - 55206");
		distinationMap.put(2009,"Vyborg - Russia - 46220");
		distinationMap.put(3756,"Wadi Feiran - Egypt - 72999");
		distinationMap.put(971,"Wageningen - Suriname - 31500");
		distinationMap.put(3682,"Wahran - Algeria - 72179");
		distinationMap.put(3433,"Wakamatsu - Japan - 58890");
		distinationMap.put(3434,"Wakamatsu Ko - Japan - 58890");
		distinationMap.put(3435,"Wakayama - Japan - 58891");
		distinationMap.put(3296,"Wakkanai - Japan - 58800");
		distinationMap.put(4669,"WALHALLA - United States - 3407");
		distinationMap.put(609,"Walker Cay - Bahamas - 23667");
		distinationMap.put(74,"Walkerville, ONT - Canada - 09605");
		distinationMap.put(1472,"Walkom - Finland - 40500");
		distinationMap.put(3456,"Wallaroo - Australia - 60200");
		distinationMap.put(1364,"Wallhamn - Sweden - 40197");
		distinationMap.put(4226,"Wallis and Futuna - Wallis and Futuna - 6413");
		distinationMap.put(1684,"Wallsend - United Kingdom - 41398");
		distinationMap.put(4016,"Walvis Baai - Namibia - 79286");
		distinationMap.put(4015,"Walvis Bay - Namibia - 79286");
		distinationMap.put(3530,"Wanganui - New Zealand - 61400");
		distinationMap.put(1757,"Warren Point - United Kingdom - 41805");
		distinationMap.put(1758,"Warrenpoint - United Kingdom - 41805");
		distinationMap.put(3853,"Warri - Nigeria - 75387");
		distinationMap.put(3457,"Warrnambool - Australia - 60200");
		distinationMap.put(4682,"WARROAD - United States - 3423");
		distinationMap.put(4945,"Warszawa - Poland - 45505");
		distinationMap.put(4928,"Washington - United States - 1001");
		distinationMap.put(3577,"Washington Island - Kiribati - 62220");
		distinationMap.put(4809,"WASHINGTON,DC (INCLUDES DULLES AIRPORT) - United States - 5401");
		distinationMap.put(1777,"Waterford - Ireland - 41910");
		distinationMap.put(152,"Watson Island, BC - Canada - 12420");
		distinationMap.put(4729,"WAUKEGAN REGIONAL AIRPORT - United States - 3981");
		distinationMap.put(3114,"Wei hai - China - 57000");
		distinationMap.put(3115,"Weihai - China - 57000");
		distinationMap.put(3491,"Weipa - Australia - 60275");
		distinationMap.put(30,"Welland, ONT - Canada - 02645");
		distinationMap.put(3551,"Wellington - New Zealand - 61447");
		distinationMap.put(210,"Welshpool, NB - Canada - 13457");
		distinationMap.put(3143,"Wenzhow - China - 57021");
		distinationMap.put(4173,"West Bank Administered by Israel - West Bank Administered by Israel - 5083");
		distinationMap.put(601,"West End - Bahamas - 23647");
		distinationMap.put(4795,"WEST PALM BEACH - United States - 5204");
		distinationMap.put(4901,"WEST SACRA - United States - 2811");
		distinationMap.put(4888,"West Valle - United States - 3301");
		distinationMap.put(4240,"Western Sahara - Western Sahara - 7370");
		distinationMap.put(4219,"Western Samoa - Western Samoa - 6150");
		distinationMap.put(3493,"Westernport - Australia - 60280");
		distinationMap.put(4678,"WESTHOPE - United States - 3419");
		distinationMap.put(1256,"Westman Isles - Iceland - 40040");
		distinationMap.put(3531,"Westport - New Zealand - 61400");
		distinationMap.put(3523,"Wewak - Papua New Guinea - 60450");
		distinationMap.put(1685,"Weymouth - United Kingdom - 41398");
		distinationMap.put(3533,"Whakatane - New Zealand - 61400");
		distinationMap.put(574,"Whale Cay - Bahamas - 23600");
		distinationMap.put(3184,"Whampoa - China - 57072");
		distinationMap.put(304,"Whiffen Head, NFLD - Canada - 15230");
		distinationMap.put(84,"Whitby, ONT - Canada - 09671");
		distinationMap.put(118,"White Rock,BC - Canada - 12200");
		distinationMap.put(80,"Whitefish River, ONT - Canada - 09667");
		distinationMap.put(4652,"WHITETAIL - United States - 3312");
		distinationMap.put(4657,"WHITLASH - United States - 3321");
		distinationMap.put(164,"Whonnock, BC - Canada - 12488");
		distinationMap.put(165,"Whonok, BC - Canada - 12488");
		distinationMap.put(3458,"Whyalla - Australia - 60200");
		distinationMap.put(69,"Wiarton, ONT - Canada - 09000");
		distinationMap.put(4760,"WICHITA - United States - 4504");
		distinationMap.put(4659,"WILDHORSE - United States - 3323");
		distinationMap.put(1961,"Wilhelmshaven - Germany - 42891");
		distinationMap.put(4430,"WILKES-BARRE/SCRANTON - United States - 1106");
		distinationMap.put(843,"Willemstad - Neth Antilles - 27725");
		distinationMap.put(3459,"Williamstown - Australia - 60200");
		distinationMap.put(4721,"WILLOW RUN AIRPORT - United States - 3882");
		distinationMap.put(4427,"WILMINGTON - United States - 1103");
		distinationMap.put(4882,"WILMINGTON - United States - 1234");
		distinationMap.put(4449,"WILMINGTON - United States - 1501");
		distinationMap.put(189,"Wilsons Beach, NB - Canada - 13400");
		distinationMap.put(38,"Windsor, ONT - Canada - 03512");
		distinationMap.put(4450,"WINSTON-SALEM - United States - 1502");
		distinationMap.put(1686,"Wisbech - United Kingdom - 41398");
		distinationMap.put(1946,"Wismar - Germany - 42835");
		distinationMap.put(285,"Witless Bay, NFLD - Canada - 15200");
		distinationMap.put(3203,"Wonsan - North Korea - 57900");
		distinationMap.put(798,"Woodbridge Bay - Dominica - 24853");
		distinationMap.put(132,"Woodfibre, BC - Canada - 12212");
		distinationMap.put(236,"Woodwards Cove, NB - Canada - 13829");
		distinationMap.put(4851,"WORCESTER - United States - 0403");
		distinationMap.put(1608,"Workington - United Kingdom - 41299");
		distinationMap.put(4624,"WRANGELL - United States - 3105");
		distinationMap.put(3116,"Wu Hu - China - 57000");
		distinationMap.put(3127,"Wuhan - China - 57013");
		distinationMap.put(3117,"Wuhu - China - 57000");
		distinationMap.put(3460,"Wyndham - Australia - 60200");
		distinationMap.put(422,"Xcalac - Mexico - 20195");
		distinationMap.put(3174,"Xiamen - China - 57069");
		distinationMap.put(3139,"Xingang - China - 57017");
		distinationMap.put(4336,"XINGANG - China - 57017");
		distinationMap.put(4337,"XINGANG - CHINA - 57017");
		distinationMap.put(3308,"Yaene - Japan - 58809");
		distinationMap.put(4618,"YAKIMA AIR TERMINAL,YAKIMA - United States - 3081");
		distinationMap.put(2411,"Yali - Greece - 48475");
		distinationMap.put(2412,"Yali Island - Greece - 48475");
		distinationMap.put(2482,"Yalova - Turkey - 48971");
		distinationMap.put(2062,"Yalta - Ukraine - 46279");
		distinationMap.put(3494,"Yamba - Australia - 60281");
		distinationMap.put(2608,"Yambo - Saudi Arabia - 51730");
		distinationMap.put(2609,"Yanbu - Saudi Arabia - 51730");
		distinationMap.put(3568,"Yandina - Solomon Is - 62200");
		distinationMap.put(1998,"Yandraknnot - Russia - 46208");
		distinationMap.put(2758,"Yangon - Burma - 54601");
		distinationMap.put(3168,"Yantai - China - 57055");
		distinationMap.put(3197,"Yantian - China - 57078");
		distinationMap.put(3615,"Yap - Micronesia - 68209");
		distinationMap.put(2499,"Yarimca - Turkey - 48999");
		distinationMap.put(1687,"Yarmouth - United Kingdom - 41398");
		distinationMap.put(1688,"Yarmouth Harbor - United Kingdom - 41398");
		distinationMap.put(239,"Yarmouth, NS - Canada - 13847");
		distinationMap.put(3481,"Yarraville - Australia - 60237");
		distinationMap.put(3429,"Yatsushiro - Japan - 58887");
		distinationMap.put(3430,"Yatsusiro - Japan - 58887");
		distinationMap.put(356,"Yavaros - Mexico - 20100");
		distinationMap.put(3438,"Yawata - Japan - 58893");
		distinationMap.put(4414,"Yekaterinburg - Russia - 44701");
		distinationMap.put(2610,"Yenbo - Saudi Arabia - 51730");
		distinationMap.put(3169,"Yentai - China - 57055");
		distinationMap.put(3235,"Yeosu - South Korea - 58065");
		distinationMap.put(2349,"Yerakini - Greece - 48400");
		distinationMap.put(4344,"YEREVAN - ARMENIA - 46337");
		distinationMap.put(3166,"Yingkou - China - 57053");
		distinationMap.put(1506,"Ykspihlaja - Finland - 40591");
		distinationMap.put(1827,"Ymuiden - Netherlands - 42190");
		distinationMap.put(3440,"Yokkaichi - Japan - 58894");
		distinationMap.put(3439,"Yokkaiti - Japan - 58894");
		distinationMap.put(3441,"Yokohama - Japan - 58895");
		distinationMap.put(3442,"Yokosuka - Japan - 58896");
		distinationMap.put(3897,"Yombo - Congo Brazzaville - 76330");
		distinationMap.put(3234,"Yosu - South Korea - 58065");
		distinationMap.put(4903,"Ypsilanti - United States - 3810");
		distinationMap.put(1319,"Ystad - Sweden - 40100");
		distinationMap.put(3297,"Yuki - Japan - 58800");
		distinationMap.put(664,"Yumuri - Cuba - 23900");
		distinationMap.put(2435,"Yumurtalik - Turkey - 48900");
		distinationMap.put(3298,"Yura - Japan - 58800");
		distinationMap.put(4985,"YUZHNY - RUSSIAN - 12345");
		distinationMap.put(2050,"Yuzhnyy - Ukraine - 46275");
		distinationMap.put(1507,"Yxpila - Finland - 40591");
		distinationMap.put(1794,"Zaandam - Netherlands - 42100");
		distinationMap.put(2296,"Zadar - Croatia - 47933");
		distinationMap.put(3769,"Zafira - Equatorial Gui - 73802");
		distinationMap.put(2404,"Zakinthos - Greece - 48467");
		distinationMap.put(4288,"Zambia - Zambia - 7940");
		distinationMap.put(3090,"Zamboanga - Philippines - 56597");
		distinationMap.put(2405,"Zante - Greece - 48467");
		distinationMap.put(3951,"Zanzibar - Tanzania - 78387");
		distinationMap.put(1226,"Zarate - Argentina - 35796");
		distinationMap.put(3716,"Zavia - Libya - 72590");
		distinationMap.put(3717,"Zawia Oil Terminal - Libya - 72590");
		distinationMap.put(1853,"Zeebrugge - Belgium - 42381");
		distinationMap.put(3742,"Zeit Bay Terminal - Egypt - 72947");
		distinationMap.put(2269,"Zelenika - Serbia - 47900");
		distinationMap.put(1838,"Zelzate - Belgium - 42300");
		distinationMap.put(3187,"Zhangjiagang - China - 57075");
		distinationMap.put(3189,"Zhanjiang - China - 57075");
		distinationMap.put(3190,"Zhanjiang gang - China - 57075");
		distinationMap.put(2052,"Zhdanov - Ukraine - 46276");
		distinationMap.put(3188,"Zhenjiang - China - 57075");
		distinationMap.put(3198,"Zhongshan - China - 57079");
		distinationMap.put(3196,"Zhuhai - China - 57077");
		distinationMap.put(3792,"Ziguinchor - Senegal - 74499");
		distinationMap.put(4290,"Zimbabwe - Zimbabwe - 7960");
		distinationMap.put(2627,"Zirku Island - United Arab Em - 52000");
		distinationMap.put(2436,"Zonguldak - Turkey - 48900");
		distinationMap.put(3718,"Zuara - Libya - 72591");
		distinationMap.put(3720,"Zuetina - Libya - 72595");
		distinationMap.put(3719,"Zuwarah - Libya - 72591");
		distinationMap.put(1839,"Zwijndrecht - Belgium - 42300");
		distinationMap.put(1840,"Zwyndrecht - Belgium - 42300");


	                                                                                                     
	                                                                                     
	}
}