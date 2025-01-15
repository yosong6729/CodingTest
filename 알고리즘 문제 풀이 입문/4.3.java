import java.util.*;

public class Main {
	
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		array.add(map.size());
		int m = k;
		
		for(int i = k; i < n; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			
			if(map.get(arr[i - m]) == 1) {
				map.remove(arr[i - m]);
			}else if(map.get(arr[i - m]) > 1) {
				map.put(arr[i - m], map.get(arr[i - m]) - 1);
			}
			array.add(map.size());
		}
		
		return array;
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
