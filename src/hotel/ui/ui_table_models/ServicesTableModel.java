package hotel.ui.ui_table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotel.dao.ServiceDao;
import hotel.model.PriceListItem;




public class ServicesTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PriceListItem> services;
	private ServiceDao servDao;
	
	public ServicesTableModel() throws SQLException {
		
		//ServiceDAO servDao = new ServiceDAO();
		services = servDao.getServicesFromPriceList();
		
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return services.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PriceListItem number = services.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return number.getName(); 
			case 1: return number.getPrice(); 
			
			default: return 0;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Назва"; 
			case 1: return "Ціна"; 
			
			default: return "0";
		}
		
	}

}
