import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		int result = n;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[j].startsWith(arr[i])) {
					result--;
					break;
				}
			}
		}
		
		System.out.print(result);
	}
}