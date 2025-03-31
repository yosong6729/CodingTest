import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arrA = new int[n][n];
		int[][] arrB = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				arrA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]	rotA = new int[n][n];
		int[][] rotB = new int[n][n];
		int min = Integer.MAX_VALUE;
		
		//120도 3번, 대칭후 120도 3번, 각각 비교 최솟값
		for(int q = 0; q < 3; q++) {
			rotA = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					rotA[n - 1 - j][i - j] = arrA[i][j];
				}
			}
			arrA = rotA;
			
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					if(arrA[i][j] != arrB[i][j]) {
						sum ++;
					}
				}
			}
			
			min = Math.min(min, sum);
		}
		
		rotA = new int[n][n];
		// 대칭 변환
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				rotA[i][i - j] = arrA[i][j];
			}
		}
		
		arrA = rotA;
		
		for(int q = 0; q < 3; q++) {
			rotA = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					rotA[n - 1 - j][i - j] = arrA[i][j];
				}
			}
			arrA = rotA;
			
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					if(arrA[i][j] != arrB[i][j]) {
						sum ++;
					}
				}
			}
			
			min = Math.min(min, sum);
		}
		
		System.out.print(min);
	}
}