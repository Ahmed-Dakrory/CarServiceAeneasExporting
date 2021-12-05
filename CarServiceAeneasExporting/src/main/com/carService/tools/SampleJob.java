package main.com.carService.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.com.carService.car.car;
import main.com.carService.car.carRepository;
import main.com.carService.consignee.consignee;
import main.com.carService.consignee.consigneeRepository;
import main.com.carService.customer.customer;
import main.com.carService.customer.customerRepository;
import main.com.carService.mainTwo.mainTwo;
import main.com.carService.mainTwo.mainTwoRepository;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperRepository;
import main.com.carService.vendor.vendor;
import main.com.carService.vendor.vendorRepository;

@Component
public class SampleJob
{
	


	@Autowired
	carRepository carDataRepository;
	
	@Autowired
	shipperRepository shippeDataRepository;

	@Autowired
	vendorRepository vendorDataRepository;
	
	@Autowired
	consigneeRepository consigneeDataRepository;

	@Autowired
	customerRepository customerDataRepository;
	
	@Autowired
	mainTwoRepository mainTwoDataRepository;
	
	public void run() {
	      List<car> allCars=carDataRepository.getAllWithAllowSendState(true);
	      for(int i=0;i<allCars.size();i++) {
	    	  car selectedCar = allCars.get(i);
	    	  
	    	  if(selectedCar.getEmailToSendComment()!=null) {
	    		 if(!selectedCar.getEmailToSendComment().equalsIgnoreCase("")) {
			    	  String[] AllEmails = selectedCar.getEmailToSendComment().split(";");
			    	  for(int j=0;j<AllEmails.length;j++) {
			    		  String sentEmail= AllEmails[j];
			    		  //System.out.println("Ahmed Dakrory: "+sentEmail);
			    		  Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar, selectedCar.getCommentToSend(), sentEmail);
			    	  }
	    		  }
	    	  }
	    	  
	    	  sendUpdateToAll(selectedCar);
	      }
			//System.out.println("Hello Quartz!: "+allCars.size());	
	   }
	
private void sendUpdateToAll(car selectedCar2) {
		
		shipper shipperObject =selectedCar2.getShipperId();
		shipper shipperIdMail =null;
		if(shipperObject!=null) {
			Integer shipperId = shipperObject.getId();
			shipperIdMail=shippeDataRepository.getById(shipperId);
		}
		
		
		
		vendor vendorObject =selectedCar2.getVendorId();
		vendor vendorIdMail =null;
		if(vendorObject!=null) {
			Integer vendorId = vendorObject.getId();
			vendorIdMail=vendorDataRepository.getById(vendorId);
		}
		
		
		consignee consigneeObject=selectedCar2.getConsigneeId();
		consignee consigneeIdMail =null;
		if(consigneeObject!=null) {
			Integer consigneeId = consigneeObject.getId();
			consigneeIdMail=consigneeDataRepository.getById(consigneeId);
		}
		
		
		
		customer customerObject=selectedCar2.getCustomerId();
		customer customerIdMail =null;
		if(customerObject!=null) {
			Integer customerId = customerObject.getId();
			customerIdMail=customerDataRepository.getById(customerId);
		}
		
		
		
		mainTwo mainTwoObject = selectedCar2.getMainTwoId();
		mainTwo mainTwoIdMail =null;
		if(mainTwoObject!=null) {
			Integer mainTwoId = mainTwoObject.getId();
			mainTwoIdMail=mainTwoDataRepository.getById(mainTwoId);
		}
		
		if(mainTwoIdMail!=null)
			Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar2, selectedCar2.getCommentToSend(), mainTwoIdMail.getUserId().getEmail());
		
		
		if(shipperIdMail!=null)
			Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar2, selectedCar2.getCommentToSend(), shipperIdMail.getUserId().getEmail());
		
		
		
		if(vendorIdMail!=null)
			Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar2, selectedCar2.getCommentToSend(), vendorIdMail.getUserId().getEmail());
		
		if(consigneeIdMail!=null)
			Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar2, selectedCar2.getCommentToSend(), consigneeIdMail.getUserId().getEmail());
		
		if(customerIdMail!=null)
			Constants.sendEmailNotificationForThisEmailWithMessage(selectedCar2, selectedCar2.getCommentToSend(), customerIdMail.getUserId().getEmail());
	}

	





	public shipperRepository getShippeDataRepository() {
	return shippeDataRepository;
}

public void setShippeDataRepository(shipperRepository shippeDataRepository) {
	this.shippeDataRepository = shippeDataRepository;
}

public vendorRepository getVendorDataRepository() {
	return vendorDataRepository;
}

public void setVendorDataRepository(vendorRepository vendorDataRepository) {
	this.vendorDataRepository = vendorDataRepository;
}

public consigneeRepository getConsigneeDataRepository() {
	return consigneeDataRepository;
}

public void setConsigneeDataRepository(consigneeRepository consigneeDataRepository) {
	this.consigneeDataRepository = consigneeDataRepository;
}

public customerRepository getCustomerDataRepository() {
	return customerDataRepository;
}

public void setCustomerDataRepository(customerRepository customerDataRepository) {
	this.customerDataRepository = customerDataRepository;
}

public mainTwoRepository getMainTwoDataRepository() {
	return mainTwoDataRepository;
}

public void setMainTwoDataRepository(mainTwoRepository mainTwoDataRepository) {
	this.mainTwoDataRepository = mainTwoDataRepository;
}

	public carRepository getCarDataRepository() {
		return carDataRepository;
	}



	public void setCarDataRepository(carRepository carDataRepository) {
		this.carDataRepository = carDataRepository;
	}




	
	
	
}