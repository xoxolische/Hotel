package hotel.services;

import java.util.ArrayList;

import hotel.model.HotelRoom;

public interface HotelRoomService{

    ArrayList<HotelRoom> bookedRooms();

    ArrayList<HotelRoom> freeRooms();

    ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces);

}
