import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int mod = 1_000_000_007;
		
		long[] dp = new long[n + 1];
		dp[0] = 1;
		
		for(int i = 1; i <= n; i++) {
			
			dp[i] = dp[i - 1];
			
			if(i >= m) {
				dp[i] = ((dp[i - 1] % mod + dp[i - m] % mod) % mod);
			}
		}
		
		System.out.print(dp[n] % mod);
	}
}
