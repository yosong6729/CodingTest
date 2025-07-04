import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] nums, int m){
		int answer = 0;
		
		int[] sN = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			sN[i] = nums[i];
		}
		
		Arrays.sort(sN);
		
		int lt = 0;
		int rt = nums.length - 1;
		
		
		while(lt < rt) {
			
			if(sN[lt] + sN[rt] <= m) {
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
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}
}
