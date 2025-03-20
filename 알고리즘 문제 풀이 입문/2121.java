import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			hm.putIfAbsent(x, new HashSet<>());
			hm.get(x).add(y);
		}
		
		int result = 0;
		
		for(Map.Entry<Integer, HashSet<Integer>> entry: hm.entrySet()) {
			int x = entry.getKey();
			
			for(int y : entry.getValue()) {
				if(hm.containsKey(x + a) && hm.get(x + a).contains(y)
						&& entry.getValue().contains(y + b)
						&& hm.get(x + a).contains(y + b)) {
					result++;
				}
			}
		}
		
		System.out.print(result);
	}
}