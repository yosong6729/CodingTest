import java.util.*;

class Main {
	
	static int[] unif;
	public int find(int v) {
		if(v == unif[v]) {
			return v;
		}else {
			return unif[v] = find(unif[v]);
		}
		
	}
	
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa != fb) {
			unif[fa] = fb;
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		unif = new int[n + 1];
		for(int i = 1; i < n; i++) {
			unif[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			T.union(a, b);
		}
		
		int fa = T.find(kb.nextInt());
		int fb = T.find(kb.nextInt());
		
		if(fa == fb) {
			System.out.print("YES");
		}else {
			System.out.print("NO");
		}
	}
}