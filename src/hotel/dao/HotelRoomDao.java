package hotel.dao;

import java.util.ArrayList;
import java.util.List;
import hotel.model.HotelRoom;


public interface HotelRoomDao{
    
    void add(HotelRoom hotelRoom);
    
    void delete(int id);
    
    HotelRoom getById(int id);
    
    List<HotelRoom> getAll();

    ArrayList<HotelRoom> getBookedRooms();

    ArrayList<HotelRoom> getFreeRooms();

    ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces);

    HotelRoom getByNumber(int no);

}
