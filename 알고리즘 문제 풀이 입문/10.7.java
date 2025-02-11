import java.util.*;

class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int cost;
	
	Edge(int v1, int v2, int cost){
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

class Main {
	
	static int[] unf;
	public static int find(int v) {
		if(v == unf[v]) {
			return v;
		}else {
			return unf[v] = find(unf[v]);
		}
	}
	
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa != fb) {
			unf[fa] = fb;
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int v = kb.nextInt();
		int e = kb.nextInt();
		
		unf = new int[v + 1];
		for(int i = 1; i <= v; i++) {
			unf[i] = i;
		}
		ArrayList<Edge> list = new ArrayList<>();
		
		for(int i = 0; i < e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			
			list.add(new Edge(a, b, c));
		}
		
		Collections.sort(list);
		int sum = 0;
		
		for(int i = 0; i < e; i++) {
			Edge a = list.get(i);
			int fa = find(a.v1);
			int fb = find(a.v2);
			if(fa != fb) {
				union(a.v1, a.v2);
				sum += a.cost;
			}
		}
		
		System.out.print(sum);
	}
}