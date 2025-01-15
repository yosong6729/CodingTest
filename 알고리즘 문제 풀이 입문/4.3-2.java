import java.util.*;

public class Main {
	
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < k - 1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		int lt = 0;
		for(int i = k - 1; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			result.add(map.size());
			map.put(arr[lt], map.get(arr[lt]) - 1);
			if(map.get(arr[lt]) == 0) {
				map.remove(arr[lt]);
			}
			lt++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, k, arr)) {
			System.out.print(x + " ");
		}
	}
}
