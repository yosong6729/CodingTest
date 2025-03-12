import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<String> da = new ArrayList<>();
		String[] yeung = new String[n];
		
		for(int i = 0; i < n; i++) {
			da.add(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			yeung[i] = br.readLine();
		}
		
		int j = 0;
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			if(!yeung[i].equals(da.get(j))) {
				for(int k = j + 1; k < n; k++){ 
					if(yeung[i].equals(da.get(k))) {
						da.remove(k);
						result++;
						break;
					}
				}
			}else {
				j++;
			}
		}
		
		System.out.print(result);
	}
}