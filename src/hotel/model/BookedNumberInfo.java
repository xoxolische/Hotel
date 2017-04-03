package hotel.model;

import java.sql.Date;

/***
 * Інформація про заброньовані номери готелю
 * 
 * @author Roman
 *
 */

public class BookedNumberInfo {

	private int noNumber;
	private int noClass;
	private int noCapacity;
	private int noFloor;

	private Date guestArrivalDate;
	private Date bookingDate;

	private int daysNum;

	private String name;

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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getDaysNum() {
		return daysNum;
	}

	public void setDaysNum(int daysNum) {
		this.daysNum = daysNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
