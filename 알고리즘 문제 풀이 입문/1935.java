import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		double[] values = new double[n];
		
		for(int i = 0 ; i < n; i++) {
			values[i] = Double.parseDouble(br.readLine());
		}
		
		
		
		Stack<Double> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c == '*') {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b * a);
			}else if( c == '/') {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b / a);
			}else if(c == '+') {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b + a);
			}else if(c == '-') {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b - a);
			}else {
				stack.push(values[c - 'A']);
			}
		}
		
		System.out.printf("%.2f",stack.peek());
	}
}