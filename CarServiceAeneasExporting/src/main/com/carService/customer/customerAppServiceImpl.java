/**
 * 
 */
package main.com.carService.customer;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("customerFacadeImpl")
public class customerAppServiceImpl implements IcustomerAppService{

	@Autowired
	customerRepository customerDataRepository;
	
	
	@Override
	public List<customer> getAll() {
		try{
			List<customer> course=customerDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public customer addcustomer(customer data) {
		try{
			customer data2=customerDataRepository.addcustomer(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(customer data)throws Exception {
		// TODO Auto-generated method stub
		try{
			customerDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public customer getById(int id) {
		// TODO Auto-generated method stub
		try{
			customer so=customerDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<customer> getAllByParentId(int idParent) {
		try{
			List<customer> course=customerDataRepository.getAllByParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<customer> getAllByUserOfParentOfParentId(int idParent) {
	
		try{
			List<customer> course=customerDataRepository.getAllByUserOfParentOfParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<customer> getAllByShipperOfParentId(int idParent) {
		try{
			List<customer> course=customerDataRepository.getAllByShipperOfParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public customer getByUserId(int userId) {
		// TODO Auto-generated method stub
				try{
					customer so=customerDataRepository.getByUserId(userId);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}
	
	
}
		
		

	
		
	


