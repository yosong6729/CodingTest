import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		TreeMap<Character, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int a = 0;
		for(char c : map.keySet()) {
			if(map.get(c) % 2 == 1) {
				a++;
				if(a >= 2) {
					System.out.print("I'm Sorry Hansoo");
					return;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuilder mid = new StringBuilder();
		StringBuilder reverse = new StringBuilder();
		
		for(char c : map.keySet()) {
			int x = map.get(c);
			for(int i = 0; i < x / 2; i++) {
				sb.append(c);
				reverse.append(c);
			}
			if(x % 2 != 0) {
				mid.append(c);
			}
		}
		
		sb.append(mid).append(reverse.reverse());
		
		System.out.print(sb);
	}
}