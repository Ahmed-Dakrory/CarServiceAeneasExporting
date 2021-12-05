/**
 * 
 */
package main.com.carService.custom;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcustomAppService {

	public List<custom> getAll();
	public List<custom> getAllByUserId(int userId);
	public custom addcustom(custom data);
	public custom getById(int id);
	public custom getByDocReceiptId(int id);
	public boolean delete(custom data)throws Exception;
}
