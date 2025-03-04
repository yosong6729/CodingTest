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
	static int[][] map;
	static Queue<Point> Q = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] ch;
	static int[][] result;
	
	public static void BFS() {
		
		int L = 0;
		
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
							&& map[nx][ny] == 1 && ch[nx][ny] == 0) {
						ch[nx][ny] = 1;
						result[nx][ny] = L + 1;
						Q.offer(new Point(nx, ny));
					}
				}
			}
			L++;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		map = new int[n + 1][m + 1];
		result = new int[n + 1][m + 1];
		ch = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m ; j++) {
				map[i][j] = kb.nextInt();
				if(map[i][j] == 2) {
					Q.offer(new Point(i, j));
					ch[i][j] = 1;
				}
			}
		}
		
		BFS();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] != 0 && ch[i][j] == 0) {
					System.out.print(-1 + " ");
				}else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
}