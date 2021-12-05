/**
 * 
 */
package main.com.carService.customer;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.carService.loginNeeds.user;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class customerRepositoryImpl implements customerRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public customer addcustomer(customer data) {
		try{
			user addedUser=data.getUserId();
			addedUser.setLastUpdate(Calendar.getInstance());
			data.setUserId(addedUser);
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
	public List<customer> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getAll");

				 @SuppressWarnings("unchecked")
				List<customer> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(customer data)throws Exception {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public customer getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<customer> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<customer> getAllByParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getAllByParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<customer> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<customer> getAllByUserOfParentOfParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getAllByUserOfParentOfParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<customer> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<customer> getAllByShipperOfParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getAllByShipperOfParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<customer> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public customer getByUserId(int userId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customer.getByUserId").setInteger("id",userId);

				 @SuppressWarnings("unchecked")
				List<customer> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}
	


}
