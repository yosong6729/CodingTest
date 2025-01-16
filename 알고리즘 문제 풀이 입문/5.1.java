import java.util.*;

public class Main {
	
	public String solution(String s) {
		
		int L = s.length();
		String result = "YES";
		int cnt = 0;
		
		for(int i = 0; i < L; i++) {
			if(s.charAt(i) == '(') {
				cnt++;
			}else if(s.charAt(i) == ')') {
				cnt--;
			}
			if(cnt < 0) {
				return "NO";
			}
		}
		if(cnt != 0) {
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
