import java.util.*;

class Main {
	
	static int[] s = new int[2];
	static int[][] ch;
	public int DFS(int n) {
		if(ch[n][0] != 0) {
			s[0] += ch[n][1];
			s[1] += ch[n][2];
			return s[0] + s[1];
		}
		if(n == 0) {
			ch[n][0] = 1;
			ch[n][1] += 1;
			s[0] += 1;
			return 0;
		}else if(n == 1) {
			ch[n][0] = 1;
			ch[n][2] += 1;
			s[1] += 1;
			return 1;
		}else {
			int x = DFS(n - 1) + DFS(n - 2);
			ch[n][0] = 1;
			ch[n][1] = ch[n - 1][1] + ch[n - 2][1];
			ch[n][2] = ch[n - 1][2] + ch[n - 2][2];
			return x;
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ch = new int[41][3];
		int[][] result = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			int a = kb.nextInt();
			T.DFS(a);
			result[i][0] = s[0];
			result[i][1] = s[1];
			Arrays.fill(s, 0);
		}
		
		for(int[] x : result) {
			System.out.println(x[0] + " " + x[1]);
		}
	}
}