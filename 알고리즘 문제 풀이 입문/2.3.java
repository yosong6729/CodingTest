import java.util.*;

public class Main {
	
	public ArrayList<String> solution(int num, int[] A, int[] B) {
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < num; i++) {
			if(A[i] == B[i]) {
				result.add("D");
			}else if(A[i] == 1 && B[i] == 2){
				result.add("B");
			}else if(A[i] == 2 && B[i] == 3) {
				result.add("B");
			}else if(A[i] == 3 && B[i] == 1) {
				result.add("B");
			}else {
				result.add("A");
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[] A = new int[num];
		int[] B = new int[num];
		for(int i = 0; i < num; i++) {
			A[i] = kb.nextInt();
		}
		for(int i = 0; i < num; i++) {
			B[i] = kb.nextInt();
		}
		
		for(String c : T.solution(num,A, B)) {
			System.out.println(c);
		}
	}
}
