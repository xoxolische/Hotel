package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.ReservationDao;
import hotel.model.Reservation;

public class ReservationDaoImpl implements ReservationDao{

    private static final String SQL_ADD_RESERVATION = "INSERT INTO reservation(booking_date, arrival_date, days, persons, booking_cancellation, cancellation_reason, id_hotel_room, id_legal_entity, id_individual) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_RESERVATION = "UPDATE reservation SET booking_date=?, arrival_date=?, days=?, persons=?, booking_cancellation=?, cancellation_reason=?, id_hotel_room=?, id_legal_entity=?, id_individual=? WHERE id=?";
    private static final String SQL_DELETE_RESERVATION = "DELETE FROM reservation WHERE id=?";
    private static final String SQL_GET_BY_ID_RESERVATION = "SELECT * FROM reservation WHERE id=?";
    private static final String SQL_ALL_RESERVATIONS = "SELECT * FROM reservation";
    private Connection con = new ConnectionFactory().getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(Reservation reservation){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_RESERVATION);
	    prepared_stmt.setDate(1, reservation.getBookingDate());
	    prepared_stmt.setDate(2, reservation.getArrivalDate());	    
	    prepared_stmt.setInt(3, reservation.getDays());
	    prepared_stmt.setInt(4, reservation.getPersons());
	    
	    if(reservation.getBookingCancelationDate()!=null){
		prepared_stmt.setDate(5, reservation.getBookingCancelationDate());
	    }
	    else{
		prepared_stmt.setNull(5, Types.INTEGER);
	    }
	    if(reservation.getCancelationReason()!=null){
		prepared_stmt.setString(6, reservation.getCancelationReason());
	    }
	    else{
		prepared_stmt.setNull(6, Types.VARCHAR);
	    }
	    prepared_stmt.setInt(7, reservation.getIdHotelRoom());
	    prepared_stmt.setInt(8, reservation.getIdLegalEntity());
	    prepared_stmt.setInt(9, reservation.getIdIndividual());
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_RESERVATION);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Reservation getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_RESERVATION);
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
    public List<Reservation> getAll(){
	List<Reservation> list = new ArrayList<Reservation>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_RESERVATIONS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private Reservation getObj(ResultSet result){
	Reservation reservation = new Reservation();
	try {
	    reservation.setId(result.getInt(1));
	    reservation.setBookingDate(result.getDate(2));
	    reservation.setArrivalDate(result.getDate(3));
	    reservation.setDays(result.getInt(4));	
	    reservation.setPersons(result.getInt(5));
	    reservation.setBookingCancelationDate(result.getDate(6));
	    reservation.setCancelationReason(result.getString(7));
	    reservation.setIdHotelRoom(result.getInt(8));
	    reservation.setIdLegalEntity(result.getInt(9));
	    reservation.setIdIndividual(result.getInt(10));
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return reservation;
    }


}
