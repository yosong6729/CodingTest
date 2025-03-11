import java.util.*;
import java.io.*;

class Point {
	int idx;
	int x;
	Point(int idx, int x){
		this.idx = idx;
		this. x = x;
	}
	
}

class Main {
	
	static ArrayList<Integer> result = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		Deque<Point> DQ = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			DQ.offer(new Point(i, kb.nextInt()));
		}
		
		while(!DQ.isEmpty()){
			Point cur = DQ.poll();
			result.add(cur.idx);
			
			if(DQ.isEmpty()) {
				break;
			}
			if(cur.x >= 1) {
				for(int j = 0; j < cur.x - 1; j++) {
					DQ.offer(DQ.poll());
				}
			}else {
				for(int j = 0; j < Math.abs(cur.x); j++) {
					DQ.offerFirst(DQ.pollLast());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int x : result) {
			sb.append(x).append(" ");
		}
		System.out.print(sb);
	}
}