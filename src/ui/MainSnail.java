package ui;

import java.util.Scanner;

import model.BlackSnail;

public class MainSnail{
	
	private BlackSnail mySnail;
	
	public Scanner sc;
	/**
	*Creates the objetcs for the Scanner and for the Class Black Snail
	*/
	public MainSnail(){
		sc=new Scanner(System.in);
		
		String nameP="";
		String resumeP="";
		String namDP="";
		
		System.out.println(
			"Welcome to black snail " + "\n" +
			"Please write the initial parameters to config " + "\n" 
			);
		
		System.out.println("Please enter the nit");
		int nit=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please enter the address");
		String adr=sc.nextLine();
		
		System.out.println("Please enter the website");
		String web=sc.nextLine();
		
		mySnail=new BlackSnail(nit,adr,web);
		/*
		System.out.println("Please enter the name of product 1");
		nameP=sc.nextLine();
		
		System.out.println("Please enter the resume of product 1");
		resumeP=sc.nextLine();
		
		System.out.println("Please enter the director's name of product 1");
		namDP=sc.nextLine();
		
		Product product=new Product(nameP, resumeP, namDP);
		mySnail.setProduct1(product);
		
		System.out.println("Please enter the name of product 2");
		nameP=sc.nextLine();
		
		System.out.println("Please enter the resume of product 2");
		resumeP=sc.nextLine();
		
		System.out.println("Please enter the director's name of product 2");
		namDP=sc.nextLine();
		
		Product product=new Product(nameP, resumeP, namDP);
		mySnail.setProduct2(product);
		
		System.out.println("Please enter the name of product 3");
		nameP=sc.nextLine();
		
		System.out.println("Please enter the resume of product 3");
		resumeP=sc.nextLine();
		
		System.out.println("Please enter the director's name of product 3");
		namDP=sc.nextLine();
		
		Product product=new Product(nameP, resumeP, namDP);
		mySnail.setProduct3(product);
		
		System.out.println("Please enter the name of product 4");
		nameP=sc.nextLine();
		
		System.out.println("Please enter the resume of product 4");
		resumeP=sc.nextLine();
		
		System.out.println("Please enter the director's name of product 4");
		namDP=sc.nextLine();
		
		Product product=new Product(nameP, resumeP, namDP);
		mySnail.setProduct4(product);
		
		System.out.println("Please enter the name of product 5");
		nameP=sc.nextLine();
		
		System.out.println("Please enter the resume of product 5");
		resumeP=sc.nextLine();
		
		System.out.println("Please enter the director's name of product 5");
		namDP=sc.nextLine();
		
		Product product=new Product(nameP, resumeP, namDP);
		mySnail.setProduct5(product);
		*/
	}
	
	public static void main(String[] args){
		
		MainSnail ms=new MainSnail();
		System.out.println("Starting the app");
		int option=0;
		do{
			option=ms.showMenu();
			ms.enterMenu(option);
		}while(option!=0);
	}
	/**
	*It shows the menu to manage the different elements that are gonna be in the app
	*@return option, int, It returns the option to enter the diferent options in the menu
	*/
	public int showMenu(){
		int option=0;
		System.out.println("Please select which element do you want to manage");
		System.out.println("1. Subscribers");
		System.out.println("2. Catalog");
		System.out.println("3. Services' creation");
		System.out.println("0. Exit the app");
		option=sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	*It enters to the different methods to manage the elements of the app
	*@param option, int, parameter used to enter the diferent methods
	*/
	public void enterMenu(int option){
		switch(option){
			case 0:
				System.out.println("Bye");
			break;
			
			case 1:
				menuSubs();
			break;
			
			case 2:
				menuCatalog();
			break;
			/*
			case 3:
				menuServices();
			break;
			*/
				
			
			default:
				System.out.println("Error option invalid");
		}
	}
	/**
	*Metohd that enters to the metohds that configure the subscribers in the app
	*/
	public void menuSubs(){
		
		System.out.println("Please select wich option do you want to do with the Subscriber");
		System.out.println("1. Create a subscriber");
		System.out.println("2. Deactivate a subscriber");
		System.out.println("3. Show active actives subscribers in the differents types");
		System.out.println("4. Show the underage subscriber with the most comsuming hours");
		
		int select=sc.nextInt();
		sc.nextLine();
		
		switch(select){
			
			case 1:
				createSub();
			break;
			
			case 2:
				deactivateSub();
			break;
			
			case 3:
				showSubs();
			break;
			
			case 4:
				showUnderAge();
			break;
		}
	}
	
	public void menuCatalog(){
		System.out.println("Please select which option do you want to do with the Catalog");
		System.out.println("1. Add a product");
		System.out.println("2. Show the info from a product");
		System.out.println("3. Create a new season for a serie");
		System.out.println("4. Show the list of Movies");
		System.out.println("5. Show the list of Series");
		
		int option=sc.nextInt();
		sc.nextLine();
		
		switch(option){
			case 1:
				addProduct();
			break;
			
			case 2:
				showInfoP();
			break;
			
			case 3:
				createSeason();
			break;
			
			case 4:
				listMovies();
			break;
			
			case 5:
				listSeries();
			break;
		}
	}
	
	public void createSub(){
		
		int posSub=mySnail.theresSpace();
		
		if(posSub>-1){
			System.out.println("Please write your id number");
			int id=sc.nextInt();
			sc.nextLine();
			do{
				System.out.println("That id number is already registered, please try another one");
				id=sc.nextInt();
				sc.nextLine();
			}while(mySnail.searchId(id));
			
			System.out.println("Please write your full name");
			String nameSub=sc.nextLine();
			
			System.out.println("Please enter your age");
			int ageSub=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter how much hours do you want to consume");
			int amountHours=sc.nextInt();
			sc.nextLine();
			
			int statusSub=1;
			
			System.out.println("Please enter which type of client do you want to be");
			System.out.println("1. Normal");
			System.out.println("2. Platinum");
			System.out.println("3. Gold");
			System.out.println("4. Diamond");
			int typeC=sc.nextInt();
			sc.nextLine();
			do{
				System.out.println("The number can't be less than 1 and more than 4");
				typeC=sc.nextInt();
				sc.nextLine();
			}while(typeC!=1 && typeC!=2 && typeC!=3 && typeC!=4);
			
			mySnail.addSubscriber(posSub,id,nameSub,ageSub,amountHours,statusSub,typeC);
		}
		else{
			System.out.println("The program can't create more subscribers");
		}
	}
	/**
	*Method used to change the status from a user to inactive
	*/
	public void deactivateSub(){
		System.out.println("Write the id number from the subscriber you want to deactivate");
		int id=sc.nextInt();
		sc.nextLine();
		if(mySnail.searchId(id)){
			mySnail.deactivateS(id);
			System.out.println("The subscriber has been deactivated");
		}
		else{
			System.out.println("There is no subscriber with that id number");
		}
	}
	/**
	*Method that shows the users active depending its type
	*/
	public void showSubs(){
		mySnail.searchActives();
	}
	/**
	*Method that show the sub underage with most hours to consume
	*/
	public void showUnderAge(){
		mySnail.searchUn();
	}
	
	public void addProduct(){
		int pospr=mySnail.spaceProducts;
		if(mySnail.spaceProducts()>-1){
			System.out.println("Write the name of the product");
			String nameP=sc.nextLine();
			
			do{
				System.out.println("It already exists a product with that name, please write another");
			}while(mySnail.searchName(nameP));
			
			System.out.println("Write the resume of the product");
			String resP=sc.nextLine();
			
			System.out.println("Write the director's name from the product");
			String dirName=sc.nextLine();
			
			System.out.println("Please select which type is the product:");
			System.out.println("1. Serie");
			System.out.println("2. Movie");
			
			int optionP=sc.nextInt();
			sc.nextLine();
			
			switch(optionP){
				case 1:
					System.out.println("Write if the serie was censored");
					String cens=sc.nextLine();
					
					if(cens.equalsIgnoreCase("Si")){
						System.out.println("Write the reason of the censure");
						String reasonCens=sc.nextLine();
						System.out.println("Write how many main actors are in the serie");
						int numact=sc.nextInt();
						sc.nextLine();
						String[] actorn;
						actorn=new String[numact];
						String namAct="";
						
						for(int i=0; i<numact; i++){
							System.out.println("Write the actors' names");
							actorn[i]=sc.nextLine();
						}
						
						System.out.println("Write how many seasons the serie's gonna have");
						int numS=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Write the date of the release of the first season");
						
						System.out.println("First the day");
						int dayr=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Then the month");
						int monthr=sc.nextInt();
						sc.nextLine();
						
						System.out.println("And last the year");
						int yearR=sc.nextLine();
						sc.nextLine();
						
						int idS=1;
						
						System.out.println("Write the route of the first season's trailer");
						String trails=sc.nextLine();
						
						System.out.println("Write how many epissodes are planned for the first season");
						int epPlan=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Write how many episodes from the first season have been broadcasted");
						int epBr=sc.nextInt();
						sc.nextLine();
											
						mySnail.addSerie(pospr,nameP,resume,dirName,cens,reasonCens,actorn,numS,idS,trails,epPlan,epBr);
					}
					
					else{
						String reasonCens="Nothing";
						
						System.out.println("Write the route of the first season's trailer");
						String trails=sc.nextLine();
						
						System.out.println("Write how many seasons the serie's gonna have");
						int numS=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Write the date of the release of the first season");
						
						System.out.println("First the day");
						int dayr=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Then the month");
						int monthr=sc.nextInt();
						sc.nextLine();
						
						System.out.println("And last the year");
						int yearR=sc.nextLine();
						sc.nextLine();
						
						int idS=1;
						
						System.out.println("Write how many epissodes are planned for the first season");
						int epPlan=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Write how many episodes from the first season have been broadcasted");
						int epBr=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Write how many main actors are in the serie");
						int numact=sc.nextInt();
						sc.nextLine();
						String[] actorn;
						actorn=new String[numact];
						
						for(int i=0; i<numact; i++){
							System.out.println("Write the actors' names");
							actorn[i]=sc.nextLine(); 
						}
					}
					
					mySnail.addProduct(pospr,nameP,resume,dirName,cens,reasonCens,actorn,numS,idS,trails,epPlan,epBr);
					
				break;
				
				case 2:
					System.out.println("Write the name of the producer");
					String namPr=sc.nextLine();
					
					System.out.println("Write the minimum age to see the movie");
					int ageM=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Select which gender the movie is");
					System.out.println("1. Romantic");
					System.out.println("2. Action");
					System.out.println("3. Suspense");
					System.out.println("4. Horror");
					System.out.println("5. Comedy");
					
					int genderSel=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Write the premiere's date of the movie, first the day, then the month, and last the year");
					
					int dayp=sc.nextInt();
					sc.nextLine();
					
					int monthp=sc.nextInt();
					sc.nextLine();
					
					int yearp=sc.nextInt();
					sc.nextLine();
					
					mySnail.addMovie(pospr,nameP,resume,dirName,ageM,namPr, genderSel, dayp, monthp, yearp);
					
				break;
				
			}
		}
		
		else{
			System.out.println("There can't be added more series and movies");
		}
	}
}