import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long min1 = Integer.MAX_VALUE;
		int min1Idx = -1;
		long min2 = Integer.MAX_VALUE;
		int min2Idx = -1;
		long sum = 0;
		
		
		for(int i = 0; i < m; i++) {
			min1 = Long.MAX_VALUE;
			min1Idx = -1;
			min2 = Long.MAX_VALUE;
			min2Idx = -1;
			sum = 0;
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < n; k++) {
					if(j == 0) {
						if(min1 > arr[k]) {
							min1 = arr[k];
							min1Idx = k;
						}
					}else {
						if(min1Idx == k) {
							continue;
						}
						if(min2 > arr[k]) {
							min2 = arr[k];
							min2Idx = k;
						}
					}
				}
			}
			sum = min1 + min2;
			arr[min1Idx] = sum;
			arr[min2Idx] = sum;
		}
		
		long result = 0;
		
		for(long x : arr) {
			result += x;
		}
		
		System.out.print(result);
	}
}