/**
 * 
 */
package main.com.carService.custom;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("customFacadeImpl")
public class customAppServiceImpl implements IcustomAppService{

	@Autowired
	customRepository customDataRepository;
	
	
	@Override
	public List<custom> getAll() {
		try{
			List<custom> course=customDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public custom addcustom(custom data) {
		try{
			custom data2=customDataRepository.addcustom(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(custom data)throws Exception {
		// TODO Auto-generated method stub
		try{
			customDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public custom getById(int id) {
		// TODO Auto-generated method stub
		try{
			custom so=customDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<custom> getAllByUserId(int userId) {
		try{
			List<custom> course=customDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public custom getByDocReceiptId(int id) {
		// TODO Auto-generated method stub
		try{
			custom so=customDataRepository.getByDocReceiptId(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	
	
	
}
		
		

	
		
	


