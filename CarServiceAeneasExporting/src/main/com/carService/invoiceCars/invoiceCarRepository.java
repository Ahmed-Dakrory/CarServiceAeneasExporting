/**
 * 
 */
package main.com.carService.invoiceCars;

import java.util.List;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface invoiceCarRepository {

	public List<invoiceCar> getAll();
	public List<invoiceCar> getAllByinvoiceId(int id);
	public invoiceCar addinvoiceCar(invoiceCar data);
	public invoiceCar getById(int id);
	public boolean delete(invoiceCar data)throws Exception;
}
