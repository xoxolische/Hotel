package hotelPomin.ui_table_models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotelPomin.vo.GuestDetail;


public class ClientDemoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GuestDetail> guests;
	
	public ClientDemoTableModel() {
		guests = new ArrayList<GuestDetail>();
		
		GuestDetail det = new GuestDetail();
		
		det.setArrivDateStr("2017-02-08");
		det.setClientName("Vasya");
		det.setDepartDateStr("2017-03-09");
		det.setNoCapacity(2);
		det.setNoClass(2);
		det.setNoFloor(5);
		det.setNoNumber(2020);
		
		GuestDetail det2 = new GuestDetail();
		
		det2.setArrivDateStr("2100-09-20");
		det2.setClientName("Petya");
		det2.setDepartDateStr("2200-06-12");
		det2.setNoCapacity(10);
		det2.setNoClass(1);
		det2.setNoFloor(1);
		det2.setNoNumber(2000);
		
		GuestDetail det3 = new GuestDetail();
		
		det3.setArrivDateStr("2001-01-01");
		det3.setClientName("Kolya");
		det3.setDepartDateStr("2002-12-10");
		det3.setNoCapacity(3);
		det3.setNoClass(6);
		det3.setNoFloor(2);
		det3.setNoNumber(1000);
		
		for(int i=1; i<=100; i++) {
			guests.add(det);
			guests.add(det2);
			guests.add(det3);
		}
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
			case 1: return detail.getArrivDateStr(); 
			case 2: return detail.getDepartDateStr();
			
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
