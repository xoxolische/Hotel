package hotelPomin.vo;

import java.util.Date;

public class Reservation {

	private long id;
	private Date bookingDate;
	private Date arrivalDate;
	private int days;
	private int persons;
	private Date bookingCancelationDate;
	private String cancelationReason;
	private long idHotelRoom;
	private long idLegalEntity;
	private long idIndividual;

	public Reservation() {
	}

	public Reservation(long id, Date bookingDate, Date arrivalDate, int days,
			int persons, Date bookingCancelationDate, String cancelationReason,
			long idHotelRoom, long idLegalEntity, long idIndividual) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public Date getBookingCancelationDate() {
		return bookingCancelationDate;
	}

	public void setBookingCancelationDate(Date bookingCancelationDate) {
		this.bookingCancelationDate = bookingCancelationDate;
	}

	public String getCancelationReason() {
		return cancelationReason;
	}

	public void setCancelationReason(String cancelationReason) {
		this.cancelationReason = cancelationReason;
	}

	public long getIdHotelRoom() {
		return idHotelRoom;
	}

	public void setIdHotelRoom(long idHotelRoom) {
		this.idHotelRoom = idHotelRoom;
	}

	public long getIdLegalEntity() {
		return idLegalEntity;
	}

	public void setIdLegalEntity(long idLegalEntity) {
		this.idLegalEntity = idLegalEntity;
	}

	public long getIdIndividual() {
		return idIndividual;
	}

	public void setIdIndividual(long idIndividual) {
		this.idIndividual = idIndividual;
	}

}
