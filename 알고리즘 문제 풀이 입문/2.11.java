import java.util.*;

public class Main {
	
	public int solution(int num, int[][] arr) {
		
		ArrayList<Integer> array = new ArrayList<>();
		
		int maxNum = 1;
		int max = 0;
		int a = 0;
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < num; k++) {
					if(i != k && arr[i][j] == arr[k][j]) {
						if(!array.contains(k + 1)) {
							array.add(k + 1);
						}
					}
				}
			}
			if(max < array.size()) {
				max = array.size();
				maxNum = i + 1;
			}
			array = new ArrayList<>();			
		}
		
		return maxNum;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[][] arr = new int[num][5];
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		
		System.out.println(T.solution(num, arr));
	}
}
