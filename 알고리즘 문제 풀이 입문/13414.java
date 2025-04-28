import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new LinkedHashSet<>();
		
		for(int i = 0; i < l; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				set.remove(s);
				set.add(s);
			}else {
				set.add(s);	
			}
		}

		int cnt = 0;
		for(String x : set) {
			System.out.println(x);
			cnt++;
			if(cnt == k) {
				break;
			}
		}
	}

}