package main.com.carService.invoice;

import java.util.List;

import main.com.carService.invoiceCars.invoiceCar;

public class invoiceDTO {

	private invoice invoice;
	
	private List<invoiceCar> carsForInvoice;

	private int totalPrice;
	
	private int numberOfCars;
	
	public invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(invoice invoice) {
		this.invoice = invoice;
	}

	public List<invoiceCar> getCarsForInvoice() {
		return carsForInvoice;
	}

	public void setCarsForInvoice(List<invoiceCar> carsForInvoice) {
		this.carsForInvoice = carsForInvoice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
	
	
	
}
