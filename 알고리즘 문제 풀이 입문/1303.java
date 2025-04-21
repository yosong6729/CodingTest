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
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int W, B;
	
	public static void BFS(int x, int y, char c) {
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		int sum = 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int pX = p.x;
				int pY = p.y;
				
				for(int j = 0; j < 4; j++) {
					int nx = pX + dx[j];
					int ny = pY + dy[j];
					
					if(nx >= 0 && nx < m && ny >= 0 && ny < n
							&& !visited[nx][ny] && arr[nx][ny] == c) {
						visited[nx][ny] = true;
						sum++;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
		if(c == 'B') {
			B += sum * sum;
		}else if(c == 'W'){
			W += sum * sum;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());for
		W = 0;
		B = 0;
		
		arr = new char[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}	
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					BFS(i, j, arr[i][j]);
				}
			}
		}
		
		System.out.print(W + " " + B);
	}
}