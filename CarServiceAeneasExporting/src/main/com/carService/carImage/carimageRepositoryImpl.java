/**
 * 
 */
package main.com.carService.carImage;

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
public class carimageRepositoryImpl implements carimageRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public carimage addcarimage(carimage data) {
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
	public List<carimage> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimage.getAll");

				 @SuppressWarnings("unchecked")
				List<carimage> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(carimage data)throws Exception {
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
	public carimage getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimage.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<carimage> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}



	@Override
	public List<carimage> getAllByCarIdAndType(int idCar, int type) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimage.getAllByCarIdAndType")
				 .setInteger("id",idCar)
				 .setInteger("type", type);

		 @SuppressWarnings("unchecked")
		List<carimage> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public carimage getByUrl(String url) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimage.getByUrl").setString("url",url);

				 @SuppressWarnings("unchecked")
				List<carimage> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}



	
	


}
