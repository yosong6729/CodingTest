import java.util.*;

public class Main {
	
	public String solution(int num, String str) {
		
		String result = "";
		
		for(int i = 0; i < num; i++) {
			String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
			int n = Integer.parseInt(tmp, 2);
			result += (char)n;
			str = str.substring(7);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		String str = kb.next();
		
		System.out.println(T.solution(num, str));
	}
}

