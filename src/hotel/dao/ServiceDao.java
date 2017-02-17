package hotel.dao;

import java.util.List;

import hotel.model.Service;

public interface ServiceDao{
    
    void add(Service service);
    
    void delete(int id);
    
    Service getById(int id);
    
    List<Service> getAll();
}
