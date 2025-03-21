import java.util.*;
import java.io.*;

class Main {
	
	static int n, result = 0;
	static int pm;
	static int[] roma = {1, 5 , 10, 50};;
	static HashSet<Integer> hs;
	
	public static void DFS(int L, int a, int sum) {
		if(L == n) {
			hs.add(sum);
			return;
		}else {
			for(int i = a; i <= 4; i++) {
				DFS(L + 1, i, sum + roma[i - 1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pm = 0;
		hs = new HashSet<>();
		
		DFS(0, 1, 0);
		
		System.out.print(hs.size());
	}
}