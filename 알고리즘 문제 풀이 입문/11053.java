import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int[] dp = new int[n];
		dp[0] = 1;
		int max = Integer.MIN_VALUE;
		
		
		for(int i = 1; i < n; i++) {
			max = Integer.MIN_VALUE;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i] && dp[j] != 0) { 
					max = Math.max(dp[j] + 1, max);
				}
			}
			if(max != Integer.MIN_VALUE) {
				dp[i] = max;
			}else {
				dp[i] = 1;
			}
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int x : dp) {
			answer = Math.max(answer, x);
		}
		
		System.out.print(answer);
	}
}