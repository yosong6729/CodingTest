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
	
	static int n, r1, c1, r2, c2;
	static int[][] arr;
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};
	static boolean[][] visited;
	
	public static void BFS(int a, int b) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(a, b));
		visited[a][b] = true;
		
		int cnt = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int x = p.x;
				int y = p.y;
				if(x == r2 && y == c2) {
					System.out.print(cnt);
					return;
				}
				for(int j = 0; j < 6; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx >= 0 && nx < n && ny >= 0 && ny < n
							&& !visited[nx][ny]) {
						visited[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}
			cnt++;
		}
		
		System.out.print(-1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		BFS(r1, c1);
	}
}