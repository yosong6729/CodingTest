import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] nums, int k){
		int answer = 0;
		
		Integer[] sortNums = new Integer[nums.length];
		ArrayList<int[]> gapList = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			sortNums[i] = nums[i];
		}
		
		Arrays.sort(sortNums, Collections.reverseOrder());
		
		for(int i = 0; i < nums.length; i += 2) {
			int gap = sortNums[i] - sortNums[i + 1];
			
			gapList.add(new int[] {i, gap});
		}
		
		gapList.sort((a, b) -> b[1] - a[1]);
		
		for(int i = 0; i < k; i++) {
			set.add(gapList.get(i)[0]);
		}
		
		for(int i = 0; i < nums.length; i += 2) {
			if(set.contains(i)) {
				answer += sortNums[i]; 
			}else {
				answer += sortNums[i + 1];
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
		System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
		System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
		System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
		System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
	}
}
