import java.util.*;

public class Main {
	
	public int solution(int num, int[] arr) {
		
		ArrayList<Integer> array = new ArrayList<>();
		int tall = arr[0];
		int result = 1;
		for(int i = 1; i < num; i++) {
			if(arr[i] > tall) {
				tall = arr[i];
				result += 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i<num; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(num, arr));
	}
}
