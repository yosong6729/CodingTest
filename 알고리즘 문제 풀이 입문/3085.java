import java.util.*;
import java.io.*;

class Main {
	static int n, max;
	static int sum;
	static char[][] candy;
	
	public static void valid() {
		for(int k = 0; k <= n - 1; k++) {
			sum = 1;
			for(int q = 0; q < n - 1; q++) {
				if(candy[k][q] == candy[k][q + 1]) {
					sum++;
					max = Math.max(max, sum);
				}else {
					sum = 1;
				}
			}
		}
		
		for(int k = 0; k <= n - 1; k++) {
			sum = 1;
			for(int q = 0; q < n - 1; q++) {
				if(candy[q][k] == candy[q + 1][k]) {
					sum++;
					max = Math.max(max, sum);
				}else {
					sum = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		candy = new char[n][n];
		for(int i = 0; i < n ; i++) {
			String s = kb.next();
			for(int j = 0; j < n; j++) {
				candy[i][j] = s.charAt(j);
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				sum = 1;
				char tmp = candy[i][j];
				candy[i][j] = candy[i][j + 1];
				candy[i][j + 1] = tmp;
				
				valid();
				
				tmp = candy[i][j];
				candy[i][j] = candy[i][j + 1];
				candy[i][j + 1] = tmp;
				
				tmp = candy[j][i];
				candy[j][i] = candy[j + 1][i];
				candy[j + 1][i] = tmp;
				
				valid();
				
				tmp = candy[j][i];
				candy[j][i] = candy[j + 1][i];
				candy[j + 1][i] = tmp;
			}
		}
		
		System.out.print(max);
	}
}