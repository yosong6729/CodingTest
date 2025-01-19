import java.util.*;

class Point implements Comparable<Point>{
	
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x != o.x) {
			return this.x - o.x; 
		}else {
			return this.y - o.y;
		}
	}
}

public class Main {

	public ArrayList<Point> solution(int n, int[][] arr) {
		
		ArrayList<Point> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new Point(arr[i][0], arr[i][1]));
		}
		Collections.sort(list);
		return list;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n;i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		for(Point p : T.solution(n, arr)) {
			System.out.println(p.x + " " + p.y);
		}
	}
}
