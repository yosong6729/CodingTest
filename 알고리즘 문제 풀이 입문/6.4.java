import java.util.*;

public class Main {

	public ArrayList<Integer> solution(int s, int n, int[] arr) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int x : arr) {
			if(list.size() < s) {
				if(!list.contains(x)) {
					list.add(x);
				}else {
					for(int i = 0; i < list.size(); i++) {
						if(x == list.get(i)) {
							int idx = i;
							list.remove(idx);
							break;
						}
					}
					list.add(x);
				}
			}else {
				if(!list.contains(x)) {
					list.remove(0);
					list.add(x);
				}else {
					for(int i = 0; i < list.size(); i++) {
						if(x == list.get(i)) {
							int idx = i;
							list.remove(idx);
							break;
						}
					}
					list.add(x);
				}
			}
		}
		
		Collections.reverse(list);
		return list;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(s, n, arr)) {
			System.out.print(x + " ");
		}
	}
}
