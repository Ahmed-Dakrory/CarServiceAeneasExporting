/**
 * 
 */
package main.com.carService.invoiceCars;

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
public class invoiceCarRepositoryImpl implements invoiceCarRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public invoiceCar addinvoiceCar(invoiceCar data) {
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
	public List<invoiceCar> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoiceCar.getAll");

				 @SuppressWarnings("unchecked")
				List<invoiceCar> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(invoiceCar data)throws Exception {
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
	public invoiceCar getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoiceCar.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<invoiceCar> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<invoiceCar> getAllByinvoiceId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("invoiceCar.getAllByinvoiceId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<invoiceCar> results=query.list();
		
			 return results;
		
	}
	


}
