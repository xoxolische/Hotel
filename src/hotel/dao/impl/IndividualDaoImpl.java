package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.IndividualDao;
import hotel.model.Individual;

public class IndividualDaoImpl implements IndividualDao{

    private static final String SQL_ADD_INDIVIDUAL = null;
    private static final String SQL_DELETE_INDIVIDUAL = null;
    private static final String SQL_GET_BY_ID_INDIVIDUAL = null;
    private static final String SQL_ALL_INDIVIDUALS = null;
    private Connection con = new ConnectionFactory().getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(Individual individual){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_INDIVIDUAL);
	    prepared_stmt.setString(1, individual.getName());	    
	    prepared_stmt.setString(2, individual.getSex());
	    prepared_stmt.setString(3, individual.getPhoneNumber());  
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_INDIVIDUAL);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Individual getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_INDIVIDUAL);
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
    public List<Individual> getAll(){
	List<Individual> list = new ArrayList<Individual>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_INDIVIDUALS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private Individual getObj(ResultSet result){
	Individual individual = new Individual();
	try {
	    individual.setId(result.getInt(1));
	    individual.setName(result.getString(2));
	    individual.setSex(result.getString(3));
	    individual.setPhoneNumber(result.getString(4));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return individual;
    }

}
