import java.util.*;

public class Main {

	static int[] ch, arr;
	static int[] list;
	static int n, m;
	public void DFS(int L) {
		if(L == m) {
			for(int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < n; i++) {
				if(ch[i] == 0) {
					list[L] = arr[i];
					ch[i] = 1;
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
		m = kb.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		ch = new int[n];
		list = new int[m];
		
		T.DFS(0);
		
	}
}
