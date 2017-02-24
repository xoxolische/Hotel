package hotel.ui.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotel.ui.object_protytypes.Client;

public class ClientTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 288144083645719922L;
	ArrayList<Client> clients;
	
	public ClientTableModel(ArrayList<Client> arrayList) {
		clients = arrayList;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Client item = clients.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return item.getLivNo(); 
			case 1: return item.getName(); 
			case 2: return item.getDate();
			
			default: return 0;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Номер"; 
			case 1: return "Прізвище/назва"; 
			case 2: return "Дата виїзду";
			
			default: return "0";
		}
		
	}

}
