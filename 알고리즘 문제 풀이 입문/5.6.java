import java.util.*;

public class Main { 
	
	public int solution(int n, int k) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			for(int i = 0; i < k - 1; i++) {
				int first = queue.poll();
				queue.offer(first);
			}
			queue.poll();
		}
		
		return queue.peek();
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		System.out.print(T.solution(n, k));
		
	}
}
