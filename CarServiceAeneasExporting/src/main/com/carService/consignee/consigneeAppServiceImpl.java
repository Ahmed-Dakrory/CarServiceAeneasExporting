/**
 * 
 */
package main.com.carService.consignee;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("consigneeFacadeImpl")
public class consigneeAppServiceImpl implements IconsigneeAppService{

	@Autowired
	consigneeRepository consigneeDataRepository;
	
	
	@Override
	public List<consignee> getAll() {
		try{
			List<consignee> course=consigneeDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public consignee addconsignee(consignee data) {
		try{
			consignee data2=consigneeDataRepository.addconsignee(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(consignee data)throws Exception {
		// TODO Auto-generated method stub
		try{
			consigneeDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public consignee getById(int id) {
		// TODO Auto-generated method stub
		try{
			consignee so=consigneeDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<consignee> getAllByParentId(int idParent) {
		try{
			List<consignee> course=consigneeDataRepository.getAllByParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<consignee> getAllByUserId(int id) {
		// TODO Auto-generated method stub
				try{
					List<consignee> so=consigneeDataRepository.getAllByUserId(id);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<consignee> getAllByMainAccountIdOfParentShipper(int idUserParent) {
		try{
			List<consignee> course=consigneeDataRepository.getAllByMainAccountIdOfParentShipper(idUserParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public consignee getAllByParentIdAndUserId(int id, int idUser) {
		// TODO Auto-generated method stub
				try{
					consignee so=consigneeDataRepository.getAllByParentIdAndUserId(id,idUser);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}
	
	
}
		
		

	
		
	


