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

class Main {
	
	static int w, h;
	static int[][] arr;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void BFS(int x, int y) {
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		arr[x][y] = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int curX = p.x;
				int curY = p.y;
				for(int j = 0; j < 8; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];
					if(nx >= 0 && nx < h && ny >= 0 && ny < w
							&& arr[nx][ny] == 1) {
						arr[nx][ny] = 0;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			arr = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1) {
						BFS(i, j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}