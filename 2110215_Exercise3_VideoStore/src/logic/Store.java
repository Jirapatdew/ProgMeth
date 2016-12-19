package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.ws.spi.Invoker;

public class Store {
	
	public static Scanner in;
	public static Inventory inventory;
	public static int day = 1;
	
	public static void main(String[] args) {
		String command;
		in = new Scanner(System.in);
		inventory = new Inventory();
		
		while (true) {
			showMenu();
			command = in.nextLine();

			System.out.println();
			
			switch (command) {
				case "L":
					listItemMenu();
					break;
				case "AG":
					addGameMenu();
					break;
				case "AM":
					addMovieMenu();
					break;
				case "RG":
					rentGameMenu();
					break;
				case "RM" :
					rentMovieMenu();
					break;
				case "GG" :
					returnGameMenu();
					break;
				case "GM" :
					returnMovieMenu();
					break;
				case "BG" :
					buyGameMenu();
					break;
				case "E":
					System.out.println("Program terminated");
					System.exit(0);
					break;
				case "T":
					timePassingMenu();
					break;
				default:
					System.out.println("Invalid command.");
					break;
			}
			
			System.out.println();
		}
	}
	
	private static void showMenu(){
		System.out.println("########################################");
		System.out.println("Video Store Menu (Day " + day + ")");
		System.out.println("########################################");
		System.out.println("AG)\tAdd game\tAM)\tAdd movie");
		//System.out.println("AM)\tAdd movie");
		System.out.println("RG)\tRent game\tRM)\tRent movie");
		//System.out.println("RM)\tRent movie");
		System.out.println("GG)\tReturn game\tGM)\tReturn movie");
		//System.out.println("GM)\tReturn movie");
		System.out.println("BG)\tBuy game\tL)\tList all items");
		System.out.println("T)\tTime passing\tE)\tExit");
		System.out.println("----------------------------------------");
		System.out.print("Enter input command : ");
	}
	
	private static void listItemMenu() {
		System.out.println("----------------------------------------");
		System.out.println("List all items in inventory");
		System.out.println("----------------------------------------");
		System.out.println("Game (Total " + inventory.getGames().size() + "):");
		System.out.println("----------------------------------------");
		
		inventory.list(inventory.getGames().toArray(new Item[]{}));
		
		System.out.println("----------------------------------------");
		System.out.println("Movie (Total " + inventory.getMovies().size() + "):");
		System.out.println("----------------------------------------");
		
		inventory.list(inventory.getMovies().toArray(new Item[]{}));
	}
	
	private static void addGameMenu() {
		System.out.println("----------------------------------------");
		System.out.println("Add game to inventory");
		System.out.println("----------------------------------------");
		int rand = (int)(Math.random() * 9);
		System.out.println("Name  : " + Inventory.gameNames[rand]);
		System.out.println("Rate  : " + Inventory.gameRatings[rand]);
		System.out.println("Price : " + Inventory.gamePrices[rand]);
		inventory.addGame(new Game(Inventory.gameNames[rand],Inventory.gameRatings[rand],Inventory.gamePrices[rand]));
		inventory.sortGames();

	}
	
	private static void addMovieMenu() {
		System.out.println("----------------------------------------");
		System.out.println("Add movie to inventory");
		System.out.println("----------------------------------------");
		int rand = (int)(Math.random() * 9);
		System.out.println("Name  : " + Inventory.movieNames[rand]);
		System.out.println("Rate  : " + Inventory.movieRatings[rand]);
		System.out.println("Price : " + Inventory.moviePrices[rand]);
		inventory.addMovie(new Movie(Inventory.movieNames[rand],Inventory.movieRatings[rand],Inventory.moviePrices[rand]));
		inventory.sortMovies();
	}
	
	private static void rentGameMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Rent game");
		System.out.println("----------------------------------------");
		
		String gameName;
		String renterName;
		int rentOption;
		
		// TODO Fill Code
		System.out.print("Enter game name : ");
		gameName = in.nextLine();
		
		int idx = inventory.searchForRentableGame(gameName);
		if(idx == -1) {
			System.out.println("The game is not available to rent. Back to menu.");
			return;
		}
		
		Game game = inventory.getGames().get(idx);
		
		System.out.println("Choose the rental options from 1 - 4 :");
		System.out.format("1) $%.2f for 1 week\n", Game.RENTAL_RATES[0]*game.price);
		System.out.format("2) $%.2f for 2 weeks\n",Game.RENTAL_RATES[1]*game.price);
		System.out.format("3) $%.2f for 3 weeks\n",Game.RENTAL_RATES[2]*game.price);
		System.out.format("4) $%.2f for 4 weeks\n",Game.RENTAL_RATES[3]*game.price);
		System.out.format("Enter your option : ");
		rentOption = in.nextInt();
		
		in.nextLine(); // For '\n' from pressing enter;
		
		if(rentOption < 1 || rentOption > 4) {
			System.out.println("Invalid option. Back to menu.");
			return;
		}
				
		System.out.print("Enter your name : ");
		renterName = in.nextLine();
		game.rent(renterName, rentOption);
		System.out.println("You rented the game successfully. The game ID is " + game.getId() + ".");
		System.out.println("Please inform the game ID when you return it.");
		System.out.format("Please return the game within Day %d. Late fee is $%.2f/day.\n", game.getGiveBackDate() , game.getLateFeePerDay());
		
	}
	
	private static void rentMovieMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Rent movie");
		System.out.println("----------------------------------------");
		
		String movieName;
		String renterName;
		
		// TODO Fill Code
		System.out.print("Enter movie name : ");
		movieName = in.nextLine();
		
		int idx = inventory.searchForRentableMovie(movieName);
		if(idx == -1) {
			System.out.println("The movie is not available to rent. Back to menu.");
			return;
		}
		
		Movie movie = inventory.getMovies().get(idx);
		
		System.out.print("Enter your name : ");
		renterName = in.nextLine();
		movie.rent(renterName, 0);
		System.out.println("You rented the movie successfully. The movie ID is " + movie.getId() + ".");
		System.out.println("Please inform the movie ID when you return it.");
		System.out.format("Rental fee is $%.2f/day.\n", movie.getPrice()*0.1);

	}
	
	private static void returnGameMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Return Game");
		System.out.println("----------------------------------------");
		
		int gameID;
		Game rentedGame = null;
		
		// TODO Fill Code
		System.out.print("Enter game ID : ");
		gameID = in.nextInt();
		
		for(Game tmp : inventory.getGames()) {
			if(tmp.getId() == gameID) {rentedGame = tmp; break;}
		}
		if(rentedGame == null || !rentedGame.getIsRented()) {
			System.out.println("The game is not rented. Back to menu.");
			in.nextLine(); // For '\n' from pressing enter;
			return;
		}
		int giveBackDate = rentedGame.getGiveBackDate();
		System.out.format("The rental fee is $%.2f.",rentedGame.giveBack());
		if(Store.day > giveBackDate) System.out.format(" (Late %d days)", Store.day - giveBackDate);
		System.out.println();
		
		in.nextLine(); // For '\n' from pressing enter;
	}
	
	private static void returnMovieMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Return movie");
		System.out.println("----------------------------------------");
		
		int movieID;
		Movie rentedMovie = null;
		
		// TODO Fill Code
		System.out.print("Enter movie ID : ");
		movieID = in.nextInt();
		in.nextLine(); // For '\n' from pressing enter;
		
		for(Movie tmp : inventory.getMovies()) {
			if(tmp.getId() == movieID) {rentedMovie = tmp; break;}
		}
		if(rentedMovie == null || !rentedMovie.getIsRented()) {
			System.out.println("The movie is not rented. Back to menu.");
			return;
		}
		
		System.out.format("The rental fee is $%.2f.\n",rentedMovie.giveBack());
			
	}
	
	private static void buyGameMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Buy Game");
		System.out.println("----------------------------------------");
		
		String gameName;
		String buyerName;
		
		// TODO Fill Code
		System.out.print("Enter game name : ");
		gameName = in.nextLine();
		
		int idx = inventory.searchForBuyableGame(gameName);
		if(idx == -1) {
			System.out.println("The game is not available to buy. Back to menu.");
			return;
		}
		
		Game game = inventory.getGames().get(idx);
		
		System.out.print("Enter your name : ");
		buyerName = in.nextLine();
		game.buy(buyerName);
		System.out.format("The price is $%.2f.\n",game.getPrice());
		System.out.println("Thank you for buying.");

	}
	
	private static void timePassingMenu() {
		System.out.println("----------------------------------------");
		System.out.println("Simulate Time Passing");
		System.out.println("----------------------------------------");
		
		System.out.print("Enter the number of days passing : ");
		
		try{
			int days = in.nextInt();
			
			if (days <= 0)
			{
				System.out.println("The number of days should be more than 0.");
			}
			else
			{
				Store.day += days;
				System.out.println("Now is Day " + Store.day + ".");
			}
		}
		catch(Exception e)
		{
			System.out.println("The input should be an integer.");
		}
		
		in.nextLine(); // For '\n' from pressing enter;
	}

}
