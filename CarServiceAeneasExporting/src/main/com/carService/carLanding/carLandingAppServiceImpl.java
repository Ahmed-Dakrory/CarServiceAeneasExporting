/**
 * 
 */
package main.com.carService.carLanding;





import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("carLandingFacadeImpl")
public class carLandingAppServiceImpl implements IcarLandingAppService{
	
	@Autowired
	carLandingRepository carLandingDataRepository;
	
	
	@Override
	public List<carLanding> getAll() {
		try{
			List<carLanding> course=carLandingDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public carLanding addcarLanding(carLanding data) {
		try{
			carLanding data2=carLandingDataRepository.addcarLanding(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(carLanding data)throws Exception {
		// TODO Auto-generated method stub
		try{
			carLandingDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public carLanding getById(int id) {
		// TODO Auto-generated method stub
		try{
			carLanding so=carLandingDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	@Override
	public carLanding getByVin(String vinId) {
		// TODO Auto-generated method stub
				try{
					carLanding so=carLandingDataRepository.getByVin(vinId);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<carLanding> getAllForLanding() {
		try{
			List<carLanding> course=carLandingDataRepository.getAllForLanding();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<carLanding> getAllForCategories(String categories) {
		try{
			List<carLanding> course=carLandingDataRepository.getAllForCategories(categories);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<carLanding> getAllGroupsOfMake() {
		try{
			List<carLanding> course=carLandingDataRepository.getAllGroupsOfMake();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<carLanding> getAllForSearch(String yearStart, String yearEnd, String make,String model, String category) {
		try{
			List<carLanding> course=carLandingDataRepository.getAllForSearch( yearStart,  yearEnd,  make, model,  category);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	


	

	

	@Override
	public List<carLanding> getAllGroupsOfModelWithMake(String model) {
		try{
			List<carLanding> course=carLandingDataRepository.getAllGroupsOfModelWithMake(model);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<carLanding> getAllWithPagination(int start, int number,String searchValue) {
		
			List<carLanding> course=carLandingDataRepository.getAllWithPagination(start,number,searchValue);
			
			return course;
			
	}



	@Override
	public long getAllCount() {
		long course=carLandingDataRepository.getAllCount();
		
		return course;
	}



	@Override
	public long getAllWithPaginationCount(int start, int number) {
long course=carLandingDataRepository.getAllWithPaginationCount( start,  number);
		
		return course;
	}



	@Override
	public List<carLanding> getAllWithPaginationSearch(int start, int number, String searchValue, String yearStart,
			String yearEnd, String make, String model, String category) {
		List<carLanding> course=carLandingDataRepository.getAllWithPaginationSearch(start,number,searchValue,yearStart,
				 yearEnd,  make,  model,  category);
		
		return course;
	}



	@Override
	public long getAllCountSearch(String searchValue, String yearStart, String yearEnd, String make, String model,
			String category) {
long course=carLandingDataRepository.getAllCountSearch( searchValue,  yearStart,  yearEnd,  make,  model,
		 category);
		
		return course;
	}



	@Override
	public List<carLanding> getAllGroupsOfCategory() {
		try{
			List<carLanding> course=carLandingDataRepository.getAllGroupsOfCategory();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


