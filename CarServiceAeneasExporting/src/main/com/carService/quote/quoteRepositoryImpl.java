/**
 * 
 */
package main.com.carService.quote;

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
public class quoteRepositoryImpl implements quoteRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public quote addquote(quote data) {
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
	public List<quote> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("quote.getAll");

				 @SuppressWarnings("unchecked")
				List<quote> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(quote data)throws Exception {
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
	public quote getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("quote.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<quote> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<quote> getAllByShipperId(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("quote.getAllByShipperId").setInteger("id",shipperId);

		 @SuppressWarnings("unchecked")
		List<quote> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<quote> getAllByUserOfShipperId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("quote.getAllByUserOfShipperId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		List<quote> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<quote> getAllByUserId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("quote.getAllByUserId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		List<quote> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}
	


}
