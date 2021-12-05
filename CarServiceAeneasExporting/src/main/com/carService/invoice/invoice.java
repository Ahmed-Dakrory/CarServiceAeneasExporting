package main.com.carService.invoice;


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

import main.com.carService.loginNeeds.user;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_details;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="invoice.getAll",
		     query="SELECT c FROM invoice c where c.deleted = false"
		     )
	,
	@NamedQuery(name="invoice.getById",
	query = "from invoice d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="invoice.getByUserIdCustomer",
	query = "from invoice d where d.userIdCustomer.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="invoice.getAllByUserId",
	query = "from invoice d where d.userIdIssuer.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="invoice.getAllByUserIdBetweenDates",
	query = "from invoice d where d.userIdIssuer.id = :id and d.deleted = false and d.date > :dateLower and d.date < :dateHigher"
			)

})

@Entity
@Table(name = "invoice")
public class invoice {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "date")
	private Calendar date;


	@ManyToOne
	@JoinColumn(name = "userIdIssuer")
	private user userIdIssuer;
	

	@ManyToOne
	@JoinColumn(name = "userIdCustomer")
	private user userIdCustomer;
	
	@ManyToOne
	@JoinColumn(name = "transactionId")
	private moneybox_transaction_details transactionId;
	

	@Column(name = "bankName")
	private String bankName;
	
	@Column(name = "bankTelephone")
	private String bankTelephone;
	
	
	@Column(name = "bankAddress")
	private String bankAddress;
	
	
	@Column(name = "bankAccountNumber")
	private String bankAccountNumber;
	
	@Column(name = "transferFees")
	private float transferFees;
	
	@Column(name = "wireFees")
	private float wireFees;
	
	@Column(name = "description_of_charges")
	private String description_of_charges;


	@Column(name = "deleted")
	private boolean deleted;

	

	@Column(name = "payedOrNot")
	private boolean payedOrNot;
	

	

	@Column(name = "role")
	private int role;
	
	
	
	
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


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public user getUserIdIssuer() {
		return userIdIssuer;
	}


	public void setUserIdIssuer(user userIdIssuer) {
		this.userIdIssuer = userIdIssuer;
	}


	public user getUserIdCustomer() {
		return userIdCustomer;
	}


	public void setUserIdCustomer(user userIdCustomer) {
		this.userIdCustomer = userIdCustomer;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBankTelephone() {
		return bankTelephone;
	}


	public void setBankTelephone(String bankTelephone) {
		this.bankTelephone = bankTelephone;
	}


	public String getBankAddress() {
		return bankAddress;
	}


	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}


	public String getBankAccountNumber() {
		return bankAccountNumber;
	}


	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}


	


	public float getTransferFees() {
		return transferFees;
	}


	public void setTransferFees(float transferFees) {
		this.transferFees = transferFees;
	}


	public float getWireFees() {
		return wireFees;
	}


	public void setWireFees(float wireFees) {
		this.wireFees = wireFees;
	}


	public String getDescription_of_charges() {
		return description_of_charges;
	}


	public void setDescription_of_charges(String description_of_charges) {
		this.description_of_charges = description_of_charges;
	}


	public boolean isPayedOrNot() {
		return payedOrNot;
	}


	public void setPayedOrNot(boolean payedOrNot) {
		this.payedOrNot = payedOrNot;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public moneybox_transaction_details getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(moneybox_transaction_details transactionId) {
		this.transactionId = transactionId;
	}
	
	
	

	
}
