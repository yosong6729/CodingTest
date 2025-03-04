import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] dp = new int[n + 1];
		int mod = 15746;
		
		if(n == 1) {
			dp[1] = 1; 
		}else if(n == 2) {
			dp[2] = 2;
		}else {
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
			}
		}
		
		System.out.print(dp[n] % mod);
	}
}