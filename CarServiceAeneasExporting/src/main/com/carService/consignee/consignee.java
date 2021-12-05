package main.com.carService.consignee;


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
import main.com.carService.shipper.shipper;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="consignee.getAll",
		     query="SELECT c FROM consignee c where c.deleted = false"
		     )
	,
	@NamedQuery(name="consignee.getById",
	query = "from consignee d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="consignee.getAllByUserId",
	query = "from consignee d where d.userId = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="consignee.getAllByParentId",
	query = "from consignee d where d.parentId.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="consignee.getAllByParentIdAndUserId",
	query = "from consignee d where d.parentId.id = :id and d.userId.id = :idUser and d.deleted = false"
			)
	
	,
	@NamedQuery(name="consignee.getAllByParentOfParentId",
	query = "from consignee d where d.parentId.parentId.id = :id and d.deleted = false group by d.userId "
			)
	
	
})

@Entity
@Table(name = "consignee")
public class consignee {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "other")
	private String other;
	
	@Column(name = "idType")
	private String idType;

	@Column(name = "idNumber")
	private String idNumber;
	
	
	
		
	

	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	
	@ManyToOne
	@JoinColumn(name = "parentId")
	private shipper parentId;


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


	public user getUserId() {
		return userId;
	}


	public void setUserId(user userId) {
		this.userId = userId;
	}

	

	public shipper getParentId() {
		return parentId;
	}


	public void setParentId(shipper parentId) {
		this.parentId = parentId;
	}


	public String getIdType() {
		return idType;
	}


	public void setIdType(String idType) {
		this.idType = idType;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	

	
	
	

	
}
