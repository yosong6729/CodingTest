import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
			
		long[][] dp = new long[10][n];
		if(n == 1) {
			for(int i = 0; i < 10; i++) {
				dp[i][0] = 1;
			}
		}else {
			for(int i = 0; i < 10; i++) {
				dp[i][0] = 1;
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < 10; j++) {
					for(int k = j; k < 10; k++) {
						dp[j][i] += dp[k][i - 1] % 10007;
					}
				}
			}
		}
		
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += dp[i][n - 1] % 10007;
		}
		System.out.print(result % 10007);
	}
}