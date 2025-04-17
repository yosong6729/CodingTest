import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
	public static int gcd(int a, int b) {
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int g = 0;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int len = Math.abs(s - num);
			if(i == 0) {
				g = len;
			}else {
				g = gcd(g, len);
			}
		}
		
		System.out.print(g);
		
	}
}