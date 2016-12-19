package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;
import exception.NotAllowedSubstringException;
import exception.ScoreParsingException;
import exception.StringTooLongException;
import exception.TestNotAllowedSubstring;
import exception.TestStringTooLong;
import main.Main;
import ui.StatScreen;


public class HighScoreUtility {
	
	public static class HighScoreRecord implements Comparable<HighScoreRecord>{
		
		private String name = "";
		private int score = 0;
		
		public HighScoreRecord(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		/* 
		 * Parse the given string "record"
		 * record format is name:score
		 */
		public HighScoreRecord(String record) throws ScoreParsingException{
			int colon = record.indexOf(":");
			if(colon == -1) throw new ScoreParsingException(1);
			else {
				try {
					this.name = record.substring(0, colon);
					this.score = Integer.parseInt(record.substring(colon+1, record.length()));
				}
				catch(NumberFormatException e1){
					throw new ScoreParsingException(0);
				}
			}
			
		}
		
		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		private String getRecord(){
			return name.trim()+":"+score;
		}
		
		private static String[] defaultRecord(){
			return new String[]{"Oliver:200","Jack:100","Noah:50",
					"Jacob:40","Charlie:30","Harry:20",
					"Oscar:10"};
		}

		@Override
		public int compareTo(HighScoreRecord o) {
			if(this.score > o.score) return -1;
			return 1;
		}
	}
	
	private static HighScoreRecord[] highScoreRecord = null; // index 0 to 6
	private static String readFileName = "highscore";
	private static final int numLength = 7;
	/*
	 * Display player's score and record if the player rank is 7 or higher.
	 */
	public static void recordHighScore(int score){
		if(!loadHighScore() || highScoreRecord == null){
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int index=highScoreRecord.length;
		for(int i=0; i<highScoreRecord.length; i++){
			if(score > highScoreRecord[i].score){
				index = i;
				break;
			}
		}
		if(index >= highScoreRecord.length){
			JOptionPane.showMessageDialog(Main.gameWindow, "Game over\n" + "Your score is " + score, "Game over", JOptionPane.INFORMATION_MESSAGE);
		}else{
			for(int i=highScoreRecord.length-1; i>=index+1; i--){
				highScoreRecord[i] = highScoreRecord[i-1];
			}
					
			/*--------------------------------------------------*/
			String name;
			String msg = "Congratulation, you are ranked " + (index + 1) + "\nPlease enter your name\n(at most 10 characters, not allowed \":\")";
			boolean isGetInput = false;
			int messageType = JOptionPane.QUESTION_MESSAGE;
			
			do {
				name = JOptionPane.showInputDialog(Main.gameWindow, msg, "High Score",messageType);	
				messageType = JOptionPane.ERROR_MESSAGE;
				
				if(name == null) return; // Click Cancel
				
				isGetInput = true;
				
				try {
					TestNotAllowedSubstring.test(name,":");
					TestStringTooLong.test(name,10);
				} catch (NotAllowedSubstringException e) {
					msg = e.getMessage();
					isGetInput = false;
				}catch (StringTooLongException e) {
					msg = e.getMessage();
					isGetInput = false;
				}
			}while(!isGetInput);
			
			/*--------------------------------------------------*/
			
			highScoreRecord[index] = new HighScoreRecord(name, score);
			try {
				
				BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
				String str = "";
				for(int i=0; i<highScoreRecord.length; i++) {
					str += highScoreRecord[i].getRecord() + "\n";
				}
				str = str.trim();
				out.write(getXORed(str));
				out.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error saving high score record", 
						"Error", JOptionPane.ERROR_MESSAGE);
				highScoreRecord = null;
				return;
			}
		}
	}
	
	public static void displayTopScore(){
		if(!loadHighScore() || highScoreRecord == null){
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Main.gameWindow.switchScreen(new StatScreen(highScoreRecord));
	}
	
	private static boolean loadHighScore(){
		File f = new File(readFileName);
		//If no high score, create default
		if(!f.exists()){
			if(!createDefaultScoreFile()) return false;
		}
		//Read high score -- if fail: delete the file, create default one and read it again 
		if(!readAndParseScoreFile(f)){
			f.delete();
			if(!createDefaultScoreFile()) return false;
			return readAndParseScoreFile(f);
		}
		return true;
		
	}
	
	private static boolean readAndParseScoreFile(File f){
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			highScoreRecord = new HighScoreRecord[numLength];
			String str = "";
			int c;
			while((c = in.read()) != -1){
				str += (char)c;
			}
			in.close();
			String[] records = getXORed(str).split("\n");
			for(int i=0; i<highScoreRecord.length; i++){
				try{
					highScoreRecord[i] = new HighScoreRecord(records[i]);
				}catch(ScoreParsingException e){
					System.err.println("Error parsing line "+(i+1)+", "+e.getMessage());
					System.err.println("records[i] -> " + records[i]);
					highScoreRecord[i] = new HighScoreRecord("ERROR_RECORD", 0);
				}
			}
			Arrays.sort(highScoreRecord);
			return true;
		} catch (Exception e) {
			highScoreRecord = null;
		}
		return false;
	}
	
	private static boolean createDefaultScoreFile(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for(String s : HighScoreRecord.defaultRecord()){
				str += s+"\n";
			}
			str = str.trim();
			out.write(getXORed(str));
			out.close();
			return true;
		} catch (IOException e1) {
			highScoreRecord = null;
			return false;
		}
	}
	
	private static final byte[] key = "qAiTtznMmcV9KXWtT7hJmC7DruAZD0d6".getBytes();
	
	//This method does both encryption and decryption 
	private static String getXORed(String in){
		byte[] inData = in.getBytes();
		for(int i = 0; i < inData.length; i++) {
			inData[i]^=key[i%key.length];
		}
		return new String(inData);
	}

	public static void setReadFileName(String name){
		readFileName = name;
	}	
}

