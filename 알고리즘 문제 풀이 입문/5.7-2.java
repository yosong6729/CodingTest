import java.util.*;

public class Main {

	public String solution(String p, String s) {
		
		Queue<Character> Q = new LinkedList<>();
		String result = "YES";
		for(char x : p.toCharArray()) {
			Q.offer(x);
		}
		
		for(char x : s.toCharArray()) {
			if(x == Q.peek()) {
				Q.poll();
			}
			if(Q.isEmpty()) {
				break;
			}
		}
		
		if(!Q.isEmpty()) {
			return "NO";
		}

		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String p = kb.next();
		String s = kb.next();
		
		System.out.print(T.solution(p, s));
	}
}
