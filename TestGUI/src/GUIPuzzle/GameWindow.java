package GUIPuzzle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel currentScreen;
	
	public GameWindow() {
		super("Star King");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		currentScreen = new MainScreen();
		getContentPane().add(currentScreen);
		pack();
		setVisible(true);
		currentScreen.requestFocus();
	}
	
	public void switchScreen(JPanel screen){
		getContentPane().remove(currentScreen);
		this.currentScreen = screen;
		getContentPane().add(currentScreen);
		getContentPane().validate();
		pack();
		currentScreen.requestFocus();
	}
}
