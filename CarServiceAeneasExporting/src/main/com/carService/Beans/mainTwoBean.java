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

import main.com.carService.car.carAppServiceImpl;
import main.com.carService.loginNeeds.user;
import main.com.carService.mainTwo.mainTwo;
import main.com.carService.mainTwo.mainTwoAppServiceImpl;
import main.com.carService.moneyBox.moneybox;
import main.com.carService.tools.Constants;


@ManagedBean(name = "mainTwoBean")
@SessionScoped
public class mainTwoBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 

	@ManagedProperty(value = "#{carFacadeImpl}")
	private carAppServiceImpl carFacade;
	

	@ManagedProperty(value = "#{mainTwoFacadeImpl}")
	private mainTwoAppServiceImpl mainTwoFacade;
	
	
	private List<mainTwo> allmainTwos;
	
	private mainTwo selectedmainTwo;
	
	private mainTwo addNewmainTwo;
	
	@PostConstruct
	public void init() {
		
		refresh();
		
		selectedmainTwo=new mainTwo();
		addNewmainTwo=new mainTwo();
		user userId=new user();
		addNewmainTwo.setUserId(userId);
		addNewmainTwo.setParentId(loginBean.getTheUserOfThisAccount());
		
	}
	
	
	
	public void refresh(){
		allmainTwos=mainTwoFacade.getAllByParentId(loginBean.getTheUserOfThisAccount().getId());
		
		
	
	}
	

	
	
	public String getFormatedDate(Calendar c) {
		String dateTime="";
		if(c!=null) {
			String[] monthNames = {"Jan", "Feb", "Mar", "April", "May", "Jun", "Jul", "Aug", "Sep", "Octo", "Nov", "Dec"};
		    
		dateTime = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) +"/"+
				   String.valueOf(monthNames[c.get(Calendar.MONTH)]) +"/"+
				   String.valueOf(c.get(Calendar.YEAR));
		}
		return dateTime;
	}
	
	
	public void goToAddNewmainTwo() {
		addNewmainTwo=new mainTwo();
		user userId=new user();
		addNewmainTwo.setUserId(userId);
		addNewmainTwo.setParentId(loginBean.getTheUserOfThisAccount());
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/mainTwo/mainTwoAddNew.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void selectmainTwo(int idmainTwo) {
		selectedmainTwo=mainTwoFacade.getById(idmainTwo);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/mainTwo/mainTwoEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void saveNewmainTwoData() {
		user userNew= addNewmainTwo.getUserId();
		
		boolean isValid=checkValidForUser(addNewmainTwo);
		if(isValid) {
			boolean checkUserName = checkUserNameIsExist(addNewmainTwo.getUserId().getUserName());
			if(checkUserName) {
		userNew.setDate(Calendar.getInstance());
		userNew.setRole(user.ROLE_MAIN2);
		userNew.setPassword(new  Md5PasswordEncoder().encodePassword(userNew.getUserName(),userNew.getUserName()));
		userNew.setMainUserId(loginBean.getTheMainUserOfThisAccount());
		
		
		loginBean.getUserDataFacede().adduser(userNew);
		

		moneybox mB = new moneybox();
		mB.setActive(true);
		mB.setUserId(userNew);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mB);
		addNewmainTwo.setParentId(loginBean.getTheUserOfThisAccount());
		mainTwoFacade.addmainTwo(addNewmainTwo);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your mainTwo has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		Constants.sendEmailNewAccount(addNewmainTwo.getUserId().getFirstName(),addNewmainTwo.getUserId().getEmail(),addNewmainTwo.getUserId().getUserName());
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/mainTwo/mainTwoList.jsf?faces-redirect=true");
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

	private boolean checkValidForUser(mainTwo addNewmainTwo2) {
		// TODO Auto-generated method stub
		if(addNewmainTwo2.getUserId().getCompany().equals("")||addNewmainTwo2.getUserId().getCompany()==null) {
			return false;
		}
		
		if(addNewmainTwo2.getUserId().getUserName().equals("")||addNewmainTwo2.getUserId().getUserName()==null) {
			return false;
		}
		
		if(addNewmainTwo2.getUserId().getFirstName().equals("")||addNewmainTwo2.getUserId().getFirstName()==null) {
			return false;
		}
		
		if(addNewmainTwo2.getUserId().getLastName().equals("")||addNewmainTwo2.getUserId().getLastName()==null) {
			return false;
		}
		
		if(addNewmainTwo2.getUserId().getEmail().equals("")||addNewmainTwo2.getUserId().getEmail()==null) {
			return false;
		}
		
		return true;
	}

	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/mainTwo/mainTwoList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData() {

		boolean isValid=checkValidForUser(selectedmainTwo);
		if(isValid) {
		loginBean.getUserDataFacede().adduser(selectedmainTwo.getUserId());
		
		mainTwoFacade.addmainTwo(selectedmainTwo);

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


	public List<mainTwo> getAllmainTwos() {
		return allmainTwos;
	}

	public void setAllmainTwos(List<mainTwo> allmainTwos) {
		this.allmainTwos = allmainTwos;
	}

	public mainTwo getSelectedmainTwo() {
		return selectedmainTwo;
	}

	public void setSelectedmainTwo(mainTwo selectedmainTwo) {
		this.selectedmainTwo = selectedmainTwo;
	}

	public mainTwo getAddNewmainTwo() {
		return addNewmainTwo;
	}

	public void setAddNewmainTwo(mainTwo addNewmainTwo) {
		this.addNewmainTwo = addNewmainTwo;
	}

	public mainTwoAppServiceImpl getmainTwoFacade() {
		return mainTwoFacade;
	}

	public void setmainTwoFacade(mainTwoAppServiceImpl mainTwoFacade) {
		this.mainTwoFacade = mainTwoFacade;
	}

	public carAppServiceImpl getCarFacade() {
		return carFacade;
	}

	public void setCarFacade(carAppServiceImpl carFacade) {
		this.carFacade = carFacade;
	}



	public mainTwoAppServiceImpl getMainTwoFacade() {
		return mainTwoFacade;
	}



	public void setMainTwoFacade(mainTwoAppServiceImpl mainTwoFacade) {
		this.mainTwoFacade = mainTwoFacade;
	}

	

	
	
}
