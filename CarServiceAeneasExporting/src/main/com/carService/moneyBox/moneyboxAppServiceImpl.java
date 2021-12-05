/**
 * 
 */
package main.com.carService.moneyBox;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("moneyboxFacadeImpl")
public class moneyboxAppServiceImpl implements ImoneyboxAppService{

	@Autowired
	moneyboxRepository moneyboxDataRepository;
	
	
	@Override
	public List<moneybox> getAll() {
		try{
			List<moneybox> course=moneyboxDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public moneybox addmoneybox(moneybox data) {
		try{
			moneybox data2=moneyboxDataRepository.addmoneybox(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(moneybox data)throws Exception {
		// TODO Auto-generated method stub
		try{
			moneyboxDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public moneybox getById(int id) {
		// TODO Auto-generated method stub
		try{
			moneybox so=moneyboxDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public moneybox getByUserId(int userId) {
		try{
			moneybox course=moneyboxDataRepository.getByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	
	
}
		
		

	
		
	


