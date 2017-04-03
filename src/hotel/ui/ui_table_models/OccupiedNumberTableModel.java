package hotel.ui.ui_table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotelPomin.dao.HotelRoomDAO;
import hotelPomin.vo.OccupiedNumberInfo;


public class OccupiedNumberTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<OccupiedNumberInfo> nums;
	
	public OccupiedNumberTableModel() throws SQLException {
		
		HotelRoomDAO roomDao = new HotelRoomDAO();
		nums = roomDao.getOccupiedNumbersDetails();
		
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return nums.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OccupiedNumberInfo number = nums.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return number.getNoNumber(); 
			case 1: return number.getNoClass(); 
			case 2: return number.getNoCapacity();
			case 3: return number.getNoFloor();
			
			case 4: return number.getGuestArrivalDate();
			case 5: return number.getGuestDepartureDate();
			case 6: return number.getGuestName();
			
			default: return 0;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Номер"; 
			case 1: return "Клас"; 
			case 2: return "К-ть місць";
			case 3: return "Поверх";
			
			case 4: return "Дата поселення";
			case 5: return "Дата виїзду";
			case 6: return "Прізвище";
			
			default: return "0";
		}
		
	}

}
