package main.com.carService.shipper;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="shipper.getAll",
		     query="SELECT c FROM shipper c where c.deleted = false"
		     )
	,
	@NamedQuery(name="shipper.getById",
	query = "from shipper d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="shipper.getByUserId",
	query = "from shipper d where d.userId = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="shipper.getAllByParentId",
	query = "from shipper d where d.parentId.id = :id and d.deleted = false"
			)
	
	
})

@Entity
@Table(name = "shipper")
public class shipper {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "other")
	private String other;
	
	@Column(name = "allowAccess")
	private boolean allowAccess;
	
	@Column(name = "salesRep")
	private String salesRep;
	
	@Column(name = "idType")
	private Integer idType;
	
	@Column(name = "idNumber")
	private String idNumber;
		
	

	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	
	@ManyToOne
	@JoinColumn(name = "parentId")
	private user parentId;


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


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public boolean getAllowAccess() {
		return allowAccess;
	}


	public void setAllowAccess(boolean allowAccess) {
		this.allowAccess = allowAccess;
	}


	public Integer getIdType() {
		return idType;
	}


	public void setIdType(Integer idType) {
		this.idType = idType;
	}


	public user getUserId() {
		return userId;
	}


	public void setUserId(user userId) {
		this.userId = userId;
	}

	

	public user getParentId() {
		return parentId;
	}


	public void setParentId(user parentId) {
		this.parentId = parentId;
	}


	public String getSalesRep() {
		return salesRep;
	}


	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	
	
	

	
}
