/**
 * 
 */
package main.com.carService.costCalc;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface transportfeeRepository {

	public List<transportfee> getAll();
	public List<transportfee> getAllGroupsOfLocation();
	public List<transportfee> getAllGroupsOfCityWithLocation(String location);
	public List<transportfee> getAllGroupsOfstateWithCity(String city);
	public transportfee getWithSpecs(String location,String city,String state);
	public transportfee addtransportfee(transportfee data);
	public transportfee getById(int id);
	public boolean delete(transportfee data)throws Exception;
}
