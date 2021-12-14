/**
 * 
 */
package main.com.carService.car;

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

import main.com.carService.loginNeeds.user;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class carRepositoryImpl implements carRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public car addcar(car data) {
		try{

			data.setLastUpdate(Calendar.getInstance());
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
	public long getAllCountSearch(int start, int number,String searchValue,int role,int state,int useridAny) {
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			
			Query query =null;
			String stateQuery = "";
			if(state==0) {
				stateQuery = " (vehicle.state = 0 or vehicle.state = 1 or vehicle.state = 2 or vehicle.state = 3 ) ";
			}else if(state==1) {
				stateQuery = " (vehicle.state = 4 or vehicle.state = 5) ";
			}else if(state==2) {
				stateQuery = " (vehicle.state = 6 or vehicle.state = 7) ";
			}else if(state==4) {
				stateQuery = " ( vehicle.state = 8) ";
			}else if(state==3) {
				stateQuery = " vehicle.id != 0 ";
			}
			String searchQuery = "";
			searchQuery = " ( vehicle.uuid like '%"+searchValue+"%' or "
					+ " vehicle.model like '%"+searchValue+"%' or "
					+ " vehicle.make like '%"+searchValue+"%' or "
					+ " vehicle.color like '%"+searchValue+"%' or "
					+ " userShipper.company like '%"+searchValue+"%' or "
					+ " userVendor.company like '%"+searchValue+"%' or "
					+ " vehicle.year like '%"+searchValue+"%' ) ";
			
			if(searchValue.equalsIgnoreCase("")) {
				if(role==user.ROLE_MAIN) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.mainId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false  order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_MAIN2) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.mainTwoId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_SHIPPER) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.shipperId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_VENDOR) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.vendorId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_CONGSIGNEE) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.consigneeId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_CUSTOMER) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where vehicle.customerId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}
			}else {
				if(role==user.ROLE_MAIN) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.mainId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false  order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_SHIPPER) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.shipperId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_MAIN2) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.mainTwoId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_VENDOR) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.vendorId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_CONGSIGNEE) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.consigneeId = "+String.valueOf(useridAny)+" and "+stateQuery+"and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}else if(role==user.ROLE_CUSTOMER) {
					 query = session.createQuery("select count(*) FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor  where "+searchQuery+" and vehicle.customerId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
				}
			}
			System.out.println("-----------------------------------");
			System.out.println(query.getQueryString());
			

			
			Number results=(Number) (query).uniqueResult();

			tx1.commit();
			session.close();
			return (long) results;
		} catch (Exception ex) {
			return 0;
		}
		

	}

	
	

	@Override
	public List<car> getAllWithPagination(int start, int number,String searchValue,int role,int state,int useridAny) {
		
			 
			 try {
					session = sessionFactory.openSession();
					Transaction tx1 = session.beginTransaction();
					
					
					Query query =null;
					String stateQuery = "";
					if(state==0) {
						stateQuery = " (vehicle.state = 0 or vehicle.state = 1 or vehicle.state = 2 or vehicle.state = 3 ) ";
					}else if(state==1) {
						stateQuery = " (vehicle.state = 4 or vehicle.state = 5) ";
					}else if(state==2) {
						stateQuery = " (vehicle.state = 6 or vehicle.state = 7) ";
					}else if(state==4) {
						stateQuery = " ( vehicle.state = 8) ";
					}else if(state==3) {
						stateQuery = " vehicle.id != 0 ";
					}
					String searchQuery = "";
					searchQuery = " ( vehicle.uuid like '%"+searchValue+"%' or "
							+ " vehicle.model like '%"+searchValue+"%' or "
							+ " vehicle.make like '%"+searchValue+"%' or "
							+ " vehicle.color like '%"+searchValue+"%' or "
							+ " userShipper.company like '%"+searchValue+"%' or "
							+ " userVendor.company like '%"+searchValue+"%' or "
							+ " vehicle.year like '%"+searchValue+"%' ) ";
					
					
					System.out.println(stateQuery);
					if(searchValue.equalsIgnoreCase("")) {
						if(role==user.ROLE_MAIN) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.mainId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false  order by cargoRecieved desc");
						}else if(role==user.ROLE_MAIN2) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.mainTwoId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by cargoRecieved desc");
						}else if(role==user.ROLE_SHIPPER) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.shipperId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by cargoRecieved desc");
						}else if(role==user.ROLE_VENDOR) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.vendorId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by cargoRecieved desc");
						}else if(role==user.ROLE_CONGSIGNEE) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.consigneeId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by cargoRecieved desc");
						}else if(role==user.ROLE_CUSTOMER) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where vehicle.customerId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by cargoRecieved desc");
						}
					}else {
						if(role==user.ROLE_MAIN) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" and vehicle.mainId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false  order by vehicle.cargoRecieved desc");
						}else if(role==user.ROLE_MAIN2) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" vehicle.mainTwoId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
						}else if(role==user.ROLE_SHIPPER) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" vehicle.shipperId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
						}else if(role==user.ROLE_VENDOR) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" vehicle.vendorId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
						}else if(role==user.ROLE_CONGSIGNEE) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" vehicle.consigneeId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
						}else if(role==user.ROLE_CUSTOMER) {
							 query = session.createQuery("select vehicle FROM car vehicle  left JOIN vehicle.shipperId shipper left JOIN shipper.userId userShipper left JOIN vehicle.vendorId vendor  left JOIN vendor.userId userVendor   where "+searchQuery+" vehicle.customerId = "+String.valueOf(useridAny)+" and "+stateQuery+" and vehicle.deleted = false order by vehicle.cargoRecieved desc");
						}
					}
					System.out.println("-----------------------------------");
					System.out.println(query.getQueryString());
					
					 query.setFirstResult(start);
					 query.setMaxResults(number);
					 
					 @SuppressWarnings("unchecked")
					List<car> results=query.list();

					tx1.commit();
					session.close();
					return results;
				} catch (Exception ex) {
					return new ArrayList<car>();
				}
		
	}

	
	
	
	@Override
	public List<car> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAll");

				 @SuppressWarnings("unchecked")
				List<car> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(car data)throws Exception {
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
	public car getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	

	@Override
	public List<car> getAllWareHouseForMainUser(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForMainUser").setInteger("userId",userId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllWareHouseForVendor(int vendorId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForVendor").setInteger("vendorId",vendorId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllWareHouseForShipper(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllWareHouseForCustomer(int customerId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForCustomer").setInteger("customerId",customerId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllWareHouseForConsignee(int consigneeId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForConsignee").setInteger("consigneeId",consigneeId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForMainUser(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForMainUser").setInteger("userId",userId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForVendor(int vendorId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForVendor").setInteger("vendorId",vendorId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForShipper(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForCustomer(int customerId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForCustomer").setInteger("customerId",customerId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForConsignee(int consigneeId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForConsignee").setInteger("consigneeId",consigneeId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForMainUser(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForMainUser").setInteger("userId",userId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForVendor(int vendorId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForVendor").setInteger("vendorId",vendorId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForShipper(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForCustomer(int customerId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForCustomer").setInteger("customerId",customerId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForConsignee(int consigneeId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForConsignee").setInteger("consigneeId",consigneeId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public car getByVin(String vinId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getByVin").setString("uuid",vinId);

				 @SuppressWarnings("unchecked")
				List<car> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}

	@Override
	public List<car> getAllWithAllowSendState(boolean state) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWithAllowSendState").setBoolean("state", state);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForMainUser(int userId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForMainUser").setInteger("userId",userId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForVendor(int vendorId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForVendor").setInteger("vendorId",vendorId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForShipper(int shipperId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForCustomer(int custmerId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForCustomer").setInteger("custmerId",custmerId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForConsignee(int consigneeId) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForConsignee").setInteger("consigneeId",consigneeId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllWareHouseForMainUserTwo(int mainTwoId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllWareHouseForMainUserTwo").setInteger("mainTwoId",mainTwoId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllDryCargoForMainUserTwo(int mainTwoId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllDryCargoForMainUserTwo").setInteger("mainTwoId",mainTwoId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightInTransitForMainUserTwo(int mainTwoId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightInTransitForMainUserTwo").setInteger("mainTwoId",mainTwoId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllFrightSentForPaymentForMainUserTwo(int mainTwoId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllFrightSentForPaymentForMainUserTwo").setInteger("mainTwoId",mainTwoId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForMainUser(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForMainUser").setInteger("userId",userId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForMainUserTwo(int mainTwoId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForMainUserTwo").setInteger("mainTwoId",mainTwoId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForVendor(int vendorId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForVendor").setInteger("vendorId",vendorId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForShipper(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForCustomer(int custmerId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForCustomer").setInteger("custmerId",custmerId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<car> getAllForConsignee(int consigneeId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllForConsignee").setInteger("consigneeId",consigneeId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}




	@Override
	public List<car> getAllPayedCarsByShipper(int shipperId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("car.getAllPayedCarsByShipper").setInteger("shipperId",shipperId);

		 @SuppressWarnings("unchecked")
		List<car> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}
	


}
