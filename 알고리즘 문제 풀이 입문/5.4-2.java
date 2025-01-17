import java.util.*;

public class Main {
	
	public int solution(String s) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(char x : s.toCharArray()) {
			if(Character.isDigit(x)) {
				stack.push(x - '0');
			}else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(x == '+') {
					stack.push(lt + rt);
				}
				if(x == '-') {
					stack.push(lt - rt);
				}
				if(x == '*') {
					stack.push(lt * rt);
				}
				if(x == '/') {
					stack.push(lt / rt);
				}
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
