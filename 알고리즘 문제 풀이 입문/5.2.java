import java.util.*;

public class Main {
	
	public char[] solution(String s) {
		
		Stack<HashMap<Character, Integer>> stack = new Stack<>();
		HashMap<Character, Integer> map = new HashMap<>();
		char[] c = s.toCharArray();

		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '(' && s.charAt(i) != ')') {
				continue;
			}else if(s.charAt(i) == '(') {
				HashMap<Character, Integer> pushM = new HashMap<>();
				pushM.put(s.charAt(i), i);
				
				stack.push(pushM);
			}else {
				HashMap<Character, Integer> popM = stack.pop();
				int k = popM.get('(');
				for(int j = k; j <= i; j++) {
					c[j] = '0';
				}
			}
		}
		
		
		return c;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		
		for(char x : T.solution(s)) {
			if(x != '0') {
				System.out.print(x);
			}
		}
	}
}
