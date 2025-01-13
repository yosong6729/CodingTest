import java.util.*;

public class Main {
	
	public int solution(int num, int[][] arr) {
		
		int max = Integer.MIN_VALUE;
		
		int sum1, sum2;
		for(int i = 0; i<num; i++) {
			sum1 = 0; sum2 = 0;
			for(int j = 0; j < num; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			max = Math.max(max, sum1);
			max = Math.max(max, sum2);
		}
		
		sum1 = 0; sum2 =0;
		for(int i = 0; i < num; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][num - 1 - i];
			max = Math.max(max, sum1);
			max = Math.max(max, sum2);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[][] arr = new int[num][num];
		for(int i = 0; i<num; i++) {
			for(int j =0; j < num; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(T.solution(num, arr));
	}
}
