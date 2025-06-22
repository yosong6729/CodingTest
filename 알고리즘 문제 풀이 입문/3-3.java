import java.util.*;
import java.io.*;

public class Main {
	
	public int[] solution(int[] arrival, int[] state){
		int[] answer = {};
		
		Queue<Integer> enter = new LinkedList<>();
		Queue<Integer> exit = new LinkedList<>();
		int n = arrival.length;
		answer = new int[n];
		
		int i = 0;
		int cnt = 0;
		int prev = 1;
		for(int t = 0; ;t++) {
			
			if(enter.isEmpty() && exit.isEmpty() && arrival[i] > t) {
				t = arrival[i];
				prev = 1;
			}
			
			while(i < n && arrival[i] <= t) {
				if(state[i] == 0) {
					enter.offer(i);
				}else{
					exit.offer(i);
				}
				i++;
			}
			
			if(prev == 1) {
				if(!exit.isEmpty()) {
					answer[exit.poll()] = t;
					prev = 1;
				}else {
					answer[enter.poll()] = t;
					prev = 0;
				}
			}else {
				if(!enter.isEmpty()) {
					answer[enter.poll()] = t;
					prev = 0;
				}else {
					answer[exit.poll()] = t;
					prev = 1;
				}
			}
			
			cnt++;
			if(cnt == n) {
				break;
			}
		}
		
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
	}
}
