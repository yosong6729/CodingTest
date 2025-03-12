import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		String[] arr = new String[n + 1];
		
		for(int i = 1; i <= n; i++) {
			map.put(br.readLine(), i);
		}
		
		for(int i = 1; i <= n; i++) {
			arr[i] = br.readLine();
		}
		
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			int a = map.get(arr[i]);
			if(a > i) {
				result++;
			}
		}
		
		System.out.print(result);
	}
}