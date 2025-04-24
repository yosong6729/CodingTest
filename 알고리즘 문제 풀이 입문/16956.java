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
	
	static int r, c;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void BFS(int x, int y){
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int px = p.x;
				int py = p.y;
				
				for(int j = 0; j < 4; j++) {
					int nx = px + dx[j];
					int ny = py + dy[j];
					if(nx >= 0 && nx < r && ny >= 0 && ny < c
							&& map[nx][ny] == '.') {
						map[nx][ny] = 'D';
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0 ; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'S') {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < r && ny >= 0 && ny < c
								&& map[nx][ny] == 'W') {
							System.out.print(0);
							return;
						}
					}
					
					BFS(i, j);
				}
			}
		}
		
		System.out.println(1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}