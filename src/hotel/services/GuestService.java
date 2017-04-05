package hotel.services;

import java.util.List;

import hotel.model.Guest;
import hotel.model.GuestDetail;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface GuestService{
	
    void add(Guest guest);
    void update(Guest guest);
    void delete(int id);
    
    Guest getById(int id);
    List<Guest> getAll();
    List<GuestDetail> getAllGuestDetail();

}
