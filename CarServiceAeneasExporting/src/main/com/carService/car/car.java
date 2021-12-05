package main.com.carService.car;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.google.gson.JsonObject;

import main.com.carService.Beans.carBean;
import main.com.carService.consignee.consignee;
import main.com.carService.customer.customer;
import main.com.carService.loginNeeds.user;
import main.com.carService.mainTwo.mainTwo;
import main.com.carService.shipper.shipper;
import main.com.carService.vendor.vendor;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="car.getAll",
		     query="SELECT c FROM car c where c.deleted = false order by c.cargoRecieved desc"
		     )
	,
	@NamedQuery(name="car.getById",
	query = "from car d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="car.getByVin",
	query = "from car d where d.uuid = :uuid and d.deleted = false"
			)
	,
	@NamedQuery(name="car.getAllForMainUser",
	query = "from car d where mainId = :userId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllForMainUserTwo",
	query = "from car d where mainTwoId = :mainTwoId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllForVendor",
	query = "from car d where vendorId = :vendorId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllForShipper",
	query = "from car d where shipperId = :shipperId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllForCustomer",
	query = "from car d where customerId = :customerId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllForConsignee",
	query = "from car d where consigneeId = :consigneeId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForMainUser",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and mainId = :userId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForMainUserTwo",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and mainTwoId = :mainTwoId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForVendor",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and vendorId = :vendorId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForShipper",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and shipperId = :shipperId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForCustomer",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and customerId = :customerId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWareHouseForConsignee",
	query = "from car d where (d.state = 0 or d.state = 1 or d.state = 2 or d.state = 3 ) and consigneeId = :consigneeId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForMainUser",
	query = "from car d where (d.state = 4 or d.state = 5) and mainId = :userId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForMainUserTwo",
	query = "from car d where (d.state = 4 or d.state = 5) and mainTwoId = :mainTwoId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForVendor",
	query = "from car d where (d.state = 4 or d.state = 5) and vendorId = :vendorId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForShipper",
	query = "from car d where (d.state = 4 or d.state = 5) and shipperId = :shipperId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForCustomer",
	query = "from car d where (d.state = 4 or d.state = 5) and customerId = :customerId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllDryCargoForConsignee",
	query = "from car d where (d.state = 4 or d.state = 5) and consigneeId = :consigneeId and d.deleted = false order by d.cargoRecieved desc"
			)
	
	,
	@NamedQuery(name="car.getAllFrightInTransitForMainUser",
	query = "from car d where (d.state = 6 or d.state = 7) and mainId = :userId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightInTransitForMainUserTwo",
	query = "from car d where (d.state = 6 or d.state = 7) and mainTwoId = :mainTwoId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightInTransitForVendor",
	query = "from car d where (d.state = 6 or d.state = 7) and vendorId = :vendorId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightInTransitForShipper",
	query = "from car d where (d.state = 6 or d.state = 7) and shipperId = :shipperId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightInTransitForCustomer",
	query = "from car d where (d.state = 6 or d.state = 7) and customerId = :customerId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightInTransitForConsignee",
	query = "from car d where (d.state = 6 or d.state = 7) and consigneeId = :consigneeId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForMainUser",
	query = "from car d where (d.state = 8) and mainId = :userId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForMainUserTwo",
	query = "from car d where (d.state = 8) and mainTwoId = :mainTwoId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForVendor",
	query = "from car d where (d.state = 8) and vendorId = :vendorId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForShipper",
	query = "from car d where (d.state = 8) and shipperId = :shipperId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForCustomer",
	query = "from car d where (d.state = 8) and customerId = :customerId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllFrightSentForPaymentForConsignee",
	query = "from car d where (d.state = 8) and consigneeId = :consigneeId and d.deleted = false order by d.cargoRecieved desc"
			)
	,
	@NamedQuery(name="car.getAllWithAllowSendState",
	query = "from car d where d.allowSendEmail = :state and d.deleted = false order by d.cargoRecieved desc"
			)
	
	
})

@Entity
@Table(name = "car")
public class car {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "mainId")
	private user mainId;
	
	@ManyToOne(targetEntity = shipper.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "shipperId")
	private shipper shipperId;
	
	@ManyToOne(targetEntity = vendor.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "vendorId")
	private vendor vendorId;
	
	@ManyToOne(targetEntity = customer.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private customer customerId;
	
	@ManyToOne(targetEntity = mainTwo.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "mainTwoId")
	private mainTwo mainTwoId;
	
	

	@Column(name = "mainUrl")
	private String mainUrl;
	

	@Column(name = "uuid")
	private String uuid;
	

	@Column(name = "companyTransName")
	private String companyTransName;
	

	@Column(name = "driverName")
	private String driverName;
	

	@Column(name = "driverPhone")
	private String driverPhone;
	

	
	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;
	

	@Column(name = "odometer")
	private String odometer;
	

	@Column(name = "assemlyCountry")
	private String assemlyCountry;
	
	@Column(name = "bodyStyle")
	private String bodyStyle;

	@Column(name = "engineType")
	private String engineType;
	

	@Column(name = "engineLiters")
	private String engineLiters;
	

	@Column(name = "color")
	private String color;
	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "year")
	private String year;

	@Column(name = "container")
	private String container;
	

	@Column(name = "titleExist")
	private boolean titleExist;
	
	@Column(name = "containerLink")
	private String containerLink;
	
	
	@Column(name = "stateOut")
	private Integer stateOut;
	

	@Column(name = "releaseDate")
	private Calendar releaseDate;
	
	
	@Column(name = "seal")
	private String seal;
	
	@Column(name = "inlandStatus")
	private String inlandStatus;
	
	@Column(name = "cargoRecieved")
	private Calendar cargoRecieved;
	
	@Column(name = "titleRecieved")
	private Integer titleRecieved;

	@Column(name = "titleNumber")
	private String titleNumber;
	


	@Column(name = "dateOfDriverSignture")
	private Calendar dateOfDriverSignture;
	

	@Column(name = "urlOfDriverSignture")
	private String urlOfDriverSignture;
	
	


	

	@Column(name = "dateOfCrashImage")
	private Calendar dateOfCrashImage;
	

	@Column(name = "urlOfCrashImage")
	private String urlOfCrashImage;
	

	@Column(name = "crashPointsJson")
	private String crashPointsJson;
	
	

	@Column(name = "CarType")
	private String carType;
	
	@Column(name = "stRecieved")
	private Calendar stRecieved;
	

	@Column(name = "origin")
	private Integer origin;
	

	@Column(name = "destination")
	private Integer destination;
	

	@Column(name = "etd")
	private Calendar etd;

	@Column(name = "eta")
	private Calendar eta;
	
	@Column(name = "loadrequest")
	private boolean loadrequest;

	@Column(name = "releaseOption")
	private boolean releaseOption;
	

	@Column(name = "sendMailUpdate")
	private boolean sendMailUpdate;
	
	

	@Column(name = "keyExist")
	private boolean keyExist;

	@ManyToOne
	@JoinColumn(name = "consigneeId")
	private consignee consigneeId;

	@Column(name = "allowSendEmail")
	private boolean allowSendEmail;
	

	@Column(name = "deleted")
	private boolean deleted;
	
	

	@Column(name = "emailToSendComment")
	private String emailToSendComment;
	

	@Column(name = "commentToSend")
	private String commentToSend;
	
	

	@Column(name = "valueOfGood")
	private Integer valueOfGood;
	
	

	@Column(name = "weight")
	private Integer weight;
	
	
	public static int STATE_WARE_HOUSE_1=0;
	public static int STATE_WARE_HOUSE_2=1;
	public static int STATE_WARE_HOUSE_3=2;
	public static int STATE_WARE_HOUSE_4=3;
	public static int STATE_DRY_CARGO_1=4;
	public static int STATE_DRY_CARGO_2=5;
	public static int STATE_In_TRANSIT_1=6;
	public static int STATE_In_TRANSIT_2=7;
	public static int STATE_Sent_For_Payment=8;
	
	
	public static int Title_Missing=0;
	public static int Title_Pending=1;
	public static int Title_Requested=2;
	public static int Title_Ok=3;
	public static int Title_InLien=4;
	public static int Title_Paid=4;
	
	
	@Column(name = "state")
	private Integer state;

	@Column(name = "landcost")
	private Integer landcost;

	@Column(name = "seacost")
	private Integer seacost;

	@Column(name = "fees")
	private Integer fees;

	@Column(name = "commision")
	private Integer commision;
	

	@Column(name = "lastUpdate")
	private Calendar lastUpdate;
	
	@Column(name = "storageStartDate")
	private Calendar storageStartDate;
	
	@Column(name = "storageEndDate")
	private Calendar storageEndDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "photoExist")
	private boolean photoExist;
	
	@Column(name = "docExist")
	private boolean docExist;
	

	public static int TYPE_Vehicle = 0;
	public static int TYPE_DRY_Cargo = 0;

	@Column(name = "type")
	private Integer type;
	

	@Column(name = "mobileOrComp")
	private Integer mobileOrComp;


	public static int Type_Comp = 0;
	public static int Type_Mobile = 1;

	public static String stateString[]= {"Warehouse (Title uploaded, VIR uploaded, Load Request NO)",
										 "Warehouse ( VIR and Title uploaded, Load Request YES)",
										 "Warehouse (Title uploaded, VIR uploaded, Priority OK TO LOAD"
										 + " / LOAD ASAP, Job Order Form assigned to freight)",
										 "Warehouse (No documents uploaded (Vehicle Inspection Report, Title or both))",
										 "Dry Cargo (Load Request NO)",
										 "Dry Cargo (Load Request YES)",
										 "Fright In Transit ( ETA present)",
										 "Fright In Transit  (No ETA)",
										 "Sent For Payment"};

	public String getTitleString() {
		String title="";
		
		if(titleRecieved==Title_Missing) {
			title="Missing";
		}else if(titleRecieved==Title_Pending) {
			title="Title Pending";
		}else if(titleRecieved==Title_Requested) {
			title="Requested";
		}else if(titleRecieved==Title_Ok) {
			title="Title ok";
		}else if(titleRecieved==Title_InLien) {
			title="In Lien";
		}else if(titleRecieved==Title_Paid) {
			title="PAID";
		}
		return title;
	}


	
	
	
	public static Integer RELEASE_TO_CUSTOMER=1;
	public static Integer RELEASE_RORO=2;
	public static Integer RELEASE_Container=3;
	
	public String getOutState() {
		String title="";
		
		if(stateOut==RELEASE_TO_CUSTOMER) {
			title="RELEASE TO CUSTOMER";
		}else if(stateOut==RELEASE_RORO) {
			title="RELEASE RORO";
		}else if(stateOut==RELEASE_Container) {
			title="RELEASE Container";
		}else{
			title="No Released";
		}
		return title;
	}






	public Integer getId() {
		return id;
	}








	public void setId(Integer id) {
		this.id = id;
	}








	public user getMainId() {
		return mainId;
	}








	public void setMainId(user mainId) {
		this.mainId = mainId;
	}








	
	public boolean isTitleExist() {
		return titleExist;
	}






	public void setTitleExist(boolean titleExist) {
		this.titleExist = titleExist;
	}






	public Integer getStateOut() {
		return stateOut;
	}

	public void setStateOut(Integer stateOut) {
		this.stateOut = stateOut;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}






	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}






	public shipper getShipperId() {
		return shipperId;
	}








	public void setShipperId(shipper shipperId) {
		this.shipperId = shipperId;
	}








	public vendor getVendorId() {
		return vendorId;
	}








	public void setVendorId(vendor vendorId) {
		this.vendorId = vendorId;
	}








	public customer getCustomerId() {
		return customerId;
	}








	public void setCustomerId(customer customerId) {
		this.customerId = customerId;
	}








	public String getUuid() {
		return uuid;
	}








	public void setUuid(String uuid) {
		this.uuid = uuid;
	}








	public String getDescription() {
		return description;
	}








	public void setDescription(String description) {
		this.description = description;
	}








	public String getYear() {
		return year;
	}








	public void setYear(String year) {
		this.year = year;
	}








	public String getContainer() {
		return container;
	}








	public void setContainer(String container) {
		this.container = container;
	}








	public String getSeal() {
		return seal;
	}








	public void setSeal(String seal) {
		this.seal = seal;
	}








	public String getInlandStatus() {
		return inlandStatus;
	}








	public void setInlandStatus(String inlandStatus) {
		this.inlandStatus = inlandStatus;
	}








	public Calendar getCargoRecieved() {
		return cargoRecieved;
	}








	public void setCargoRecieved(Calendar cargoRecieved) {
		this.cargoRecieved = cargoRecieved;
	}








	public Integer getTitleRecieved() {
		return titleRecieved;
	}








	public void setTitleRecieved(Integer titleRecieved) {
		this.titleRecieved = titleRecieved;
	}










	public String getTitleNumber() {
		return titleNumber;
	}






	public void setTitleNumber(String titleNumber) {
		this.titleNumber = titleNumber;
	}






	public Calendar getStRecieved() {
		return stRecieved;
	}








	public void setStRecieved(Calendar stRecieved) {
		this.stRecieved = stRecieved;
	}








	public Integer getOrigin() {
		return origin;
	}








	public void setOrigin(Integer origin) {
		this.origin = origin;
	}



	





	public Calendar getDateOfDriverSignture() {
		return dateOfDriverSignture;
	}






	public void setDateOfDriverSignture(Calendar dateOfDriverSignture) {
		this.dateOfDriverSignture = dateOfDriverSignture;
	}






	public String getUrlOfDriverSignture() {
		return urlOfDriverSignture;
	}






	public void setUrlOfDriverSignture(String urlOfDriverSignture) {
		this.urlOfDriverSignture = urlOfDriverSignture;
	}






	public Calendar getDateOfCrashImage() {
		return dateOfCrashImage;
	}






	public void setDateOfCrashImage(Calendar dateOfCrashImage) {
		this.dateOfCrashImage = dateOfCrashImage;
	}






	public String getUrlOfCrashImage() {
		return urlOfCrashImage;
	}






	public void setUrlOfCrashImage(String urlOfCrashImage) {
		this.urlOfCrashImage = urlOfCrashImage;
	}






	public String getCrashPointsJson() {
		return crashPointsJson;
	}






	public void setCrashPointsJson(String crashPointsJson) {
		this.crashPointsJson = crashPointsJson;
	}






	public String getCarType() {
		return carType;
	}






	public void setCarType(String carType) {
		this.carType = carType;
	}






	public Integer getDestination() {
		return destination;
	}








	public void setDestination(Integer destination) {
		this.destination = destination;
	}








	public Calendar getEtd() {
		return etd;
	}








	public void setEtd(Calendar etd) {
		this.etd = etd;
	}








	public Calendar getEta() {
		return eta;
	}








	public void setEta(Calendar eta) {
		this.eta = eta;
	}








	public boolean getLoadrequest() {
		return loadrequest;
	}








	public void setLoadrequest(boolean loadrequest) {
		this.loadrequest = loadrequest;
	}

















	public boolean isReleaseOption() {
		return releaseOption;
	}








	public void setReleaseOption(boolean releaseOption) {
		this.releaseOption = releaseOption;
	}








	public consignee getConsigneeId() {
		return consigneeId;
	}








	public void setConsigneeId(consignee consigneeId) {
		this.consigneeId = consigneeId;
	}








	public Integer getState() {
		return state;
	}








	public void setState(Integer state) {
		this.state = state;
	}








	public Integer getLandcost() {
		return landcost;
	}








	public void setLandcost(Integer landcost) {
		this.landcost = landcost;
	}








	public Integer getSeacost() {
		return seacost;
	}








	public void setSeacost(Integer seacost) {
		this.seacost = seacost;
	}








	public Integer getFees() {
		return fees;
	}








	public void setFees(Integer fees) {
		this.fees = fees;
	}








	public Integer getCommision() {
		return commision;
	}








	public void setCommision(Integer commision) {
		this.commision = commision;
	}








	public Calendar getLastUpdate() {
		return lastUpdate;
	}








	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}











	public static String[] getStateString() {
		return stateString;
	}








	public static void setStateString(String[] stateString) {
		car.stateString = stateString;
	}








	public Calendar getStorageStartDate() {
		return storageStartDate;
	}








	public void setStorageStartDate(Calendar storageStartDate) {
		this.storageStartDate = storageStartDate;
	}








	public Calendar getStorageEndDate() {
		return storageEndDate;
	}








	public void setStorageEndDate(Calendar storageEndDate) {
		this.storageEndDate = storageEndDate;
	}








	public String getNote() {
		return note;
	}








	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	public int getNumberOfDays() {
		if(state!=STATE_WARE_HOUSE_1||state!=STATE_WARE_HOUSE_2||state!=STATE_WARE_HOUSE_3||
				state!=STATE_WARE_HOUSE_4) {

			return getDaysDifference(Calendar.getInstance(),storageStartDate);
		}
		return getDaysDifference(storageEndDate,storageStartDate);
	}








	private int getDaysDifference(Calendar end, Calendar start) {
		// TODO Auto-generated method stub

		Date endDate=end.getTime();
		Date startDate=start.getTime();
		
		return (int)(endDate.getTime()-startDate.getTime());
	}








	public String getMake() {
		return make;
	}








	public void setMake(String make) {
		this.make = make;
	}








	public String getModel() {
		return model;
	}








	public void setModel(String model) {
		this.model = model;
	}








	public String getBodyStyle() {
		return bodyStyle;
	}








	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}








	public String getEngineType() {
		return engineType;
	}








	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}








	public String getEngineLiters() {
		return engineLiters;
	}








	public void setEngineLiters(String engineLiters) {
		this.engineLiters = engineLiters;
	}








	public String getColor() {
		return color;
	}








	public void setColor(String color) {
		this.color = color;
	}








	public String getAssemlyCountry() {
		return assemlyCountry;
	}








	public void setAssemlyCountry(String assemlyCountry) {
		this.assemlyCountry = assemlyCountry;
	}








	public boolean isPhotoExist() {
		return photoExist;
	}








	public void setPhotoExist(boolean photoExist) {
		this.photoExist = photoExist;
	}








	public boolean isDocExist() {
		return docExist;
	}








	public void setDocExist(boolean docExist) {
		this.docExist = docExist;
	}








	public Integer getType() {
		return type;
	}








	public void setType(Integer type) {
		this.type = type;
	}






	public String getContainerLink() {
		return containerLink;
	}






	public void setContainerLink(String containerLink) {
		this.containerLink = containerLink;
	}






	public boolean isAllowSendEmail() {
		return allowSendEmail;
	}






	public void setAllowSendEmail(boolean allowSendEmail) {
		this.allowSendEmail = allowSendEmail;
	}






	public String getEmailToSendComment() {
		return emailToSendComment;
	}






	public void setEmailToSendComment(String emailToSendComment) {
		this.emailToSendComment = emailToSendComment;
	}






	public String getCommentToSend() {
		return commentToSend;
	}






	public void setCommentToSend(String commentToSend) {
		this.commentToSend = commentToSend;
	}






	public mainTwo getMainTwoId() {
		return mainTwoId;
	}






	public void setMainTwoId(mainTwo mainTwoId) {
		this.mainTwoId = mainTwoId;
	}






	public String getOdometer() {
		return odometer;
	}






	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}






	public boolean isDeleted() {
		return deleted;
	}






	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}






	public Integer getValueOfGood() {
		return valueOfGood;
	}






	public void setValueOfGood(Integer valueOfGood) {
		this.valueOfGood = valueOfGood;
	}






	public Integer getWeight() {
		return weight;
	}






	public void setWeight(Integer weight) {
		this.weight = weight;
	}






	public Integer getMobileOrComp() {
		return mobileOrComp;
	}






	public void setMobileOrComp(Integer mobileOrComp) {
		this.mobileOrComp = mobileOrComp;
	}






	public boolean isKeyExist() {
		return keyExist;
	}






	public void setKeyExist(boolean keyExist) {
		this.keyExist = keyExist;
	}






	public boolean isSendMailUpdate() {
		return sendMailUpdate;
	}






	public void setSendMailUpdate(boolean sendMailUpdate) {
		this.sendMailUpdate = sendMailUpdate;
	}






	public String getMainUrl() {
		return mainUrl;
	}






	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}













	





	public String getCompanyTransName() {
		return companyTransName;
	}






	public void setCompanyTransName(String companyTransName) {
		this.companyTransName = companyTransName;
	}






	public String getDriverName() {
		return driverName;
	}






	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}






	public String getDriverPhone() {
		return driverPhone;
	}






	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
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


	
	 public JsonObject toJson() {
	    	JsonObject obj=new JsonObject();
	    	  obj.addProperty("id", String.valueOf(this.id));
		      obj.addProperty("color", String.valueOf(this.color));
		      if(this.mainId!=null) {
			      obj.addProperty("mainId", String.valueOf(this.mainId.getId()));
			      }else {
				      obj.addProperty("mainId", String.valueOf("null"));
			    	  
			      }
		      
		      if(this.getVendorId()!=null) {
			      obj.addProperty("vendorCompanyName", String.valueOf(this.getVendorId().getUserId().getCompany()));
			      }else {
				      obj.addProperty("vendorCompanyName", String.valueOf("null"));
			    	  
			      }
		      
		      if(this.getShipperId()!=null) {
			      obj.addProperty("shipperCompanyName", String.valueOf(this.getShipperId().getUserId().getCompany()));
			      }else {
				      obj.addProperty("shipperCompanyName", String.valueOf("null"));
			    	  
			      }
		      obj.addProperty("uuid", String.valueOf(this.uuid));
		      obj.addProperty("make", String.valueOf(this.make));
		      obj.addProperty("model", String.valueOf(this.model));
		      obj.addProperty("year", String.valueOf(this.year));
		      obj.addProperty("mainImage", String.valueOf(this.mainUrl));
		      obj.addProperty("keyExist", String.valueOf(this.keyExist?"Yes":"No"));
		      obj.addProperty("containerLink", String.valueOf(this.containerLink));
		      obj.addProperty("container", String.valueOf(this.container));
		      obj.addProperty("numberOfDays", String.valueOf(getNumberOfDays(this.storageStartDate,this.storageEndDate)));
		      obj.addProperty("formatedDate", String.valueOf(getFormatedDate(this.cargoRecieved)));
		      
		      
		      obj.addProperty("titleRecieved", String.valueOf(this.titleRecieved));
		      obj.addProperty("origin", String.valueOf(new carBean().getTheOrigin2(this.origin)));
		      obj.addProperty("docExist", String.valueOf(this.docExist));
		      obj.addProperty("photoExist", String.valueOf(this.photoExist));
		      return obj;
	    	
	    }
	
	
	
}
