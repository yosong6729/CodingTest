import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) {
				if(PQ.size() == 0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(PQ.poll()).append("\n");
				}
			}else {
				for(int j = 0; j < num; j++) {
					PQ.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		System.out.print(sb);
	}
}