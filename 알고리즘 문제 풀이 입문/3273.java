import java.util.*;
import java.io.*;

class Main {


	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int x = kb.nextInt();
		
		Arrays.sort(arr);
		int j = arr.length - 1;
		int i = 0;
		int result = 0;
		
		while(i < j) {
			if((arr[i] + arr[j]) == x) {
				result++;
				i++;
			}else if((arr[i] + arr[j]) > x) {
				j--;
			}else {
				i++;
			}
		}
		
		System.out.print(result);
	}
	
}