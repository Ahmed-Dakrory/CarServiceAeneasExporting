package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import main.com.carService.loginNeeds.user;
import main.com.carService.quote.quote;
import main.com.carService.quote.quoteAppServiceImpl;
import main.com.carService.shipper.shipper;
import main.com.carService.shipper.shipperAppServiceImpl;
import main.com.carService.tools.Constants;
import main.com.carService.vendor.vendor;
import main.com.carService.vendor.vendorAppServiceImpl;


@ManagedBean(name = "quoteBean")
@SessionScoped
public class quoteBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	
	@ManagedProperty(value = "#{shipperFacadeImpl}")
	private shipperAppServiceImpl shipperFacade;
	
	
	@ManagedProperty(value = "#{quoteFacadeImpl}")
	private quoteAppServiceImpl quoteFacade;
	
	@ManagedProperty(value = "#{vendorFacadeImpl}")
	private vendorAppServiceImpl vendorFacade;
	 


	private shipper shipperOfThisAccount;
	private vendor vendorOfThisAccount;
	
	private List<quote> allQuotes;
	

	private quote newQuote;

	private quote editQuote;
	
	

	private  String dateOfShipment;
	private Integer dimSelection=0;
	private Integer moveTypeSelection=0;
	private Integer piecesSelection=1;
	private Integer commoditySelection=0;
	private Integer modeSelection=0;
	private Integer loadTypeSelection=0;
	private boolean marineInsuranceSelection=false;
	private Integer countryfromSelection=0;
	private Integer countrytoSelection=0;
	private Integer statefromSelection=0;
	private Integer statetoSelection=0;
	private Integer portfromSelection=0;
	private Integer porttoSelection=0;
	
	private Map<Integer, String> origineMap;
	
	@PostConstruct
	public void init() {
		
		refresh();
		origineMap=new LinkedHashMap<Integer,String>();
		fillMap();
		
	}
	public void fillMap() {
		
		fillMap3();
	}
	
	void fillMap3() {
		origineMap.put(-1, "--SELECT--");
		origineMap.put(60, "BIRMINGHAM, AL");
		origineMap.put(61, "HUNTSVILLE, AL");
		origineMap.put(57, "MOBILE, AL");
		origineMap.put(501, "Tuscumbia , AL");
	}
	
	
	public String getTheOrigin(Integer codeCountry) {
		String country=origineMap.get(codeCountry);
		
		return country;
		
	}
	public void refresh(){
		dateOfShipment="";
		newQuote =new quote();
		editQuote =new quote();
		dimSelection=0;
		moveTypeSelection=0;
		piecesSelection=1;
		commoditySelection=0;
		modeSelection=0;
		loadTypeSelection=0;
		marineInsuranceSelection=false;
		countryfromSelection=0;
		countrytoSelection=0;
		statefromSelection=0;
		statetoSelection=0;
		portfromSelection=0;
		porttoSelection=0;
		if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_SHIPPER) {
		shipperOfThisAccount=shipperFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
		
		allQuotes=quoteFacade.getAllByShipperId(shipperOfThisAccount.getId());
		
		}else if(loginBean.getTheUserOfThisAccount().getRole()==user.ROLE_VENDOR) {
			vendorOfThisAccount=vendorFacade.getByUserId(loginBean.getTheUserOfThisAccount().getId());
			allQuotes=quoteFacade.getAllByShipperId(vendorOfThisAccount.getParentId().getId());
		}
	}

	public String getStringFromCalendar(Calendar calendar) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		String returnedCalendarString="";
		
			if(calendar!=null) {
				returnedCalendarString=formatter.format(calendar.getTime());
			}
		return returnedCalendarString;
	}
	
	private Calendar setCalendarFromString(String cargoRecievedDate2) {

		Calendar cal = null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss"); 
		try {
			if(!cargoRecievedDate2.equals("")) {
				cal=Calendar.getInstance();
				Date date=formatter.parse(cargoRecievedDate2);
				cal.setTime(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return cal;
	}
	
	
	public void selecteQuote(int quoteId) {
		
		
		editQuote=quoteFacade.getById(quoteId);

		dimSelection=editQuote.getDimensions();
		moveTypeSelection=editQuote.getMovetype();
		piecesSelection=editQuote.getPieces();
		commoditySelection=editQuote.getCommodity();
		modeSelection=editQuote.getMode();
		loadTypeSelection=editQuote.getLoadtype();
		marineInsuranceSelection=editQuote.getMarineInsurance();
		countryfromSelection=editQuote.getFromCountry();
		countrytoSelection=editQuote.getToCountry();
		statefromSelection=editQuote.getFromState();
		statetoSelection=editQuote.getToState();
		portfromSelection=editQuote.getFromPort();
		porttoSelection=editQuote.getToPort();
		dateOfShipment=getStringFromCalendar(editQuote.getDateOfShipment());
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/RequestAQuoteEdit.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateQuote() {
		editQuote.setDimensions(dimSelection);
		editQuote.setMovetype(moveTypeSelection);
		editQuote.setPieces(piecesSelection);
		editQuote.setCommodity(commoditySelection);
		editQuote.setMode(modeSelection);
		editQuote.setLoadtype(loadTypeSelection);
		editQuote.setMarineInsurance(marineInsuranceSelection);
		editQuote.setFromCountry(countryfromSelection);
		editQuote.setToCountry(countrytoSelection);
		editQuote.setFromState(statefromSelection);
		editQuote.setToState(statetoSelection);
		editQuote.setFromPort(portfromSelection);
		editQuote.setToPort(porttoSelection);

		editQuote.setDateOfShipment(setCalendarFromString(dateOfShipment));
		quoteFacade.addquote(editQuote);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Quote has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
		
		sendUpdateToAll(editQuote);
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/QuoteList.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendUpdateToAll(quote quotenew) {
		shipper shipperIdMail=shipperFacade.getById(quotenew.getShipperId().getId());
		List<vendor> vendors = vendorFacade.getAllByParentId(shipperIdMail.getId());
		
		if(shipperIdMail!=null)
			Constants.sendEmailUpdateFormat(shipperIdMail.getUserId().getFirstName(), shipperIdMail.getUserId().getEmail(), shipperIdMail.getUserId().getEmail());
		if(vendors!=null) {
			for(int i=0;i<vendors.size();i++) {
				Constants.sendEmailUpdateFormat(vendors.get(i).getUserId().getFirstName(), vendors.get(i).getUserId().getEmail(), vendors.get(i).getUserId().getEmail());
			}
		}
	}
	public void addNewQuote() {

		newQuote.setDimensions(dimSelection);
		newQuote.setMovetype(moveTypeSelection);
		newQuote.setPieces(piecesSelection);
		newQuote.setCommodity(commoditySelection);
		newQuote.setMode(modeSelection);
		newQuote.setLoadtype(loadTypeSelection);
		newQuote.setMarineInsurance(marineInsuranceSelection);
		newQuote.setFromCountry(countryfromSelection);
		newQuote.setToCountry(countrytoSelection);
		newQuote.setFromState(statefromSelection);
		newQuote.setToState(statetoSelection);
		newQuote.setFromPort(portfromSelection);
		newQuote.setToPort(porttoSelection);
		
		newQuote.setDateOfShipment(setCalendarFromString(dateOfShipment));
		newQuote.setShipperId(shipperOfThisAccount);
		quoteFacade.addquote(newQuote);
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your Quote has been added.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");

		sendUpdateToAll(newQuote);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/vendor/QuoteList.jsf?faces-redirect=true");
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

	public shipperAppServiceImpl getShipperFacade() {
		return shipperFacade;
	}

	public void setShipperFacade(shipperAppServiceImpl shipperFacade) {
		this.shipperFacade = shipperFacade;
	}

	public quoteAppServiceImpl getQuoteFacade() {
		return quoteFacade;
	}

	public void setQuoteFacade(quoteAppServiceImpl quoteFacade) {
		this.quoteFacade = quoteFacade;
	}

	public shipper getShipperOfThisAccount() {
		return shipperOfThisAccount;
	}

	public void setShipperOfThisAccount(shipper shipperOfThisAccount) {
		this.shipperOfThisAccount = shipperOfThisAccount;
	}

	public List<quote> getAllQuotes() {
		return allQuotes;
	}

	public void setAllQuotes(List<quote> allQuotes) {
		this.allQuotes = allQuotes;
	}

	public quote getNewQuote() {
		return newQuote;
	}

	public void setNewQuote(quote newQuote) {
		this.newQuote = newQuote;
	}

	public quote getEditQuote() {
		return editQuote;
	}

	public void setEditQuote(quote editQuote) {
		this.editQuote = editQuote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDateOfShipment() {
		return dateOfShipment;
	}

	public void setDateOfShipment(String dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}

	public Integer getDimSelection() {
		return dimSelection;
	}

	public void setDimSelection(Integer dimSelection) {
		this.dimSelection = dimSelection;
	}

	public Integer getMoveTypeSelection() {
		return moveTypeSelection;
	}

	public void setMoveTypeSelection(Integer moveTypeSelection) {
		this.moveTypeSelection = moveTypeSelection;
	}

	public Integer getPiecesSelection() {
		return piecesSelection;
	}

	public void setPiecesSelection(Integer piecesSelection) {
		this.piecesSelection = piecesSelection;
	}

	public Integer getCommoditySelection() {
		return commoditySelection;
	}

	public void setCommoditySelection(Integer commoditySelection) {
		this.commoditySelection = commoditySelection;
	}

	public Integer getModeSelection() {
		return modeSelection;
	}

	public void setModeSelection(Integer modeSelection) {
		this.modeSelection = modeSelection;
	}

	public Integer getLoadTypeSelection() {
		return loadTypeSelection;
	}

	public void setLoadTypeSelection(Integer loadTypeSelection) {
		this.loadTypeSelection = loadTypeSelection;
	}

	public boolean getMarineInsuranceSelection() {
		return marineInsuranceSelection;
	}

	public void setMarineInsuranceSelection(boolean marineInsuranceSelection) {
		this.marineInsuranceSelection = marineInsuranceSelection;
	}

	public Integer getCountryfromSelection() {
		return countryfromSelection;
	}

	public void setCountryfromSelection(Integer countryfromSelection) {
		this.countryfromSelection = countryfromSelection;
	}

	public Integer getCountrytoSelection() {
		return countrytoSelection;
	}

	public void setCountrytoSelection(Integer countrytoSelection) {
		this.countrytoSelection = countrytoSelection;
	}

	public Integer getStatefromSelection() {
		return statefromSelection;
	}

	public void setStatefromSelection(Integer statefromSelection) {
		this.statefromSelection = statefromSelection;
	}

	public Integer getStatetoSelection() {
		return statetoSelection;
	}

	public void setStatetoSelection(Integer statetoSelection) {
		this.statetoSelection = statetoSelection;
	}

	public Integer getPortfromSelection() {
		return portfromSelection;
	}

	public void setPortfromSelection(Integer portfromSelection) {
		this.portfromSelection = portfromSelection;
	}

	public Integer getPorttoSelection() {
		return porttoSelection;
	}

	public void setPorttoSelection(Integer porttoSelection) {
		this.porttoSelection = porttoSelection;
	}
	public Map<Integer, String> getOrigineMap() {
		return origineMap;
	}
	public void setOrigineMap(Map<Integer, String> origineMap) {
		this.origineMap = origineMap;
	}
	public vendorAppServiceImpl getVendorFacade() {
		return vendorFacade;
	}
	public void setVendorFacade(vendorAppServiceImpl vendorFacade) {
		this.vendorFacade = vendorFacade;
	}
	public vendor getVendorOfThisAccount() {
		return vendorOfThisAccount;
	}
	public void setVendorOfThisAccount(vendor vendorOfThisAccount) {
		this.vendorOfThisAccount = vendorOfThisAccount;
	}
	
	
	
	
	
	
	
	

}
