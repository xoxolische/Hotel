package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.AccountDao;
import hotel.model.Account;

public class AccountDaoImpl implements AccountDao{
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    
    private static final String SQL_ADD_ACCOUNT = "INSERT INTO account(cost, id_guest) VALUES (?, ?)";
    private static final String SQL_ADD_ACCOUNT_PAYER = "UPDATE account SET payment_date=?, id_individual=?, id_legal_entity=? WHERE id=?";
    private static final String SQL_UPDATE_ACCOUNT = "UPDATE account SET cost=?, payment_date=?, id_guest=?, id_individual=?, id_legal_entity=? WHERE id=?";
    private static final String SQL_DELETE_ACCOUNT = "DELETE FROM account WHERE id=?";
    private static final String SQL_GET_BY_ID_ACCOUNT = "SELECT * FROM account WHERE id=?";
    private static final String SQL_ALL_ACCOUNTS = "SELECT * FROM account";
    
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Account account){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_ACCOUNT);
	    prepared_stmt.setDouble(1, account.getCost());	    
	    if(account.getPaymentDate()!=null){
		prepared_stmt.setDate(2, account.getPaymentDate());		
	    }
	    else{
		prepared_stmt.setNull(2, Types.INTEGER);
	    }
	    prepared_stmt.setLong(3, account.getIdGuest());
	    prepared_stmt.setLong(4, account.getIdIndividual());
	    prepared_stmt.setLong(5, account.getIdLegalEntity());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_ACCOUNT);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public Account getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_ACCOUNT);
	    prepared_stmt.setInt(1, id);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getAccountObject(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    @Override
    public List<Account> getAll(){
	List<Account> list = new ArrayList<Account>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_ACCOUNTS);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getAccountObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }
    
    
    /**
     * Section below contains Object row mapper methods
     */
    private Account getAccountObject(ResultSet result){
	Account account = new Account();
	try {
	    account.setId(result.getInt(1));
	    account.setCost(result.getDouble(2));
	    account.setPaymentDate(result.getDate(3));
	    account.setIdGuest(result.getInt(4));
	    account.setIdIndividual(result.getInt(5));
	    account.setIdLegalEntity(result.getInt(6));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return account;
    }
}
