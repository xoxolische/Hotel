package hotel.model;

public class Individual{

    private int id;
    private String name;
    private String sex;
    private String phoneNumber;
    
    public Individual(){
    }

    public Individual(int id, String name, String sex, String phoneNumber){
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.phoneNumber = phoneNumber;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
