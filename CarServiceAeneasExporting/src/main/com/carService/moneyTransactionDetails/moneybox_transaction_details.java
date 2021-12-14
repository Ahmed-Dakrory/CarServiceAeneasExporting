package main.com.carService.moneyTransactionDetails;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.moneyBox.moneybox;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="moneybox_transaction_details.getAll",
		     query="SELECT c FROM moneybox_transaction_details c"
		     )
	,
	@NamedQuery(name="moneybox_transaction_details.getById",
	query = "from moneybox_transaction_details d where d.id = :id order by d.date asc"
			)
	,
	@NamedQuery(name="moneybox_transaction_details.getAllByUserMoneyBoxId",
	query = "from moneybox_transaction_details d where d.moneyBoxId.id = :id order by d.date asc"
			)


})

@Entity
@Table(name = "moneybox_transaction_details")
public class moneybox_transaction_details {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	

	@ManyToOne
	@JoinColumn(name = "moneyBoxId")
	private moneybox moneyBoxId;
	

	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "amountBefore")
	private float amountBefore;
	
	
	@Column(name = "date")
	private Date date;
	

	@Column(name = "typeOfTransaction")
	private Integer typeOfTransaction;
	
	

	@Column(name = "description")
	private String description;



	public enum depositeTypes{
		Deposite(0,"Deposite"),Payment(1,"Payment"),ReturnPayment(2,"Returns"),Inserted(3,"Inserted");
		
		depositeTypes(int type,String name){
			this.type=type;
			this.name=name;
		}
		
		int type=0;
		
		String name="";
		
		public int getType() {
			return type;
		}


		public void setType(int type) {
			this.type = type;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
		

	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public moneybox getMoneyBoxId() {
		return moneyBoxId;
	}



	public void setMoneyBoxId(moneybox moneyBoxId) {
		this.moneyBoxId = moneyBoxId;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Integer getTypeOfTransaction() {
		return typeOfTransaction;
	}



	public void setTypeOfTransaction(Integer typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}



	public float getAmountBefore() {
		return amountBefore;
	}



	public void setAmountBefore(float amountBefore) {
		this.amountBefore = amountBefore;
	}
	

	
	
}
