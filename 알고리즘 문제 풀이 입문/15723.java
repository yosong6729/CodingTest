import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] graph;
	static boolean[] visited;
	static boolean flag = false;
	
	public static void DFS(int fir, int sec) {
		
		visited[fir] = true;
		
		if(flag) {
			return;
		}
		
		if(fir == sec) {
			flag = true;
			return;
		}else {
			for(int i = 0; i < 26; i++) {
				if(graph[fir][i] == 1 && !visited[i]) {
					visited[i] = true;
					DFS(i, sec);
					visited[i] = false;
				}
			}
		}
		
		visited[fir] = false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		graph = new int[26][26];
		visited = new boolean[26];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			int fir = s.charAt(0) - 'a';
			int sec = s.charAt(5) - 'a';
			
			graph[fir][sec] = 1;
		}
		
		
		m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			int fir = s.charAt(0) - 'a';
			int sec = s.charAt(5) - 'a';
		
			DFS(fir, sec);
			if(flag) {
				sb.append("T").append("\n");
			}else {
				sb.append("F").append("\n");
			}
			
			flag = false;
		}
		
		System.out.print(sb);
	}
	
}