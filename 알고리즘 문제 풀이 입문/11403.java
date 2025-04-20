import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] graph, result;
	static boolean[] visited;
	
	public static void DFS(int x, int y) {
		
		result[x][y] = 1;
		
		for(int i = 0; i < n; i++) {
			if(graph[y][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(x, i);
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		result = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(graph[i][j] == 1) {
					DFS(i, j);
					Arrays.fill(visited, false);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}