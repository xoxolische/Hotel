package hotel.dao;

import java.util.ArrayList;
import java.util.List;

import hotel.model.BookedNumberInfo;
import hotel.model.HotelRoom;
import hotel.model.OccupiedNumberInfo;


public interface HotelRoomDao{
    
    void add(HotelRoom hotelRoom);
    
    void delete(int id);
    
    HotelRoom getById(int id);
    
    List<HotelRoom> getAll();

    ArrayList<HotelRoom> getBookedRooms();

    ArrayList<HotelRoom> getFreeRooms();

    ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces);

    HotelRoom getByNumber(int no);

    ArrayList<BookedNumberInfo> getBookedNumbersDetailsIndividal();

    ArrayList<BookedNumberInfo> getBookedNumbersDetailsLegalEntity();

    ArrayList<HotelRoom> getFreeNumbersDetails();

    ArrayList<OccupiedNumberInfo> getOccupiedNumbersDetails();

    ArrayList<OccupiedNumberInfo> getAllOccupiedNumbers();

    ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsIndividual();

    ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsLegalEntity();

}
