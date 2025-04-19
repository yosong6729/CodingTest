import java.util.*;
import java.io.*;

public class Main {
	
	static int[] answer;
	static int[] pm;
	static int result = 0;
	
	public static void DFS(int L, int sum) {
		
		if(L == 10) {
			if(sum >= 5) {
				result++;
			}
			return;
		}

		for(int i = 1; i <= 5; i++) {
			if(L >= 2) {
				if(pm[L - 1] == pm[L - 2] && pm[L - 1] == i) {
					continue;
				}
			}
			pm[L] = i;
			
			if(answer[L] == pm[L]) {
				DFS(L + 1, sum + 1);
			}else {
				DFS(L + 1, sum);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		pm = new int[10];
		answer = new int[10];
		for(int i = 0; i < 10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		
		System.out.print(result);
	}
}