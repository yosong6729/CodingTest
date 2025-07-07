import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] nums){
		int answer = 0;
		
		Arrays.sort(nums);
		
		int lt = 0;
		int rt = nums.length -1;
		
		while(lt < rt) {
			if(nums[lt] + nums[rt] <= 5) {
				answer++;
				lt++;
				rt--;
			}else {
				answer++;
				rt--;
			}
		}
		if(lt == rt) {
			answer++;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
		System.out.println(T.solution(new int[]{2, 3, 4, 5}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
	}
}
