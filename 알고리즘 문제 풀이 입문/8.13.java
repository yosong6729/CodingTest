import java.util.*;

class Point {
	
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n;
	static int[][] board;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public void DFS(int x, int y, Point p) {
			for(int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= 0 && nx < n&& ny >= 0 && ny < n && board[nx][ny] == 1) {
					board[nx][ny] = 0;
					DFS(nx, ny, new Point(nx, ny));
				}
			}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					T.DFS(i, j, new Point(i, j));
					cnt++;
				}	
			}
		}
		System.out.print(cnt);
	}
}
