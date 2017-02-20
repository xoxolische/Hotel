package hotel.services.impl;

import java.util.ArrayList;



import hotel.dao.GuestDao;
import hotel.dao.impl.GuestDaoImpl;
import hotel.model.Guest;
import hotel.services.GuestService;
import hotel.ui.object_protytypes.Client;

public class GuestServiceImpl implements GuestService{

    @Override
    public ArrayList<Client> getMovedOff(){
	ArrayList<Client> movedOff = new ArrayList<Client>();
	GuestDao gDao = new GuestDaoImpl();
	movedOff = gDao.getMovedOff();
	return movedOff;
    }

}
