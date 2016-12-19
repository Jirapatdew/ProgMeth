package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import config.PlayerStatus;
import render.Resource;

public class GameWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel currentScene;
	
	public GameWindow() {
		super("Star King");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		currentScene = new MainScreen();
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
		
		if(PlayerStatus.enableSound) Resource.s_back.loop();
	}
	
	public void switchScreen(JPanel screen){
		getContentPane().remove(currentScene);
		this.currentScene = screen;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		currentScene.requestFocus();
	}
	
}
