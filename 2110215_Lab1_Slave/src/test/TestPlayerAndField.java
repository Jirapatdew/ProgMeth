package test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import slave.Card;
import slave.Deck;
import slave.Field;
import slave.Player;

public class TestPlayerAndField {

	@Test
	public void testStartingHand(){
		Deck deck = new Deck();
		Player[] players = new Player[4];
		players[0] = new Player("Alice");
		players[1] = new Player("Bill");
		players[2] = new Player("Cain");
		players[3] = new Player("Doug");
		deck.shuffle();
		int i = 0;
		while (deck.getDeckSize() > 0) {
			players[i].addCardToHand(deck.deal());
			i++;
			if (i == players.length)
				i = 0;
		}
		
		int handCount = 0;
		for(int j=0; j<4; j++)
			handCount += players[j].getCardsInHand().size();
		assertTrue(handCount == 52);
		
		HashSet<Card> cardsHash = new HashSet<Card>();
		for(int j=0; j<4; j++)
			cardsHash.addAll(players[j].getCardsInHand());
		assertTrue(cardsHash.size() == 52);
	}
	
	@Test
	public void testPlaying() {
		Field field = new Field();
		assertTrue(field.getTopPile() == null);

		Player p = new Player("Test");
		p.addCardToHand(new Card(3, 1));
		p.addCardToHand(new Card(3, 3));
		p.addCardToHand(new Card(5, 2));
		p.addCardToHand(new Card(5, 3));
		assertTrue(p.getCardsInHand().size() == 4);
		p.play(field);
		assertTrue(p.getCardsInHand().size() == 3);
		assertTrue(field.getTopPile() != null);
	}

}
