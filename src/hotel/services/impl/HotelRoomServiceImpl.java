package hotel.services.impl;

import java.util.ArrayList;

import hotel.dao.HotelRoomDao;
import hotel.dao.impl.HotelRoomDaoImpl;
import hotel.model.HotelRoom;
import hotel.services.HotelRoomService;

public class HotelRoomServiceImpl implements HotelRoomService{

    @Override
    public ArrayList<HotelRoom> bookedRooms(){
	HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();
	ArrayList<HotelRoom> bRooms= new ArrayList<HotelRoom>();
	bRooms = hotelRoomDao.getBookedRooms();
	return bRooms;
    }

    @Override
    public ArrayList<HotelRoom> freeRooms(){
	HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();
	ArrayList<HotelRoom> fRooms= new ArrayList<HotelRoom>();
	fRooms = hotelRoomDao.getFreeRooms();
	return fRooms;
    }

    @Override
    public ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces){
	HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();
	ArrayList<HotelRoom> foundRooms = new ArrayList<HotelRoom>();
	foundRooms = hotelRoomDao.searchRooms(rClass, floor, rPlaces);
	return foundRooms;
    }

}
