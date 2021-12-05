package main.com.carService.Res;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

	@RequestMapping(value = "/dologout")
    public ResponseEntity<String> getLogout1(@RequestParam(value="name",required = false)  String name) {
    	if(name==null) {

        	return new ResponseEntity<>(" ", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(" Hi : "+name, HttpStatus.OK);
		
		
    }
	
	@RequestMapping(value = "/data",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<String> createUser(@RequestBody UserDetailsRequestModel requestUserDetails) {
	   

		System.out.println("Email: "+requestUserDetails.email);
		System.out.println("address: "+requestUserDetails.obj.work.address);
		System.out.println("work_profile: "+requestUserDetails.obj.work_profile);

    	return new ResponseEntity<>(" Hi : ", HttpStatus.OK);
	}
}
