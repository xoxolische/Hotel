package hotel.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import hotel.model.BookedNumberInfo;
import hotel.model.Guest;
import hotel.model.HotelRoom;
import hotel.model.OccupiedNumberInfo;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface HotelRoomService{
	
    void add(HotelRoom hotelRoom);
    void update(HotelRoom hm);
    void delete(int id);
    
    HotelRoom getById(int id);
    
    List<HotelRoom> getAll();
    ArrayList<HotelRoom> getBookedRooms();
    ArrayList<HotelRoom> getFreeRooms();
    ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces);
    HotelRoom getByNumber(int no);
    ArrayList<BookedNumberInfo> getBookedNumbersDetailsIndividal(int individual_id);
    ArrayList<BookedNumberInfo> getBookedNumbersDetailsLegalEntity(int legal_entity_id);
    ArrayList<HotelRoom> getFreeNumbersDetails(Date date);
    ArrayList<OccupiedNumberInfo> getOccupiedNumbersDetails(Guest guest);
    ArrayList<OccupiedNumberInfo> getAllOccupiedNumbers();
    ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsIndividual();
    ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsLegalEntity();

}
