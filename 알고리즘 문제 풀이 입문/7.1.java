import java.util.*;

public class Main {
// TODO: 6.9 다시 풀기, 6.10 다시 풀기
	
	public void factorial(int n) {
		if(n < 1) {
			return;
		}
		factorial(n - 1);
		System.out.print(n + " ");
	}
	public void solution(int n) {
		factorial(n);
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		T.solution(n);
	}
}
