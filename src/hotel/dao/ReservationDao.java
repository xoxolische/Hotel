package hotel.dao;

import java.util.List;

import hotel.model.Reservation;

public interface ReservationDao{
    
    void add(Reservation reservation);
    
    void delete(int id);
    
    Reservation getById(int id);
    
    List<Reservation> getAll();
}
