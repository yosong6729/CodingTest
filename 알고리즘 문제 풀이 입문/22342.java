import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[m][n];
		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		for(int i = 0; i < m; i++) {
			dp[i][0] = arr[i][0];
		}
		
		
		
		for(int j = 1; j < n; j++) {
			for(int i = 0; i < m; i++) {
				int max = Integer.MIN_VALUE;
				if(i - 1 >= 0) {
					max = Math.max(max, dp[i - 1][j - 1]);
				}
				
				max = Math.max(max, dp[i][j - 1]);
				
				if(i + 1 < m) {
					max = Math.max(max, dp[i + 1][j - 1]);
				}
				
				result = Math.max(max, result);
				dp[i][j] = max + arr[i][j];
			}
		}
		
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.print(result);
	}

}
