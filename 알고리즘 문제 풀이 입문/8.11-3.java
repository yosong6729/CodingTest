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

	static int[][] m = new int[8][8];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] dis = new int[8][8];
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point tmp = Q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && m[nx][ny] == 0) {
						m[nx][ny] = 1;
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
		
		for(int i = 1; i <= 7; i++) {
			for(int j = 1; j <= 7; j++) {
				m[i][j] = kb.nextInt();
			}
		}
		
		m[1][1] = 1;
		
		T.BFS(1, 1);
		if(dis[7][7] == 0) {
			System.out.print("-1");
		}else {
			System.out.print(dis[7][7]);
		}
	}
}
