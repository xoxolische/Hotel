package hotel.model;

import java.sql.Date;

public class Guest{
    
    private int id;
    private Date arrivalDate;
    private Date departureDate;
    private boolean additionalSpace;
    private int idIndividual;
    private int idHotelRoom;    

    public Guest(){
	
    }

    public Guest(int id, Date arrivalDate, Date departureDate, boolean additionalSpace, int idIndividual, int idHotelRoom){
	this.id = id;
	this.arrivalDate = arrivalDate;
	this.departureDate = departureDate;
	this.additionalSpace = additionalSpace;
	this.idIndividual = idIndividual;
	this.idHotelRoom = idHotelRoom;
    }

    public int getId(){
	return id;
    }
    
    public void setId(int id){
	this.id = id;
    }
    
    public Date getArrivalDate(){
	return arrivalDate;
    }
    
    public void setArrivalDate(Date arrivalDate){
	this.arrivalDate = arrivalDate;
    }
    
    public Date getDepartureDate(){
	return departureDate;
    }
    
    public void setDepartureDate(Date departureDate){
	this.departureDate = departureDate;
    }
    
    public boolean getAdditionalSpace(){
	return additionalSpace;
    }
    
    public void setAdditionalSpace(boolean additionalSpace){
	this.additionalSpace = additionalSpace;
    }
    
    public int getIdIndividual(){
	return idIndividual;
    }
    
    public void setIdIndividual(int idIndividual){
	this.idIndividual = idIndividual;
    }
    
    public int getIdHotelRoom(){
	return idHotelRoom;
    }
    
    public void setIdHotelRoom(int idHotelRoom){
	this.idHotelRoom = idHotelRoom;
    }
}
