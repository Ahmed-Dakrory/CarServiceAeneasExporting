/**
 * 
 */
package main.com.carService.customCommodity;

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
public class commoditiyRepositoryImpl implements commoditiyRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public commoditiy addcommoditiy(commoditiy data) {
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
	public List<commoditiy> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("commoditiy.getAll");

				 @SuppressWarnings("unchecked")
				List<commoditiy> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(commoditiy data)throws Exception {
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
	public commoditiy getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("commoditiy.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<commoditiy> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<commoditiy> getAllByCustomId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("commoditiy.getAllByCustomId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<commoditiy> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<commoditiy> getAllByDocReceiptId(int id) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("commoditiy.getAllByDocReceiptId").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		 List<commoditiy> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	


}
