import java.util.*;

public class Main {
	
	public String solution(String s) {
		
		Stack<Character> stack = new Stack<>();
		String result = "YES";
		
		for(char x : s.toCharArray()) {
			if(x == '('){
				stack.push(x);
			}else {
				if(stack.isEmpty()) {
					return "NO";
				}
				stack.pop();
			}
		}
		
		if(!stack.isEmpty()) {
			return "NO";
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
