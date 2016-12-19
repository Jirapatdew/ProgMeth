/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 13 Nov 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */

public class InputUtility {
	private static boolean spaceTriggered;
	private static boolean spacePressed;
	public InputUtility() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static boolean isSpaceTriggered() {
		return spaceTriggered;
	}
	public static void setSpaceTriggered(boolean spaceTriggered) {
		InputUtility.spaceTriggered = spaceTriggered;
	}
	public static boolean isSpacePressed() {
		return spacePressed;
	}
	public static void setSpacePressed(boolean spacePressed) {
		InputUtility.spacePressed = spacePressed;
	}	
}