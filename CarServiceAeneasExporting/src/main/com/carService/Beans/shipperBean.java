package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.carService.car.car;
import main.com.carService.car.carAppServiceImpl;
import main.com.carService.invoice.invoice;
import main.com.carService.invoice.invoiceAppServiceImpl;
import main.com.carService.invoice.invoiceDTO;
import main.com.carService.invoiceCars.invoiceCar;
import main.com.carService.invoiceCars.invoiceCarAppServiceImpl;
import main.com.carService.loginNeeds.user;
import main.com.carService.moneyBox.moneybox;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_details;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperAppServiceImpl;
import main.com.carService.tools.Constants;


@ManagedBean(name = "shipperBean")
@SessionScoped
public class shipperBean implements Serializable{
	
	

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
	

	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	
	@ManagedProperty(value = "#{invoiceFacadeImpl}")
	private invoiceAppServiceImpl invoiceFacade;
	
	@ManagedProperty(value = "#{invoiceCarFacadeImpl}")
	private invoiceCarAppServiceImpl invoiceCarFacade;
	
	private List<shipper> allshippers;
	
	private shipper selectedshipper;
	
	private shipper addNewshipper;
	
	private shipper shipperForInvoice;
	private invoice invoiceData;
	private List<car> carsForthisAccount;
	private List<car> carsForInvoice;
	private Integer selectedCarIdToBeAddedInInvoice;
	private Float carFeesInvoice;
	
	private List<invoiceDTO> allInvoice;
	private String dateLower;
	private String dateHigh;
	private float totalFees;
	
	
	@PostConstruct
	public void init() {
		
		refresh();
		
		selectedshipper=new shipper();
		addNewshipper=new shipper();
		user userId=new user();
		addNewshipper.setUserId(userId);
		addNewshipper.setParentId(loginBean.getTheUserOfThisAccount());
		
		invoiceData=new invoice();
	}
	
	public void getTheInvoiceData(int invoiceId) {
		invoiceData = invoiceFacade.getById(invoiceId);
		

		shipperForInvoice=shipperFacade.getByUserId(invoiceData.getUserIdCustomer().getId());
		carsForthisAccount=new ArrayList<car>();
		
		List<car> wareHouseMain = carFacade.getAllWareHouseForShipper(shipperForInvoice.getId());
		List<car> dryCargoMain = carFacade.getAllDryCargoForShipper(shipperForInvoice.getId());
		List<car> transitMain = carFacade.getAllFrightInTransitForShipper(shipperForInvoice.getId());

		if(wareHouseMain!=null)
			carsForthisAccount.addAll(wareHouseMain);
			
		if(dryCargoMain!=null)
			carsForthisAccount.addAll(dryCargoMain);
			
		if(transitMain!=null)
			carsForthisAccount.addAll(transitMain);
			
		
		List<invoiceCar> listOfCarsInvoices = invoiceCarFacade.getAllByinvoiceId(invoiceId);
		carsForInvoice = new ArrayList<car>();
		for(int i = 0;i<listOfCarsInvoices.size();i++) {
			carsForInvoice.add(carFacade.getById(listOfCarsInvoices.get(i).getCarId().getId()));
		}
		
		

		try {

			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoiceEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void updateTheInvoice() {
		System.out.println("Ahmed: Data");
		invoice lastInvoice = invoiceFacade.getById(invoiceData.getId());
		List<invoiceCar> lastInvoiceCars = invoiceCarFacade.getAllByinvoiceId(invoiceData.getId());

		System.out.println("Ahmed: Data2");
		for(int i = 0;i<lastInvoiceCars.size();i++) {
			
			try {
				System.out.println("Ahmed: "+lastInvoiceCars.get(i).getCarId().getId());
				invoiceCarFacade.delete(lastInvoiceCars.get(i));
			} catch (Exception e) {
				System.out.println("Error: ");
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Problem While update!',\r\n" + 
						"			text: 'Please try Again!',\r\n" + 
						"			type: 'error',\r\n" + 
						"			left:\"1%\"\r\n" + 
						"		});");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Modify the MoneyBox
		if(lastInvoice.isPayedOrNot()) {
			//Modify the moneyBox
			resetTheTotalAmountOFMoneyBoxs(lastInvoice);

		}
		
		
		//add the invoice and the car list
		
		
		invoiceData.setDate(Calendar.getInstance());

		System.out.println("Ahmed:4 Data");
		invoiceFacade.addinvoice(invoiceData);
		carFeesInvoice=(float) 0;
		System.out.println("AhmedMohamed:"+ String.valueOf(carsForInvoice.size()));
		for(int i=0;i<carsForInvoice.size();i++) {
			invoiceCar carinvoice=new invoiceCar();
			carinvoice.setCarId(carsForInvoice.get(i));
			carinvoice.setInvoiceId(invoiceData);
			
			invoiceCarFacade.addinvoiceCar(carinvoice);
			float landCost = 0;
			float Seacost=0;
			float Commision=0;
			float Fees=0;
			try {
				landCost=carsForInvoice.get(i).getLandcost();
			}catch(Exception ee) {
				
			}
			
			try {
				Seacost=carsForInvoice.get(i).getSeacost();
			}catch(Exception ee) {
				
			}
			
			try {
				Commision=carsForInvoice.get(i).getCommision();
			}catch(Exception ee) {
				
			}
			
			try {
				Fees=carsForInvoice.get(i).getFees();
			}catch(Exception ee) {
				
			}
			
					
			float totalForCar=(float) (landCost+Seacost
					+Commision+Fees);
			
			carFeesInvoice+=totalForCar;
		}
		moneybox mBofThisShipper = loginBean.getMoneyBoxDataFacede().getByUserId(shipperForInvoice.getUserId().getId());
		moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
		
		moneybox_transaction_details M_B_T = new moneybox_transaction_details();
		
		M_B_T.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Payment.getType());
		M_B_T.setAmountBefore(mBofMainAccount.getAvailableMoney());
		
		float amount_Of_This_Invoice = invoiceData.getWireFees()+carFeesInvoice+(invoiceData.getTransferFees()/100*carFeesInvoice);
		
		M_B_T.setAmount(amount_Of_This_Invoice);
		M_B_T.setDate(new Date());
		M_B_T.setMoneyBoxId(mBofThisShipper);
		
		
		if(invoiceData.isPayedOrNot()) {
			loginBean.getMoneybox_transaction_detailsDataFacede().addmoneybox_transaction_details(M_B_T);
			mBofThisShipper.setTotalUsed(mBofThisShipper.getTotalUsed()+amount_Of_This_Invoice);
			mBofThisShipper.setAvailableMoney(mBofThisShipper.getAvailableMoney()-amount_Of_This_Invoice);
			 
			
			mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney()+amount_Of_This_Invoice);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisShipper);
			
			
			invoiceData.setTransactionId(M_B_T);
			invoiceFacade.addinvoice(invoiceData);
			
		}
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoice.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void cancelEdit() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoiceList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void resetTheTotalAmountOFMoneyBoxs(invoice lastInvoice) {
		
		moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
		Integer idTrans= invoiceData.getTransactionId().getId();
		
		if(idTrans !=null) {
			moneybox_transaction_details M_B_T = loginBean.getMoneybox_transaction_detailsDataFacede().getById(idTrans);
			moneybox mBofThisShipper = loginBean.getMoneyBoxDataFacede().getById(M_B_T.getMoneyBoxId().getId());
			float amountToReturn = M_B_T.getAmount();
			
			mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney() - amountToReturn);
			
			mBofThisShipper.setAvailableMoney(mBofThisShipper.getAvailableMoney()+ amountToReturn);
			mBofThisShipper.setTotalUsed(mBofThisShipper.getTotalUsed()-amountToReturn);

			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisShipper);

			try {
				loginBean.getMoneybox_transaction_detailsDataFacede().delete(M_B_T);
				invoiceData.setTransactionId(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Problem While update!',\r\n" + 
						"			text: 'Please try Again!',\r\n" + 
						"			type: 'error',\r\n" + 
						"			left:\"1%\"\r\n" + 
						"		});");
				e.printStackTrace();
			}		
		}
		
		
	}

	public void getAllInvoicesBetweenDates() {
		totalFees = 0;
		Calendar lowDate = setCalendarFromString(dateLower);
		Calendar highDate = setCalendarFromString(dateHigh);
		
		allInvoice =new ArrayList<invoiceDTO>();
		List<invoice> allInvoicesForThisMainAccount =new ArrayList<invoice>();
		if(lowDate == null || highDate ==null) {
			allInvoicesForThisMainAccount = invoiceFacade.getAllByUserId(loginBean.getTheUserOfThisAccount().getId());
			
		}else {
		allInvoicesForThisMainAccount = invoiceFacade.getAllByUserIdBetweenDates(loginBean.getTheUserOfThisAccount().getId(),lowDate,highDate);
		}
		if(allInvoicesForThisMainAccount!=null) {
		if(allInvoicesForThisMainAccount.size()>0) {
		for(int i=0;i<allInvoicesForThisMainAccount.size();i++) {
			int totalFeesForInvoice = 0;
			List<invoiceCar> allCarsForThisInvoice = invoiceCarFacade.getAllByinvoiceId(allInvoicesForThisMainAccount.get(i).getId());
			for(int j=0;j<allCarsForThisInvoice.size();j++) {
				car selectedCar = allCarsForThisInvoice.get(j).getCarId();
				float landCost=0;
				float Seacost=0;
				float Commision=0;
				float Fees=0;
				
				
				if(selectedCar.getLandcost()!=null) landCost=selectedCar.getLandcost();
				if(selectedCar.getSeacost()!=null) Seacost=selectedCar.getSeacost();
				if(selectedCar.getCommision()!=null) Commision=selectedCar.getCommision();
				if(selectedCar.getFees()!=null) Fees=selectedCar.getFees();
						
				float totalForCar=(float) (landCost+Seacost
						+Commision+Fees);
				
				
				//This for total Fees Without Transfer
				totalFeesForInvoice+=totalForCar;
				
				
				//This for the total Fees With Transfer

				float trFees = 0;
					trFees=allInvoicesForThisMainAccount.get(i).getTransferFees();
					
				
				totalFees = totalFees + totalForCar + (totalForCar/100*trFees);
			}
			float wireFees = allInvoicesForThisMainAccount.get(i).getWireFees();
			
			totalFees = totalFees + wireFees;
			invoiceDTO invoicedto =new invoiceDTO();
			invoicedto.setCarsForInvoice(allCarsForThisInvoice);
			invoicedto.setInvoice(allInvoicesForThisMainAccount.get(i));
			invoicedto.setTotalPrice(totalFeesForInvoice);
			invoicedto.setNumberOfCars(allCarsForThisInvoice.size());
			
			allInvoice.add(invoicedto);
		}
		}
		}
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoiceList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refresh(){
		allshippers=shipperFacade.getAllByParentId(loginBean.getTheUserOfThisAccount().getId());
		
		
		carsForthisAccount=new ArrayList<car>();
		carsForInvoice=new ArrayList<car>();
		
		//Get all cars for the main account to be used in the invoice
		List<car> allMain = carFacade.getAllForMainUser(loginBean.getTheUserOfThisAccount().getId());
		
		if(allMain!=null)
			carsForthisAccount.addAll(allMain);
		
		
	}
	
	private Calendar setCalendarFromString(String cargoRecievedDate2) {

		Calendar cal = null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		try {
			if(cargoRecievedDate2!=null) {
			if(!cargoRecievedDate2.equals("")) {
				cal=Calendar.getInstance();
				Date date=formatter.parse(cargoRecievedDate2);
				cal.setTime(date);
			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return cal;
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
	
	public void addCarToInvoice() {
		car selectedCarToBeAddedInInvoice= carFacade.getById(selectedCarIdToBeAddedInInvoice);
		carsForInvoice.add(selectedCarToBeAddedInInvoice);

		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void deleteCarInInvoice(int indexInList) {
		carsForInvoice.remove(indexInList);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void saveInvoiceData() {

		invoiceData.setUserIdCustomer(shipperForInvoice.getUserId());
		invoiceData.setUserIdIssuer(loginBean.getTheUserOfThisAccount());
		invoiceData.setDate(Calendar.getInstance());
		invoiceData.setRole(user.ROLE_SHIPPER);
		invoiceFacade.addinvoice(invoiceData);
		carFeesInvoice=(float) 0;
		for(int i=0;i<carsForInvoice.size();i++) {
			invoiceCar carinvoice=new invoiceCar();
			carinvoice.setCarId(carsForInvoice.get(i));
			carinvoice.setInvoiceId(invoiceData);
			
			invoiceCarFacade.addinvoiceCar(carinvoice);
			

			float landCost = 0;
			try {
				landCost=carsForInvoice.get(i).getLandcost();
			}catch(NullPointerException exc) {
			}
			
			

			float Seacost = 0;
			try {
				Seacost=carsForInvoice.get(i).getSeacost();
			}catch(NullPointerException exc) {
			}
			
			

			float Commision = 0;
			try {
				Commision=carsForInvoice.get(i).getCommision();
			}catch(NullPointerException exc) {
			}
			
			
			

			float Fees = 0;
			try {
				Fees=carsForInvoice.get(i).getFees();
			}catch(NullPointerException exc) {
			}

			
			
					
			float totalForCar=(float) (landCost+Seacost
					+Commision+Fees);
			
			carFeesInvoice+=totalForCar;
		}
		moneybox mBofThisShipper = loginBean.getMoneyBoxDataFacede().getByUserId(shipperForInvoice.getUserId().getId());
		moneybox mBofMainAccount = loginBean.getMoneyBoxDataFacede().getByUserId(loginBean.getTheMainUserOfThisAccount().getId());
		
		moneybox_transaction_details M_B_T = new moneybox_transaction_details();
		M_B_T.setTypeOfTransaction(moneybox_transaction_details.depositeTypes.Payment.getType());
//		System.out.println("Dakrory:"+String.valueOf(mBofMainAccount.getId()));		
//		System.out.println("Dakrory:"+String.valueOf(mBofMainAccount.getId()));
		M_B_T.setAmountBefore(mBofMainAccount.getAvailableMoney());
		
		float amount_Of_This_Invoice = invoiceData.getWireFees()+carFeesInvoice+(invoiceData.getTransferFees()/100*carFeesInvoice);
		
		M_B_T.setAmount(amount_Of_This_Invoice);
		M_B_T.setDate(new Date());
		M_B_T.setMoneyBoxId(mBofThisShipper);
		
		if(invoiceData.isPayedOrNot()) {
			loginBean.getMoneybox_transaction_detailsDataFacede().addmoneybox_transaction_details(M_B_T);
			mBofThisShipper.setTotalUsed(mBofThisShipper.getTotalUsed()+amount_Of_This_Invoice);
			mBofThisShipper.setAvailableMoney(mBofThisShipper.getAvailableMoney()-amount_Of_This_Invoice);
			 
			
			mBofMainAccount.setAvailableMoney(mBofMainAccount.getAvailableMoney()+amount_Of_This_Invoice);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofMainAccount);
			loginBean.getMoneyBoxDataFacede().addmoneybox(mBofThisShipper);

			invoiceData.setTransactionId(M_B_T);
			invoiceFacade.addinvoice(invoiceData);
		}
		
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoice.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void goToAddNewshipper() {
		addNewshipper=new shipper();
		user userId=new user();
		addNewshipper.setUserId(userId);
		addNewshipper.setParentId(loginBean.getTheUserOfThisAccount());
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/shipperAddNew.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void selectshipper(int idshipper) {
		selectedshipper=shipperFacade.getById(idshipper);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/shipperEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void invoiceDetails(int idShipper) {
		
		invoiceData=new invoice();
		shipperForInvoice=shipperFacade.getById(idShipper);
		moneybox mB= loginBean.getThisAccountMoneyBox();
				
		try {
			invoiceData.setBankAccountNumber(mB.getBankAccountNumber());
				}catch(NullPointerException exc) {
					
				}
		
		
		try {
			invoiceData.setBankAddress(mB.getBankAddress());
		}catch(NullPointerException exc) {
			
		}
		
		
		try {
			invoiceData.setBankName(mB.getBankName());
		}catch(NullPointerException exc) {
			
		}

		
		
		try {
			invoiceData.setBankTelephone(mB.getBankTelephone());
		}catch(NullPointerException exc) {
			
		}


		
		
		
		
		carsForthisAccount=new ArrayList<car>();
		
		List<car> wareHouseMain = carFacade.getAllWareHouseForShipper(idShipper);
		List<car> dryCargoMain = carFacade.getAllDryCargoForShipper(idShipper);
		List<car> transitMain = carFacade.getAllFrightInTransitForShipper(idShipper);

		if(wareHouseMain!=null)
			carsForthisAccount.addAll(wareHouseMain);
			
		if(dryCargoMain!=null)
			carsForthisAccount.addAll(dryCargoMain);
			
		if(transitMain!=null)
			carsForthisAccount.addAll(transitMain);
			
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/invoice/invoiceAdd.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveNewshipperData() {
		user userNew= addNewshipper.getUserId();
		
		boolean isValid=checkValidForUser(addNewshipper);
		if(isValid) {
			boolean checkUserName = checkUserNameIsExist(addNewshipper.getUserId().getUserName());
			if(checkUserName) {
		userNew.setDate(Calendar.getInstance());
		userNew.setRole(user.ROLE_SHIPPER);
		userNew.setPassword(new  Md5PasswordEncoder().encodePassword(userNew.getUserName(),userNew.getUserName()));
		userNew.setMainUserId(loginBean.getTheMainUserOfThisAccount());
		
		
		loginBean.getUserDataFacede().adduser(userNew);
		
		moneybox mB = new moneybox();
		mB.setActive(true);
		mB.setUserId(userNew);
		loginBean.getMoneyBoxDataFacede().addmoneybox(mB);
		addNewshipper.setParentId(loginBean.getTheUserOfThisAccount());
		shipperFacade.addshipper(addNewshipper);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your shipper has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		Constants.sendEmailNewAccount(addNewshipper.getUserId().getFirstName(),addNewshipper.getUserId().getEmail(),addNewshipper.getUserId().getUserName());
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/shipperList.jsf?faces-redirect=true");
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

	private boolean checkValidForUser(shipper addNewshipper2) {
		// TODO Auto-generated method stub
		if(addNewshipper2.getUserId().getCompany().equals("")||addNewshipper2.getUserId().getCompany()==null) {
			return false;
		}
		
		if(addNewshipper2.getUserId().getUserName().equals("")||addNewshipper2.getUserId().getUserName()==null) {
			return false;
		}
		
		if(addNewshipper2.getUserId().getFirstName().equals("")||addNewshipper2.getUserId().getFirstName()==null) {
			return false;
		}
		
		if(addNewshipper2.getUserId().getLastName().equals("")||addNewshipper2.getUserId().getLastName()==null) {
			return false;
		}
		
		if(addNewshipper2.getUserId().getEmail().equals("")||addNewshipper2.getUserId().getEmail()==null) {
			return false;
		}
		
		return true;
	}

	public void cancel() {
		System.out.println("Cancel");
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/shipper/shipperList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData() {

		boolean isValid=checkValidForUser(selectedshipper);
		if(isValid) {
		loginBean.getUserDataFacede().adduser(selectedshipper.getUserId());
		
		shipperFacade.addshipper(selectedshipper);

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

	public shipperAppServiceImpl getshipperFacade() {
		return shipperFacade;
	}

	public void setshipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}

	public List<shipper> getAllshippers() {
		return allshippers;
	}

	public void setAllshippers(List<shipper> allshippers) {
		this.allshippers = allshippers;
	}

	public shipper getSelectedshipper() {
		return selectedshipper;
	}

	public void setSelectedshipper(shipper selectedshipper) {
		this.selectedshipper = selectedshipper;
	}

	public shipper getAddNewshipper() {
		return addNewshipper;
	}

	public void setAddNewshipper(shipper addNewshipper) {
		this.addNewshipper = addNewshipper;
	}

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}

	public carAppServiceImpl getCarFacade() {
		return carFacade;
	}

	public void setCarFacade(carAppServiceImpl carFacade) {
		this.carFacade = carFacade;
	}

	public shipper getShipperForInvoice() {
		return shipperForInvoice;
	}

	public void setShipperForInvoice(shipper shipperForInvoice) {
		this.shipperForInvoice = shipperForInvoice;
	}


	
	
	
	public invoiceAppServiceImpl getInvoiceFacade() {
		return invoiceFacade;
	}

	public void setInvoiceFacade(invoiceAppServiceImpl invoiceFacade) {
		this.invoiceFacade = invoiceFacade;
	}

	public invoiceCarAppServiceImpl getInvoiceCarFacade() {
		return invoiceCarFacade;
	}

	public void setInvoiceCarFacade(invoiceCarAppServiceImpl invoiceCarFacade) {
		this.invoiceCarFacade = invoiceCarFacade;
	}

	public invoice getInvoiceData() {
		return invoiceData;
	}

	public void setInvoiceData(invoice invoiceData) {
		this.invoiceData = invoiceData;
	}

	public List<car> getCarsForthisAccount() {
		return carsForthisAccount;
	}

	public void setCarsForthisAccount(List<car> carsForthisAccount) {
		this.carsForthisAccount = carsForthisAccount;
	}

	public List<car> getCarsForInvoice() {
		return carsForInvoice;
	}

	public void setCarsForInvoice(List<car> carsForInvoice) {
		this.carsForInvoice = carsForInvoice;
	}

	public Integer getSelectedCarIdToBeAddedInInvoice() {
		return selectedCarIdToBeAddedInInvoice;
	}

	public void setSelectedCarIdToBeAddedInInvoice(Integer selectedCarIdToBeAddedInInvoice) {
		this.selectedCarIdToBeAddedInInvoice = selectedCarIdToBeAddedInInvoice;
	}

	public Float getCarFeesInvoice() {
		return carFeesInvoice;
	}

	public void setCarFeesInvoice(Float carFeesInvoice) {
		this.carFeesInvoice = carFeesInvoice;
	}

	public List<invoiceDTO> getAllInvoice() {
		return allInvoice;
	}

	public void setAllInvoice(List<invoiceDTO> allInvoice) {
		this.allInvoice = allInvoice;
	}

	public String getDateLower() {
		return dateLower;
	}

	public void setDateLower(String dateLower) {
		this.dateLower = dateLower;
	}

	public String getDateHigh() {
		return dateHigh;
	}

	public void setDateHigh(String dateHigh) {
		this.dateHigh = dateHigh;
	}

	public float getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(float totalFees) {
		this.totalFees = totalFees;
	}

	

	
	
}
