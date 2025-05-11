import java.util.*;
import java.io.*;

class D{
	int a;
	int b;
	
	D(int a, int b){
		this.a = a;
		this.b = b;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		D[] dp = new D[d + 1];
		dp[1] = new D(1, 0);
		dp[2] = new D(0, 1);
		
		for(int i = 3; i <= d; i++) {
			dp[i] = new D(dp[i - 1].a + dp[i - 2].a, dp[i - 1].b + dp[i - 2].b);
		}
		
		int a = dp[d].a;
		int b = dp[d].b;
		
		int total = 0;
		for(int i = 1; a * i + b <= k; i++) {
			for(int j = 1; total <= k; j++) {
				total = a * i + b * j;
				if(total == k) {
					System.out.println(i);
					System.out.print(j);
					return;
				}
			}
			total = 0;
		}
		
	}
}
