import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[r + 1][c + 1];
		int[][] dp = new int[r + 1][c + 1];
		
		for(int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			sum = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
			
			sb.append(sum / ((r2 - r1 + 1) * (c2 - c1 + 1))).append("\n");
		}
		
		System.out.print(sb);
	}
}