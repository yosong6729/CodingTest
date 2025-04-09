import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] dis;
	static int max = Integer.MIN_VALUE;
	
	public static void BFS() {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(1);
		dis[1] = 0;
		visited[1] = true;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int x = Q.poll();
				for(int j = 0; j < list.get(x).size(); j++) {
					if(!visited[list.get(x).get(j)]) {
						visited[list.get(x).get(j)] = true;
						dis[list.get(x).get(j)] = dis[x] + 1;
						max = Math.max(max, dis[x] + 1);
						Q.offer(list.get(x).get(j));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		dis = new int[n + 1];
		
		list = new ArrayList<>();
		
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
		
		BFS();
		
		ArrayList<Integer> result = new ArrayList<>();
		int sameDis = 0;
		
		for(int i = 1; i <= n; i++) {
			if(dis[i] == max) {
				sameDis++;
				result.add(i);
			}
		}
		
		Collections.sort(result);
		
		System.out.print(result.get(0) + " " + max + " " + sameDis);
	}
}