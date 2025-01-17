import java.util.*;

public class Main {
	
	public String solution(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		String result = "";
		
		for(char x : s.toCharArray()) {
			if(x == ')') {
				while(stack.pop() != '(');
			}else {
				stack.push(x);
			}
		}
		
		for(int i = 0; i < stack.size(); i++) {
			result += stack.get(i);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		
		System.out.print(T.solution(s));
		
	}
}
