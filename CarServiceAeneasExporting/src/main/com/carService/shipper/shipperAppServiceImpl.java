/**
 * 
 */
package main.com.carService.shipper;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("shipperFacadeImpl")
public class shipperAppServiceImpl implements IshipperAppService{

	@Autowired
	shipperRepository shipperDataRepository;
	
	
	@Override
	public List<shipper> getAll() {
		try{
			List<shipper> course=shipperDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public shipper addshipper(shipper data) {
		try{
			shipper data2=shipperDataRepository.addshipper(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(shipper data)throws Exception {
		// TODO Auto-generated method stub
		try{
			shipperDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public shipper getById(int id) {
		// TODO Auto-generated method stub
		try{
			shipper so=shipperDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<shipper> getAllByParentId(int idParent) {
		try{
			List<shipper> course=shipperDataRepository.getAllByParentId(idParent);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public shipper getByUserId(int id) {
		// TODO Auto-generated method stub
				try{
					shipper so=shipperDataRepository.getByUserId(id);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}
	
	
}
		
		

	
		
	


