package main.com.carService.customCommodity;


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
	
	
	@NamedQuery(name="commoditiy.getAll",
		     query="SELECT c FROM commoditiy c where c.deleted = false"
		     )
	,
	@NamedQuery(name="commoditiy.getById",
	query = "from commoditiy d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="commoditiy.getAllByCustomId",
	query = "from commoditiy d where d.customId.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="commoditiy.getAllByDocReceiptId",
	query = "from commoditiy d where d.docReceiptId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "commoditiy")
public class commoditiy {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "lineNum")
	private Integer lineNum;
	
	
	
	@Column(name = "isLine")
	private String isLine;
	

	@Column(name = "it_1")
	private String it_1;
	

	@Column(name = "it_2")
	private String it_2;
	
	

	@Column(name = "it_3")
	private String it_3;
	
	

	@Column(name = "it_4")
	private String it_4;
	

	@Column(name = "it_5")
	private String it_5;
	
	@Column(name = "it_6")
	private String it_6;
	
	@Column(name = "it_7")
	private String it_7;
	
	@Column(name = "it_8")
	private String it_8;
	
	@Column(name = "it_9")
	private String it_9;
	
	@Column(name = "it_10")
	private String it_10;

	@Column(name = "it_12")
	private String it_12;
	
	@Column(name = "it_13")
	private String it_13;
	
	@Column(name = "it_15")
	private String it_15;
	
	
	@Column(name = "it_16")
	private String it_16;
	
	@Column(name = "it_17")
	private String it_17;
	
	@Column(name = "it_18")
	private String it_18;
	
	@Column(name = "it_20")
	private String it_20;
	
	@Column(name = "it_21")
	private String it_21;

	@Column(name = "odtc_1")
	private String odtc_1;


	@Column(name = "odtc_2")
	private String odtc_2;
	

	@Column(name = "odtc_3")
	private String odtc_3;
	

	@Column(name = "odtc_4")
	private String odtc_4;
	

	@Column(name = "odtc_5")
	private String odtc_5;
	

	@Column(name = "odtc_6")
	private String odtc_6;
	

	@Column(name = "odtc_7")
	private String odtc_7;
	
	
	@Column(name = "description")
	private String description;
	

	@ManyToOne
	@JoinColumn(name = "customId")
	private custom customId;
	
	@ManyToOne
	@JoinColumn(name = "docReceiptId")
	private docreciept docReceiptId;
	

	@Column(name = "deleted")
	private boolean deleted;

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getLineNum() {
		return lineNum;
	}


	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}


	
	public String getIsLine() {
		return isLine;
	}


	public void setIsLine(String isLine) {
		this.isLine = isLine;
	}


	public String getIt_1() {
		return it_1;
	}


	public void setIt_1(String it_1) {
		this.it_1 = it_1;
	}


	public String getIt_2() {
		return it_2;
	}


	public void setIt_2(String it_2) {
		this.it_2 = it_2;
	}


	public String getIt_3() {
		return it_3;
	}


	public void setIt_3(String it_3) {
		this.it_3 = it_3;
	}


	public String getIt_4() {
		return it_4;
	}


	public void setIt_4(String it_4) {
		this.it_4 = it_4;
	}


	public String getIt_5() {
		return it_5;
	}


	public void setIt_5(String it_5) {
		this.it_5 = it_5;
	}


	public String getIt_6() {
		return it_6;
	}


	public void setIt_6(String it_6) {
		this.it_6 = it_6;
	}


	public String getIt_7() {
		return it_7;
	}


	public void setIt_7(String it_7) {
		this.it_7 = it_7;
	}


	public String getIt_8() {
		return it_8;
	}


	public void setIt_8(String it_8) {
		this.it_8 = it_8;
	}


	public String getIt_9() {
		return it_9;
	}


	public void setIt_9(String it_9) {
		this.it_9 = it_9;
	}


	public String getIt_10() {
		return it_10;
	}


	public void setIt_10(String it_10) {
		this.it_10 = it_10;
	}


	public String getIt_12() {
		return it_12;
	}


	public void setIt_12(String it_12) {
		this.it_12 = it_12;
	}


	public String getIt_13() {
		return it_13;
	}


	public void setIt_13(String it_13) {
		this.it_13 = it_13;
	}


	public String getIt_15() {
		return it_15;
	}


	public void setIt_15(String it_15) {
		this.it_15 = it_15;
	}


	public String getIt_16() {
		return it_16;
	}


	public void setIt_16(String it_16) {
		this.it_16 = it_16;
	}


	public String getIt_17() {
		return it_17;
	}


	public void setIt_17(String it_17) {
		this.it_17 = it_17;
	}


	public String getIt_18() {
		return it_18;
	}


	public void setIt_18(String it_18) {
		this.it_18 = it_18;
	}


	public String getIt_20() {
		return it_20;
	}


	public void setIt_20(String it_20) {
		this.it_20 = it_20;
	}


	public String getIt_21() {
		return it_21;
	}


	public void setIt_21(String it_21) {
		this.it_21 = it_21;
	}


	public String getOdtc_1() {
		return odtc_1;
	}


	public void setOdtc_1(String odtc_1) {
		this.odtc_1 = odtc_1;
	}


	public String getOdtc_2() {
		return odtc_2;
	}


	public void setOdtc_2(String odtc_2) {
		this.odtc_2 = odtc_2;
	}


	public String getOdtc_3() {
		return odtc_3;
	}


	public void setOdtc_3(String odtc_3) {
		this.odtc_3 = odtc_3;
	}


	public String getOdtc_4() {
		return odtc_4;
	}


	public void setOdtc_4(String odtc_4) {
		this.odtc_4 = odtc_4;
	}


	public String getOdtc_5() {
		return odtc_5;
	}


	public void setOdtc_5(String odtc_5) {
		this.odtc_5 = odtc_5;
	}


	public String getOdtc_6() {
		return odtc_6;
	}


	public void setOdtc_6(String odtc_6) {
		this.odtc_6 = odtc_6;
	}


	public String getOdtc_7() {
		return odtc_7;
	}


	public void setOdtc_7(String odtc_7) {
		this.odtc_7 = odtc_7;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
	
	
}
