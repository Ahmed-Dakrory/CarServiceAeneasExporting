/**
 * 
 */
package main.com.carService.car;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcarAppService {

	public List<car> getAll();
	public List<car> getAllWithPagination(int start, int number,String searchValue,int role,int state,int useridAny);
	public long getAllCountSearch(int start, int number,String searchValue,int role,int state,int useridAny);
	public List<car> getAllWithAllowSendState(boolean state);
	
	
	public List<car> getAllForMainUser(int userId);
	public List<car> getAllForMainUserTwo(int mainTwoId);
	public List<car> getAllForVendor(int vendorId);
	public List<car> getAllForShipper(int shipperId);
	public List<car> getAllForCustomer(int custmerId);
	public List<car> getAllForConsignee(int consigneeId);
	
	
	public List<car> getAllWareHouseForMainUser(int userId);
	public List<car> getAllWareHouseForMainUserTwo(int mainTwoId);
	public List<car> getAllWareHouseForVendor(int vendorId);
	public List<car> getAllWareHouseForShipper(int shipperId);
	public List<car> getAllWareHouseForCustomer(int custmerId);
	public List<car> getAllWareHouseForConsignee(int consigneeId);

	public List<car> getAllDryCargoForMainUser(int userId);
	public List<car> getAllDryCargoForMainUserTwo(int mainTwoId);
	public List<car> getAllDryCargoForVendor(int vendorId);
	public List<car> getAllDryCargoForShipper(int shipperId);
	public List<car> getAllDryCargoForCustomer(int custmerId);
	public List<car> getAllDryCargoForConsignee(int consigneeId);
	

	public List<car> getAllFrightInTransitForMainUser(int userId);
	public List<car> getAllFrightInTransitForMainUserTwo(int mainTwoId);
	public List<car> getAllFrightInTransitForVendor(int vendorId);
	public List<car> getAllFrightInTransitForShipper(int shipperId);
	public List<car> getAllFrightInTransitForCustomer(int custmerId);
	public List<car> getAllFrightInTransitForConsignee(int consigneeId);
	

	public List<car> getAllFrightSentForPaymentForMainUser(int userId);
	public List<car> getAllFrightSentForPaymentForMainUserTwo(int mainTwoId);
	public List<car> getAllFrightSentForPaymentForVendor(int vendorId);
	public List<car> getAllFrightSentForPaymentForShipper(int shipperId);
	public List<car> getAllFrightSentForPaymentForCustomer(int custmerId);
	public List<car> getAllFrightSentForPaymentForConsignee(int consigneeId);
	
	public car addcar(car data);
	public car getById(int id);
	public car getByVin(String vinId);
	public boolean delete(car data)throws Exception;
}
