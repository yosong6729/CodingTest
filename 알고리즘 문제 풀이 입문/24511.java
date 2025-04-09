import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] type = new int[n];
		int[] B = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> DQ = new ArrayDeque<>(); 
		for(int i = 0; i < n; i++) {
			if(type[i] == 0) {
				DQ.offerFirst(B[i]);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			DQ.offerLast(num);
			sb.append(DQ.poll()).append(" ");
		}
		
		System.out.print(sb);
	}
}