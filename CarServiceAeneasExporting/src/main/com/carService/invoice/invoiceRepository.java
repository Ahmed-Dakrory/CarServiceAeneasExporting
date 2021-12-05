/**
 * 
 */
package main.com.carService.invoice;

import java.util.Calendar;
import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface invoiceRepository {

	public List<invoice> getAll();
	public invoice getByUserIdCustomer(int userId);
	public List<invoice> getAllByUserId(int userId);
	public List<invoice> getAllByUserIdBetweenDates(int userId,Calendar dateLower,Calendar dateHigh);
	public invoice addinvoice(invoice data);
	public invoice getById(int id);
	public boolean delete(invoice data)throws Exception;
}
