package hotel.dao;

import java.util.ArrayList;

import hotel.ui.object_protytypes.Client;

public interface ClientDao{
    
    ArrayList<Client> getMovedOff();

    ArrayList<Client> getLivingNow();

}
