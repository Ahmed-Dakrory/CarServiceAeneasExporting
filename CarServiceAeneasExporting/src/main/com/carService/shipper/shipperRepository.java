/**
 * 
 */
package main.com.carService.shipper;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface shipperRepository {

	public List<shipper> getAll();
	public List<shipper> getAllByParentId(int idParent);
	public shipper addshipper(shipper data);
	public shipper getById(int id);
	public shipper getByUserId(int id);
	public boolean delete(shipper data)throws Exception;
}
