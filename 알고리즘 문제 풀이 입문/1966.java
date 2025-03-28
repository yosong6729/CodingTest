import java.util.*;
import java.io.*;

class Print{
	int idx;
	int pri;
	
	Print(int idx , int pri){
		this.idx = idx;
		this.pri = pri;
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Print> Q = new LinkedList<>();
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				Q.offer(new Print(j, Integer.parseInt(st.nextToken())));
			}
			int cnt = 0;
			
			while(true) {
				Print p = Q.peek();
				int pri = p.pri;
				boolean flag = true;
				for(Print P : Q) {
					if(pri < P.pri) {
						Q.offer(Q.poll());
						flag = false;
						break;
					}
				}
				if(flag) {
					cnt++;
					if(Q.poll().idx == m) {
						break;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}