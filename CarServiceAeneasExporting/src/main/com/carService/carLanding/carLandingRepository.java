/**
 * 
 */
package main.com.carService.carLanding;

import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface carLandingRepository {

	public List<carLanding> getAll();
	public long getAllCount();
	public List<carLanding> getAllForLanding();
	public List<carLanding> getAllGroupsOfMake();
	public List<carLanding> getAllGroupsOfCategory();
	public List<carLanding> getAllWithPagination(int start, int number,String searchValue);
	public List<carLanding> getAllWithPaginationSearch(int start, int number,String searchValue,String yearStart,String yearEnd,String make,String model,String category);
	public long getAllCountSearch(String searchValue,String yearStart,String yearEnd,String make,String model,String category);
	public long getAllWithPaginationCount(int start, int number);
	public List<carLanding> getAllGroupsOfModelWithMake(String model);
	public List<carLanding> getAllForSearch(String yearStart,String yearEnd,String make,String model,String category);
	public List<carLanding> getAllForCategories(String categories);
	public carLanding addcarLanding(carLanding data);
	public carLanding getById(int id);
	public carLanding getByVin(String vinId);
	public boolean delete(carLanding data)throws Exception;
}
