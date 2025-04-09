import java.util.*;
import java.io.*;

class Main {
	
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> list;
	static int[] dis;
	
	public static void DFS(int x, int d) {
		for(int i = 0; i < list.get(x).size(); i++) {
			int n = list.get(x).get(i);
			if(dis[n] == -1) {
				dis[n] = d;
				DFS(n, d + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		dis = new int[n + 1];
		Arrays.fill(dis, -1);
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 0; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		
		
		dis[r] = 0;
		DFS(r, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(dis[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}