import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		int mod = 1000000000;
		dp[0] = 1;
		
		
		for(int coin = 1; coin <= n; coin <<= 1) {
			for(int j = coin; j <= n; j++) {
				dp[j] += (dp[j - coin] % mod);
			}
		}
		
		System.out.print(dp[n] % mod);
	}

}
