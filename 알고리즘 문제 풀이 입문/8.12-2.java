import java.util.*;

class Point{
	
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int m;
	static int n;
	static int[][] board, dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> Q = new LinkedList<>();
	
	public void BFS() {
	
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point tmp = Q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
						board[nx][ny] = 1;
						dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		m = kb.nextInt();
		n = kb.nextInt();
		board = new int[n][m];
		dis = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j] == 1) {
					Q.offer(new Point(i, j));
				}
			}
		}
		
		T.BFS();
		
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 0) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				break;
			}
		}
		int max = Integer.MIN_VALUE;
		
		if(!flag) {
			System.out.print(-1);
		}else {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					max = Math.max(max, dis[i][j]);
				}
			}
			System.out.print(max);
		}
	}
}
