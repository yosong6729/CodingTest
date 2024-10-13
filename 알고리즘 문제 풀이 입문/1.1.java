import java.util.*;

public class Main {
	
	public int solution(String str, char t) {
		int answer = 0;
		str=str.toUpperCase();
		t=Character.toUpperCase(t);
		for(char x : str.toCharArray()) {
			//toCharArray 문자 배열 객체 생성
			if(x==t) {
				answer ++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		char a = kb.next().charAt(0);;
		System.out.print(T.solution(str, a));
	}
}