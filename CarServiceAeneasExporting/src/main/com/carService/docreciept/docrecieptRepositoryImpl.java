/**
 * 
 */
package main.com.carService.docreciept;

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
public class docrecieptRepositoryImpl implements docrecieptRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public docreciept adddocreciept(docreciept data) {
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
	public List<docreciept> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("docreciept.getAll");

				 @SuppressWarnings("unchecked")
				List<docreciept> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(docreciept data)throws Exception {
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
	public docreciept getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("docreciept.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<docreciept> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<docreciept> getAllByUserId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("docreciept.getAllByUserId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<docreciept> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<docreciept> getAllByMainId(int mainId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("docreciept.getAllByMainId").setInteger("id",mainId);

		 @SuppressWarnings("unchecked")
		 List<docreciept> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	


}
