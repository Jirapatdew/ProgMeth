package exception;

public class TestStringTooLong {
	public static void test(String string,int num) throws StringTooLongException {
		//Range --> [lower,upper]
		if(string.length() > num) {
			throw new StringTooLongException("Error!\nExceeds string length (at most " + num + " characters)");
		}
	}
}
