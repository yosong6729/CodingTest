import java.util.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Main {


	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = kb.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		Queue<Point> Q = new LinkedList<>();
		int[] dx = {-1 , 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int a = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1) {
					sum++;
					Q.offer(new Point(i, j));
					arr[i][j] = 0;
					while(!Q.isEmpty()) {
						int len = Q.size();
						for(int q = 0; q < len; q++) {
							Point p = Q.poll();
							for(int k = 0; k < 4; k++) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if(nx >= 0 && nx < n && ny >=0 && ny < n 
										&& arr[nx][ny] == 1) {
									sum++;
									Q.offer(new Point(nx, ny));
									arr[nx][ny] = 0;
								}
							}
						}
					}
					list.add(sum);
					sum = 0;
					a++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(a);
		for(int x : list) {
			System.out.println(x);
		}
	}
}