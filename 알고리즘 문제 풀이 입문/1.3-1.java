import java.util.*;

public class Main {
	
	public String solution(String str) {
		String answer = "";
		
		int m = Integer.MIN_VALUE;
		
		String[] array = str.split(" ");
		for(String x : array) {
			if(m < x.length()) {
				m = x.length();
				answer = x;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		
		System.out.print(T.solution(str));
	}
}