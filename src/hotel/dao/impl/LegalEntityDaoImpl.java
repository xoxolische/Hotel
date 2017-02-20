package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.LegalEntityDao;
import hotel.model.LegalEntity;

public class LegalEntityDaoImpl implements LegalEntityDao{

    private static final String SQL_ADD_LEGALENTITY = null;
    private static final String SQL_DELETE_LEGALENTITY = null;
    private static final String SQL_GET_BY_ID_LEGALENTITY = null;
    private static final String SQL_ALL_LEGALENTITY = null;
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt; 
    
    @Override
    public void add(LegalEntity le){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_LEGALENTITY);
	    prepared_stmt.setString(1, le.getName());	    
	    prepared_stmt.setString(2, le.getKindOfBusiness());
	    prepared_stmt.setString(3, le.getContactPersonName());
	    prepared_stmt.setString(4, le.getPhoneNumber());
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_LEGALENTITY);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public LegalEntity getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_LEGALENTITY);
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
    public List<LegalEntity> getAll(){
	List<LegalEntity> list = new ArrayList<LegalEntity>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_LEGALENTITY);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getObj(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    private LegalEntity getObj(ResultSet result){
	LegalEntity le = new LegalEntity();
	try {
	    le.setId(result.getInt(1));
	    le.setName(result.getString(2));
	    le.setKindOfBusiness(result.getString(3));
	    le.setContactPersonName(result.getString(4));
	    le.setPhoneNumber(result.getString(5));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return le;
    }

}
