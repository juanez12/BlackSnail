package model;

public class Series extends Product{
	
	private boolean censored;
	private String censoredCause;
	
	private Date emisionDate;
	private Season[] seasons;
	private Actor[] actors;
	
	public Series(String name, String resume, String nameDirector, boolean censored, String censoredCause){
		super(name, resume, nameDirector);
		this.censored=censored;
		this.censoredCause=censoredCause;
	}
	
	public boolean getCensored(){
		return censored;
	}
	
	public void setCensored(boolean censored){
		this.censored=censored;
	}
	
	public String getCensoredCause(){
		return censoredCause;
	}
	
	public void setCensoredCause(String censoredCause){
		this.censoredCause=censoredCause;
	}
	
	public String toString(){
		String out="";
		out+= "The name of the serie is: " + name + "\n";
		out+= "it's about: " + resume + "\n"; 
		out+= "The director's name is : " + nameDirector + "\n";
		if(censored){
			out+="The serie was censored for this reason: " + censoredCause + "\n";
			out+="It's planned that the serie will have " + seasons.length + "seasons \n";
			for(int i=0; i<actors.length; i++){
				out+="The serie has this actors: " + actors[i].getName() + "\n";
			}
		}
		
		else{
			out+="It's planned that the serie will have " + seasons.length + "seasons \n";
			for(int i=0; i<actors.length; i++){
				out+="The serie has this actors: " + actors[i].getName() + "\n";
			}
		}
		return out;
	}
	
	public void addActor(){
		
	}
	
	@Override
	public String exampleClass(int par){
		String out="";
		out+= "Esta es una serie" + (par+10);
		return out;
	}
}