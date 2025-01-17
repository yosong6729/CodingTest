import java.util.*;

public class Main {
	
	public String solution(String p, String s) {
		String result = "YES";
		
		Queue<Character> pQ = new LinkedList<>();
		
		for(int i = 0; i < p.length(); i++) {
			pQ.offer(p.charAt(i));
		}
		
		Queue<Character> sQ = new LinkedList<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(pQ.contains(s.charAt(i))){
				sQ.offer(s.charAt(i));
			}
		}
		if(!pQ.equals(sQ)) {
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
