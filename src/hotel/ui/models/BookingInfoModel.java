package hotel.ui.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotel.ui.object_protytypes.BookingInfoItem;


public class BookingInfoModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2168896806351740928L;
	ArrayList<BookingInfoItem> bookedNumbers;
	
	public BookingInfoModel(ArrayList<BookingInfoItem> bookedItems) {
		bookedNumbers = bookedItems;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return bookedNumbers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		BookingInfoItem item = bookedNumbers.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return item.getBookedNo(); 
			case 1: return item.getFio(); 
			case 2: return item.getBookingDate();
			
			default: return 0;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Номер"; 
			case 1: return "Прізвище/назва"; 
			case 2: return "Дата бронювання";
			
			default: return "0";
		}
		
	}

}
