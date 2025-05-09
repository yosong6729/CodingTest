import java.util.*;
import java.io.*;

class Point{
	int color;
	long x;
	
	Point(long x, int color){
		this.color = color;
		this.x = x;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			list.add(new Point(x, color));
		}
		
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				if(a.color == b.color) {
					return Long.compare(a.x, b.x);
				}
				
				return a.color - b.color;
			}
		});
		
		long result = 0;
		
		if(list.size() > 1 && list.get(0).color == list.get(1).color) {
			result += list.get(1).x - list.get(0).x;
		}
		
		for(int i = 1; i < list.size() - 1; i++) {
			Point a = list.get(i - 1);
			Point b = list.get(i);
			Point c = list.get(i + 1);
			
			long min = Integer.MAX_VALUE;
			
			if(a.color == b.color) {
				min = Math.min(min,  b.x - a.x);
			}
			
			if(b.color == c.color) {
				min = Math.min(min, c.x - b.x);
			}
			if(min != Integer.MAX_VALUE) {
				result += min;
			}
			
		}
		
		if(list.get(list.size() - 1).color == list.get(list.size() - 2).color) {
			result += list.get(list.size() - 1).x - list.get(list.size() - 2).x;
		}
		
		System.out.print(result);
		
	}
}
