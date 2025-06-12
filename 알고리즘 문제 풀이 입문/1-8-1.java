import java.util.*;
import java.io.*;

public class Main {

	public int[] solution(int[] enter, int[] exit){
		int[] answer = {};
		int n = enter.length;
		
		answer = new int[n];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			list.add(new int[n + 1]);
		}
		
		int[] room = new int[n + 1];
		
		int j = 0;
		for(int i = 0; i < n; i++) {
			int p = enter[i];
			
			room[p] = 1;
			
			for(int k = 1; k <= n; k++) {
				for(int q = k + 1; q <= n; q++) {
					if(room[k] == 1 && room[q] == 1) {
						list.get(k)[q] = 1;
						list.get(q)[k] = 1;
					}
				}
			}
			
			while(j < n && room[exit[j]] == 1) {
				room[exit[j]] = 0;
				j++;
			}
			
		}
		
		for(; j < n; j++) {
			if(room[exit[j]] == 1) {
				room[exit[j]] = 0;
				j++;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			int[] p = list.get(i);
			for(int k = 1; k <= n; k++) {
				if(p[k] == 1) {
					answer[i - 1]++;
				}
				
			}
		}
		
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
	}
}
