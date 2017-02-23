package hotel.ui.object_protytypes;

import hotel.model.Guest;

public class Client extends Guest{
	
	private String name;
	private int livNo;
	//?????
	private String date;
	
	
	public Client(){
	    
	}
	
	public Client(int livNo, String name, String date) {
		this.livNo = livNo;
		this.name = name;
		this.date = date;
	}


	public void setName(String name){
	    this.name = name;
	}

	public void setLivNo(int livNo){
	    this.livNo = livNo;
	}

	public void setDate(String date){
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
