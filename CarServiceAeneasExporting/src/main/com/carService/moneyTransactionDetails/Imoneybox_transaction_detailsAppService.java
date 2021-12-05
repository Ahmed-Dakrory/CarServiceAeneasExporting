/**
 * 
 */
package main.com.carService.moneyTransactionDetails;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface Imoneybox_transaction_detailsAppService {

	public List<moneybox_transaction_details> getAll();
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int userId);
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int userId,int start,int limit);
	public moneybox_transaction_details addmoneybox_transaction_details(moneybox_transaction_details data);
	public moneybox_transaction_details getById(int id);
	public boolean delete(moneybox_transaction_details data)throws Exception;
}
