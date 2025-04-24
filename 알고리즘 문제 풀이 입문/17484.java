import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n, m;
	static int result;
	static int[][] arr;
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};
	
	public static void DFS(int x, int y, int sum, int d) {
		if(x == n - 1) {
			result = Math.min(result,  sum);
			return;
		}else {
			for(int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(ny >= 0 && ny < m && d != i) {
					DFS(nx, ny, sum + arr[nx][ny], i);
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < m; i++) {
			DFS(0, i, arr[0][i], - 1);
		}
		
		System.out.print(result);
	}
}