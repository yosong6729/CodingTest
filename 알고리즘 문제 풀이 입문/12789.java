import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		Queue<Integer> Q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			Q.offer(kb.nextInt());
		}
		
		int lineN = 1;
		
		while(!Q.isEmpty()) {
			if(!stack.isEmpty() && stack.peek() == lineN) {
				stack.pop();
				lineN++;
			}else {
				if(Q.peek() == lineN) {
					Q.poll();
					lineN++;
				}else {
					stack.push(Q.poll());
				}
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() != lineN) {
				break;
			}else {
				stack.pop();
				lineN++;
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.print("Sad");
		}else {
			System.out.print("Nice");
		}
	}
}