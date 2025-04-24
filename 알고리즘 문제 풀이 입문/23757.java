import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Integer[] pre = new Integer[n];
		int[] chi = new int[m];
		
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			PQ.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m; i++) {
			chi[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			if(PQ.peek() < chi[i]) {
				System.out.print(0);
				return;
			}else {
				PQ.offer(PQ.poll() - chi[i]);
			}
		}
		
		System.out.print(1);
	}
	
}