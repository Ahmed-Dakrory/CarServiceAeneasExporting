/**
 * 
 */
package main.com.carService.moneyTransactionDetails;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("moneybox_transaction_detailsFacadeImpl")
public class moneybox_transaction_detailsAppServiceImpl implements Imoneybox_transaction_detailsAppService{

	@Autowired
	moneybox_transaction_detailsRepository moneybox_transaction_detailsDataRepository;
	
	
	@Override
	public List<moneybox_transaction_details> getAll() {
		try{
			List<moneybox_transaction_details> course=moneybox_transaction_detailsDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public moneybox_transaction_details addmoneybox_transaction_details(moneybox_transaction_details data) {
		try{
			moneybox_transaction_details data2=moneybox_transaction_detailsDataRepository.addmoneybox_transaction_details(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(moneybox_transaction_details data)throws Exception {
		// TODO Auto-generated method stub
		try{
			moneybox_transaction_detailsDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public moneybox_transaction_details getById(int id) {
		// TODO Auto-generated method stub
		try{
			moneybox_transaction_details so=moneybox_transaction_detailsDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int moneyBoxId) {
		try{
			List<moneybox_transaction_details> course=moneybox_transaction_detailsDataRepository.getAllByUserMoneyBoxId(moneyBoxId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	@Override
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int moneyBoxId,int start,int limit) {
		try{
			List<moneybox_transaction_details> course=moneybox_transaction_detailsDataRepository.getAllByUserMoneyBoxId(moneyBoxId,start,limit);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	
	
}
		
		

	
		
	


