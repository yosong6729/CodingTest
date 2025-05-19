import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int result = Integer.MAX_VALUE;
	static int[] dis;
	
	public static void BFS(int x) {
		Queue<Integer> Q = new LinkedList<>();
		visited[x] = true;
		Q.offer(x);
		
		int sum = 0;
		int cnt = 0;
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			cnt = 0;
			for(int i = 0; i < len; i++) {
				int v = Q.poll();
				
				for(int j = 0; j < list.get(v).size(); j++) {
					if(!visited[list.get(v).get(j)]) {
						visited[list.get(v).get(j)] = true;
						Q.offer(list.get(v).get(j));
						cnt++;
					}
				}
			}
			sum += ((L + 1) * cnt); 
			L++;
		}
		min = Math.min(min,  sum);
		dis[x] = sum;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		list = new ArrayList<>();
		dis = new int[n + 1];
		
		
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
		
		for(int i = 1; i <= n; i++) {
			BFS(i);
			Arrays.fill(visited, false);
		}

		
		for(int i = 1; i <= n; i++) {
			if(min == dis[i] && result > i) {
				result = i;
			}
		}
		
		System.out.print(result);
	}
}
