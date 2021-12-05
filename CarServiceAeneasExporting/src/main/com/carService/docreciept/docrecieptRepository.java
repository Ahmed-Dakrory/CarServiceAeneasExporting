/**
 * 
 */
package main.com.carService.docreciept;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface docrecieptRepository {

	public List<docreciept> getAll();
	public List<docreciept> getAllByUserId(int userId);
	public List<docreciept> getAllByMainId(int mainId);
	public docreciept adddocreciept(docreciept data);
	public docreciept getById(int id);
	public boolean delete(docreciept data)throws Exception;
}
