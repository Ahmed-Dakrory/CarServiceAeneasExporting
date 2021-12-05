/**
 * 
 */
package main.com.carService.mainTwo;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface mainTwoRepository {

	public List<mainTwo> getAll();
	public List<mainTwo> getAllByParentId(int idParent);
	public mainTwo addmainTwo(mainTwo data);
	public mainTwo getById(int id);
	public mainTwo getByUserId(int id);
	public boolean delete(mainTwo data)throws Exception;
}
