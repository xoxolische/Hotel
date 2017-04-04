package hotel.dao;

import java.util.List;

import hotel.model.LegalEntity;

public interface LegalEntityDao{
    /*** 
     * DAO interface
     * @author Pavlov Nikita 
     */
    void add(LegalEntity legalEntity);
    
    void delete(int id);
    
    LegalEntity getById(int id);
    
    List<LegalEntity> getAll();
    
}
