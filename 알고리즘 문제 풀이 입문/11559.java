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
	
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result = 0;
	static int[][] ch;
	
	public static boolean BFS(int x, int y, char c) {
		Queue<Point> Q = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		ch = new int[12][6];
		list.add(new Point(x, y));
		ch[x][y] = 1;
		Q.offer(new Point(x, y));
		
		int sum = 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int px = p.x;
				int py = p.y;
				for(int j = 0; j < 4; j++) {
					int nx = px + dx[j];
					int ny = py + dy[j];
					if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6
							&& map[nx][ny] == c && ch[nx][ny] == 0) {
						ch[nx][ny] = 1;
						sum++;
						list.add(new Point(nx, ny));
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
		if(sum >= 4) {
			// 터진 경우
			for(Point p : list) {
				map[p.x][p.y] = '.';
			}
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		map = new char[12][6];
		
		for(int i = 0; i < 12; i++) {
			String s = kb.next();
			for(int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		while(true) {
			boolean popHappend = false;
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] != '.') {
						if(BFS(i, j, map[i][j])) {
							popHappend = true;
						}
					}
				}
			}
			
			if(!popHappend) {
				break;
			}else {
				result++;
			}
			
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j <= 11; j++) {
					for(int k = 10; k >= 0; k--) {
						if(map[k + 1][i] == '.') {
							map[k + 1][i] = map[k][i];
							map[k][i] = '.';
						}
					}
				}
			}
		}
		
		System.out.print(result);
	}
}