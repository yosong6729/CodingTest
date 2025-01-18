import java.util.*;

public class Main {

	public int[] solution(int n, int[] arr) {
		int min = 0;
		int minId = 0;
		for(int i = 0; i < n - 1; i++) {
			min = arr[i];
			for(int j = i + 1; j < n; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minId = j;
				}
			}
			
			if(arr[i] != min) {
				int tmp = arr[i];
				arr[i] = arr[minId];
				arr[minId] = tmp;
			}
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
