import java.util.*;

public class Main {
	
	int[] dis = {1, -1, 5};
 	int[] ch;
	public int BFS(int s, int e) {
	
		Queue<Integer> Q = new LinkedList<>();
		ch = new int[10001];
		ch[s] = 1;
		Q.offer(s);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				int x = Q.poll();
				for(int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					if(nx == e) {
						return L + 1; 
					}
					if(nx > 0 && nx < 10001 && ch[nx] == 0) {
						Q.offer(nx);
						ch[nx] = 1;
					}
				}
			}
			L++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		int e = kb.nextInt();
		
		System.out.print(T.BFS(s, e));
	}
}
