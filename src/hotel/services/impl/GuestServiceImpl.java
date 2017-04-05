package hotel.services.impl;

import java.util.List;

import hotel.dao.GuestDao;
import hotel.dao.impl.GuestDaoImpl;
import hotel.model.Guest;
import hotel.model.GuestDetail;
import hotel.services.GuestService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class GuestServiceImpl implements GuestService{
	
	private static GuestDao guestDao = new GuestDaoImpl();

	@Override
	public void add(Guest guest) {
		guestDao.add(guest);
	}

	@Override
	public void update(Guest guest) {
		guestDao.update(guest);
	}

	@Override
	public void delete(int id) {
		guestDao.delete(id);
	}

	@Override
	public Guest getById(int id) {
		return guestDao.getById(id);
	}

	@Override
	public List<Guest> getAll() {
		return guestDao.getAll();
	}

	@Override
	public List<GuestDetail> getAllGuestDetail(int guest_id) {
		return guestDao.getAllGuestDetail(guest_id);
	}


}
