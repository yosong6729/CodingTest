import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			String str = br.readLine();
			
			List<Character> list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();
			
			for(char c : str.toCharArray()) {
				switch(c) {
				case '<':
					if(iter.hasPrevious()) {
						iter.previous();
					}
					break;
				case '>':
					if(iter.hasNext()) {
						iter.next();
					}
					break;
				case '-':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default:
					iter.add(c);
					break;
				}
			}
			
			for(char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}