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

class Main {
	
	static int n, m;
	static int[][] graph;
	static int max = Integer.MIN_VALUE;
	static int paintN = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void BFS(int a, int b) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(a, b));
		graph[a][b] = 0;
		int sum = 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int x = p.x;
				int y = p.y;
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx >= 1 && nx <= n && ny >= 1 && ny <= m
							&& graph[nx][ny] == 1) {
						graph[nx][ny] = 0;
						Q.offer(new Point(nx, ny));
						sum++;
					}
				}
			}
		}
		
		max = Math.max(max, sum);
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				graph[i][j] = kb.nextInt();
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(graph[i][j] == 1) {
					BFS(i, j);
					paintN++;
				}
			}
		}
		if(paintN == 0) {
			System.out.println(0);
			System.out.print(0);
		}else {
			System.out.println(paintN);
			System.out.print(max);
		}
		
	}
}