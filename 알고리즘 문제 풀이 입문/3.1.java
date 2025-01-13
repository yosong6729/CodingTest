import java.util.*;

public class Main {
	
	public int[] solution(int n,int m, int[] arr, int[] arr2) {
			
		int[] result = new int[n + m];
		
		for(int i = 0; i < n; i++) {
			result[i] = arr[i];
		}
		int i =0;
		for(int j = n; j < n + m; j++) {
			result[j] = arr2[i];
			i++;
		}
		
		Arrays.sort(result);
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int m = kb.nextInt();
		int[] arr2 = new int[m];
		for(int j = 0; j < m; j++) {
			arr2[j] = kb.nextInt();
		}

		for(int x : T.solution(n, m, arr, arr2)) {
			System.out.print(x + " ");
		}
	}
}
