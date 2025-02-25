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
	
	static int n;
	static int[][] ch, arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int sum;
	
	public static void BFS(int x, int y, int min) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		ch[x][y] = 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int px = p.x;
				int py = p.y;
				for(int j = 0; j < 4; j++) {
					int nx = px + dx[j];
					int ny = py + dy[j];
					if(nx >= 0 && nx < n && ny >= 0 && ny < n 
							&& ch[nx][ny] == 0 && arr[nx][ny] > min) {
						Q.offer(new Point(nx, ny));
						ch[nx][ny] = 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		arr = new int[n][n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		ch = new int[n][n];
		int sum = 0;
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = kb.nextInt();
				max = Math.max(max, arr[i][j]);
				min = Math.min(min, arr[i][j]);
			}
		}
		
		for(int i = 0; i <= max; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[j][k] > i && ch[j][k] == 0) {
						ch[j][k] = 1;
						BFS(j, k, i);
						sum++;
					}
				}
			}
			ch = new int[n][n];
			result = Math.max(result, sum);
			sum = 0;
		}
		
		System.out.print(result);
	}
}