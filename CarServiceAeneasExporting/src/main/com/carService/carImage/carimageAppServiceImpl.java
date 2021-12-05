/**
 * 
 */
package main.com.carService.carImage;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("carimageFacadeImpl")
public class carimageAppServiceImpl implements IcarimageAppService{

	@Autowired
	carimageRepository carimageDataRepository;
	
	
	@Override
	public List<carimage> getAll() {
		try{
			List<carimage> course=carimageDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public carimage addcarimage(carimage data) {
		try{
			carimage existData = carimageDataRepository.getByUrl(data.getUrl());
			if(existData==null) {
				carimage data2=carimageDataRepository.addcarimage(data);
				return data2;
			}else {
				existData.setDeleted(data.isDeleted());
				carimageDataRepository.addcarimage(existData);
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
	public boolean delete(carimage data)throws Exception {
		// TODO Auto-generated method stub
		try{
			carimageDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public carimage getById(int id) {
		// TODO Auto-generated method stub
		try{
			carimage so=carimageDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	@Override
	public List<carimage> getAllByCarIdAndType(int idCar, int type) {
		try{
			List<carimage> course=carimageDataRepository.getAllByCarIdAndType(idCar, type);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public carimage getByUrl(String url) {
		try{
			carimage so=carimageDataRepository.getByUrl(url);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	
	
	
}
		
		

	
		
	


