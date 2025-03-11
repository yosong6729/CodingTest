import java.util.*;
import java.io.*;

class Doc implements Comparable<Doc>{
	String s;
	int len;
	Doc(String s, int len){
		this.s = s;
		this.len = len;
	}
	
	@Override
	public int compareTo(Doc o) {
		if(this.len == o.len) {
			return this.s.compareTo(o.s);
		}else {
			return o.len - this.len;
		}
	}
	
}

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
		ArrayList<ArrayList<Doc>> list = new ArrayList<>();
		
		for(int i = 0; i <= 100000; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.length() >= m) {
				hm.put(s, hm.getOrDefault(s, 0) + 1);
			}
		}
		
		for(String key : hm.keySet()) {
			list.get(hm.get(key)).add(new Doc(key, key.length()));
		}
		
		for(ArrayList<Doc> l : list) {
			Collections.sort(l);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 100000; i >= 1; i--) {
			if(!list.get(i).isEmpty()) {
				for(Doc d : list.get(i)) {
					String s = d.s;
					sb.append(s).append("\n");
				}
			}
		}
		
		System.out.print(sb);
	}
}