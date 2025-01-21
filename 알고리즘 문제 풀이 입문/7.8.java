import java.util.*;

public class Main {

	static int e;
	public int BFS(int s) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(0);
		 
		int dist = s; // 현 위치
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		while(!Q.isEmpty()) {
			for(int i = 0; i < Q.size(); i++) {
				Q.poll();
				if(min > Math.abs(e - (dist + 1))) {
					min = Math.abs(e - (dist + 1));
				}
				if(min > Math.abs(e - (dist - 1))) {
					min = Math.abs(e - (dist - 1));
				}
				if(min > Math.abs(e - (dist + 5))) {
					min = Math.abs(e - (dist + 5));
				}
				if(min == Math.abs(e - (dist + 1))) {
					dist++;
				}else if(min == Math.abs(e - (dist - 1))){
					dist--;
				}else if(min == Math.abs(e - (dist + 5))) {
					dist += 5;
				}
				cnt++;
			}
			if(dist != e) {
				Q.offer(dist);
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		e = kb.nextInt();
		
		System.out.print(T.BFS(s));
	}
}
