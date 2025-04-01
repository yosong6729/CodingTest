import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int mod = 9901;
		long dp[][] = new long[n][3];
		
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		
		if(n > 1){
			for(int i = 1; i < n; i++) {
				dp[i][0] += dp[i - 1][0] % mod + dp[i - 1][1] % mod + dp[i- 1][2] % mod;
				dp[i][1] += dp[i - 1][0] % mod + dp[i - 1][2] % mod;
				dp[i][2] += dp[i - 1][0] % mod + dp[i - 1][1] % mod;
			}
		}
		long result = 0;
		
		result += (dp[n - 1][0]  + dp[n - 1][1] + dp[n - 1][2]) % mod;
		
		System.out.print(result);
	}
}