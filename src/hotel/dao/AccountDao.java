package hotel.dao;

import java.util.List;

import hotel.model.Account;

public interface AccountDao{
    
    void add(Account account);
    
    void delete(int id);
    
    Account getById(int id);
    
    List<Account> getAll();
}
