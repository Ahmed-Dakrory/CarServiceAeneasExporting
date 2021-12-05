/**
 * 
 */
package main.com.carService.loginNeeds;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class userRepositoryImpl implements userRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public user adduser(user data) {
		try{
			data.setLastUpdate(Calendar.getInstance());
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(data);
			tx1.commit();
			session.close(); 
			return data; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<user> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getAll");

				 @SuppressWarnings("unchecked")
				List<user> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(user data) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public user getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<user> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}
	
	@Override
	public user getByUserNameAndPassword(String userName,String password) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getByUserNameAndPassword").setString("userName",userName).setString("password", password).setInteger("active", 1);

		 @SuppressWarnings("unchecked")
		List<user> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public user getByUserNameAndPasswordNotActivated(String userName,
			String password) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getByUserNameAndPassword").setString("userName",userName).setString("password", password).setInteger("active", 0);

		 @SuppressWarnings("unchecked")
		List<user> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public user getByUserName(String userName) {
		// TODO Auto-generated method stub
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getByUserName").setString("userName",userName);

		 @SuppressWarnings("unchecked")
		List<user> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<user> getAllWithRole(int role) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getAllWithRole").setInteger("role", role);

		 @SuppressWarnings("unchecked")
		List<user> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public user getByUserNameAndRole(String userName, int role) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("user.getByUserNameAndRole").setString("userName",userName).setInteger("role", role);

				 @SuppressWarnings("unchecked")
				List<user> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}

}
