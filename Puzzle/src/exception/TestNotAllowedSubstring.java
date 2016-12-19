package exception;

public class TestNotAllowedSubstring {
	public static void test(String string, String key) throws NotAllowedSubstringException {
		// Range --> [lower,upper]
		int idx = string.indexOf(key);
		if (idx != -1) {
			throw new NotAllowedSubstringException("Error!\n\"" + key + "\" is not allowed.");
		}
	}
}
