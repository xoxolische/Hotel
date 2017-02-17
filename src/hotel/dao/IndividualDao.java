package hotel.dao;

import java.util.List;

import hotel.model.Individual;

public interface IndividualDao{
    
    void add(Individual individual);
    
    void delete(int id);
    
    Individual getById(int id);
    
    List<Individual> getAll();
    
}
