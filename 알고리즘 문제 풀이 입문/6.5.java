import java.util.*;

public class Main {

	public String solution(int n, int[] arr) {
		
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		
		if(set.size() != n) {
			return "D";
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
