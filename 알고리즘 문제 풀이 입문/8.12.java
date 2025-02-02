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
	static Integer[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public void BFS(ArrayList<Point> a) {
	
		Queue<Point> Q = new LinkedList<>();
		for(int i = 0; i < a.size(); i++) {
			Q.offer(a.get(i));
		}
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point tmp = Q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
						board[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
					}
				}
			}
			L++;
		}
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 0) {
					System.out.print(-1);
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(!flag) {
			System.out.print(L - 1);
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		m = kb.nextInt();
		n = kb.nextInt();
		board = new Integer[n][m];
		
		ArrayList<Point> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j] == 1) {
					a.add(new Point(i, j));
				}
			}
		}
		
		T.BFS(a);
		
	}
}
