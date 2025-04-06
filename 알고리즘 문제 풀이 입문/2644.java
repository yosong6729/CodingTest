import java.util.*;
import java.io.*;

class Main {
	
	static int n, a, b, m, cnt = 0;
	static int[][] graph;
	static boolean flag = true;
	public static void BFS(int a) {
		
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(a);
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int x = Q.poll();
				for(int j = 1; j <= n; j++) {
					if(graph[x][j] == 1) {
						graph[x][j] = graph[j][x] = 0;
						Q.offer(j);
						if(j == b) {
							flag = false;
							break;
						}
					}
				}
				if(!flag) {
					break;
				}
			}
			cnt++;
			if(!flag) {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		BFS(a);
		
		if(flag) {
			System.out.print(-1);
		}else {
			System.out.print(cnt);
		}
		
	}
}