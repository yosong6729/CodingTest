import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int total = 0;
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '<') {
				total++;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append('<');
				continue;
			}else if(s.charAt(i) == '>') {
				total--;
				sb.append('>');
				continue;
			}else if(s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
				continue;
			}
			
			if(total == 1) {
				sb.append(s.charAt(i));
			}else if(total == 0) {
				stack.push(s.charAt(i));
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb);
	}
}