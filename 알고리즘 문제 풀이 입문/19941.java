import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		int result = 0;
		
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < n; i++) {
			if(arr[i] != 'P') {
				continue;
			}else {
				for(int j = -k; j <= k; j++) {
					if(i + j >= 0 && i + j < n) {
						char c = arr[i + j];
						if(j == 0) {
							continue;
						}
						if(c == 'H') {
							arr[i + j] = 'X';
							result++;
							break;
						}
					}
				}
			}
		}
		
		System.out.print(result);
	}
}