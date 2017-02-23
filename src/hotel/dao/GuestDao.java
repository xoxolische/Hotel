package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.Guest;
import hotel.ui.object_protytypes.Client;

public interface GuestDao{

    void add(Guest guest);
    
    void delete(int id);
    
    Guest getById(int id);
    
    List<Guest> getAll();

}
