package main.com.carService.Res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Data Sample Json :
 * 
 
 {
  "firstName":"Sergey",
  "lastName":"Kargopolov",
  "email":"test9@test.com",
  "password":"123",
  "Hope":"Play",
  "obj":{
  	"work":{
  		"id":1,
  		"address":"1 omda st"
  	},
  	"work_profile":"Engineering",
  	"work_data":"Zewail City"
  }
}
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDetailsRequestModel {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    
    public obj obj;
    
    public class obj{

    	public work work;
    	public String work_profile;
    	public String work_data;
    	
    	public class work{
    		public Integer id;
    		public String address;
    	}
    }
  
    
}