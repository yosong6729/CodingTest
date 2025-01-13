import java.util.*;

public class Main {
	
	public int solution(int num) {
		int[] array = new int[num + 1];
		
		int result = 0;
		for(int i = 2; i <= num; i++) {
			if(array[i] == 0) {
				result++;
				for(int j = i; j <= num; j = j+i) {
					array[j] = 1;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		
		System.out.println(T.solution(num));
	}
}
