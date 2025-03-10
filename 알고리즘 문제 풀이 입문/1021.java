import java.util.*;
import java.io.*;

class Main {
	
	static int n, m, min = Integer.MAX_VALUE;
	static Deque<Integer> DQ;
	static int[] arr;
	
	public static void Deque() {
		
		int L = 0;
		int idx = 0;
		int sum = 0;
		
		while(idx != m) {
			if(DQ.peek() == arr[idx]) {
				DQ.poll();
				idx++;
			}else {
				int i = 0;
				for(int x : DQ) {
					if(x == arr[idx]) {
						break;
					}
					i++;
				}
				if(DQ.size() / 2 >= i) {
					DQ.offer(DQ.poll());
					sum++;
				}else {
					DQ.offerFirst(DQ.pollLast());
					sum++;
				}
			}
		}
		
		System.out.print(sum);
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		arr = new int[m];
		for(int i = 0; i < m; i++) {
			arr[i] = kb.nextInt();
		}
		
		DQ = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			DQ.offer(i);
		}
		
		Deque();
	}
}