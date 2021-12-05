/**
 * 
 */
package main.com.carService.customer;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface customerRepository {

	public List<customer> getAll();
	public List<customer> getAllByParentId(int idParent);
	public List<customer> getAllByShipperOfParentId(int idParent);
	public List<customer> getAllByUserOfParentOfParentId(int idParent);
	public customer addcustomer(customer data);
	public customer getById(int id);
	public customer getByUserId(int userId);
	public boolean delete(customer data)throws Exception;
}
