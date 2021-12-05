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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import main.com.carService.carImage.carimage;
import main.com.carService.carLanding.carLanding;
import main.com.carService.carLanding.carLandingAppServiceImpl;
import main.com.carService.carLanding.categoriesEnum;
import main.com.carService.carLanding.transmissionTypesEnum;
import main.com.carService.carLandingImage.carimageLanding;
import main.com.carService.carLandingImage.carimageLandingAppServiceImpl;
import retrofit2.Call;


@ManagedBean(name = "carLandingBean")
@SessionScoped
public class carLandingBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236769354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{carLandingFacadeImpl}")
	private carLandingAppServiceImpl carLandingFacade;
	
	List<carLanding> listOfAddedCars;
	
	List<carLanding> listOfCarsLandingScroller;
	
	List<carLanding> listOfCarsGroupByMake;
	
	carLanding selectedFreight;
	private boolean progress=false;
	
	
	
	private  String saleDate;
	

	private List<String> images;
	private List<String> images_deleted;
	
	private carLanding selectedCarPage;
	private List<carimageLanding> imagesOfSelectedCarLanding;

	@ManagedProperty(value = "#{carimageLandingFacadeImpl}")
	private carimageLandingAppServiceImpl carimageLandingFacade;
	

	private Integer searchType;
	private String searchMake;
	private String searchModel;
	private String searchStartYear;
	private String searchEndYear;
	
	@PostConstruct
	public void init() {
		
		refresh();
		
		
	}
	
	
	public void refresh(){

		
		listOfAddedCars=carLandingFacade.getAll();
		listOfCarsLandingScroller=carLandingFacade.getAllForLanding();
		listOfCarsGroupByMake=carLandingFacade.getAllGroupsOfMake();
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("id")[0]);
				if(id!=null){
					selectedCarPage=carLandingFacade.getById(id);
					imagesOfSelectedCarLanding=carimageLandingFacade.getAllByCarId(id);
				}
			}
		catch(Exception ex){
			 
		}
		
		try{
			String categories=String.valueOf(origRequest.getParameterValues("category")[0]);
				if(categories!=null){
					listOfAddedCars=carLandingFacade.getAllForCategories(categories);
				}
			}
		catch(Exception ex){
			 
		}
	}
	
	public void makeSearch() {
		listOfAddedCars=carLandingFacade.getAllForSearch(searchStartYear, searchEndYear, searchMake,searchModel, String.valueOf(searchType));

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("panelCarsToUpdate");
	}
	public categoriesEnum getCategoryEnum(String type) {
        return categoriesEnum.valueOf(type);
    }
	
	public categoriesEnum[] getCategoriesEnum() {
        return categoriesEnum.values();
    }
	
	public transmissionTypesEnum[] getTransmissionTypesEnum() {
        return transmissionTypesEnum.values();
    }
	
	public transmissionTypesEnum getTransmissionTypesEnum(int type) {
        return transmissionTypesEnum.values()[type];
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
	/*
	public String saveImageToDirectory(byte[] image,String directory) {
		String fileName="";
		
		try {
			File file=File.createTempFile("img", ".png",new File(directory));
			ByteArrayInputStream bis = new ByteArrayInputStream(image);
			BufferedImage bImage=ImageIO.read(bis);
			BufferedImage bImageN=scaleImage(bImage, 15);
			ImageIO.write(bImageN, "png", file);
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
	
	public void previewImage(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		images.add(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanel");
	}
	
	public void previewImageMain(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		String fileName =saveImageToDirectory(image, System.getProperty("catalina.base")+"/images/");
		selectedFreight.setMainImage(fileName);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanelMain");
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
	        	selectedFreight.setAssemblyCountry(car.Results.get(0).PlantCountry);
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
	
	public String getStringFromCalendar(Calendar calendar) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		String returnedCalendarString="";
		
			if(calendar!=null) {
				returnedCalendarString=formatter.format(calendar.getTime());
			}
		return returnedCalendarString;
	}
	
public void addCarForMain() {
		
		
		selectedFreight=new carLanding();
		saleDate="";
		
		images=new ArrayList<String>();
		images_deleted=new ArrayList<String>();
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitView.jsf?faces-redirect=true");
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

		if(typeOfFile==carimage.TYPE_PIC) {
			
			removeFileFromImages(fileURL);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanel");
		PrimeFaces.current().executeScript("swal(\"Action Done\", \"The Image Has Been Deleted\", \"success\");");
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

	public void selectCarForMain(int selectedCarId) {
		
		
		selectedFreight=carLandingFacade.getById(selectedCarId);
		saleDate=getStringFromCalendar(selectedFreight.getSaleDate());
		List<carimageLanding> imagesOfCar =carimageLandingFacade.getAllByCarId(selectedFreight.getId());

		images=new ArrayList<String>();
		images_deleted=new ArrayList<String>();
		if(imagesOfCar!=null) {
			for(int i=0;i<imagesOfCar.size();i++) {
				images.add(imagesOfCar.get(i).getUrl());
			}
		}
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vitView.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void updateCarDataMain() {
		selectedFreight.setSaleDate(setCalendarFromString(saleDate));
		
		//Here Added
		selectedFreight.setShowenInLanding(true);
		carLandingFacade.addcarLanding(selectedFreight);
		
		
		
		for(int i=0;i<images_deleted.size();i++) {
			carimageLanding cImage=new carimageLanding();
			cImage.setCarId(selectedFreight);
			cImage.setUrl(images_deleted.get(i));
			cImage.setDeleted(true);
			carimageLandingFacade.addcarimageLanding(cImage);
		}
		
		for(int i=0;i<images.size();i++) {
			carimageLanding cImage=new carimageLanding();
			cImage.setCarId(selectedFreight);
			cImage.setUrl(images.get(i));
			carimageLandingFacade.addcarimageLanding(cImage);
		}
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/CarLandingPage/vehicleList.jsf?faces-redirect=true");
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


	public carLanding getSelectedFreight() {
		return selectedFreight;
	}


	public void setSelectedFreight(carLanding selectedFreight) {
		this.selectedFreight = selectedFreight;
	}


	public boolean isProgress() {
		return progress;
	}


	public void setProgress(boolean progress) {
		this.progress = progress;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}


	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public carimageLandingAppServiceImpl getCarimageLandingFacade() {
		return carimageLandingFacade;
	}


	public void setCarimageLandingFacade(carimageLandingAppServiceImpl carimageLandingFacade) {
		this.carimageLandingFacade = carimageLandingFacade;
	}


	public List<carLanding> getListOfCarsLandingScroller() {
		return listOfCarsLandingScroller;
	}


	public void setListOfCarsLandingScroller(List<carLanding> listOfCarsLandingScroller) {
		this.listOfCarsLandingScroller = listOfCarsLandingScroller;
	}


	public carLanding getSelectedCarPage() {
		return selectedCarPage;
	}


	public void setSelectedCarPage(carLanding selectedCarPage) {
		this.selectedCarPage = selectedCarPage;
	}


	public List<carimageLanding> getImagesOfSelectedCarLanding() {
		return imagesOfSelectedCarLanding;
	}


	public void setImagesOfSelectedCarLanding(List<carimageLanding> imagesOfSelectedCarLanding) {
		this.imagesOfSelectedCarLanding = imagesOfSelectedCarLanding;
	}


	public List<carLanding> getListOfCarsGroupByMake() {
		return listOfCarsGroupByMake;
	}


	public void setListOfCarsGroupByMake(List<carLanding> listOfCarsGroupByMake) {
		this.listOfCarsGroupByMake = listOfCarsGroupByMake;
	}


	public Integer getSearchType() {
		return searchType;
	}


	public void setSearchType(Integer searchType) {
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


	public List<String> getImages_deleted() {
		return images_deleted;
	}


	public void setImages_deleted(List<String> images_deleted) {
		this.images_deleted = images_deleted;
	}


	public String getSearchModel() {
		return searchModel;
	}


	public void setSearchModel(String searchModel) {
		this.searchModel = searchModel;
	}


	
	
}
