import java.util.*;

public class Main {

	public int[] solution(int s, int n, int[] arr) {
		
		int[] cache = new int[s];
		
		for(int i = 0; i < n; i++) {
			int a = 0;
			for(int j = 0; j < s; j++) {
				if(arr[i] == cache[j]) {
					a = j;
					break;
				}
			}
			if(a != 0) {
				for(int j = a; j > 0; j--) {
					cache[j] = cache[j-1];
				}
			}else {
				for(int j = s - 1; j > 0; j--) {
					cache[j] = cache[j - 1];
				}
			}
			cache[0] = arr[i];
			
		}
		
		return cache;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(s, n, arr)) {
			System.out.print(x + " ");
		}
		
		
	}
}
