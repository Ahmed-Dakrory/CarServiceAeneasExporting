/**
 * 
 */
package main.com.carService.customCommodity;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("commoditiyFacadeImpl")
public class commoditiyAppServiceImpl implements IcommoditiyAppService{

	@Autowired
	commoditiyRepository commoditiyDataRepository;
	
	
	@Override
	public List<commoditiy> getAll() {
		try{
			List<commoditiy> course=commoditiyDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public commoditiy addcommoditiy(commoditiy data) {
		try{
			commoditiy data2=commoditiyDataRepository.addcommoditiy(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(commoditiy data)throws Exception {
		// TODO Auto-generated method stub
		try{
			commoditiyDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public commoditiy getById(int id) {
		// TODO Auto-generated method stub
		try{
			commoditiy so=commoditiyDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<commoditiy> getAllByCustomId(int id) {
		try{
			List<commoditiy> course=commoditiyDataRepository.getAllByCustomId(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<commoditiy> getAllByDocReceiptId(int id) {
		try{
			List<commoditiy> course=commoditiyDataRepository.getAllByDocReceiptId(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	
	
	
}
		
		

	
		
	


