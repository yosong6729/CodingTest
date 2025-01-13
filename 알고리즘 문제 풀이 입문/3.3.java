import java.util.*;

public class Main {
	
	public int solution(int n,int k, int[] arr) {
		int max = 0;
		int sum = 0;
		for(int i = 0; i < k; i++) {
			max += arr[i];
		}
		sum = max;
		
		for(int i = k; i < n; i++) {
			sum = sum + arr[i] - arr[i-k];
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, k, arr));
	}
}
