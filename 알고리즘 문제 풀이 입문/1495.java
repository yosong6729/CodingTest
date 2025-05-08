import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[] p = new boolean[m + 1];
		p[s] = true;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			boolean[] next = new boolean[m + 1];
			for(int j = 0; j <= m; j++){
				if(!p[j]) {
					continue;
				}
				
				if(j + v <= m) {
					next[j + v] = true;
				}
				
				if(j - v >= 0) {
					next[j - v] = true;
				}
			}
			p = next;
		}
		
		int result = -1;
		for(int i = 0; i <= m; i++) {
			if(p[i]) {
				result = Math.max(result, i);
			}
		}
		
		System.out.print(result);
	}
}
