import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				PQ.offer(kb.nextInt());
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			result = PQ.poll();
		}
		
		System.out.print(result);
	}
}