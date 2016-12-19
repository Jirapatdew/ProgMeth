package entity;

import java.util.Random;

public class RandomUtility {

	public RandomUtility() {

	}
	public static int random(int Low, int High) {
		Random r = new Random();
		return r.nextInt(High-Low+1) + Low;
	}
}
