/**
 * 
 */
package main.com.carService.costCalc;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("transportfeeFacadeImpl")
public class transportfeeAppServiceImpl implements ItransportfeeAppService{

	@Autowired
	transportfeeRepository transportfeeDataRepository;
	
	
	@Override
	public List<transportfee> getAll() {
		try{
			List<transportfee> course=transportfeeDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public transportfee addtransportfee(transportfee data) {
		try{
			transportfee data2=transportfeeDataRepository.addtransportfee(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(transportfee data)throws Exception {
		// TODO Auto-generated method stub
		try{
			transportfeeDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public transportfee getById(int id) {
		// TODO Auto-generated method stub
		try{
			transportfee so=transportfeeDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	






	@Override
	public List<transportfee> getAllGroupsOfLocation() {
		try{
			List<transportfee> course=transportfeeDataRepository.getAllGroupsOfLocation();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	



	@Override
	public transportfee getWithSpecs(String location, String city, String state) {
		// TODO Auto-generated method stub
				try{
					transportfee so=transportfeeDataRepository.getWithSpecs(location, city, state);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<transportfee> getAllGroupsOfCityWithLocation(String location) {
		try{
			List<transportfee> course=transportfeeDataRepository.getAllGroupsOfCityWithLocation(location);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<transportfee> getAllGroupsOfstateWithCity(String city) {
		try{
			List<transportfee> course=transportfeeDataRepository.getAllGroupsOfstateWithCity(city);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


