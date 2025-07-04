import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[][] meetings){
		int answer = 0;
		
		ArrayList<int []> sM = new ArrayList<>();
		
		for(int i = 0; i < meetings.length; i++) {
			int startTime = meetings[i][0];
			int endTime = meetings[i][1];
			
			sM.add(new int[] {startTime, 1});
			sM.add(new int[] {endTime, 2});
		}
		
		Collections.sort(sM, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		
		
		int max = 0;
		for(int i = 0; i < sM.size(); i++) {
			if(sM.get(i)[1] == 1) {
				max++;
			}else {
				max--;
			}
			
			answer = Math.max(answer, max); 
		}
		
    	return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
		System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
	}
}
