import java.util.*;

public class Main {
	
	public String solution(String str) {
		str = str.toUpperCase();
		
		for(int i =0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return "NO";
			}
		}
		return "YES";
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}