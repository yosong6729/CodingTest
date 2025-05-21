import java.util.*;
import java.io.*;

public class Main {
	
	static int k;
	static int[] s;
	static int[] pm;
	static StringBuilder sb;
	
	public static void DFS(int L, int idx) {
		if(L == 6) {
			for(int x : pm) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			
			for(int i = idx + 1; i < k; i++) {
				pm[L] = s[i];
				DFS(L + 1, i);
			}
			
		}
			
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			
			s = new int[k];
			pm = new int[6];
			
			for(int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0, -1);
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
