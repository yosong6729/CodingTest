import java.util.*;

public class Main {

	public int solution(String s) {
		
		Stack<Character> stack = new Stack<>(); 
		int result = 0;
		
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				if(s.charAt(i - 1) == '(') {
					stack.pop();
					result += stack.size();
				}else {
					stack.pop();
					result++;
				}
			}
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
