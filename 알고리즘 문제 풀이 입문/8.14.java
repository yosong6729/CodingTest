import java.util.*;

class Point{
	int x;
	int y;
	Point(int x , int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n, result;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] board;
	Queue<Point> Q = new LinkedList<>();
	public void BFS(Point p) {
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point tmp = Q.poll();
				for(int j = 0; j < 8; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if(nx >= 0 && nx < n && ny < n && ny >= 0 && board[nx][ny] == 1) {
						board[nx][ny] = 0;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	public void solution(int n) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					Q.offer(new Point(i, j));
					board[i][j] = 0;
					BFS(Q.peek());
					result++;
				}
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
		
		T.solution(n);
		System.out.print(result);
		
	}
}
