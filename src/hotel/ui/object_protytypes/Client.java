package hotel.ui.object_protytypes;

public class Client {
	
	private String name;
	private int livNo;
	private String date;
	
	
	public Client(int livNo, String name, String date) {
		this.livNo = livNo;
		this.name = name;
		this.date = date;
	}


	public String getName() {
		return name;
	}

	public int getLivNo() {
		return livNo;
	}

	public String getDate() {
		return date;
	}
	
	

}
