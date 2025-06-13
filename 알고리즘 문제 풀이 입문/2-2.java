import java.util.*;
import java.io.*;

public class Main {

	public int[] solution(String s){
		int[] answer = new int[5];
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int max = 0;
		for(char c: map.keySet()) {
			
			int n = map.get(c);
			max = Math.max(max, n);
		}
		
		char x = 'a';
		for(int i = 0; i < 5; i++) {
			answer[i] = max - map.getOrDefault(x, 0);
			x++;
		}

		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
