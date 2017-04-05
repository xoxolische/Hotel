package hotel.services;

import java.util.List;

import hotel.model.Reservation;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface ReservationService{

    void add(Reservation reservation);
    void delete(int id);
    
    Reservation getById(int id);
    List<Reservation> getAll();

}
