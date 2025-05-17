import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int m = Integer.parseInt(br.readLine());
		
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		
		for(char c : str.toCharArray()) {
			left.offerLast(c);
		}
		
		for(int i = 0; i < m; i++){
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			
			if(c == 'P') {
				char t = st.nextToken().charAt(0);
				
				left.offer(t);
			}else if(c == 'L') {
				if(!left.isEmpty()) {
					right.offerFirst(left.pollLast());
				}
			}else if(c == 'D') {
				if(!right.isEmpty()) {
					left.offerLast(right.pollFirst());
				}
			}else if(c == 'B') {
				if(!left.isEmpty()) {
					left.pollLast();
				}
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(char x : left) {
			sb.append(x);
		}
		
		for(char x : right) {
			sb.append(x);
		}
		
		System.out.print(sb);
	}
}
