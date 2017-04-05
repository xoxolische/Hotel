package hotel.services.impl;

import java.util.List;

import hotel.dao.PriceListDao;
import hotel.dao.impl.PriceListDaoImpl;
import hotel.model.PriceList;
import hotel.services.PriceListService;

/*** 
 * Service implementation
 * @author Lida Pinchuk 
 */

public class PriceListServiceImpl implements PriceListService{

	private static PriceListDao priceListDao = new PriceListDaoImpl();
	
	@Override
	public void add(PriceList priceList) {
		priceListDao.add(priceList);
	}

	@Override
	public void delete(int id) {
		priceListDao.delete(id);
	}

	@Override
	public PriceList getById(int id) {
		return priceListDao.getById(id);
	}

	@Override
	public List<PriceList> getAll() {
		return priceListDao.getAll();
	}

}
