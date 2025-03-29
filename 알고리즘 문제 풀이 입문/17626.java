import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		boolean flag = true;
		
		for(int i = 0; i <= 255; i++) {
			for(int j = 0; j <= 255; j++) {
				for(int k = 0; k <= 255; k++) {
					for(int q = 0; q <= 255; q++) {
						
						int a = (int)Math.pow(i, 2);
						int b = (int)Math.pow(j, 2);
						int c = (int)Math.pow(k, 2);
						int d = (int)Math.pow(q, 2);
						
						if(a + b + c + d == n) {
							if(i != 0) {
								result++;
							}
							if(j != 0) {
								result++;
							}
							if(k != 0) {
								result++;
							}
							if(q != 0) {
								result++;
							}
							System.out.print(result);
							return;
						}
					}
				}
			}
		}
	}
}