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
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static int BFS(int x, int y, int n, int[][] keypad) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		int L = 0;
		boolean[][] visited = new boolean[3][3];
		visited[x][y] = true;
		
		while(!Q.isEmpty()){
			
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Point p = Q.poll();
				int px = p.x;
				int py = p.y;
				if(keypad[px][py] == n) {
					return L;
				}
				
				for(int j = 0; j < 8; j++) {
					int nx = px + dx[j];
					int ny = py + dy[j];
					
					if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3
							&& !visited[nx][ny]) {
						visited[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
					
				}
			}
			L++;
		}
		return 0;
	}
	
	public int solution(int[] keypad, String password){
		int answer = 0;
		
		int[][] newKeypad = new int[3][3];
		
		for(int i = 0; i < keypad.length; i++) {
			newKeypad[i / 3][i % 3] = keypad[i];
		}
		
		
		for(int i = 0; i < password.length() - 1; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(newKeypad[j][k] == (password.charAt(i) - '0')) {
						answer += BFS(j, k, password.charAt(i + 1) - '0', newKeypad);
					}
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}
