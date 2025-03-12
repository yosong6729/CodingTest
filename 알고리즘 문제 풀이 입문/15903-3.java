import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Long> PQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			PQ.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < m; i++) {
			long min = PQ.poll();
			long min2 = PQ.poll();
			
			long sum = min + min2;
			PQ.offer(sum);
			PQ.offer(sum);
		}
		
		long result = 0;
		
		for(long l : PQ) {
			result += l;
		}
		
		System.out.print(result);
	}
}