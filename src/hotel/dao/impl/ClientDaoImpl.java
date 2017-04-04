package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import hotel.dao.ClientDao;

public class ClientDaoImpl implements ClientDao{
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    private static final String SQL_LIVING_NOW_CLIENTS = "SELECT DISTINCT * FROM individual WHERE id IN (SELECT DISTINCT id_individual FROM guest WHERE curdate() BETWEEN guest.arrival_date AND guest.departure_date);";
    private static final String SQL_MOVEDOFF_CLIENTS = "SELECT DISTINCT * FROM individual WHERE id IN (SELECT DISTINCT id_individual FROM guest WHERE curdate() > guest.departure_date);";
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt; 
    
    /*
    private Client getClientObject(ResultSet result){
	Client client = new Client();
	try {
	    client.setId(result.getInt(1));
	    client.setArrivalDate(result.getDate(2));
	    client.setDepartureDate(result.getDate(3));
	    client.setAdditionalSpace(result.getBoolean(4));
	    client.setIdIndividual(result.getInt(5));
	    client.setIdHotelRoom(result.getInt(6));
	    client.setName(result.getString(7));
	    client.setLivNo(result.getInt(8));
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return client;
    }
	
    @Override
    public ArrayList<Client> getMovedOff(){
	ArrayList<Client> list = new ArrayList<Client>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_MOVEDOFF_CLIENTS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getClientObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }

    @Override
    public ArrayList<Client> getLivingNow(){
	ArrayList<Client> list = new ArrayList<Client>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_LIVING_NOW_CLIENTS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getClientObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
     */
    
}
