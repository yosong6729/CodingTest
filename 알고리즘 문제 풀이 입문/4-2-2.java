import java.util.*;
import java.io.*;

public class Main {
	
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];
	
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int x : nums) {
			list.add(x);
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		list.sort((a, b) -> a - b);
		
		int idx = 0;
		
		for(int x : list) {
			if(map.get(x) == 0) {
				continue;
			}
			
			map.put(x, map.get(x) - 1);
			map.put(x * 2, map.get(x * 2) - 1);
			
			answer[idx++] = x;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}
