package hotel.services.impl;

import java.util.List;

import hotel.dao.ReservationDao;
import hotel.dao.impl.ReservationDaoImpl;
import hotel.model.Reservation;
import hotel.services.ReservationService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class ReservationServiceImpl implements ReservationService{

	private static ReservationDao reservationDao = new ReservationDaoImpl();
	
	@Override
	public void add(Reservation reservation) {
		reservationDao.add(reservation);
	}

	@Override
	public void delete(int id) {
		reservationDao.delete(id);
	}

	@Override
	public Reservation getById(int id) {
		return reservationDao.getById(id);
	}

	@Override
	public List<Reservation> getAll() {
		return reservationDao.getAll();
	}

}
