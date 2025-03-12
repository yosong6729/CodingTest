import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String a, String b) {
				if(a.length() != b.length()) {
					return a.length() - b.length();
				}else {
					int aSum = 0;
					int bSum = 0;
					for(int i = 0; i < a.length(); i++) {
						if(a.charAt(i) >= '0' && a.charAt(i) <= '9') {
							aSum += a.charAt(i) - '0';
						}
						
						if(b.charAt(i) >= '0' && b.charAt(i) <= '9') {
							bSum += b.charAt(i) - '0';
						}
					}
					
					if(aSum == bSum) {
						return a.compareTo(b);
					}else{
						return aSum - bSum;
					}
				}
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.print(sb);
	}
}