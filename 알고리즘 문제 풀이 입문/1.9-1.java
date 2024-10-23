import java.util.*;

public class Main {
	
	public String solution(String str, Character ch) {
		String result = "";
		
		int lt, rt, ltCount = 0, rtCount = 0;
		for(int i = 0; i < str.length(); i++) {
			lt = i;
			rt = i;
			if(str.charAt(i) == ch) {
				result += 0 + " ";
				continue;
			}
			while(true) {
				if(lt > 0) {
					lt--;
					ltCount++;
					if(str.charAt(lt) == ch) {
						result += ltCount + " ";
						ltCount = 0;
						rtCount = 0;
						break;
					}
				}
				if(rt < str.length() - 1) {
					rt++;
					rtCount++;
					if(str.charAt(rt) == ch) {
						result += rtCount + " ";
						ltCount = 0;
						rtCount = 0;
						break;
					}
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
		Character ch = kb.next().charAt(0);
		
		System.out.print(T.solution(str, ch));
	}
}
