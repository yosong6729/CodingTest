import java.util.*;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static ArrayList<Point> PList = new ArrayList<>();
	static ArrayList<Point> HList = new ArrayList<>();
	static ArrayList<Integer> minList = new ArrayList<>();
	static int n, m;
	static ArrayList<Point> d;

	public void DFS(int L, int n) {
		if(L == m) {
			int minSum = 0;
			for(int i = 0; i < HList.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < m; j++) {
					min = Math.min(Math.abs(HList.get(i).x - d.get(j).x) +
							Math.abs(HList.get(i).y - d.get(j).y), min);
				}
				minSum += min;
			}
			minList.add(minSum);
			return;
		}else {
			for(int i = n; i < PList.size(); i++) {
				d.add(new Point(PList.get(i).x, PList.get(i).y));
				DFS(L + 1, i + 1);
				d.remove(d.size() - 1);
			}
		}
	}
	
	public int solution(int n, int m, int[][] board) {
		
		DFS(0, 0);
		Collections.sort(minList);
		return minList.get(0);
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		d = new ArrayList<>();
		int[][] board = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j] == 1) {
					HList.add(new Point(i, j));
				}else if(board[i][j] == 2){
					PList.add(new Point(i, j));
				}
			}
		}
		
		System.out.print(T.solution(n, m, board));
	}
}
