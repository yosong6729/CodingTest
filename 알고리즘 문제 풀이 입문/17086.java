import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int n, m;
	static int[][] graph;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int max = Integer.MIN_VALUE;
	
	public static void BFS(int sX, int eY) {
		
		boolean[][] visited = new boolean[n][m];
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(sX, eY));
		visited[sX][eY] = true;
		
		int L = 0;

		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int x = p.x;
				int y = p.y;
				
				for(int j = 0; j < 8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx >= 0 && nx < n && ny >= 0 && ny < m
							&& !visited[nx][ny]) {
						if(graph[nx][ny] == 1) {
							max = Math.max(max,  L + 1);
							return;
						}
						visited[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}
			L++;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(graph[i][j] == 0) {
					BFS(i, j);
				}
			}
		}
		
		System.out.print(max);
	}
}
