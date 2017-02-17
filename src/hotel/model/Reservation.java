package hotel.model;

import java.sql.Date;

public class Reservation{

    private int id;
    private Date bookingDate;
    private Date arrivalDate;
    private int days;
    private int persons;
    private Date bookingCancelationDate;
    private String cancelationReason;
    private int idHotelRoom;
    private int idLegalEntity;
    private int idIndividual;
    
    public Reservation(){
    }

    public Reservation(int id, Date bookingDate, Date arrivalDate, int days,
	    int persons, Date bookingCancelationDate, String cancelationReason,
	    int idHotelRoom, int idLegalEntity, int idIndividual){
	this.id = id;
	this.bookingDate = bookingDate;
	this.arrivalDate = arrivalDate;
	this.days = days;
	this.persons = persons;
	this.bookingCancelationDate = bookingCancelationDate;
	this.cancelationReason = cancelationReason;
	this.idHotelRoom = idHotelRoom;
	this.idLegalEntity = idLegalEntity;
	this.idIndividual = idIndividual;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Date getBookingDate(){
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate){
        this.bookingDate = bookingDate;
    }

    public Date getArrivalDate(){
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate){
        this.arrivalDate = arrivalDate;
    }

    public int getDays(){
        return days;
    }

    public void setDays(int days){
        this.days = days;
    }

    public int getPersons(){
        return persons;
    }

    public void setPersons(int persons){
        this.persons = persons;
    }

    public Date getBookingCancelationDate(){
        return bookingCancelationDate;
    }

    public void setBookingCancelationDate(Date bookingCancelationDate){
        this.bookingCancelationDate = bookingCancelationDate;
    }

    public String getCancelationReason(){
        return cancelationReason;
    }

    public void setCancelationReason(String cancelationReason){
        this.cancelationReason = cancelationReason;
    }

    public int getIdHotelRoom(){
        return idHotelRoom;
    }

    public void setIdHotelRoom(int idHotelRoom){
        this.idHotelRoom = idHotelRoom;
    }

    public int getIdLegalEntity(){
        return idLegalEntity;
    }

    public void setIdLegalEntity(int idLegalEntity){
        this.idLegalEntity = idLegalEntity;
    }

    public int getIdIndividual(){
        return idIndividual;
    }

    public void setIdIndividual(int idIndividual){
        this.idIndividual = idIndividual;
    }

}
