import java.util.*;
import java.io.*;

class Main {
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		Stack<Integer> stack4 = new Stack<>();
		Stack<Integer> stack5 = new Stack<>();
		Stack<Integer> stack6 = new Stack<>();
		
		result = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(a) {
				case 1:
					melody(stack1, b);
					break;
				case 2:
					melody(stack2, b);
					break;
				case 3:
					melody(stack3, b);
					break;
				case 4:
					melody(stack4, b);
					break;
				case 5:
					melody(stack5, b);
					break;
				case 6:
					melody(stack6, b);
					break;
			}
		}
		
		System.out.print(result);
	}
	
	public static void melody(Stack<Integer> stack, int num) {
		if(stack.isEmpty()) {
			stack.push(num);
			result++;
			return;
		}else {
			if(stack.peek() == num) {
				return;
			}else if(stack.peek() < num) {
				stack.push(num);
				result++;
				return;
			}else {
				while(true) {
					if(stack.isEmpty()) {
						stack.push(num);
						result++;
						return;
					}
					if(stack.peek() == num) {
						break;
					}else if(stack.peek() > num) {
						stack.pop();
						result++;
					}else {
						stack.push(num);
						result++;
						return;
					}
				}
			}
			
		}
		
	}
}