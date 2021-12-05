/**
 * 
 */
package main.com.carService.vendor;

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
public class vendorRepositoryImpl implements vendorRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public vendor addvendor(vendor data) {
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
	public List<vendor> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("vendor.getAll");

				 @SuppressWarnings("unchecked")
				List<vendor> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(vendor data)throws Exception {
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
	public vendor getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("vendor.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<vendor> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<vendor> getAllByParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("vendor.getAllByParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<vendor> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public vendor getByUserId(int idUser) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("vendor.getByUserId").setInteger("id",idUser);

				 @SuppressWarnings("unchecked")
				List<vendor> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}

	@Override
	public List<vendor> getAllByParentIdForUser(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("vendor.getAllByParentIdForUser").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<vendor> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}
	


}
