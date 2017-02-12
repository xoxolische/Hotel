package hotel.dao.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test{

    private String url;
    private String user;
    private String password;
    
    //private static final String url = "jdbc:mysql://db4free.net:3307/hotel_project";
    //private static final String user = "hotel_admin";
    //private static final String password = "139746852";
 
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    
 
    public Test() throws IOException{
	FileReader fr = new FileReader("db");
	BufferedReader br = new BufferedReader(fr);
	this.url = br.readLine();
	this.user = br.readLine();
	this.password = br.readLine();
	br.close();
    }
    
    public String[] DB(){
	return null;
    }
    public static void main(String args[]) throws ClassNotFoundException, IOException {
	
        String query = "select message from test where id=1";
        Test t = new Test();
 
        try {
            con = DriverManager.getConnection(t.url, t.user, t.password);
 
            stmt = con.createStatement();
 
            rs = stmt.executeQuery(query);
 
            while (rs.next()) {
                String m = rs.getString("message");
                System.out.println("Message : " + m);
            }
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { }
            try { stmt.close(); } catch(SQLException se) { }
            try { rs.close(); } catch(SQLException se) { }
        }
    }

}
