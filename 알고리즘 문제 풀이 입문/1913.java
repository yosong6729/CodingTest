import java.util.*;
import java.io.*;

class Main {
	

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int a = kb.nextInt();
		int[][] arr = new int[n][n];
		
		int start = n / 2;
		arr[start][start] = 1;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int dir = 0; // 초기 방향 북
		
		int cnt = 1;
		int step = 1;
		
		int curX = start;
		int curY = start;
		boolean flag = true;
		
		int targetX = 0;
		int targetY = 0;
		
		if(a == 1) {
			targetX = start + 1;
			targetY = start + 1;
		}
		
		while(true) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < step; j++) {
					cnt++;
					if(curX == 0 && curY == 0) {
						flag = false;
						break;
					}
					int nx = curX + dx[dir];
					int ny = curY + dy[dir];
					if(cnt == a) {
						targetX = nx + 1;
						targetY = ny + 1;
					}
					
					arr[nx][ny] = cnt;
					curX = nx;
					curY= ny;
				}
				if(!flag) {
					break;
				}
				dir = (dir + 1) % 4;
			}
			if(!flag) {
				break;
			}
			step++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		System.out.print(targetX + " " + targetY);
	}
	
}