package vo;

import java.util.Date;

public class Guest {

	private long id;
	private Date arrivalDate;
	private Date departureDate;
	private boolean additionalSpace;
	private long idIndividual;
	private long idHotelRoom;

	public Guest() {

	}

	public Guest(long id, Date arrivalDate, Date departureDate,
			boolean additionalSpace, long idIndividual, long idHotelRoom) {
		this.id = id;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.additionalSpace = additionalSpace;
		this.idIndividual = idIndividual;
		this.idHotelRoom = idHotelRoom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public boolean getAdditionalSpace() {
		return additionalSpace;
	}

	public void setAdditionalSpace(boolean additionalSpace) {
		this.additionalSpace = additionalSpace;
	}

	public long getIdIndividual() {
		return idIndividual;
	}

	public void setIdIndividual(long idIndividual) {
		this.idIndividual = idIndividual;
	}

	public long getIdHotelRoom() {
		return idHotelRoom;
	}

	public void setIdHotelRoom(long idHotelRoom) {
		this.idHotelRoom = idHotelRoom;
	}
}
