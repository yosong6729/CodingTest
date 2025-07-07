import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int n, int[] nums){
		int answer = 0;
		
		int[][] spring = new int[n + 1][2];
		
		for(int i = 0; i <= n; i++) {
			int a = nums[i];
			int s = Math.max(0, i - a);
			int e = Math.min(n, i + a);
			
			spring[i][0] = s;
			spring[i][1] = e;
		}
		
		Arrays.sort(spring, (a, b) -> a[0] - b[0]);
		
		int s = 0;
		int e = 0;
		int i = 0;
		while(i <= n) {
			while(i <= n && spring[i][0] <= s) {
				e = Math.max(e, spring[i][1]);
				i++;
			}
			answer++;
			if(e == n) {
				break;
			}
			if(s == e) {
				return -1;
			}
			s = e;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));		
		System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
		System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}
}
