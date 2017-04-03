package hotelPomin.vo;

import java.util.Date;

public class Service {

	private long id;
	private Date date;
	private int quantity;
	private long idGuest;
	private long idPriceList;

	public Service() {
	}

	public Service(long id, Date date, int quantity, long idGuest,
			long idPriceList) {
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.idGuest = idGuest;
		this.idPriceList = idPriceList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(long idGuest) {
		this.idGuest = idGuest;
	}

	public long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(long idPriceList) {
		this.idPriceList = idPriceList;
	}

}
