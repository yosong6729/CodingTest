import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int result = 0;		
			
			for(int j = 0; j < n; j++) {
				arr[j] = (Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(arr);
			
			for(int mid = 1; mid < n - 1; mid++) {
				int lt = mid - 1;
				int rt = mid + 1;
				
				while(lt >= 0 && rt < n) {
					
					int lDif = arr[mid] - arr[lt];
					int rDif = arr[rt] - arr[mid];
					
					if(lDif == rDif) {
						result++;
						lt--;
						rt++;
					}else if(lDif > rDif) {
						rt++;
					}else {
						lt--;
					}
				}
				
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}