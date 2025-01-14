import java.util.*;

public class Main {
	
	public int solution(int n, int k,int[] arr) {
		
		int max = 0;
		int length = 0;
		int lt = 0;
		int cnt = 0;
		
		for(int rt = 0; rt < n; rt++) {
			
			if(arr[rt] == 0) {
				cnt++;
			}
			while(cnt > k) {
				if(arr[lt] == 0) {
					cnt--;
				}
				lt++;
			}
			length = rt - lt + 1;
			max = Math.max(max, length);
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
		
		System.out.println(T.solution(n, k,arr));
	}
}
