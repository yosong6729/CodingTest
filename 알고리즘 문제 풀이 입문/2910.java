import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> hm = new LinkedHashMap<>();
		
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			hm.put(a, hm.getOrDefault(a, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<>(hm.keySet());
		
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				return hm.get(b) - hm.get(a);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for(int x : list) {
			for(int i = 0; i < hm.get(x); i++) {
				sb.append(x).append(" ");
			}
		}
		
		System.out.print(sb);
	}
}