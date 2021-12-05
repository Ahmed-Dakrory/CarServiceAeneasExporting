package main.com.carService.api;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.com.carService.car.car;
import main.com.carService.car.carAppServiceImpl;
import main.com.carService.carLanding.carLanding;
import main.com.carService.carLanding.carLandingAppServiceImpl;
@Controller
@RequestMapping("/ApiCarLanding")
public class carLandingApiClass {


	@Inject
	private carLandingAppServiceImpl carLandingFacade;
	

	@Inject
	private carAppServiceImpl carFacade;
	

	

	
	@RequestMapping(value = "/")
    public ResponseEntity<String> getLogin() {
      return new ResponseEntity<>("",HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/all" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> all(@RequestParam(value="start",required=false) Integer start,
    		@RequestParam(value="length",required=false) Integer length,
    		@RequestParam(value="draw",required=false) Integer draw,
    		@RequestParam(value="search[value]",required=false) String search_value) {

		Gson gson = new Gson();
//			int pageNumber = (start/length + 1);
			List<carLanding> list = carLandingFacade.getAllWithPagination(start, length,search_value);
		
	      JsonArray allCars = new JsonArray();
	      for(int i=0;i<list.size();i++) {
	    	  allCars.add(list.get(i).toJson());
	      }
	      
	      
	      JsonObject obj =new JsonObject();
	      obj.add("data", allCars);
	      obj.addProperty("draw", draw);
	      obj.addProperty("recordsTotal", carLandingFacade.getAllCount());
	      obj.addProperty("recordsFiltered", carLandingFacade.getAllCount());
	    	return new ResponseEntity<>(gson.toJson(obj), HttpStatus.CREATED); 
	

     
    }
	
	
	
	@RequestMapping(value = "/allCarsDependsOnStateAndRole" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allCarsDependsOnStateAndRole(@RequestParam(value="start",required=false) Integer start,
    		@RequestParam(value="length",required=false) Integer length,
    		@RequestParam(value="draw",required=false) Integer draw,
    		@RequestParam(value="state",required=false) Integer state,
    		@RequestParam(value="role",required=false) Integer role,
    		@RequestParam(value="useridAny",required=false) Integer useridAny,
    		@RequestParam(value="search[value]",required=false) String search_value) {

		Gson gson = new Gson();
//			int pageNumber = (start/length + 1);
			List<car> list = carFacade.getAllWithPagination(start, length,search_value,role,state,useridAny);
		
	      JsonArray allCars = new JsonArray();
	      for(int i=0;i<list.size();i++) {
	    	  allCars.add(list.get(i).toJson());
	      }
	      
	      
	      JsonObject obj =new JsonObject();
	      obj.add("data", allCars);
	      obj.addProperty("draw", draw);
	      obj.addProperty("recordsTotal", carFacade.getAllCountSearch(start, length,search_value,role,state,useridAny));
	      obj.addProperty("recordsFiltered", carFacade.getAllCountSearch(start, length,search_value,role,state,useridAny));
	    	return new ResponseEntity<>(gson.toJson(obj), HttpStatus.CREATED); 
	

     
    }

	
	@RequestMapping(value = "/allSearch" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allSearch(@RequestParam(value="start",required=false) Integer start,
    		@RequestParam(value="length",required=false) Integer length,
    		@RequestParam(value="draw",required=false) Integer draw,
    		@RequestParam(value="type",required=false) String type,
    		@RequestParam(value="make",required=false) String make,
    		@RequestParam(value="model",required=false) String model,
    		@RequestParam(value="yearStart",required=false) String yearStart,
    		@RequestParam(value="yearEnd",required=false) String yearEnd,
    		@RequestParam(value="search[value]",required=false) String search_value) {

		Gson gson = new Gson();
//			int pageNumber = (start/length + 1);
			List<carLanding> list = carLandingFacade.getAllWithPaginationSearch(start,length,search_value,yearStart,
					 yearEnd,  make,  model,  type);
		
	      JsonArray allCars = new JsonArray();
	      for(int i=0;i<list.size();i++) {
	    	  allCars.add(list.get(i).toJson());
	      }
	      
	      
	      JsonObject obj =new JsonObject();
	      obj.add("data", allCars);
	      obj.addProperty("draw", draw);
	      obj.addProperty("recordsTotal", carLandingFacade.getAllCountSearch( search_value,  yearStart,  yearEnd,  make,  model,
	    			 type));
	      obj.addProperty("recordsFiltered",  carLandingFacade.getAllCountSearch( search_value,  yearStart,  yearEnd,  make,  model,
	    			 type));
	    	return new ResponseEntity<>(gson.toJson(obj), HttpStatus.CREATED); 
	

     
    }
	
	
		
	@RequestMapping(value = "/moneybox",method = RequestMethod.POST)
    public ResponseEntity<String> getCourse(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	//moneybox course=moneyBoxFacade.getById(Integer.parseInt(String.valueOf(id)));

    	
    	return new ResponseEntity<>("{\"statue\":\"Ok\"}", HttpStatus.CREATED); 
    }
}
