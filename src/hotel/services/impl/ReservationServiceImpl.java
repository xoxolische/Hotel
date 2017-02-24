package hotel.services.impl;

import java.sql.Date;

import hotel.dao.HotelRoomDao;
import hotel.dao.ReservationDao;
import hotel.dao.impl.HotelRoomDaoImpl;
import hotel.dao.impl.ReservationDaoImpl;
import hotel.model.Reservation;
import hotel.services.ReservationService;

public class ReservationServiceImpl implements ReservationService{

    @Override
    public void createReservation(int no, Date dateF, Date dateE){
	ReservationDao reservationDao = new ReservationDaoImpl();
	HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();
		
	Reservation reservation = new Reservation();
	reservation.setBookingDate(dateF);
	reservation.setArrivalDate(dateE);
	reservation.setIdHotelRoom(hotelRoomDao.getByNumber(no).getId());
	
	reservation.setDays(1);
	reservation.setPersons(1);
	reservation.setIdIndividual(1);
	reservation.setIdLegalEntity(1);
	
	reservationDao.add(reservation);
    }

}
