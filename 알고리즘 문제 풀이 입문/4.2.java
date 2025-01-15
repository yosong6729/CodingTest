import java.util.*;

public class Main {
	
	public String solution(String a, String b) {
		
		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();

		String result = "YES";
	
		for(char x : a.toCharArray()) {
			mapA.put(x, mapA.getOrDefault(x, 0) + 1);
		}
		
		for(char x : b.toCharArray()) {
			mapB.put(x, mapB.getOrDefault(x, 0) + 1);
		}
		
		for(char x : mapA.keySet()) {
			if(mapB.get(x) == null) {
				result = "NO";
				break;
			}else {
				if(mapB.get(x) != mapA.get(x)) {
					result = "NO";
					break;
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		
		System.out.println(T.solution(a, b));
	}
}
