import java.util.*;


class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int max = arr[0];
		dp[0] = arr[0];
		
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}