package test;

import static org.junit.Assert.*;

import logic.Movie;
import logic.Store;

import org.junit.Test;

public class MovieTest {

	/*
	 Write (1) GameTest.java and (2) MovieTest.java and put it inside package test.

	    GameTest must test method buy(), rent(), giveBack() and compareTo() of Class Game.
	    MovieTest must test method rent(), giveBack(), compareTo() of Class Movie.
	    Note that InventoryTest.java is provided.

	 */

	@Test
	public void testRent() {
				
		Movie movie = new Movie("AAAAA", 4.0, 100.0); //create movie
		Store.day = 1 + (int)(Math.random()*100); //random day
		movie.rent("Bot AB C", 0);
		
		assertEquals("Bot AB C", movie.getRenterName());
		assertEquals(false, movie.getIsInStock());
		assertEquals(true, movie.getIsRented() );
		assertEquals(Store.day, movie.getRentDate());
		
	}
	@Test
	public void testGiveBack() {
		
		int rentDate = 1 + (int)(Math.random()*100);		
		// Loop Store.day form rentDate to rentDate+100
		for(int j = 0; j <= 100; j++) {
			
			Store.day = rentDate; //set rent date
			Movie movie = new Movie("AAAAA", 4.0, 100.0); //create game
			movie.rent("Bot AB C", 0);
			Store.day = rentDate + j; //set now date
			
			double cost = (Store.day-rentDate)*(movie.getPrice()*0.1);
			if(Store.day==rentDate) cost = movie.getPrice()*0.1;
			
			assertEquals(cost, movie.giveBack(), 0.0);
			assertEquals("", movie.getRenterName());
			assertEquals(false, movie.getIsRented());
			assertEquals(true, movie.getIsInStock());
			assertEquals(0, movie.getRentDate());
		}
	}
	
	@Test
	public void testCompareTo() {
		
		//rating is first order
		Movie[] movie = new Movie[5]; 
		movie[1] = new Movie("AAAAA", 2.0, 500);
		movie[2] = new Movie("BBBBB", 2.0, 500);
		movie[3] = new Movie("AAAAA", 1.0, 500);
		movie[4] = new Movie("BBBBB", 1.0, 500);
				
		//Check all pair
		for(int i = 1; i < 5; i++) {
			assertEquals(0, movie[i].compareTo(movie[i]));
			for(int j = i+1; j < 5; j++) {
				assertEquals(1, movie[i].compareTo(movie[j]));
				assertEquals(-1, movie[j].compareTo(movie[i]));
			}
		}
	}
	
}
