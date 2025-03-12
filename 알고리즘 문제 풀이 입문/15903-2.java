import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
	long v;
	int idx;
	
	Point(long v, int idx){
		this.v = v;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Point o) {
		return Long.compare(this.v, o.v);
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Point> PQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			PQ.offer(new Point(Integer.parseInt(st.nextToken()), i));
		}
		
		for(int i = 0; i < m; i++) {
			Point p = PQ.poll();
			long min = p.v;
			int minIdx = p.idx;
			
			Point p2 = PQ.poll();
			long min2 = p2.v;
			int min2Idx = p2.idx;
			
			long sum = min + min2;
			PQ.offer(new Point(sum, minIdx));
			PQ.offer(new Point(sum, min2Idx));
		}
		
		long result = 0;
		
		for(Point p : PQ) {
			result += p.v;
		}
		
		System.out.print(result);
	}
}