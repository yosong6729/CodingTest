import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int minSize = Integer.MAX_VALUE;
		
		long A = 0;
		long B = 0;
		
		for(int i = l; i <= 100; i++) {
			
			long mid = n / i;
			
			long total = 0;
			
			long a = 0;
			long b = 0;
			
			if(i % 2 == 0) {
				a = mid - (i / 2 - 1);
				b = mid + i / 2;
			}else {
				a = mid - i / 2;
				b = mid + i / 2;
			}
			
			if(a < 0 || b < 0) {
				continue;
			}
			
			total = (b * (b + 1) / 2) - ((a - 1) * a / 2);
			if(total == n) {
				if(minSize > i) {
					A = a;
					B = b;
					minSize = i;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(minSize == Integer.MAX_VALUE) {
			System.out.print(-1);
		}else {
			for(long i = A; i <= B; i++) {
				sb.append(i).append(" ");
			}
			System.out.print(sb);
		}
	}
}
