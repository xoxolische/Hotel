package hotel.model;

public class HotelRoom{

    private int id;
    private int number;
    private int rClass;
    private int capacity;
    private int floor;
    private int idPriceList;
    
    public HotelRoom(){
	
    }

    public HotelRoom(int id, int number, int rClass, int capacity, int floor, int idPriceList){
	this.id = id;
	this.number = number;
	this.rClass = rClass;
	this.capacity = capacity;
	this.floor = floor;
	this.idPriceList = idPriceList;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getRoomClass(){
        return rClass;
    }

    public void setRoomClass(int rClass){
        this.rClass = rClass;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getFloor(){
        return floor;
    }

    public void setFloor(int floor){
        this.floor = floor;
    }

    public int getIdPriceList(){
        return idPriceList;
    }

    public void setIdPriceList(int idPriceList){
        this.idPriceList = idPriceList;
    }

}
