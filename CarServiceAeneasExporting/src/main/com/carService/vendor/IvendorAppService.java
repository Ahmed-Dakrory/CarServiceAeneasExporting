/**
 * 
 */
package main.com.carService.vendor;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IvendorAppService {

	public List<vendor> getAll();
	public List<vendor> getAllByParentId(int idParent);
	public List<vendor> getAllByParentIdForUser(int idParent);
	public vendor addvendor(vendor data);
	public vendor getById(int id);
	public vendor getByUserId(int idUser);
	public boolean delete(vendor data)throws Exception;
}
