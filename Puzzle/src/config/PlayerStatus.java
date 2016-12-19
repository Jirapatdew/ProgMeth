package config;

public class PlayerStatus {
	public static boolean enableSound = true;
	public static boolean CheatMode = false;
	public static int level;
	public static int heart;
	public static int score;
	public static int collectedStarThisMap;
	public static int newScore;
	
	public synchronized static void reset(){
		level = 1;
		heart = 5;
		score = 0;
		collectedStarThisMap = 0;
		newScore = 0;
	}

	public synchronized static void increaseScore(int val, int mode) {
		score += val;
		
		if(mode == 1) { //default
			newScore += val;
			collectedStarThisMap++;
		}
		else if(mode == 2){//Refresh Map
			newScore = 0;
			collectedStarThisMap = 0;
		}
		else if(mode == 3){//CheatMode Set Score
			newScore = 0;
		} 
	}
	
	public synchronized static void increaseheart(int val) {
		heart += val;
	}
	
	public static void updateLevel(){
		level++;
	}

	public static void enterNewMap() {
		// TODO Auto-generated method stub
		collectedStarThisMap=0;
		newScore = 0;
	}
}
