package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.GuestDao;
import hotel.model.Guest;

public class GuestDaoImpl implements GuestDao{

    private static final String SQL_ADD_GUEST = null;
    private static final String SQL_DELETE_GUEST = null;
    private static final String SQL_GET_BY_ID_GUEST = null;
    private static final String SQL_ALL_GUESTS = null;
    private Connection con = new ConnectionFactory().getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Guest guest){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_GUEST);
	    prepared_stmt.setDate(1, guest.getArrivalDate());	    
	    prepared_stmt.setDate(2, guest.getDepartureDate());
	    prepared_stmt.setBoolean(3, guest.getAdditionalSpace());
	    prepared_stmt.setInt(4, guest.getIdIndividual());
	    prepared_stmt.setInt(5, guest.getIdHotelRoom());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_GUEST);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Guest getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_GUEST);
	    prepared_stmt.setInt(1, id);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getObj(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public List<Guest> getAll(){
	List<Guest> list = new ArrayList<Guest>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_GUESTS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private Guest getObj(ResultSet result){
	Guest guest = new Guest();
	try {
	    guest.setId(result.getInt(1));
	    guest.setArrivalDate(result.getDate(2));
	    guest.setDepartureDate(result.getDate(3));
	    guest.setAdditionalSpace(result.getBoolean(4));
	    guest.setIdIndividual(result.getInt(5));
	    guest.setIdHotelRoom(result.getInt(6));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return guest;
    }

}