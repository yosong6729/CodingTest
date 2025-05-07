import java.util.*;
import java.io.*;

class STU{
	int n;
	int rec;
	
	STU(int n, int rec){
		this.n = n;
		this.rec = rec;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<STU> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int stuNum = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			for(STU S : list) {
				if(S.n == stuNum) {
					S.rec++;
					flag = true;
					break;
				}
			}
			if(flag) {
				continue;
			}
			
			if(list.size() < n) {
				list.add(new STU(stuNum, 1));
				continue;
			}
			
			int min = Integer.MAX_VALUE;
			for(STU S : list) {
				min = Math.min(min, S.rec);
			}
			
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).rec == min) {
					list.remove(j);
					list.add(new STU(stuNum, 1));
					break;
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(STU S : list) {
			result.add(S.n);
		}
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for(int x : result) {
			sb.append(x).append(" ");
		}
		
		System.out.print(sb);
	}
}
