/**
 * 
 */
package main.com.carService.shipper;

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
public class shipperRepositoryImpl implements shipperRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public shipper addshipper(shipper data) {
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
	public List<shipper> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("shipper.getAll");

				 @SuppressWarnings("unchecked")
				List<shipper> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(shipper data)throws Exception {
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
	public shipper getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("shipper.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<shipper> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<shipper> getAllByParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("shipper.getAllByParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<shipper> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public shipper getByUserId(int id) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("shipper.getByUserId").setInteger("id",id);

				 @SuppressWarnings("unchecked")
				List<shipper> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}
	


}
