import java.util.*;

class Main {
	
	static int n, m;
	static int[] arr;
	static int[] ch;
	static int[] pm;
 	public void DFS(int L) {
		if(L == m) {
			for(int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}else{
			for(int i = 0; i < n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		arr = new int[n];
		ch = new int[n];
		pm = new int[m];
		
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		T.DFS(0);
		
		
	}
}