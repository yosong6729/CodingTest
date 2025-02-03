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
	
	static int n, m, result = Integer.MAX_VALUE;
	static ArrayList<Point> pz;
	static ArrayList<Point> hm;
	static int[][] board;
	static int[] dis;
	public void DFS(int L, int n) {
		if(L == m) {
			int sum = 0;
			for(int i = 0; i < hm.size(); i ++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < m; j++) {
					min = Math.min((Math.abs(hm.get(i).x - pz.get(dis[j]).x) 
							+ Math.abs(hm.get(i).y - pz.get(dis[j]).y)), min);
				}
				sum += min;
			}
			result = Math.min(sum, result);
			return;
		}else {
			for(int i = n; i < pz.size(); i++) {
				dis[L] = i; //pz 인덱스
				DFS(L + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		board = new int[n][n]; 
		hm = new ArrayList<>();
		pz = new ArrayList<>();
		dis = new int[m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j] == 1) {
					hm.add(new Point(i, j));
				}else if(board[i][j] == 2) {
					pz.add(new Point(i, j));
				}
			}
		}
		
		T.DFS(0, 0);
		System.out.print(result);
	}
}
