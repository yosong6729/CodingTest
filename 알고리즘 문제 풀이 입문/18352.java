import java.util.*;
import java.io.*;



class Main {
	
	static int n, m, k, x;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	public static void BFS(int x) {
		
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(x);
		visited[x] = true;

		ArrayList<Integer> result = new ArrayList<>();
		int cnt = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				if(cnt == k) {
					for(int n : Q) {
						result.add(n);
					}
					break;
				}
				int n = Q.poll();
				for(int j = 0;  j < list.get(n).size(); j++) {
					if(!visited[list.get(n).get(j)]) {
						Q.offer(list.get(n).get(j));
						visited[list.get(n).get(j)] = true;
					}
				}
			}
			cnt++;
		}
		
		if(result.isEmpty()) {
			System.out.print(-1);
		}else {
			Collections.sort(result);
			StringBuilder sb = new StringBuilder();
			for(int n : result) {
				sb.append(n).append("\n");
			}
			System.out.print(sb);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		visited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		
		BFS(x);
	}
}