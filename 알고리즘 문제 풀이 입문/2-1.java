import java.util.*;
import java.io.*;

public class Main {

	public int solution(String s){
		int answer = -1;

		HashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int i = 1;
		for(char c : map.keySet()) {
			if(map.get(c) == 1) {
				return i;
			}
			i++;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
