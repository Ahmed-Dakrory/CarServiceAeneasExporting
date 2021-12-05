package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.PrimeFaces;



@ManagedBean(name = "formsBean")
@RequestScoped
public class formsBean  implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440239977354416L;

	private int numberType = 0;
	private int number_of_vehicles = 0;

	private List<String> vehicleYears =new ArrayList<String>();
	private List<String> vehicleModel =new ArrayList<String>();
	private List<String> vehicleMake =new ArrayList<String>();
	private List<String> vehicleVin =new ArrayList<String>();
	private List<String> vehicleValue =new ArrayList<String>();
	private List<Boolean> vehicleInsurance =new ArrayList<Boolean>();
	private List<Boolean> vehicleAdditionalPickUp =new ArrayList<Boolean>();
	private List<Integer> vehicles = new ArrayList<Integer>();


	private String contactName = "";
	private String contactMail = "";
	private String contactPhone = "";
	private String contactMessage = "";
	
	private boolean aggreement = false; 
	private String harmLess="";
	private String destPort="";

	//SHIPPER
	private int citizenType = 0;
	private String einNumber="";
	private String passportId="";
	private String shipperCompanyName="";
	private String shipperFirstName="";
	private String shipperLastName="";
	private String shipperAddress1="";
	private String shipperAddress2="";
	private String shipperCity="";
	private String shipperState="";
	private String shipperProvince="";
	private String shipperCountry="";
	private String shipperZip="";
	private String shipperMail="";
	private String shipperPhone="";
	
	
	//CONSIGNEE
	private String consigneeFirstName="";
	private String consigneeLastName="";
	private String consigneeAddress1="";
	private String consigneeAddress2="";
	private String consigneeCity="";
	private String consigneeState="";
	private String consigneeProvince="";
	private String consigneeCountry="";
	private String consigneeZip="";
	private String consigneePhone="";
	
	//Title
	private String titleSelect="Local Pick Up - Free";
	private String titleMailTo="";
	private String titleFirstName="";
	private String titleLastName="";
	private String titleAddress1="";
	private String titleAddress2="";
	private String titleCity="";
	private String titleState="";
	private String titleProvince="";
	private String titleCountry="";
	private String titleZip="";
	private String titlePhone="";
	
	
	//AGENT
	private String agentSelect="own";
	private String agentFirstName="";
	private String agentLastName="";
	private String agentAddress1="";
	private String agentAddress2="";
	private String agentCity="";
	private String agentState="";
	private String agentProvince="";
	private String agentCountry="";
	private String agentZip="";
	private String agentPhone="";
	
	
	
	
	
	private String comments="";
	@PostConstruct
	public void init() {
		refresh();
	}

	public void refresh() {
		

		contactName = "";
		contactMail = "";
		contactPhone = "";
		contactMessage = "";
		vehicleYears =new ArrayList<String>();
		vehicleModel =new ArrayList<String>();
		vehicleMake =new ArrayList<String>();
		vehicleVin =new ArrayList<String>();
		vehicleValue =new ArrayList<String>();
		vehicleInsurance =new ArrayList<Boolean>();
		vehicleAdditionalPickUp =new ArrayList<Boolean>();
		vehicles = new ArrayList<Integer>();
		for(int i=0;i<6;i++) {
			vehicleYears.add("2021");
			vehicleModel.add("");
			vehicleMake.add("");
			vehicleVin.add("");
			vehicleValue.add("");
			vehicleInsurance.add(false);
			vehicleAdditionalPickUp.add(false);
			vehicles.add(i+1);
		}
		

		numberType = 0;
		number_of_vehicles = 0;


		
		aggreement = false; 
		harmLess="";
		destPort="";

		//SHIPPER
		citizenType = 0;
		einNumber="";
		passportId="";
		shipperCompanyName="";
		shipperFirstName="";
		shipperLastName="";
		shipperAddress1="";
		shipperAddress2="";
		shipperCity="";
		shipperState="";
		shipperProvince="";
		shipperCountry="";
		shipperZip="";
		shipperMail="";
		shipperPhone="";
		
		
		//CONSIGNEE
		consigneeFirstName="";
		consigneeLastName="";
		consigneeAddress1="";
		consigneeAddress2="";
		consigneeCity="";
		consigneeState="";
		consigneeProvince="";
		consigneeCountry="";
		consigneeZip="";
		consigneePhone="";
		
		//Title
		titleSelect="Local Pick Up - Free";
		titleMailTo="";
		titleFirstName="";
		titleLastName="";
		titleAddress1="";
		titleAddress2="";
		titleCity="";
		titleState="";
		titleProvince="";
		titleCountry="";
		titleZip="";
		titlePhone="";
		
		
		//AGENT
		agentSelect="own";
		agentFirstName="";
		agentLastName="";
		agentAddress1="";
		agentAddress2="";
		agentCity="";
		agentState="";
		agentProvince="";
		agentCountry="";
		agentZip="";
		agentPhone="";
		
		
		
		
		
		comments="";
		aggreement = false;
	}

	
	public void mail_the_data() {
		System.out.println(vehicleYears.get(0));
		sendEmailNotificationForThisEmailWithMessage();
		   PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Success',\r\n" + 
					"			text: 'Mail has been sent.',\r\n" + 
					"			type: 'success'\r\n" + 
					"		});");
		   try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/public/application_form.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		   
	}
	
	
	
	public void mail_Contact() {
		System.out.println(vehicleYears.get(0));
		sendEmailNotificationForThisEmailWithMessageContact();
		   PrimeFaces.current().executeScript("new PNotify({\r\n" + 
					"			title: 'Success',\r\n" + 
					"			text: 'Mail has been sent.',\r\n" + 
					"			type: 'success'\r\n" + 
					"		});");
		   try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/public/contactUs.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		   
	}
	
	public void sendEmailNotificationForThisEmailWithMessage() {
		String[] to = {"support@AeneasExportingllc.com" }; // list of recipient email addresses 

//		String[] to = {"ahmedsonic1993@gmail.com" }; // list of recipient email addresses 
        String subject = "Form Message ";
        String htmlText = getMessageforEmailWithMessage();

        System.out.println("Email Sent To: ");
        sendFromGMail( to, subject, htmlText);
        

}
	
	
	public void sendEmailNotificationForThisEmailWithMessageContact() {
		
		String[] to = {"support@AeneasExportingllc.com" }; // list of recipient email addresses 
//		String[] to = {"ahmedsonic1993@gmail.com" }; // list of recipient email addresses 
        String subject = "Message From the website ";
        String htmlText = getMessageforEmailWithMessageContact();

        System.out.println("Email Sent To: ");
        sendFromGMail( to, subject, htmlText);
        

}
	
	public String getMessageforEmailWithMessageContact() {
		
		return "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
				"    <meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">  <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
				"\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : BEGIN -->\r\n" + 
				" <!-- CSS Reset : BEGIN -->\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"#headerCarOld::after{\r\n" + 
				"	position: absolute;	left: 0;	right: 0;	bottom: -10px;	content: '';	width: 100%;	height: 2px;	background: #ff8b00;	margin: 0 auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa; margin: 0 auto !important;    padding: 0 !important;    height: 100% !important;    width: 100% !important;    background: #f1f1f1;\">\r\n" + 
				"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
				"    <div style=\"max-width: 79%; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"    	<!-- BEGIN BODY -->\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
				"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
				"          		<tbody><tr>\r\n" + 
				"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
				"			            <h1 style=\"margin: 0;\"><a href=\"http://AeneasExportingllc.com/\" style=\"color: #3c64f5;	font-size: 20px;	font-weight: 700;	font-family: 'Work Sans', sans-serif;\">Aeneas Exporting</a></h1>\r\n" + 
				"			          </td>\r\n" + 
				"          		</tr>\r\n" + 
				"          	</tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td valign=\"middle\" class=\"hero bg_white\" style=\"position: relative;	z-index: 0;background-image: url(http://adainter.com/resources/images/public/img/emailBack.jpg);background-size: cover;height: 263px;\">\r\n" + 
				"          	<div class=\"overlay\" style=\"position: absolute;	top: 0;	left: 0;	right: 0;	bottom: 0;	content: '';	width: 100%;	background: #000000;	z-index: -1;	opacity: .2;\"></div>\r\n" + 
				"            <table style=\"width: 100%;\">\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"            		<td>\r\n" + 
				"            			<div class=\"text\" style=\"padding: 0 1em; text-align: center;\">\r\n" + 
				"							<div class=\"mainContainer\">\r\n" + 
				"						\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Message Data</span>\r\n" + 
				"									</div>\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+contactName+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Mail :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+contactMail+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Phone:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+contactPhone+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Message</span><br>\r\n" + 
				"										\r\n" + 
				"										"+contactMessage+"\r\n" + 
				"									</div>\r\n" + 
				"									\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"							\r\n" + 
				"									\r\n" + 
				"							</div>\r\n" + 
				"            				\r\n" + 
				"            				\r\n" + 
				"            			</div>\r\n" + 
				"            		</td>\r\n" + 
				"            	</tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td class=\"bg_dark email-section\" style=\"text-align:center;background: rgba(0,0,0,.8);padding:2.5em;\">\r\n" + 
				"          	<div class=\"heading-section heading-section-white\" >\r\n" + 
				"          		<span class=\"subheading\" id=\"headerCarOld\" style=\"margin-bottom: 20px !important;	display: inline-block;	font-size: 13px;	text-transform: uppercase;	letter-spacing: 2px;	color: rgba(0,0,0,.4);	position: relative;margin-bottom: 0;	display: inline-block;	font-size: 13px;	text-transform: uppercase;	letter-spacing: 2px;	color: rgba(255,255,255,.4);\">Welcome</span>\r\n" + 
				"            	\r\n" + 
				"				<h2 style=\"color: #ffffff;\">Aeneas Exporting LLC®</h2>\r\n" + 
				"            	\r\n" + 
				"          	</div>\r\n" + 
				"          </td>\r\n" + 
				"        </tr><!-- end: tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"        <!-- end tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"				<!-- end: tr -->\r\n" + 
				"      <!-- 1 Column Text + Button : END -->\r\n" + 
				"      </tbody></table>\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;width: 100%;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"middle\" class=\"bg_light footer email-section\" style=\"padding:2.5em;\">\r\n" + 
				"            <table style=\"width: 100%;\">\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
				"                      	<h3 class=\"heading\">About</h3>\r\n" + 
				"                      	<p style=\"margin-top: 0;\">Aeneas Exporting LLC®</p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody></table>\r\n" + 
				"                </td>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-left: 5px; padding-right: 5px;\">\r\n" + 
				"                      	<h3 class=\"heading\">Contact Info</h3>\r\n" + 
				"                      	<ul>\r\n" + 
				"					                <li><span class=\"text\">9100 Galveston Rd Suite# 5, Houston, TX 77034, United States</span></li>\r\n" + 
				"					                <li><span class=\"text\"> +1 (832)-500-7007</span></li>\r\n" + 
				"					              </ul>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody></table>\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"        </tr><!-- end: tr -->\r\n" + 
				"        \r\n" + 
				"      </tbody></table>\r\n" + 
				"\r\n" + 
				"    </div>\r\n" + 
				"  </center>\r\n" + 
				"\r\n" + 
				"</body></html>";
		
		
	}
	
	
	
	public String getMessageforEmailWithMessage() {
		String allCars="";
		if(numberType==0) {
			String yesNoInsurance = "";
			if(vehicleInsurance.get(0)) {
				yesNoInsurance="Yes";
			}else {
				yesNoInsurance="No";
			}
			String yesNoAdditionalPick = "";
			if(vehicleAdditionalPickUp.get(0)) {
				yesNoAdditionalPick="Yes";
			}else {
				yesNoAdditionalPick="No";
			}
			allCars += 				"								  <tr style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">\r\n" + 
					"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+vehicleYears.get(0)+" "+vehicleMake.get(0)+" "+vehicleModel.get(0)+"</td>\r\n" + 
					"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\" colspan=\"2\">"+vehicleVin.get(0)+"</td>\r\n" + 
					"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+vehicleValue.get(0)+"</td>\r\n" + 
					"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+yesNoInsurance+"</td>\r\n" + 
					"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+yesNoAdditionalPick+"</td>\r\n" + 
					"								  </tr>\r\n" ;
		}else {
			for(int i=0;i<number_of_vehicles;i++) {
				String yesNoInsurance = "";
				if(vehicleInsurance.get(i)) {
					yesNoInsurance="Yes";
				}else {
					yesNoInsurance="No";
				}
				String yesNoAdditionalPick = "";
				if(vehicleAdditionalPickUp.get(i)) {
					yesNoAdditionalPick="Yes";
				}else {
					yesNoAdditionalPick="No";
				}
				allCars += 				"								  <tr style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">\r\n" + 
						"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+vehicleYears.get(i)+" "+vehicleMake.get(i)+" "+vehicleModel.get(i)+"</td>\r\n" + 
						"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\" colspan=\"2\">"+vehicleVin.get(i)+"</td>\r\n" + 
						"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+vehicleValue.get(i)+"</td>\r\n" + 
						"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+yesNoInsurance+"</td>\r\n" + 
						"									<td style=\" border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">"+yesNoAdditionalPick+"</td>\r\n" + 
						"								  </tr>\r\n" ;
			}
		}
		String CitizenType="";
		if(citizenType==0) {
			CitizenType="US Citizen\\Business";
		}else {
			CitizenType="Non US citizen";
		}
		return "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
				"    <meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">  <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
				"\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : BEGIN -->\r\n" + 
				" <!-- CSS Reset : BEGIN -->\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"#headerCarOld::after{\r\n" + 
				"	position: absolute;	left: 0;	right: 0;	bottom: -10px;	content: '';	width: 100%;	height: 2px;	background: #ff8b00;	margin: 0 auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa; margin: 0 auto !important;    padding: 0 !important;    height: 100% !important;    width: 100% !important;    background: #f1f1f1;\">\r\n" + 
				"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
				"    <div style=\"max-width: 79%; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"    	<!-- BEGIN BODY -->\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
				"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
				"          		<tbody><tr>\r\n" + 
				"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
				"			            <h1 style=\"margin: 0;\"><a href=\"http://AeneasExportingllc.com/\" style=\"color: #3c64f5;	font-size: 20px;	font-weight: 700;	font-family: 'Work Sans', sans-serif;\">Aeneas Exporting</a></h1>\r\n" + 
				"			          </td>\r\n" + 
				"          		</tr>\r\n" + 
				"          	</tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td valign=\"middle\" class=\"hero bg_white\" style=\"position: relative;	z-index: 0;background-image: url(http://adainter.com/resources/images/public/img/emailBack.jpg);background-size: cover;height: 263px;\">\r\n" + 
				"          	<div class=\"overlay\" style=\"position: absolute;	top: 0;	left: 0;	right: 0;	bottom: 0;	content: '';	width: 100%;	background: #000000;	z-index: -1;	opacity: .2;\"></div>\r\n" + 
				"            <table style=\"width: 100%;\">\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"            		<td>\r\n" + 
				"            			<div class=\"text\" style=\"padding: 0 1em; text-align: center;\">\r\n" + 
				"							<div class=\"mainContainer\">\r\n" + 
				"								<table id=\"carTables\" style=\"width:100%;font-size:15px;border: 1px solid black;  text-align: center;  text-align: center;  table-layout: auto;\">\r\n" + 
					allCars+
				"								</table>\r\n" + 
				"								<div class=\"card\" style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">HOLD HARMLESS FORM:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+harmLess+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">DESTINATION PORT:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+destPort+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Shipper Data:</span>"+CitizenType+"\r\n" + 
				"									</div>\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">EIN Number:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+einNumber+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Passport ID:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+passportId+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">First Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperFirstName+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Last Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperLastName+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Company Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperCompanyName+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">City :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperCity+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 1:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperAddress1+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 2:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperAddress2+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">State (US only):</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperState+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Province:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperProvince+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Country :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperCountry+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">E-mail:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperMail+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Phone :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+shipperPhone+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">CONSIGNEE Data</span>\r\n" + 
				"									</div>\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">First Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeFirstName+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Last Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeLastName+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">City :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeCity+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Phone :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneePhone+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 1:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeAddress1+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 2:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeAddress2+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">State (US only):</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeState+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Province:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeProvince+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Country :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeCountry+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Zip :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+consigneeZip+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">TITLE Method</span> "+titleSelect+"<br>\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Mail to </span> "+titleMailTo+"\r\n" + 
				"									</div>\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">First Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleFirstName+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Last Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleLastName+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">City :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleCity+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Phone :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titlePhone+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 1:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleAddress1+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 2:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleAddress2+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">State (US only):</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleState+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Province:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleProvince+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Country :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleCountry+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Zip :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+titleZip+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">AGENT:</span>"+agentSelect+"\r\n" + 
				"									</div>\r\n" + 
				"									<table style=\"width: 100%;\">\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">First Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentFirstName+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Last Name:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentLastName+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">City :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentCity+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Phone :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentPhone+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 1:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentAddress1+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Address 2:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentAddress2+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">State (US only):</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentState+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Province:</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentProvince+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Country :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentCountry+"</span></td>\r\n" + 
				"											<td><span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">Zip :</span> <span style=\" font-size: small;    color: black;    margin-left: 7%;\">"+agentZip+"</span></td>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"										<tr>\r\n" + 
				"										<tr>\r\n" + 
				"										\r\n" + 
				"									</table>\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<br>\r\n" + 
				"								<div class=\"card\"  style=\"border: 1px solid black;margin:5px;padding:5px;\">\r\n" + 
				"									<div style=\"box-shadow: 2px 2px 15px 8px grey;    width: auto;    margin: 11px;    padding: 7px;    font-size: 14px;    border-radius: 7px;\">\r\n" + 
				"										<span style=\"font-weight: 700;    font-size: small;    color: black;    margin-left: 7%;\">COMMENTS</span><br>\r\n" + 
				"										\r\n" + 
				"										"+comments+"\r\n" + 
				"									</div>\r\n" + 
				"									\r\n" + 
				"									\r\n" + 
				"								</div>\r\n" + 
				"							\r\n" + 
				"									\r\n" + 
				"							</div>\r\n" + 
				"            				\r\n" + 
				"            				\r\n" + 
				"            			</div>\r\n" + 
				"            		</td>\r\n" + 
				"            	</tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td class=\"bg_dark email-section\" style=\"text-align:center;background: rgba(0,0,0,.8);padding:2.5em;\">\r\n" + 
				"          	<div class=\"heading-section heading-section-white\" >\r\n" + 
				"          		<span class=\"subheading\" id=\"headerCarOld\" style=\"margin-bottom: 20px !important;	display: inline-block;	font-size: 13px;	text-transform: uppercase;	letter-spacing: 2px;	color: rgba(0,0,0,.4);	position: relative;margin-bottom: 0;	display: inline-block;	font-size: 13px;	text-transform: uppercase;	letter-spacing: 2px;	color: rgba(255,255,255,.4);\">Welcome</span>\r\n" + 
				"            	\r\n" + 
				"				<h2 style=\"color: #ffffff;\">Aeneas Exporting LLC®</h2>\r\n" + 
				"            	\r\n" + 
				"          	</div>\r\n" + 
				"          </td>\r\n" + 
				"        </tr><!-- end: tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"        <!-- end tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"	      <!-- end: tr -->\r\n" + 
				"				<!-- end: tr -->\r\n" + 
				"      <!-- 1 Column Text + Button : END -->\r\n" + 
				"      </tbody></table>\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;width: 100%;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"middle\" class=\"bg_light footer email-section\" style=\"padding:2.5em;\">\r\n" + 
				"            <table style=\"width: 100%;\">\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
				"                      	<h3 class=\"heading\">About</h3>\r\n" + 
				"                      	<p style=\"margin-top: 0;\">Aeneas Exporting LLC®</p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody></table>\r\n" + 
				"                </td>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-left: 5px; padding-right: 5px;\">\r\n" + 
				"                      	<h3 class=\"heading\">Contact Info</h3>\r\n" + 
				"                      	<ul>\r\n" + 
				"					                <li><span class=\"text\">9100 Galveston Rd Suite# 5, Houston, TX 77034, United States</span></li>\r\n" + 
				"					                <li><span class=\"text\"> +1 (832)-500-7007</span></li>\r\n" + 
				"					              </ul>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody></table>\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"        </tr><!-- end: tr -->\r\n" + 
				"        \r\n" + 
				"      </tbody></table>\r\n" + 
				"\r\n" + 
				"    </div>\r\n" + 
				"  </center>\r\n" + 
				"\r\n" + 
				"</body></html>";
		
		
	}
	
	
	private static void sendFromGMail( final String[] to, final String subject, final String body) {
		 new Thread(new Runnable() {
			
			@Override
			public void run() {

//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println(body);
//				System.out.println();
//				System.out.println();
//				System.out.println();
				String from = "support@AeneasExportingllc.com";
		        String pass = "tqtqwruxkwiqnvgh";
				
				// TODO Auto-generated method stub
				 Properties props = System.getProperties();

			        String host = "smtp.gmail.com";
			        props.put("mail.smtp.starttls.enable", "true");
			        props.put("mail.smtp.host", host);
			        props.put("mail.smtp.user", from);
			        props.put("mail.smtp.password", pass);
			        props.put("mail.smtp.port", "587");
			        props.put("mail.smtp.auth", "true");

			        Session session = Session.getDefaultInstance(props);
			        MimeMessage message = new MimeMessage(session);

			        try {
			            message.setFrom(new InternetAddress(from));
			            InternetAddress[] toAddress = new InternetAddress[to.length];

			            // To get the array of addresses
			            for( int i = 0; i < to.length; i++ ) {
			                toAddress[i] = new InternetAddress(to[i]);
			            }

			            for( int i = 0; i < toAddress.length; i++) {
			                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			            }

			            message.setSubject(subject);
			            message.setText(body);

			    		message.setContent(body, "text/html; charset=ISO-8859-1");
			            Transport transport = session.getTransport("smtp");
			            transport.connect(host, from, pass);
			            transport.sendMessage(message, message.getAllRecipients());
			            transport.close();
			            System.out.println("Done Email Send");
			        }
			        catch (AddressException ae) {
			            ae.printStackTrace();
			            System.out.println("Problem"+ae.toString());
			        }
			        catch (MessagingException me) {
			            me.printStackTrace();
			            System.out.println("Problem"+me.toString());
			        }
			        
			}
		}).start();
	       
	    }
	
	public int getNumberType() {
		return numberType;
	}

	public void setNumberType(int numberType) {
		this.numberType = numberType;
	}

	public int getNumber_of_vehicles() {
		return number_of_vehicles;
	}

	public void setNumber_of_vehicles(int number_of_vehicles) {
		this.number_of_vehicles = number_of_vehicles;
	}

	public List<String> getVehicleYears() {
		return vehicleYears;
	}

	public void setVehicleYears(List<String> vehicleYears) {
		this.vehicleYears = vehicleYears;
	}

	public List<String> getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(List<String> vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public List<String> getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(List<String> vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public List<String> getVehicleVin() {
		return vehicleVin;
	}

	public void setVehicleVin(List<String> vehicleVin) {
		this.vehicleVin = vehicleVin;
	}

	public List<String> getVehicleValue() {
		return vehicleValue;
	}

	public void setVehicleValue(List<String> vehicleValue) {
		this.vehicleValue = vehicleValue;
	}

	public List<Boolean> getVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(List<Boolean> vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	public List<Boolean> getVehicleAdditionalPickUp() {
		return vehicleAdditionalPickUp;
	}

	public void setVehicleAdditionalPickUp(List<Boolean> vehicleAdditionalPickUp) {
		this.vehicleAdditionalPickUp = vehicleAdditionalPickUp;
	}

	public List<Integer> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Integer> vehicles) {
		this.vehicles = vehicles;
	}

	public boolean isAggreement() {
		return aggreement;
	}

	public void setAggreement(boolean aggreement) {
		this.aggreement = aggreement;
	}

	public String getHarmLess() {
		return harmLess;
	}

	public void setHarmLess(String harmLess) {
		this.harmLess = harmLess;
	}

	public String getDestPort() {
		return destPort;
	}

	public void setDestPort(String destPort) {
		this.destPort = destPort;
	}

	public int getCitizenType() {
		return citizenType;
	}

	public void setCitizenType(int citizenType) {
		this.citizenType = citizenType;
	}

	public String getEinNumber() {
		return einNumber;
	}

	public void setEinNumber(String einNumber) {
		this.einNumber = einNumber;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getShipperCompanyName() {
		return shipperCompanyName;
	}

	public void setShipperCompanyName(String shipperCompanyName) {
		this.shipperCompanyName = shipperCompanyName;
	}

	public String getShipperFirstName() {
		return shipperFirstName;
	}

	public void setShipperFirstName(String shipperFirstName) {
		this.shipperFirstName = shipperFirstName;
	}

	public String getShipperLastName() {
		return shipperLastName;
	}

	public void setShipperLastName(String shipperLastName) {
		this.shipperLastName = shipperLastName;
	}

	public String getShipperAddress1() {
		return shipperAddress1;
	}

	public void setShipperAddress1(String shipperAddress1) {
		this.shipperAddress1 = shipperAddress1;
	}

	public String getShipperAddress2() {
		return shipperAddress2;
	}

	public void setShipperAddress2(String shipperAddress2) {
		this.shipperAddress2 = shipperAddress2;
	}

	public String getShipperCity() {
		return shipperCity;
	}

	public void setShipperCity(String shipperCity) {
		this.shipperCity = shipperCity;
	}

	public String getShipperState() {
		return shipperState;
	}

	public void setShipperState(String shipperState) {
		this.shipperState = shipperState;
	}

	public String getShipperProvince() {
		return shipperProvince;
	}

	public void setShipperProvince(String shipperProvince) {
		this.shipperProvince = shipperProvince;
	}

	public String getShipperCountry() {
		return shipperCountry;
	}

	public void setShipperCountry(String shipperCountry) {
		this.shipperCountry = shipperCountry;
	}

	public String getShipperZip() {
		return shipperZip;
	}

	public void setShipperZip(String shipperZip) {
		this.shipperZip = shipperZip;
	}

	public String getShipperMail() {
		return shipperMail;
	}

	public void setShipperMail(String shipperMail) {
		this.shipperMail = shipperMail;
	}

	public String getShipperPhone() {
		return shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public String getConsigneeFirstName() {
		return consigneeFirstName;
	}

	public void setConsigneeFirstName(String consigneeFirstName) {
		this.consigneeFirstName = consigneeFirstName;
	}

	public String getConsigneeLastName() {
		return consigneeLastName;
	}

	public void setConsigneeLastName(String consigneeLastName) {
		this.consigneeLastName = consigneeLastName;
	}

	public String getConsigneeAddress1() {
		return consigneeAddress1;
	}

	public void setConsigneeAddress1(String consigneeAddress1) {
		this.consigneeAddress1 = consigneeAddress1;
	}

	public String getConsigneeAddress2() {
		return consigneeAddress2;
	}

	public void setConsigneeAddress2(String consigneeAddress2) {
		this.consigneeAddress2 = consigneeAddress2;
	}

	public String getConsigneeCity() {
		return consigneeCity;
	}

	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}

	public String getConsigneeState() {
		return consigneeState;
	}

	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}

	public String getConsigneeProvince() {
		return consigneeProvince;
	}

	public void setConsigneeProvince(String consigneeProvince) {
		this.consigneeProvince = consigneeProvince;
	}

	public String getConsigneeCountry() {
		return consigneeCountry;
	}

	public void setConsigneeCountry(String consigneeCountry) {
		this.consigneeCountry = consigneeCountry;
	}

	public String getConsigneeZip() {
		return consigneeZip;
	}

	public void setConsigneeZip(String consigneeZip) {
		this.consigneeZip = consigneeZip;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getTitleSelect() {
		return titleSelect;
	}

	public void setTitleSelect(String titleSelect) {
		this.titleSelect = titleSelect;
	}

	public String getTitleMailTo() {
		return titleMailTo;
	}

	public void setTitleMailTo(String titleMailTo) {
		this.titleMailTo = titleMailTo;
	}

	public String getTitleFirstName() {
		return titleFirstName;
	}

	public void setTitleFirstName(String titleFirstName) {
		this.titleFirstName = titleFirstName;
	}

	public String getTitleLastName() {
		return titleLastName;
	}

	public void setTitleLastName(String titleLastName) {
		this.titleLastName = titleLastName;
	}

	public String getTitleAddress1() {
		return titleAddress1;
	}

	public void setTitleAddress1(String titleAddress1) {
		this.titleAddress1 = titleAddress1;
	}

	public String getTitleAddress2() {
		return titleAddress2;
	}

	public void setTitleAddress2(String titleAddress2) {
		this.titleAddress2 = titleAddress2;
	}

	public String getTitleCity() {
		return titleCity;
	}

	public void setTitleCity(String titleCity) {
		this.titleCity = titleCity;
	}

	public String getTitleState() {
		return titleState;
	}

	public void setTitleState(String titleState) {
		this.titleState = titleState;
	}

	public String getTitleProvince() {
		return titleProvince;
	}

	public void setTitleProvince(String titleProvince) {
		this.titleProvince = titleProvince;
	}

	public String getTitleCountry() {
		return titleCountry;
	}

	public void setTitleCountry(String titleCountry) {
		this.titleCountry = titleCountry;
	}

	public String getTitleZip() {
		return titleZip;
	}

	public void setTitleZip(String titleZip) {
		this.titleZip = titleZip;
	}

	public String getTitlePhone() {
		return titlePhone;
	}

	public void setTitlePhone(String titlePhone) {
		this.titlePhone = titlePhone;
	}

	public String getAgentSelect() {
		return agentSelect;
	}

	public void setAgentSelect(String agentSelect) {
		this.agentSelect = agentSelect;
	}

	public String getAgentFirstName() {
		return agentFirstName;
	}

	public void setAgentFirstName(String agentFirstName) {
		this.agentFirstName = agentFirstName;
	}

	public String getAgentLastName() {
		return agentLastName;
	}

	public void setAgentLastName(String agentLastName) {
		this.agentLastName = agentLastName;
	}

	public String getAgentAddress1() {
		return agentAddress1;
	}

	public void setAgentAddress1(String agentAddress1) {
		this.agentAddress1 = agentAddress1;
	}

	public String getAgentAddress2() {
		return agentAddress2;
	}

	public void setAgentAddress2(String agentAddress2) {
		this.agentAddress2 = agentAddress2;
	}

	public String getAgentCity() {
		return agentCity;
	}

	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public String getAgentProvince() {
		return agentProvince;
	}

	public void setAgentProvince(String agentProvince) {
		this.agentProvince = agentProvince;
	}

	public String getAgentCountry() {
		return agentCountry;
	}

	public void setAgentCountry(String agentCountry) {
		this.agentCountry = agentCountry;
	}

	public String getAgentZip() {
		return agentZip;
	}

	public void setAgentZip(String agentZip) {
		this.agentZip = agentZip;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactMessage() {
		return contactMessage;
	}

	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}
	
	
	
	
	
}
