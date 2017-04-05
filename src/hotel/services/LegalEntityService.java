package hotel.services;

import java.util.List;

import hotel.model.LegalEntity;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface LegalEntityService{

    void add(LegalEntity legalEntity);
    void delete(int id);
    
    LegalEntity getById(int id);
    List<LegalEntity> getAll();

}
