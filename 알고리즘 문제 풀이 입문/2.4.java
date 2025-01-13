import java.util.*;

public class Main {
	
	public int[] solution(int num) {
		ArrayList<Integer> array = new ArrayList<>();
		
		int[] arr = new int[num];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i < num; i++) {
			arr[i] += arr[i-1] + arr[i-2];
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int num = kb.nextInt();
		
		for(int a : T.solution(num)) {
			System.out.print(a + " ");
		}
	}
}
