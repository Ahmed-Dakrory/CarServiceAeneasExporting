/**
 * 
 */
package main.com.carService.carImage;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcarimageAppService {

	public List<carimage> getAll();
	public List<carimage> getAllByCarIdAndType(int idCar,int type);
	public carimage addcarimage(carimage data);
	public carimage getByUrl(String url);
	public carimage getById(int id);
	public boolean delete(carimage data)throws Exception;
}
