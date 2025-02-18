public import java.util.*;

class Main {
	
	static boolean[] visited;
	public void BFS(int n, int k) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(n);
		
		boolean flag = true;
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0 ; i < len; i++) {
				int x = Q.poll();
				if(visited[x]) {
					continue;
				}
				visited[x] = true;
				if(x == k) {
					flag = false;
					break;
				}
				
				if (x * 2 >= 0 && x * 2 <= 100000 && x <= k) {
					Q.offer(x * 2);
				}
				
				if(x - 1 >= 0 && x <= 100000) {
					Q.offer(x - 1);
				}
				if(x + 1 >= 0 && x + 1 <= 100000) {
					Q.offer(x + 1);
				}
				
				
			}
			if(!flag) {
				break;
			}
			L++;

		}
		
		System.out.print(L);
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int k = kb.nextInt();
		visited = new boolean[100001];
		
		T.BFS(n, k);
		
		
	}
} 1697 {
    
}
