import java.util.*;
import java.io.*;

public class Main {

	public int solution(String s){
		int answer = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		boolean flag = false;
		for(char c : map.keySet()) {
			
			while(true) {
				flag = false;
				int n = map.get(c);
				for(char a : map.keySet()) {
					if(a != c) {
						int t = map.get(a);
						if(n == t && t != 0) {
							flag = true;
							answer++;
							map.put(c, map.get(c) - 1);
							
							break;
						}
					}
				}
				if(!flag || map.get(c) == null) {
					break;
				}
			}
			
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
