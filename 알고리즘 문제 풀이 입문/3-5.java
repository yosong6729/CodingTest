import java.util.*;
import java.io.*;

public class Main {
	
	public int[] solution(int[][] tasks){
		int n = tasks.length;
		int[] answer = new int[n];
		
		LinkedList<int[]> list = new LinkedList<>();
		PriorityQueue<int[]> PQ = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		for(int i = 0; i < n; i++) {
			int callT = tasks[i][0];
			int execT = tasks[i][1];
			
			list.add(new int[] {callT, execT, i});
		}
		
		list.sort((a, b) -> a[0] - b[0]);
		int[] a = list.pollFirst();
		PQ.offer(new int[]{a[1], a[2]});
		int ft = a[0];
		
		int idx = 0;
		
		while(!list.isEmpty() || !PQ.isEmpty()) {

			while(!list.isEmpty() && list.peekFirst()[0] <= ft) {
				int[] b = list.pollFirst();
				PQ.offer(new int[]{b[1], b[2]});
			}
			
			if(!list.isEmpty() && PQ.isEmpty()) {
				int[] b = list.pollFirst();
				PQ.offer(new int[]{b[1], b[2]});
				ft = b[0];
			}
			
			int[] p = PQ.poll();
			answer[idx++] = p[1];
			ft += p[0];
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
	}
}
