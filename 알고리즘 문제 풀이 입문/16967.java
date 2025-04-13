import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[][] arrB = new int[h + x][w + y];
		
		for(int i = 0; i < h + x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w + y; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int a = 0;
		int b = 0;
		for(int i = x; i < h; i++) {
			b = 0;
			for(int j = y; j < w; j++) {
				arrB[i][j] -= arrB[a][b];
				b++;
			}
			a++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				sb.append(arrB[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}