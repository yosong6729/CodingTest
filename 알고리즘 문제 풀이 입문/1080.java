import java.util.*;
import java.io.*;

class Main {
	
	static char[][] arrA;
	static char[][] arrB;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arrA = new char[n][m];
		arrB = new char[n][m];
		
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				arrA[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				arrB[i][j] = s.charAt(j);
			}
		}
		
		int result = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    change(i, j);
                    result++;
                }
            }
        }
        
        if (Arrays.deepEquals(arrA, arrB)) {
            System.out.print(result);
        } else {
            System.out.print(-1);
        }
	}
	
	public static void change(int x, int y) {
		for(int i = x; i <= x + 2; i++) {
			for(int j = y; j <= y + 2; j++) {
				if(arrA[i][j] == '0') {
					arrA[i][j] = '1';
				}else {
					arrA[i][j] = '0';
				}
			}
		}
	}
}