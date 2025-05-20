import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] pm;
	static int[] arr;
	static StringBuilder sb;
	public static void DFS(int L) {
		if(L == m) {
			for(int i = 0; i < m; i++) {
				sb.append(pm[i]).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			for(int i = 0; i < n; i++) {
				pm[L] = arr[i];
				DFS(L + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		pm = new int[m];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		DFS(0);
		
		System.out.print(sb);
	}
}
