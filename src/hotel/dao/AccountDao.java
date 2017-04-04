package hotel.dao;

import java.util.ArrayList;

import hotel.model.Account;

public interface AccountDao{
    /*** 
     * DAO interface
     * @author Pavlov Nikita 
     */
    void add(Account account);
    
    void delete(int id);
    
    Account getById(int id);
    
    ArrayList<Account> getAll();
}
