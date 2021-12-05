package main.com.carService.custom;


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
import main.com.carService.docreciept.docreciept;
import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="custom.getAll",
		     query="SELECT c FROM custom c where c.deleted = false"
		     )
	,
	@NamedQuery(name="custom.getById",
	query = "from custom d where d.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="custom.getByDocReceiptId",
	query = "from custom d where d.doReceiptId = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="custom.getAllByUserId",
	query = "from custom d where d.userId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "custom")
public class custom {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "consigneeType")
	private String consigneeType;
	
	@Column(name = "soldEnRoute")
	private String soldEnRoute;

	@Column(name = "srn")
	private String srn;
	
	@Column(name = "eda")
	private Calendar eda;
	

	@Column(name = "scac")
	private String scac;
	
	@Column(name = "vn")
	private String vn;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	
	@ManyToOne
	@JoinColumn(name = "freightForwardedId")
	private consignee freightForwardedId;

	@ManyToOne
	@JoinColumn(name = "usppiId")
	private consignee usppiId;
	

	@ManyToOne
	@JoinColumn(name = "doReceiptId")
	private docreciept doReceiptId;
	

	@ManyToOne
	@JoinColumn(name = "ulConsigneeId")
	private consignee ulConsigneeId;
	

	@ManyToOne
	@JoinColumn(name = "interConsigneeId")
	private consignee interConsigneeId;
	
	

	
	

	@Column(name = "bn")
	private String bn;

	

	@Column(name = "st")
	private String st;
	
	@Column(name = "ibt")
	private String ibt;
	
	@Column(name = "poe")
	private String poe;

	@Column(name = "cod")
	private String cod;
	
	@Column(name = "pou")
	private String pou;
	
	@Column(name = "mot")
	private String mot;
	
	
	@Column(name = "rcc")
	private String rcc;
	
	@Column(name = "haz")
	private String haz;
	
	@Column(name = "rt")
	private String rt;
	
	
	@Column(name = "deleted")
	private boolean deleted;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Calendar getEda() {
		return eda;
	}


	public void setEda(Calendar eda) {
		this.eda = eda;
	}


	public user getUserId() {
		return userId;
	}


	public void setUserId(user userId) {
		this.userId = userId;
	}


	

	public consignee getUsppiId() {
		return usppiId;
	}


	public void setUsppiId(consignee usppiId) {
		this.usppiId = usppiId;
	}


	public consignee getUlConsigneeId() {
		return ulConsigneeId;
	}


	public void setUlConsigneeId(consignee ulConsigneeId) {
		this.ulConsigneeId = ulConsigneeId;
	}


	public consignee getInterConsigneeId() {
		return interConsigneeId;
	}


	public void setInterConsigneeId(consignee interConsigneeId) {
		this.interConsigneeId = interConsigneeId;
	}


	public consignee getFreightForwardedId() {
		return freightForwardedId;
	}


	public void setFreightForwardedId(consignee freightForwardedId) {
		this.freightForwardedId = freightForwardedId;
	}


	

	public String getSrn() {
		return srn;
	}


	public void setSrn(String srn) {
		this.srn = srn;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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


	
	public String getBn() {
		return bn;
	}


	public void setBn(String bn) {
		this.bn = bn;
	}


	public docreciept getDoReceiptId() {
		return doReceiptId;
	}


	public void setDoReceiptId(docreciept doReceiptId) {
		this.doReceiptId = doReceiptId;
	}


	public String getSt() {
		return st;
	}


	public void setSt(String st) {
		this.st = st;
	}


	public String getIbt() {
		return ibt;
	}


	public void setIbt(String ibt) {
		this.ibt = ibt;
	}


	public String getPoe() {
		return poe;
	}


	public void setPoe(String poe) {
		this.poe = poe;
	}


	public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}


	public String getPou() {
		return pou;
	}


	public void setPou(String pou) {
		this.pou = pou;
	}


	public String getMot() {
		return mot;
	}


	public void setMot(String mot) {
		this.mot = mot;
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


	public String getRt() {
		return rt;
	}


	public void setRt(String rt) {
		this.rt = rt;
	}
	
	
	
}
