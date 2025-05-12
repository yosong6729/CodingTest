import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			Point[] arr = new Point[4];
			for(int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[j] = new Point(x, y);
			}
			
			HashSet<Double> set = new HashSet<>();
			
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					if(j == k) {
						continue;
					}
					
					Point a = arr[j];
					Point b = arr[k];
					
					double len = Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
					
					set.add(len);
				}
			}
			
			if(set.size() == 2) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
