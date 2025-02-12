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
	
	static ArrayList<ArrayList<Edge>> list;
	static int[] ch;
	static int answer = 0;
	public void solution() {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));
		
		while(!pQ.isEmpty()) {
			Edge e = pQ.poll();
			int now = e.vex;
			if(ch[now] == 0) {
				answer += e.cost;
				ch[now] = 1;
				for(Edge o : list.get(now)) {
					pQ.offer(new Edge(o.vex, o.cost));
				}
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int v = kb.nextInt();
		int e = kb.nextInt();
		list = new ArrayList<>();
		ch = new int[v + 1];
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			
			list.get(a).add(new Edge(b, c));
			list.get(b).add(new Edge(a, c));
		}
		T.solution();
		
		System.out.print(answer);
	}
}