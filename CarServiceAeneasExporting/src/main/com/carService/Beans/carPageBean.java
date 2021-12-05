package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import helpers.retrofit.mainFiles.APIClient;
import helpers.retrofit.mainFiles.APIInterface;
import helpers.retrofit.mainFiles.OrderOutDetails;
import main.com.carService.carLanding.carLanding;
import main.com.carService.costCalc.transportfeeAppServiceImpl;
import main.com.carService.loginNeeds.user;
import main.com.carService.moneyBox.moneybox;
import main.com.carService.carLanding.carLandingAppServiceImpl;
import retrofit2.Call;


@ManagedBean(name = "carPageBean")
@SessionScoped
public class carPageBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440239969354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	



	@ManagedProperty(value = "#{carLandingFacadeImpl}")
	private carLandingAppServiceImpl carLandingFacade;
	
	List<carLanding> listOfAddedCars;

	

	private Integer progressLoading;

	
	private List<carLanding> listOfFilteredCars;
	
	private String searchType;
	private String searchMake;
	private String searchModel;
	private String searchStartYear;
	private String searchEndYear;

	private boolean progress=false;

	private carLanding selectedFreight;


	List<carLanding> listOfCarsGroupByCategory;
	List<carLanding> listOfCarsGroupByMake;
	List<carLanding> listOfCarsGroupByModel;

	@ManagedProperty(value = "#{transportfeeFacadeImpl}")
	private transportfeeAppServiceImpl transportfeeFacade;
	

	private Date bidingDate;
	private  Date endDate;
	
	private List<String> images;
	
	private user userForInvoice;
	private moneybox invoiceMoneyBoxData;
	private List<carLanding> carsForthisAccount;
	private carLanding carForInvoice;
	private Integer selectedCarIdToBeAddedInInvoice;

	
	
	@PostConstruct
	public void init() {


		listOfAddedCars=new ArrayList<carLanding>();
		refresh();
	}
	
	
	public void getAllModelsByMakes() {
		listOfCarsGroupByModel=carLandingFacade.getAllGroupsOfModelWithMake(searchMake);
	}
	
public void refresh() {
		// TODO Auto-generated method stub
	HttpServletRequest origRequest = (HttpServletRequest)FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getRequest();
	listOfCarsGroupByMake=carLandingFacade.getAllGroupsOfMake();
	listOfCarsGroupByCategory = carLandingFacade.getAllGroupsOfCategory();
	
	try{
		String categories=String.valueOf(origRequest.getParameterValues("category")[0]);
			if(categories!=null){
				searchType = categories;
				searchStartYear = "1960";
				searchEndYear = "2020";
				listOfAddedCars=new ArrayList<carLanding>();
				listOfAddedCars=carLandingFacade.getAllForCategories(categories);
			}
		}
	catch(Exception ex){
		 
	}
	}



public void addCarToInvoice() {
	carForInvoice= carLandingFacade.getById(selectedCarIdToBeAddedInInvoice);
	

	try {

		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/normalUsers/invoice/invoiceAdd.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




	
		public void makeSearch() {

			listOfAddedCars=new ArrayList<carLanding>();
		listOfAddedCars=carLandingFacade.getAllForSearch(searchStartYear, searchEndYear, searchMake,searchModel, searchType);

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("panelCarsToUpdate");
	}
	
	public void makeSearchOutSide() {

		listOfAddedCars=new ArrayList<carLanding>();
		listOfAddedCars=carLandingFacade.getAllForSearch(searchStartYear, searchEndYear, searchMake,searchModel, searchType);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/public/carsForType.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public void selectCarForMain(int selectedCarId) {
		
		PrimeFaces.current().executeScript("showDialog('car');");
		selectedFreight=carLandingFacade.getById(selectedCarId);

		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitView.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

public void theloaderFirst() {
	
	progress=true;
	FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tableRendered");
	

}

public void getCarWithVinNew() {
	if(!selectedFreight.getUuid().equals("")) {
		
	APIInterface apiInterface = APIClient.getClient(selectedFreight.getUuid()+"/").create(APIInterface.class);
	  Call<OrderOutDetails> call = apiInterface.performOrder();
        try {
        	OrderOutDetails car= call.execute().body();

        	selectedFreight.setMake(car.Results.get(0).Make);
        	selectedFreight.setModel(car.Results.get(0).Model);
        	selectedFreight.setYear(car.Results.get(0).ModelYear);
        	selectedFreight.setBodyStyle(car.Results.get(0).DriveType);
        	selectedFreight.setFuel(car.Results.get(0).FuelTypePrimary);
        	selectedFreight.setCylinder(car.Results.get(0).EngineConfiguration+"- "+car.Results.get(0).EngineCylinders+" Cylinders");


			progress=false;

    		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tableRendered");
          	  
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			progress=false;

    		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tableRendered");
		}
	}else {
		progress=false;

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:tableRendered");
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Check this ',\r\n" + 
				"			text: 'Please enter the Vin number',\r\n" + 
				"			left:\"2%\"\r\n" + 
				"		});");
	}
}


	public void selectCarRowForMain() {

		 FacesContext context = FacesContext.getCurrentInstance();
		 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		 Integer carId = Integer.valueOf((String) map.get("carId"));
		 selectedFreight=carLandingFacade.getById(carId);
		 
		PrimeFaces.current().executeScript("showDialog('car');");

		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitView.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void selectCarRowForUpload(SelectEvent event) {
		selectedFreight = ((carLanding) event.getObject());
		PrimeFaces.current().executeScript("showDialog('car');");

		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitViewUpload.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

public void cancel() {
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cancel2() {
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleListUpload.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateCarDataMain() {
		selectedFreight.setMainId(loginBean.getTheUserOfThisAccount());
		carLandingFacade.addcarLanding(selectedFreight);
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
	
	
	public void updateCarDataUpload() {
		selectedFreight.setMainId(loginBean.getTheUserOfThisAccount());
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleListUpload.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getFormatedDate(Calendar c) {
		String dateTime="";
		if(c!=null) {
		dateTime = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) +"/"+
				   String.valueOf(c.get(Calendar.MONTH)+1) +"/"+
				   String.valueOf(c.get(Calendar.YEAR));
		}
		return dateTime;
	}
	
	public void cancelInvoice() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/Bid/userOfBiding.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteCar() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		 Integer carId = Integer.valueOf((String) map.get("carId"));
		 
		 carLanding deletedCar = carLandingFacade.getById(carId);
		 deletedCar.setDeleted(true);
		 carLandingFacade.addcarLanding(deletedCar);
		 
			PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Car Has Been Deleted\", \"success\");");
			
		 try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleList.jsf?faces-redirect=true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}
	

public void addCarForMain() {
	
	
	selectedFreight=new carLanding();
	
	images=new ArrayList<String>();
	
	try {
		FacesContext.getCurrentInstance()
		   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitView.jsf?faces-redirect=true");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	
	
	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public carLandingAppServiceImpl getCarLandingFacade() {
		return carLandingFacade;
	}

	public void setCarLandingFacade(carLandingAppServiceImpl carLandingFacade) {
		this.carLandingFacade = carLandingFacade;
	}

	public List<carLanding> getListOfAddedCars() {
		return listOfAddedCars;
	}

	public void setListOfAddedCars(List<carLanding> listOfAddedCars) {
		this.listOfAddedCars = listOfAddedCars;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getSearchMake() {
		return searchMake;
	}


	public void setSearchMake(String searchMake) {
		this.searchMake = searchMake;
	}


	public String getSearchStartYear() {
		return searchStartYear;
	}


	public void setSearchStartYear(String searchStartYear) {
		this.searchStartYear = searchStartYear;
	}


	public String getSearchEndYear() {
		return searchEndYear;
	}


	public void setSearchEndYear(String searchEndYear) {
		this.searchEndYear = searchEndYear;
	}



	

	public transportfeeAppServiceImpl getTransportfeeFacade() {
		return transportfeeFacade;
	}


	public void setTransportfeeFacade(transportfeeAppServiceImpl transportfeeFacade) {
		this.transportfeeFacade = transportfeeFacade;
	}


	public boolean isProgress() {
		return progress;
	}


	public void setProgress(boolean progress) {
		this.progress = progress;
	}

	

	public List<carLanding> getListOfCarsGroupByMake() {
		return listOfCarsGroupByMake;
	}


	public void setListOfCarsGroupByMake(List<carLanding> listOfCarsGroupByMake) {
		this.listOfCarsGroupByMake = listOfCarsGroupByMake;
	}




	public carLanding getSelectedFreight() {
		return selectedFreight;
	}




	public void setSelectedFreight(carLanding selectedFreight) {
		this.selectedFreight = selectedFreight;
	}




	public List<String> getImages() {
		return images;
	}




	public void setImages(List<String> images) {
		this.images = images;
	}




	public Date getBidingDate() {
		return bidingDate;
	}




	public void setBidingDate(Date bidingDate) {
		this.bidingDate = bidingDate;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}





	public List<carLanding> getListOfFilteredCars() {
		return listOfFilteredCars;
	}




	public void setListOfFilteredCars(List<carLanding> listOfFilteredCars) {
		this.listOfFilteredCars = listOfFilteredCars;
	}


	public Integer getProgressLoading() {
        if(progressLoading == null) {
        	progressLoading = 0;
        }
        else {
        	if(progressLoading > 100)
            	progressLoading = 100;
        }
         
        return progressLoading;
    }
 
    public void setProgressLoading(Integer progressLoading) {
        this.progressLoading = progressLoading;
    }
    
	

	public user getUserForInvoice() {
		return userForInvoice;
	}

	public void setUserForInvoice(user userForInvoice) {
		this.userForInvoice = userForInvoice;
	}

	

	public moneybox getInvoiceMoneyBoxData() {
		return invoiceMoneyBoxData;
	}

	public void setInvoiceMoneyBoxData(moneybox invoiceMoneyBoxData) {
		this.invoiceMoneyBoxData = invoiceMoneyBoxData;
	}

	public List<carLanding> getCarsForthisAccount() {
		return carsForthisAccount;
	}

	public void setCarsForthisAccount(List<carLanding> carsForthisAccount) {
		this.carsForthisAccount = carsForthisAccount;
	}

	public carLanding getCarForInvoice() {
		return carForInvoice;
	}

	public void setCarForInvoice(carLanding carForInvoice) {
		this.carForInvoice = carForInvoice;
	}

	public Integer getSelectedCarIdToBeAddedInInvoice() {
		return selectedCarIdToBeAddedInInvoice;
	}

	public void setSelectedCarIdToBeAddedInInvoice(Integer selectedCarIdToBeAddedInInvoice) {
		this.selectedCarIdToBeAddedInInvoice = selectedCarIdToBeAddedInInvoice;
	}

	
	public String getSearchModel() {
		return searchModel;
	}


	public void setSearchModel(String searchModel) {
		this.searchModel = searchModel;
	}


	public List<carLanding> getListOfCarsGroupByModel() {
		return listOfCarsGroupByModel;
	}


	public void setListOfCarsGroupByModel(List<carLanding> listOfCarsGroupByModel) {
		this.listOfCarsGroupByModel = listOfCarsGroupByModel;
	}


	public List<carLanding> getListOfCarsGroupByCategory() {
		return listOfCarsGroupByCategory;
	}


	public void setListOfCarsGroupByCategory(List<carLanding> listOfCarsGroupByCategory) {
		this.listOfCarsGroupByCategory = listOfCarsGroupByCategory;
	}

	
	
	
}
