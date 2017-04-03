package hotelPomin;

import java.sql.SQLException;
import java.util.ArrayList;

import hotelPomin.dao.HotelRoomDAO;
import hotelPomin.vo.HotelRoom;

public class Main {

	public static void main(String[] args) throws SQLException {
		//PriceListDAO dao = new PriceListDAO();
		
		/*ArrayList<PriceListItem> items = dao.getAllItems();
		System.out.println("Size: "+items.size());
		
		for(PriceListItem item : items) {
			System.out.print(item.getId()+"; "+item.getName()+"; "+item.getPrice());
			System.out.println();
		}*/
		
		
		//----------------------------------
		
		HotelRoomDAO roomDao = new HotelRoomDAO();
		
		/*ArrayList<OccupiedNumberInfo> items = roomDao.getOccupiedNumbersDetails();
		
		for(OccupiedNumberInfo item : items) {
			System.out.print(item.getGuestName()+" - "+item.getNoCapacity()+" - "+item.getNoClass()+" - "+item.getNoFloor()+" - "+item.getNoNumber()+" - "+item.getGuestArrivalDate()+" - "+item.getGuestDepartureDate());
			System.out.println();
		}*/
		
		
		/*ArrayList<BookedNumberInfo> items = roomDao.getBookedNumbersDetailsIndividal();
		
		for(BookedNumberInfo item : items) {
			System.out.print(item.getDaysNum()+" - "+item.getName()+" - "+item.getNoCapacity()+" - "+item.getNoClass()+" - "+item.getNoFloor()+" - "+item.getNoNumber()+" - "+item.getBookingDate()+" - "+item.getGuestArrivalDate());
			System.out.println();
		}*/
		
		/*ArrayList<BookedNumberInfo> items = roomDao.getBookedNumbersDetailsLegalEntity();
		
		for(BookedNumberInfo item : items) {
			System.out.print(item.getDaysNum()+" - "+item.getName()+" - "+item.getNoCapacity()+" - "+item.getNoClass()+" - "+item.getNoFloor()+" - "+item.getNoNumber()+" - "+item.getBookingDate()+" - "+item.getGuestArrivalDate());
			System.out.println();
		}*/
		
		ArrayList<HotelRoom> items = roomDao.getFreeNumbersDetails();
		
		for(HotelRoom item : items) {
			System.out.print(item.getCapacity()+" - "+item.getrClass()+" - "+item.getFloor()+" - "+item.getNumber());
			System.out.println();
		}

	}

}
