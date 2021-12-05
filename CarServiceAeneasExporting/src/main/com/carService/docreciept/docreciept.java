package main.com.carService.docreciept;


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

import main.com.carService.consignee.consignee;
import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="docreciept.getAll",
		     query="SELECT c FROM docreciept c where c.deleted = false"
		     )
	,
	@NamedQuery(name="docreciept.getById",
	query = "from docreciept d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="docreciept.getAllByUserId",
	query = "from docreciept d where d.userId.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="docreciept.getAllByMainId",
	query = "from docreciept d where d.mainId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "docreciept")
public class docreciept {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	

	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	
	
	@ManyToOne
	@JoinColumn(name = "usppiId")
	private consignee usppiId;
	
	@ManyToOne
	@JoinColumn(name = "freightForwarderId")
	private consignee freightForwarderId;

	@ManyToOne
	@JoinColumn(name = "ultiConsignee")
	private consignee ultiConsignee;
	

	@ManyToOne
	@JoinColumn(name = "intermConsignee")
	private consignee intermConsignee;
	

	
	

	

	
	@Column(name = "bn")
	private String bn;
	
	@Column(name = "srn")
	private String srn;

	@Column(name = "portOfExportCountry")
	private String portOfExportCountry;
	
	

	@Column(name = "scac")
	private String scac;
	
	@Column(name = "preCarrageBy")
	private String preCarrageBy;
	
	@Column(name = "vn")
	private String vn;
	
	

	@Column(name = "portOfExportState")
	private String portOfExportState;


	@Column(name = "sailingOn")
	private String sailingOn;
	
	

	@Column(name = "itn")
	private String itn;
	
	

	@Column(name = "portOfDestination")
	private String portOfDestination;
	
	@Column(name = "countryOfDestination")
	private String countryOfDestination;
	
	

	@Column(name = "loadingTerminal")
	private String loadingTerminal;
	


	@Column(name = "mot")
	private String mot;

	@Column(name = "exportCarrier")
	private String exportCarrier;
	

	@Column(name = "mark_cont")
	private String mark_cont;
	

	@Column(name = "mark_seal")
	private String mark_seal;
	

	@Column(name = "no_of_pkg")
	private String no_of_pkg;
	
	

	@Column(name = "billOfLading")
	private String billOfLading;
	
	@Column(name = "deleted")
	private boolean deleted;



	@Column(name = "date")
	private Calendar date;


	
	@ManyToOne
	@JoinColumn(name = "mainId")
	private user mainId;
	
	


	@Column(name = "notifyParity")
	private String notifyParity;
	
	


	@Column(name = "placeOfReceipt")
	private String placeOfReceipt;
	


	@Column(name = "ibt")
	private String ibt;
	


	@Column(name = "rt")
	private String rt;
	


	@Column(name = "rcc")
	private String rcc;
	


	@Column(name = "haz")
	private String haz;
	
	

	@Column(name = "consigneeType")
	private String consigneeType;
	

	@Column(name = "soldEnRoute")
	private String soldEnRoute;
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public consignee getUsppiId() {
		return usppiId;
	}



	public void setUsppiId(consignee usppiId) {
		this.usppiId = usppiId;
	}



	public consignee getFreightForwarderId() {
		return freightForwarderId;
	}



	public void setFreightForwarderId(consignee freightForwarderId) {
		this.freightForwarderId = freightForwarderId;
	}



	public consignee getUltiConsignee() {
		return ultiConsignee;
	}



	public void setUltiConsignee(consignee ultiConsignee) {
		this.ultiConsignee = ultiConsignee;
	}



	public consignee getIntermConsignee() {
		return intermConsignee;
	}



	public void setIntermConsignee(consignee intermConsignee) {
		this.intermConsignee = intermConsignee;
	}



	public String getBn() {
		return bn;
	}



	public void setBn(String bn) {
		this.bn = bn;
	}



	public String getSrn() {
		return srn;
	}



	public void setSrn(String srn) {
		this.srn = srn;
	}



	public String getPortOfExportCountry() {
		return portOfExportCountry;
	}



	public void setPortOfExportCountry(String portOfExportCountry) {
		this.portOfExportCountry = portOfExportCountry;
	}



	public String getScac() {
		return scac;
	}



	public void setScac(String scac) {
		this.scac = scac;
	}



	public String getVn() {
		return vn;
	}



	public void setVn(String vn) {
		this.vn = vn;
	}



	public String getPortOfExportState() {
		return portOfExportState;
	}



	public void setPortOfExportState(String portOfExportState) {
		this.portOfExportState = portOfExportState;
	}



	public String getSailingOn() {
		return sailingOn;
	}



	public void setSailingOn(String sailingOn) {
		this.sailingOn = sailingOn;
	}



	public String getItn() {
		return itn;
	}



	public void setItn(String itn) {
		this.itn = itn;
	}



	public String getPortOfDestination() {
		return portOfDestination;
	}



	public void setPortOfDestination(String portOfDestination) {
		this.portOfDestination = portOfDestination;
	}



	public String getLoadingTerminal() {
		return loadingTerminal;
	}



	public void setLoadingTerminal(String loadingTerminal) {
		this.loadingTerminal = loadingTerminal;
	}



	public String getMot() {
		return mot;
	}



	public void setMot(String mot) {
		this.mot = mot;
	}



	public String getMark_cont() {
		return mark_cont;
	}



	public void setMark_cont(String mark_cont) {
		this.mark_cont = mark_cont;
	}



	public String getMark_seal() {
		return mark_seal;
	}



	public void setMark_seal(String mark_seal) {
		this.mark_seal = mark_seal;
	}



	public String getNo_of_pkg() {
		return no_of_pkg;
	}



	public void setNo_of_pkg(String no_of_pkg) {
		this.no_of_pkg = no_of_pkg;
	}



	public String getBillOfLading() {
		return billOfLading;
	}



	public void setBillOfLading(String billOfLading) {
		this.billOfLading = billOfLading;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public Calendar getDate() {
		return date;
	}



	public void setDate(Calendar date) {
		this.date = date;
	}



	public user getUserId() {
		return userId;
	}



	public void setUserId(user userId) {
		this.userId = userId;
	}



	public user getMainId() {
		return mainId;
	}



	public void setMainId(user mainId) {
		this.mainId = mainId;
	}



	public String getNotifyParity() {
		return notifyParity;
	}



	public void setNotifyParity(String notifyParity) {
		this.notifyParity = notifyParity;
	}



	public String getPlaceOfReceipt() {
		return placeOfReceipt;
	}



	public void setPlaceOfReceipt(String placeOfReceipt) {
		this.placeOfReceipt = placeOfReceipt;
	}



	public String getCountryOfDestination() {
		return countryOfDestination;
	}



	public void setCountryOfDestination(String countryOfDestination) {
		this.countryOfDestination = countryOfDestination;
	}



	public String getIbt() {
		return ibt;
	}



	public void setIbt(String ibt) {
		this.ibt = ibt;
	}



	public String getRt() {
		return rt;
	}



	public void setRt(String rt) {
		this.rt = rt;
	}



	public String getRcc() {
		return rcc;
	}



	public void setRcc(String rcc) {
		this.rcc = rcc;
	}



	public String getHaz() {
		return haz;
	}



	public void setHaz(String haz) {
		this.haz = haz;
	}



	public String getConsigneeType() {
		return consigneeType;
	}



	public void setConsigneeType(String consigneeType) {
		this.consigneeType = consigneeType;
	}



	public String getSoldEnRoute() {
		return soldEnRoute;
	}



	public void setSoldEnRoute(String soldEnRoute) {
		this.soldEnRoute = soldEnRoute;
	}



	public String getPreCarrageBy() {
		return preCarrageBy;
	}



	public void setPreCarrageBy(String preCarrageBy) {
		this.preCarrageBy = preCarrageBy;
	}



	public String getExportCarrier() {
		return exportCarrier;
	}



	public void setExportCarrier(String exportCarrier) {
		this.exportCarrier = exportCarrier;
	}
	
	
	
	
}
