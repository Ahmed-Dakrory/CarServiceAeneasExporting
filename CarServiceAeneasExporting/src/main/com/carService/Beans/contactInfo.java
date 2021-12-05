package main.com.carService.Beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;


@ManagedBean(name = "contactInfo")
@SessionScoped
public class contactInfo implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236767354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 

	
	
	@PostConstruct
	public void init() {
		
		refresh();
	}
	
	public void refresh(){
		
	}
	
	public void previewImage(FileUploadEvent event) {
		byte[] image =event.getFile().getContents();
		loginBean.getTheUserOfThisAccount().setImage(image);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("aspnetForm:imagesPanel");
	}
	
	public void updateData() {
		loginBean.getUserDataFacede().adduser(loginBean.getTheUserOfThisAccount());
		PrimeFaces.current().executeScript("new PNotify({\r\n" + 
				"			title: 'Success',\r\n" + 
				"			text: 'Your data has been updated.',\r\n" + 
				"			type: 'success'\r\n" + 
				"		});");
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
	

	
	
}
