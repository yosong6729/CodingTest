import java.util.*;

class Main {
	
	static int n, v, answer = 0;
	static int[][] graph;
	static int[] ch;
	
	public void DFS(int L) {
		if(ch[L] == 0) {
			ch[L] = 1;
			answer++;
		}
		
		for(int i = 0; i <= n; i++) {
			if(graph[L][i] == 1 && ch[i] == 0) {
				graph[L][i] = graph[i][L] = 0;
				DFS(i);
			}
		}
		
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		v = kb.nextInt();
		
		graph = new int[n + 1][n + 1];
		ch = new int[n + 1];
		
		for(int i = 0; i < v; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		
		T.DFS(1);
		System.out.print(answer - 1);
	}
}