import java.util.*;
import java.io.*;

class Main {
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stacks = new Stack[7];
		
		for(int i = 1; i <= 6; i++) {
			stacks[i] = new Stack<>();
		}
		
		result = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			
			while(!stacks[line].isEmpty() && stacks[line].peek() > fret) {
				stacks[line].pop();
				result++;
			}
			
			if(stacks[line].isEmpty() || stacks[line].peek() < fret) {
				stacks[line].push(fret);
				result++;
			}
		}
		
		System.out.print(result);
	}
	
	
}