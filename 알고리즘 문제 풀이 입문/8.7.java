import java.util.*;

public class Main {
	static int[][] dy;
	public int DFS(int n, int r) {
		if(dy[n][r] != 0) {
			return dy[n][r];
		}
		if(r == 1) {
			dy[n][1] = n;
			return n;
		}
		if(n == r) {
			dy[n][r] = 1;
			return 1;
		}else {
			return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int r = kb.nextInt();
		dy = new int[n + 1][r + 1];
		
		System.out.print(T.DFS(n ,r));
	}
}
