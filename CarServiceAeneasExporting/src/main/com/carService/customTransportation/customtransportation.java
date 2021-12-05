package main.com.carService.customTransportation;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.custom.custom;
import main.com.carService.docreciept.docreciept;




/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="customtransportation.getAll",
		     query="SELECT c FROM customtransportation c where c.deleted = false"
		     )
	,
	@NamedQuery(name="customtransportation.getById",
	query = "from customtransportation d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="customtransportation.getAllByCustomId",
	query = "from customtransportation d where d.customId.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="customtransportation.getAllByDocReceiptId",
	query = "from customtransportation d where d.docReceiptId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "customtransportation")
public class customtransportation {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "lineNum")
	private Integer lineNum;
	

	@Column(name = "eqNumber")
	private String eqNumber;
	

	@Column(name = "sn")
	private String sn;
	

	@ManyToOne
	@JoinColumn(name = "customId")
	private custom customId;
	

	@Column(name = "deleted")
	private boolean deleted;


	@ManyToOne
	@JoinColumn(name = "docReceiptId")
	private docreciept docReceiptId;
	
	
	public Integer getLineNum() {
		return lineNum;
	}


	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	

	public String getEqNumber() {
		return eqNumber;
	}


	public void setEqNumber(String eqNumber) {
		this.eqNumber = eqNumber;
	}


	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public custom getCustomId() {
		return customId;
	}


	public void setCustomId(custom customId) {
		this.customId = customId;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public docreciept getDocReceiptId() {
		return docReceiptId;
	}


	public void setDocReceiptId(docreciept docReceiptId) {
		this.docReceiptId = docReceiptId;
	}

	
	
	
	
}
