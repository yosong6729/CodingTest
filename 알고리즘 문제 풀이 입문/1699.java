import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int maxSqr = 0;
		int a = 0;
		
		while(a < n) {
			maxSqr++;
			a = (int)Math.pow(maxSqr, 2);
		}
		if(a != n) {
			maxSqr--;
		}
		
		int[] dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j <= maxSqr; j++) {
				if(i - j * j >= 0) {
					min = Math.min(min, dp[i - j * j] + 1);
					
				}
			}
			dp[i] = min;
		}
		
		System.out.print(dp[n]);
	}
}