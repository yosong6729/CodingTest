import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i = a; i <= b; i++) {
			if(Integer.toString(i).contains(Integer.toString(d))) {
				if(prime(i)) {
					result++;
				}
			}
		}
		
		System.out.print(result);
	}

	
	public static boolean prime(int n) {
		
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
