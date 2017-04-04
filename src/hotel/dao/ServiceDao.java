package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.PriceListItem;
import hotel.model.Service;
import hotel.model.ClientServiceInfo;

public interface ServiceDao{
    /*** 
     * DAO interface
     * @author Pavlov Nikita 
     */
    void add(Service service);
    
    void delete(int id);
    
    Service getById(int id);
    
    List<Service> getAll();

    ArrayList<PriceListItem> getServicesFromPriceList(int pricelist_id);
    
    ArrayList<PriceListItem> getAllPriceListItems();
    
    ArrayList<Service> getServicesByGuestId(int guest_id);
    //methods form Roman's project
    ArrayList<ClientServiceInfo> getServicesByClient(String clientName);
    
    ArrayList<PriceListItem> getServicesFromPriceListItem();
    
    void orderServiceByClient(String clName, int quantity, String servName);
    
}
