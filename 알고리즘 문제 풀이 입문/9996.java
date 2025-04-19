import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String pattern = br.readLine();
		
		int idx = pattern.indexOf('*');
		String firstPattern = pattern.substring(0, idx);
		String lastPattern = pattern.substring(idx + 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.length() >= firstPattern.length() + lastPattern.length()) {
				if(s.startsWith(firstPattern) && s.endsWith(lastPattern)) {
					sb.append("DA").append("\n");
				}else {
					sb.append("NE").append("\n");
				}
			}else {
				sb.append("NE").append("\n");
			}
		}
		
		System.out.print(sb);
	}
}