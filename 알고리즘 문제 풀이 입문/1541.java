import java.util.*;
import java.io.*;


class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sub = br.readLine().split("-");
		int result = 0; 
		
		if(sub.length == 1) {
			String[] s = sub[0].split("\\+");
			for(String  a : s) {
				result += Integer.parseInt(a);
			}
		}else {
			String[] a = sub[0].split("\\+");
			for(String s : a) {
				result += Integer.parseInt(s);
			}
			
			for(int i = 1; i < sub.length; i++) {
				String[] b = sub[i].split("\\+");
				for(String s : b) {
					result -= Integer.parseInt(s);
				}
			}
			
		}
		
		System.out.print(result);
	}
}