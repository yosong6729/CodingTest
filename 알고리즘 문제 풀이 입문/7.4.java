import java.util.*;

public class Main {

	
	public void DFS(int n, int[] arr) {
		if(n == 3) {
			arr[n - 1] = arr[n - 2] + arr[n - 3];
			System.out.print(arr[0] + " " + arr[n - 1] + " ");
			return;
		}else {
			DFS(n - 1, arr);
			arr[n - 1] = arr[n - 2] + arr[n - 3];
			System.out.print(arr[n - 1] + " ");
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		
		T.DFS(n, arr);
	}
}
