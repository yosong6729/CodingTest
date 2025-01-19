import java.util.*;

public class Main {

	public int solution(int n, int m, int[] arr) {

		Arrays.sort(arr);
		int result = 0;
		int lt = 0;
		int rt = n - 1;
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(arr[mid] == m) {
				result = mid + 1;
				break;
			}else if(arr[mid] > m) {
				rt = mid - 1;
			}else {
				lt = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.print(T.solution(n, m , arr));
	}
}
