package hotel.dao;

import java.util.List;

import hotel.model.PriceList;

public interface PriceListDao{
    /*** 
     * DAO interface
     * @author Pavlov Nikita 
     */
    void add(PriceList priceList);
    
    void delete(int id);
    
    PriceList getById(int id);
    
    List<PriceList> getAll();
}
