package model;

public class Movie extends Product{
	
	 private int minimunAge;
	 private String nameProducer;
	 
	 private Gender genderType;
	 private Date releaseDate;
	 
	public Movie(String name, String resume, String nameDirector, int minimunAge, String nameProducer, genderType){
	 
	 super(name,resume,nameDirector);
	 this.minimunAge=minimunAge;
	 this.nameProducer=nameProducer;
	}
	
	public int getMinimumAge(){
		return minimunAge;
	}
	
	public void setMinimumAge(int minimunAge){
		this.minimunAge=minimunAge;
	}
	
	public String getNameProducer(){
		return nameProducer;
	}
	
	public void setNameProducer(String nameProducer){
		this.nameProducer=nameProducer;
	}
	
	public void addDate(int dateRls, int monthRls, int yearRls){
		releaseDate=new Date(dateRls, monthRls, yearRls);
	}
	
	public String toString(){
		String out="";
		out+= "The name of the movie is: " + name + "\n";
		out+= "the movie is about: " + resume + "\n";
		out+= "The director's name is: " + nameDirector + "\n"; 
		out+= "The minimum age to see the movie is: " + minimunAge + "\n";
		out+= "the producer of the movie is: " + nameProducer + "\n";
		out+= "it's a " + genderType + " movie \n";
		return out;
	}
	@Override
	public String exampleClass(int par){
		String out="";
		out+= "Esta es una pelicula" + par;
		return out;
	}
}