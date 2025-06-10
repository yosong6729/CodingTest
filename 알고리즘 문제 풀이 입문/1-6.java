import java.util.*;
import java.io.*;

public class Main {
	
	public static int getMin(int[] fruit) {
		
		int min = Integer.MAX_VALUE;;
		for(int x : fruit) {
			min = Math.min(min, x);
		}
		
		return min;
	}
	
	public static boolean uniqueIdx(int[] fruit, int min) {
		
		int cnt = 0;
		for(int x : fruit) {
			if(min == x) {
				cnt++;
			}
		}
		
		if(cnt == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static int getMinIdx(int[] fruit, int min) {
		
		int i = 0;
		for(int x : fruit) {
			if(x == min) {
				return i;
			}
			i++;
		}
		return i;
	}

	public int solution(int[][] fruit){
		int answer = 0;
		
		int n = fruit.length;
		boolean[] visited = new boolean[n];
		
		
		for(int i = 0; i < n; i++) {
			int aMin = getMin(fruit[i]);
			if(!uniqueIdx(fruit[i], aMin)) {
				continue;
			}
			if(visited[i]) {
				continue;
			}
			int aIdx = getMinIdx(fruit[i], aMin);
			for(int j = i + 1; j < n; j++) {
				int bMin = getMin(fruit[j]);
				if(!uniqueIdx(fruit[j], bMin)) {
					continue;
				}
				if(visited[j]) {
					continue;
				}
				int bIdx = getMinIdx(fruit[j], bMin);
				
				if(aIdx != bIdx &&
						fruit[i][bIdx]> 0 && fruit[j][aIdx] > 0 &&
						fruit[i][aIdx] + 1 <= fruit[i][bIdx] - 1
						&& fruit[j][bIdx] + 1 <= fruit[j][aIdx] - 1) {
					fruit[i][aIdx]++;
					fruit[i][bIdx]--;
					fruit[j][bIdx]++;
					fruit[j][aIdx]--;
					visited[i] = true;
					visited[j] = true;
					
					break;
				}
			}
		}
		
		for(int[] x : fruit) {
			answer += getMin(x);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}
