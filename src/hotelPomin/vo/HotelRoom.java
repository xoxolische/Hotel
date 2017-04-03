package hotelPomin.vo;

public class HotelRoom {

	private long id;
	private int number;
	private int rClass;
	private int capacity;
	private int floor;
	private long idPriceList;

	public HotelRoom() {

	}

	public HotelRoom(long id, int number, int rClass, int capacity, int floor,
			long idPriceList) {
		this.id = id;
		this.number = number;
		this.rClass = rClass;
		this.capacity = capacity;
		this.floor = floor;
		this.idPriceList = idPriceList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getrClass() {
		return rClass;
	}

	public void setrClass(int rClass) {
		this.rClass = rClass;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(long idPriceList) {
		this.idPriceList = idPriceList;
	}

}
