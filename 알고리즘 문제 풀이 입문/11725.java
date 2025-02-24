import java.util.*;

class Main {
	
	static int n;
	static ArrayList<ArrayList<Integer>> list;
	static Queue<Integer> Q = new LinkedList<>();
	static int[] result;
	static boolean[] visited;
	
	public static void BFS(int start) {
		Q.offer(start);
		visited[start] = true;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int cur = Q.poll();
				for(int x : list.get(cur)) {
					if(!visited[x]) {
						Q.offer(x);
						visited[x] = true;
						result[x] = cur;
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		list = new ArrayList<>();
		list.add(new ArrayList<>());
		result = new int[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i <=n ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		BFS(1);
		
		for(int i = 2; i <= n; i++) {
			System.out.println(result[i]);
		}
		
	}
}