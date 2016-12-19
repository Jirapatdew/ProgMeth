/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 13 Nov 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */

import javax.swing.JFrame;

public class Main {

	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Button Smasher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameLogic gameLogic = new GameLogic(); 
		GameScreen gameScreen = new GameScreen(gameLogic);
		frame.add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		while(true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			
			gameScreen.repaint();
			if(InputUtility.isSpaceTriggered()) {
				gameLogic.hitButton();
				InputUtility.setSpaceTriggered(false);
			}
			gameLogic.update();
		}
	}
}
