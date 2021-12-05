/**
 * 
 */
package main.com.carService.invoice;

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
public class invoiceRepositoryImpl implements invoiceRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public invoice addinvoice(invoice data) {
		try{
			
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
	public List<invoice> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoice.getAll");

				 @SuppressWarnings("unchecked")
				List<invoice> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(invoice data)throws Exception {
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
	public invoice getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoice.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<invoice> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public invoice getByUserIdCustomer(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoice.getByUserIdCustomer").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<invoice> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<invoice> getAllByUserId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoice.getAllByUserId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		List<invoice> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<invoice> getAllByUserIdBetweenDates(int userId, Calendar dateLower, Calendar dateHigh) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoice.getAllByUserIdBetweenDates")
				 .setInteger("id",userId).setCalendar("dateLower", dateLower).setCalendar("dateHigher", dateHigh);

		 @SuppressWarnings("unchecked")
		List<invoice> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}
	


}
