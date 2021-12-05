package main.com.carService.loginNeeds;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="user.getAll",
		     query="SELECT c FROM user c where c.deleted = false"
		     )
	,
	@NamedQuery(name="user.getById",
	query = "from user d where d.id = :id and d.deleted = false"
			)
	
	,
	@NamedQuery(name="user.getByUserName",
	query = "from user d where d.userName = :userName and d.deleted = false"
			)
	
	,
	@NamedQuery(name="user.getByUserNameAndRole",
	query = "from user d where d.userName = :userName and d.role = :role and d.deleted = false"
			)
	
	,
	@NamedQuery(name="user.getAllWithRole",
	query = "from user d where d.role = :role and d.deleted = false"
			)
	
	,
	@NamedQuery(name="user.getByUserNameAndPassword",
	query = "from user d where d.userName = :userName and d.password = :password and active = :active and d.deleted = false"
			)
	
})

@Entity
@Table(name = "user")
public class user {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "userName")
	private String userName;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	
	@Column(name = "email")
	private String email;
	

	@Column(name = "password")
	private String password;
	

	@Column(name = "lastUpdate")
	private Calendar lastUpdate;
	
	@Column(name = "date")
	private Calendar date;
	


	@Column(name="image")
	@Lob
	private byte[] image;
	
	
	@Column(name = "role")
	private Integer role;


	@Column(name = "active")
	private boolean active;
	

	@Column(name = "country")
	private String country;


	@Column(name = "address1")
	private String address1;
	

	@Column(name = "address2")
	private String address2;
	

	@Column(name = "city")
	private String city;
	

	@Column(name = "state")
	private String state;
	

	@Column(name = "zip")
	private String zip;
	

	
	@Column(name = "phone")
	private String phone;

	@Column(name = "mobilePhone")
	private String mobilePhone;
	

	@Column(name = "Phone2")
	private String Phone2;
	

	@Column(name = "fax")
	private String fax;
	
	
	@Column(name = "deleted")
	private boolean deleted;
	

	@ManyToOne
	@JoinColumn(name = "mainUserId")
	private user mainUserId;
	
	
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




	public String getCompany() {
		return company;
	}




	public void setCompany(String company) {
		this.company = company;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Calendar getLastUpdate() {
		return lastUpdate;
	}




	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}




	public Calendar getDate() {
		return date;
	}




	public void setDate(Calendar date) {
		this.date = date;
	}




	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}




	public Integer getRole() {
		return role;
	}




	public void setRole(Integer role) {
		this.role = role;
	}




	public boolean getActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getAddress1() {
		return address1;
	}




	public void setAddress1(String address1) {
		this.address1 = address1;
	}




	public String getAddress2() {
		return address2;
	}




	public void setAddress2(String address2) {
		this.address2 = address2;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getZip() {
		return zip;
	}




	public void setZip(String zip) {
		this.zip = zip;
	}








	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getMobilePhone() {
		return mobilePhone;
	}




	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}




	public String getPhone2() {
		return Phone2;
	}




	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}




	public String getFax() {
		return fax;
	}




	public void setFax(String fax) {
		this.fax = fax;
	}


	


	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}





	public user getMainUserId() {
		return mainUserId;
	}


	public void setMainUserId(user mainUserId) {
		this.mainUserId = mainUserId;
	}





	public static int ROLE_MAIN=0;
	public static int ROLE_SHIPPER=1;
	public static int ROLE_VENDOR=2;
	public static int ROLE_CUSTOMER=3;
	public static int ROLE_CONGSIGNEE=4;
	public static int ROLE_MAIN2=5;

	


	public String getRoleString() {
		if(role==ROLE_MAIN) {
			return "Admin";
		}else if(role==ROLE_SHIPPER) {
			return "Shipper";
		}else if(role==ROLE_VENDOR) {
			return "Vendor";
		}else if(role==ROLE_CUSTOMER) {
			return "Customer";
		}else if(role==ROLE_MAIN2) {
			return "Follower User";
		}else{
			return "Consignee";
		}
	}

	public static int Active=1;
	public static int InActive=0;
	

	public String getphoto() {
		if(getImage()!=null) {
		String imageString= new String(Base64.encodeBase64(image));

		return "data:image/png;base64, "+imageString;
		}else {
			return "/resources/images/comment-img3.jpg";
		}
	}

}
