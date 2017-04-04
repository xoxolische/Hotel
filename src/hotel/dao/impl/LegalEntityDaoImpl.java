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
    
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    
    private static final String SQL_ADD_LEGALENTITY = "INSERT INTO legal_entity(name, kind_of_business, contact_name, phone_number) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_LEGALENTITY = "UPDATE legal_entity SET name=?, kind_of_business=?, contact_name=?, phone_number=? WHERE id=?";
    private static final String SQL_DELETE_LEGALENTITY = "DELETE FROM legal_entity WHERE id=?";
    private static final String SQL_GET_BY_ID_LEGALENTITY = "SELECT * FROM legal_entity WHERE id=?";
    private static final String SQL_ALL_LEGALENTITY = "SELECT * FROM legal_entity";
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
		return getLegalEntityObject(res);
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
		list.add(getLegalEntityObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    /**
     * Section below contains Object row mapper methods
     */
    private LegalEntity getLegalEntityObject(ResultSet result){
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
