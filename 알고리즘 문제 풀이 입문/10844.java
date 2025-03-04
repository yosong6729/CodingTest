import java.util.*;
import java.io.*;


class Main {


	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		long mod = 1000000000;
		
		long[][] dp = new long[n + 1][11];
		
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][1] % mod;
				}else if(j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
				}else {
					dp[i][j] = (dp[i - 1][j - 1] % mod + dp[i - 1][j + 1] % mod) % mod;
				}
			}
		}
		
		long result = 0;
		for(int i = 1; i <= 9; i++) {
			result += dp[n][i] % mod;
		}
		
		System.out.print(result % mod);
	}
}