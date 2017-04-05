package hotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.HotelRoomDao;
import hotel.model.BookedNumberInfo;
import hotel.model.Guest;
import hotel.model.HotelRoom;
import hotel.model.LegalEntity;
import hotel.model.OccupiedNumberInfo;

public class HotelRoomDaoImpl implements HotelRoomDao{
    
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    
    private static final String SQL_ADD_ROOM = "INSERT INTO hotel_room(rnumber, rclass, capacity, `floor`, id_price_list) VALUES (?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE_ROOM = "UPDATE hotel_room SET rnumber=?, rclass=?, capacity=?, floor=?, id_price_list=? WHERE id=?";
    
    private static final String SQL_DELETE_ROOM = "DELETE FROM hotel_room WHERE id=?";
    
    private static final String SQL_GET_BY_ID_ROOM = "SELECT * FROM hotel_room WHERE id=?";
    
    private static final String SQL_ALL_ROOMS = "SELECT * FROM hotel_room";
    
    private static final String SQL_ALL_BOOKED_ROOMS = "select * from hotel_room";
    
    private static final String SQL_FIND_ROOMS_ANYCLASS = SQL_ALL_ROOMS + " WHERE floor=? AND capacity=?";
    
    private static final String SQL_GET_ROOMS_BY_CLASS = SQL_FIND_ROOMS_ANYCLASS + " AND rclass=?";
    
    private static final String SQL_ALL_FREE_ROOMS = "select * from hotel_room";
    
    private static final String SQL_GET_BY_NUMBER_ROOM = "SELECT * FROM hotel_room WHERE rnumber=?";
    
    private static final String SQL_GET_BOOKED_NUMBER_DETAILS_BY_INDIVIDUAL = "SELECT * FROM reservation INNER JOIN hotel_room ON reservation.id_hotel_room=hotel_room.id INNER JOIN individual ON reservation.id_individual=individual.id WHERE reservation.id_individual=?;";
    
    private static final String SQL_GET_BOOKED_NUMBER_DETAILS_BY_LEGAL_ENTITY = "SELECT * FROM reservation INNER JOIN hotel_room ON reservation.id_hotel_room=hotel_room.id INNER JOIN legal_entity ON reservation.id_legal_entity=legal_entity.id WHERE reservation.id_legal_entity=?;";
    
    private static final String SQL_GET_FREE_HOTEL_ROOM_DETAIS = "SELECT * FROM hotel_room WHERE id NOT IN (SELECT id_hotel_room FROM reservation WHERE ? BETWEEN reservation.arrival_date AND ADDDATE(reservation.arrival_date, reservation.days-1)) AND id NOT IN (SELECT id_hotel_room FROM guest WHERE ? BETWEEN guest.arrival_date AND guest.departure_date-1)";
    
    private static final String SQL_GET_BOOKED_HOTEL_ROOM_DETAIS = "SELECT * FROM hotel_room WHERE id IN (SELECT id_hotel_room FROM reservation WHERE ? BETWEEN reservation.arrival_date AND ADDDATE(reservation.arrival_date, reservation.days-1)) OR id IN (SELECT id_hotel_room FROM guest WHERE ? BETWEEN guest.arrival_date AND guest.departure_date-1)";
    
    private static final String SQL_GET_OCCUPIED_HOTEL_ROOM_DETAIS = "SELECT * FROM guest INNER JOIN hotel_room ON guest.id_hotel_room=hotel_room.id INNER JOIN individual ON guest.id_individual=individual.id WHERE guest.id_individual=?;";
    
    private static final String SQL_GET_OCCUPIED_HOTEL_ROOMS = "";

    private static final String SQL_GET_BOOKED_NUMBER_INFO = "";

    private static final String SQL_GET_ALL_BOOKED_NUMBERS_LEGAL_ENTITY = null;
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(HotelRoom hm){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_ROOM);
	    prepared_stmt.setInt(1, hm.getNumber());	    
	    prepared_stmt.setInt(2, hm.getrClass());
	    prepared_stmt.setInt(3, hm.getCapacity());
	    prepared_stmt.setInt(4, hm.getFloor());
	    prepared_stmt.setLong(5, hm.getIdPriceList());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    @Override
    public void update(HotelRoom hm){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_UPDATE_ROOM);
	    prepared_stmt.setInt(1, hm.getNumber());	    
	    prepared_stmt.setInt(2, hm.getrClass());
	    prepared_stmt.setInt(3, hm.getCapacity());
	    prepared_stmt.setInt(4, hm.getFloor());
	    prepared_stmt.setLong(5, hm.getIdPriceList());
	    prepared_stmt.setLong(6, hm.getId());
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_ROOM);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public HotelRoom getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_ROOM);
	    prepared_stmt.setInt(1, id);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getHotelRoomObj(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    @Override
    public List<HotelRoom> getAll(){
	List<HotelRoom> list = new ArrayList<HotelRoom>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_ROOMS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getHotelRoomObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    
    @Override
    public ArrayList<HotelRoom> getBookedRooms(){
	ArrayList<HotelRoom> list = new ArrayList<HotelRoom>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_BOOKED_ROOMS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getHotelRoomObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return list;
    }
    
    @Override
    public ArrayList<HotelRoom> getFreeRooms(){
	ArrayList<HotelRoom> list = new ArrayList<HotelRoom>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_FREE_ROOMS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getHotelRoomObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return list;
    }
    
    @Override
    public ArrayList<HotelRoom> searchRooms(int rClass, int floor, int rPlaces){
	ArrayList<HotelRoom> list = new ArrayList<HotelRoom>();
	ResultSet res = null;
	
	try {
	    if(rClass!=0){
		prepared_stmt = con.prepareStatement(SQL_GET_ROOMS_BY_CLASS);
		prepared_stmt.setInt(3, rClass);		
	    }
	    else{
		prepared_stmt = con.prepareStatement(SQL_FIND_ROOMS_ANYCLASS);
	    }
	    prepared_stmt.setInt(1, floor);
	    prepared_stmt.setInt(2, rPlaces);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getHotelRoomObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return list;
    }
    
    @Override
    public HotelRoom getByNumber(int no){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_NUMBER_ROOM);
	    prepared_stmt.setInt(1, no);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getHotelRoomObj(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    @Override
    public ArrayList<BookedNumberInfo> getBookedNumbersDetailsIndividal(int individual_id){
	ResultSet res = null;
	ArrayList<BookedNumberInfo> list = new ArrayList<BookedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BOOKED_NUMBER_DETAILS_BY_INDIVIDUAL);
	    prepared_stmt.setInt(1, individual_id);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getBookedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<BookedNumberInfo> getBookedNumbersDetailsLegalEntity(int legal_entity_id){
	ResultSet res = null;
	ArrayList<BookedNumberInfo> list = new ArrayList<BookedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BOOKED_NUMBER_DETAILS_BY_LEGAL_ENTITY);
	    prepared_stmt.setInt(1, legal_entity_id);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getBookedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<HotelRoom> getFreeNumbersDetails(Date date){
	ResultSet res = null;
	ArrayList<HotelRoom> list = new ArrayList<HotelRoom>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_FREE_HOTEL_ROOM_DETAIS);
	    prepared_stmt.setDate(1, date);
	    prepared_stmt.setDate(2, date);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getHotelRoomObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<OccupiedNumberInfo> getOccupiedNumbersDetails(Guest guest){
	ResultSet res = null;
	ArrayList<OccupiedNumberInfo> list = new ArrayList<OccupiedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_OCCUPIED_HOTEL_ROOM_DETAIS);
	    prepared_stmt.setLong(1, guest.getId());
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getOccupiedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<OccupiedNumberInfo> getAllOccupiedNumbers(){
	ResultSet res = null;
	ArrayList<OccupiedNumberInfo> list = new ArrayList<OccupiedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_OCCUPIED_HOTEL_ROOMS);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getOccupiedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsIndividual(){
	ResultSet res = null;
	ArrayList<BookedNumberInfo> list = new ArrayList<BookedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BOOKED_NUMBER_INFO);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getBookedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<BookedNumberInfo> getAllBookedNumbersDetailsLegalEntity(LegalEntity legal_entity){
	ResultSet res = null;
	ArrayList<BookedNumberInfo> list = new ArrayList<BookedNumberInfo>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_ALL_BOOKED_NUMBERS_LEGAL_ENTITY);
	    prepared_stmt.setLong(1, legal_entity.getId());
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getBookedNumberInfoObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    /**
     * Section below contains Object row mapper methods
     */
    private HotelRoom getHotelRoomObj(ResultSet result){
	HotelRoom room = new HotelRoom();
	try {
	    room.setId(result.getInt(1));
	    room.setNumber(result.getInt(2));
	    room.setrClass(result.getInt(3));
	    room.setCapacity(result.getInt(4));
	    room.setFloor(result.getInt(5));
	    room.setIdPriceList(result.getInt(6));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return room;
    }
    
    private BookedNumberInfo getBookedNumberInfoObject(ResultSet result){
	BookedNumberInfo bni = new BookedNumberInfo();
	try {
	    bni.setNoNumber(result.getInt("number"));
	    bni.setNoClass(result.getInt("class"));
	    bni.setNoCapacity(result.getInt("capacity"));
	    bni.setNoFloor(result.getInt("floor"));
	    bni.setGuestArrivalDate(result.getDate("arrival_date"));
	    bni.setBookingDate(result.getDate("booking_date"));
	    bni.setDaysNum(result.getInt("days"));
	    bni.setName(result.getString("name"));
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return bni;
    }
    
    private OccupiedNumberInfo getOccupiedNumberInfoObject(ResultSet result){
	OccupiedNumberInfo oni = new OccupiedNumberInfo();
	try {
	    oni.setNoNumber(result.getInt("number"));
	    oni.setNoClass(result.getInt("class"));
	    oni.setNoCapacity(result.getInt("capacity"));
	    oni.setNoFloor(result.getInt("floor"));
	    oni.setGuestArrivalDate(result.getDate("arrival_date"));
	    oni.setGuestDepartureDate(result.getDate("departure_date"));
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return oni;
    }
}
