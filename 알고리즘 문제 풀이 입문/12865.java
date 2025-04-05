import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] W = new int[n + 1];
		int[] V = new int[n + 1];
		int[] dp = new int[k + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = k; j - W[i] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
				max = Math.max(max, dp[j]);
			}
		}
		
		System.out.print(max);
	}
}