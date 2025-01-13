import java.util.*;

public class Main {
	
	public int solution(int num, int[] arr) {

		int plus = 0;
		int result = 0;
		for(int i = 0; i < num; i++) {
			if(arr[i] == 1) {
				plus++;
				result += plus;
			}else {
				plus = 0;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] arr = new int[num];
		for(int i = 0 ; i < num; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(num, arr));
	}
}
