package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.GuestDetail;
import vo.Individual;

public class GuestDAO {
	
	private Connection conn;
	private Statement statem;
	private PreparedStatement prepSt;
	private ResultSet resSet;
	private String sql;
	
	//Повернути прізвища всіх клієнтів (проживаючих)
	public ArrayList<Individual> getAllGuests() throws SQLException {
		
		ArrayList<Individual> guests = new ArrayList<Individual>();
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			
			statem = conn.createStatement();
			
			/*sql = "SELECT name"
				+ "FROM individual, guest"
				+ "WHERE individual.id = guest.id_individual";*/
			
			sql = "SELECT name FROM individual, guest WHERE individual.id = guest.id_individual";
			
			statem.execute(sql);
			
			resSet = statem.getResultSet();
			
			while(resSet.next()) {
				String guestName = resSet.getString("name");
				
				Individual guest = new Individual();
				guest.setName(guestName);
				
				guests.add(guest);
			}
		}
		
		acc.disConnect();
		
		return guests;
	}
	
	
	//Повернути деталі про клієнта
	//+ дати заїзду та виїзду
	public ArrayList<GuestDetail> getGuestDetails() throws SQLException {
		
		ArrayList<GuestDetail> details = new ArrayList<GuestDetail>();
		
		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();
		
		if(conn != null) {
			
			/*sql = "SELECT arrival_date, departure_date, rnumber, rclass, rfloor, capacity, individual.name"
				+ "FROM guest, hotel_room, individual"
				+ "WHERE hotel_room.id = guest.id_hotel_room
				   AND individual.id = guest.id_individual";*/
			
			sql = "SELECT arrival_date, departure_date, rnumber, rclass, rfloor, capacity, individual.name FROM guest, hotel_room WHERE hotel_room.id = guest.id_hotel_room AND individual.id = guest.id_individual";
			
			prepSt = conn.prepareStatement(sql);
			//prepSt.setString(1, clientName);
			
			resSet = prepSt.executeQuery();
			
			//Getting result of query
			while((resSet != null) && (resSet.next())) {
				GuestDetail detail = new GuestDetail();
				
				detail.setArrivDate(resSet.getDate("arrival_date"));
				detail.setDepartDate(resSet.getDate("departure_date"));
				detail.setNoCapacity(resSet.getInt("capacity"));
				detail.setNoClass(resSet.getInt("rclass"));
				detail.setNoFloor(resSet.getInt("rfloor"));
				detail.setNoNumber(resSet.getInt("rnumber"));
				detail.setClientName(resSet.getString("individual.name"));
				
				details.add(detail);
			}
		}
		
		
		acc.disConnect();
		
		return details;
	}	

}
