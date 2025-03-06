import java.util.*;
import java.io.*;

class Point{
	int t;
	int w;
	Point(int t, int w){
		this.t = t;
		this.w = w;
	}
}

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int w = kb.nextInt();
		int L = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		Queue<Point> Q = new LinkedList<>();
		int curTime = 1;
		Q.offer(new Point(curTime, arr[0]));
		int sum  = arr[0];
		int i = 1;
		
		while(!Q.isEmpty()) {
			curTime++;
			if(!Q.isEmpty() && (Q.peek().t + w) == curTime) {
				sum -= Q.poll().w;
			}
			
			if(i < n && sum + arr[i] <= L) {
				Q.offer(new Point(curTime, arr[i]));
				sum += arr[i];
				i++;
			}
		}
		
		System.out.print(curTime);
		
	}
}