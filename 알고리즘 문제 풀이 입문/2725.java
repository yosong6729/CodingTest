import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		int[] count = new int[1001];
		count[1] = 3;
		for(int i = 2; i < 1001; i++) {
			int tmp = 0;
			for(int j = 1; j < i; j++) {
				if(gcd(i, j) == 1) {
					tmp++;
				}
			}
			count[i] = count[i - 1] + tmp * 2;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < c; i++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(count[n]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static int gcd(int a, int b) {
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}

	
}