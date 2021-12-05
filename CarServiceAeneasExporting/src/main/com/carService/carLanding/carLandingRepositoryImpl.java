/**
 * 
 */
package main.com.carService.carLanding;

import java.util.ArrayList;
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
public class carLandingRepositoryImpl implements carLandingRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public carLanding addcarLanding(carLanding data) {
		try{

			data.setDateAdd(Calendar.getInstance());
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
	public List<carLanding> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAll");

				 @SuppressWarnings("unchecked")
				List<carLanding> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(carLanding data)throws Exception {
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
	public carLanding getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	

	
	@Override
	public carLanding getByVin(String vinId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getByVin").setString("uuid",vinId);

				 @SuppressWarnings("unchecked")
				List<carLanding> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}

	@Override
	public List<carLanding> getAllForLanding() {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllForLanding");

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<carLanding> getAllForCategories(String categories) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllForCategories").setString("category",categories).setMaxResults(30);

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<carLanding> getAllGroupsOfMake() {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllGroupsOfMake");

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
}

	@Override
	public List<carLanding> getAllForSearch(String yearStart, String yearEnd, String make,String model, String category) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllForSearch")
				 .setString("category",category)
				 .setString("yearStart",yearStart)
				 .setString("yearEnd",yearEnd)
		 		 .setString("make",make)
		 		 .setString("model",model);

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	
	
	

	@Override
	public List<carLanding> getAllGroupsOfModelWithMake(String make) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllGroupsOfModelWithMake").setString("make",make);

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<carLanding> getAllWithPagination(int start, int number,String searchValue) {
		
			 
			 try {
					session = sessionFactory.openSession();
					Transaction tx1 = session.beginTransaction();
					
					
					Query query =null;
					if(searchValue.equalsIgnoreCase("")) {
						 query = session.createQuery("FROM carLanding order by dateAdd desc");
					}else {
					 query = session.createQuery("FROM carLanding where"
							+ " uuid like '%"+searchValue+"%' or "
							+ " model like '%"+searchValue+"%' or "
							+ " make like '%"+searchValue+"%' or "
							+ " color like '%"+searchValue+"%' or "
							+ " year like '%"+searchValue+"%' or "
							+ " itemNumber like '%"+searchValue+"%' or "
							+ " transmission like '%"+searchValue+"%' or "
							+ " damageDescription like '%"+searchValue+"%' or "
							+ " category like '%"+searchValue+"%'"
							+ " order by dateAdd desc");
					}
					
					 query.setFirstResult(start);
					 query.setMaxResults(number);
					 
					 @SuppressWarnings("unchecked")
					List<carLanding> results=query.list();

					tx1.commit();
					session.close();
					return results;
				} catch (Exception ex) {
					return new ArrayList<carLanding>();
				}
		
	}

	@Override
	public long getAllCount() {
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select count(*) FROM carLanding order by dateAdd desc");
			 
			Number results=(Number) (query).uniqueResult();

			tx1.commit();
			session.close();
			return (long) results;
		} catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public long getAllWithPaginationCount(int start, int number) {
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			Query query = session.createQuery("select count(*) FROM carLanding order by dateAdd desc");
			 query.setFirstResult(start);
			 query.setMaxResults(number);
			 
			Number results=(Number) (query).uniqueResult();

			tx1.commit();
			session.close();
			return (long) results;
		} catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public List<carLanding> getAllWithPaginationSearch(int start, int number, String searchValue, String yearStart,
			String yearEnd, String make, String model, String categorySearch) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			
			
			Query query =null;
			if(searchValue.equalsIgnoreCase("")) {
				 query = session.createQuery("FROM carLanding where "
						+ " model like '%"+model+"%' and "
						+ " make like '%"+make+"%' and "
						+ " year < "+yearEnd+" and "
						+ " year > "+yearStart+" and "
						+ " category like '%"+categorySearch+"%' "
				 		+ "order by dateAdd desc");
			}else {
			 query = session.createQuery("FROM carLanding where"
					+ " model like '%"+model+"%' and "
					+ " make like '%"+make+"%' and "
					+ " year < "+yearEnd+" and "
					+ " year > "+yearStart+" and "
					+ " category like '%"+categorySearch+"%' and ( "
					+ " uuid like '%"+searchValue+"%' or "
					+ " model like '%"+searchValue+"%' or "
					+ " make like '%"+searchValue+"%' or "
					+ " color like '%"+searchValue+"%' or "
					+ " year like '%"+searchValue+"%' or "
					+ " itemNumber like '%"+searchValue+"%' or "
					+ " transmission like '%"+searchValue+"%' or "
					+ " damageDescription like '%"+searchValue+"%' or "
					+ " category like '%"+searchValue+"%') "
					+ " order by dateAdd desc");
			}
			
			 query.setFirstResult(start);
			 query.setMaxResults(number);
			 
			 @SuppressWarnings("unchecked")
			List<carLanding> results=query.list();

			tx1.commit();
			session.close();
			return results;
		} catch (Exception ex) {
			return new ArrayList<carLanding>();
		}

		
	}

	@Override
	public long getAllCountSearch(String searchValue, String yearStart, String yearEnd, String make, String model,
			String categorySearch) {
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			
			Query query =null;
			if(searchValue.equalsIgnoreCase("")) {
				 query = session.createQuery("select count(*) FROM carLanding where "
						+ " model like '%"+model+"%' and "
						+ " make like '%"+make+"%' and "
						+ " year < "+yearEnd+" and "
						+ " year > "+yearStart+" and "
						+ " category like '%"+categorySearch+"%' "
				 		+ "order by dateAdd desc");
			}else {
			 query = session.createQuery("select count(*) FROM carLanding where"
					+ " model like '%"+model+"%' and "
					+ " make like '%"+make+"%' and "
					+ " year < "+yearEnd+" and "
					+ " year > "+yearStart+" and "
					+ " category like '%"+categorySearch+"%' and ( "
					+ " uuid like '%"+searchValue+"%' or "
					+ " model like '%"+searchValue+"%' or "
					+ " make like '%"+searchValue+"%' or "
					+ " color like '%"+searchValue+"%' or "
					+ " year like '%"+searchValue+"%' or "
					+ " itemNumber like '%"+searchValue+"%' or "
					+ " transmission like '%"+searchValue+"%' or "
					+ " damageDescription like '%"+searchValue+"%' or "
					+ " category like '%"+searchValue+"%') "
					+ " order by dateAdd desc");
			}
			
			Number results=(Number) (query).uniqueResult();

			tx1.commit();
			session.close();
			return (long) results;
		} catch (Exception ex) {
			return 0;
		}
		

	}

	@Override
	public List<carLanding> getAllGroupsOfCategory() {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("carLanding.getAllGroupsOfCategory");

		 @SuppressWarnings("unchecked")
		List<carLanding> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}


}
