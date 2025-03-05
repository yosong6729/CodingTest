import java.util.*;
import java.io.*;

class Main {
	
	static int n;
	static int[] arr;
	static int[] p;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int L, int sum) {
		if(L == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}else {
			for(int i = 0; i < 4; i++) {
					if(p[i] > 0) {
						p[i]--;
						if(i == 0) {
							DFS(L + 1, sum + arr[L]);
						}else if(i == 1) {
							DFS(L + 1, sum - arr[L]);
						}else if(i == 2) {
							DFS(L + 1, sum * arr[L]);
						}else if(i == 3) {
							DFS(L + 1, sum / arr[L]);
						}
						p[i]++;
					}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		arr = new int[n];
		p = new int[4];
		
		for(int i = 0 ; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int i = 0; i < 4; i++) {
			p[i] = kb.nextInt();
		}
		
		DFS(1, arr[0]);
		
		System.out.println(max);
		System.out.print(min);
	}
}