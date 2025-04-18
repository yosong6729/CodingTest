import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int mod = 1000000009;
		int[][] dp = new int[1001][1001];
		
		dp[0][0] = 1;
		
		for(int j = 1; j <= 1000; j++) {
			for(int q = 1; q <= 1000; q++) {
				for(int k = 1; k <= 3; k++) {
					if(j - k >= 0){
						dp[j][q] = (dp[j][q] + dp[j - k][q - 1]) % mod;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			
			sb.append(dp[n][m]).append("\n");
		}
		
		System.out.print(sb);
	}
}