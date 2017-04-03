package hotelPomin.vo;

import java.util.Date;

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

	public void setId(long id) {
		this.id = id;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setIdGuest(long idGuest) {
		this.idGuest = idGuest;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setIdIndividual(long idIndividual) {
		this.idIndividual = idIndividual;
	}

	public void setIdLegalEntity(long idLegalEntity) {
		this.idLegalEntity = idLegalEntity;
	}

	public long getId() {
		return id;
	}

	public double getCost() {
		return cost;
	}

	public double getIdGuest() {
		return idGuest;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public long getIdIndividual() {
		return idIndividual;
	}

	public long getIdLegalEntity() {
		return idLegalEntity;
	}

}
