/**
 * 
 */
package main.com.carService.security.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.com.carService.loginNeeds.user;
import main.com.carService.loginNeeds.userRepository;

/**
 * @author Omnya Alaa
 * 
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	/*
	 * Mock for users from database. In the real application users will be
	 * retrieved from database and proper Spring UserDetails object will be
	 * created then for each database user.
	 */

	/*
	 * @Autowired IUserRepository userRep;
	 */
	
	@Autowired
	userRepository userDataRepository;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		try {

			user dao = userDataRepository.getByUserName(username);
			System.out.println("Ahmed Dakrory333: "+username);
			UserDetails user;
			if(dao.getRole()==main.com.carService.loginNeeds.user.ROLE_MAIN) {
				Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
				studentAuthorities.add(new GrantedAuthorityImpl("ROLE_MAIN"));
				user = new User(dao.getUserName(), dao.getPassword(), true,
						true, true, true, studentAuthorities);
			}else if(dao.getRole()==main.com.carService.loginNeeds.user.ROLE_SHIPPER) {
				Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
				studentAuthorities.add(new GrantedAuthorityImpl("ROLE_SHIPPER"));
				user = new User(dao.getUserName(), dao.getPassword(), true,
						true, true, true, studentAuthorities);
			}else if(dao.getRole()==main.com.carService.loginNeeds.user.ROLE_VENDOR) {
				Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
				studentAuthorities.add(new GrantedAuthorityImpl("ROLE_VENDOR"));
				user = new User(dao.getUserName(), dao.getPassword(), true,
						true, true, true, studentAuthorities);
			}else if(dao.getRole()==main.com.carService.loginNeeds.user.ROLE_MAIN2) {
				Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
				studentAuthorities.add(new GrantedAuthorityImpl("ROLE_MAINTWO"));
				user = new User(dao.getUserName(), dao.getPassword(), true,
						true, true, true, studentAuthorities);
			}else  {
				Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
				studentAuthorities.add(new GrantedAuthorityImpl("ROLE_CUSTOMER"));
				user = new User(dao.getUserName(), dao.getPassword(), true,
						true, true, true, studentAuthorities);
			}
			return user;
		} catch (IndexOutOfBoundsException ex) {
			throw new UsernameNotFoundException("UserAccount for name \""
					+ username + "\" not found.");
		}

		
		
	}

}
