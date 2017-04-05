package hotel.services;

import java.util.List;

import hotel.model.Individual;

/*** 
 * Service interface
 * @author Lida Pinchuk
 */

public interface IndividualService{

    void add(Individual individual);
    void delete(int id);
    
    Individual getById(int id);
    List<Individual> getAll();

}
