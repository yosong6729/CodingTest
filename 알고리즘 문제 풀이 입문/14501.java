import java.util.*;
import java.io.*;

class Schedule{
	int t;
	int p;
	Schedule(int t, int p){
		this.t = t;
		this.p = p;
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Schedule[] sc = new Schedule[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			sc[i] = new Schedule(t, p);
		}
		
		for(int i = 0; i < n; i++) {
			if(sc[i].t + i > n) {
				continue;
			}
			
			dp[i] = sc[i].p;
			int sum = 0;
			for(int j = i; j >= 0; j--) {
				if(j + sc[j].t - 1 < i) {
					sum = Math.max(sum, dp[i] + dp[j]);
				}
			}
			if(sum != 0) {
				dp[i] = sum;
			}
		}
		int result = 0;
		
		for(int x : dp) {
			result = Math.max(result, x);
		}
		
		System.out.print(result);
	}
}