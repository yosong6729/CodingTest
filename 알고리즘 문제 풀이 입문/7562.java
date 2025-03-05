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
	
	static int l;
	static int curX, curY, endX, endY;
	static int[][] graph;
	static int[][] ch;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void BFS(int a, int b) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(a, b));
		ch[a][b] = 1;
		
		boolean flag = true;
		int L = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int x = p.x;
				int y = p.y;
				if(x == endX && y == endY) {
					flag = false;
					result.add(L);
					break;
				}
				for(int j = 0; j < 8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx >= 0 && nx < l && ny >= 0 && ny < l
							&& ch[nx][ny] == 0) {
						ch[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
					}
				}
			}
			if(!flag) {
				break;
			}
			L++;
		}
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		
		int t = kb.nextInt();
		for(int i = 0; i < t; i++) {
			l = kb.nextInt();
			graph = new int[l][l];
			ch = new int[l][l];
			
			curX = kb.nextInt();
			curY = kb.nextInt();
			
			endX = kb.nextInt();
			endY = kb.nextInt();
			
			BFS(curX, curY);
		}
		
		for(int x : result) {
			System.out.println(x);
		}
	}
}