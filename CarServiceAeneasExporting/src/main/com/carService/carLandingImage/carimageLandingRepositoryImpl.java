/**
 * 
 */
package main.com.carService.carLandingImage;

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
public class carimageLandingRepositoryImpl implements carimageLandingRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public carimageLanding addcarimageLanding(carimageLanding data) {
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
	public List<carimageLanding> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimageLanding.getAll");

				 @SuppressWarnings("unchecked")
				List<carimageLanding> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(carimageLanding data)throws Exception {
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
	public carimageLanding getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimageLanding.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<carimageLanding> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}



	@Override
	public List<carimageLanding> getAllByCarId(int idCar) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimageLanding.getAllByCarId")
				 .setInteger("id",idCar);

		 @SuppressWarnings("unchecked")
		List<carimageLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public carimageLanding getByUrl(String url) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carimageLanding.getByUrl").setString("url",url);

				 @SuppressWarnings("unchecked")
				List<carimageLanding> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}



	
	


}
