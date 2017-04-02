package dao;

import java.sql.*;

//Connecting and disconnecting to DB
public class DbAccess {
	
	private Connection conn = null;
	
	DbAccess(){ 
		try  {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception ex) {
           	System.out.println("DbAccess> " + ex.getMessage());
        } 	
	}
	
	public Connection connectionDb(){
	       try{ 
		      conn = DriverManager.getConnection("jdbc:mysql://194.44.143.138/projman7?characterEncoding=cp1251", "projman7", "!projman_7");
		      //s = conn.createStatement();
		      
		      System.out.println("Connection suceed!");
		      
		      return conn;
	        } catch (SQLException e) {
				System.out.println("connectionDB> " + e.getMessage());
				return conn;
		    } 
	}
	
	public void disConnect(){
		 try{
			 conn.close();	
			 conn = null;
	     } catch (SQLException e) {
	    	 System.out.println("disConnect> " + e.getMessage());
	     }  
	}

}
