/**
 * 
 */
package main.com.carService.consignee;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface consigneeRepository {

	public List<consignee> getAll();
	public List<consignee> getAllByParentId(int idShipperParent);
	public List<consignee> getAllByMainAccountIdOfParentShipper(int idUserParent);
	public consignee addconsignee(consignee data);
	public consignee getById(int id);
	public consignee getAllByParentIdAndUserId(int id,int idUser);
	public List<consignee> getAllByUserId(int id);
	public boolean delete(consignee data)throws Exception;
}
