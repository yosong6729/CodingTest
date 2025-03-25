import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		
		int lt = 0;
		int max = Integer.MIN_VALUE;
		
		for(int rt = 0; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			
			while(map.size() > 2) {
				map.put(arr[lt], map.get(arr[lt]) - 1);
				if(map.get(arr[lt]) == 0) {
					map.remove(arr[lt]);
				}
				lt++;
			}
			
			max = Math.max(max, rt - lt + 1);
		}
		
		System.out.print(max);
	}
}