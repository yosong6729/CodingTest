import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] result = new long[n];
		result[n - 1] = (long)arr[n - 1];
		
		for(int i = n - 2; i >= 0 ; i--) {
			if(arr[i] < result[i + 1]) {
				long j = 0;
				j = (result[i + 1] + (long)arr[i] - (long)1) / (long)arr[i];
				result[i] = (long)arr[i] * j;
			}else {
				result[i] = (long)arr[i];
			}
		}
		
		System.out.print(result[0]);
	}
}