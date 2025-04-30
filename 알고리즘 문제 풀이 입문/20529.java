import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if(n > 32) {
				sb.append(0).append("\n");
				continue;
			}
			
			String[] s = new String[n];
			
			for(int j = 0; j < n; j++) {
				s[j] = st.nextToken();
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int j = 0; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					for(int l = k + 1; l < n; l++) {
						int sum = 0;
						for(int q = 0; q < 4; q++) {
							
							if(s[j].charAt(q) != s[k].charAt(q)) {
								sum++;
							}
							
							if(s[k].charAt(q) != s[l].charAt(q)) {
								sum++;
							}
							
							if(s[j].charAt(q) != s[l].charAt(q)) {
								sum++;
							}
						}
						min = Math.min(min,  sum);
						
					}
				}
			}
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
}