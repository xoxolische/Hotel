package hotel.model;

public class Individual{

    private long id;
    private String name;
    private String sex;
    private String phoneNumber;
    
    public Individual(){
    }

    public Individual(long id, String name, String sex, String phoneNumber){
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.phoneNumber = phoneNumber;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
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
