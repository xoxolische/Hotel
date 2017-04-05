package hotel.services;

import java.util.List;

import hotel.model.PriceList;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface PriceListService{
	
    void add(PriceList priceList);
    void delete(int id);
    
    PriceList getById(int id);
    List<PriceList> getAll();

}
