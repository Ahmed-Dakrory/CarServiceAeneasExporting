/**
 * 
 */
package main.com.carService.customTransportation;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface customtransportationRepository {

	public List<customtransportation> getAll();
	public List<customtransportation> getAllByCustomId(int id);
	public List<customtransportation> getAllByDocReceiptId(int id);
	public customtransportation addcustomtransportation(customtransportation data);
	public customtransportation getById(int id);
	public boolean delete(customtransportation data)throws Exception;
}
