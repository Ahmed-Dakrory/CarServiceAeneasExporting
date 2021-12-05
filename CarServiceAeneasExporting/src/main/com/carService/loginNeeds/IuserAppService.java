/**
 * 
 */
package main.com.carService.loginNeeds;

import java.util.List;

/**
 * @author Dakrory
 *
 */
public interface IuserAppService {

	public List<user> getAll();
	public List<user> getAllWithRole(int role);
	public user adduser(user data);
	public user getById(int id);
	public user getByUserName(String userName);
	public user getByUserNameAndRole(String userName,int role);
	public user getByUserNameAndPassword(String userName,String password);
	public user getByUserNameAndPasswordNotActivated(String userName,String password);
	public boolean delete(user data);
}
