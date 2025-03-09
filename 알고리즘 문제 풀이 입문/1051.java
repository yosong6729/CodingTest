import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[n][m];
		int max = 1;
		
		for(int i = 0; i < n; i++) {
			String s = kb.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int k = 1;
				while(true) {
					if(i + k >= n || j + k >= m) {
						break;
					}
					int sum = 0;
					int num = arr[i][j];
					int nx = arr[i + k][j];
					int ny = arr[i][j + k];
					int nny = arr[i + k][j + k];
					
					if(num == nx && num == ny && num == nny) {
						sum = (k + 1) * (k + 1);
						max = Math.max(max, sum);
					}
					k++;
				}
			}
		}
		
		System.out.print(max);
	}
}