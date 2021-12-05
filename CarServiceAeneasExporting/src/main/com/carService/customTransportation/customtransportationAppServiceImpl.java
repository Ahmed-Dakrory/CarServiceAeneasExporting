/**
 * 
 */
package main.com.carService.customTransportation;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("customtransportationFacadeImpl")
public class customtransportationAppServiceImpl implements IcustomtransportationAppService{

	@Autowired
	customtransportationRepository customtransportationDataRepository;
	
	
	@Override
	public List<customtransportation> getAll() {
		try{
			List<customtransportation> course=customtransportationDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public customtransportation addcustomtransportation(customtransportation data) {
		try{
			customtransportation data2=customtransportationDataRepository.addcustomtransportation(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(customtransportation data)throws Exception {
		// TODO Auto-generated method stub
		try{
			customtransportationDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public customtransportation getById(int id) {
		// TODO Auto-generated method stub
		try{
			customtransportation so=customtransportationDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<customtransportation> getAllByCustomId(int id) {
		try{
			List<customtransportation> course=customtransportationDataRepository.getAllByCustomId(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<customtransportation> getAllByDocReceiptId(int id) {
		try{
			List<customtransportation> course=customtransportationDataRepository.getAllByDocReceiptId(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	
	
	
}
		
		

	
		
	


