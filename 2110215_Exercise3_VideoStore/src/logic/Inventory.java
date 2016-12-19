package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
	
	// TODO Fill Code Class ItemItr
	public class ItemItr implements Iterator<Item> {
		private Item[] items;
		public int index;
		
		public ItemItr(Item[] items){
			this.items = items;
			this.index = 0;
		}
		
		public boolean hasNext() {
			if(index < items.length)
				return true;
			return false;
		}
		public Item next() {
			return items[index++];
		}
		public void remove() {}
	}
	
	private ArrayList<Game> games;
	private ArrayList<Movie> movies;
	
	public static String movieNames[] = {"Hobbit","Star War","Harry Potter","Imitation Game","Social Network","Big Hero 6","Gone Girl","Automata","Iron man","Avengers"};
	public static double movieRatings[] = {5.0,4.6,5.0,4.5,4.1,4.3,4.8,4.0,4.0,4.3};
	public static double moviePrices[] = {40.00,30.00,30.00,50.00,40.00,50.00,50.00,50.00,30.00,30.00};
	public static String gameNames[] = {"Dragon Quest","The Sim","Final Fantasy","Super Mario","Donkey Kong","Sonic","Megaman","Kirby","Monopoly","Mario Kart"};
	public static double gameRatings[] = {4.5,4.2,4.5,4.7,4.5,4.2,4.3,4.0,4.0,4.0};
	public static double gamePrices[] = {30.00,30.00,30.00,10.00,10.00,10.00,20.00,10.00,20.00,20.00};
	public static int initialSize = 3;
	
	public Inventory(){
		this.games = new ArrayList<Game>();
		this.movies = new ArrayList<Movie>();
		
		this.initailize();
	}
	
	public void initailize(){
		for (int i = 0;i < initialSize ; i++)
		{
			this.addMovie(new Movie(movieNames[i],movieRatings[i],moviePrices[i]));
		}
		this.sortMovies();
		
		for (int i = 0;i < initialSize; i++)
		{
			this.addGame(new Game(gameNames[i],gameRatings[i],gamePrices[i]));
		}
		this.sortGames();
	}
	
	public void addGame(Game game){
		// TODO Fill Code
		games.add(game);
	}
	
	public void addMovie(Movie movie){
		// TODO Fill Code
		movies.add(movie);
	}

	public void list(Item[] items)
	{
		// TODO Fill Code
		ItemItr iterator = new ItemItr(items);
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
	
	public void sortGames(){
		// TODO Fill Code
		Comparator<Game> compGame = new Comparator<Game>(){
			@Override
			public int compare(Game o1, Game o2) {
		        return o2.compareTo(o1);
		    }
		};
		
		Collections.sort(games, compGame);
	}
	
	public void sortMovies(){
		// TODO Fill Code
		Comparator<Movie> compMovie = new Comparator<Movie>(){
			@Override
			public int compare(Movie o1, Movie o2) {
		        return o2.compareTo(o1);
		    }
		};
		
		Collections.sort(movies, compMovie);
	}
	
	public int searchForRentableGame(String gameName){
		// TODO Fill Code
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getName().equals(gameName) && !games.get(i).getIsRented() && games.get(i).getIsInStock()) 
				return i;
		}
		return -1;
	}
	
	public int searchForRentableMovie(String movieName){
		// TODO Fill Code
		for(int i = 0; i < movies.size(); i++) {
			if(movies.get(i).getName().equals(movieName) && !movies.get(i).getIsRented() && movies.get(i).getIsInStock()) 
				return i;
		}
		return -1;
	}
	
	public int searchForBuyableGame(String gameName){
		// TODO Fill Code
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getName().equals(gameName) && games.get(i).getIsBuyable() && !games.get(i).getIsBought()) 
				return i;
		}
		return -1;
		
	}
	
	// TODO Implement Getter&Setter

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
}
