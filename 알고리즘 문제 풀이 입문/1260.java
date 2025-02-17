import java.util.*;

class Main {
	
	static int n, m, v;
	static int[][] graph;
	static int[] ch;
 	public void DFS(int v) {
 		if(ch[v] == 0) {
 			ch[v] = 1;
 			System.out.print(v + " ");
 		}
		for(int i = 0; i <= n; i++) {
			if(graph[i][v] == 1 || graph[v][i] == 1) {
				if(ch[i]== 0) {
 					graph[v][i] = graph[i][v] = 0;
 					DFS(i);
 					graph[v][i] = graph[i][v] = 1;
				}
			}
		}
	}
	
	public void BFS(int v) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) {
				int a = q.poll();
				if(ch[a] == 0) {
					ch[a] = 1;
					System.out.print(a + " ");
				}
				for(int j = 0; j <= n; j++) {
					if(graph[a][j] == 1 || graph[j][a] == 1) {
						if(ch[j] == 0) {
							graph[a][j] = graph[j][a] = 0;
							q.offer(j);
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		v = kb.nextInt();
		ch = new int[n + 1];
		graph = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		
		T.DFS(v);
		System.out.println();
		Arrays.fill(ch, 0);
		T.BFS(v);
	}
}