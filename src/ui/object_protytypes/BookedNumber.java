package object_protytypes;


/*
 * Клас, що показує VO номера готелю
 */

public class BookedNumber {
	
	private int numNo;
	private String klass;
	private int places;
	private int floor;
	
	
	public BookedNumber(int numNo, String klass, int places, int floor) {
		this.numNo = numNo;
		this.klass = klass;
		this.places = places;
		this.floor = floor;
	}


	public int getNumNo() {
		return numNo;
	}


	public String getKlass() {
		return klass;
	}


	public int getPlaces() {
		return places;
	}


	public int getFloor() {
		return floor;
	}
	

}
