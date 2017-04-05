package hotel.services.impl;

import java.util.List;

import hotel.dao.IndividualDao;

import hotel.dao.impl.IndividualDaoImpl;
import hotel.model.Individual;
import hotel.services.IndividualService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class IndividualServiceImpl implements IndividualService{

	private static IndividualDao individualDao = new IndividualDaoImpl();

	@Override
	public void add(Individual individual) {
		individualDao.add(individual);
	}

	@Override
	public void delete(int id) {
		individualDao.delete(id);
	}

	@Override
	public Individual getById(int id) {
		return individualDao.getById(id);
	}
	
	@Override
	public List<Individual> getAll() {
		return individualDao.getAll();
	}

}
