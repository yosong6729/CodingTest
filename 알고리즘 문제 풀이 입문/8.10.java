import java.util.*;

public class Main {
	
	static int[][] m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result = 0;
	public void DFS(int x, int y) {
		if(x == 6 && y == 6) {
			result++;
			return;
		}else {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && nx < 7 && ny >=0 && ny < 7 && m[nx][ny] == 0) {
					m[nx][ny] = 1;
					DFS(nx, ny);
					m[nx][ny] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		m = new int[7][7];
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				m[i][j] = kb.nextInt();
			}
		}
		m[0][0] = 1;
		
		T.DFS(0, 0);
		System.out.print(result);
		
	}
}
