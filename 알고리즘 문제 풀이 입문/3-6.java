import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int n, int[][] meetings){
		int answer = Integer.MAX_VALUE;  
		int len = meetings.length;
		LinkedList<int[]> list = new LinkedList<>();
		TreeSet<Integer> rooms = new TreeSet<>();
		PriorityQueue<int[]> PQ = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int[] res = new int[n];
		
		
		for(int i = 0; i < len; i++) {
			int a = meetings[i][0];
			int b = meetings[i][1];
			list.add(new int[] {a, b});
		}
		
		list.sort((a, b) -> a[0] - b[0]);
		for(int i = 0; i < n; i++) {
			rooms.add(i);
		}
		
		while(!list.isEmpty()) {
			
			while(!PQ.isEmpty() && PQ.peek()[0] <= list.peek()[0]) {
				int rm = PQ.poll()[1];
				rooms.add(rm);
			}
			
			if(!rooms.isEmpty()) {
				int rm = rooms.pollFirst();
				int ft = list.pollFirst()[1];
				PQ.offer(new int[] {ft, rm});
				res[rm]++;
			}else {
				int[] x = PQ.poll();
				int ft = x[0];
				int rm = x[1];
				
				int[] listX = list.poll();
				
				PQ.offer(new int[] {ft + listX[1] - listX[0], rm});
				res[rm]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(max < res[i]) {
				max = res[i];
				answer = i;
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
		System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
	}
}
