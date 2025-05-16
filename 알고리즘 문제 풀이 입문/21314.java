import java.util.*;
import java.io.*;

public class Main {
	
	static int minCnt, maxCnt;
	static StringBuilder max, min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		if(str.length() == 0) {
			System.out.println(0);
			System.out.print(0);
			return;
		}
		
		minCnt = 0;
		maxCnt = 0;
		max = new StringBuilder();
		min = new StringBuilder();
		for(char c : str.toCharArray()) {
			
			maxStr(c);
			
			minStr(c);
		}
		
		if(maxCnt > 0) {
			for(int i = 0; i < maxCnt; i++) {
				max.append("1");
			}
		}
		
		if(minCnt > 0) {
			min.append("1");
			for(int i = 1; i < minCnt; i++) {
				min.append("0");
			}
		}
		
		System.out.println(max);
		System.out.print(min);
	}		
	
	public static void maxStr(char c) {
		if(c == 'M') {
			maxCnt++;
		}else {
			max.append("5");
			for(int i = 0; i < maxCnt; i++) {
				max.append("0");
			}
			maxCnt = 0;
		}
	}
	
	public static void minStr(char c) {
		if(c == 'M') {
			minCnt++;
		}else {
			if(minCnt == 0) {
				min.append("5");
			}else {
				min.append("1");
				for(int i = 1; i < minCnt; i++) {
					min.append("0");
				}
				min.append("5");
			}
			
			minCnt = 0;
		}
	}
}
