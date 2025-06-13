import java.util.*;
import java.io.*;

public class Main {

	public int solution(String s){
		int answer = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c : map.keySet()) {
			while(set.contains( map.get(c))) {
				map.put(c, map.get(c) - 1);
				answer++;
			}
			
			if(map.get(c) == 0) {
				continue;
			}
			set.add(map.get(c));
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}
