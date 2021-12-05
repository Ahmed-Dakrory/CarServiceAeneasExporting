package main.com.carService.carLandingImage;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import main.com.carService.carLanding.carLanding;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="carimageLanding.getAll",
		     query="SELECT c FROM carimageLanding c where c.deleted = false"
		     )
	,
	@NamedQuery(name="carimageLanding.getById",
	query = "from carimageLanding d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="carimageLanding.getAllByCarId",
	query = "from carimageLanding d where d.carId.id = :id and d.deleted = false"
			)
	,
	
	@NamedQuery(name="carimageLanding.getByUrl",
	query = "from carimageLanding d where d.url = :url and d.deleted = false"
			)
	
	
})

@Entity
@Table(name = "carimageLanding")
public class carimageLanding {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "url")
	private String url;
	
	
	@ManyToOne
	@JoinColumn(name = "carId")
	private carLanding carId;


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


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public carLanding getCarId() {
		return carId;
	}


	public void setCarId(carLanding carId) {
		this.carId = carId;
	}



	
	
}
