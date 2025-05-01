import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double len = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			
			if(len == 0 && r1 == r2) {
				sb.append(-1).append("\n");
				continue;
			}
			if(len > Math.max(r1,  r2)) {
				
				if(len > (r1 + r2)) {
					sb.append(0).append("\n");
					continue;
				}else if(len == (r1 + r2)) {
					sb.append(1).append("\n");
					continue;
				}else {
					sb.append(2).append("\n");
					continue;
				}
			}else if(len < Math.max(r1,  r2)) {
				if((len + Math.min(r1,  r2)) < Math.max(r1,  r2)) {
					sb.append(0).append("\n");
					continue;
				}else if((len + Math.min(r1,  r2)) > Math.max(r1, r2)) {
					sb.append(2).append("\n");
					continue;
				}else {
					sb.append(1).append("\n");
					continue;
				}
			}else {
				sb.append(2).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}