import java.util.*;

public class Main {
	
	public char solution(int n, String sign) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		char result = ' ';
		
		for(char x : sign.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		for(char x : map.keySet()){
			if(max < map.get(x)) {
				max = map.get(x);
				result = x;
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String sign = kb.next();
		
		System.out.println(T.solution(n, sign));
	}
}
