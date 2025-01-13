import java.util.*;

public class Main {
	
	public ArrayList<Integer> solution(int num, int[] arr) {

		ArrayList<Integer> result = new ArrayList<>();
		int a = 1;
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(arr[i] < arr[j]) {
					a++;
				}
			}
			result.add(a);
			a = 1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] arr = new int[num];
		
		for(int i = 0; i< num; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(num, arr)) {
			System.out.print(x + " ");
		}
	}
}
