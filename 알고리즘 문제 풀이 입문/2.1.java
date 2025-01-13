import java.util.*;

public class Main {
	
	public ArrayList<Integer> solution(int num, int[] arr) {
		
		ArrayList<Integer> array = new ArrayList<>();
		array.add(arr[0]);
		
		for(int i = 1; i < num; i++) {
			if(arr[i] > arr[i - 1]) {
				array.add(arr[i]);
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int n : T.solution(num, arr)) {
			System.out.print(n + " ");
		}		
	}
}
