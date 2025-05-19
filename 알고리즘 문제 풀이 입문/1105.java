import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String l = st.nextToken();
		String r = st.nextToken();
		
		if(l.length() < r.length()){
			System.out.print(0);
			return;
		}
		
		int cnt = 0;
		for(int i = 0; i < l.length(); i++) {
			if(l.charAt(i) == r.charAt(i)) {
				if(l.charAt(i) == '8') {
					cnt++;
				}
			}else {
				break;
			}
		}
		
		System.out.print(cnt);
	}
}
