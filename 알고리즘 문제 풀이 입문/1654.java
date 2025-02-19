import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int k = kb.nextInt();
		int n = kb.nextInt();
		int[] arr = new int[k];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < k; i++) {
			arr[i] = kb.nextInt();
			max = Math.max(max, arr[i]);
		}
	
		long lt = 1;
		long rt = max;
		long answer = 0;
		
		while(lt <= rt) {
			long mid = (lt + rt) / 2;
			long sum = 0;
			
			for(int x : arr) {
				if(x >= mid) {
					sum += x / mid;
				}
			}
			
			if(sum < n) {
				rt = mid - 1;
			}else if(sum >= n){
				answer = mid;
				lt = mid + 1;
			}
		}
		
		System.out.print(answer);
	}
}