import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int mod = 10007;
		
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j - 1] % mod + dp[i - 1][j] % mod;
			}
		}
		
		System.out.print(dp[n][k] % mod);
	}
}