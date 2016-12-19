package slave;

public class Deck {
	
	private int deckCount;
	private Card[] cards = new Card[52];
	
	public Deck() {
		this.deckCount = 0;
		for(int i = 1; i <= 13; i++) {
			for(int j = 1; j <= 4; j++) {
				this.cards[deckCount++] = new Card(i, j);
			}
		}
	}
	public void shuffle() {
		int x,y;
		for(int i = 0; i < 500; i++) {
			x = Utility.random(0, this.deckCount-1);
			y = Utility.random(0, this.deckCount-1);
			Card temp = this.cards[x];
			this.cards[x] = this.cards[y];
			this.cards[y] = temp;
		}
	}
	public Card deal() {
		this.deckCount--;
		return cards[this.deckCount];
	}
	public int getDeckSize() {
		return deckCount;
	}
}
