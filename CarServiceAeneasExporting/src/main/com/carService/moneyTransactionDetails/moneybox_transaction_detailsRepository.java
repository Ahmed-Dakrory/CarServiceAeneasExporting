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
public interface moneybox_transaction_detailsRepository {

	public List<moneybox_transaction_details> getAll();
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int moneyBoxId);
	public List<moneybox_transaction_details> getAllByUserMoneyBoxId(int moneyBoxId,int start,int limit);
	public moneybox_transaction_details addmoneybox_transaction_details(moneybox_transaction_details data);
	public moneybox_transaction_details getById(int id);
	public boolean delete(moneybox_transaction_details data)throws Exception;
}
