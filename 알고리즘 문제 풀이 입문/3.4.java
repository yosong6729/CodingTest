import java.util.*;

public class Main {
	
	public int solution(int n,int m, int[] arr) {
		
		int rt = 0;
		int lt = 0;
		int sum = 0;
		int result = 0;
		
		
		for(rt = 0; rt < n; rt++) {
			sum += arr[rt];
			while(sum >= m) {
				if(sum == m) {
					result++;
				}
				sum -= arr[lt];
				lt++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, m, arr));
	}
}
