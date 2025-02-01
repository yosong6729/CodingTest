import java.util.*;

public class Main {
	
	static int n, f;
	static int[] ch, arr, d, a;
	static int[][] di;
	static int[] s;
	static Boolean flag = false;
	public void DFS(int L) {
		if(flag) {
			return;
		}
		if(L == n) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += a[i] * s[i];
			}
			if(sum == f) {
				for(int x : a) {
					System.out.print(x + " ");
				}
				flag = true;
			}
			return;
		}else {
			for(int i = 0; i < n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					a[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
		
		
	}
	
	public int COMB(int n, int r) {
		if(di[n][r] != 0) {
			return di[n][r];
		}
		
		if(n == r) {
			return di[n][r] = 1;
		}
		if(r == 0) {
			return di[n][r] = 1;
		}else {
			return di[n][r] = COMB(n - 1, r - 1) + COMB(n - 1, r);
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		f = kb.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		ch = new int[n];	
		di = new int[n][n];
		
		s = new int[n];
		a = new int[n];
		for(int i = 0; i < n; i++) {
			s[i] = T.COMB(n - 1, i);
		}
		
		T.DFS(0);
		
	}
}
