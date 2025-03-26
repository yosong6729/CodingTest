import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			if(map.size() == 1) {
				for(String s : map.keySet()) {
					sb.append(map.get(s)).append("\n");
				}
			}else {
				int sum = 1;
				for(String s : map.keySet()) {
					sum *= (map.get(s) + 1);
				}
				sb.append(sum - 1).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}