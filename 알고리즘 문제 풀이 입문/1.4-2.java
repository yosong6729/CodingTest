import java.util.*;

public class Main {
	
	public ArrayList<String> solution(int n, String[] str) {
		
		ArrayList<String> answer = new ArrayList<>();
		
		for(String x : str) {
			char[] s = x.toCharArray();
			for(int i = 0; i < s.length / 2; i++) {
				char tmp = s[i];
				s[i] = s[s.length - i -1];
				s[s.length - i - 1] = tmp;
			}
			
			answer.add(String.valueOf(s));
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int c = kb.nextInt();
		String[] str = new String[c];
		
		for(int i = 0; i < c; i++) {
			str[i] = kb.next();
		}
		
		
		for(String x : T.solution(c, str)) {
			System.out.println(x);
		}
	}
}