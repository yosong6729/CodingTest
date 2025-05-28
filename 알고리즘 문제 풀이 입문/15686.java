import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int n, m;
	static int[][] arr;
	static ArrayList<Point> chiList;
	static ArrayList<Point> homeList;
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int idx, int L, ArrayList<Point> list) {
		
		if(L <= m && list.size() > 0) {
			int sum = 0;
			for(Point hp : homeList) {
				int hx = hp.x;
				int hy = hp.y;
				int minValue = Integer.MAX_VALUE;
				for(Point cP : list) {
					int cx = cP.x;
					int cy = cP.y;
					
					minValue = Math.min(minValue, Math.abs(cx - hx) + Math.abs(cy - hy));
				}
				sum += minValue;
			}
			min = Math.min(min, sum);
		}else if(L > m){
			return;
		}
			
		for(int i = idx; i < chiList.size(); i++) {
			list.add(chiList.get(i));
			DFS(i + 1, L + 1, list);
			list.remove(list.size() - 1);
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		chiList = new ArrayList<>();
		homeList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 2) {
					chiList.add(new Point(i, j));
				}else if(arr[i][j] == 1) {
					homeList.add(new Point(i, j));
				}
			}
		}
		
		DFS(0, 0, new ArrayList<>());
		
		System.out.print(min);
	}

}
