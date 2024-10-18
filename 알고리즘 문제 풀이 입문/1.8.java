import java.util.*;

public class Main {
	
	public String solution(String str) {
		
		
		str = str.replaceAll("[^A-Za-z]", "").toUpperCase();
		
		String tmp = new StringBuilder(str).reverse().toString();
		
		if(str.equals(tmp)) {
			return "YES";
		}
		
		return "NO";
		
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		
		System.out.print(T.solution(str));
	}
}
