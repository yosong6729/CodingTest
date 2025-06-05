import java.util.*;
import java.io.*;

public class Main {

	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		
		int[][] arr = new int[c][r];
		boolean[][] visited = new boolean[c][r];
		
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1;
		
		int curX = 0;
		int curY = 0;
		visited[curX][curY] = true;
		
		int cnt = 1;
		if(c * r < k) {
			return answer;
		}
		
		while(true) {
			if(k == cnt) {
				answer[0] = curX + 1;
				answer[1] = curY + 1;
				break;
			}
			int nx = curX + dx[d];
			int ny = curY + dy[d];
			
			if(nx >= 0 && nx < c && ny >= 0 && ny < r
					&& !visited[nx][ny]) {
				visited[nx][ny] = true;
				cnt++;
				curX = nx;
				curY = ny;
			}else {
				d = (d + 1) % 4;
			}
			
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
