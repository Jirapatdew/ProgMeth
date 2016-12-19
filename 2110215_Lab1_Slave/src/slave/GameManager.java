package slave;

public class GameManager {
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		deck.shuffle();
		
		Player[] player = new Player[4];
		player[0] = new Player("Alice");
		player[1] = new Player("Bill");
		player[2] = new Player("Cain");
		player[3] = new Player("Doug");
		
		int k = 0;
		while(deck.getDeckSize() > 0) {
			player[k++].addCardToHand(deck.deal());
			k %= player.length;
		}
		
		int countWin = 0;
		int countPass = 0;
		boolean allPlayerWin = false;
		Field field = new Field();
		
		while(!allPlayerWin) {
			for(int i = 0; i < player.length; i++) {
				player[i].play(field);

				if(player[i].win() && !player[i].isPass()) {
					countWin++;
					if(countWin == player.length) {
						allPlayerWin = true;
						System.out.println(player[i].getName() + " is a SLAVE!");
						break;
					}
				}
				
				if(player[i].isPass()) {
					countPass++;
					if(countPass == player.length) {
						countPass = 0;
						field.clearField();
						System.out.println("All players declare \"PASS\"");
						break;
					}
				}
				else countPass = 0;
			}
		}
		
	}
}
