import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		int[] sorted = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sorted[i] = kb.nextInt();
			
		}
		
		Arrays.sort(sorted);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int rank = 0;
		for(int i = 0; i < n; i++) {
			int x  = sorted[i];
			if(!map.containsKey(x)) {
				map.put(x, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < n; i++) {
			int x = arr[i];
			sb.append(map.get(x)).append(' ');
		}
		
		System.out.print(sb);
	}
}