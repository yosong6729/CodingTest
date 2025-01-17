import java.util.*;

public class Main {
	
	public int solution(String s) {
		
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> lazer = new ArrayList<>();
		
		int result = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				if(i - 1 == stack.peek()) {
					stack.pop();
					lazer.add(i);
				}else {
					int lt = stack.pop();
					int rt = i;
					boolean flag = false;
					for(; lt < i; lt++) {
						if(lazer.contains(lt)) {
							result++;
							flag = true;
						}
					}
					if(flag) result++;
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		
		System.out.print(T.solution(s));
		
	}
}
