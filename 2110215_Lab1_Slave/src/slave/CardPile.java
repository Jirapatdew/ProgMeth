package slave;

public class CardPile {
	//It represents a set of cards (single, double, triple, quadruple cards)
	//that can be placed down in the field.
	
	private Card[] cards;

	public CardPile(Card[] cards) {
		this.cards = cards;
	}
	public Card[] getCards() {
		return cards;
	}
	public Card getBiggestCardInThisPile() {
		Card maxCard = this.cards[0];
		for(int i = 1; i < this.cards.length; i++ ) {
			if(this.cards[i].isBiggerThan(maxCard)) {
				maxCard = this.cards[i];
			}
		}
		return maxCard;
	}
	public boolean canBePlacedOnTopOf(CardPile otherPile) {
		/* ------- Important ------- */
		if(otherPile.getCards().length == 1) {
			if(this.cards.length == 1) {
				if(this.getBiggestCardInThisPile().isBiggerThan(otherPile.getBiggestCardInThisPile()))
					return true;
				else return false;
			}
			else if(this.cards.length == 3) return true;
			return false;
		}
		else if(otherPile.getCards().length == 2) {
			if(this.cards.length == 2) {
				if(this.getBiggestCardInThisPile().isBiggerThan(otherPile.getBiggestCardInThisPile()))
					return true;
				else return false;
			}
			else if(this.cards.length == 4) return true;
			return false;
		}
		else if(otherPile.getCards().length == 3) {
			if(this.cards.length == 3) {
				if(this.getBiggestCardInThisPile().isBiggerThan(otherPile.getBiggestCardInThisPile()))
					return true;
				else return false;
			}
			return false;
		}
		else if(otherPile.getCards().length == 4) {
			if(this.cards.length == 4) {
				if(this.getBiggestCardInThisPile().isBiggerThan(otherPile.getBiggestCardInThisPile()))
					return true;
				else return false;
			}
			return false;
		}
		return false;
	}
	public String toString() {
		String out = "[";
		for(int i = 0; i < cards.length; i++ ) {
			out += cards[i].toString();
			if(i != cards.length-1) out += ", ";
		}
		out += "]";
		return out;
	}
}
