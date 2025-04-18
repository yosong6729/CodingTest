import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.BigInteger;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int m, n;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean flag = false; 
	
	public static void BFS(int x, int y) {
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		arr[x][y] = 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int pX = p.x;
				int pY = p.y;
				if(pX == m - 1) {
					flag = true;
					return;
				}
				for(int j = 0; j < 4; j++) {
					int nx = pX + dx[j];
					int ny = pY + dy[j];
					
					if(nx >= 0 && nx < m && ny >= 0 && ny < n
							&& arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(arr[0][i] == 0) {
				BFS(0, i);
			}
		}

		if(!flag) {
			System.out.print("NO");	
		}else {
			System.out.print("YES");
		}
	}
}