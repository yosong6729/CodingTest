import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		int i = 0;
		while(Math.pow(2, i) < k) {
			i++;
		}
		
		int n = (int)(Math.pow(2, i));
		StringBuilder sb = new StringBuilder();
		sb.append(n).append(" ");
		int cnt = 0;
		
		while(k > 0) {
			if(n <= k) {
				k -= n;
			}else {
				n /= 2;
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.print(sb);
	}
}