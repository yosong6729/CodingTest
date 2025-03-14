import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int n = 0;
		int sIdx = 0;
		
		while(sIdx < s.length()) {
			n++;
			String num = String.valueOf(n);
			
			for(int i = 0; i < num.length() && sIdx < s.length(); i++) {
				if(num.charAt(i) == s.charAt(sIdx)) {
					sIdx++;
				}
			}
		}
		
		System.out.print(n);
	}
}