/**
 * 
 */
package main.com.carService.moneyBox;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface moneyboxRepository {

	public List<moneybox> getAll();
	public moneybox getByUserId(int userId);
	public moneybox addmoneybox(moneybox data);
	public moneybox getById(int id);
	public boolean delete(moneybox data)throws Exception;
}
