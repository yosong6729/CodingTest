import java.util.*;

public class Main {

	public int[][] solution(int n, int[][] arr) {
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(arr[j][0] > arr[j + 1][0]) {
					int tmp = arr[j][0];
					arr[j][0] = arr[j + 1][0];
					arr[j + 1][0] = tmp;
					
					int tmp2 =arr[j][1];
					arr[j][1] = arr[j + 1][1];
					arr[j + 1][1] = tmp2;
				}else if(arr[j][0] == arr[j + 1][0]){
					if(arr[j][1] > arr[j + 1][1]) {
						int tmp = arr[j][0];
						arr[j][0] = arr[j + 1][0];
						arr[j + 1][0] = tmp;
						
						int tmp2 =arr[j][1];
						arr[j][1] = arr[j + 1][1];
						arr[j + 1][1] = tmp2;
					}
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		int[][] result = T.solution(n, arr);
		for(int i = 0; i < n; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
		
	}
}
