/**
 * 
 */
package main.com.carService.vendor;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("vendorFacadeImpl")
public class vendorAppServiceImpl implements IvendorAppService{

	@Autowired
	vendorRepository vendorDataRepository;
	
	
	@Override
	public List<vendor> getAll() {
		try{
			List<vendor> course=vendorDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public vendor addvendor(vendor data) {
		try{
			vendor data2=vendorDataRepository.addvendor(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(vendor data)throws Exception {
		// TODO Auto-generated method stub
		try{
			vendorDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public vendor getById(int id) {
		// TODO Auto-generated method stub
		try{
			vendor so=vendorDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<vendor> getAllByParentId(int idParent) {
		try{
			List<vendor> course=vendorDataRepository.getAllByParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public vendor getByUserId(int idUser) {
		// TODO Auto-generated method stub
				try{
					vendor so=vendorDataRepository.getByUserId(idUser);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<vendor> getAllByParentIdForUser(int idParent) {
		try{
			List<vendor> course=vendorDataRepository.getAllByParentIdForUser(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


