package hotel.services.impl;

import java.util.List;

import hotel.dao.LegalEntityDao;
import hotel.dao.impl.LegalEntityDaoImpl;
import hotel.model.LegalEntity;
import hotel.services.LegalEntityService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class LegalEntityServiceImpl implements LegalEntityService{
	
	private static LegalEntityDao legalEntityDao = new LegalEntityDaoImpl();

	@Override
	public void add(LegalEntity legalEntity) {
		legalEntityDao.add(legalEntity);
	}

	@Override
	public void delete(int id) {
		legalEntityDao.delete(id);
	}

	@Override
	public LegalEntity getById(int id) {
		return legalEntityDao.getById(id);
	}

	@Override
	public List<LegalEntity> getAll() {
		return legalEntityDao.getAll();
	}


}
