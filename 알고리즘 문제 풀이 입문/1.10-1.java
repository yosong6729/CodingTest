import java.util.*;

public class 1.10 {
	
	public String solution(String str) {
		
		String result = "";
		
		str = str + " ";
		int cnt = 1;
		
		for(int i = 0; i < str.length() - 1; i ++) {
			if(str.charAt(i) == str.charAt(i + 1)){
				cnt += 1;
			}else {
				result += str.charAt(i);
				if(cnt > 1) {
					result += cnt;
					cnt = 1;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//내가 처음에 푼것
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.println(T.solution(str));
	}
}
