package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.com.carService.costCalc.transportfee;
import main.com.carService.costCalc.transportfeeAppServiceImpl;


@ManagedBean(name = "calcBean")
@SessionScoped
public class calcBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	@ManagedProperty(value = "#{transportfeeFacadeImpl}")
	private transportfeeAppServiceImpl transportfeeFacade;
	
	

	private List<transportfee> allLocation;
	private List<transportfee> allCity;
	private List<transportfee> allState;
	
	private transportfee selectedTansportFees;

	private String selectedLocation;
	private String selectedCity;
	private String selectedState;
	
	private int carSize;
	private String carPrice;
	
	private int portType;
	
	private double copartFees;
	private double onlineFees;
	private double GateFees=59;
	private double ourFees=100;
	private double seaFees;
	private double landFees;
	private double totalFees;
	
	public static double onlineBid[]= {	39,  39,  39,  39,  49,  49,  49,  49,  49,  49,
			69,  69,  69,  69,  79,  79,  79,  79,  89,  89,
			89,  89,  99,  99,  99,  99, 119, 129, 129,   0,
			 0,   0,   0,   0,	 0};



	public static int getLevel(double price) {
	
	int level = 0;
	if(price >= 1.00 && price <= 349.99) {
	level = 0;
	}else if(price >= 350.00 && price <= 399.99) {
	level = 1;
	}else if(price >= 400.00 && price <= 449.99) {
	level = 2;
	}else if(price >= 450.00 && price <= 499.99) {
	level = 3;
	}else if(price >= 500.00 && price <= 549.99) {
	level = 4;
	}else if(price >= 550.00 && price <= 599.99) {
	level = 5;
	}else if(price >= 600.00 && price <= 699.99) {
	level = 6;
	}else if(price >= 700.00 && price <= 799.99) {
	level = 7;
	}else if(price >= 800.00 && price <= 899.99) {
	level = 8;
	}else if(price >= 900.00 && price <= 999.99) {
	level = 9;
	}else if(price >= 1000.00 && price <= 1199.99) {
	level = 10;
	}else if(price >= 1200.00 && price <= 1299.99) {
	level = 11;
	}else if(price >= 1300.00 && price <= 1399.99) {
	level = 12;
	}else if(price >= 1400.00 && price <= 1499.99) {
	level = 13;
	}else if(price >= 1500.00 && price <= 1599.99) {
	level = 14;
	}else if(price >= 1600.00 && price <= 1699.99) {
	level = 15;
	}else if(price >= 1700.00 && price <= 1799.99) {
	level = 16;
	}else if(price >= 1800.00 && price <= 1999.99) {
	level = 17;
	}else if(price >= 2000.00 && price <= 2399.99) {
	level = 18;
	}else if(price >= 2400.00 && price <= 2499.99) {
	level = 19;
	}else if(price >= 2500.00 && price <= 2999.99) {
	level = 20;
	}else if(price >= 3000.00 && price <= 3499.99) {
	level = 21;
	}else if(price >= 3500.00 && price <= 3999.99) {
	level = 22;
	}else if(price >= 4000.00 && price <= 4499.99) {
	level = 23;
	}else if(price >= 4500.00 && price <= 4999.99) {
	level = 24;
	}else if(price >= 5000.00 && price <= 5999.99) {
	level = 25;
	}else if(price >= 6000.00 && price <= 7499.99) {
	level = 26;
	}else if(price >= 7500.00 && price <= 9999.99) {
	level = 27;
	}else if(price >= 10000.00 && price <= 14999.99) {
	level = 28;
	}else if(price >= 15000.00 && price <= 19999.99) {
	level = 29;
	}else if(price >= 20000.00 && price <= 24999.99) {
	level = 30;
	}else if(price >= 25000.00 && price <= 29999.99) {
	level = 31;
	}else if(price >= 30000.00 && price <= 34999.99) {
	level = 32;
	}else if(price >= 35000.00 && price <= 10000000.00) {
	level = 33;
	}else if(price == -1) {
	level = 34;
	}

	return level;
	}


	public static double CalculateCopart(int level,double price) {

double copFees=0;

if(level == 0) {
copFees=75.00;
}else if(level == 1) {
copFees=75.00;
}else if(level == 2) {
copFees=110.00;
}else if(level == 3) {
copFees=110.00;
}else if(level == 4) {
copFees=125.00;
}else if(level == 5) {
copFees=130.00;
}else if(level == 6) {
copFees=140.00;
}else if(level == 7) {
copFees=155.00;
}else if(level == 8) {
copFees=170.00;
}else if(level == 9) {
copFees=185.00;
}else if(level == 10) {
copFees=200.00;
}else if(level == 11) {
copFees=225.00;
}else if(level == 12) {
copFees=240.00;
}else if(level == 13) {
copFees=275.00;
}else if(level == 14) {
copFees=300.00;
}else if(level == 15) {
copFees=300.00;
}else if(level == 16) {
copFees=300.00;
}else if(level == 17) {
copFees=300.00;
}else if(level == 18) {
copFees=350.00;
}else if(level == 19) {
copFees=375.00;
}else if(level == 20) {
copFees=400.00;
}else if(level == 21) {
copFees=450.00;
}else if(level == 22) {
copFees=475.00;
}else if(level == 23) {
copFees=500.00;
}else if(level == 24) {
copFees=565.00;
}else if(level == 25) {
copFees=600.00;
}else if(level == 26) {
copFees=625.00;
}else if(level == 27) {
copFees=650.00;
}else if(level == 28) {
copFees=675.00;
}else if(level == 29) {
copFees = 0.04 * price;
}else if(level == 30) {
copFees = 0.04 * price;
}else if(level == 31) {
copFees = 0.04 * price;
}else if(level == 32) {
copFees = 0.04 * price;
}else if(level == 33) {
copFees = 0.04 * price;
}else if(level == 34) {
copFees = 0.20 * price;
}

return copFees;
}

	@PostConstruct
	public void init() {
		
		refresh();
		
		
	}
	
	public void refresh(){
		allLocation = transportfeeFacade.getAllGroupsOfLocation();
		allCity=new ArrayList<transportfee>();
		allState=new ArrayList<transportfee>();
		selectedLocation=allLocation.get(0).getLocation();
		
		refreshCityList();
		selectedCity=allCity.get(0).getCity();
		
		refreshStateList();
	}

	public void refreshCityList() {

		allCity = transportfeeFacade.getAllGroupsOfCityWithLocation(selectedLocation);
		if(allCity!=null) {
				allState = transportfeeFacade.getAllGroupsOfstateWithCity(allCity.get(0).getCity());
		}
	}
	
	public void refreshStateList() {

		allState = transportfeeFacade.getAllGroupsOfstateWithCity(selectedCity);

	}
	public void calcValueOfTotalFees() {
		

		
		selectedTansportFees=transportfeeFacade.getWithSpecs(selectedLocation, selectedCity, selectedState);

		if(selectedTansportFees!=null) {
			double price=Double.parseDouble(carPrice);
			int level=getLevel(price);
			copartFees=CalculateCopart(level, price);
			onlineFees=onlineBid[level];
			seaFees=0;
			if(carSize==0) {
				seaFees=selectedTansportFees.getLowCost();
			}else {
				seaFees=selectedTansportFees.getHighCost();
			}
			
			landFees=0;
			
			if(portType==0) {
				landFees=selectedTansportFees.getNjPortCost();
			}else if(portType==1) {
				landFees=selectedTansportFees.getGaPortCost();
			}else if(portType==2) {
				landFees=selectedTansportFees.getTxPortCost();
			}else if(portType==3) {
				landFees=selectedTansportFees.getCaPortCost();
			}

			totalFees=copartFees+onlineFees+GateFees+seaFees+landFees+ourFees;
			
		}
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/public/carCostResult.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public transportfeeAppServiceImpl getTransportfeeFacade() {
		return transportfeeFacade;
	}

	public void setTransportfeeFacade(transportfeeAppServiceImpl transportfeeFacade) {
		this.transportfeeFacade = transportfeeFacade;
	}

	public List<transportfee> getAllLocation() {
		return allLocation;
	}

	public void setAllLocation(List<transportfee> allLocation) {
		this.allLocation = allLocation;
	}

	public List<transportfee> getAllCity() {
		return allCity;
	}

	public void setAllCity(List<transportfee> allCity) {
		this.allCity = allCity;
	}

	public List<transportfee> getAllState() {
		return allState;
	}

	public void setAllState(List<transportfee> allState) {
		this.allState = allState;
	}

	public transportfee getSelectedTansportFees() {
		return selectedTansportFees;
	}

	public void setSelectedTansportFees(transportfee selectedTansportFees) {
		this.selectedTansportFees = selectedTansportFees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSelectedLocation() {
		return selectedLocation;
	}

	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public String getSelectedState() {
		return selectedState;
	}

	public void setSelectedState(String selectedState) {
		this.selectedState = selectedState;
	}

	public int getCarSize() {
		return carSize;
	}

	public void setCarSize(int carSize) {
		this.carSize = carSize;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}


	public int getPortType() {
		return portType;
	}


	public void setPortType(int portType) {
		this.portType = portType;
	}


	public double getCopartFees() {
		return copartFees;
	}


	public void setCopartFees(double copartFees) {
		this.copartFees = copartFees;
	}


	public double getOnlineFees() {
		return onlineFees;
	}


	public void setOnlineFees(double onlineFees) {
		this.onlineFees = onlineFees;
	}


	public double getGateFees() {
		return GateFees;
	}


	public void setGateFees(double gateFees) {
		GateFees = gateFees;
	}


	public double getOurFees() {
		return ourFees;
	}


	public void setOurFees(double ourFees) {
		this.ourFees = ourFees;
	}


	public double getSeaFees() {
		return seaFees;
	}


	public void setSeaFees(double seaFees) {
		this.seaFees = seaFees;
	}


	public double getLandFees() {
		return landFees;
	}


	public void setLandFees(double landFees) {
		this.landFees = landFees;
	}


	public double getTotalFees() {
		return totalFees;
	}


	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}


	public static double[] getOnlineBid() {
		return onlineBid;
	}


	public static void setOnlineBid(double[] onlineBid) {
		calcBean.onlineBid = onlineBid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
