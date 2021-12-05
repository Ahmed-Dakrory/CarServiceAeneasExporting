package main.com.carService.tools;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.com.carService.car.car;

public class Constants {

	public static String URLwithVin="https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinValuesExtended/";
	
	public static Integer Notifcation_Period=30;
	
	//For tls and mail send
	//sudo apt-get install libtcnative-1
	
	
	public static void sendEmailNotificationForThisEmailWithMessage(car selectedCar2, String message,String mail) {
		
        String[] to = {mail }; // list of recipient email addresses 
        String subject = "Aeneas Exporting LLC "+selectedCar2.getUuid();
        String htmlText = getMessageforEmailWithMessage(selectedCar2, message);

        System.out.println("Email Sent To: "+message+" With Mail: "+mail);
        sendFromGMail( to, subject, htmlText);
        

}
	
	
	
	public static String getMessageforEmailWithMessage(car selectedCar, String message) {
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
				"    <style>\r\n" + 
				"\r\n" + 
				"        /* What it does: Remove spaces around the email design added by some email clients. */\r\n" + 
				"        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\r\n" + 
				"        html,\r\n" + 
				"body {\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"    padding: 0 !important;\r\n" + 
				"    height: 100% !important;\r\n" + 
				"    width: 100% !important;\r\n" + 
				"    background: #f1f1f1;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops email clients resizing small text. */\r\n" + 
				"* {\r\n" + 
				"    -ms-text-size-adjust: 100%;\r\n" + 
				"    -webkit-text-size-adjust: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Centers email on Android 4.4 */\r\n" + 
				"div[style*=\"margin: 16px 0\"] {\r\n" + 
				"    margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops Outlook from adding extra spacing to tables. */\r\n" + 
				"table,\r\n" + 
				"td {\r\n" + 
				"    mso-table-lspace: 0pt !important;\r\n" + 
				"    mso-table-rspace: 0pt !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Fixes webkit padding issue. */\r\n" + 
				"table {\r\n" + 
				"    border-spacing: 0 !important;\r\n" + 
				"    border-collapse: collapse !important;\r\n" + 
				"    table-layout: fixed !important;\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Uses a better rendering method when resizing images in IE. */\r\n" + 
				"img {\r\n" + 
				"    -ms-interpolation-mode:bicubic;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\r\n" + 
				"a {\r\n" + 
				"    text-decoration: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: A work-around for email clients meddling in triggered links. */\r\n" + 
				"*[x-apple-data-detectors],  /* iOS */\r\n" + 
				".unstyle-auto-detected-links *,\r\n" + 
				".aBn {\r\n" + 
				"    border-bottom: 0 !important;\r\n" + 
				"    cursor: default !important;\r\n" + 
				"    color: inherit !important;\r\n" + 
				"    text-decoration: none !important;\r\n" + 
				"    font-size: inherit !important;\r\n" + 
				"    font-family: inherit !important;\r\n" + 
				"    font-weight: inherit !important;\r\n" + 
				"    line-height: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\r\n" + 
				".a6S {\r\n" + 
				"    display: none !important;\r\n" + 
				"    opacity: 0.01 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from changing the text color in conversation threads. */\r\n" + 
				".im {\r\n" + 
				"    color: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* If the above doesn't work, add a .g-img class to any image in question. */\r\n" + 
				"img.g-img + div {\r\n" + 
				"    display: none !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\r\n" + 
				"/* Create one of these media queries for each additional viewport size you'd like to fix */\r\n" + 
				"\r\n" + 
				"/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\r\n" + 
				"@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 320px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6, 6S, 7, 8, and X */\r\n" + 
				"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 375px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6+, 7+, and 8+ */\r\n" + 
				"@media only screen and (min-device-width: 414px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 414px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"\r\n" + 
				"	    .primary{\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"}\r\n" + 
				".bg_white{\r\n" + 
				"	background: #ffffff;\r\n" + 
				"}\r\n" + 
				".bg_light{\r\n" + 
				"	background: #fafafa;\r\n" + 
				"}\r\n" + 
				".bg_black{\r\n" + 
				"	background: #000000;\r\n" + 
				"}\r\n" + 
				".bg_dark{\r\n" + 
				"	background: rgba(0,0,0,.8);\r\n" + 
				"}\r\n" + 
				".email-section{\r\n" + 
				"	padding:2.5em;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*BUTTON*/\r\n" + 
				".btn{\r\n" + 
				"	padding: 5px 20px;\r\n" + 
				"	display: inline-block;\r\n" + 
				"}\r\n" + 
				".btn.btn-primary{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".btn.btn-white{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ffffff;\r\n" + 
				"	color: #000000;\r\n" + 
				"}\r\n" + 
				".btn.btn-white-outline{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 1px solid #fff;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: #000;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black-outline{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 2px solid #000;\r\n" + 
				"	color: #000;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".btn.btn-custom{\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	font-size: 12px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1,h2,h3,h4,h5,h6{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	color: #000000;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	font-size: 15px;\r\n" + 
				"	line-height: 1.8;\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"a{\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table{\r\n" + 
				"}\r\n" + 
				"/*LOGO*/\r\n" + 
				"\r\n" + 
				".logo h1{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				".logo h1 a{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"	/*text-transform: uppercase;*/\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".navigation{\r\n" + 
				"	padding: 0;\r\n" + 
				"	padding: 1em 0;\r\n" + 
				"	/*background: rgba(0,0,0,1);*/\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".navigation li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	display: inline-block;;\r\n" + 
				"	margin-left: 5px;\r\n" + 
				"	margin-right: 5px;\r\n" + 
				"	font-size: 14px;\r\n" + 
				"	font-weight: 500;\r\n" + 
				"}\r\n" + 
				".navigation li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HERO*/\r\n" + 
				".hero{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".hero .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .2;\r\n" + 
				"}\r\n" + 
				".hero .text{\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	max-width: 50%;\r\n" + 
				"	margin: 0 auto 0;\r\n" + 
				"}\r\n" + 
				".hero .text h2{\r\n" + 
				"	color: #fff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"}\r\n" + 
				".hero .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*INTRO*/\r\n" + 
				".intro{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".intro .text{\r\n" + 
				"	color: rgba(0,0,0,.3);\r\n" + 
				"}\r\n" + 
				".intro .text h2{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 300;\r\n" + 
				"}\r\n" + 
				".intro .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*SERVICES*/\r\n" + 
				".services{\r\n" + 
				"}\r\n" + 
				".text-services{\r\n" + 
				"	padding: 10px 10px 0; \r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".text-services h3{\r\n" + 
				"	font-size: 18px;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list{\r\n" + 
				"	margin: 0 0 20px 0;\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list img{\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".services-list h3{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".services-list p{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"/*COUNTER*/\r\n" + 
				".counter{\r\n" + 
				"	width: 100%;\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".counter .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .3;\r\n" + 
				"}\r\n" + 
				".counter-text{\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".counter-text .num{\r\n" + 
				"	display: block;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".counter-text .name{\r\n" + 
				"	display: block;\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	font-size: 13px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*TOPIC*/\r\n" + 
				".topic{\r\n" + 
				"	width: 100%;\r\n" + 
				"	display: block;\r\n" + 
				"	float: left;\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.1);\r\n" + 
				"	padding: 1.5em 0;\r\n" + 
				"}\r\n" + 
				".topic .img{\r\n" + 
				"	width: 120px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text{\r\n" + 
				"	width: calc(100% - 150px);\r\n" + 
				"	padding-left: 20px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text h3{\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	margin-bottom: 15px;\r\n" + 
				"	line-height: 1.2;\r\n" + 
				"}\r\n" + 
				".topic .text .meta{\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HEADING SECTION*/\r\n" + 
				".heading-section{\r\n" + 
				"}\r\n" + 
				".heading-section h2{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 28px;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading{\r\n" + 
				"	margin-bottom: 20px !important;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(0,0,0,.4);\r\n" + 
				"	position: relative;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading::after{\r\n" + 
				"	position: absolute;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: -10px;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	height: 2px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	margin: 0 auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".heading-section-white{\r\n" + 
				"	color: rgba(255,255,255,.8);\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	font-family: \r\n" + 
				"	line-height: 1;\r\n" + 
				"	padding-bottom: 0;\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".heading-section-white .subheading{\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(255,255,255,.4);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"ul.social{\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				"ul.social li{\r\n" + 
				"	display: inline-block;\r\n" + 
				"	margin-right: 10px;\r\n" + 
				"	/*border: 1px solid #ff8b00;*/\r\n" + 
				"	padding: 10px;\r\n" + 
				"	border-radius: 50%;\r\n" + 
				"	background: rgba(0,0,0,.05);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*FOOTER*/\r\n" + 
				"\r\n" + 
				".footer{\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				".footer .heading{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"}\r\n" + 
				".footer ul{\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				".footer ul li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				".footer ul li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@media screen and (max-width: 500px) {\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa;\">\r\n" + 
				"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
				"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"    	<!-- BEGIN BODY -->\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
				"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
				"          		<tbody><tr>\r\n" + 
				"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
				"			            <h1><a href=\"http://AeneasExportingllc.com/\">Aeneas Exporting LLC</a></h1>\r\n" + 
				"			          </td>\r\n" + 
				"          		</tr>\r\n" + 
				"          	</tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td valign=\"middle\" class=\"hero bg_white\" style=\"background-color: #555c61;box-shadow: 0px 3px 21px 5px grey;background-size:cover;height:263px;\">\r\n" + 
				"          	<div class=\"overlay\"></div>\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"            		<td>\r\n" + 
				"            			<div class=\"text\" style=\"padding: 0 4em; text-align: center;\">\r\n" + 
				"\r\n" + 
				"<p style=\"\r\n" + 
				"    font-size: 22px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
				"\">Please Check the Note to Car With Vin  "+selectedCar.getUuid()+"</p><p style=\"\r\n" + 
				"    font-size: 26px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
				"\">"+message+"</p><p></p>\r\n" + 
				"\r\n" + 
				"							<br>\r\n" + 
				"            				\r\n" + 
				"            				\r\n" + 
				"            			</div>\r\n" + 
				"            		</td>\r\n" + 
				"            	</tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td class=\"bg_dark email-section\" style=\"text-align:center;\">\r\n" + 
				"          	<div style=\" margin-top: 31px; \" class=\"heading-section heading-section-white\">\r\n" + 
				"          		<span style=\"font-size: 25px;color: #8c7c0e;font-weight: 900;\" class=\"subheading\">Welcome</span>\r\n" + 
				"            	<h2>Aeneas Exporting LLC</h2>\r\n" + 
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
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"middle\" class=\"bg_light footer email-section\">\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
				"                      	<h3 class=\"heading\">About</h3>\r\n" + 
				"                      	<p>Aeneas Exporting LLC®</p>\r\n" + 
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
	public static void sendEmailUpdateFormatCar(car selectedCar2, String name,String mail, String string) {
		
        String[] to = {mail }; // list of recipient email addresses 
        String subject = "Aeneas Exporting LLC "+selectedCar2.getUuid()+" Update";
        String htmlText = getMessageUpdateCar(selectedCar2);

        System.out.println("Email Sent To: "+name+" With Mail: "+mail);
        sendFromGMail( to, subject, htmlText);
        

}
	
	
	
	public static String getMessageUpdateCar(car selectedCar) {
		String note ="";
		if(!selectedCar.getNote().equalsIgnoreCase("")) {
			 note = "\r\n" + 
					"<p style=\"\r\n" + 
					"    font-size: 26px;\r\n" + 
					"    color: white;\r\n" + 
					"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
					"\">Note <p style=\"\r\n" + 
					"    font-size: 26px;\r\n" + 
					"    color: white;\r\n" + 
					"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
					"\"> "+selectedCar.getNote()+"</p></p>\r\n" + 
					"\r\n" + 
					"							<br>\r\n" + 
					"            				\r\n" + 
					"            				\r\n" ;
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
				"    <style>\r\n" + 
				"\r\n" + 
				"        /* What it does: Remove spaces around the email design added by some email clients. */\r\n" + 
				"        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\r\n" + 
				"        html,\r\n" + 
				"body {\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"    padding: 0 !important;\r\n" + 
				"    height: 100% !important;\r\n" + 
				"    width: 100% !important;\r\n" + 
				"    background: #f1f1f1;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops email clients resizing small text. */\r\n" + 
				"* {\r\n" + 
				"    -ms-text-size-adjust: 100%;\r\n" + 
				"    -webkit-text-size-adjust: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Centers email on Android 4.4 */\r\n" + 
				"div[style*=\"margin: 16px 0\"] {\r\n" + 
				"    margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops Outlook from adding extra spacing to tables. */\r\n" + 
				"table,\r\n" + 
				"td {\r\n" + 
				"    mso-table-lspace: 0pt !important;\r\n" + 
				"    mso-table-rspace: 0pt !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Fixes webkit padding issue. */\r\n" + 
				"table {\r\n" + 
				"    border-spacing: 0 !important;\r\n" + 
				"    border-collapse: collapse !important;\r\n" + 
				"    table-layout: fixed !important;\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Uses a better rendering method when resizing images in IE. */\r\n" + 
				"img {\r\n" + 
				"    -ms-interpolation-mode:bicubic;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\r\n" + 
				"a {\r\n" + 
				"    text-decoration: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: A work-around for email clients meddling in triggered links. */\r\n" + 
				"*[x-apple-data-detectors],  /* iOS */\r\n" + 
				".unstyle-auto-detected-links *,\r\n" + 
				".aBn {\r\n" + 
				"    border-bottom: 0 !important;\r\n" + 
				"    cursor: default !important;\r\n" + 
				"    color: inherit !important;\r\n" + 
				"    text-decoration: none !important;\r\n" + 
				"    font-size: inherit !important;\r\n" + 
				"    font-family: inherit !important;\r\n" + 
				"    font-weight: inherit !important;\r\n" + 
				"    line-height: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\r\n" + 
				".a6S {\r\n" + 
				"    display: none !important;\r\n" + 
				"    opacity: 0.01 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from changing the text color in conversation threads. */\r\n" + 
				".im {\r\n" + 
				"    color: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* If the above doesn't work, add a .g-img class to any image in question. */\r\n" + 
				"img.g-img + div {\r\n" + 
				"    display: none !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\r\n" + 
				"/* Create one of these media queries for each additional viewport size you'd like to fix */\r\n" + 
				"\r\n" + 
				"/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\r\n" + 
				"@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 320px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6, 6S, 7, 8, and X */\r\n" + 
				"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 375px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6+, 7+, and 8+ */\r\n" + 
				"@media only screen and (min-device-width: 414px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 414px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"\r\n" + 
				"	    .primary{\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"}\r\n" + 
				".bg_white{\r\n" + 
				"	background: #ffffff;\r\n" + 
				"}\r\n" + 
				".bg_light{\r\n" + 
				"	background: #fafafa;\r\n" + 
				"}\r\n" + 
				".bg_black{\r\n" + 
				"	background: #000000;\r\n" + 
				"}\r\n" + 
				".bg_dark{\r\n" + 
				"	background: rgba(0,0,0,.8);\r\n" + 
				"}\r\n" + 
				".email-section{\r\n" + 
				"	padding:2.5em;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*BUTTON*/\r\n" + 
				".btn{\r\n" + 
				"	padding: 5px 20px;\r\n" + 
				"	display: inline-block;\r\n" + 
				"}\r\n" + 
				".btn.btn-primary{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".btn.btn-white{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ffffff;\r\n" + 
				"	color: #000000;\r\n" + 
				"}\r\n" + 
				".btn.btn-white-outline{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 1px solid #fff;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: #000;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black-outline{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 2px solid #000;\r\n" + 
				"	color: #000;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".btn.btn-custom{\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	font-size: 12px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1,h2,h3,h4,h5,h6{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	color: #000000;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	font-size: 15px;\r\n" + 
				"	line-height: 1.8;\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"a{\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table{\r\n" + 
				"}\r\n" + 
				"/*LOGO*/\r\n" + 
				"\r\n" + 
				".logo h1{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				".logo h1 a{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"	/*text-transform: uppercase;*/\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".navigation{\r\n" + 
				"	padding: 0;\r\n" + 
				"	padding: 1em 0;\r\n" + 
				"	/*background: rgba(0,0,0,1);*/\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".navigation li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	display: inline-block;;\r\n" + 
				"	margin-left: 5px;\r\n" + 
				"	margin-right: 5px;\r\n" + 
				"	font-size: 14px;\r\n" + 
				"	font-weight: 500;\r\n" + 
				"}\r\n" + 
				".navigation li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HERO*/\r\n" + 
				".hero{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".hero .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .2;\r\n" + 
				"}\r\n" + 
				".hero .text{\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	max-width: 50%;\r\n" + 
				"	margin: 0 auto 0;\r\n" + 
				"}\r\n" + 
				".hero .text h2{\r\n" + 
				"	color: #fff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"}\r\n" + 
				".hero .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*INTRO*/\r\n" + 
				".intro{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".intro .text{\r\n" + 
				"	color: rgba(0,0,0,.3);\r\n" + 
				"}\r\n" + 
				".intro .text h2{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 300;\r\n" + 
				"}\r\n" + 
				".intro .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*SERVICES*/\r\n" + 
				".services{\r\n" + 
				"}\r\n" + 
				".text-services{\r\n" + 
				"	padding: 10px 10px 0; \r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".text-services h3{\r\n" + 
				"	font-size: 18px;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list{\r\n" + 
				"	margin: 0 0 20px 0;\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list img{\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".services-list h3{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".services-list p{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"/*COUNTER*/\r\n" + 
				".counter{\r\n" + 
				"	width: 100%;\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".counter .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .3;\r\n" + 
				"}\r\n" + 
				".counter-text{\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".counter-text .num{\r\n" + 
				"	display: block;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".counter-text .name{\r\n" + 
				"	display: block;\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	font-size: 13px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*TOPIC*/\r\n" + 
				".topic{\r\n" + 
				"	width: 100%;\r\n" + 
				"	display: block;\r\n" + 
				"	float: left;\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.1);\r\n" + 
				"	padding: 1.5em 0;\r\n" + 
				"}\r\n" + 
				".topic .img{\r\n" + 
				"	width: 120px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text{\r\n" + 
				"	width: calc(100% - 150px);\r\n" + 
				"	padding-left: 20px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text h3{\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	margin-bottom: 15px;\r\n" + 
				"	line-height: 1.2;\r\n" + 
				"}\r\n" + 
				".topic .text .meta{\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HEADING SECTION*/\r\n" + 
				".heading-section{\r\n" + 
				"}\r\n" + 
				".heading-section h2{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 28px;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading{\r\n" + 
				"	margin-bottom: 20px !important;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(0,0,0,.4);\r\n" + 
				"	position: relative;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading::after{\r\n" + 
				"	position: absolute;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: -10px;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	height: 2px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	margin: 0 auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".heading-section-white{\r\n" + 
				"	color: rgba(255,255,255,.8);\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	font-family: \r\n" + 
				"	line-height: 1;\r\n" + 
				"	padding-bottom: 0;\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".heading-section-white .subheading{\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(255,255,255,.4);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"ul.social{\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				"ul.social li{\r\n" + 
				"	display: inline-block;\r\n" + 
				"	margin-right: 10px;\r\n" + 
				"	/*border: 1px solid #ff8b00;*/\r\n" + 
				"	padding: 10px;\r\n" + 
				"	border-radius: 50%;\r\n" + 
				"	background: rgba(0,0,0,.05);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*FOOTER*/\r\n" + 
				"\r\n" + 
				".footer{\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				".footer .heading{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"}\r\n" + 
				".footer ul{\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				".footer ul li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				".footer ul li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@media screen and (max-width: 500px) {\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa;\">\r\n" + 
				"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
				"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"    	<!-- BEGIN BODY -->\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
				"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
				"          		<tbody><tr>\r\n" + 
				"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
				"			            <h1><a href=\"http://AeneasExportingllc.com/\">Aeneas Exporting LLC</a></h1>\r\n" + 
				"			          </td>\r\n" + 
				"          		</tr>\r\n" + 
				"          	</tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td valign=\"middle\" class=\"hero bg_white\" style=\"background-color: #555c61;box-shadow: 0px 3px 21px 5px grey;background-size:cover;height:263px;\">\r\n" + 
				"          	<div class=\"overlay\"></div>\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"            		<td>\r\n" + 
				"            			<div class=\"text\" style=\"padding: 0 4em; text-align: center;\">\r\n" + 
				"\r\n" + 
				"<p style=\"\r\n" + 
				"    font-size: 26px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
				"\">Please Check Updated Vin <p style=\"\r\n" + 
				"    font-size: 26px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
				"\"> "+selectedCar.getUuid()+"</p></p>\r\n" + 
				"\r\n" + 
				"							<br>\r\n" + 
				"            				\r\n" + 
				"            				\r\n" + 
				
				
				note+
				
				"            			</div>\r\n" + 
				"            		</td>\r\n" + 
				"            	</tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td class=\"bg_dark email-section\" style=\"text-align:center;\">\r\n" + 
				"          	<div style=\" margin-top: 31px; \" class=\"heading-section heading-section-white\">\r\n" + 
				"          		<span style=\"font-size: 25px;color: #8c7c0e;font-weight: 900;\" class=\"subheading\">Welcome</span>\r\n" + 
				"            	<h2>Aeneas Exporting LLC</h2>\r\n" + 
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
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"middle\" class=\"bg_light footer email-section\">\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
				"                      	<h3 class=\"heading\">About</h3>\r\n" + 
				"                      	<p>Aeneas Exporting LLC®</p>\r\n" + 
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
	
	
	public static void sendEmailUpdateFormat(String name,String mail, String string) {
		
	        String[] to = {mail }; // list of recipient email addresses 
	        String subject = "Aeneas Exporting LLC";
	        String htmlText = getMessageUpdate();

	        System.out.println("Email Sent To: "+name+" With Mail: "+mail);
	        sendFromGMail( to, subject, htmlText);
	        
	
	}
	
	public static String getMessageUpdate() {
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
				"    <style>\r\n" + 
				"\r\n" + 
				"        /* What it does: Remove spaces around the email design added by some email clients. */\r\n" + 
				"        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\r\n" + 
				"        html,\r\n" + 
				"body {\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"    padding: 0 !important;\r\n" + 
				"    height: 100% !important;\r\n" + 
				"    width: 100% !important;\r\n" + 
				"    background: #f1f1f1;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops email clients resizing small text. */\r\n" + 
				"* {\r\n" + 
				"    -ms-text-size-adjust: 100%;\r\n" + 
				"    -webkit-text-size-adjust: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Centers email on Android 4.4 */\r\n" + 
				"div[style*=\"margin: 16px 0\"] {\r\n" + 
				"    margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Stops Outlook from adding extra spacing to tables. */\r\n" + 
				"table,\r\n" + 
				"td {\r\n" + 
				"    mso-table-lspace: 0pt !important;\r\n" + 
				"    mso-table-rspace: 0pt !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Fixes webkit padding issue. */\r\n" + 
				"table {\r\n" + 
				"    border-spacing: 0 !important;\r\n" + 
				"    border-collapse: collapse !important;\r\n" + 
				"    table-layout: fixed !important;\r\n" + 
				"    margin: 0 auto !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Uses a better rendering method when resizing images in IE. */\r\n" + 
				"img {\r\n" + 
				"    -ms-interpolation-mode:bicubic;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\r\n" + 
				"a {\r\n" + 
				"    text-decoration: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: A work-around for email clients meddling in triggered links. */\r\n" + 
				"*[x-apple-data-detectors],  /* iOS */\r\n" + 
				".unstyle-auto-detected-links *,\r\n" + 
				".aBn {\r\n" + 
				"    border-bottom: 0 !important;\r\n" + 
				"    cursor: default !important;\r\n" + 
				"    color: inherit !important;\r\n" + 
				"    text-decoration: none !important;\r\n" + 
				"    font-size: inherit !important;\r\n" + 
				"    font-family: inherit !important;\r\n" + 
				"    font-weight: inherit !important;\r\n" + 
				"    line-height: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\r\n" + 
				".a6S {\r\n" + 
				"    display: none !important;\r\n" + 
				"    opacity: 0.01 !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Prevents Gmail from changing the text color in conversation threads. */\r\n" + 
				".im {\r\n" + 
				"    color: inherit !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* If the above doesn't work, add a .g-img class to any image in question. */\r\n" + 
				"img.g-img + div {\r\n" + 
				"    display: none !important;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\r\n" + 
				"/* Create one of these media queries for each additional viewport size you'd like to fix */\r\n" + 
				"\r\n" + 
				"/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\r\n" + 
				"@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 320px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6, 6S, 7, 8, and X */\r\n" + 
				"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 375px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"/* iPhone 6+, 7+, and 8+ */\r\n" + 
				"@media only screen and (min-device-width: 414px) {\r\n" + 
				"    u ~ div .email-container {\r\n" + 
				"        min-width: 414px !important;\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"\r\n" + 
				"	    .primary{\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"}\r\n" + 
				".bg_white{\r\n" + 
				"	background: #ffffff;\r\n" + 
				"}\r\n" + 
				".bg_light{\r\n" + 
				"	background: #fafafa;\r\n" + 
				"}\r\n" + 
				".bg_black{\r\n" + 
				"	background: #000000;\r\n" + 
				"}\r\n" + 
				".bg_dark{\r\n" + 
				"	background: rgba(0,0,0,.8);\r\n" + 
				"}\r\n" + 
				".email-section{\r\n" + 
				"	padding:2.5em;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*BUTTON*/\r\n" + 
				".btn{\r\n" + 
				"	padding: 5px 20px;\r\n" + 
				"	display: inline-block;\r\n" + 
				"}\r\n" + 
				".btn.btn-primary{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".btn.btn-white{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: #ffffff;\r\n" + 
				"	color: #000000;\r\n" + 
				"}\r\n" + 
				".btn.btn-white-outline{\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 1px solid #fff;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: #000;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				".btn.btn-black-outline{\r\n" + 
				"	border-radius: 0px;\r\n" + 
				"	background: transparent;\r\n" + 
				"	border: 2px solid #000;\r\n" + 
				"	color: #000;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".btn.btn-custom{\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	font-size: 12px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1,h2,h3,h4,h5,h6{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	color: #000000;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body{\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	font-size: 15px;\r\n" + 
				"	line-height: 1.8;\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"a{\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table{\r\n" + 
				"}\r\n" + 
				"/*LOGO*/\r\n" + 
				"\r\n" + 
				".logo h1{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				".logo h1 a{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"	/*text-transform: uppercase;*/\r\n" + 
				"	font-family: 'Work Sans', sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".navigation{\r\n" + 
				"	padding: 0;\r\n" + 
				"	padding: 1em 0;\r\n" + 
				"	/*background: rgba(0,0,0,1);*/\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".navigation li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	display: inline-block;;\r\n" + 
				"	margin-left: 5px;\r\n" + 
				"	margin-right: 5px;\r\n" + 
				"	font-size: 14px;\r\n" + 
				"	font-weight: 500;\r\n" + 
				"}\r\n" + 
				".navigation li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HERO*/\r\n" + 
				".hero{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".hero .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .2;\r\n" + 
				"}\r\n" + 
				".hero .text{\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	max-width: 50%;\r\n" + 
				"	margin: 0 auto 0;\r\n" + 
				"}\r\n" + 
				".hero .text h2{\r\n" + 
				"	color: #fff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"}\r\n" + 
				".hero .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*INTRO*/\r\n" + 
				".intro{\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".intro .text{\r\n" + 
				"	color: rgba(0,0,0,.3);\r\n" + 
				"}\r\n" + 
				".intro .text h2{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	font-weight: 300;\r\n" + 
				"}\r\n" + 
				".intro .text h2 span{\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	color: #ff8b00;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*SERVICES*/\r\n" + 
				".services{\r\n" + 
				"}\r\n" + 
				".text-services{\r\n" + 
				"	padding: 10px 10px 0; \r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".text-services h3{\r\n" + 
				"	font-size: 18px;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list{\r\n" + 
				"	margin: 0 0 20px 0;\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".services-list img{\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".services-list h3{\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"}\r\n" + 
				".services-list p{\r\n" + 
				"	margin: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"/*COUNTER*/\r\n" + 
				".counter{\r\n" + 
				"	width: 100%;\r\n" + 
				"	position: relative;\r\n" + 
				"	z-index: 0;\r\n" + 
				"}\r\n" + 
				".counter .overlay{\r\n" + 
				"	position: absolute;\r\n" + 
				"	top: 0;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	background: #000000;\r\n" + 
				"	z-index: -1;\r\n" + 
				"	opacity: .3;\r\n" + 
				"}\r\n" + 
				".counter-text{\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				".counter-text .num{\r\n" + 
				"	display: block;\r\n" + 
				"	color: #ffffff;\r\n" + 
				"	font-size: 34px;\r\n" + 
				"	font-weight: 700;\r\n" + 
				"}\r\n" + 
				".counter-text .name{\r\n" + 
				"	display: block;\r\n" + 
				"	color: rgba(255,255,255,.9);\r\n" + 
				"	font-size: 13px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*TOPIC*/\r\n" + 
				".topic{\r\n" + 
				"	width: 100%;\r\n" + 
				"	display: block;\r\n" + 
				"	float: left;\r\n" + 
				"	border-bottom: 1px solid rgba(0,0,0,.1);\r\n" + 
				"	padding: 1.5em 0;\r\n" + 
				"}\r\n" + 
				".topic .img{\r\n" + 
				"	width: 120px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text{\r\n" + 
				"	width: calc(100% - 150px);\r\n" + 
				"	padding-left: 20px;\r\n" + 
				"	float: left;\r\n" + 
				"}\r\n" + 
				".topic .text h3{\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	margin-bottom: 15px;\r\n" + 
				"	line-height: 1.2;\r\n" + 
				"}\r\n" + 
				".topic .text .meta{\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*HEADING SECTION*/\r\n" + 
				".heading-section{\r\n" + 
				"}\r\n" + 
				".heading-section h2{\r\n" + 
				"	color: #000000;\r\n" + 
				"	font-size: 28px;\r\n" + 
				"	margin-top: 0;\r\n" + 
				"	line-height: 1.4;\r\n" + 
				"	font-weight: 400;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading{\r\n" + 
				"	margin-bottom: 20px !important;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(0,0,0,.4);\r\n" + 
				"	position: relative;\r\n" + 
				"}\r\n" + 
				".heading-section .subheading::after{\r\n" + 
				"	position: absolute;\r\n" + 
				"	left: 0;\r\n" + 
				"	right: 0;\r\n" + 
				"	bottom: -10px;\r\n" + 
				"	content: '';\r\n" + 
				"	width: 100%;\r\n" + 
				"	height: 2px;\r\n" + 
				"	background: #ff8b00;\r\n" + 
				"	margin: 0 auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".heading-section-white{\r\n" + 
				"	color: rgba(255,255,255,.8);\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	font-family: \r\n" + 
				"	line-height: 1;\r\n" + 
				"	padding-bottom: 0;\r\n" + 
				"}\r\n" + 
				".heading-section-white h2{\r\n" + 
				"	color: #ffffff;\r\n" + 
				"}\r\n" + 
				".heading-section-white .subheading{\r\n" + 
				"	margin-bottom: 0;\r\n" + 
				"	display: inline-block;\r\n" + 
				"	font-size: 13px;\r\n" + 
				"	text-transform: uppercase;\r\n" + 
				"	letter-spacing: 2px;\r\n" + 
				"	color: rgba(255,255,255,.4);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"ul.social{\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				"ul.social li{\r\n" + 
				"	display: inline-block;\r\n" + 
				"	margin-right: 10px;\r\n" + 
				"	/*border: 1px solid #ff8b00;*/\r\n" + 
				"	padding: 10px;\r\n" + 
				"	border-radius: 50%;\r\n" + 
				"	background: rgba(0,0,0,.05);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/*FOOTER*/\r\n" + 
				"\r\n" + 
				".footer{\r\n" + 
				"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
				"	color: rgba(0,0,0,.5);\r\n" + 
				"}\r\n" + 
				".footer .heading{\r\n" + 
				"	color: #000;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"}\r\n" + 
				".footer ul{\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"}\r\n" + 
				".footer ul li{\r\n" + 
				"	list-style: none;\r\n" + 
				"	margin-bottom: 10px;\r\n" + 
				"}\r\n" + 
				".footer ul li a{\r\n" + 
				"	color: rgba(0,0,0,1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@media screen and (max-width: 500px) {\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa;\">\r\n" + 
				"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
				"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"    	<!-- BEGIN BODY -->\r\n" + 
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
				"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
				"          		<tbody><tr>\r\n" + 
				"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
				"			            <h1><a href=\"http://AeneasExportingllc.com/\">Aeneas Exporting LLC</a></h1>\r\n" + 
				"			          </td>\r\n" + 
				"          		</tr>\r\n" + 
				"          	</tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td valign=\"middle\" class=\"hero bg_white\" style=\"background-color: #555c61;box-shadow: 0px 3px 21px 5px grey;background-size:cover;height:263px;\">\r\n" + 
				"          	<div class=\"overlay\"></div>\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"            		<td>\r\n" + 
				"            			<div class=\"text\" style=\"padding: 0 4em; text-align: center;\">\r\n" + 
				"\r\n" + 
				"<p style=\"\r\n" + 
				"    font-size: 26px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
				"\"> please check the Account for new updates</p>\r\n" + 
				"            				\r\n" + 
				"            				\r\n" + 
				"            			</div>\r\n" + 
				"            		</td>\r\n" + 
				"            	</tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"	      </tr><!-- end tr -->\r\n" + 
				"	      <tr>\r\n" + 
				"          <td class=\"bg_dark email-section\" style=\"text-align:center;\">\r\n" + 
				"          	<div style=\" margin-top: 31px; \" class=\"heading-section heading-section-white\">\r\n" + 
				"          		<span style=\"font-size: 25px;color: #8c7c0e;font-weight: 900;\" class=\"subheading\">Welcome</span>\r\n" + 
				"            	<h2>Aeneas Exporting LLC</h2>\r\n" + 
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
				"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
				"      	<tbody><tr>\r\n" + 
				"          <td valign=\"middle\" class=\"bg_light footer email-section\">\r\n" + 
				"            <table>\r\n" + 
				"            	<tbody><tr>\r\n" + 
				"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
				"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
				"                    <tbody><tr>\r\n" + 
				"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
				"                      	<h3 class=\"heading\">About</h3>\r\n" + 
				"                      	<p>Aeneas Exporting LLC®</p>\r\n" + 
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
	
	
	
	public static void sendEmailForgetAccount(String name,String mail, String account) {
		
        String[] to = {mail }; // list of recipient email addresses 
        String subject = "Aeneas Exporting LLC";
        String htmlText = "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
        		"    <meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\r\n" + 
        		"    <meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
        		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
        		"    <meta name=\"x-apple-disable-message-reformatting\">  <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
        		"    <title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
        		"\r\n" + 
        		"    <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\r\n" + 
        		"\r\n" + 
        		"    <!-- CSS Reset : BEGIN -->\r\n" + 
        		"    <style>\r\n" + 
        		"\r\n" + 
        		"        /* What it does: Remove spaces around the email design added by some email clients. */\r\n" + 
        		"        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\r\n" + 
        		"        html,\r\n" + 
        		"body {\r\n" + 
        		"    margin: 0 auto !important;\r\n" + 
        		"    padding: 0 !important;\r\n" + 
        		"    height: 100% !important;\r\n" + 
        		"    width: 100% !important;\r\n" + 
        		"    background: #f1f1f1;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Stops email clients resizing small text. */\r\n" + 
        		"* {\r\n" + 
        		"    -ms-text-size-adjust: 100%;\r\n" + 
        		"    -webkit-text-size-adjust: 100%;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Centers email on Android 4.4 */\r\n" + 
        		"div[style*=\"margin: 16px 0\"] {\r\n" + 
        		"    margin: 0 !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Stops Outlook from adding extra spacing to tables. */\r\n" + 
        		"table,\r\n" + 
        		"td {\r\n" + 
        		"    mso-table-lspace: 0pt !important;\r\n" + 
        		"    mso-table-rspace: 0pt !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Fixes webkit padding issue. */\r\n" + 
        		"table {\r\n" + 
        		"    border-spacing: 0 !important;\r\n" + 
        		"    border-collapse: collapse !important;\r\n" + 
        		"    table-layout: fixed !important;\r\n" + 
        		"    margin: 0 auto !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Uses a better rendering method when resizing images in IE. */\r\n" + 
        		"img {\r\n" + 
        		"    -ms-interpolation-mode:bicubic;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\r\n" + 
        		"a {\r\n" + 
        		"    text-decoration: none;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: A work-around for email clients meddling in triggered links. */\r\n" + 
        		"*[x-apple-data-detectors],  /* iOS */\r\n" + 
        		".unstyle-auto-detected-links *,\r\n" + 
        		".aBn {\r\n" + 
        		"    border-bottom: 0 !important;\r\n" + 
        		"    cursor: default !important;\r\n" + 
        		"    color: inherit !important;\r\n" + 
        		"    text-decoration: none !important;\r\n" + 
        		"    font-size: inherit !important;\r\n" + 
        		"    font-family: inherit !important;\r\n" + 
        		"    font-weight: inherit !important;\r\n" + 
        		"    line-height: inherit !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\r\n" + 
        		".a6S {\r\n" + 
        		"    display: none !important;\r\n" + 
        		"    opacity: 0.01 !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Prevents Gmail from changing the text color in conversation threads. */\r\n" + 
        		".im {\r\n" + 
        		"    color: inherit !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* If the above doesn't work, add a .g-img class to any image in question. */\r\n" + 
        		"img.g-img + div {\r\n" + 
        		"    display: none !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\r\n" + 
        		"/* Create one of these media queries for each additional viewport size you'd like to fix */\r\n" + 
        		"\r\n" + 
        		"/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\r\n" + 
        		"@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
        		"    u ~ div .email-container {\r\n" + 
        		"        min-width: 320px !important;\r\n" + 
        		"    }\r\n" + 
        		"}\r\n" + 
        		"/* iPhone 6, 6S, 7, 8, and X */\r\n" + 
        		"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
        		"    u ~ div .email-container {\r\n" + 
        		"        min-width: 375px !important;\r\n" + 
        		"    }\r\n" + 
        		"}\r\n" + 
        		"/* iPhone 6+, 7+, and 8+ */\r\n" + 
        		"@media only screen and (min-device-width: 414px) {\r\n" + 
        		"    u ~ div .email-container {\r\n" + 
        		"        min-width: 414px !important;\r\n" + 
        		"    }\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"    </style>\r\n" + 
        		"\r\n" + 
        		"    <!-- CSS Reset : END -->\r\n" + 
        		"\r\n" + 
        		"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
        		"    <style>\r\n" + 
        		"\r\n" + 
        		"	    .primary{\r\n" + 
        		"	background: #ff8b00;\r\n" + 
        		"}\r\n" + 
        		".bg_white{\r\n" + 
        		"	background: #ffffff;\r\n" + 
        		"}\r\n" + 
        		".bg_light{\r\n" + 
        		"	background: #fafafa;\r\n" + 
        		"}\r\n" + 
        		".bg_black{\r\n" + 
        		"	background: #000000;\r\n" + 
        		"}\r\n" + 
        		".bg_dark{\r\n" + 
        		"	background: rgba(0,0,0,.8);\r\n" + 
        		"}\r\n" + 
        		".email-section{\r\n" + 
        		"	padding:2.5em;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*BUTTON*/\r\n" + 
        		".btn{\r\n" + 
        		"	padding: 5px 20px;\r\n" + 
        		"	display: inline-block;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-primary{\r\n" + 
        		"	border-radius: 5px;\r\n" + 
        		"	background: #ff8b00;\r\n" + 
        		"	color: #ffffff;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-white{\r\n" + 
        		"	border-radius: 5px;\r\n" + 
        		"	background: #ffffff;\r\n" + 
        		"	color: #000000;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-white-outline{\r\n" + 
        		"	border-radius: 5px;\r\n" + 
        		"	background: transparent;\r\n" + 
        		"	border: 1px solid #fff;\r\n" + 
        		"	color: #fff;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-black{\r\n" + 
        		"	border-radius: 0px;\r\n" + 
        		"	background: #000;\r\n" + 
        		"	color: #fff;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-black-outline{\r\n" + 
        		"	border-radius: 0px;\r\n" + 
        		"	background: transparent;\r\n" + 
        		"	border: 2px solid #000;\r\n" + 
        		"	color: #000;\r\n" + 
        		"	font-weight: 700;\r\n" + 
        		"}\r\n" + 
        		".btn.btn-custom{\r\n" + 
        		"	text-transform: uppercase;\r\n" + 
        		"	font-weight: 600;\r\n" + 
        		"	font-size: 12px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"h1,h2,h3,h4,h5,h6{\r\n" + 
        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
        		"	color: #000000;\r\n" + 
        		"	margin-top: 0;\r\n" + 
        		"	font-weight: 400;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"body{\r\n" + 
        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
        		"	font-weight: 400;\r\n" + 
        		"	font-size: 15px;\r\n" + 
        		"	line-height: 1.8;\r\n" + 
        		"	color: rgba(0,0,0,.5);\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"a{\r\n" + 
        		"	color: #ff8b00;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"p{\r\n" + 
        		"	margin-top: 0;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"table{\r\n" + 
        		"}\r\n" + 
        		"/*LOGO*/\r\n" + 
        		"\r\n" + 
        		".logo h1{\r\n" + 
        		"	margin: 0;\r\n" + 
        		"}\r\n" + 
        		".logo h1 a{\r\n" + 
        		"	color: #000000;\r\n" + 
        		"	font-size: 20px;\r\n" + 
        		"	font-weight: 700;\r\n" + 
        		"	/*text-transform: uppercase;*/\r\n" + 
        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".navigation{\r\n" + 
        		"	padding: 0;\r\n" + 
        		"	padding: 1em 0;\r\n" + 
        		"	/*background: rgba(0,0,0,1);*/\r\n" + 
        		"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
        		"	border-bottom: 1px solid rgba(0,0,0,.05);\r\n" + 
        		"	margin-bottom: 0;\r\n" + 
        		"}\r\n" + 
        		".navigation li{\r\n" + 
        		"	list-style: none;\r\n" + 
        		"	display: inline-block;;\r\n" + 
        		"	margin-left: 5px;\r\n" + 
        		"	margin-right: 5px;\r\n" + 
        		"	font-size: 14px;\r\n" + 
        		"	font-weight: 500;\r\n" + 
        		"}\r\n" + 
        		".navigation li a{\r\n" + 
        		"	color: rgba(0,0,0,1);\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*HERO*/\r\n" + 
        		".hero{\r\n" + 
        		"	position: relative;\r\n" + 
        		"	z-index: 0;\r\n" + 
        		"}\r\n" + 
        		".hero .overlay{\r\n" + 
        		"	position: absolute;\r\n" + 
        		"	top: 0;\r\n" + 
        		"	left: 0;\r\n" + 
        		"	right: 0;\r\n" + 
        		"	bottom: 0;\r\n" + 
        		"	content: '';\r\n" + 
        		"	width: 100%;\r\n" + 
        		"	background: #000000;\r\n" + 
        		"	z-index: -1;\r\n" + 
        		"	opacity: .2;\r\n" + 
        		"}\r\n" + 
        		".hero .text{\r\n" + 
        		"	color: rgba(255,255,255,.9);\r\n" + 
        		"	max-width: 50%;\r\n" + 
        		"	margin: 0 auto 0;\r\n" + 
        		"}\r\n" + 
        		".hero .text h2{\r\n" + 
        		"	color: #fff;\r\n" + 
        		"	font-size: 34px;\r\n" + 
        		"	margin-bottom: 0;\r\n" + 
        		"	font-weight: 400;\r\n" + 
        		"	line-height: 1.4;\r\n" + 
        		"}\r\n" + 
        		".hero .text h2 span{\r\n" + 
        		"	font-weight: 600;\r\n" + 
        		"	color: #ff8b00;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*INTRO*/\r\n" + 
        		".intro{\r\n" + 
        		"	position: relative;\r\n" + 
        		"	z-index: 0;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".intro .text{\r\n" + 
        		"	color: rgba(0,0,0,.3);\r\n" + 
        		"}\r\n" + 
        		".intro .text h2{\r\n" + 
        		"	color: #000;\r\n" + 
        		"	font-size: 34px;\r\n" + 
        		"	margin-bottom: 0;\r\n" + 
        		"	font-weight: 300;\r\n" + 
        		"}\r\n" + 
        		".intro .text h2 span{\r\n" + 
        		"	font-weight: 600;\r\n" + 
        		"	color: #ff8b00;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*SERVICES*/\r\n" + 
        		".services{\r\n" + 
        		"}\r\n" + 
        		".text-services{\r\n" + 
        		"	padding: 10px 10px 0; \r\n" + 
        		"	text-align: center;\r\n" + 
        		"}\r\n" + 
        		".text-services h3{\r\n" + 
        		"	font-size: 18px;\r\n" + 
        		"	font-weight: 400;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".services-list{\r\n" + 
        		"	margin: 0 0 20px 0;\r\n" + 
        		"	width: 100%;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".services-list img{\r\n" + 
        		"	float: left;\r\n" + 
        		"}\r\n" + 
        		".services-list h3{\r\n" + 
        		"	margin-top: 0;\r\n" + 
        		"	margin-bottom: 0;\r\n" + 
        		"}\r\n" + 
        		".services-list p{\r\n" + 
        		"	margin: 0;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"/*COUNTER*/\r\n" + 
        		".counter{\r\n" + 
        		"	width: 100%;\r\n" + 
        		"	position: relative;\r\n" + 
        		"	z-index: 0;\r\n" + 
        		"}\r\n" + 
        		".counter .overlay{\r\n" + 
        		"	position: absolute;\r\n" + 
        		"	top: 0;\r\n" + 
        		"	left: 0;\r\n" + 
        		"	right: 0;\r\n" + 
        		"	bottom: 0;\r\n" + 
        		"	content: '';\r\n" + 
        		"	width: 100%;\r\n" + 
        		"	background: #000000;\r\n" + 
        		"	z-index: -1;\r\n" + 
        		"	opacity: .3;\r\n" + 
        		"}\r\n" + 
        		".counter-text{\r\n" + 
        		"	text-align: center;\r\n" + 
        		"}\r\n" + 
        		".counter-text .num{\r\n" + 
        		"	display: block;\r\n" + 
        		"	color: #ffffff;\r\n" + 
        		"	font-size: 34px;\r\n" + 
        		"	font-weight: 700;\r\n" + 
        		"}\r\n" + 
        		".counter-text .name{\r\n" + 
        		"	display: block;\r\n" + 
        		"	color: rgba(255,255,255,.9);\r\n" + 
        		"	font-size: 13px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*TOPIC*/\r\n" + 
        		".topic{\r\n" + 
        		"	width: 100%;\r\n" + 
        		"	display: block;\r\n" + 
        		"	float: left;\r\n" + 
        		"	border-bottom: 1px solid rgba(0,0,0,.1);\r\n" + 
        		"	padding: 1.5em 0;\r\n" + 
        		"}\r\n" + 
        		".topic .img{\r\n" + 
        		"	width: 120px;\r\n" + 
        		"	float: left;\r\n" + 
        		"}\r\n" + 
        		".topic .text{\r\n" + 
        		"	width: calc(100% - 150px);\r\n" + 
        		"	padding-left: 20px;\r\n" + 
        		"	float: left;\r\n" + 
        		"}\r\n" + 
        		".topic .text h3{\r\n" + 
        		"	font-size: 20px;\r\n" + 
        		"	margin-bottom: 15px;\r\n" + 
        		"	line-height: 1.2;\r\n" + 
        		"}\r\n" + 
        		".topic .text .meta{\r\n" + 
        		"	margin-bottom: 10px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*HEADING SECTION*/\r\n" + 
        		".heading-section{\r\n" + 
        		"}\r\n" + 
        		".heading-section h2{\r\n" + 
        		"	color: #000000;\r\n" + 
        		"	font-size: 28px;\r\n" + 
        		"	margin-top: 0;\r\n" + 
        		"	line-height: 1.4;\r\n" + 
        		"	font-weight: 400;\r\n" + 
        		"}\r\n" + 
        		".heading-section .subheading{\r\n" + 
        		"	margin-bottom: 20px !important;\r\n" + 
        		"	display: inline-block;\r\n" + 
        		"	font-size: 13px;\r\n" + 
        		"	text-transform: uppercase;\r\n" + 
        		"	letter-spacing: 2px;\r\n" + 
        		"	color: rgba(0,0,0,.4);\r\n" + 
        		"	position: relative;\r\n" + 
        		"}\r\n" + 
        		".heading-section .subheading::after{\r\n" + 
        		"	position: absolute;\r\n" + 
        		"	left: 0;\r\n" + 
        		"	right: 0;\r\n" + 
        		"	bottom: -10px;\r\n" + 
        		"	content: '';\r\n" + 
        		"	width: 100%;\r\n" + 
        		"	height: 2px;\r\n" + 
        		"	background: #ff8b00;\r\n" + 
        		"	margin: 0 auto;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".heading-section-white{\r\n" + 
        		"	color: rgba(255,255,255,.8);\r\n" + 
        		"}\r\n" + 
        		".heading-section-white h2{\r\n" + 
        		"	font-family: \r\n" + 
        		"	line-height: 1;\r\n" + 
        		"	padding-bottom: 0;\r\n" + 
        		"}\r\n" + 
        		".heading-section-white h2{\r\n" + 
        		"	color: #ffffff;\r\n" + 
        		"}\r\n" + 
        		".heading-section-white .subheading{\r\n" + 
        		"	margin-bottom: 0;\r\n" + 
        		"	display: inline-block;\r\n" + 
        		"	font-size: 13px;\r\n" + 
        		"	text-transform: uppercase;\r\n" + 
        		"	letter-spacing: 2px;\r\n" + 
        		"	color: rgba(255,255,255,.4);\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"ul.social{\r\n" + 
        		"	padding: 0;\r\n" + 
        		"}\r\n" + 
        		"ul.social li{\r\n" + 
        		"	display: inline-block;\r\n" + 
        		"	margin-right: 10px;\r\n" + 
        		"	/*border: 1px solid #ff8b00;*/\r\n" + 
        		"	padding: 10px;\r\n" + 
        		"	border-radius: 50%;\r\n" + 
        		"	background: rgba(0,0,0,.05);\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/*FOOTER*/\r\n" + 
        		"\r\n" + 
        		".footer{\r\n" + 
        		"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
        		"	color: rgba(0,0,0,.5);\r\n" + 
        		"}\r\n" + 
        		".footer .heading{\r\n" + 
        		"	color: #000;\r\n" + 
        		"	font-size: 20px;\r\n" + 
        		"}\r\n" + 
        		".footer ul{\r\n" + 
        		"	margin: 0;\r\n" + 
        		"	padding: 0;\r\n" + 
        		"}\r\n" + 
        		".footer ul li{\r\n" + 
        		"	list-style: none;\r\n" + 
        		"	margin-bottom: 10px;\r\n" + 
        		"}\r\n" + 
        		".footer ul li a{\r\n" + 
        		"	color: rgba(0,0,0,1);\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"@media screen and (max-width: 500px) {\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"    </style>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"</head>\r\n" + 
        		"\r\n" + 
        		"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa;\">\r\n" + 
        		"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
        		"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
        		"    	<!-- BEGIN BODY -->\r\n" + 
        		"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
        		"      	<tbody><tr>\r\n" + 
        		"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
        		"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
        		"          		<tbody><tr>\r\n" + 
        		"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
        		"			            <h1><a href=\"http://AeneasExportingllc.com/\">Aeneas Exporting LLC</a></h1>\r\n" + 
        		"			          </td>\r\n" + 
        		"          		</tr>\r\n" + 
        		"          	</tbody></table>\r\n" + 
        		"          </td>\r\n" + 
        		"	      </tr><!-- end tr -->\r\n" + 
        		"	      <tr>\r\n" + 
        		"          <td valign=\"middle\" class=\"hero bg_white\" style=\"background-color: #555c61;box-shadow: 0px 3px 21px 5px grey;background-size:cover;height:263px;\">\r\n" + 
        		"          	<div class=\"overlay\"></div>\r\n" + 
        		"            <table>\r\n" + 
        		"            	<tbody><tr>\r\n" + 
        		"            		<td>\r\n" + 
        		"            			<div class=\"text\" style=\"padding: 0 4em; text-align: center;\">\r\n" + 
        		"\r\n" + 
        		"<p style=\"\r\n" + 
        		"    font-size: 26px;\r\n" + 
        		"    color: white;\r\n" + 
        		"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
        		"\">your New Password is: "+account+"</p>\r\n" + 
        		"            				\r\n" + 
        		"            				\r\n" + 
        		"            			</div>\r\n" + 
        		"            		</td>\r\n" + 
        		"            	</tr>\r\n" + 
        		"            </tbody></table>\r\n" + 
        		"          </td>\r\n" + 
        		"	      </tr><!-- end tr -->\r\n" + 
        		"	      <tr>\r\n" + 
        		"          <td class=\"bg_dark email-section\" style=\"text-align:center;\">\r\n" + 
        		"          	<div style=\" margin-top: 31px; \" class=\"heading-section heading-section-white\">\r\n" + 
        		"          		<span style=\"font-size: 25px;color: #8c7c0e;font-weight: 900;\" class=\"subheading\">Welcome</span>\r\n" + 
        		"            	<h2>Aeneas Exporting LLC</h2>\r\n" + 
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
        		"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
        		"      	<tbody><tr>\r\n" + 
        		"          <td valign=\"middle\" class=\"bg_light footer email-section\">\r\n" + 
        		"            <table>\r\n" + 
        		"            	<tbody><tr>\r\n" + 
        		"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
        		"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
        		"                    <tbody><tr>\r\n" + 
        		"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
        		"                      	<h3 class=\"heading\">About</h3>\r\n" + 
        		"                      	<p>Aeneas Exporting LLC®</p>\r\n" + 
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

        System.out.println("Email Sent To: "+name+" With Mail: "+mail);
        sendFromGMail( to, subject, htmlText);
        

}

	
	public static void sendEmailNewAccount(String name,String mail, String account) {
		
	        String[] to = {mail }; // list of recipient email addresses 
	        String subject = "Aeneas Exporting LLC";
	        String htmlText = "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
	        		"    <meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\r\n" + 
	        		"    <meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
	        		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
	        		"    <meta name=\"x-apple-disable-message-reformatting\">  <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
	        		"    <title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
	        		"\r\n" + 
	        		"    <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\r\n" + 
	        		"\r\n" + 
	        		"    <!-- CSS Reset : BEGIN -->\r\n" + 
	        		"    <style>\r\n" + 
	        		"\r\n" + 
	        		"        /* What it does: Remove spaces around the email design added by some email clients. */\r\n" + 
	        		"        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\r\n" + 
	        		"        html,\r\n" + 
	        		"body {\r\n" + 
	        		"    margin: 0 auto !important;\r\n" + 
	        		"    padding: 0 !important;\r\n" + 
	        		"    height: 100% !important;\r\n" + 
	        		"    width: 100% !important;\r\n" + 
	        		"    background: #f1f1f1;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Stops email clients resizing small text. */\r\n" + 
	        		"* {\r\n" + 
	        		"    -ms-text-size-adjust: 100%;\r\n" + 
	        		"    -webkit-text-size-adjust: 100%;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Centers email on Android 4.4 */\r\n" + 
	        		"div[style*=\"margin: 16px 0\"] {\r\n" + 
	        		"    margin: 0 !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Stops Outlook from adding extra spacing to tables. */\r\n" + 
	        		"table,\r\n" + 
	        		"td {\r\n" + 
	        		"    mso-table-lspace: 0pt !important;\r\n" + 
	        		"    mso-table-rspace: 0pt !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Fixes webkit padding issue. */\r\n" + 
	        		"table {\r\n" + 
	        		"    border-spacing: 0 !important;\r\n" + 
	        		"    border-collapse: collapse !important;\r\n" + 
	        		"    table-layout: fixed !important;\r\n" + 
	        		"    margin: 0 auto !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Uses a better rendering method when resizing images in IE. */\r\n" + 
	        		"img {\r\n" + 
	        		"    -ms-interpolation-mode:bicubic;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\r\n" + 
	        		"a {\r\n" + 
	        		"    text-decoration: none;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: A work-around for email clients meddling in triggered links. */\r\n" + 
	        		"*[x-apple-data-detectors],  /* iOS */\r\n" + 
	        		".unstyle-auto-detected-links *,\r\n" + 
	        		".aBn {\r\n" + 
	        		"    border-bottom: 0 !important;\r\n" + 
	        		"    cursor: default !important;\r\n" + 
	        		"    color: inherit !important;\r\n" + 
	        		"    text-decoration: none !important;\r\n" + 
	        		"    font-size: inherit !important;\r\n" + 
	        		"    font-family: inherit !important;\r\n" + 
	        		"    font-weight: inherit !important;\r\n" + 
	        		"    line-height: inherit !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\r\n" + 
	        		".a6S {\r\n" + 
	        		"    display: none !important;\r\n" + 
	        		"    opacity: 0.01 !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Prevents Gmail from changing the text color in conversation threads. */\r\n" + 
	        		".im {\r\n" + 
	        		"    color: inherit !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* If the above doesn't work, add a .g-img class to any image in question. */\r\n" + 
	        		"img.g-img + div {\r\n" + 
	        		"    display: none !important;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\r\n" + 
	        		"/* Create one of these media queries for each additional viewport size you'd like to fix */\r\n" + 
	        		"\r\n" + 
	        		"/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\r\n" + 
	        		"@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
	        		"    u ~ div .email-container {\r\n" + 
	        		"        min-width: 320px !important;\r\n" + 
	        		"    }\r\n" + 
	        		"}\r\n" + 
	        		"/* iPhone 6, 6S, 7, 8, and X */\r\n" + 
	        		"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
	        		"    u ~ div .email-container {\r\n" + 
	        		"        min-width: 375px !important;\r\n" + 
	        		"    }\r\n" + 
	        		"}\r\n" + 
	        		"/* iPhone 6+, 7+, and 8+ */\r\n" + 
	        		"@media only screen and (min-device-width: 414px) {\r\n" + 
	        		"    u ~ div .email-container {\r\n" + 
	        		"        min-width: 414px !important;\r\n" + 
	        		"    }\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"    </style>\r\n" + 
	        		"\r\n" + 
	        		"    <!-- CSS Reset : END -->\r\n" + 
	        		"\r\n" + 
	        		"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
	        		"    <style>\r\n" + 
	        		"\r\n" + 
	        		"	    .primary{\r\n" + 
	        		"	background: #ff8b00;\r\n" + 
	        		"}\r\n" + 
	        		".bg_white{\r\n" + 
	        		"	background: #ffffff;\r\n" + 
	        		"}\r\n" + 
	        		".bg_light{\r\n" + 
	        		"	background: #fafafa;\r\n" + 
	        		"}\r\n" + 
	        		".bg_black{\r\n" + 
	        		"	background: #000000;\r\n" + 
	        		"}\r\n" + 
	        		".bg_dark{\r\n" + 
	        		"	background: rgba(0,0,0,.8);\r\n" + 
	        		"}\r\n" + 
	        		".email-section{\r\n" + 
	        		"	padding:2.5em;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*BUTTON*/\r\n" + 
	        		".btn{\r\n" + 
	        		"	padding: 5px 20px;\r\n" + 
	        		"	display: inline-block;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-primary{\r\n" + 
	        		"	border-radius: 5px;\r\n" + 
	        		"	background: #ff8b00;\r\n" + 
	        		"	color: #ffffff;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-white{\r\n" + 
	        		"	border-radius: 5px;\r\n" + 
	        		"	background: #ffffff;\r\n" + 
	        		"	color: #000000;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-white-outline{\r\n" + 
	        		"	border-radius: 5px;\r\n" + 
	        		"	background: transparent;\r\n" + 
	        		"	border: 1px solid #fff;\r\n" + 
	        		"	color: #fff;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-black{\r\n" + 
	        		"	border-radius: 0px;\r\n" + 
	        		"	background: #000;\r\n" + 
	        		"	color: #fff;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-black-outline{\r\n" + 
	        		"	border-radius: 0px;\r\n" + 
	        		"	background: transparent;\r\n" + 
	        		"	border: 2px solid #000;\r\n" + 
	        		"	color: #000;\r\n" + 
	        		"	font-weight: 700;\r\n" + 
	        		"}\r\n" + 
	        		".btn.btn-custom{\r\n" + 
	        		"	text-transform: uppercase;\r\n" + 
	        		"	font-weight: 600;\r\n" + 
	        		"	font-size: 12px;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"h1,h2,h3,h4,h5,h6{\r\n" + 
	        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
	        		"	color: #000000;\r\n" + 
	        		"	margin-top: 0;\r\n" + 
	        		"	font-weight: 400;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"body{\r\n" + 
	        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
	        		"	font-weight: 400;\r\n" + 
	        		"	font-size: 15px;\r\n" + 
	        		"	line-height: 1.8;\r\n" + 
	        		"	color: rgba(0,0,0,.5);\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"a{\r\n" + 
	        		"	color: #ff8b00;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"p{\r\n" + 
	        		"	margin-top: 0;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"table{\r\n" + 
	        		"}\r\n" + 
	        		"/*LOGO*/\r\n" + 
	        		"\r\n" + 
	        		".logo h1{\r\n" + 
	        		"	margin: 0;\r\n" + 
	        		"}\r\n" + 
	        		".logo h1 a{\r\n" + 
	        		"	color: #000000;\r\n" + 
	        		"	font-size: 20px;\r\n" + 
	        		"	font-weight: 700;\r\n" + 
	        		"	/*text-transform: uppercase;*/\r\n" + 
	        		"	font-family: 'Work Sans', sans-serif;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		".navigation{\r\n" + 
	        		"	padding: 0;\r\n" + 
	        		"	padding: 1em 0;\r\n" + 
	        		"	/*background: rgba(0,0,0,1);*/\r\n" + 
	        		"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
	        		"	border-bottom: 1px solid rgba(0,0,0,.05);\r\n" + 
	        		"	margin-bottom: 0;\r\n" + 
	        		"}\r\n" + 
	        		".navigation li{\r\n" + 
	        		"	list-style: none;\r\n" + 
	        		"	display: inline-block;;\r\n" + 
	        		"	margin-left: 5px;\r\n" + 
	        		"	margin-right: 5px;\r\n" + 
	        		"	font-size: 14px;\r\n" + 
	        		"	font-weight: 500;\r\n" + 
	        		"}\r\n" + 
	        		".navigation li a{\r\n" + 
	        		"	color: rgba(0,0,0,1);\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*HERO*/\r\n" + 
	        		".hero{\r\n" + 
	        		"	position: relative;\r\n" + 
	        		"	z-index: 0;\r\n" + 
	        		"}\r\n" + 
	        		".hero .overlay{\r\n" + 
	        		"	position: absolute;\r\n" + 
	        		"	top: 0;\r\n" + 
	        		"	left: 0;\r\n" + 
	        		"	right: 0;\r\n" + 
	        		"	bottom: 0;\r\n" + 
	        		"	content: '';\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"	background: #000000;\r\n" + 
	        		"	z-index: -1;\r\n" + 
	        		"	opacity: .2;\r\n" + 
	        		"}\r\n" + 
	        		".hero .text{\r\n" + 
	        		"	color: rgba(255,255,255,.9);\r\n" + 
	        		"	max-width: 50%;\r\n" + 
	        		"	margin: 0 auto 0;\r\n" + 
	        		"}\r\n" + 
	        		".hero .text h2{\r\n" + 
	        		"	color: #fff;\r\n" + 
	        		"	font-size: 34px;\r\n" + 
	        		"	margin-bottom: 0;\r\n" + 
	        		"	font-weight: 400;\r\n" + 
	        		"	line-height: 1.4;\r\n" + 
	        		"}\r\n" + 
	        		".hero .text h2 span{\r\n" + 
	        		"	font-weight: 600;\r\n" + 
	        		"	color: #ff8b00;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*INTRO*/\r\n" + 
	        		".intro{\r\n" + 
	        		"	position: relative;\r\n" + 
	        		"	z-index: 0;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		".intro .text{\r\n" + 
	        		"	color: rgba(0,0,0,.3);\r\n" + 
	        		"}\r\n" + 
	        		".intro .text h2{\r\n" + 
	        		"	color: #000;\r\n" + 
	        		"	font-size: 34px;\r\n" + 
	        		"	margin-bottom: 0;\r\n" + 
	        		"	font-weight: 300;\r\n" + 
	        		"}\r\n" + 
	        		".intro .text h2 span{\r\n" + 
	        		"	font-weight: 600;\r\n" + 
	        		"	color: #ff8b00;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*SERVICES*/\r\n" + 
	        		".services{\r\n" + 
	        		"}\r\n" + 
	        		".text-services{\r\n" + 
	        		"	padding: 10px 10px 0; \r\n" + 
	        		"	text-align: center;\r\n" + 
	        		"}\r\n" + 
	        		".text-services h3{\r\n" + 
	        		"	font-size: 18px;\r\n" + 
	        		"	font-weight: 400;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		".services-list{\r\n" + 
	        		"	margin: 0 0 20px 0;\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		".services-list img{\r\n" + 
	        		"	float: left;\r\n" + 
	        		"}\r\n" + 
	        		".services-list h3{\r\n" + 
	        		"	margin-top: 0;\r\n" + 
	        		"	margin-bottom: 0;\r\n" + 
	        		"}\r\n" + 
	        		".services-list p{\r\n" + 
	        		"	margin: 0;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"/*COUNTER*/\r\n" + 
	        		".counter{\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"	position: relative;\r\n" + 
	        		"	z-index: 0;\r\n" + 
	        		"}\r\n" + 
	        		".counter .overlay{\r\n" + 
	        		"	position: absolute;\r\n" + 
	        		"	top: 0;\r\n" + 
	        		"	left: 0;\r\n" + 
	        		"	right: 0;\r\n" + 
	        		"	bottom: 0;\r\n" + 
	        		"	content: '';\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"	background: #000000;\r\n" + 
	        		"	z-index: -1;\r\n" + 
	        		"	opacity: .3;\r\n" + 
	        		"}\r\n" + 
	        		".counter-text{\r\n" + 
	        		"	text-align: center;\r\n" + 
	        		"}\r\n" + 
	        		".counter-text .num{\r\n" + 
	        		"	display: block;\r\n" + 
	        		"	color: #ffffff;\r\n" + 
	        		"	font-size: 34px;\r\n" + 
	        		"	font-weight: 700;\r\n" + 
	        		"}\r\n" + 
	        		".counter-text .name{\r\n" + 
	        		"	display: block;\r\n" + 
	        		"	color: rgba(255,255,255,.9);\r\n" + 
	        		"	font-size: 13px;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*TOPIC*/\r\n" + 
	        		".topic{\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"	display: block;\r\n" + 
	        		"	float: left;\r\n" + 
	        		"	border-bottom: 1px solid rgba(0,0,0,.1);\r\n" + 
	        		"	padding: 1.5em 0;\r\n" + 
	        		"}\r\n" + 
	        		".topic .img{\r\n" + 
	        		"	width: 120px;\r\n" + 
	        		"	float: left;\r\n" + 
	        		"}\r\n" + 
	        		".topic .text{\r\n" + 
	        		"	width: calc(100% - 150px);\r\n" + 
	        		"	padding-left: 20px;\r\n" + 
	        		"	float: left;\r\n" + 
	        		"}\r\n" + 
	        		".topic .text h3{\r\n" + 
	        		"	font-size: 20px;\r\n" + 
	        		"	margin-bottom: 15px;\r\n" + 
	        		"	line-height: 1.2;\r\n" + 
	        		"}\r\n" + 
	        		".topic .text .meta{\r\n" + 
	        		"	margin-bottom: 10px;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*HEADING SECTION*/\r\n" + 
	        		".heading-section{\r\n" + 
	        		"}\r\n" + 
	        		".heading-section h2{\r\n" + 
	        		"	color: #000000;\r\n" + 
	        		"	font-size: 28px;\r\n" + 
	        		"	margin-top: 0;\r\n" + 
	        		"	line-height: 1.4;\r\n" + 
	        		"	font-weight: 400;\r\n" + 
	        		"}\r\n" + 
	        		".heading-section .subheading{\r\n" + 
	        		"	margin-bottom: 20px !important;\r\n" + 
	        		"	display: inline-block;\r\n" + 
	        		"	font-size: 13px;\r\n" + 
	        		"	text-transform: uppercase;\r\n" + 
	        		"	letter-spacing: 2px;\r\n" + 
	        		"	color: rgba(0,0,0,.4);\r\n" + 
	        		"	position: relative;\r\n" + 
	        		"}\r\n" + 
	        		".heading-section .subheading::after{\r\n" + 
	        		"	position: absolute;\r\n" + 
	        		"	left: 0;\r\n" + 
	        		"	right: 0;\r\n" + 
	        		"	bottom: -10px;\r\n" + 
	        		"	content: '';\r\n" + 
	        		"	width: 100%;\r\n" + 
	        		"	height: 2px;\r\n" + 
	        		"	background: #ff8b00;\r\n" + 
	        		"	margin: 0 auto;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		".heading-section-white{\r\n" + 
	        		"	color: rgba(255,255,255,.8);\r\n" + 
	        		"}\r\n" + 
	        		".heading-section-white h2{\r\n" + 
	        		"	font-family: \r\n" + 
	        		"	line-height: 1;\r\n" + 
	        		"	padding-bottom: 0;\r\n" + 
	        		"}\r\n" + 
	        		".heading-section-white h2{\r\n" + 
	        		"	color: #ffffff;\r\n" + 
	        		"}\r\n" + 
	        		".heading-section-white .subheading{\r\n" + 
	        		"	margin-bottom: 0;\r\n" + 
	        		"	display: inline-block;\r\n" + 
	        		"	font-size: 13px;\r\n" + 
	        		"	text-transform: uppercase;\r\n" + 
	        		"	letter-spacing: 2px;\r\n" + 
	        		"	color: rgba(255,255,255,.4);\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"ul.social{\r\n" + 
	        		"	padding: 0;\r\n" + 
	        		"}\r\n" + 
	        		"ul.social li{\r\n" + 
	        		"	display: inline-block;\r\n" + 
	        		"	margin-right: 10px;\r\n" + 
	        		"	/*border: 1px solid #ff8b00;*/\r\n" + 
	        		"	padding: 10px;\r\n" + 
	        		"	border-radius: 50%;\r\n" + 
	        		"	background: rgba(0,0,0,.05);\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"/*FOOTER*/\r\n" + 
	        		"\r\n" + 
	        		".footer{\r\n" + 
	        		"	border-top: 1px solid rgba(0,0,0,.05);\r\n" + 
	        		"	color: rgba(0,0,0,.5);\r\n" + 
	        		"}\r\n" + 
	        		".footer .heading{\r\n" + 
	        		"	color: #000;\r\n" + 
	        		"	font-size: 20px;\r\n" + 
	        		"}\r\n" + 
	        		".footer ul{\r\n" + 
	        		"	margin: 0;\r\n" + 
	        		"	padding: 0;\r\n" + 
	        		"}\r\n" + 
	        		".footer ul li{\r\n" + 
	        		"	list-style: none;\r\n" + 
	        		"	margin-bottom: 10px;\r\n" + 
	        		"}\r\n" + 
	        		".footer ul li a{\r\n" + 
	        		"	color: rgba(0,0,0,1);\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"@media screen and (max-width: 500px) {\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"    </style>\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"</head>\r\n" + 
	        		"\r\n" + 
	        		"<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #fafafa;\">\r\n" + 
	        		"	<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" + 
	        		"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
	        		"    	<!-- BEGIN BODY -->\r\n" + 
	        		"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
	        		"      	<tbody><tr>\r\n" + 
	        		"          <td valign=\"top\" class=\"bg_light\" style=\"padding: .5em 2.5em 1em 2.5em;\">\r\n" + 
	        		"          	<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	        		"          		<tbody><tr>\r\n" + 
	        		"          			<td class=\"logo\" style=\"text-align: center;\">\r\n" + 
	        		"			            <h1><a href=\"http://AeneasExportingllc.com/\">Aeneas Exporting LLC</a></h1>\r\n" + 
	        		"			          </td>\r\n" + 
	        		"          		</tr>\r\n" + 
	        		"          	</tbody></table>\r\n" + 
	        		"          </td>\r\n" + 
	        		"	      </tr><!-- end tr -->\r\n" + 
	        		"	      <tr>\r\n" + 
	        		"          <td valign=\"middle\" class=\"hero bg_white\" style=\"background-color: #555c61;box-shadow: 0px 3px 21px 5px grey;background-size:cover;height:263px;\">\r\n" + 
	        		"          	<div class=\"overlay\"></div>\r\n" + 
	        		"            <table>\r\n" + 
	        		"            	<tbody><tr>\r\n" + 
	        		"            		<td>\r\n" + 
	        		"            			<div class=\"text\" style=\"padding: 0 4em; text-align: center;\">\r\n" + 
	        		"\r\n" + 
	        		"<p style=\"\r\n" + 
	        		"    font-size: 26px;\r\n" + 
	        		"    color: white;\r\n" + 
	        		"    text-shadow: 1px 1px 2px black, 0 0 25px white, 0 0 5px #cacaca;\r\n" + 
	        		"\">your Username and Password is: "+account+"</p>\r\n" + 
	        		"            				\r\n" + 
	        		"            				\r\n" + 
	        		"            			</div>\r\n" + 
	        		"            		</td>\r\n" + 
	        		"            	</tr>\r\n" + 
	        		"            </tbody></table>\r\n" + 
	        		"          </td>\r\n" + 
	        		"	      </tr><!-- end tr -->\r\n" + 
	        		"	      <tr>\r\n" + 
	        		"          <td class=\"bg_dark email-section\" style=\"text-align:center;\">\r\n" + 
	        		"          	<div style=\" margin-top: 31px; \" class=\"heading-section heading-section-white\">\r\n" + 
	        		"          		<span style=\"font-size: 25px;color: #8c7c0e;font-weight: 900;\" class=\"subheading\">Welcome</span>\r\n" + 
	        		"            	<h2>Aeneas Exporting LLC</h2>\r\n" + 
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
	        		"      <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">\r\n" + 
	        		"      	<tbody><tr>\r\n" + 
	        		"          <td valign=\"middle\" class=\"bg_light footer email-section\">\r\n" + 
	        		"            <table>\r\n" + 
	        		"            	<tbody><tr>\r\n" + 
	        		"                <td valign=\"top\" width=\"33.333%\" style=\"padding-top: 20px;\">\r\n" + 
	        		"                  <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
	        		"                    <tbody><tr>\r\n" + 
	        		"                      <td style=\"text-align: left; padding-right: 10px;\">\r\n" + 
	        		"                      	<h3 class=\"heading\">About</h3>\r\n" + 
	        		"                      	<p>Aeneas Exporting LLC®</p>\r\n" + 
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

	        System.out.println("Email Sent To: "+name+" With Mail: "+mail);
	        sendFromGMail( to, subject, htmlText);
	        
	
	}

	private static void sendFromGMail( final String[] to, final String subject, final String body) {
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
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
	 
}
