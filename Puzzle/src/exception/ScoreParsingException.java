package exception;

public class ScoreParsingException extends Exception {

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
