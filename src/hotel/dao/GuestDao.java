package hotel.dao;

import java.util.List;

import hotel.model.Guest;

public interface GuestDao{

    void add(Guest guest);
    
    void delete(int id);
    
    Guest getById(int id);
    
    List<Guest> getAll();

}
