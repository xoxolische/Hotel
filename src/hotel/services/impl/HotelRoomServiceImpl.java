package hotel.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.HotelRoomDao;
import hotel.dao.impl.HotelRoomDaoImpl;
import hotel.model.BookedNumberInfo;
import hotel.model.Guest;
import hotel.model.HotelRoom;
import hotel.model.OccupiedNumberInfo;
import hotel.services.HotelRoomService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class HotelRoomServiceImpl implements HotelRoomService{
	
	private static HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();

	@Override
	public void add(HotelRoom hotelRoom) {
		hotelRoomDao.add(hotelRoom);
	}

	@Override
	public void update(HotelRoom hm) {
		hotelRoomDao.update(hm);
	}

	@Override
	public void delete(int id) {
		hotelRoomDao.delete(id);
	}

	@Override
	public HotelRoom getById(int id) {
		return hotelRoomDao.getById(id);
	}

	@Override
	public List<HotelRoom> getAll() {
		return hotelRoomDao.getAll();
	}

	@Override
	public ArrayList<HotelRoom> getBookedRooms() {
		return hotelRoomDao.getBookedRooms();
	}

	@Override
	public ArrayList<HotelRoom> getFreeRooms() {
		return hotelRoomDao.getFreeRooms();
	}

	@Override
	public ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces) {
		return hotelRoomDao.searchRooms(rClass, floor, rPlaces);
	}

	@Override
	public HotelRoom getByNumber(int no) {
		return hotelRoomDao.getByNumber(no);
	}

	@Override
	public ArrayList<BookedNumberInfo> getBookedNumbersDetailsIndividal(int individual_id) {
		return hotelRoomDao.getAllBookedNumbersDetailsIndividual();
	}

	@Override
	public ArrayList<BookedNumberInfo> getBookedNumbersDetailsLegalEntity(int legal_entity_id) {
		return hotelRoomDao.getAllBookedNumbersDetailsLegalEntity();
	}

	@Override
	public ArrayList<HotelRoom> getFreeNumbersDetails(Date date) {
		return hotelRoomDao.getFreeNumbersDetails(date);
	}

	@Override
	public ArrayList<OccupiedNumberInfo> getOccupiedNumbersDetails(Guest guest) {
		return hotelRoomDao.getOccupiedNumbersDetails(guest);
	}

	@Override
	public ArrayList<OccupiedNumberInfo> getAllOccupiedNumbers() {
		return hotelRoomDao.getAllOccupiedNumbers();
	}

	@Override
	public ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsIndividual() {
		return hotelRoomDao.getAllBookedNumbersDetailsIndividual();
	}

	@Override
	public ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsLegalEntity() {
		return hotelRoomDao.getAllBookedNumbersDetailsLegalEntity();
	}

}
