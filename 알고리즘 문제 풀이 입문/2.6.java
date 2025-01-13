import java.util.*;

public class Main {
	
	public boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public ArrayList<Integer> solution(int num, int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		int n = 0;
		for(int i = 0; i < num; i++) {
			n = 0;
			while(arr[i] > 0) {
				int tmp = arr[i] % 10;
				n = n*10 + tmp;
				arr[i] = arr[i] / 10;
			}
			if(isPrime(n)) {
				result.add(n);	
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int c : T.solution(num, arr)) {
			System.out.print(c + " ");
		}
	}
}
