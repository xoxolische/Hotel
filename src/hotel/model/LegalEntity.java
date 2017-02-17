package hotel.model;

public class LegalEntity{
    
    private int id;
    private String name;
    private String kindOfBusiness;
    private String contactPersonName;
    private String phoneNumber;

    public LegalEntity(){
    }

    public LegalEntity(int id, String name, String kindOfBusiness,
	    String contactPersonName, String phoneNumber){
	this.id = id;
	this.name = name;
	this.kindOfBusiness = kindOfBusiness;
	this.contactPersonName = contactPersonName;
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

    public String getKindOfBusiness(){
        return kindOfBusiness;
    }

    public void setKindOfBusiness(String kindOfBusiness){
        this.kindOfBusiness = kindOfBusiness;
    }

    public String getContactPersonName(){
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName){
        this.contactPersonName = contactPersonName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
