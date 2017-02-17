package hotel.model;

import java.sql.Date;

public class Service{
    
    private int id;
    private Date date;
    private int quantity;
    private int idGuest;
    private int idPriceList;

    public Service(){
    }

    public Service(int id, Date date, int quantity, int idGuest,
	    int idPriceList){
	this.id = id;
	this.date = date;
	this.quantity = quantity;
	this.idGuest = idGuest;
	this.idPriceList = idPriceList;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getIdGuest(){
        return idGuest;
    }

    public void setIdGuest(int idGuest){
        this.idGuest = idGuest;
    }

    public int getIdPriceList(){
        return idPriceList;
    }

    public void setIdPriceList(int idPriceList){
        this.idPriceList = idPriceList;
    }

}
