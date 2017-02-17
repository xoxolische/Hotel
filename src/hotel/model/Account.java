package hotel.model;

import java.sql.Date;

public class Account{

    private int id;
    private double cost;
    private Date paymentDate;
    private int idGuest;
    private int idIndividual;
    private int idLegalEntity;
    
    public Account(){
    }
    
    public Account(int id, double cost, int idGuest, Date paymentDate, int idIndividual, int idLegalEntity){
	this.id = id;
	this.cost = cost;
	this.idGuest = idGuest;
	this.paymentDate = paymentDate;
	this.idIndividual = idIndividual;
	this.idLegalEntity = idLegalEntity;
    }
    public void setId(int id){
	this.id = id;
    }
    public void setCost(double cost){
	this.cost = cost;
    }
    public void setIdGuest(int idGuest){
	this.idGuest = idGuest;
    }
    public void setPaymentDate(Date paymentDate){
	this.paymentDate = paymentDate;
    }
    public void setIdIndividual(int idIndividual){
	this.idIndividual = idIndividual;
    }
    public void setIdLegalEntity(int idLegalEntity){
	this.idLegalEntity = idLegalEntity;
    }
    
    public int getId(){
	return id;	
    }
    public double getCost(){
	return cost;	
    }
    public int getIdGuest(){
	return idGuest;	
    }
    public Date getPaymentDate(){
	return paymentDate;	
    }
    public int getIdIndividual(){
	return idIndividual;	
    }
    public int getIdLegalEntity(){
	return idLegalEntity;	
    }  
    
    

}
