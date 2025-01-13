import java.util.*;

public class Main {
	
	public ArrayList<Integer> solution(int n,int m, int[] arr, int[] arr2) {

		ArrayList<Integer> result = new ArrayList<>();
		
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < n && p2 < m) {
			if(arr[p1] < arr2[p2]) {
				p1++;
			}else if(arr[p1] == arr2[p2]) {
				result.add(arr[p1]);
				p1++;
				p2++;
			}else {
				p2++;
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
