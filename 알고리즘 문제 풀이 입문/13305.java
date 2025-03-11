import java.util.*;
import java.io.*;

class Main {
	
	static ArrayList<Integer> result = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		long[] gas = new long[n];
		long[] dis = new long[n - 1];
		long result = 0;
		
		for(int i = 0; i < n - 1; i++) {
			dis[i] = kb.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			gas[i] = kb.nextInt();
		}
		
		int j = 0;
		
		for(int i = 0; i < n - 1;i++) {
			result += gas[j] * dis[i];
			if(gas[j] > gas[i + 1]) {
				j = i + 1;
			}
		}
		
		System.out.print(result);
	}
}