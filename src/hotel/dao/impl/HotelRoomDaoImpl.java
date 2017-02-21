package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.HotelRoomDao;
import hotel.model.HotelRoom;

public class HotelRoomDaoImpl implements HotelRoomDao{

    private static final String SQL_ADD_ROOM = "INSERT INTO hotel_room(rnumber, rclass, capacity, `floor`, id_price_list) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_ROOM = "UPDATE hotel_room SET rnumber=?, rclass=?, capacity=?, floor=?, id_price_list=? WHERE id=?";
    
    private static final String SQL_DELETE_ROOM = "DELETE FROM hotel_room WHERE id=?";

    private static final String SQL_GET_BY_ID_ROOM = "SELECT * FROM hotel_room WHERE id=?";

    private static final String SQL_ALL_ROOMS = "SELECT * FROM hotel_room";

    private static final String SQL_ALL_BOOKED_ROOMS = "select * from hotel_room";

    private static final String SQL_FIND_ROOMS_ANYCLASS = SQL_ALL_ROOMS + " WHERE floor=? AND capacity=?";
    
    private static final String SQL_GET_ROOMS_BY_CLASS = SQL_FIND_ROOMS_ANYCLASS + " AND rclass=?";

    private static final String SQL_ALL_FREE_ROOMS = "select * from hotel_room";

    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(HotelRoom hm){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_ROOM);
	    prepared_stmt.setInt(1, hm.getNumber());	    
	    prepared_stmt.setInt(2, hm.getRoomClass());
	    prepared_stmt.setInt(3, hm.getCapacity());
	    prepared_stmt.setInt(4, hm.getFloor());
	    prepared_stmt.setInt(5, hm.getIdPriceList());	    
	    
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
		return getObj(res);
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
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private HotelRoom getObj(ResultSet result){
	HotelRoom room = new HotelRoom();
	try {
	    room.setId(result.getInt(1));
	    room.setNumber(result.getInt(2));
	    room.setRoomClass(result.getInt(3));
	    room.setCapacity(result.getInt(4));
	    room.setFloor(result.getInt(5));
	    room.setIdPriceList(result.getInt(6));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return room;
    }

    @Override
    public ArrayList<HotelRoom> getBookedRooms(){
	ArrayList<HotelRoom> list = new ArrayList<HotelRoom>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_BOOKED_ROOMS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
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
		list.add(getObj(res));
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
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return list;
    }
}
