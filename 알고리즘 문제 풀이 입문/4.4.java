import java.util.*;

public class Main {
	
	public int solution(String s, String t) {
		
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> tmap = new HashMap<>();
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int lt = 0;
		
		for(int i = 0; i < t.length() - 1; i++) {
			map.put(sArray[i], map.getOrDefault(sArray[i], 0) + 1);
		}
		
		for(int i = 0; i < t.length(); i++) {
			tmap.put(tArray[i], tmap.getOrDefault(tArray[i], 0) + 1);
		}
		
		for(int rt = t.length() - 1; rt < s.length(); rt++) {
			map.put(sArray[rt], map.getOrDefault(sArray[rt], 0) + 1);
			boolean flag = true;
			for(char x : tmap.keySet()) {
				if(!map.containsKey(x) || tmap.get(x) != map.get(x)) {
					flag = false;
					break;
					
				}
			}
			if(flag) {
				result++;
			}
			map.put(sArray[lt], map.get(sArray[lt]) - 1);
			if(map.get(sArray[lt]) == 0) {
				map.remove(sArray[lt]);
			}
			lt++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		String t = kb.next();
		
		System.out.print(T.solution(s, t));
	}
}
