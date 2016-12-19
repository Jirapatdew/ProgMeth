
public class Main {
	public static void main(String[] args) {
		int x=10,y=50,z=0;
		
		try {
			System.out.println(x+y);
			System.out.println(x-y);
			System.out.println((double)x/y);
			System.out.println(x/1);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Arithmetic Exception ----- (^__^)");
			return;
		} finally {
			System.out.println("5555 finally."); //run always
		}
		
	}
}
