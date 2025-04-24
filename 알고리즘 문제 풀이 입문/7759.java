import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] A = new int[n];
			int[] B = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < n; k++) {
				A[k] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int q = 0; q < m; q++) {
				B[q] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			int result = 0;
			
			for(int j = 0; j < n; j++) {
				int num = A[j];
				
				int ans = 0;
				int lt = 0;
				int rt = m - 1;
				int mid = (lt + rt) / 2;
				while(lt <= rt) {
					
					mid = (lt + rt) / 2;
					
					if(B[mid] < num) {
						ans = mid + 1;
						lt = mid + 1;
					}else if(B[mid] >= num){
						rt = mid - 1;
					}
				}
				result += ans;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
		
		
	}
}