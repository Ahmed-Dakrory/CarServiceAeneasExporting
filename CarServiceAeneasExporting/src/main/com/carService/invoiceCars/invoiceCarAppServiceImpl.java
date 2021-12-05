/**
 * 
 */
package main.com.carService.invoiceCars;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("invoiceCarFacadeImpl")
public class invoiceCarAppServiceImpl implements IinvoiceCarAppService{

	@Autowired
	invoiceCarRepository invoiceCarDataRepository;
	
	
	@Override
	public List<invoiceCar> getAll() {
		try{
			List<invoiceCar> course=invoiceCarDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public invoiceCar addinvoiceCar(invoiceCar data) {
		try{
			invoiceCar data2=invoiceCarDataRepository.addinvoiceCar(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(invoiceCar data)throws Exception {
		// TODO Auto-generated method stub
		try{
			invoiceCarDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public invoiceCar getById(int id) {
		// TODO Auto-generated method stub
		try{
			invoiceCar so=invoiceCarDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<invoiceCar> getAllByinvoiceId(int userId) {
		try{
			List<invoiceCar> course=invoiceCarDataRepository.getAllByinvoiceId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


