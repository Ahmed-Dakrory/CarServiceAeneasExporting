/**
 * 
 */
package main.com.carService.invoice;





import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("invoiceFacadeImpl")
public class invoiceAppServiceImpl implements IinvoiceAppService{

	@Autowired
	invoiceRepository invoiceDataRepository;
	
	
	@Override
	public List<invoice> getAll() {
		try{
			List<invoice> course=invoiceDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public invoice addinvoice(invoice data) {
		try{
			invoice data2=invoiceDataRepository.addinvoice(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(invoice data)throws Exception {
		// TODO Auto-generated method stub
		try{
			invoiceDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public invoice getById(int id) {
		// TODO Auto-generated method stub
		try{
			invoice so=invoiceDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public invoice getByUserIdCustomer(int userId) {
		try{
			invoice course=invoiceDataRepository.getByUserIdCustomer(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<invoice> getAllByUserId(int userId) {
		try{
			List<invoice> course=invoiceDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<invoice> getAllByUserIdBetweenDates(int userId, Calendar dateLower, Calendar dateHigh) {
		try{
			List<invoice> course=invoiceDataRepository.getAllByUserIdBetweenDates(userId,dateLower, dateHigh);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


