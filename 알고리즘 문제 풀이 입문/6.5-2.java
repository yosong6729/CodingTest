import java.util.*;

public class Main {

	public String solution(int n, int[] arr) {
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				return "D";
			}
		}
		
		return "U";
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, arr));
		
	}
}
