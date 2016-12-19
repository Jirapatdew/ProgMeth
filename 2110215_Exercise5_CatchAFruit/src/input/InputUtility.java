package input;

public class InputUtility {
	private static boolean[] keyPressed = new boolean[256];

	public InputUtility() {
	}

	public static boolean getKeyPressed(int idx) {
		return keyPressed[idx];
	}

	public static void setKeyPressed(int idx, boolean b) {
		InputUtility.keyPressed[idx] = b;
	}
	
	
}
