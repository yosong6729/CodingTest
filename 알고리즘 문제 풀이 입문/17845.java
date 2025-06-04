import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] imp = new int[k];
		int[] time = new int[k];
		
		int[] dpImp = new int[n + 1];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			imp[i] = a;
			time[i] = b;
		}
		
		for(int i = 0; i < k; i++) {
			for(int j = n; j >= time[i]; j--) {
				dpImp[j] = Math.max(dpImp[j], dpImp[j - time[i]] + imp[i]);
			}
		}
		
		int max = 0;
		for(int x : dpImp) {
			max = Math.max(max, x);
		}
		
		System.out.print(max);
	}
}
