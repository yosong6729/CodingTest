import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = kb.nextInt();
		}
		
		if(n == 1) {
			dp[1] = arr[1];
		}else if(n == 2) {
			dp[2] = arr[1] + arr[2];
		}else {
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			dp[3] = Math.max(dp[1], arr[2]) + arr[3];
			for(int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
			}
		}
		
		System.out.print(dp[n]);
	}
}