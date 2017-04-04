package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.ServiceDao;
import hotel.model.Service;
import hotel.model.ClientServiceInfo;
import hotel.model.PriceListItem;

public class ServiceDaoImpl implements ServiceDao{
    /*** 
     * DAO implementation 
     * @author Pavlov Nikita 
     * 
     * 
     *SQL queries 
     * @author Lida Pinchuk 
     */
    private static final String SQL_ADD_SERVICE = "INSERT INTO service(sdate, quantity, id_guest, id_price_list) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_SERVICE = "UPDATE service SET sdate=?, quantity=?, id_guest=?, id_price_list=? WHERE id=?";
    private static final String SQL_DELETE_SERVICE = "DELETE FROM service WHERE id=?";
    private static final String SQL_GET_BY_PRICE_LIST_ID_SERVICE = "SELECT * FROM service WHERE id_price_list=?";
    private static final String SQL_GET_BY_ID_SERVICE = "SELECT * FROM service WHERE id=?";
    private static final String SQL_GET_BY_GUEST_ID_SERVICE = "SELECT * FROM service WHERE id_guest=?";
    private static final String SQL_ALL_SERVICES = "SELECT * FROM service";    
    private static final String SQL_ALL_PRICE_LIST = "SELECT * FROM price_list";   
    private static final String SQL_GET_SERVICES_BY_PRICE_LIST = "SELECT * FROM price_list INNER JOIN service ON price_list.id=service.id_price_list WHERE price_list.id=?;";
    private static final String SQL_GET_BY_CLIENT_NAME_SERVICES = "SELECT individual.name, quantity FROM price_list, service, guest, individual WHERE individual.name = ? AND individual.id = guest.id_individual AND service.id_guest = guest.id AND price_list.id = service.id_price_list";;
    private static final String SQL_SERVICES_FROM_PRICELISTITEM = "SELECT * FROM price_list WHERE price < ?";
    private static final String SQL_GET_GUEST_ID_BY_CL_NAME = "SELECT guest.id FROM guest, service, individual WHERE service.id_guest = guest.id AND guest.id_individual = individual.id AND individual.name = ?";
    private static final String SQL_GET_PRICE_LIST_ID_BY_SERV_NAME ="SELECT price_list.id FROM price_list WHERE price_list.name = ?";
    private Connection con = ConnectionFactory.cf.getConnection();
    private PreparedStatement prepared_stmt;    
    
    @Override
    public void add(Service service){	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ADD_SERVICE);
	    prepared_stmt.setDate(1, service.getDate());	    
	    prepared_stmt.setInt(2, service.getQuantity());
	    prepared_stmt.setLong(3, service.getIdGuest());
	    prepared_stmt.setLong(4, service.getIdPriceList());	    
	    
	    prepared_stmt.executeUpdate();	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void delete(int id){
	try {
	    prepared_stmt = con.prepareStatement(SQL_DELETE_SERVICE);
	    prepared_stmt.setInt(1, id);
	    prepared_stmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public Service getById(int id){
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_BY_ID_SERVICE);
	    prepared_stmt.setInt(1, id);
	    res = prepared_stmt.executeQuery();	    
	    if(res.next()){
		return getServiceObject(res);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    @Override
    public List<Service> getAll(){
	List<Service> list = new ArrayList<Service>();
	ResultSet res = null;
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_ALL_SERVICES);
	    res = prepared_stmt.executeQuery();
	    while(res.next()){		
		list.add(getServiceObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}	
	
	return list;
    }    
    
    @Override
    public ArrayList<PriceListItem> getServicesFromPriceList(int pricelist_id){
	ResultSet res = null;
	ArrayList<PriceListItem> list = new ArrayList<PriceListItem>();
	
	try {
	    prepared_stmt = con.prepareStatement(SQL_GET_SERVICES_BY_PRICE_LIST);
	    prepared_stmt.setInt(1, pricelist_id);
	    res = prepared_stmt.executeQuery();	    
	    while(res.next()){
		list.add(getPriceListItemObject(res));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }
    
    /**
     * Section below contains Object row mapper methods
     */
    private PriceListItem getPriceListItemObject(ResultSet result){
	PriceListItem pli = new PriceListItem();
	try {
	    pli.setId(result.getInt("id")); 
	    pli.setName(result.getString("name")); 
	    pli.setPrice(result.getDouble("price")); 

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return pli;
    }

    private Service getServiceObject(ResultSet result){
	Service service = new Service();
	try {
	    service.setId(result.getInt(1));
	    service.setDate(result.getDate(2));
	    service.setQuantity(result.getInt(3));
	    service.setIdGuest(result.getInt(4));
	    service.setIdPriceList(result.getInt(5));	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return service;
    }
    
    
	@Override		
	public ArrayList<ClientServiceInfo> getServicesByClient(String clientName){
		
			ArrayList<ClientServiceInfo> services = new ArrayList<ClientServiceInfo>();
			ResultSet res = null;
		try{	
			prepared_stmt = con.prepareStatement(SQL_GET_BY_CLIENT_NAME_SERVICES);
			prepared_stmt.setString(1, clientName);
					
			res = prepared_stmt.executeQuery();
			
			//Getting result of query
			while((res != null) && (res.next())) {
				String servName = res.getString("name");
				int servQuantity = res.getInt("quantity");
				
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
		return services;			
	}
	@Override
	public ArrayList<PriceListItem> getServicesFromPriceListItem(){
		
		ArrayList<PriceListItem> services = new ArrayList<PriceListItem>();
		ResultSet resSet = null;	
		try {
		prepared_stmt = con.prepareStatement(SQL_SERVICES_FROM_PRICELISTITEM);
		prepared_stmt.setDouble(1, 100.0);
		
		resSet = prepared_stmt.executeQuery();
		
		
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
		} catch (SQLException e) {
			System.out.println("SQL exception: "+e.getMessage());
			e.printStackTrace();
		}
		return services;
		
	}
	
	//Замовлення послуги клієнтом
	@Override
	public void orderServiceByClient(String clName, int quantity, String servName){
		
		try{	
				prepared_stmt = con.prepareStatement(SQL_ADD_SERVICE);
				
				long millis = System.currentTimeMillis();  
			    java.sql.Date date = new java.sql.Date(millis);
			    
			    int guestId = getGuestIdByName(clName);
			    int PriceListItemId = getPriceListIdByName(servName);
			    
			    prepared_stmt.setDate(1, date);
			    prepared_stmt.setInt(2, quantity);
			    
			    if(guestId != -1)
			    	prepared_stmt.setInt(3, guestId);
			    else
			    	System.out.println("Guest id = -1");
			    
			    if(PriceListItemId != -1)
			    	prepared_stmt.setInt(4, PriceListItemId);
			    else
			    	System.out.println("Price list id = -1");
			    
			    prepared_stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL exception: "+e.getMessage());
			e.printStackTrace();
		}
	}		
	
	private int getGuestIdByName(String clName) throws SQLException {
		
		int id = -1;
		ResultSet resSet = null;	
		prepared_stmt = con.prepareStatement(SQL_GET_GUEST_ID_BY_CL_NAME);
		prepared_stmt.setString(1, clName);
		resSet = prepared_stmt.executeQuery();
		
		//Getting result of query
		while((resSet != null) && (resSet.next())) {
			id = resSet.getInt("guest.id");
		}
			
		return id;
	}
	
	private int getPriceListIdByName(String servName) throws SQLException {
		
		int id = -1;
		ResultSet resSet = null;	
		prepared_stmt = con.prepareStatement(SQL_GET_PRICE_LIST_ID_BY_SERV_NAME);
		prepared_stmt.setString(1, servName);
		resSet = prepared_stmt.executeQuery();
		
		//Getting result of query
		while((resSet != null) && (resSet.next())) {
			id = resSet.getInt("price_list.id");
		}	
		return id;
	}

	@Override
	public ArrayList<PriceListItem> getAllPriceListItems() {
		ArrayList<PriceListItem> list = new ArrayList<PriceListItem>();
		ResultSet res = null;
		try {
		    prepared_stmt = con.prepareStatement(SQL_ALL_PRICE_LIST);
		    res = prepared_stmt.executeQuery();
		    while(res.next()){		
			list.add(getPriceListItemObject(res));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}	
		
		return list;
	}
	@Override
	public ArrayList<Service> getServicesByGuestId(int guest_id){
		ArrayList<Service> list = new ArrayList<Service>();
		ResultSet res = null;
		try {
		    prepared_stmt = con.prepareStatement(SQL_GET_BY_GUEST_ID_SERVICE);
		    res = prepared_stmt.executeQuery();
		    while(res.next()){		
			list.add(getServiceObject(res));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}	
		
		return list;
		
	}
		
}
