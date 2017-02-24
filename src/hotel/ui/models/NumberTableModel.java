package hotel.ui.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotel.model.HotelRoom;



public class NumberTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3464050534790528234L;
	
	
	//BookedNumber = NumberVO
	ArrayList<HotelRoom> nums;
	
	public NumberTableModel(ArrayList<HotelRoom> arrayList) {
		nums = arrayList;
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
			case 1: return number.getRoomClass(); 
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
