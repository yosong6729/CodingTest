import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			int a = kb.nextInt();
			int b = 0;
			for(int j = 0; j < n; j++) {
				if(result[j] == 0) {
					b++;
				}
				if(a + 1 == b) {
					result[j] = i + 1;
					break;
				}
			}
		}	
		
		for(int x : result) {
			System.out.print(x + " ");
		}
	}
}