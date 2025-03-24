import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		long result = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int idx = 1;
		for(int x : arr) {
			result += (long)Math.abs(x - idx);
			idx++;
		}
		
		System.out.print(result);
	}
}