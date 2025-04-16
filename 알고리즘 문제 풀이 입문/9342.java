import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String regex = "^[ABCDEF]?A+F+C+[ABCDEF]?$";
		Pattern pattern = Pattern.compile(regex);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			
			String s = br.readLine();
			Matcher m = pattern.matcher(s);
			if(m.matches()) {
				sb.append("Infected!").append("\n");
			}else {
				sb.append("Good").append("\n");
			}
		}
		
		System.out.print(sb);
	}

}
