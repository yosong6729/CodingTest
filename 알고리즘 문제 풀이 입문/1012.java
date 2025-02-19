import java.util.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Main {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n, m, cnt = 0;
	static int[][] graph;
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				graph[p.x][p.y] = 0;
				for(int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if(nx >=0 && nx < n && ny >= 0 && ny < m 
							&& graph[nx][ny] == 1) {
						graph[nx][ny] = 0;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int t = kb.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int  q = 0; q < t; q++) {
			n = kb.nextInt();
			m = kb.nextInt();
			int k = kb.nextInt();
			
			graph = new int[n][m];
			
			for(int i = 0; i < k; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				graph[a][b] = 1;
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(graph[i][j] == 1) {
						T.BFS(i, j);
						cnt++;
					}
				}
			}
			answer.add(cnt);
			cnt = 0;
		}
		
		for(int x : answer) {
			System.out.println(x);
		}
	}
}