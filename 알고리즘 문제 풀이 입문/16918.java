import java.util.*;
import java.io.*;
class Point{
	int time;
	char boom;
	
	Point(int time, char boom){
		this.time = time;
		this.boom = boom;
	}
}

class XY{
	int x;
	int y;
	
	XY(int x, int y){
		this.x = x;
		this.y = y;
	}
}


class Main {
	
	static int r, c, n, curTime;
	static Point[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void BFS(int x, int y) {
		
		map[x][y] = new Point(0, '.');
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
				map[nx][ny] = new Point(0, '.');
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		r = kb.nextInt();
		c = kb.nextInt();
		n = kb.nextInt();
		map = new Point[r][c];
		
		for(int i = 0; i < r; i++) {
			String s = kb.next();
			for(int j = 0; j < c; j++) {
				map[i][j] = new Point(0, s.charAt(j));
			}
		}
		
		curTime = 1;
		ArrayList<XY> boomList = new ArrayList<>();

		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < r; j++) {
				for(int k = 0; k < c; k++) {
					if(curTime % 2 == 0) {
						if(map[j][k].boom == '.') {
							map[j][k] = new Point(curTime, 'O');
						}
					}
					if((map[j][k].time + 3) == curTime) {
						boomList.add(new XY(j, k));
					}
				}
			}
			for(XY xy : boomList) {
				BFS(xy.x, xy.y);
			}
			boomList.clear();
			curTime++;
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0 ; j < c; j++) {
				System.out.print(map[i][j].boom);
			}
			System.out.println();
		}
	}
}