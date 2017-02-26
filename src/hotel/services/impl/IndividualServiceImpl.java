package hotel.services.impl;

import hotel.dao.IndividualDao;
import hotel.dao.impl.IndividualDaoImpl;
import hotel.model.Individual;
import hotel.services.IndividualService;

public class IndividualServiceImpl implements IndividualService{

    @Override
    public void add(String name, String sex, String phone){
	IndividualDao individualDao = new IndividualDaoImpl();
	Individual individual = new Individual();
	individual.setName(name);
	individual.setSex(sex);
	individual.setPhoneNumber(phone);
	individualDao.add(individual);
    }

}
