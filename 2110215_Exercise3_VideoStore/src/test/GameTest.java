package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Game;
import logic.Store;

public class GameTest {
	
	@Test
	public void testRent() {	
		
		//Loop choose option 1 to 4 => 1 week to 4 week
		for(int i = 1; i <= 4; i++) {
			Game game = new Game("AAAAA", 4.0, 100.0); //create game
			Store.day = 1 + (int)(Math.random()*100); //random day
			
			game.rent("Bot AB C", i);
			assertEquals("Bot AB C", game.getRenterName());
			assertEquals(i, game.getChosenRentOption());
			assertEquals(false, game.getIsInStock());
			assertEquals(true, game.getIsRented() );
			assertEquals(Store.day + 7*i, game.getGiveBackDate() );
			assertEquals(false, game.getIsBuyable());
		}
	}
	
	@Test
	public void testGiveBack() {
		
		//Loop choose option 1 to 4 => 1 week to 4 week
		for(int i = 1; i <= 4; i++) {
			
			//random rentDate and set giveBackDate
			int rentDate = 1 + (int)(Math.random()*100);	
			int giveBackDate = rentDate + i*7;
			
			// Loop Store.day from rentDate to rentDate + 100
			// have all case (in time/late/bound)
			for(int j = 0; j <= 100; j++) {
				
				Store.day = rentDate; // Set day for rent game
				Game game = new Game("AAAAA", 4.0, 100.0); //create game
				game.rent("Bot AB C", i);
				double lateFeePerDay = game.getPrice()*0.10;
				Store.day = rentDate + j; // Set day for give back game
				
				double cost = Game.RENTAL_RATES[i-1] * game.getPrice();
				if(Store.day - giveBackDate > 0) cost += (Store.day - giveBackDate) * lateFeePerDay;	
						
				assertEquals(cost, game.giveBack(), 0.0);
				assertEquals(0, game.getChosenRentOption());
				assertEquals("", game.getRenterName());
				assertEquals(false, game.getIsRented());
				assertEquals(0, game.getGiveBackDate());
				assertEquals(true, game.getIsInStock());
			}
		}			
	}
	
	@Test
	public void testCompareTo() {
		
		//rating is first order
		Game[] game = new Game[5]; 
		game[1] = new Game("AAAAA", 2.0, 500);
		game[2] = new Game("BBBBB", 2.0, 500);
		game[3] = new Game("AAAAA", 1.0, 500);
		game[4] = new Game("BBBBB", 1.0, 500);
		
		//Check all pair
		for(int i = 1; i < 5; i++) {
			assertEquals(0, game[i].compareTo(game[i]));
			for(int j = i+1; j < 5; j++) {
				assertEquals(1, game[i].compareTo(game[j]));
				assertEquals(-1, game[j].compareTo(game[i]));
			}
		}
	}
	
	@Test
	public void testBuy()
	{
		// random price 100 times
		for(int i = 0; i < 100; i++) {
			double price = (100 + (int)(Math.random()*10000))/100.0;
			Game game = new Game("AAAAA", 4.0, price);
			double cost = game.buy("Bot AB C");
			assertEquals("Bot AB C",game.getBuyerName());
			assertEquals(true,game.getIsBought());
			assertEquals(false,game.getIsInStock());
			assertEquals(false,game.getIsBuyable());
			assertEquals(cost,game.getPrice(),0.0);
		}
	}
}
