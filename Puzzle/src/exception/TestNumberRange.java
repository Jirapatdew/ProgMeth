package exception;

public class TestNumberRange {

	public static void test(int num, int lower, int upper) throws NumberOutOfRangeException {
		// Range --> [lower,upper]
		if (num < lower || num > upper) {
			throw new NumberOutOfRangeException("Error!\nPlease enter number between " + lower + " to " + upper);
		}
	}
}
