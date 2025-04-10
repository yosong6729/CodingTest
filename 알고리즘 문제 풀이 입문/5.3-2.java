import java.util.*;

public class Main {
	
	public int solution(int n, int[][] board, int m, int[] moves) {
		
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		
		for(int i = 0; i < m ; i++) {
			for(int j = 0; j < n; j++) {
				if(board[j][moves[i] - 1] != 0) {
					if(!stack.isEmpty() && stack.peek() == board[j][moves[i] - 1]) {
						result += 2;
						stack.pop();
						board[j][moves[i] - 1] = 0;
						break;
					}else {
						stack.push(board[j][moves[i] - 1]);
						board[j][moves[i] - 1] = 0;
						break;
					}
				}

			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		int m = kb.nextInt();
		int[] moves = new int[m];
		for(int i = 0; i < m; i++) {
			moves[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, board, m, moves));
		
	}
}
