import java.util.*;
import java.io.*;

class Main {
	
	static int n, m, r, c, d;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0 , 1, 0, -1};
	static int result = 1;
	
	public static void DFS(int x, int y, int dir) {
		map[x][y] = -1;
		
		for(int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < m
					&& map[nx][ny] == 0) {
				result++;
				DFS(nx, ny, dir);
				return;
			}
		}
		
		int direction = (dir + 2) % 4;
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		
		if(nx >= 0 && nx < n && ny >= 0 && ny < m
				&& map[nx][ny] != 1) {
			DFS(nx, ny, dir);
		}
	}


	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		map= new int[n][m];
		
		r = kb.nextInt();
		c = kb.nextInt();
		d = kb.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		DFS(r, c, d);
		
		System.out.print(result);
	}
	
}