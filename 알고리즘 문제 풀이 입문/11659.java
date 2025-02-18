import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n + 1];
		int[] sumArr = new int[n + 1];
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			arr[i] = kb.nextInt();
			sumArr[i] = arr[i] + sumArr[i - 1];
		}
		
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int sum = 0;
			sum = sumArr[b] - sumArr[a - 1];
			answer.add(sum);
		}
		
		for(int x : answer) {
			System.out.println(x);
		}
		
	}
}