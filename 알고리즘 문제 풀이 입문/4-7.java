import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[][] meetings){
		int answer = 0;
		
		PriorityQueue<Integer> rooms = new PriorityQueue<>(
				(a, b) -> a - b);
		int[][] sM = new int[meetings.length][2];
		
		for(int i = 0; i < meetings.length; i++) {
			int a = meetings[i][0];
			int b = meetings[i][1];
			
			sM[i][0] = a;
			sM[i][1] = b;
		}
		
		Arrays.sort(sM, (a, b) -> a[0] - b[0]);
		
		rooms.offer(sM[0][1]);
		answer = 1;
		
		for(int i = 1; i < meetings.length; i++) {
			if(rooms.peek() <= sM[i][0]) {
				rooms.poll();
				rooms.offer(sM[i][1]);
			}else{
				rooms.offer(sM[i][1]);
			}
			answer = Math.max(answer, rooms.size());
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
