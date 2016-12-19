package test;

import static org.junit.Assert.*;
import logic.Game;
import logic.Inventory;
import logic.Item;
import logic.Movie;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

	private Inventory inventory;
	
	@Before
	public void setUp() throws Exception {
		Inventory.initialSize = 10;
		Game.idCount = 0;
		Movie.idCount = 0; 
		inventory = new Inventory();
	}
	
	@Test
	public void testSortGames() {
		
		//All games should be correctly sorted after inventory is initialized.
		assertEquals(4,inventory.getGames().get(0).getId());
		assertEquals(5,inventory.getGames().get(1).getId());
		assertEquals(1,inventory.getGames().get(2).getId());
		assertEquals(3,inventory.getGames().get(3).getId());
		assertEquals(7,inventory.getGames().get(4).getId());
		assertEquals(6,inventory.getGames().get(5).getId());
		assertEquals(2,inventory.getGames().get(6).getId());
		assertEquals(8,inventory.getGames().get(7).getId());
		assertEquals(10,inventory.getGames().get(8).getId());
		assertEquals(9,inventory.getGames().get(9).getId());
		
		//The added games should be correctly sorted after sortGames() is called.
		inventory.addGame(new Game("Ninja Gaiden",4.5,19.99));
		inventory.addGame(new Game("Bomberman",4.1,9.99));
		inventory.sortGames();
		
		assertEquals(11,inventory.getGames().get(4).getId());
		assertEquals(12,inventory.getGames().get(8).getId());
		
	}

	@Test
	public void testSortMovies() {
		
		//All movies should be correctly sorted after inventory is initialized.
		assertEquals(3, inventory.getMovies().get(0).getId());
		assertEquals(1, inventory.getMovies().get(1).getId());
		assertEquals(7, inventory.getMovies().get(2).getId());
		assertEquals(2, inventory.getMovies().get(3).getId());
		assertEquals(4, inventory.getMovies().get(4).getId());
		assertEquals(10, inventory.getMovies().get(5).getId());
		assertEquals(6, inventory.getMovies().get(6).getId());
		assertEquals(5, inventory.getMovies().get(7).getId());
		assertEquals(8, inventory.getMovies().get(8).getId());
		assertEquals(9, inventory.getMovies().get(9).getId());
		
		//The added movies should be correctly sorted after sortGames() is called.
		inventory.addMovie(new Movie("Ant man",4.2,45.99));
		inventory.addMovie(new Movie("World War Z",5.0,29.99));
		inventory.sortMovies();
		
		assertEquals(11, inventory.getMovies().get(8).getId());
		assertEquals(12, inventory.getMovies().get(2).getId());
		
	}

	@Test
	public void testSearchForRentableGame() {
		
		inventory.addGame(new Game(Inventory.gameNames[0],Inventory.gameRatings[0],Inventory.gamePrices[0]));
		
		//The index of rentable game which has the same name as user mentioned should be returned.  
		int index1 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getGames().get(index1).getName());
		assertEquals(true, inventory.getGames().get(index1).getId() == 1 || inventory.getGames().get(index1).getId() == 11);
		
		inventory.getGames().get(index1).rent("Earth", 1);
		
		//The first "Dragon Quest" game is rented,the second "Dragon Quest" game index should be returned. 
		int index2 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getGames().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getGames().get(index1).getId() == 1 && inventory.getGames().get(index2).getId() == 11) || (inventory.getGames().get(index1).getId() == 11 && inventory.getGames().get(index2).getId() == 1));
		
		inventory.getGames().get(index2).rent("John", 1);
		
		//-1 should be returned because all "Dragon Quest" games are rented.
		int index3 = inventory.searchForRentableGame("DragonQuest");
		assertEquals(-1, index3);
		
		//The second "Dragon Quest" game is returned so the index returned from calling searchForRentableGame should be the same as index2.
		inventory.getGames().get(index2).giveBack();
		int index4 = inventory.searchForRentableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getGames().get(index4).getName());
		assertEquals(true, index4 == index2);
	
	}

	@Test
	public void testSearchForRentableMovie() {
		
		inventory.addMovie(new Movie(Inventory.movieNames[0],Inventory.movieRatings[0],Inventory.moviePrices[0]));
		
		//The index of rentable movie which has the same name as user mentioned should be returned.
		int index1 = inventory.searchForRentableMovie("Hobbit");
		assertEquals("Hobbit", inventory.getMovies().get(index1).getName());
		assertEquals(true, inventory.getMovies().get(index1).getId() == 1 || inventory.getMovies().get(index1).getId() == 11);
		
		inventory.getMovies().get(index1).rent("Earth", 0);
		
		//The first "Hobbit" movie is rented,the second "Hobbit" movie index should be returned. 
		int index2 = inventory.searchForRentableMovie("Hobbit");
		assertEquals("Hobbit", inventory.getMovies().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getMovies().get(index1).getId() == 1 && inventory.getMovies().get(index2).getId() == 11) || (inventory.getMovies().get(index1).getId() == 11 && inventory.getMovies().get(index2).getId() == 1));
		
		inventory.getMovies().get(index2).rent("John", 0);
		
		//-1 should be returned because all "Hobbit" movies are rented.
		int index3 = inventory.searchForRentableMovie("Hobbit");
		assertEquals(-1, index3);
		
		//The second "Hobbit" movie is returned so the index returned from calling searchForRentableGame should be the same as index2.
		inventory.getMovies().get(index2).giveBack();
		int index4 = inventory.searchForRentableMovie("Hobbit");
		assertEquals("Hobbit", inventory.getMovies().get(index4).getName());
		assertEquals(true, index4 == index2);
	}

	@Test
	public void testSearchForBuyableGame() {
		
		inventory.addGame(new Game(Inventory.gameNames[0],Inventory.gameRatings[0],Inventory.gamePrices[0]));
		
		//The index of buyable game which has the same name as user mentioned should be returned.  
		int index1 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getGames().get(index1).getName());
		assertEquals(true, inventory.getGames().get(index1).getId() == 1 || inventory.getGames().get(index1).getId() == 11);
		
		inventory.getGames().get(index1).buy("Earth");
		
		//The first "Dragon Quest" game is bought,the second "Dragon Quest" game index should be returned. 
		int index2 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals("Dragon Quest", inventory.getGames().get(index2).getName());
		assertEquals(true, index1 != index2);
		assertEquals(true, (inventory.getGames().get(index1).getId() == 1 && inventory.getGames().get(index2).getId() == 11) || (inventory.getGames().get(index1).getId() == 11 && inventory.getGames().get(index2).getId() == 1));
		
		inventory.getGames().get(index2).rent("John", 4);
		inventory.getGames().get(index2).giveBack();
		
		//Once the game is rented,it won't be able to buy. So -1 should be returned because there is no buyable "Dragon Quest" game in the inventory.
		int index3 = inventory.searchForBuyableGame("Dragon Quest");
		assertEquals(-1, index3);
	}

}
