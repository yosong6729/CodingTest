import java.util.*;

public class Main {
	
	public String solution(String str) {
		String answer = "";
		
		for(char x : str.toCharArray()) {
			if(Character.isUpperCase(x)) {
				answer += Character.toLowerCase(x);
			}else {
				answer += Character.toUpperCase(x);
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}