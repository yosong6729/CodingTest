import java.util.*;

public class Main {

	static int n, m;
	static int[] pm ;
	public void DFS(int L) {
		if(L == m) {
			for(int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}else {
			for(int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		pm = new int[m];
		
		T.DFS(0);
	}
}
