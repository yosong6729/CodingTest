import java.util.*;

class Edge implements Comparable<Edge>{
	int vex;
	int cost;
	
	Edge(int vex, int cost){
		this.vex = vex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}


class Main {
	
	static int[] dis;
	public void solution(int n, int m, ArrayList<ArrayList<Edge>> graph){
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));
		
		while(!pQ.isEmpty()) {
			Edge e = pQ.poll();
			int now = e.vex;
			int nowCost = e.cost;
			if(dis[now] < nowCost) continue;
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int cost = kb.nextInt();
			graph.get(a).add(new Edge(b, cost));
		}
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		T.solution(n, m, graph);
		
		for(int i = 2; i < dis.length; i++) {
			if(dis[i] != Integer.MAX_VALUE) {
				System.out.println(i + " : " + dis[i]);
			}else {
				System.out.println(i + " : impossible");
			}
		}
	}
}