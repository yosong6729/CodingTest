import java.util.*;

public class Main {
	
	static int[][] graph;
	static ArrayList<ArrayList<Integer>> list;
	static int[] ch, dis;
	public int[] BFS(int v) {
		
		Queue<Integer> Q = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		Q.offer(v);
		
		while(!Q.isEmpty()) {
			int cv = Q.poll();
			for(int nv : list.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					dis[nv] = dis[cv] + 1;
					Q.offer(nv);
				}
			}
		}
		
		return dis;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		graph = new int[n + 1][n + 1];
		list = new ArrayList<>();
		
		for(int  i = 0; i <= n;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			list.get(a).add(b);
		}
		
		ch = new int[n + 1];
		dis = new int[n + 1];
		
		int[] result = T.BFS(1);
		for(int i = 2; i <= n; i++) {
			System.out.println(i + ":" + result[i]);
		}
	}
}
