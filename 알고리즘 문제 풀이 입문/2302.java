import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 1];
		int[] arr = new int[m];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 1;
		int prev = 0;
		for(int x : arr) {
			result *= dp[x - prev - 1];
			prev = x;
		}
		
		if(m != 0) {
			result *= dp[n - arr[m - 1]];
			System.out.print(result);
		}else {
			System.out.print(dp[n]);
		}
	}
}