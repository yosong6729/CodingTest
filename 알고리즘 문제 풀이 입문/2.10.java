import java.util.*;

public class Main {
	
	public int solution(int num, int[][] arr) {

		int answer = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				boolean flag = true;
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < num && ny >= 0 && ny < num && arr[i][j] <= arr[nx][ny]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					answer++;
				}
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		int[][] arr = new int[num][num];
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(T.solution(num, arr));
	}
}
