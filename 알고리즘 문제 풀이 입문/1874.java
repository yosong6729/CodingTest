import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		ArrayList<Character> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		int n = kb.nextInt();
		int start = 0;
		
		for(int i = 0; i < n; i++) {
			
			int value = kb.nextInt();
			
			if(start < value) {
				for(int j = start + 1; j <= value; j++) {
					stack.push(j);
					result.add('+');
					start = j;
				}
			}else {
				if(stack.peek() != value) {
					flag = false;
					System.out.print("NO");
					break;
				}
			}
			result.add('-');
			stack.pop();
		}
		
		if(flag) {
			for(char x : result) {
				System.out.println(x);
			}
		}
	}
}