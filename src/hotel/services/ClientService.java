package hotel.services;

import java.util.ArrayList;

import hotel.ui.object_protytypes.Client;

public interface ClientService{

    ArrayList<Client> getMovedOff();

    ArrayList<Client> getLivingNow();

}