package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.Guest;
import hotel.model.GuestDetail;

public interface GuestDao{

    void add(Guest guest);
    
    void delete(int id);
    
    Guest getById(int id);
    
    List<Guest> getAll();

    ArrayList<GuestDetail> getAllGuestDetail();

    ArrayList<GuestDetail> getGuestDetails();

}
