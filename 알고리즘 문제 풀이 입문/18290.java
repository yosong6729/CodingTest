import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, k;
	static int result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void DFS(int cnt, int sum) {
		if(cnt == k) {
			result = Math.max(result,  sum);
		}else {
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j]) {
						if(check(i, j)) {
							visited[i][j] = true;
							DFS(cnt + 1, sum + map[i][j]);
							visited[i][j] = false;
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int x, int y){
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < m 
					&& visited[nx][ny]) {
				return false;
			}
		}
		
		return true;
	}
		

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];		
		visited = new boolean[n][m];
		result = Integer.MIN_VALUE;		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0);
		
		System.out.print(result);
	}
}