import java.util.*;
import java.io.*;

class Main {
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> PQ1 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> PQ2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> PQ3 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> PQ4 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> PQ5 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> PQ6 = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		result = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(a) {
				case 1:
					melody(PQ1, b);
					break;
				case 2:
					melody(PQ2, b);
					break;
				case 3:
					melody(PQ3, b);
					break;
				case 4:
					melody(PQ4, b);
					break;
				case 5:
					melody(PQ5, b);
					break;
				case 6:
					melody(PQ6, b);
					break;
			}
		}
		
		System.out.print(result);
			
	}
	
	public static void melody(PriorityQueue<Integer> PQ, int num) {
		
		if(PQ.isEmpty()) {
			PQ.offer(num);
			result++;
			return;
		}else {
			if(PQ.peek() == num) {
				return;
			}else if(PQ.peek() < num) {
				PQ.offer(num);
				result++;
			}else {
				while(true) {
					if(PQ.isEmpty()) {
						PQ.offer(num);
						result++;
						break;
					}
					int n = PQ.peek();
					if(n == num){
						break;
					}else if(n > num){
						PQ.poll();
						result++;
					}else {
						result++;
						PQ.offer(num);
						break;
					}
				}
			}
		}
	}
}