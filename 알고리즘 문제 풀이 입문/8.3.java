import java.util.*;

public class Main {

	static int m, n;
	static int max = Integer.MIN_VALUE;
	public void DFS(int L, int sum, int time,int[][] arr) {
		if(time > m) {
			return;
		}
		if(L == n) {
			max = Math.max(max, sum);
			return;
		}else {
			DFS(L + 1, sum + arr[L][0], time + arr[L][1],arr);
			DFS(L + 1, sum, time, arr);
			
		}
			
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
	
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = kb.nextInt();
			arr[i][1] = kb.nextInt();
		}
		
		T.DFS(0, 0, 0,arr);
		
		System.out.print(max);
		
	}
}
