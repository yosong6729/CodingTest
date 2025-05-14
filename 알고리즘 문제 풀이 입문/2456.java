import java.util.*;
import java.io.*;

public class Main {
	
	public static int distance(int d, int dis, int w, int h) {
		
		switch(d) {
		case 1:
			return dis;
		case 4:
			return w + dis;
		case 2:
			return 2 * w + h - dis;
		case 3:
			return 2 * w + 2 * h - dis;
		}
		
		return 0;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		int[] stored = new int[num];
		
		for(int i = 0; i < num; i++) {
					
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			stored[i] = distance(d, dis, w, h);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int dis = Integer.parseInt(st.nextToken());
		int baseDis = distance(d, dis, w, h);
		
		int total = 0;
		
		for(int x : stored) {
			total += Math.min(Math.abs(baseDis - x), 
					2 * w + 2 * h - Math.abs(baseDis - x));
		}
		
		System.out.print(total);
	}
}
