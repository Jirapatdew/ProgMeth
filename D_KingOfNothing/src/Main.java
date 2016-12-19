import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n;
			n = sc.nextInt();
			BigInteger K = sc.nextBigInteger();
			BigInteger A = new BigInteger("1");
			BigInteger B = new BigInteger("1");
			B = K.pow(n);
			for(int i=0;i<n;i++){
				BigInteger X = sc.nextBigInteger();
				A = A.multiply(K.subtract(X));
			}
			BigInteger GCD = A.gcd(B);
			A = A.divide(GCD);
			B = B.divide(GCD);
			if(A.compareTo(new BigInteger("0")) == 0) {
				System.out.printf("Case %d: 0\n",t);
			}
			else if(A.compareTo(new BigInteger("1")) == 0&&B.compareTo(new BigInteger("1"))==0) {
				System.out.printf("Case %d: 1\n",t);
			}
			else System.out.printf("Case %d: %s/%s\n",t,A.mod(new BigInteger("1000000007")),B.mod(new BigInteger("1000000007")));
		}
	}
}
