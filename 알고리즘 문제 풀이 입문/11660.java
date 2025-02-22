import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				arr[i][j] = kb.nextInt();
				dp[i][j] = arr[i][j] + dp[i][j - 1];
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			int x1 = kb.nextInt();
			int y1 = kb.nextInt();
			int x2 = kb.nextInt();
			int y2 = kb.nextInt();
			int sum = 0;
			
			for(int j = x1; j <= x2; j++) {
				sum += dp[j][y2] - dp[j][y1 - 1];
			}
			
			result.add(sum);
		}
		
		for(int x : result) {
			System.out.println(x);
		}
	}
}