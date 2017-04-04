package hotel.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hotel.dao.AccountDao;
import hotel.dao.GuestDao;
import hotel.dao.HotelRoomDao;
import hotel.dao.PriceListDao;
import hotel.dao.ServiceDao;
import hotel.dao.impl.AccountDaoImpl;
import hotel.dao.impl.GuestDaoImpl;
import hotel.dao.impl.HotelRoomDaoImpl;
import hotel.dao.impl.PriceListDaoImpl;
import hotel.dao.impl.ServiceDaoImpl;
import hotel.model.Account;
import hotel.model.Guest;
import hotel.model.HotelRoom;
import hotel.model.PriceList;
import hotel.model.Service;
import hotel.services.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public ArrayList<Account> paidAccounts() {
		AccountDao accDao = new AccountDaoImpl();
		ArrayList<Account> allAccounts = accDao.getAll();
		return (ArrayList<Account>)allAccounts.stream()
			    .filter(p -> p.getIdIndividual()!=0||p.getIdLegalEntity()!=0).collect(Collectors.toList());
	}

	@Override
	public ArrayList<Account> unpaidAccounts() {
		AccountDao accDao = new AccountDaoImpl();
		ArrayList<Account> allAccounts = accDao.getAll();
		return (ArrayList<Account>)allAccounts.stream()
			    .filter(p -> p.getIdIndividual()==0&&p.getIdLegalEntity()==0).collect(Collectors.toList());
	}
	@Override
	public void createAccount(int guestId){
		ServiceDao servDao = new ServiceDaoImpl();
		HotelRoomDao hrDao = new HotelRoomDaoImpl();
		PriceListDao plDao = new PriceListDaoImpl();
		AccountDao accDao = new AccountDaoImpl();
		GuestDao gDao= new GuestDaoImpl();
		Guest g= gDao.getById(guestId);
		HotelRoom hr = hrDao.getById((int)g.getIdHotelRoom());
		ArrayList<Service> servicesforguest= servDao.getServicesByGuestId(guestId);
		List<PriceList> pl = plDao.getAll();
		double currprice=0;
		double sum=0;
		for(Service i : servicesforguest){
			currprice=pl.stream()
				    .filter(p -> p.getId()==i.getIdPriceList()).collect(Collectors.toList()).get(0).getPrice();
			sum+=currprice*i.getQuantity();
		}
		int days=daysBetween(g.getArrivalDate(), g.getDepartureDate());
		//if client books the whole room
		if(g.isAdditionalSpace())
			days=days*hr.getCapacity();
		double roomprice=pl.stream()
			    .filter(p -> p.getId()==hr.getIdPriceList()).collect(Collectors.toList()).get(0).getPrice();
		sum+=days*roomprice;
		Account newAcc = new Account();
		newAcc.setCost(sum);
		newAcc.setIdGuest(g.getId());
		accDao.add(newAcc);
	}
	public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
}
}
