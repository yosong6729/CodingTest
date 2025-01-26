import java.util.*;

public class Main {
	
	static int total;
	static int sum;
	static int[] arr;
	static int n;
	static String result;
	public void DFS(int v) {
		if(v >= n) {
			return;
		}else {
			sum += arr[v];
			if((total - sum) == sum) {
				result = "YES";
			}
			DFS(v + 1);
			
			sum -= arr[v];
			if((total - sum) == sum) {
				result = "YES";
			}
			
			DFS(v + 1);
		}
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		result = "NO";
		T.DFS(0);
		System.out.print(result);
		
	}
}
