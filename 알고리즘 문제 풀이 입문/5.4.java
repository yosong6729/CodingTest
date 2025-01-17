import java.util.*;

public class Main {
	
	public int solution(String s) {
		Stack<Integer> stack = new Stack<>();
		
		for(char x : s.toCharArray()) {
			if(x == '+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push((b + a));
			}else if(x == '-') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push((b - a));
			}else if(x == '*') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push((b * a));
			}else if(x == '/') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push((b / a));
			}else {
				stack.push(x - '0');
			}
		}
		
		return stack.get(0);
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		
		System.out.print(T.solution(s));
		
	}
}
