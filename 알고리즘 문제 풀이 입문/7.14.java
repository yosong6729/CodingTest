import java.util.*;

public class Main {
    	
	static int[][] graph;
	static int[] ch;
	public int[] BFS(int n, int m) {
		
		int[] result = new int[n + 1];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(1);
		
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int x = Q.poll();
				for(int j = 1; j <= n; j++) {
					if(graph[x][j] == 1 && ch[j] == 0) {
						ch[j] = 1;
						Q.offer(j);
						result[j] = L + 1;
					}
				}
			}
			L++;
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		graph = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = 1;
		}
		
		ch = new int[n + 1];
		ch[1] = 1;
		int[] result = new int[n + 1];
		result = T.BFS(n, m);
		for(int i = 2; i <= n; i++) {
			System.out.println(i + ":" + result[i]);
		}
	}
}
