import java.util.*;

public class Main {
	
	static int n, m;
	static int[] result;
	public void DFS(int L, int a) {
		if(L == m) {
			for(int i = 1; i <= m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			
			return;
		}else {
			for(int i = 1; i <= n; i++) {
				if(i > a) {
					result[L + 1] = i;
					DFS(L + 1, i);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		result = new int[m + 1];
		
		T.DFS(0, 0);
		
	}
}
