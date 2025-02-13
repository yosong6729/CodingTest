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


	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[][] arr = new int[n + 1][m + 1];
		
		for(int i = 0; i < n; i++) {
			String s = kb.next();
			for(int j = 0; j < s.length(); j++) {
				arr[i + 1][j + 1] = s.charAt(j) - '0';
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(1, 1));
		
		int answer = 0;
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				if(p.x == n && p.y == m) {
					answer = Math.max(answer, L); 
				}
				for(int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if(nx >= 1 && nx <= n && ny >= 1 && ny <= m
							&& arr[nx][ny] == 1) {
						Q.offer(new Point(nx, ny));
						arr[nx][ny] = 0;
					}
				}
			}
			L++;
		}
		
		System.out.print(answer + 1);
		
	}
}