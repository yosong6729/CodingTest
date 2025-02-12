import java.util.*;

class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		int[] dy = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		dy[0] = 1;
		int cnt = 0;
		int max = 0;
		for(int i = 1; i < n; i++) {
			for(int j = i; j >= 0; j--) {
				if(arr[i] > arr[j]) {
					int a = dy[j] + 1;
					max = Math.max(max, a);
					cnt++;
				}
			}
			if(cnt == 0) {
				dy[i] = 1;
				continue;
			}
			dy[i] = max;
			max = 0;
			cnt = 0;
		}
		
		max = 0;
		for(int x : dy) {
			max = Math.max(x, max);
		}
		
		System.out.print(max);
		
	}
}