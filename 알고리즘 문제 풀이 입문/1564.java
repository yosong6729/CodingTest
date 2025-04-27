import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long mod = 1_000_000_000_000L;
		
		long result = 1;
		while(n >= 1) {
			
			result *= n;
			while(result % 10 == 0) {
				result /= 10;
			}
			if(result >= 100000) {
				result %= mod;
			}
			
			n--;
		}
		
		String s = Long.toString(result);
		if(s.length() >= 5) {
			System.out.print(s.substring(s.length() - 5));
		}else {
			System.out.print(String.format("%05d", result % mod));
		}
	}

}