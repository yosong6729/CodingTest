import java.util.*;

public class Main {
	
	public int solution(int n, int[] arr) {
		
		int sum = 0;
		int lt = 0;
		int result = 0;
		
		for(int rt = 0; rt < n / 2 + 1; rt++){
			sum += arr[rt];
			while(sum >= n) {
				if(sum == n) {
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
		int[] arr = new int[n];
		
		for(int i = 0; i < n / 2 + 1; i++) {
			arr[i] = i + 1;
		}
		
		System.out.println(T.solution(n, arr));
	}
}
