package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.PriceListItem;
import hotel.model.Service;

public interface ServiceDao{
    
    void add(Service service);
    
    void delete(int id);
    
    Service getById(int id);
    
    List<Service> getAll();

    ArrayList<PriceListItem> getServicesFromPriceList();

    ArrayList<PriceListItem> getAllPriceListItems();

}
