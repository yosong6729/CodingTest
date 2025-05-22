import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static HashSet<Integer> set;
	
	public static void DFS(int L, int x, int y, String s) {
		if(L == 5) {
			set.add(Integer.valueOf(s));
			return;
		}else {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
					DFS(L + 1, nx, ny, s + arr[nx][ny]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[5][5];
		set = new HashSet<>();
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				DFS(0, i, j, String.valueOf(arr[i][j]));
			}
		}
		
		System.out.print(set.size());
	}
}
