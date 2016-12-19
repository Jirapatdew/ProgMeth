/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ui.HighScoreUtility;
import ui.ScoreParsingException;

public class TestHighScoreUtility {

	@Test
	public void testInputHighScore() {
		//this will show MessageDialog that title will show "Congratulation"
		HighScoreUtility.recordHighScore(10000);
		//this will show MessageDialog that title will show "Game over"
		HighScoreUtility.recordHighScore(1);
	}
	
	@Test
	public void testReadfile() {
		//Test Read File Error
		//this will show MessageDialog that title will show "Error" 
		//and have a message "Error loading highscore record"
		HighScoreUtility.setReadFileName("aaa");
		HighScoreUtility.displayTop10();
		//Test Read File
		//This will show top 10 scores
		HighScoreUtility.setReadFileName("highscore");
		HighScoreUtility.displayTop10();
	}
	
	@Test(expected=ScoreParsingException.class)
	public void testNoRecordedScore() throws ScoreParsingException {
		//Test exception "Wrong record format"
		HighScoreUtility.HighScoreRecord b = new HighScoreUtility.HighScoreRecord("nkjio2000");  
	}
	
	@Test(expected=ScoreParsingException.class)
	public void testNoRecordedFormat() throws ScoreParsingException {
		//Test exception "No recorded score"
		HighScoreUtility.HighScoreRecord b = new HighScoreUtility.HighScoreRecord("hh:okj");  
	}
	
}
