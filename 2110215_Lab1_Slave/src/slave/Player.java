package slave;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private boolean pass = false;
	private ArrayList<Card> cardsInHand = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	public ArrayList<Card> getCardsInHand() {
		return cardsInHand;
	}
	
	public void addCardToHand(Card card) {
		cardsInHand.add(card);
	}
	public void play(Field field) {
		/* ------- Important ------- */
		this.setPass(true);
		if(win()) {
			System.out.println(this.name + " passes with empty hand");
			return;
		}
		ArrayList<CardPile> possibleCardPile = Utility.generatePossibleCardPile(cardsInHand);
		for(int i = possibleCardPile.size()-1; 0 <= i; i--) {
			if(field.getTopPile() == null || 
					possibleCardPile.get(i).canBePlacedOnTopOf(field.getTopPile())) {
				field.setTopPile(possibleCardPile.get(i));
				this.setPass(false);
				System.out.println(this.name + " plays " + possibleCardPile.get(i).toString());
				
				Card[] deleteCard = possibleCardPile.get(i).getCards();
				for(int j = 0; j < deleteCard.length; j++){
					for(int k = 0; k < cardsInHand.size(); k++) {
						if(deleteCard[j].getRank() == cardsInHand.get(k).getRank() && 
								deleteCard[j].getSuit() == cardsInHand.get(k).getSuit()) {
							cardsInHand.remove(k);
							break;
						}
					}
				}
				return;
			}
		}
		System.out.println(this.name + " passes");
		return;
	}
	public boolean win() {
		if(cardsInHand.size() == 0) return true;
		return false;
	}
	
}
