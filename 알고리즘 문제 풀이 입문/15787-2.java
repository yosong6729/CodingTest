import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		
		int[] train = new int[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = 0;
			int c = 0;
			switch(a) {
			case 1:
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				train[b] |= 1 << c; 
				break;
			case 2:
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				train[b] &= ~(1 << c);
				break;
			case 3:
				b = Integer.parseInt(st.nextToken());
				train[b] = train[b] << 1 & ((1 << 21) - 1);
				break;
			case 4:
				b = Integer.parseInt(st.nextToken());
				train[b] = train[b] >>> 1;
				train[b] &= ~(1 << 0);
				break;
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			set.add(train[i]);
		}
		
		System.out.print(set.size());
	}
}