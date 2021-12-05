/**
 * 
 */
package main.com.carService.docreciept;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("docrecieptFacadeImpl")
public class docrecieptAppServiceImpl implements IdocrecieptAppService{

	@Autowired
	docrecieptRepository docrecieptDataRepository;
	
	
	@Override
	public List<docreciept> getAll() {
		try{
			List<docreciept> course=docrecieptDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public docreciept adddocreciept(docreciept data) {
		try{
			docreciept data2=docrecieptDataRepository.adddocreciept(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(docreciept data)throws Exception {
		// TODO Auto-generated method stub
		try{
			docrecieptDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public docreciept getById(int id) {
		// TODO Auto-generated method stub
		try{
			docreciept so=docrecieptDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<docreciept> getAllByUserId(int userId) {
		try{
			List<docreciept> course=docrecieptDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<docreciept> getAllByMainId(int mainId) {
		try{
			List<docreciept> course=docrecieptDataRepository.getAllByMainId(mainId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	
	
	
}
		
		

	
		
	


