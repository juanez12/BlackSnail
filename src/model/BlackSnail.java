package model;
/**
*Class of BlackSnail
*/
public class BlackSnail{
	//Constants
	private final int MAX_SUBSCRIBERS=50;
	private final int MAX_PRODUCTS=85;
	//Attributes
	private int nit;
	private String adress;
	private String website;
	//Relations
	private Subscriber[] subscribers;
	/*
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product product5;
	*/
	private Product[] catalog;
	//Methods
	/**
	*Constructor for the class BlackSnail
	*@param nit, int, The nit of the application
	*@param adress, String, The address of the offices of the app
	*@param website, String, the link of the app
	*/
	public BlackSnail(int nit, String adress, String website){
		this.nit=nit;
		this.adress=adress;
		this.website=website;
		
		//initialazing the array of subscribers
		subscribers=new Subscriber[MAX_SUBSCRIBERS];
		catalog=new Product[MAX_PRODUCTS];
	}
	
	public String showExample(int par){
		String out="";
		for(int i=0; i<catalog.length; i++){
			if(catalog[i]!=null){
				out+=catalog[i].exampleClass(par);
			}
		}
		return out;
	}
	/**
	*It returns an int if theres space to add a new subscriber
	*@return pos, int, returns what position in the array subscribers is null
	*/
	public int theresSpace(){
		int pos=-1;
		boolean flag=false;
		for(int i=0; i<subscribers.length && !flag; i++){
			if(subscribers[i]==null){
				flag=true;
				pos=i;
			}
		}
		return pos;
	}
	
	/**
	*The method searchs the id written by the user and verifys it doesn´t exist already
	*@param idN, int The id written by the user
	*@return out, boolean, boolean that its used to verify an id doesn't exist twice
	*/
	
	public boolean searchId(int idN){
		boolean out=false;
		for(int i=0; i<subscribers.length && !out; i++){
			if(idN==subscribers[i].getIdNum()){
				out=true;
			}
		}
		return out;
	}
	/**
	*The metod adds a new subscriber with the params passed from the main
	*@param posSu, int, position from the array where the subscriber is going to be added
	*@param idN, int, id from the subscriber
	*@param nameS, String, subs's name
	*@param ageS, int,  subs's age
	*@param hoursSeen, int,  amount of hours the sub is going to consume
	*@param statusS, int , identifier of the status of the client
	*@param typeCl, int , identifier of the type of the client
	*/
	public void addSubscriber(int posSu,int idN, String nameS, int ageS, int hoursSeen, int statusS, int typeCl){
		ClientType typec=ClientType.NORMAL;
		Status statusc=Status.ACTIVE;
		switch(statusS){
			case 1:
				statusc=Status.ACTIVE;
			break;
			
			case 2:
				statusc=Status.INACTIVE;
			break;
		}
		
		switch(typeCl){
			case 1:
				typec=ClientType.NORMAL;
			break;
			
			case 2:
				typec=ClientType.PLATINUM;
			break;
			
			case 3:
				typec=ClientType.GOLD;
			break;
			
			case 4:
				typec=ClientType.DIAMOND;
			break;
		}
		
		subscribers[posSu]=new Subscriber(idN,nameS,ageS,hoursSeen,statusc,typec);
	}
	
	/**
	*Method that deactivates a subscriber and turns his type to normal
	*@param idN, int id that search a user that has it
	*/
	public void deactivateS(int idN){
		
		ClientType typec=ClientType.NORMAL;
		Status statusc=Status.INACTIVE;
		
		for(int i=0; i<subscribers.length; i++){
			if(idN!=subscribers[i].getIdNum()){
				subscribers[i].setStatus(statusc);
				subscribers[i].setType(typec);
			}
		}
	}
	
	/**
	*Search how subs are actives dependeing its type
	*@return message, String, message that shows all the active users in every type of client
	*/
	public String searchActives(){
		
		String message="";
		
		int countN=0;
		int countP=0;
		int countG=0;
		int countD=0;
		
		for(int i=0; i<subscribers.length;i++){
			if(subscribers[i]!=null){
				if(subscribers[i].getStatus().equals(Status.ACTIVE)){
					if(subscribers[i].getType().equals(ClientType.NORMAL)){
						countN++;
					}
					
					if(subscribers[i].getType().equals(ClientType.PLATINUM)){
						countP++;
					}
					
					if(subscribers[i].getType().equals(ClientType.GOLD)){
						countG++;
					}
					if(subscribers[i].getType().equals(ClientType.DIAMOND)){
						countD++;
					}
				}
			}
			message+= "The amount of actives subscribers is " + "\n";
			message+= "Normal: " + countN + "\n";
			message+= "Platinum: " + countP + "\n";
			message+= "Gold: " + countG + "\n";
			message+= "Diamond: " + countD + "\n";
		}
		return message;
	}
	/**
	*Method that search the underage sub with the most hours to consume
	*@return message, String, message that shows the name and the hours to consume from the subscriber founded
	*/
	public String searchUn(){
		int maxH=0;
		String nameS="";
		String mesage="";
			
		for(int i=0;i<subscribers.length;i++){
			if(subscribers[i]!=null){
				if(subscribers[i].getAge()<18){
					if(maxH<subscribers[i].getNumHours()){
						maxH=subscribers[i].getNumHours();
						nameS=subscribers[i].getName();
					}
				}
			}
		}
		mesage+= "The underage subscriber with the most amount of hours for see is: " + "\n";
		mesage+= nameS + "\n";
		mesage+= "with " + maxH + "\n";
			
		return mesage;
	}
	
	public int spaceProducts(){
		int pos=-1;
		boolean flag=false;
		for(int i=0; i<catalog.length && !flag; i++){
			if(catalog[i]==null){
				pos=i;
				flag=true;
			}
		}
		return pos;
	}
	
	public boolean searchName(String namePr){
		boolean found=false;
		for(int i=0; i<catalog.length && !found; i++){
			if(namePr.equals(catalog[i].getName()){
				found=true;
			}
		}
		return found;
	}
	
	public void addMovie(int psProduct, String nameM, String sinopsis, String nameDm, int minAge, String prodn, int genderOpt){
		Gender genderM=Gender.ROMANTIC;
		switch(genderOpt){
			
			case 1:
				genderM=Gender.ROMANTIC;
			break;
			
			case 2:
				genderM=Gender.ACTION;
			break;
			
			case 3:
				genderM=Gender.SUSPENSE;
			break;
			
			case 4:
				genderM=Gender.HORROR;
			break; 
			
			case 5:
				genderM=Gender.COMEDY;
			break;
		}
		
		(Movie)catalog[psProduct]=new Movie(nameM, sinopsis, nameDm, minAge, prodn, genderM); 
	}
	
	public void addSerie(int psPr, String nameS, String sipnosis, String nameDs, String censor, String censorR, String[] actors, String trailerS, int epP, int epI){
		boolean censorS=false;
		
		if(censor.equalsIgnoreCase("si"){
			censorS=true;
		}
		
		(Series)catalog[psPr]=new Series(nameS, sipnosis, nameDs, censorS, censorR);
		if(
	}
	
	//gets and sets
	public int getNit(){
		return nit;
	}
	
	public void setNit(int nit){
		this.nit=nit;
	}
	
	public String getAdress(){
		return adress;
	}
	
	public void setAdress(String adress){
		this.adress=adress;
	}
	
	public String getWebsite(){
		return website;
	}
	
	public void setWebsite(String website){
		this.website=website;
	}
	/*
	public Product getProduct1(){
		return product1;
	}
	
	public void setProduct1(Product product1){
		this.product1=product1;
	}
	
	public Product getProduct2(){
		return product2;
	}
	
	public void setProduct2(Product product2){
		this.product2=product2;
	}
	
	public Product getProduct3(){
		return product3;
	}
	
	public void setProduct3(Product product3){
		this.product3=product3;
	}
	
	public Product getProduct4(){
		return product4;
	}
	
	public void setProduct4(Product product4){
		this.product4=product4;
	}
	
	public Product getProduct5(){
		return product5;
	}
	
	public void setProduct5(Product product5){
		this.product5=product5;
	}
	*/
}