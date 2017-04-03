package hotel.model;

import java.sql.Date;

/**
 * Інформація про заселені номери готелю
 * 
 * @author Roman
 *
 */

public class OccupiedNumberInfo {

	private int noNumber;
	private int noClass;
	private int noCapacity;
	private int noFloor;

	private Date guestArrivalDate;
	private Date guestDepartureDate;

	private String guestName;

	public int getNoNumber() {
		return noNumber;
	}

	public void setNoNumber(int noNumber) {
		this.noNumber = noNumber;
	}

	public int getNoClass() {
		return noClass;
	}

	public void setNoClass(int noClass) {
		this.noClass = noClass;
	}

	public int getNoCapacity() {
		return noCapacity;
	}

	public void setNoCapacity(int noCapacity) {
		this.noCapacity = noCapacity;
	}

	public int getNoFloor() {
		return noFloor;
	}

	public void setNoFloor(int noFloor) {
		this.noFloor = noFloor;
	}

	public Date getGuestArrivalDate() {
		return guestArrivalDate;
	}

	public void setGuestArrivalDate(Date guestArrivalDate) {
		this.guestArrivalDate = guestArrivalDate;
	}

	public Date getGuestDepartureDate() {
		return guestDepartureDate;
	}

	public void setGuestDepartureDate(Date guestDepartureDate) {
		this.guestDepartureDate = guestDepartureDate;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

}
