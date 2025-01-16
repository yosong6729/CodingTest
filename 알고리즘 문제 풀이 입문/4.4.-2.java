import java.util.*;

public class Main {
	
	public int solution(String s, String t) {
		
		int result = 0;
		HashMap<Character, Integer> amap = new HashMap<>();
		HashMap<Character, Integer> bmap = new HashMap<>();
		
		for(int i = 0; i < t.length() - 1; i++) {
			amap.put(s.charAt(i), amap.getOrDefault(s.charAt(i) , 0) + 1);
		}
		
		for(int i = 0; i < t.length(); i++) {
			bmap.put(t.charAt(i), bmap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int L = t.length() - 1;
		int lt = 0;
		
		for(int rt = L; rt < s.length(); rt++) {
			amap.put(s.charAt(rt), amap.getOrDefault(s.charAt(rt), 0) + 1);
			if(amap.equals(bmap)) {
				result++;
			}
			amap.put(s.charAt(lt), amap.get(s.charAt(lt)) - 1);
			if(amap.get(s.charAt(lt)) == 0) {
				amap.remove(s.charAt(lt));
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
