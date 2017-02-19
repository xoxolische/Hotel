package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.PriceListDao;
import hotel.model.PriceList;

public class PriceListDaoImpl implements PriceListDao{

    private static final String SQL_ADD_PRICELIST = null;
    private static final String SQL_DELETE_PRICELIST = null;
    private static final String SQL_GET_BY_ID_PRICELIST = null;
    private static final String SQL_ALL_PRICELISTS = null;
    //private Connection con = new ConnectionFactory().getConnection();
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(PriceList priceList){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_PRICELIST);
	    prepared_stmt.setString(1, priceList.getName());	    
	    prepared_stmt.setDouble(2, priceList.getPrice());  
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_PRICELIST);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public PriceList getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_PRICELIST);
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
    public List<PriceList> getAll(){
	List<PriceList> list = new ArrayList<PriceList>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_PRICELISTS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private PriceList getObj(ResultSet result){
	PriceList priceList = new PriceList();
	try {
	    priceList.setId(result.getInt(1));
	    priceList.setName(result.getString(2));
	    priceList.setPrice(result.getDouble(3));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return priceList;
    }


}
