import java.util.*;

public class Main {
	
	public String solution(String str) {
		char[] s = str.toCharArray();
	
		int lf = 0;
		int rf = s.length - 1;
		
		while(lf < rf) {
			if(Character.isAlphabetic(s[lf]) && Character.isAlphabetic(s[rf])) {
				char tmp = s[lf];
				s[lf] = s[rf];
				s[rf] = tmp;
				lf++;
				rf--;
				continue;
			}else if(!Character.isAlphabetic(s[lf])) {
				lf++;
			}else if(!Character.isAlphabetic(s[rf])) {
				rf--;
			}
		}
		
		return String.valueOf(s);
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}