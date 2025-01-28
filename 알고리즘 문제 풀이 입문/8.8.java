import java.util.*;

public class Main {
	
	static int[][] dy;
	static int[] d, arr, ch, list;
	static int n, f;
	static ArrayList<Integer[]> result;
	public int CDFS(int n, int r) {
		if(dy[n][r] != 0) {
			return dy[n][r];
		}
		if(r == 0) {
			return 1;
		}
		if(n == r) {
			return 1;
		}else {
			return dy[n][r] = CDFS(n - 1 , r - 1) + CDFS(n - 1, r);
		}
	}
	
	public void DFS(int L) {
		if(L == n) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += list[i] * d[i];
			}
			if(sum == f) {
				Integer[] a = new Integer[n];
				for(int j = 0; j < n; j++) {
					a[j] = list[j];
				}
				result.add(a);
			}
			return;
		}else {
			for(int i = 0; i < n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					list[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		f = kb.nextInt();
		arr = new int[n];
		ch = new int[n];
		list = new int[n];
		result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		dy = new int[n + 1][n + 1];
		d = new int[n];
		
		for(int i = 0; i < n; i++) {
			d[i] = T.CDFS(n - 1, i);
		}
		
		T.DFS(0);
		
		Integer[] a = result.get(0);
		
		for(int x : a) {
			System.out.print(x + " ");
		}
		

		
	}
}
