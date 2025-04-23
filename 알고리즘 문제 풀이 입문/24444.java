import java.util.*;
import java.io.*;



public class Main {
	
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] result;
	
	public static void BFS(int x) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(x);
		visited[x] = true;
		int cnt = 1;
		result[x] = cnt;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int u = Q.poll();
				
				for(int j = 0; j < graph.get(u).size(); j++) {
					if(!visited[graph.get(u).get(j)]) {
						visited[graph.get(u).get(j)] = true;
						cnt++;
						result[graph.get(u).get(j)] = cnt;
						Q.offer(graph.get(u).get(j));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n + 1];
		result = new int[n + 1];
		graph = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		
		BFS(r);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n ; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}