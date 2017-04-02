package vo;

import java.sql.Date;

public class GuestDetail {

	/*
	 * private String arrivDate; private String departDate;
	 */

	private String clientName;
	private Date arrivDate;
	private Date departDate;
	private int noNumber;
	private int noClass;
	private int noFloor;
	private int noCapacity;
	
	private String arrivDateStr;
	private String departDateStr;

	/*
	 * public String getArrivDate() { return arrivDate; }
	 * 
	 * public void setArrivDate(String arrivDate) { this.arrivDate = arrivDate;
	 * }
	 * 
	 * public String getDepartDate() { return departDate; }
	 * 
	 * public void setDepartDate(String departDate) { this.departDate =
	 * departDate; }
	 */

	public String getArrivDateStr() {
		return arrivDateStr;
	}

	public void setArrivDateStr(String arrivDateStr) {
		this.arrivDateStr = arrivDateStr;
	}

	public String getDepartDateStr() {
		return departDateStr;
	}

	public void setDepartDateStr(String departDateStr) {
		this.departDateStr = departDateStr;
	}

	public Date getArrivDate() {
		return arrivDate;
	}

	public void setArrivDate(Date arrivDate) {
		this.arrivDate = arrivDate;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

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

	public int getNoFloor() {
		return noFloor;
	}

	public void setNoFloor(int noFloor) {
		this.noFloor = noFloor;
	}

	public int getNoCapacity() {
		return noCapacity;
	}

	public void setNoCapacity(int noCapacity) {
		this.noCapacity = noCapacity;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}
