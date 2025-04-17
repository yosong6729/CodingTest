import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static boolean flag = false;
	
	public static void DFS(int x, int y) {
		
		visited[x][y] = true;
		if(map[x][y] == -1) {
			flag = true;
			return;
		}
		if(flag) {
			return;
		}else {
			int len = map[x][y];
			for(int i = 0; i < 2; i++) {
				int nx = x + dx[i] * len;
				int ny = y + dy[i] * len;
				
				if(nx >= 0 & nx < n && ny >= 0 && ny < n
						&& !visited[nx][ny]) {
					visited[nx][ny] = true;
					DFS(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0);
		
		if(flag) {
			System.out.print("HaruHaru");
		}else {
			System.out.print("Hing");
		}
	}
}