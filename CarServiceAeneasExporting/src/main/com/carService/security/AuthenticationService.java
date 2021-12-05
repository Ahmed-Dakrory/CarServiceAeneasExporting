package main.com.carService.security;

import javax.annotation.security.RolesAllowed;





public interface AuthenticationService {

	boolean login(String username, String password);
	public boolean autoLogin(String username, String password);
	@RolesAllowed({"ROLE_MAIN","ROLE_SHIPPER","ROLE_VENDOR","ROLE_CUSTOMER","ROLE_MAINTWO"})
	void logout();
}
