package hotel.services.impl;

import java.util.ArrayList;

import hotel.dao.ClientDao;
import hotel.dao.impl.ClientDaoImpl;
import hotel.services.ClientService;
import hotel.ui.object_protytypes.Client;

public class ClientServiceImpl implements ClientService{
    
    @Override
    public ArrayList<Client> getMovedOff(){
	ArrayList<Client> movedOff = new ArrayList<Client>();
	ClientDao gDao = new ClientDaoImpl();
	movedOff = gDao.getMovedOff();
	return movedOff;
    }

    @Override
    public ArrayList<Client> getLivingNow(){
	ArrayList<Client> livingNow = new ArrayList<Client>();
	ClientDao gDao = new ClientDaoImpl();
	livingNow = gDao.getLivingNow();
	return livingNow;
    }

}
