package slave;

public class Card {
	
	private int rank;
	private int suit;
	
	public Card(int rank, int suit) {
		if(1 <= rank && rank <= 13) this.rank = rank;
		else this.rank = 1;
		if(1 <= suit && suit <= 4) this.suit = suit;
		else this.suit = 1;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		if(1 <= rank && rank <= 13) this.rank = rank;
		else this.rank = 1;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		if(1 <= suit && suit <= 4) this.suit = suit;
		else this.suit = 1;
	}
	public boolean isBiggerThan(Card card) {
		int[] val = {12,13,1,2,3,4,5,6,7,8,9,10,11};
		if(val[this.rank-1] > val[card.getRank()-1]) return true;
		else if(val[this.rank-1] == val[card.getRank()-1] && this.suit > card.getSuit()) return true;
		else return false;
	}
	public String toString() {
		String[] suit = {"Club","Diamond","Heart","Spade"};
		String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		return suit[this.suit-1] + " " + rank[this.rank-1];
	}

}
