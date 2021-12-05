/**
 * 
 */
package main.com.carService.customCommodity;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface commoditiyRepository {

	public List<commoditiy> getAll();
	public List<commoditiy> getAllByCustomId(int id);
	public List<commoditiy> getAllByDocReceiptId(int id);
	public commoditiy addcommoditiy(commoditiy data);
	public commoditiy getById(int id);
	public boolean delete(commoditiy data)throws Exception;
}
