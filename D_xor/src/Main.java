import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int i =1;i<=T;i++){
		
		BigInteger input = sc.nextBigInteger();
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		BigInteger MM,MM2;
		MM = new BigInteger("1000000006");
		MM2 = new BigInteger("1000000007");
		
		BigInteger r = input.mod(MM);
		r = three.modPow(r, MM2);
		BigInteger k = r.add(one);
		System.out.printf("Case %d: ",i);
		if((k.mod(two)).compareTo(zero)==0) {
			System.out.println(k.divide(two));
		}
		else {
			System.out.println((k.add(MM2)).divide(two));
		}}
	}
	
}
