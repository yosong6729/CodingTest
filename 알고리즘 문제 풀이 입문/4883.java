import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			
			int[][] dp = new int[n][3];
			int[][] arr = new int[n][3];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dx = {0, -1, -1, -1};
			int[] dy = {-1, -1, 0, 1};
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[0][1];
			dp[0][2] = dp[0][1] + arr[0][2];
			dp[1][0] = dp[0][1] + arr[1][0];
			dp[1][1] = Math.min(dp[1][0], Math.min(dp[0][1], dp[0][2])) + arr[1][1];
			dp[1][2] = Math.min(dp[1][1], Math.min(dp[0][1], dp[0][2])) + arr[1][2];
			
			for(int i = 2; i < n; i++) {
				for(int j = 0; j < 3; j++) {
					int min = Integer.MAX_VALUE;
					for(int k = 0; k < 4; k++) {
						
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < n && ny >= 0 && ny < 3) {
							min = Math.min(min,  dp[nx][ny] + arr[i][j]);
						}
					}
					dp[i][j] = min;
				}
			}
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < 3; j++) {
//					System.out.print(dp[i][j]);
//				}
//				System.out.println();
//			}
			
			sb.append(t + ".").append(" ").append(dp[n - 1][1]).append("\n");
			t++;
		}
		System.out.print(sb);
	}
}
