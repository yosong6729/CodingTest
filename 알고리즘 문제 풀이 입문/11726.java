import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] dp = new int[n + 1];
		
		if(n == 1) {
			dp[1] = 1;
		}else if(n == 2) {
			dp[2] = 2;
		}else {
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i < n + 1; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
		}
		
		System.out.print(dp[n]);
	}
}