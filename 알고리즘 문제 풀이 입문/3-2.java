import java.util.*;
import java.io.*;

public class Main {
	
	public String solution(String s){
		String answer = "";
		
		Stack<String> stack = new Stack<>();
		
		
		for(char x : s.toCharArray()) {
			
			if(x != ')') {
				stack.add(String.valueOf(x));
			}else {
				StringBuilder sb = new StringBuilder();
				
				while(true) {
					String p = stack.peek();
					if(p.equals("(")) {
						stack.pop();
						break;
					}else {
						StringBuilder a = new StringBuilder();
						a.append(stack.pop());
						sb = a.append(sb);
					}
				}
				
				if(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
					int n = Integer.parseInt(stack.pop());
					String str = sb.toString();
					for(int i = 0; i < n - 1; i++) {
						sb.append(str);
					}
				}
				stack.add(sb.toString());
			}
		}
		
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			StringBuilder a = new StringBuilder();
			a.append(stack.pop());
			result = a.append(result);
		}
		
		
		return answer = result.toString();
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}
