/**
 * 
 */
package main.com.carService.mainTwo;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("mainTwoFacadeImpl")
public class mainTwoAppServiceImpl implements ImainTwoAppService{

	@Autowired
	mainTwoRepository mainTwoDataRepository;
	
	
	@Override
	public List<mainTwo> getAll() {
		try{
			List<mainTwo> course=mainTwoDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public mainTwo addmainTwo(mainTwo data) {
		try{
			mainTwo data2=mainTwoDataRepository.addmainTwo(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(mainTwo data)throws Exception {
		// TODO Auto-generated method stub
		try{
			mainTwoDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public mainTwo getById(int id) {
		// TODO Auto-generated method stub
		try{
			mainTwo so=mainTwoDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<mainTwo> getAllByParentId(int idParent) {
		try{
			List<mainTwo> course=mainTwoDataRepository.getAllByParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public mainTwo getByUserId(int id) {
		// TODO Auto-generated method stub
				try{
					mainTwo so=mainTwoDataRepository.getByUserId(id);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}
	
	
}
		
		

	
		
	


