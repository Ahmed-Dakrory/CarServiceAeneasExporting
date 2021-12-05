/**
 * 
 */
package main.com.carService.car;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("carFacadeImpl")
public class carAppServiceImpl implements IcarAppService{

	@Autowired
	carRepository carDataRepository;
	
	
	@Override
	public List<car> getAll() {
		try{
			List<car> course=carDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public car addcar(car data) {
		try{
			car data2=carDataRepository.addcar(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(car data)throws Exception {
		// TODO Auto-generated method stub
		try{
			carDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public car getById(int id) {
		// TODO Auto-generated method stub
		try{
			car so=carDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	@Override
	public List<car> getAllWareHouseForMainUser(int userId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForMainUser(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWareHouseForVendor(int vendorId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForVendor(vendorId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWareHouseForShipper(int shipperId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForShipper(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWareHouseForCustomer(int custmerId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForCustomer(custmerId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWareHouseForConsignee(int consigneeId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForConsignee(consigneeId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForMainUser(int userId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForMainUser(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForVendor(int vendorId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForVendor(vendorId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForShipper(int shipperId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForShipper(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForCustomer(int custmerId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForCustomer(custmerId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForConsignee(int consigneeId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForConsignee(consigneeId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForMainUser(int userId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForMainUser(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForVendor(int vendorId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForVendor(vendorId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForShipper(int shipperId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForShipper(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForCustomer(int custmerId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForCustomer(custmerId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForConsignee(int consigneeId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForConsignee(consigneeId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public car getByVin(String vinId) {
		// TODO Auto-generated method stub
				try{
					car so=carDataRepository.getByVin(vinId);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<car> getAllWithAllowSendState(boolean state) {
		try{
			List<car> course=carDataRepository.getAllWithAllowSendState(state);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForMainUser(int userId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForMainUser(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForVendor(int vendorId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForVendor(vendorId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForShipper(int shipperId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForShipper(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForCustomer(int custmerId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForCustomer(custmerId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForConsignee(int consigneeId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForConsignee(consigneeId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWareHouseForMainUserTwo(int mainTwoId) {
		try{
			List<car> course=carDataRepository.getAllWareHouseForMainUserTwo(mainTwoId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllDryCargoForMainUserTwo(int mainTwoId) {
		try{
			List<car> course=carDataRepository.getAllDryCargoForMainUserTwo(mainTwoId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightInTransitForMainUserTwo(int mainTwoId) {
		try{
			List<car> course=carDataRepository.getAllFrightInTransitForMainUserTwo(mainTwoId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllFrightSentForPaymentForMainUserTwo(int mainTwoId) {
		try{
			List<car> course=carDataRepository.getAllFrightSentForPaymentForMainUserTwo(mainTwoId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForMainUser(int userId) {
		try{
			List<car> course=carDataRepository.getAllForMainUser(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForMainUserTwo(int mainTwoId) {
		try{
			List<car> course=carDataRepository.getAllForMainUserTwo(mainTwoId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForVendor(int vendorId) {
		try{
			List<car> course=carDataRepository.getAllForVendor(vendorId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForShipper(int shipperId) {
		try{
			List<car> course=carDataRepository.getAllForShipper(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForCustomer(int custmerId) {
		try{
			List<car> course=carDataRepository.getAllForCustomer(custmerId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllForConsignee(int consigneeId) {
		try{
			List<car> course=carDataRepository.getAllForConsignee(consigneeId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<car> getAllWithPagination(int start, int number, String searchValue, int role, int state,
			int useridAny) {
		try{
			List<car> course=carDataRepository.getAllWithPagination( start,  number,  searchValue,  role,  state,
					 useridAny);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public long getAllCountSearch(int start, int number, String searchValue, int role, int state, int useridAny) {
		try{
			long course=carDataRepository.getAllCountSearch( start,  number,  searchValue,  role,  state,
					 useridAny);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return 0;
			}
	}
	
	
}
		
		

	
		
	


