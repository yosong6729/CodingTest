import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int k = kb.nextInt();
		int max = Integer.MIN_VALUE;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += arr[i];
		}
		max = Math.max(max, sum);
		
		for(int i = k; i < n; i++) {
			sum += arr[i];
			sum -= arr[i - k];
			max = Math.max(max, sum);
		}
		
		System.out.print(max);
	}
}