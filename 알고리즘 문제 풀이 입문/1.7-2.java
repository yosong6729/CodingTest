import java.util.*;

public class Main {
	
	public String solution(String str) {
		
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(tmp)) {
			return "YES";
		}else {
			return "NO";
		}
		
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}
