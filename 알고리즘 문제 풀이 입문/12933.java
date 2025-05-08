import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char[] duck = {'q', 'u', 'a', 'c', 'k'};
		List<Integer> list = new ArrayList<>();
		for(int c : str.toCharArray()) {
			
			boolean flag = false;
			for(int i = 0; i < list.size(); i++) {
				
				if(duck[list.get(i)] == c) {
					list.set(i, (list.get(i) + 1) % 5);
					flag = true;
					break;
				}
			}
			
			if(flag) {
				continue;
			}
			
			if(c == 'q') {
				list.add(1);
			}else {
				System.out.print(-1);
				return;
			}
		}
		
		for(int x : list) {
			if(x != 0) {
				System.out.print(-1);
				return;
			}
		}
		
		System.out.print(list.size());
	}
}
