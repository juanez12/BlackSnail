package model;
/**
*Class subscriber
*/
public class Subscriber{
	//Attributes
	private int idNum;
	private String name;
	private int age;
	private int numHours;
	
	//Relations
	/**
	* type of the client NORMAL, PLATINUM, GOLD, DIAMOND
	*/
	private ClientType type;
	
	/**
	*Status of the subscriber ACTIVE, INACTIVE
	*/
	private Status status;
	
	//Methods
	/**
	*Constructor of the class Subscriber
	*@param idNum, int, id from the subscriber
	*@param name, String, subs's name
	*@param age, int,  subs's age
	*@param numHours, int,  amount of hours the sub is going to consume
	*@param status, int , identifier of the status of the client
	*@param type int , identifier of the type of the client
	*/
	public Subscriber(int idNum, String name, int age, int numHours, Status status, ClientType type){
		this.idNum=idNum;
		this.name=name;
		this.age=age;
		this.numHours=numHours;
		this.status=status;
		this.type=type;
	}
	
	public String getName(){
		return name;
	}
	
	public int getIdNum(){
		return idNum;
	}
	
	public int getAge(){
		return age;
	}
	
	public int getNumHours(){
		return numHours;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public ClientType getType(){
		return type;
	}
	
	public void setStatus(Status status){
		this.status=status;
	}
	
	public void setType(ClientType type){
		this.type=type;
	}
}