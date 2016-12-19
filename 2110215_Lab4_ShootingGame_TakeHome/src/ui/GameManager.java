/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */

package ui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lib.ConfigurableOption;
import lib.GameloopUtility;
import lib.IGameLogic;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.MainLogic;


public class GameManager {
	
	private static GameTitle titleScene;
	private static GameScreen gameScreen;
	private static GameWindow gameWindow;
	
	public static void runGame(IGameLogic gameLogic){
		titleScene = new GameTitle();
		
		if(gameLogic instanceof IRenderableHolder){
			gameScreen = new GameScreen((IRenderableHolder)gameLogic);
		}else{
			gameScreen = new GameScreen(new IRenderableHolder() {
				private List<IRenderableObject> emptyList = new ArrayList<IRenderableObject>(0);
				@Override
				public List<IRenderableObject> getSortedRenderableObject() {
					return emptyList;
				}
			});
		}
		
		gameWindow = new GameWindow(titleScene);
		
		GameloopUtility.runGameLoop(gameLogic, gameWindow, titleScene, gameScreen);
	}
	
	public static void goToTitle(){
		GameloopUtility.goToTitle();
	}
	
	public static void newGame(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("log.txt"));
			String str = "";
			str += "Width = "+ConfigurableOption.screenWidth+"\n";
			str += "Hight = "+ConfigurableOption.screenHeight+"\n";
			str += "Creation min delay = "+ConfigurableOption.objectCreationMinDelay+"\n";
			str += "Creation max delay = "+ConfigurableOption.objectCreationMaxDelay+"\n";
			str += "Object min duration = "+ConfigurableOption.objectMinDuration+"\n";
			str += "Object max duration = "+ConfigurableOption.objectMaxDuration+"\n";
			str += "Time Limit (sec) = "+ConfigurableOption.timelimit+"\n";
			out.write(str);
			out.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error saving ConfigurableOption variable to log file", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		GameloopUtility.newGame();
	}
	
	public static void resizeScreen(){
		gameScreen.applyResize();
		gameWindow.setSize(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		titleScene.validate();
	}
}
