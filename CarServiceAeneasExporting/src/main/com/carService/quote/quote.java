package main.com.carService.quote;


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

import main.com.carService.shipper.shipper;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="quote.getAll",
		     query="SELECT c FROM quote c where c.deleted = false"
		     )
	,
	@NamedQuery(name="quote.getById",
	query = "from quote d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="quote.getAllByShipperId",
	query = "from quote d where d.shipperId.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="quote.getAllByUserId",
	query = "from quote d where d.shipperId.userId.id = :id and d.deleted = false"
			)
	

	,
	@NamedQuery(name="quote.getAllByUserOfShipperId",
	query = "from quote d where d.shipperId.parentId.id = :id and d.deleted = false"
			)
	
})

@Entity
@Table(name = "quote")
public class quote {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "dateOfShipment")
	private Calendar dateOfShipment;

	@Column(name = "dimensions")
	private Integer dimensions;
	

	@Column(name = "commodity")
	private Integer commodity;
	
	@Column(name = "movetype")
	private Integer movetype;
	
	
	@Column(name = "comDescription")
	private String comDescription;
	
	@Column(name = "width")
	private Float width;
	
	@Column(name = "height")
	private Float height;
	
	@Column(name = "depth")
	private Float depth;
	
	
	@Column(name = "weight")
	private Float weight;
	
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "pieces")
	private Integer pieces;
	
	@Column(name = "mode")
	private Integer mode;
	
	@Column(name = "marineInsurance")
	private boolean marineInsurance;
	
	@Column(name = "loadtype")
	private Integer loadtype;
	
	@Column(name = "declaredvalue")
	private String declaredvalue;
	

	
	@ManyToOne
	@JoinColumn(name = "shipperId")
	private shipper shipperId;



	@Column(name = "fromCountry")
	private Integer fromCountry;
	
	@Column(name = "fromState")
	private Integer fromState;
	
	@Column(name = "fromPort")
	private Integer fromPort;
	
	
	@Column(name = "toCountry")
	private Integer toCountry;
	
	@Column(name = "toState")
	private Integer toState;
	
	@Column(name = "toPort")
	private Integer toPort;
	
	
	@Column(name = "note")
	private String note;

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


	public Calendar getDateOfShipment() {
		return dateOfShipment;
	}


	public void setDateOfShipment(Calendar dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}


	public Integer getDimensions() {
		return dimensions;
	}


	public void setDimensions(Integer dimensions) {
		this.dimensions = dimensions;
	}


	public Integer getCommodity() {
		return commodity;
	}


	public void setCommodity(Integer commodity) {
		this.commodity = commodity;
	}


	public String getComDescription() {
		return comDescription;
	}


	public void setComDescription(String comDescription) {
		this.comDescription = comDescription;
	}


	public Float getWidth() {
		return width;
	}


	public void setWidth(Float width) {
		this.width = width;
	}


	public Float getHeight() {
		return height;
	}


	public void setHeight(Float height) {
		this.height = height;
	}


	public Float getDepth() {
		return depth;
	}


	public void setDepth(Float depth) {
		this.depth = depth;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getPieces() {
		return pieces;
	}


	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}


	public Integer getMode() {
		return mode;
	}


	public void setMode(Integer mode) {
		this.mode = mode;
	}


	public Integer getLoadtype() {
		return loadtype;
	}


	public void setLoadtype(Integer loadtype) {
		this.loadtype = loadtype;
	}


	public String getDeclaredvalue() {
		return declaredvalue;
	}


	public void setDeclaredvalue(String declaredvalue) {
		this.declaredvalue = declaredvalue;
	}


	public shipper getShipperId() {
		return shipperId;
	}


	public void setShipperId(shipper shipperId) {
		this.shipperId = shipperId;
	}


	public Integer getFromCountry() {
		return fromCountry;
	}


	public void setFromCountry(Integer fromCountry) {
		this.fromCountry = fromCountry;
	}


	public Integer getFromState() {
		return fromState;
	}


	public void setFromState(Integer fromState) {
		this.fromState = fromState;
	}


	public Integer getFromPort() {
		return fromPort;
	}


	public void setFromPort(Integer fromPort) {
		this.fromPort = fromPort;
	}


	public Integer getToCountry() {
		return toCountry;
	}


	public void setToCountry(Integer toCountry) {
		this.toCountry = toCountry;
	}


	public Integer getToState() {
		return toState;
	}


	public void setToState(Integer toState) {
		this.toState = toState;
	}


	public Integer getToPort() {
		return toPort;
	}


	public void setToPort(Integer toPort) {
		this.toPort = toPort;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Float getWeight() {
		return weight;
	}


	public void setWeight(Float weight) {
		this.weight = weight;
	}


	public Integer getMovetype() {
		return movetype;
	}


	public void setMovetype(Integer movetype) {
		this.movetype = movetype;
	}


	public boolean getMarineInsurance() {
		return marineInsurance;
	}


	public void setMarineInsurance(boolean marineInsurance) {
		this.marineInsurance = marineInsurance;
	}
	
	
	
	
	
}
