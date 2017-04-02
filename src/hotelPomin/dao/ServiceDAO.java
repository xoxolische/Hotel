package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ClientServiceInfo;
import vo.PriceListItem;

public class ServiceDAO {

	private Connection conn;
	//private Statement statem;
	private PreparedStatement prepSt;
	private ResultSet resSet;
	private String sql;

	//Query 1
	//Отримати всі послуги, які замовив конкретний клієнт
	public ArrayList<ClientServiceInfo> getServicesByClient(String clientName) throws SQLException {
		
		ArrayList<ClientServiceInfo> services = new ArrayList<ClientServiceInfo>();
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			try {
				/*sql = "SELECT individual.name, quantity "
						+ "FROM price_list, service, guest, individual"
						+ "WHERE individual.name = ? AND"
						+ "individual.id = guest.id_individual AND"
						+ "service.id_guest = guest.id AND"
						+ "price_list.id = service.id_price_list";*/
				
				sql = "SELECT individual.name, quantity FROM price_list, service, guest, individual WHERE individual.name = ? AND individual.id = guest.id_individual AND service.id_guest = guest.id AND price_list.id = service.id_price_list";
				
				prepSt = conn.prepareStatement(sql);
				prepSt.setString(1, clientName);
				
				resSet = prepSt.executeQuery();
				
				//Getting result of query
				while((resSet != null) && (resSet.next())) {
					String servName = resSet.getString("name");
					int servQuantity = resSet.getInt("quantity");
					
					//Forming VO
					ClientServiceInfo item = new ClientServiceInfo();
					item.setServName(servName);
					item.setServQuantity(servQuantity);
					
					services.add(item);
				}
				
				
			} catch (SQLException e) {
				System.out.println("SQL exception: "+e.getMessage());
				e.printStackTrace();
			}
						
		}
		
		acc.disConnect();
		
		return services;
	}
	
	
	//Query 5
	//Отримати всі послуги з прейскуранта
	public ArrayList<PriceListItem> getServicesFromPriceList() throws SQLException {
		
		ArrayList<PriceListItem> services = new ArrayList<PriceListItem>();
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			sql = "SELECT * FROM price_list WHERE price < ?";
			
			prepSt = conn.prepareStatement(sql);
			prepSt.setDouble(1, 100.0);
			
			resSet = prepSt.executeQuery();
			
			
			//Getting result of query
			while((resSet != null) && (resSet.next())) {
				
				int id = resSet.getInt("id");
		    	String name = resSet.getString("name");
		    	double price = resSet.getDouble("price");
		    	
				//Forming VO
		    	PriceListItem item = new PriceListItem();
		    	item.setId(id);
		    	item.setName(name);
		    	item.setPrice(price);
				
				services.add(item);
			}
		}
		
		acc.disConnect();
		
		return services;
		
	}
	
	//Замовлення послуги клієнтом
	public void orderServiceByClient(String clName, int quantity, String servName) throws SQLException {
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			sql = "INSERT INTO service VALUES (?, ?, ?, ?)";
			
			prepSt = conn.prepareStatement(sql);
			
			long millis = System.currentTimeMillis();  
		    java.sql.Date date = new java.sql.Date(millis);
		    
		    int guestId = getGuestIdByName(clName);
		    int priceListId = getPriceListIdByName(servName);
		    
		    prepSt.setDate(1, date);
		    prepSt.setInt(2, quantity);
		    
		    if(guestId != -1)
		    	prepSt.setInt(3, guestId);
		    else
		    	System.out.println("Guest id = -1");
		    
		    if(priceListId != -1)
		    	prepSt.setInt(4, priceListId);
		    else
		    	System.out.println("Price list id = -1");
		    
		    prepSt.executeUpdate();
		}
		
		acc.disConnect();
		
	}
	
	private int getGuestIdByName(String clName) throws SQLException {
		
		int id = -1;
		
		if(conn != null) {
			/*sql = "SELECT guest.id"
				+ "FROM guest, service, individual"
				+ "WHERE service.id_guest = guest.id AND"
				+ "guest.id_individual = individual.id AND"
				+ "individual.name = ?";*/
			
			sql = "SELECT guest.id FROM guest, service, individual WHERE service.id_guest = guest.id AND guest.id_individual = individual.id AND individual.name = ?";
			
			prepSt = conn.prepareStatement(sql);
			prepSt.setString(1, clName);
			
			
			resSet = prepSt.executeQuery();
			
			//Getting result of query
			while((resSet != null) && (resSet.next())) {
				id = resSet.getInt("guest.id");
			}
		}
		
		return id;
	}
	
	private int getPriceListIdByName(String servName) throws SQLException {
		int id = -1;
		
		if(conn != null) {
			/*sql = "SELECT price_list.id"
				+ "FROM price_list"
				+ "WHERE price_list.name = ?";*/
			
			sql = "SELECT price_list.id FROM price_list WHERE price_list.name = ?";
			
			prepSt = conn.prepareStatement(sql);
			prepSt.setString(1, servName);
			
			
			resSet = prepSt.executeQuery();
			
			//Getting result of query
			while((resSet != null) && (resSet.next())) {
				id = resSet.getInt("price_list.id");
			}
		}
		
		return id;
	}
	
}
