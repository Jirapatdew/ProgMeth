import javax.swing.JComponent;
import javax.swing.JFrame;

import entity.GameLogic;
import render.GameScreen;

public class Main {

	public Main() {
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Catch a fruit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		GameScreen gameScreen = new GameScreen();
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
			GameLogic.getInstance().logicUpdate();
		}
	}
}

