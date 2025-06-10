import java.util.*;
import java.io.*;

public class Main {

	public int solution(int[] nums){
		int answer = 0;
		
		ArrayList<Integer> peek = new ArrayList<>();
		
		for(int i = 1; i < nums.length - 1; i++) {
			if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peek.add(i);
			}
		}
		
		for(int x : peek) {
			
			int a = x;
			int b = x;
			
			int sum = 0;
			while(a - 1 >= 0 && nums[a] > nums[a - 1]) {
				sum++;
				a--;
			}
			
			while(b + 1 < nums.length && nums[b] > nums[b + 1]) {
				sum++;
				b++;
			}
			
			answer = Math.max(answer, sum + 1);
		}
		
		
		return answer;	
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}
