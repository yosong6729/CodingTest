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
	public void BFS() {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(1, 1));
		
		int L = 0;
		Boolean flag = false;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point a = Q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = a.x + dx[j];
					int ny = a.y + dy[j];
					if(nx == 7 && ny == 7) {
						System.out.print(L + 1);
						flag = true;
						break;
					}
					if(nx > 0 && nx < 8 && ny > 0 && ny < 8 && m[nx][ny] == 0) {
						m[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
					}
				}
				if(flag) {
					break;
				}
			}
			L++;
			if(flag) {
				break;
			}
		}
		
		if(!flag) {
			System.out.print("-1");
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
		
		T.BFS();
	}
}
