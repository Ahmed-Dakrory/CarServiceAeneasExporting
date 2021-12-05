package main.com.carService.carLanding;


import java.util.Calendar;

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

import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	
	@NamedQuery(name="carLanding.getAll",
		     query="SELECT c FROM carLanding c where c.deleted = false"
		     )
	,
	@NamedQuery(name="carLanding.getById",
	query = "from carLanding d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="carLanding.getByVin",
	query = "from carLanding d where d.uuid = :uuid and d.deleted = false"
			)
	
	,
	@NamedQuery(name="carLanding.getAllForLanding",
	query = "from carLanding d where d.isShowenInLanding = true and d.deleted = false"
			)
	
	,
	@NamedQuery(name="carLanding.getAllForCategories",
	query = "from carLanding d where d.category = :category and d.deleted = false"
			)
	,
	@NamedQuery(name="carLanding.getAllGroupsOfMake",
	query = "from carLanding d where d.deleted = false group by d.make "
			)
	
	,
	@NamedQuery(name="carLanding.getAllGroupsOfCategory",
	query = "from carLanding d where d.deleted = false group by d.category"
			)
	
	,
	@NamedQuery(name="carLanding.getAllGroupsOfModelWithMake",
	query = "from carLanding d where d.deleted = false and d.make=:make group by d.model "
			)
	
	,
	@NamedQuery(name="carLanding.getAllForSearch",
	query = "from carLanding d where d.year <= :yearEnd and d.year >= :yearStart and d.make like :make and d.model like :model and d.category like :category and d.deleted = false"
			)
	
	
	
})

@Entity
@Table(name = "carLanding")
public class carLanding {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "mainId")
	private user mainId;
	
	
	@Column(name = "uuid")
	private String uuid;
	

	@Column(name = "description")
	private String description;
	

	@Column(name = "model")
	private String model;
	
	@Column(name = "make")
	private String make;

	@Column(name = "year")
	private String year;

	@Column(name = "assemblyCountry")
	private String assemblyCountry;

	@Column(name = "bodyStyle")
	private String bodyStyle;
	

	@Column(name = "docType")
	private String docType;

	@Column(name = "odoMeter")
	private String odoMeter;
	

	@Column(name = "transmission")
	private Integer transmission;
	

	@Column(name = "primaryDamage")
	private String primaryDamage;
	

	@Column(name = "secondaryDamage")
	private String secondaryDamage;
	
	@Column(name = "color")
	private String color;
	
	
	@Column(name = "cylinder")
	private String cylinder;
	
	
	@Column(name = "fuel")
	private String fuel;
	
	
	@Column(name = "currentBid")
	private String currentBid;

	@Column(name = "saleStatues")
	private String saleStatues;

	@Column(name = "auctionLocation")
	private String auctionLocation;

	@Column(name = "dateAdd")
	private Calendar dateAdd;
	
	@Column(name = "saleDate")
	private Calendar saleDate;
	
	@Column(name = "kiloDistance")
	private String kiloDistance;
	
	@Column(name = "mainImage")
	private String mainImage;

	

	@Column(name = "category")
	private String category;
	
	@Column(name = "isShowenInLanding")
	private boolean isShowenInLanding;


	@Column(name = "deleted")
	private boolean deleted;
	
	
	
	
	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getAssemblyCountry() {
		return assemblyCountry;
	}


	public void setAssemblyCountry(String assemblyCountry) {
		this.assemblyCountry = assemblyCountry;
	}


	public String getBodyStyle() {
		return bodyStyle;
	}


	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}


	public String getDocType() {
		return docType;
	}


	public void setDocType(String docType) {
		this.docType = docType;
	}


	public String getOdoMeter() {
		return odoMeter;
	}


	public void setOdoMeter(String odoMeter) {
		this.odoMeter = odoMeter;
	}


	public Integer getTransmission() {
		return transmission;
	}


	public void setTransmission(Integer transmission) {
		this.transmission = transmission;
	}


	public String getPrimaryDamage() {
		return primaryDamage;
	}


	public void setPrimaryDamage(String primaryDamage) {
		this.primaryDamage = primaryDamage;
	}


	public String getSecondaryDamage() {
		return secondaryDamage;
	}


	public void setSecondaryDamage(String secondaryDamage) {
		this.secondaryDamage = secondaryDamage;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getCylinder() {
		return cylinder;
	}


	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}


	public String getFuel() {
		return fuel;
	}


	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


	public String getCurrentBid() {
		return currentBid;
	}


	public void setCurrentBid(String currentBid) {
		this.currentBid = currentBid;
	}


	public String getSaleStatues() {
		return saleStatues;
	}


	public void setSaleStatues(String saleStatues) {
		this.saleStatues = saleStatues;
	}


	public String getAuctionLocation() {
		return auctionLocation;
	}


	public void setAuctionLocation(String auctionLocation) {
		this.auctionLocation = auctionLocation;
	}


	public Calendar getDateAdd() {
		return dateAdd;
	}


	public void setDateAdd(Calendar dateAdd) {
		this.dateAdd = dateAdd;
	}


	public Calendar getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}


	public String getKiloDistance() {
		return kiloDistance;
	}


	public void setKiloDistance(String kiloDistance) {
		this.kiloDistance = kiloDistance;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}


	public boolean isShowenInLanding() {
		return isShowenInLanding;
	}


	public void setShowenInLanding(boolean isShowenInLanding) {
		this.isShowenInLanding = isShowenInLanding;
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
		      obj.addProperty("uuid", String.valueOf(this.uuid));
		      obj.addProperty("make", String.valueOf(this.make));
		      obj.addProperty("model", String.valueOf(this.model));
		      obj.addProperty("year", String.valueOf(this.year));
		      obj.addProperty("transmission", String.valueOf(this.transmission));
		      obj.addProperty("mainImage", String.valueOf(this.mainImage));
		      obj.addProperty("category", String.valueOf(this.category));
		      obj.addProperty("docType", String.valueOf(this.docType));
		      obj.addProperty("odoMeter", String.valueOf(this.odoMeter));
		      obj.addProperty("primaryDamage", String.valueOf(this.primaryDamage));
		      obj.addProperty("dateAdd", String.valueOf(this.dateAdd));
		      obj.addProperty("kiloDistance", String.valueOf(this.kiloDistance));
		      obj.addProperty("description", String.valueOf(this.description));
		      
		      
		      obj.addProperty("mainImage", String.valueOf(this.mainImage));
		      obj.addProperty("currentBid", String.valueOf(this.currentBid));
		      obj.addProperty("auctionLocation", String.valueOf(this.auctionLocation));
		      obj.addProperty("secondaryDamage", String.valueOf(this.secondaryDamage));
		      return obj;
	    	
	    }


	

	
	
}
