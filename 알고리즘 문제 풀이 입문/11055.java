import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int result = dp[0];
		if(n > 1) {
			for(int i = 1; i < n; i++) {
				dp[i] = arr[i];
				for(int j = i - 1; j >= 0; j--) {
					if(arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + arr[i]);
					}
				}
				result = Math.max(result, dp[i]);
			}
			
		}
		
		System.out.print(result);
	}
}