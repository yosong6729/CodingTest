import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
	int n;
	int idx;

	Point(int n, int idx){
		this.n = n;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.n == o.n) {
			return o.idx - this.idx;
		}else {
			return o.n - this.n;
		}
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int[] ch = new int[n];
			
			Point[] sortedArr = new Point[n];
			for(int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[j] = a;
				sortedArr[j] = new Point(a, j);
			}
			
			Arrays.sort(sortedArr);
			long result = 0;
			
			for(Point p : sortedArr) {
				int idx = p.idx;
				int num = p.n;
				long sum = 0;
				
				while(idx >= 0 && ch[idx] == 0 && arr[idx] <= num) {
					ch[idx] = 1;
					sum += (long)num - (long)arr[idx];
					idx--;
				}
				result += sum;
			}
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}