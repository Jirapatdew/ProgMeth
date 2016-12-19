package utility;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import config.PlayerStatus;
import config.configs;
import exception.NumberOutOfRangeException;
import exception.TestNumberRange;
import main.Main;
import ui.GameScreen;

public class CheatUtility implements Runnable {

	private ArrayList<Integer> history;
	private final int[][] CheatCode = { { 78, 69, 88, 84, 76, 69, 86, 69, 76 }, // NEXTLEVEL
			{ 65, 68, 68, 83, 67, 79, 82, 69 }, // ADDSCORE
			{ 65, 68, 68, 72, 69, 65, 82, 84 }, // ADDHEART
			{ 71, 79, 84, 79, 76, 69, 86, 69, 76 }, // GOTOLEVEL
			{ 83, 69, 84, 83, 67, 79, 82, 69 } }; // SETSCORE
	
	
	public CheatUtility(ArrayList<Integer> history) {
		super();
		this.history = history;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		System.out.println("Check Cheat---");
		if(history == null) return;
		if(checkCode(CheatCode[0])){
//			System.out.println("NEXTLEVEL");
			
			GameScreen.goToNextMap();
		}
		else if(checkCode(CheatCode[1])){
//			System.out.println("ADDSCORE");
			
			PlayerStatus.increaseScore(50, 0);
		}
		else if(checkCode(CheatCode[2])){
//			System.out.println("ADDHEART");
			
			PlayerStatus.increaseheart(5-PlayerStatus.heart);
		}
		else if(checkCode(CheatCode[3])){
//			System.out.println("GOTOLEVEL");
			
			String msg = "Please select level (1 - " + configs.AllMap + ")";
			int level=0;
			boolean isGetInput = false;
			int messageType = JOptionPane.QUESTION_MESSAGE;
			
			do {
				String input = JOptionPane.showInputDialog(Main.gameWindow, msg, "Go To Level",messageType);	
				messageType = JOptionPane.ERROR_MESSAGE;
				
				if(input == null) return; // Click Cancel
				
				isGetInput = true;
				try {
					level = Integer.parseInt(input);
					TestNumberRange.test(level,1,configs.AllMap);
				}
				catch (NumberFormatException e) {
					msg = "Wrong Number format\nPlease enter number again (1 - " + configs.AllMap + ")";
					isGetInput = false;
				}
				catch (NumberOutOfRangeException e) {
					msg = e.getMessage();
					isGetInput = false;
				}
			}while(!isGetInput);
			
			PlayerStatus.level = level-1;
			GameScreen.goToNextMap();
		}
		else if(checkCode(CheatCode[4])){
//			System.out.println("SETSCORE");
			
			String msg = "Please enter score (0 - 9999999)";
			int score=0;
			boolean isGetInput = false;
			int messageType = JOptionPane.QUESTION_MESSAGE;
			
			do {
				String input = JOptionPane.showInputDialog(Main.gameWindow, msg, "Set Score",messageType );	
				messageType = JOptionPane.ERROR_MESSAGE;
				
				if(input == null) return; // Click Cancel
				
				isGetInput = true;
				try {
					score = Integer.parseInt(input);
					TestNumberRange.test(score,0,9999999);
				}
				catch (NumberFormatException e) {
					msg = "Wrong Number format\nPlease enter number again (0 - 9999999)";
					isGetInput = false;
				}
				catch (NumberOutOfRangeException e) {
					msg = e.getMessage();
					isGetInput = false;
				}
			}while(!isGetInput);
			
			PlayerStatus.increaseScore(score - PlayerStatus.score, 3);

		}
	}

	private boolean checkCode(int[] code) {
		
		if(history.size()<code.length) return false;
		for(int i = 1; i <= code.length; i++) {
			if (history.get(history.size()-i).intValue() != code[code.length - i]) {
				return false;
			}
		}

//		System.out.print("Run CheatCode : ");
		return true;


	}
	
}
