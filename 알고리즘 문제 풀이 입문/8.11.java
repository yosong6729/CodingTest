import java.util.*;

public class Main {

	static int[][] m = new int[7][7];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Integer> result = new ArrayList<>();
	static int cnt = 0;
	public void DFS(int x, int y) {
		if(x == 6 && y == 6) {
			result.add(cnt);
			return;
		}else {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < 7 && ny >=0 && ny < 7 && m[nx][ny] == 0) {
					m[nx][ny] = 1;
					cnt++;
					DFS(nx, ny);
					cnt--;
					m[nx][ny] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				m[i][j] = kb.nextInt();
			}
		}
		
		m[1][1] = 1;
		
		T.DFS(0, 0);
		
		Collections.sort(result);
		if(result.size() == 0) {
			System.out.print("-1");
		}else{
			System.out.print(result.get(0));
		}
		
	}
}
