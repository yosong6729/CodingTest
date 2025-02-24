import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				arr[i][j] = kb.nextInt();
				if(i == 0 && j == 0) {
					dp[i][j] = arr[i][j];
				}else if(j == 0){
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.print(max);
	}
}