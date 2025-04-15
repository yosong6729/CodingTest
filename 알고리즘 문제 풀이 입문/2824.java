import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		HashMap<Integer, Integer> mapA = new HashMap<>();
		HashMap<Integer, Integer> mapB = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 2; j * j <= num; j++) {
				
				while(num % j == 0) {
					mapA.put(j, mapA.getOrDefault(j, 0) + 1);
					num /= j;
				}
			}
			
			if(num > 1) {
				mapA.put(num, mapA.getOrDefault(num, 0) + 1); 
			}
		}
		
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 2; j * j <= num; j++) {
				
				while(num % j == 0) {
					mapB.put(j, mapB.getOrDefault(j, 0) + 1);
					num /= j;
				}
			}
			
			if(num > 1) {
				mapB.put(num, mapB.getOrDefault(num, 0) + 1); 
			}
		}
		
		
		BigInteger result = BigInteger.ONE;
		
		if(mapA.isEmpty() || mapB.isEmpty()) {
			System.out.print(1);
			return;
		}else {
			for(int x : mapA.keySet()) {
				if(mapB.containsKey(x)) {
					int exp = Math.min(mapA.get(x), mapB.get(x));
					BigInteger p = BigInteger.valueOf(x);
					result = result.multiply(p.pow(exp));
				}
			}
		}
		
		String s = result.toString();
		if(s.length() > 9) {
			s = s.substring(s.length() - 9);
		}
		
		System.out.print(s);
	}

}
