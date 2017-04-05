package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.GuestDao;
import hotel.model.Guest;
import hotel.model.GuestDetail;

public class GuestDaoImpl implements GuestDao{
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    
    private static final String SQL_ADD_GUEST = "INSERT INTO guest(arrival_date, departure_date, additional_space, id_individual, id_hotel_room) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_GUEST = "UPDATE guest SET arrival_date=?, departure_date=?, additional_space=?, id_individual=?, id_hotel_room=? WHERE id=?";
    private static final String SQL_DELETE_GUEST = "DELETE FROM guest WHERE id=?";
    private static final String SQL_GET_BY_ID_GUEST = "SELECT * FROM guest WHERE id=?";
    private static final String SQL_ALL_GUESTS = "SELECT * FROM guest";
    private static final String SQL_ALL_GUEST_DETAIL = "SELECT * FROM guest INNER JOIN individual ON guest.id_individual=individual.id INNER JOIN hotel_room ON guest.id_hotel_room=hotel_room.id WHERE guest.id=?;";
    //private static final String SQL_MOVEDOFF_GUESTS = null;
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Guest guest){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_GUEST);
	    prepared_stmt.setDate(1, guest.getArrivalDate());	    
	    prepared_stmt.setDate(2, guest.getDepartureDate());
	    prepared_stmt.setBoolean(3, guest.isAdditionalSpace());
	    prepared_stmt.setLong(4, guest.getIdIndividual());
	    prepared_stmt.setLong(5, guest.getIdHotelRoom());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void update(Guest guest){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_UPDATE_GUEST);
	    prepared_stmt.setDate(1, guest.getArrivalDate());	    
	    prepared_stmt.setDate(2, guest.getDepartureDate());
	    prepared_stmt.setBoolean(3, guest.isAdditionalSpace());
	    prepared_stmt.setLong(4, guest.getIdIndividual());
	    prepared_stmt.setLong(5, guest.getIdHotelRoom());
	    prepared_stmt.setLong(6, guest.getId());
	    
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
		return getGuestObject(res);
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
		list.add(getGuestObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    @Override
    public List<GuestDetail> getAllGuestDetail(int guest_id){
	ResultSet res = null;
	List<GuestDetail> list = new ArrayList<GuestDetail>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_GUEST_DETAIL);
	    prepared_stmt.setInt(1, guest_id);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getGuestDetailObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    /**
     * Section below contains Object row mapper methods
     */
    
    private Guest getGuestObject(ResultSet result){
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
    
    private GuestDetail getGuestDetailObject(ResultSet result){
	GuestDetail guest = new GuestDetail();
	try {
	    guest.setClientName(result.getString("name"));
	    guest.setArrivDate(result.getDate("arrival_date"));
	    guest.setDepartDate(result.getDate("departure_date"));
	    guest.setNoNumber(result.getInt("number"));
	    guest.setNoClass(result.getInt("class"));
	    guest.setNoFloor(result.getInt("floor"));	
	    guest.setNoCapacity(result.getInt("capacity"));	
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return guest;
    }
}
