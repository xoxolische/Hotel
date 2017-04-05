package hotel.ui.ui_table_models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import hotel.dao.HotelRoomDao;
import hotel.model.HotelRoom;
import hotel.services.HotelRoomService;
import hotel.services.impl.HotelRoomServiceImpl;


public class FreeNumberTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<HotelRoom> nums;
	
	private HotelRoomService hotelRoomService = new HotelRoomServiceImpl();
	
	public FreeNumberTableModel() throws SQLException {
		
		//HotelRoomDAO roomDao = new HotelRoomDAO();
	    
		nums = hotelRoomService.getFreeNumbersDetails(new java.sql.Date(0));
		
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return nums.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		HotelRoom number = nums.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return number.getNumber(); 
			case 1: return number.getrClass(); 
			case 2: return number.getCapacity();
			case 3: return number.getFloor();
				
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
			
			default: return "0";
		}
		
	}

}
