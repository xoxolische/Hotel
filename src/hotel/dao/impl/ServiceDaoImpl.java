package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.ServiceDao;
import hotel.model.PriceListItem;
import hotel.model.Service;

public class ServiceDaoImpl implements ServiceDao{
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    private static final String SQL_ADD_SERVICE = "INSERT INTO service(sdate, quantity, id_guest, id_price_list) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_SERVICE = "UPDATE service SET sdate=?, quantity=?, id_guest=?, id_price_list=? WHERE id=?";
    private static final String SQL_DELETE_SERVICE = "DELETE FROM service WHERE id=?";
    private static final String SQL_GET_BY_ID_SERVICE = "SELECT * FROM service WHERE id=?";
    private static final String SQL_ALL_SERVICES = "SELECT * FROM service";
    
    private static final String SQL_GET_SERVICES_BY_PRICE_LIST = "SELECT * FROM price_list INNER JOIN service ON price_list.id=service.id_price_list WHERE price_list.id=?;";
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Service service){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_SERVICE);
	    prepared_stmt.setDate(1, service.getDate());	    
	    prepared_stmt.setInt(2, service.getQuantity());
	    prepared_stmt.setLong(3, service.getIdGuest());
	    prepared_stmt.setLong(4, service.getIdPriceList());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_SERVICE);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public Service getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_SERVICE);
	    prepared_stmt.setInt(1, id);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getServiceObject(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    @Override
    public List<Service> getAll(){
	List<Service> list = new ArrayList<Service>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_SERVICES);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getServiceObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }    
    
    @Override
    public ArrayList<PriceListItem> getServicesFromPriceList(int pricelist_id){
	ResultSet res = null;
	ArrayList<PriceListItem> list = new ArrayList<PriceListItem>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_SERVICES_BY_PRICE_LIST);
	    prepared_stmt.setInt(1, pricelist_id);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getPriceListItemObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    @Override
    public ArrayList<PriceListItem> getAllPriceListItems(){
	// TODO Auto-generated method stub
	return null;
    }
    /**
     * Section below contains Object row mapper methods
     */
    private PriceListItem getPriceListItemObject(ResultSet result){
	PriceListItem pli = new PriceListItem();
	try {
	    pli.setId(result.getInt("id")); 
	    pli.setName(result.getString("name")); 
	    pli.setPrice(result.getDouble("price")); 
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return pli;
    }
    private Service getServiceObject(ResultSet result){
	Service service = new Service();
	try {
	    service.setId(result.getInt(1));
	    service.setDate(result.getDate(2));
	    service.setQuantity(result.getInt(3));
	    service.setIdGuest(result.getInt(4));
	    service.setIdPriceList(result.getInt(5));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return service;
    }
    
    
}
