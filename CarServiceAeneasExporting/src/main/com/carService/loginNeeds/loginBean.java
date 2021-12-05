package main.com.carService.loginNeeds;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.carService.moneyBox.moneybox;
import main.com.carService.moneyBox.moneyboxAppServiceImpl;
import main.com.carService.moneyTransactionDetails.moneybox_transaction_detailsAppServiceImpl;
import main.com.carService.security.AuthenticationService;
import main.com.carService.tools.Constants;


@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6715784400190397743L;
	private boolean isLoggedIn;
	private String userNameOfUserLoggedIn;
	private String passwordOfUserLoggedIn;
	private String passwordConfirm;
	private boolean passwordRequestChange = false;
	private user theUserOfThisAccount;
	private int type;
	

	private Map<String, String> countrys;
	private Map<String, String> states;
	@ManagedProperty(value = "#{userFacadeImpl}")
	private userAppServiceImpl userDataFacede; 
	
	

	@ManagedProperty(value = "#{moneyboxFacadeImpl}")
	private moneyboxAppServiceImpl moneyBoxDataFacede; 
	
	@ManagedProperty(value = "#{moneybox_transaction_detailsFacadeImpl}")
	private moneybox_transaction_detailsAppServiceImpl moneybox_transaction_detailsDataFacede; 
	 

	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;
	
	private user theMainUserOfThisAccount;
	private moneybox thisAccountMoneyBox;

	private List<moneybox> listOfAllUsersMoneyBox;
	private List<moneybox> selectedlistOfAllUsersMoneyBox;
	
	@PostConstruct
	public void init() {
		isLoggedIn=false;
		theUserOfThisAccount=new user();
		theMainUserOfThisAccount=new user();
		
		

		countrys=new LinkedHashMap<String,String>();
		states=new LinkedHashMap<String,String>();
		fillCountrys();
		fillStates();
		
	}
	
	
	public void resetPassword() {
		
	    user userForget = userDataFacede.getByUserName(userNameOfUserLoggedIn);
	    if(userForget==null) {
		    PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Check this ',\r\n" + 
					"			text: 'No user registered with this Username!',\r\n" + 
					"			left:\"2%\"\r\n" + 
					"		});");
	    }else {

	    	final String uuid = UUID.randomUUID().toString().replace("-", "");
	    	passwordConfirm = RandomStringUtils.random( 15, uuid );
		     
		     System.out.println(passwordConfirm);
		     passwordRequestChange = true;
		     
		     Constants.sendEmailForgetAccount(userForget.getUserName(), userForget.getEmail(), passwordConfirm);
		     
		     PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Success',\r\n" + 
						"			text: 'Mail Sent with your new password.',\r\n" + 
						"			type: 'success'\r\n" + 
						"		});");

	    }
	}
	public void refreshTheDataMain() {

		listOfAllUsersMoneyBox = moneyBoxDataFacede.getAll();
	}
	
	public void refresh(){
		
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("id")[0]);
				if(id!=null){
					user user=userDataFacede.getById(id);
					user.setActive(true);
					userDataFacede.adduser(user);
					
				}
			}
		catch(Exception ex){
			 
		}
	}
	
	public String logOut(){

		userNameOfUserLoggedIn="";
		passwordOfUserLoggedIn="";
		authenticationService.logout();
		theUserOfThisAccount=new user();
		isLoggedIn=false;
		System.out.println("");
		return "/pages/public/index.jsf?faces-redirect=true";
	}
	public void login(){

		if(passwordRequestChange) {
			
			 String hashedPassword= new  Md5PasswordEncoder().encodePassword(passwordConfirm,userNameOfUserLoggedIn);

				theUserOfThisAccount = userDataFacede.getByUserName(userNameOfUserLoggedIn);
				theUserOfThisAccount.setPassword(hashedPassword);
				userDataFacede.adduser(theUserOfThisAccount);
		}
		
		passwordRequestChange = false;
		 String hashedPassword= new  Md5PasswordEncoder().encodePassword(passwordOfUserLoggedIn,userNameOfUserLoggedIn);

		theUserOfThisAccount = userDataFacede.getByUserNameAndPassword(userNameOfUserLoggedIn,hashedPassword);

		if(theUserOfThisAccount!=null){
			isLoggedIn=true;
			
		}else{
			isLoggedIn=false;
			theUserOfThisAccount=new user();
			wrongPassword();
		}
		if(isLoggedIn){
			

			
						boolean success = authenticationService.autoLogin(theUserOfThisAccount.getUserName(), passwordOfUserLoggedIn);
						if (success) {

								FacesContext.getCurrentInstance().getExternalContext()
											.getSessionMap().put("resetMenu", true);
									

			try {
					theMainUserOfThisAccount = userDataFacede.getById(theUserOfThisAccount.getMainUserId().getId());
					thisAccountMoneyBox = moneyBoxDataFacede.getByUserId(theMainUserOfThisAccount.getId());
					FacesContext.getCurrentInstance()
					   .getExternalContext().redirect("/pages/secured/userData/vehicleList.jsf?faces-redirect=true");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							}
		}else{
			

			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("FormMain");
		}
		
	}
	
	
	
	

public void updateDataOfUser() {
		
	// TODO Auto-generated method stub
			boolean ok=false;

				
			if(passwordOfUserLoggedIn.equals(passwordConfirm)&&!passwordOfUserLoggedIn.equals("")&&passwordOfUserLoggedIn!=null){
				ok=true;
			}
			
			
			if(ok){
				
					theUserOfThisAccount.setPassword(new  Md5PasswordEncoder().encodePassword(passwordOfUserLoggedIn,theUserOfThisAccount.getUserName()));
					userDataFacede.adduser(theUserOfThisAccount);
					PrimeFaces.current().executeScript("new PNotify({\r\n" + 
							"			title: 'Success',\r\n" + 
							"			text: 'Your data has been changed.',\r\n" + 
							"			type: 'success'\r\n" + 
							"		});");
				
				
			}else{
				PrimeFaces.current().executeScript("new PNotify({\r\n" + 
						"			title: 'Check this ',\r\n" + 
						"			text: 'Please Make sure that the Passwords are the same and not empty!',\r\n" + 
						"			left:\"2%\"\r\n" + 
						"		});");
				
				
			}
	}
	
public void onRowEdit(RowEditEvent event) {
	 

    moneybox mNew= ((moneybox) event.getObject());
    
    moneyBoxDataFacede.addmoneybox(mNew);
    PrimeFaces.current().executeScript("new PNotify({\r\n" + 
			"			title: 'Success',\r\n" + 
			"			text: 'Your data has been saved.',\r\n" + 
			"			type: 'success'\r\n" + 
			"		});");
   
 
}
	
   
	public void wrongPassword(){
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'wrong Credentials!',\r\n" + 
				"			text: 'Please try Again!',\r\n" + 
				"			type: 'error',\r\n" + 
				"			left:\"1%\"\r\n" + 
				"		});");
		
	
	}
	
	
	
	
	
	

	
	public String getTheStatueOfLoginMenu(){
		if(isLoggedIn){
			return "inherit";
		}
		return "none";
	}
	
	
	
	
	
	public String getTheStatueMenuMain(){
		if(isLoggedIn){
			return "none";
		}
		return "block";
	}

	public String getCountrysValue(String i) {
		String value=countrys.get(i);
		
		return value;
		
	}
	
	public String getStatesValue(String i) {
		String value=states.get(i);
		
		return value;
		
	}

	/*
	 * the start of getting and setting method
	 */
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	

	public String getPasswordOfUserLoggedIn() {
		return passwordOfUserLoggedIn;
	}

	public void setPasswordOfUserLoggedIn(String passwordOfUserLoggedIn) {
		this.passwordOfUserLoggedIn = passwordOfUserLoggedIn;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public user getTheUserOfThisAccount() {
		return theUserOfThisAccount;
	}

	public void setTheUserOfThisAccount(user theUserOfThisAccount) {
		this.theUserOfThisAccount = theUserOfThisAccount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	
	public boolean isPasswordRequestChange() {
		return passwordRequestChange;
	}


	public void setPasswordRequestChange(boolean passwordRequestChange) {
		this.passwordRequestChange = passwordRequestChange;
	}


	public userAppServiceImpl getUserDataFacede() {
		return userDataFacede;
	}

	public void setUserDataFacede(userAppServiceImpl userDataFacede) {
		this.userDataFacede = userDataFacede;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserNameOfUserLoggedIn() {
		return userNameOfUserLoggedIn;
	}

	public void setUserNameOfUserLoggedIn(String userNameOfUserLoggedIn) {
		this.userNameOfUserLoggedIn = userNameOfUserLoggedIn;
	}

	public user getTheMainUserOfThisAccount() {
		return theMainUserOfThisAccount;
	}

	public void setTheMainUserOfThisAccount(user theMainUserOfThisAccount) {
		this.theMainUserOfThisAccount = theMainUserOfThisAccount;
	}
	
	
	



public List<moneybox> getListOfAllUsersMoneyBox() {
		return listOfAllUsersMoneyBox;
	}

	public void setListOfAllUsersMoneyBox(List<moneybox> listOfAllUsersMoneyBox) {
		this.listOfAllUsersMoneyBox = listOfAllUsersMoneyBox;
	}

public moneyboxAppServiceImpl getMoneyBoxDataFacede() {
		return moneyBoxDataFacede;
	}

	public void setMoneyBoxDataFacede(moneyboxAppServiceImpl moneyBoxDataFacede) {
		this.moneyBoxDataFacede = moneyBoxDataFacede;
	}

	public moneybox_transaction_detailsAppServiceImpl getMoneybox_transaction_detailsDataFacede() {
		return moneybox_transaction_detailsDataFacede;
	}

	public void setMoneybox_transaction_detailsDataFacede(
			moneybox_transaction_detailsAppServiceImpl moneybox_transaction_detailsDataFacede) {
		this.moneybox_transaction_detailsDataFacede = moneybox_transaction_detailsDataFacede;
	}

public Map<String, String> getCountrys() {
		return countrys;
	}




	public void setCountrys(Map<String, String> countrys) {
		this.countrys = countrys;
	}





public Map<String, String> getStates() {
		return states;
	}



	public void setStates(Map<String, String> states) {
		this.states = states;
	}



	
	


public List<moneybox> getSelectedlistOfAllUsersMoneyBox() {
		return selectedlistOfAllUsersMoneyBox;
	}

	public void setSelectedlistOfAllUsersMoneyBox(List<moneybox> selectedlistOfAllUsersMoneyBox) {
		this.selectedlistOfAllUsersMoneyBox = selectedlistOfAllUsersMoneyBox;
	}

public moneybox getThisAccountMoneyBox() {
		return thisAccountMoneyBox;
	}

	public void setThisAccountMoneyBox(moneybox thisAccountMoneyBox) {
		this.thisAccountMoneyBox = thisAccountMoneyBox;
	}

private void fillStates() {
	// TODO Auto-generated method stub
	states.put("AL","Alabama");
	states.put("AK","Alaska");
	states.put("AZ","Arizona");
	states.put("AR","Arkansas");
	states.put("CA","California");
	states.put("CO","Colorado");
	states.put("CT","Connecticut");
	states.put("DE","Delaware");
	states.put("DC","District Of Columbia");
	states.put("FL","Florida");
	states.put("GA","Georgia");
	states.put("HI","Hawaii");
	states.put("ID","Idaho");
	states.put("IL","Illinois");
	states.put("IN","Indiana");
	states.put("IA","Iowa");
	states.put("KS","Kansas");
	states.put("KY","Kentucky");
	states.put("LA","Louisiana");
	states.put("ME","Maine");
	states.put("MD","Maryland");
	states.put("MA","Massachusetts");
	states.put("MI","Michigan");
	states.put("MN","Minnesota");
	states.put("MS","Mississippi");
	states.put("MO","Missouri");
	states.put("MT","Montana");
	states.put("NE","Nebraska");
	states.put("NV","Nevada");
	states.put("NH","New Hampshire");
	states.put("NJ","New Jersey");
	states.put("NM","New Mexico");
	states.put("NY","New York");
	states.put("NC","North Carolina");
	states.put("ND","North Dakota");
	states.put("OH","Ohio");
	states.put("OK","Oklahoma");
	states.put("OR","Oregon");
	states.put("PA","Pennsylvania");
	states.put("RI","Rhode Island");
	states.put("SC","South Carolina");
	states.put("SD","South Dakota");
	states.put("TN","Tennessee");
	states.put("TX","Texas");
	states.put("UT","Utah");
	states.put("VT","Vermont");
	states.put("VA","Virginia");
	states.put("WA","Washington");
	states.put("WV","West Virginia");
	states.put("WI","Wisconsin");
	states.put("WY","Wyoming");
	states.put("AS","American Samoa");
	states.put("GU","Guam");
	states.put("MP","Northern Mariana Islands");
	states.put("PR","Puerto Rico");
	states.put("UM","United States Minor Outlying Islands");
	states.put("VI","Virgin Islands");
}



private void fillCountrys() {
	countrys.put("AF","Afghanistan");
	countrys.put("AX","Åland Islands");
	countrys.put("AL","Albania");
	countrys.put("DZ","Algeria");
	countrys.put("AS","American Samoa");
	countrys.put("AD","Andorra");
	countrys.put("AO","Angola");
	countrys.put("AI","Anguilla");
	countrys.put("AQ","Antarctica");
	countrys.put("AG","Antigua and Barbuda");
	countrys.put("AR","Argentina");
	countrys.put("AM","Armenia");
	countrys.put("AW","Aruba");
	countrys.put("AU","Australia");
	countrys.put("AT","Austria");
	countrys.put("AZ","Azerbaijan");
	countrys.put("BS","Bahamas");
	countrys.put("BH","Bahrain");
	countrys.put("BD","Bangladesh");
	countrys.put("BB","Barbados");
	countrys.put("BY","Belarus");
	countrys.put("BE","Belgium");
	countrys.put("BZ","Belize");
	countrys.put("BJ","Benin");
	countrys.put("BM","Bermuda");
	countrys.put("BT","Bhutan");
	countrys.put("BO","Bolivia, Plurinational State of");
	countrys.put("BQ","Bonaire, Sint Eustatius and Saba");
	countrys.put("BA","Bosnia and Herzegovina");
	countrys.put("BW","Botswana");
	countrys.put("BV","Bouvet Island");
	countrys.put("BR","Brazil");
	countrys.put("IO","British Indian Ocean Territory");
	countrys.put("BN","Brunei Darussalam");
	countrys.put("BG","Bulgaria");
	countrys.put("BF","Burkina Faso");
	countrys.put("BI","Burundi");
	countrys.put("KH","Cambodia");
	countrys.put("CM","Cameroon");
	countrys.put("CA","Canada");
	countrys.put("CV","Cape Verde");
	countrys.put("KY","Cayman Islands");
	countrys.put("CF","Central African Republic");
	countrys.put("TD","Chad");
	countrys.put("CL","Chile");
	countrys.put("CN","China");
	countrys.put("CX","Christmas Island");
	countrys.put("CC","Cocos (Keeling) Islands");
	countrys.put("CO","Colombia");
	countrys.put("KM","Comoros");
	countrys.put("CG","Congo");
	countrys.put("CD","Congo, the Democratic Republic of the");
	countrys.put("CK","Cook Islands");
	countrys.put("CR","Costa Rica");
	countrys.put("CI","Côte d'Ivoire");
	countrys.put("HR","Croatia");
	countrys.put("CU","Cuba");
	countrys.put("CW","Curaçao");
	countrys.put("CY","Cyprus");
	countrys.put("CZ","Czech Republic");
	countrys.put("DK","Denmark");
	countrys.put("DJ","Djibouti");
	countrys.put("DM","Dominica");
	countrys.put("DO","Dominican Republic");
	countrys.put("EC","Ecuador");
	countrys.put("EG","Egypt");
	countrys.put("SV","El Salvador");
	countrys.put("GQ","Equatorial Guinea");
	countrys.put("ER","Eritrea");
	countrys.put("EE","Estonia");
	countrys.put("ET","Ethiopia");
	countrys.put("FK","Falkland Islands (Malvinas)");
	countrys.put("FO","Faroe Islands");
	countrys.put("FJ","Fiji");
	countrys.put("FI","Finland");
	countrys.put("FR","France");
	countrys.put("GF","French Guiana");
	countrys.put("PF","French Polynesia");
	countrys.put("TF","French Southern Territories");
	countrys.put("GA","Gabon");
	countrys.put("GM","Gambia");
	countrys.put("GE","Georgia");
	countrys.put("DE","Germany");
	countrys.put("GH","Ghana");
	countrys.put("GI","Gibraltar");
	countrys.put("GR","Greece");
	countrys.put("GL","Greenland");
	countrys.put("GD","Grenada");
	countrys.put("GP","Guadeloupe");
	countrys.put("GU","Guam");
	countrys.put("GT","Guatemala");
	countrys.put("GG","Guernsey");
	countrys.put("GN","Guinea");
	countrys.put("GW","Guinea-Bissau");
	countrys.put("GY","Guyana");
	countrys.put("HT","Haiti");
	countrys.put("HM","Heard Island and McDonald Islands");
	countrys.put("VA","Holy See (Vatican City State)");
	countrys.put("HN","Honduras");
	countrys.put("HK","Hong Kong");
	countrys.put("HU","Hungary");
	countrys.put("IS","Iceland");
	countrys.put("IN","India");
	countrys.put("ID","Indonesia");
	countrys.put("IR","Iran, Islamic Republic of");
	countrys.put("IQ","Iraq");
	countrys.put("IE","Ireland");
	countrys.put("IM","Isle of Man");
	countrys.put("IL","Israel");
	countrys.put("IT","Italy");
	countrys.put("JM","Jamaica");
	countrys.put("JP","Japan");
	countrys.put("JE","Jersey");
	countrys.put("JO","Jordan");
	countrys.put("KZ","Kazakhstan");
	countrys.put("KE","Kenya");
	countrys.put("KI","Kiribati");
	countrys.put("KP","Korea, Democratic People's Republic of");
	countrys.put("KR","Korea, Republic of");
	countrys.put("KW","Kuwait");
	countrys.put("KG","Kyrgyzstan");
	countrys.put("LA","Lao People's Democratic Republic");
	countrys.put("LV","Latvia");
	countrys.put("LB","Lebanon");
	countrys.put("LS","Lesotho");
	countrys.put("LR","Liberia");
	countrys.put("LY","Libya");
	countrys.put("LI","Liechtenstein");
	countrys.put("LT","Lithuania");
	countrys.put("LU","Luxembourg");
	countrys.put("MO","Macao");
	countrys.put("MK","Macedonia, the former Yugoslav Republic of");
	countrys.put("MG","Madagascar");
	countrys.put("MW","Malawi");
	countrys.put("MY","Malaysia");
	countrys.put("MV","Maldives");
	countrys.put("ML","Mali");
	countrys.put("MT","Malta");
	countrys.put("MH","Marshall Islands");
	countrys.put("MQ","Martinique");
	countrys.put("MR","Mauritania");
	countrys.put("MU","Mauritius");
	countrys.put("YT","Mayotte");
	countrys.put("MX","Mexico");
	countrys.put("FM","Micronesia, Federated States of");
	countrys.put("MD","Moldova, Republic of");
	countrys.put("MC","Monaco");
	countrys.put("MN","Mongolia");
	countrys.put("ME","Montenegro");
	countrys.put("MS","Montserrat");
	countrys.put("MA","Morocco");
	countrys.put("MZ","Mozambique");
	countrys.put("MM","Myanmar");
	countrys.put("NA","Namibia");
	countrys.put("NR","Nauru");
	countrys.put("NP","Nepal");
	countrys.put("NL","Netherlands");
	countrys.put("NC","New Caledonia");
	countrys.put("NZ","New Zealand");
	countrys.put("NI","Nicaragua");
	countrys.put("NE","Niger");
	countrys.put("NG","Nigeria");
	countrys.put("NU","Niue");
	countrys.put("NF","Norfolk Island");
	countrys.put("MP","Northern Mariana Islands");
	countrys.put("NO","Norway");
	countrys.put("OM","Oman");
	countrys.put("PK","Pakistan");
	countrys.put("PW","Palau");
	countrys.put("PS","Palestinian Territory, Occupied");
	countrys.put("PA","Panama");
	countrys.put("PG","Papua New Guinea");
	countrys.put("PY","Paraguay");
	countrys.put("PE","Peru");
	countrys.put("PH","Philippines");
	countrys.put("PN","Pitcairn");
	countrys.put("PL","Poland");
	countrys.put("PT","Portugal");
	countrys.put("PR","Puerto Rico");
	countrys.put("QA","Qatar");
	countrys.put("RE","Réunion");
	countrys.put("RO","Romania");
	countrys.put("RU","Russian Federation");
	countrys.put("RW","Rwanda");
	countrys.put("BL","Saint Barthélemy");
	countrys.put("SH","Saint Helena, Ascension and Tristan da Cunha");
	countrys.put("KN","Saint Kitts and Nevis");
	countrys.put("LC","Saint Lucia");
	countrys.put("MF","Saint Martin (French part)");
	countrys.put("PM","Saint Pierre and Miquelon");
	countrys.put("VC","Saint Vincent and the Grenadines");
	countrys.put("WS","Samoa");
	countrys.put("SM","San Marino");
	countrys.put("ST","Sao Tome and Principe");
	countrys.put("SA","Saudi Arabia");
	countrys.put("SN","Senegal");
	countrys.put("RS","Serbia");
	countrys.put("SC","Seychelles");
	countrys.put("SL","Sierra Leone");
	countrys.put("SG","Singapore");
	countrys.put("SX","Sint Maarten (Dutch part)");
	countrys.put("SK","Slovakia");
	countrys.put("SI","Slovenia");
	countrys.put("SB","Solomon Islands");
	countrys.put("SO","Somalia");
	countrys.put("ZA","South Africa");
	countrys.put("GS","South Georgia and the South Sandwich Islands");
	countrys.put("SS","South Sudan");
	countrys.put("ES","Spain");
	countrys.put("LK","Sri Lanka");
	countrys.put("SD","Sudan");
	countrys.put("SR","Suriname");
	countrys.put("SJ","Svalbard and Jan Mayen");
	countrys.put("SZ","Swaziland");
	countrys.put("SE","Sweden");
	countrys.put("CH","Switzerland");
	countrys.put("SY","Syrian Arab Republic");
	countrys.put("TW","Taiwan, Province of China");
	countrys.put("TJ","Tajikistan");
	countrys.put("TZ","Tanzania, United Republic of");
	countrys.put("TH","Thailand");
	countrys.put("TL","Timor-Leste");
	countrys.put("TG","Togo");
	countrys.put("TK","Tokelau");
	countrys.put("TO","Tonga");
	countrys.put("TT","Trinidad and Tobago");
	countrys.put("TN","Tunisia");
	countrys.put("TR","Turkey");
	countrys.put("TM","Turkmenistan");
	countrys.put("TC","Turks and Caicos Islands");
	countrys.put("TV","Tuvalu");
	countrys.put("UG","Uganda");
	countrys.put("UA","Ukraine");
	countrys.put("AE","United Arab Emirates");
	countrys.put("GB","United Kingdom");
	countrys.put("US","United States");
	countrys.put("UM","United States Minor Outlying Islands");
	countrys.put("UY","Uruguay");
	countrys.put("UZ","Uzbekistan");
	countrys.put("VU","Vanuatu");
	countrys.put("VE","Venezuela, Bolivarian Republic of");
	countrys.put("VN","Viet Nam");
	countrys.put("VG","Virgin Islands, British");
	countrys.put("VI","Virgin Islands, U.S.");
	countrys.put("WF","Wallis and Futuna");
	countrys.put("EH","Western Sahara");
	countrys.put("YE","Yemen");
	countrys.put("ZM","Zambia");
	countrys.put("ZW","Zimbabwe");


}
	
}
