import java.util.*;

public class Main {

	static int n, c;
	static int max = 0;
	public void DFS(int L, int sum,int[] arr) {
		if(sum > c) {
			return;
		}
		if(L == n) {
			max = Math.max(max, sum);
			return;
		}else {
			DFS(L + 1, sum + arr[L], arr);
			DFS(L + 1, sum, arr);
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		c = kb.nextInt();
		n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		
		T.DFS(0, 0,arr);
		System.out.print(max);	
	}
}
