package slave;

import java.util.ArrayList;
import java.util.Random;

public class Utility {
	
	static Random rand = new Random();
	//[min,max]
	public static int random(int min, int max) {
		return rand.nextInt(max - min) + min;
	}

	public static int random(int min, int max, long seed) {
		rand = new Random(seed);
		return rand.nextInt(max - min) + min;
	}
	public static ArrayList<CardPile> generatePossibleCardPile(ArrayList<Card> cardList) {
		
		ArrayList<CardPile> outListPile = new ArrayList<CardPile>();
		int[][] hashCard = new int[13][4];
		for(int i = 0; i < cardList.size(); i++) {
			hashCard[cardList.get(i).getRank()-1][cardList.get(i).getSuit()-1] = 1;
		}
		
		int[][] patternCard = {{1,1,1,1},
		                       {0,1,1,1},{1,0,1,1},{1,1,0,1},{1,1,1,0},
		                       {0,0,1,1},{0,1,0,1},{1,0,0,1},{0,1,1,0},{1,0,1,0},{1,1,0,0},
		                       {0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0}};
		int[] startAt = {15,11,5,1,0};
		
		
		
		for(int num = 4; num >= 1; num--) {
			for(int r = 14; r > 1; r--) {
				int i = r % 13;
				
				for(int k = startAt[num]; k < startAt[num-1]; k++) {
					Card[] aCard = new Card[num];
					int cnt = 0;
					for(int j = 3; j >= 0; j--) {
						if(patternCard[k][j] == 1) {
							if(hashCard[i][j]==1) {
								aCard[cnt++] = new Card(i+1, j+1);
							}
							else break;
						}
					}
					if(cnt == num) outListPile.add(new CardPile(aCard));
					
				}
			}
		}
		return outListPile;
	}
}
