package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.carService.loginNeeds.user;
import main.com.carService.moneyBox.moneybox;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperAppServiceImpl;
import main.com.carService.tools.Constants;
import main.com.carService.vendor.vendor;
import main.com.carService.vendor.vendorAppServiceImpl;
import main.com.carService.customer.customer;
import main.com.carService.customer.customerAppServiceImpl;


@ManagedBean(name = "customerBean")
@SessionScoped
public class customerBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{customerFacadeImpl}")
	private customerAppServiceImpl customerFacade;

	@ManagedProperty(value = "#{vendorFacadeImpl}")
	private vendorAppServiceImpl vendorFacade;
	

	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	
	private List<customer> allcustomers;
	
	private customer selectedcustomer;
	
	private customer addNewcustomer;
	
	@PostConstruct
	public void init() {
		
		refresh();
		
		selectedcustomer=new customer();
		addNewcustomer=new customer();
		user userId=new user();
		addNewcustomer.setUserId(userId);
		vendor vendor_of_this_account=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewcustomer.setParentId(vendor_of_this_account);
	}
	
	public void refresh(){
		
		//Get All customers For The Shipper
		//
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_VENDOR) {
			vendor vendor_of_this_account=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			
			allcustomers=customerFacade.getAllByParentId(vendor_of_this_account.getId());
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_SHIPPER) {
			//This ShipperParentId
			shipper shipper_of_this_account=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			
			allcustomers=customerFacade.getAllByShipperOfParentId(shipper_of_this_account.getId());
			
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_MAIN) {
			allcustomers=customerFacade.getAllByUserOfParentOfParentId(loginBean.getTheUserOfThisAccount().getId());
			
		}else {
			allcustomers=new ArrayList<customer>();
		}
		
		
	}
	
	public void goToAddNewcustomer() {
		addNewcustomer=new customer();
		user userId=new user();
		addNewcustomer.setUserId(userId);
		vendor vendor_of_this_account=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		addNewcustomer.setParentId(vendor_of_this_account);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/customer/customerAddNew.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectcustomer(int idcustomer) {
		selectedcustomer=customerFacade.getById(idcustomer);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/customer/customerEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void saveNewcustomerData() {
		user userNew= addNewcustomer.getUserId();
		
		boolean isValid=checkValidForUser(addNewcustomer);
		if(isValid) {
			boolean checkUserName = checkUserNameIsExist(addNewcustomer.getUserId().getUserName());
			if(checkUserName) {
		userNew.setDate(Calendar.getInstance());
		userNew.setRole(user.ROLE_CUSTOMER);
		userNew.setPassword(new  Md5PasswordEncoder().encodePassword(userNew.getUserName(),userNew.getUserName()));
		userNew.setMainUserId(loginBean.getTheMainUserOfThisAccount());
		
		
		loginBean.getUserDataFacede().adduser(userNew);
		

		moneybox mB = new moneybox();
		mB.setActive(true);
		mB.setUserId(userNew);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mB);
		vendor vendor_of_this_account=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewcustomer.setParentId(vendor_of_this_account);
		customerFacade.addcustomer(addNewcustomer);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your customer has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		Constants.sendEmailNewAccount(addNewcustomer.getUserId().getFirstName(),addNewcustomer.getUserId().getEmail(),addNewcustomer.getUserId().getUserName());
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/customer/customerList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else {
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Check this ',\r\n" + 
						"			text: 'This userName is already Registered',\r\n" + 
						"			left:\"2%\"\r\n" + 
						"		});");
			}
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}

	private boolean checkUserNameIsExist(String userName) {
		// TODO Auto-generated method stub
		
		user the_user=loginBean.getUserDataFacede().getByUserName(userName);
		if(the_user!=null) {
			return false;
		}
		return true;
	}

	private boolean checkValidForUser(customer addNewcustomer2) {
		// TODO Auto-generated method stub
		if(addNewcustomer2.getUserId().getCompany().equals("")||addNewcustomer2.getUserId().getCompany()==null) {
			return false;
		}
		
		if(addNewcustomer2.getUserId().getUserName().equals("")||addNewcustomer2.getUserId().getUserName()==null) {
			return false;
		}
		
		if(addNewcustomer2.getUserId().getFirstName().equals("")||addNewcustomer2.getUserId().getFirstName()==null) {
			return false;
		}
		
		if(addNewcustomer2.getUserId().getLastName().equals("")||addNewcustomer2.getUserId().getLastName()==null) {
			return false;
		}
		
		if(addNewcustomer2.getUserId().getEmail().equals("")||addNewcustomer2.getUserId().getEmail()==null) {
			return false;
		}
		
		return true;
	}

	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/customer/customerList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData() {

		boolean isValid=checkValidForUser(selectedcustomer);
		if(isValid) {
		loginBean.getUserDataFacede().adduser(selectedcustomer.getUserId());
		
		customerFacade.addcustomer(selectedcustomer);

		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your data has been updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
			
		}
	}

	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public customerAppServiceImpl getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(customerAppServiceImpl customerFacade) {
		this.customerFacade = customerFacade;
	}

	public vendorAppServiceImpl getVendorFacade() {
		return vendorFacade;
	}

	public void setVendorFacade(vendorAppServiceImpl vendorFacade) {
		this.vendorFacade = vendorFacade;
	}

	public List<customer> getAllcustomers() {
		return allcustomers;
	}

	public void setAllcustomers(List<customer> allcustomers) {
		this.allcustomers = allcustomers;
	}

	public customer getSelectedcustomer() {
		return selectedcustomer;
	}

	public void setSelectedcustomer(customer selectedcustomer) {
		this.selectedcustomer = selectedcustomer;
	}

	public customer getAddNewcustomer() {
		return addNewcustomer;
	}

	public void setAddNewcustomer(customer addNewcustomer) {
		this.addNewcustomer = addNewcustomer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}



	
	
	
}
