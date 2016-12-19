/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel currentScene;
	
	protected GameWindow(JPanel scene){
		super("Shoot the bullet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
	}
	
	protected void switchScene(JPanel scene){
		getContentPane().remove(currentScene);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		currentScene.requestFocus();
	}
	
	protected JPanel getCurrentScene(){
		return currentScene;
	}
}
