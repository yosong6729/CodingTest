import java.util.*;
import java.io.*;

class Main {
	static int n, s, result = 0;
	static int[] arr;
	public static void DFS(int idx, int sum) {
		if(idx == n) {
			if(sum == s) {
				result++;
			}
			return;
		}
		
		DFS(idx + 1, sum + arr[idx]);
		DFS(idx + 1, sum);
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		s = kb.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		DFS(0, 0);
		
		if(s == 0) {
			result--;
		}
		
		System.out.print(result);
	}
}