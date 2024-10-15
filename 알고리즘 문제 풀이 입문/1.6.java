import java.util.*;

public class Main {
	
	public String solution(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) {
				result += str.charAt(i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}
