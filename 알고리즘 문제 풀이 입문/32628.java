import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Stack<Integer> aStack = new Stack<>();
		Stack<Integer> bStack = new Stack<>();
		
		long aWeigth = 0;
		long bWeigth = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			aStack.push(a);
			aWeigth += a;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int b = Integer.parseInt(st.nextToken());
			bStack.push(b);
			bWeigth += b;
		}
		
		for(int i = 0; i < k; i++) {
			if(aStack.isEmpty()) {
				if(!bStack.isEmpty()) {
					bWeigth -= bStack.pop();
					continue;
				}
			}
			
			if(bStack.isEmpty()) {
				if(!aStack.isEmpty()) {
					aWeigth -= aStack.pop();
					continue;
				}
			}
			
			long a = Math.max(aWeigth - aStack.peek(), bWeigth);
			long b = Math.max(bWeigth - bStack.peek(), aWeigth);
			
			if(a > b) {
				bWeigth -= bStack.pop();
			}else if(b > a) {
				aWeigth -= aStack.pop();
			}else {
				bWeigth -= bStack.pop();
			}
		}
		
		if(bWeigth > aWeigth) {
			System.out.print(bWeigth);
		}else{
			System.out.print(aWeigth);
		}
	}
}