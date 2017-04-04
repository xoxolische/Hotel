package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.Guest;
import hotel.model.GuestDetail;

public interface GuestDao{
    
    /*** 
     * DAO interface
     * @author Pavlov Nikita 
     */
    void add(Guest guest);
    
    void delete(int id);
    
    Guest getById(int id);
    
    List<Guest> getAll();
    
    ArrayList<GuestDetail> getAllGuestDetail(int guest_id);
    
    void update(Guest guest);
    
}
