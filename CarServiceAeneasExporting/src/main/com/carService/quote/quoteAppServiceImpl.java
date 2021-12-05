/**
 * 
 */
package main.com.carService.quote;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("quoteFacadeImpl")
public class quoteAppServiceImpl implements IquoteAppService{

	@Autowired
	quoteRepository quoteDataRepository;
	
	
	@Override
	public List<quote> getAll() {
		try{
			List<quote> course=quoteDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public quote addquote(quote data) {
		try{
			quote data2=quoteDataRepository.addquote(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(quote data)throws Exception {
		// TODO Auto-generated method stub
		try{
			quoteDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public quote getById(int id) {
		// TODO Auto-generated method stub
		try{
			quote so=quoteDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	@Override
	public List<quote> getAllByShipperId(int shipperId) {
		try{
			List<quote> course=quoteDataRepository.getAllByShipperId(shipperId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<quote> getAllByUserOfShipperId(int userId) {
		try{
			List<quote> course=quoteDataRepository.getAllByUserOfShipperId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<quote> getAllByUserId(int userId) {
		try{
			List<quote> course=quoteDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


