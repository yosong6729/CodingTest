import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int result = 0;
			int[][] dp = new int[3][n];
			
			for(int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					int v = Integer.parseInt(st.nextToken());
					arr[j][k] = v;
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[2][0] = 0;
			
			for(int j = 1 ; j < n; j++) {
				for(int k = 0; k < 3; k++) {
					if(k == 2) {
						dp[k][j] = Math.max(dp[(k + 1) % 3][j - 1], dp[(k + 2) % 3][j - 1]);
					}else{
						dp[k][j] = arr[k][j] + Math.max(dp[(k + 1) % 3][j - 1], dp[(k + 2) % 3][j - 1]); 
					}
					
				}
			}
			
			result += Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1]));
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}