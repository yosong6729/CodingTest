import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] trS = s.split(" ");
		
		String first = trS[0];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < trS.length; i++) {
			first = trS[0];
			String a = trS[i];
			for(int j = a.length() - 2; j >= 1 ; j--) {
				char c = a.charAt(j);
				if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
					break;
				}
				if(c == ']'){
					first += "[]";
					j--;
					continue;
				}
				
				first += c;
			}
			
			first += " ";
			int j = 0;
			while(a.charAt(j) >= 'A' && a.charAt(j) <= 'Z' 
					|| a.charAt(j) >= 'a' && a.charAt(j) <= 'z') {
				first += a.charAt(j);
				j++;
			}
			
			sb.append(first).append(";").append("\n");
		}
		
		System.out.print(sb);
	}

}
