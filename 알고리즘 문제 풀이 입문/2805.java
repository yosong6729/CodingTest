import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		int answer = 0;
		int lt = 0;
		int rt = max;
		int mid = 0;
		
		while(lt <= rt) {
			long sum = 0;
			mid = (lt + rt) / 2;
			
			for(int i = 0; i < n; i++) {
				if(arr[i] - mid > 0) {
					sum += arr[i] - mid; 
				}
			}
			
			if(m <= sum) {
				answer = mid;
				lt = mid + 1;
			}else if(m > sum) {
				rt = mid - 1;
			}
		}
		
		System.out.print(answer);
	}
}