import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] nums){
		int answer = 0;
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int x : nums) {
			set.add(x);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int x : set) {
			list.add(x);
		}
		
		Collections.sort(list);
		
		answer = 1;
		int sum = 1;
		for(int i = 0 ; i < list.size() - 1; i++) {
			if((list.get(i) + 1) == (list.get(i + 1))) {
				sum++;
			}else {
				sum = 1;
			}
			answer = Math.max(answer, sum);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}
