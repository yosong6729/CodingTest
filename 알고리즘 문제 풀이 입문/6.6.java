import java.util.*;

public class Main {

	public ArrayList<Integer> solution(int n, int[] arr) {
		
		ArrayList<Integer> result = new ArrayList<>();
		int[] arr2 = arr.clone();
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != arr2[i]) {
				result.add(i + 1);
			}
		}
		
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
		
		for(int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
		
		
	}
}
