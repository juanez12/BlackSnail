package model;

public abstract class Product{
	
	protected String name;
	protected String resume;
	protected String nameDirector;

	public Product(String name, String resume, String nameDirector){
		
		this.name=name;
		this.resume=resume;
		this.nameDirector=nameDirector;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getResume(){
		return resume;
	}

	public void setResume(String resume){
		this.resume=resume;
	}
	
	public String getNameDirector(){
		return nameDirector;
	}
	
	public void setNameDirector(String nameDirector){
		this.nameDirector=nameDirector;
	}
	
	public abstract String exampleClass(int par);

}
