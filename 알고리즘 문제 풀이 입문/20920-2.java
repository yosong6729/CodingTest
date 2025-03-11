import java.util.*;
import java.io.*;

class Main {
	
	static ArrayList<Integer> result = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.length() >= m) {
				hm.put(s, hm.getOrDefault(s, 0) + 1);
			}
		}
		
		ArrayList<String> list = new ArrayList<>(hm.keySet());
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String a, String b) {
				int aN = hm.get(a);
				int bN = hm.get(b);
				
				if(aN != bN) {
					return bN - aN;
				}
				
				if(a.length() != b.length()) {
					return b.length() - a.length();
				}
				
				return a.compareTo(b);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		System.out.print(sb);
	}
}