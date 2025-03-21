import java.util.*;
import java.io.*;


class Main {
	
	static int c, r, k;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1 ,0};
	static int cnt = 0;
	static boolean flag = true;
	static int resultX = 0;
	static int resultY = 0;
	public static void DFS(int x, int y, int dir) {
		arr[x][y] = 1;
		cnt++;
		if(!flag) {
			return;
		}
		
		if(cnt == k) {
			flag = false;
			resultX = x;
			resultY = y;
			return;
		}
		
		int nx = x + dx[dir % 4];
		int ny = y + dy[dir % 4];
		if(nx >= 1 && nx <= c && ny >= 1 && ny <= r
				&& arr[nx][ny] == 0) {
			DFS(nx, ny, dir);
		}else {
			nx = x + dx[(dir + 1) % 4];
			ny = y + dy[(dir + 1) % 4];
			if(nx >= 1 && nx <= c && ny >= 1 && ny <= r
					&& arr[nx][ny] == 0) {
				DFS(nx, ny, dir + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		
		arr = new int[c + 1][r + 1];
		
		DFS(1, 1, 0);
		
		if(resultX != 0 && resultY != 0) {
			System.out.print(resultX + " " + resultY);
		}else {
			System.out.print(0);
		}
	}
}