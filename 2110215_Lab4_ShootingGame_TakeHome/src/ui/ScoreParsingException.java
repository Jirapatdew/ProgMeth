/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */
package ui;

public class ScoreParsingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorType;
	
	public ScoreParsingException(int errorType){
		this.errorType = errorType;
	}
	
	@Override
	public String getMessage(){
		if(errorType == 0) return "No record score";
		if(errorType == 1) return "Wrong record format";
		return null;
	}
}
