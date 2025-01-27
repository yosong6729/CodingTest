import java.util.*;

public class Main {

	static int n, m;
	static int min = Integer.MAX_VALUE;
	static Integer[] arr;
	public void DFS(int L, int sum) {
		if(L >= min) {
			return;
		}
		if(sum >= m) {
			if(sum == m) {
				min = Math.min(min, L);
			}else {
				return;
			}
		}else {
			for(int i = 0; i < n; i++) {
				DFS(L + 1, sum + arr[i]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		arr = new Integer[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		m = kb.nextInt();
		T.DFS(0, 0);
		
		System.out.print(min);
		
	}
}
