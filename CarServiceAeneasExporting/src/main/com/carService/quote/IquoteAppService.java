/**
 * 
 */
package main.com.carService.quote;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IquoteAppService {

	public List<quote> getAll();
	public List<quote> getAllByShipperId(int shipperId);
	public List<quote> getAllByUserOfShipperId(int userId);
	public List<quote> getAllByUserId(int userId);
	public quote addquote(quote data);
	public quote getById(int id);
	public boolean delete(quote data)throws Exception;
}
