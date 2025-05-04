import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = n * m  * 2;
		
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					for(int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						
						if(ni >= 0 && ni < n && nj >= 0 && nj < m) {
							if(arr[i][j] > arr[ni][nj]) {
								answer += (arr[i][j] - arr[ni][nj]);
							}
						}else {
							answer += arr[i][j];
						}
					}
				}
			}
		
		System.out.print(answer);
	}
	
}