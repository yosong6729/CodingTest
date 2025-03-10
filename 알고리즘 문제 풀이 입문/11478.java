import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		String s = kb.next();
		
		int lt = 0;
		int rt = 1;
		int len = 1;
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j <= s.length(); j++) {
				hs.add(s.substring(i, j));
			}
		}
		
		System.out.print(hs.size());
	}
}