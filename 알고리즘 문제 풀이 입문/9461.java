import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int t = kb.nextInt();
		long[] result = new long[t];
		
		for(int i = 0; i < t; i++) {
			int n = kb.nextInt();
			long[] dp = new long[n + 1];

			
			if(n == 1) {
				dp[1] = 1;
			}else if(n == 2) {
				dp[2] = 1;
			}else{
				dp[1] = 1;
				dp[2] = 1;
				for(int j = 3; j <= n ; j++) {
					dp[j] = dp[j - 2] + dp[j - 3];
				}
			}
			
			result[i] = dp[n];
		}
		
		for(long x : result) {
			System.out.println(x);
		}
	}
}