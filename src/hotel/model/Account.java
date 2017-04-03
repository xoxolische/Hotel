package hotel.model;

import java.sql.Date;

public class Account {

	private long id;
	private double cost;
	private Date paymentDate;
	private long idGuest;
	private long idIndividual;
	private long idLegalEntity;

	public Account() {
	}

	public Account(long id, double cost, long idGuest, Date paymentDate, long idIndividual, long idLegalEntity) {
		this.id = id;
		this.cost = cost;
		this.idGuest = idGuest;
		this.paymentDate = paymentDate;
		this.idIndividual = idIndividual;
		this.idLegalEntity = idLegalEntity;
	}

	public long getId(){
	    return id;
	}

	public void setId(long id){
	    this.id = id;
	}

	public double getCost(){
	    return cost;
	}

	public void setCost(double cost){
	    this.cost = cost;
	}

	public Date getPaymentDate(){
	    return paymentDate;
	}

	public void setPaymentDate(Date paymentDate){
	    this.paymentDate = paymentDate;
	}

	public long getIdGuest(){
	    return idGuest;
	}

	public void setIdGuest(long idGuest){
	    this.idGuest = idGuest;
	}

	public long getIdIndividual(){
	    return idIndividual;
	}

	public void setIdIndividual(long idIndividual){
	    this.idIndividual = idIndividual;
	}

	public long getIdLegalEntity(){
	    return idLegalEntity;
	}

	public void setIdLegalEntity(long idLegalEntity){
	    this.idLegalEntity = idLegalEntity;
	}

	

}
