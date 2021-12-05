/**
 * 
 */
package main.com.carService.carLandingImage;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Dakrory
 *
 */
@Service("carimageLandingFacadeImpl")
public class carimageLandingAppServiceImpl implements IcarimageLandingAppService{

	@Autowired
	carimageLandingRepository carimageLandingDataRepository;
	
	
	@Override
	public List<carimageLanding> getAll() {
		try{
			List<carimageLanding> course=carimageLandingDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public carimageLanding addcarimageLanding(carimageLanding data) {
		try{
			carimageLanding existData = carimageLandingDataRepository.getByUrl(data.getUrl());
			if(existData==null) {
				carimageLanding data2=carimageLandingDataRepository.addcarimageLanding(data);
				return data2;
			}else {
				existData.setDeleted(data.isDeleted());
				carimageLandingDataRepository.addcarimageLanding(existData);
				return existData;
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(carimageLanding data)throws Exception {
		// TODO Auto-generated method stub
		try{
			carimageLandingDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public carimageLanding getById(int id) {
		// TODO Auto-generated method stub
		try{
			carimageLanding so=carimageLandingDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	@Override
	public List<carimageLanding> getAllByCarId(int idCar) {
		try{
			List<carimageLanding> course=carimageLandingDataRepository.getAllByCarId(idCar);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public carimageLanding getByUrl(String url) {
		try{
			carimageLanding so=carimageLandingDataRepository.getByUrl(url);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	
	
	
}
		
		

	
		
	


