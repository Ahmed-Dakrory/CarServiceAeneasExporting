package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
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
import main.com.carService.consignee.consignee;
import main.com.carService.consignee.consigneeAppServiceImpl;


@ManagedBean(name = "consigneeBean")
@SessionScoped
public class consigneeBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{consigneeFacadeImpl}")
	private consigneeAppServiceImpl consigneeFacade;
	
	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	
	private List<consignee> allconsignees;
	
	private consignee selectedconsignee;
	
	private consignee addNewconsignee;
	
	@PostConstruct
	public void init() {
		
		refresh();
		
		selectedconsignee=new consignee();
		addNewconsignee=new consignee();
		user userId=new user();
		addNewconsignee.setUserId(userId);
		shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		addNewconsignee.setParentId(shipperOfThisAccount);
	}
	
	public void refresh(){
		int role=loginBean.getTheUserOfThisAccount().getRole();
		if(role==user.ROLE_MAIN) {
			allconsignees=consigneeFacade.getAllByMainAccountIdOfParentShipper(loginBean.getTheUserOfThisAccount().getId());
			
		}else if(role==user.ROLE_SHIPPER) {
			shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			
			allconsignees=consigneeFacade.getAllByParentId(shipperOfThisAccount.getId());
			
		}
		
	}
	
	public void goToAddNewconsignee() {
		addNewconsignee=new consignee();
		user userId=new user();
		addNewconsignee.setUserId(userId);
		shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewconsignee.setParentId(shipperOfThisAccount);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/consignee/consigneeAddNew.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectconsignee(int idconsignee) {
		selectedconsignee=consigneeFacade.getById(idconsignee);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/consignee/consigneeEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void saveNewconsigneeData() {
		user userNew= addNewconsignee.getUserId();
		
		boolean isValid=checkValidForUser(addNewconsignee);
		if(isValid) {
			boolean checkUserName = checkUserNameIsExist(addNewconsignee.getUserId().getUserName());
			if(checkUserName) {
				
				
				
		userNew.setDate(Calendar.getInstance());
		userNew.setRole(user.ROLE_CONGSIGNEE);
		userNew.setPassword(new  Md5PasswordEncoder().encodePassword(userNew.getUserName(),userNew.getUserName()));
		userNew.setMainUserId(loginBean.getTheMainUserOfThisAccount());
		
		loginBean.getUserDataFacede().adduser(userNew);
		

		moneybox mB = new moneybox();
		mB.setActive(true);
		mB.setUserId(userNew);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mB);
		shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		addNewconsignee.setParentId(shipperOfThisAccount);
		consigneeFacade.addconsignee(addNewconsignee);
		Constants.sendEmailNewAccount(addNewconsignee.getUserId().getFirstName(),addNewconsignee.getUserId().getEmail(),addNewconsignee.getUserId().getUserName());
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your consignee has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/consignee/consigneeList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else {

				userNew=loginBean.getUserDataFacede().getByUserNameAndRole(addNewconsignee.getUserId().getUserName(),user.ROLE_CONGSIGNEE);
if(userNew!=null) {
				shipper shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
				if(!isTheConsigneeExistForThisShipperAndConsignee(shipperOfThisAccount,userNew)) {


		
				addNewconsignee.setUserId(userNew);
		
		addNewconsignee.setParentId(shipperOfThisAccount);
		consigneeFacade.addconsignee(addNewconsignee);
		//Not Need This EmaUserNametification as the consignee is registered already
		//Constants.sendEmailNewAccount(addNewconsignee.getUserId().getFirstName(),addNewconsignee.getUserId().getEmail(),addNewconsignee.getUserId().getUserName());
		
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your consignee has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/consignee/consigneeList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}else {
					PrimeFaces.current().executeScript("new PNotify({\r\n" + 
							"			title: 'Check this ',\r\n" + 
							"			text: 'This Consignee is already Registered',\r\n" + 
							"			left:\"2%\"\r\n" + 
							"		});");
				}
}else {
	PrimeFaces.current().executeScript("new PNotify({\r\n" + 
			"			title: 'Check this ',\r\n" + 
			"			text: 'This UserName is for another Role and cannot be used',\r\n" + 
			"			left:\"2%\"\r\n" + 
			"		});");
}
			}
		}else {
			PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'Check the Madatory fields',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
		}
	}

	private boolean isTheConsigneeExistForThisShipperAndConsignee(shipper shipperOfThisAccount,user userNew) {
		// TODO Auto-generated method stub
		consignee allconsigneeForThisShipper = consigneeFacade.getAllByParentIdAndUserId(shipperOfThisAccount.getId(),userNew.getId());
		if(allconsigneeForThisShipper!=null) {
			
				return true;
			
		}
		return false;
	}

	private boolean checkUserNameIsExist(String userName) {
		// TODO Auto-generated method stub
		
		user the_user=loginBean.getUserDataFacede().getByUserName(userName);
		if(the_user!=null) {
			return false;
		}
		return true;
	}

	private boolean checkValidForUser(consignee addNewconsignee2) {
		// TODO Auto-generated method stub
		if(addNewconsignee2.getUserId().getCompany().equals("")||addNewconsignee2.getUserId().getCompany()==null) {
			return false;
		}
		
		if(addNewconsignee2.getUserId().getUserName().equals("")||addNewconsignee2.getUserId().getUserName()==null) {
			return false;
		}
		
		if(addNewconsignee2.getUserId().getFirstName().equals("")||addNewconsignee2.getUserId().getFirstName()==null) {
			return false;
		}
		
		if(addNewconsignee2.getUserId().getLastName().equals("")||addNewconsignee2.getUserId().getLastName()==null) {
			return false;
		}
		
		if(addNewconsignee2.getUserId().getEmail().equals("")||addNewconsignee2.getUserId().getEmail()==null) {
			return false;
		}
		
		return true;
	}

	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/consignee/consigneeList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData() {

		boolean isValid=checkValidForUser(selectedconsignee);
		if(isValid) {
			
			
		loginBean.getUserDataFacede().adduser(selectedconsignee.getUserId());
		
		consigneeFacade.addconsignee(selectedconsignee);

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<consignee> getAllconsignees() {
		return allconsignees;
	}

	public void setAllconsignees(List<consignee> allconsignees) {
		this.allconsignees = allconsignees;
	}

	public consignee getSelectedconsignee() {
		return selectedconsignee;
	}

	public void setSelectedconsignee(consignee selectedconsignee) {
		this.selectedconsignee = selectedconsignee;
	}

	public consignee getAddNewconsignee() {
		return addNewconsignee;
	}

	public void setAddNewconsignee(consignee addNewconsignee) {
		this.addNewconsignee = addNewconsignee;
	}

	public consigneeAppServiceImpl getconsigneeFacade() {
		return consigneeFacade;
	}

	public void setconsigneeFacade(consigneeAppServiceImpl consigneeFacade) {
		this.consigneeFacade = consigneeFacade;
	}

	public consigneeAppServiceImpl getConsigneeFacade() {
		return consigneeFacade;
	}

	public void setConsigneeFacade(consigneeAppServiceImpl consigneeFacade) {
		this.consigneeFacade = consigneeFacade;
	}

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}
	

	
	
	
}
