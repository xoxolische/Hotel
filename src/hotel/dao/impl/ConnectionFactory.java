package hotel.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{

    private String url;
    private String user;
    private String password;     
    private Connection con; 
    
    public static final ConnectionFactory cf = new ConnectionFactory();
 
    public ConnectionFactory(){
	try {
	    initialize();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    private void initialize() throws IOException, SQLException{
	FileReader fr = new FileReader("db");
	BufferedReader br = new BufferedReader(fr);
	this.setUrl(br.readLine());
	this.setUser(br.readLine());
	this.setPassword(br.readLine());
	fr.close();
	br.close();
	this.con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }
    
    public Connection getConnection(){
	return con;
    }
    
    public String getUrl(){
	return url;
    }

    public void setUrl(String url){
	this.url = url;
    }

    public String getUser(){
	return user;
    }

    public void setUser(String user){
	this.user = user;
    }

    public String getPassword(){
	return password;
    }

    public void setPassword(String password){
	this.password = password;
    }

}
