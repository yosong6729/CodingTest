import java.util.*;

public class Main {
	
	public int[] solution(String str, char t) {
		int[] array = new int[str.length()];
		int p = 1000;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == t) {
				array[i] = 0;
				p = 0;
			}else {
				p++;
				array[i] = p;
			}
		}
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == t) {
				p = 0;
			}else {
				p++;
				array[i] = Math.min(array[i], p);
			}
		}
		return array;
		
	}
	
	public static void main(String[] args) {
		//내가 처음에 푼것
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char t = kb.next().charAt(0);
		
		int[] result = T.solution(str, t);
		for(int i = 0; i < str.length(); i++) {
			System.out.print(result[i] + " ");
		}
	}
}
