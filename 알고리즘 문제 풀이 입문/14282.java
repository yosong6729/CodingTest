import java.util.*;
import java.io.*;

public class Main {
	
	static int n, a, cnt;
	static int[] arr;
	static boolean[] visited;
	
	public static void DFS(int x) {

		if(x - arr[x] >= 1 && !visited[x - arr[x]]) {
			cnt++;
			visited[x - arr[x]] = true;
			DFS(x - arr[x]);
		}
		if(x + arr[x] <= n && !visited[x + arr[x]]) {
			cnt++;
			visited[x + arr[x]] = true;
			DFS(x + arr[x]);
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		cnt = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		a = Integer.parseInt(br.readLine());
		
		visited[a] = true;
		DFS(a);
		
		System.out.print(cnt);
	}
}
