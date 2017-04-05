package hotel.ui.ui_table_models;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import hotel.model.GuestDetail;
import hotel.services.GuestService;
import hotel.services.impl.GuestServiceImpl;



public class GuestTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GuestDetail> guests;
	private GuestService guestService = new GuestServiceImpl();
	
	public GuestTableModel() throws SQLException {
		//GuestDAO guestDao = new GuestDAO();
		//guests = guestDao.getGuestDetails();
	    guests = guestService.getAllGuestDetail();
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return guests.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		GuestDetail detail = guests.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return detail.getClientName();
			case 1: return detail.getArrivDate(); 
			case 2: return detail.getDepartDate();
			
			case 3: return detail.getNoNumber();
			case 4: return detail.getNoFloor();
			case 5: return detail.getNoClass();
			case 6: return detail.getNoCapacity();
			
			default: return 0;
		}
		
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Прізвище"; 
			case 1: return "Дата заїзду"; 
			case 2: return "Дата виїзду";
			
			case 3: return "Номер";
			case 4: return "Поверх";
			case 5: return "Клас";
			case 6: return "К-ть місць";
			
			default: return "0";
		}
	}

}
