/**
 * 
 */
package main.com.carService.carLandingImage;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcarimageLandingAppService {

	public List<carimageLanding> getAll();
	public List<carimageLanding> getAllByCarId(int idCar);
	public carimageLanding addcarimageLanding(carimageLanding data);
	public carimageLanding getByUrl(String url);
	public carimageLanding getById(int id);
	public boolean delete(carimageLanding data)throws Exception;
}
