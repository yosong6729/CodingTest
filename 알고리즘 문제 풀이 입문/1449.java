import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())] = 1;
		}
		
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				for(int j = i ; j < i + l; j++) {
					if(j <= 1000) {
						arr[j] = 0;
					}
				}
				result++;
			}
		}
		
		System.out.print(result);
	}
}