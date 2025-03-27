import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n][3];
		int[][] arr = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				int a = arr[i][j] + dp[i - 1][(j + 1) % 3];
				int b = arr[i][j] + dp[i - 1][(j + 2) % 3];
				dp[i][j] = Math.min(a, b);
			}
		}
		
		System.out.print(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
	}
}