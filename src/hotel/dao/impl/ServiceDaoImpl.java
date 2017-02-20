package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.ServiceDao;
import hotel.model.Service;

public class ServiceDaoImpl implements ServiceDao{

    private static final String SQL_ADD_SERVICE = null;
    private static final String SQL_DELETE_SERVICE = null;
    private static final String SQL_GET_BY_ID_SERVICE = null;
    private static final String SQL_ALL_SERVICES = null;
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Service service){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_SERVICE);
	    prepared_stmt.setDate(1, service.getDate());	    
	    prepared_stmt.setInt(2, service.getQuantity());
	    prepared_stmt.setInt(3, service.getIdGuest());
	    prepared_stmt.setInt(4, service.getIdPriceList());	    
	    
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
		return getObj(res);
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
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private Service getObj(ResultSet result){
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
