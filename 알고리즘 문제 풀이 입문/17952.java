import java.util.*;
import java.io.*;

class Point{
	int score;
	int minutes;
	
	Point(int score, int minutes){
		this.score = score;
		this.minutes = minutes;
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		int result = 0;
		
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) {
				if(list.size() >= 1) {
					Point p = list.get(list.size() - 1);
					p.minutes--;
					if(p.minutes == 0) {
						result += p.score;
						list.remove(list.size() - 1);
					}
				}
				continue;
				
			}
			int score = Integer.parseInt(st.nextToken());
			int minutes = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				list.add(new Point(score, minutes));
				Point p = list.get(list.size() - 1);
				p.minutes--;
				if(p.minutes == 0) {
					result += p.score;
					list.remove(list.size() - 1);
				}
			}
		}
		
		System.out.print(result);
	}
}