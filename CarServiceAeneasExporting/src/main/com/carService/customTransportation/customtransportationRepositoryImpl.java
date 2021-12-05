/**
 * 
 */
package main.com.carService.customTransportation;

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
public class customtransportationRepositoryImpl implements customtransportationRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public customtransportation addcustomtransportation(customtransportation data) {
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
	public List<customtransportation> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customtransportation.getAll");

				 @SuppressWarnings("unchecked")
				List<customtransportation> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(customtransportation data)throws Exception {
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
	public customtransportation getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customtransportation.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<customtransportation> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<customtransportation> getAllByCustomId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customtransportation.getAllByCustomId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<customtransportation> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<customtransportation> getAllByDocReceiptId(int id) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customtransportation.getAllByDocReceiptId").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		 List<customtransportation> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	


}
