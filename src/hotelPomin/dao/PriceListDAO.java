package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.PriceListItem;


public class PriceListDAO {
	
	private Connection conn;
	private Statement s; 
	private ResultSet rs;
	private String sql;
	
	public ArrayList<PriceListItem> getAllItems() throws SQLException {
		
		ArrayList<PriceListItem> items = new ArrayList<PriceListItem>();
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			s = conn.createStatement();
			
			sql = "SELECT * FROM price_list";
			s.execute(sql);
			
			rs = s.getResultSet();
			
		    while((rs!=null) && (rs.next())) {
		    	int id = rs.getInt("id");
		    	String name = rs.getString("name");
		    	double price = rs.getDouble("price");
		    	
		    	PriceListItem item = new PriceListItem();
		    	item.setId(id);
		    	item.setName(name);
		    	item.setPrice(price);
		    	
		    	items.add(item);
		    }
		    
		}
		else {
			System.out.println("Connection is null");
		}
		
		acc.disConnect();
		
		return items;
		
	}

}
