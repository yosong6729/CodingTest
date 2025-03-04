import java.util.*;
import java.io.*;

class Main {
	
	static long a, b;
	static boolean flag;
	public static void BFS(long n) {
		Queue<Long> Q = new LinkedList<>();
		Q.offer(n);
		int L = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				long x = Q.poll();
				if(x == b) {
					flag = false;
					System.out.print(L + 1);
					break;
				}
				if(x * 2 <= b) {
					Q.offer(x * 2);
				}
				if((x * 10 + 1) <= b) {
					Q.offer(x * 10 + 1);
				}
			}
			if(!flag) {
				break;
			}
			L++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		a = kb.nextInt();
		b = kb.nextInt();
		flag = true;
		
		BFS(a);
		
		if(flag) {
			System.out.print(-1);
		}
	}
}