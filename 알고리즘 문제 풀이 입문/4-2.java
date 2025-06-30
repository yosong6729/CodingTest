import java.util.*;
import java.io.*;

public class Main {
	
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];
	
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int x : nums) {
			list.add(x);
		}
		
		list.sort((a, b) -> a - b);
		
		int idx = 0;
		
		while(!list.isEmpty()) {
			
			int n = list.get(0);
			if(list.contains(n * 2)) {
				answer[idx++] = n;
				list.remove(Integer.valueOf(n * 2));
				list.remove(0);
			}
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
