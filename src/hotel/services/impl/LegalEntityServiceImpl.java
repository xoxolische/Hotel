package hotel.services.impl;

import hotel.dao.LegalEntityDao;
import hotel.dao.impl.LegalEntityDaoImpl;
import hotel.model.LegalEntity;
import hotel.services.LegalEntityService;

public class LegalEntityServiceImpl implements LegalEntityService{

    @Override
    public void add(String organisation, String business, String personName, String phone){
	LegalEntityDao legalEntityDao = new LegalEntityDaoImpl();
	LegalEntity legalEntity = new LegalEntity();
	legalEntity.setName(organisation);
	legalEntity.setKindOfBusiness(business);
	legalEntity.setContactPersonName(personName);
	legalEntity.setPhoneNumber(phone);
	legalEntityDao.add(legalEntity);
    }

}
