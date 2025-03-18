import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[4];
		for(int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int numMin = Integer.MAX_VALUE;
		
		for(int i = 0; i < 4; i++) {
			int sum = 0;
			for(int j = i; j < i + 4; j++) {
				int idx = j % 4;
				sum = sum * 10 + num[idx];
			}
			numMin = Math.min(numMin, sum);
		}
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		for(int i = 1111; i <= 9999; i++) {
			String str = Integer.toString(i);
			int[] iNum = new int[4];
			int iNumMin = Integer.MAX_VALUE;
			
			if(str.contains("0")) {
				continue;
			}
			
			for(int j = 0; j < 4; j++) {
				iNum[j] = str.charAt(j) - '0';
			}
			
			for(int j = 0; j < 4; j++) {
				int sum = 0;
				for(int k = j; k < j + 4; k++) {
					int idx = k % 4;
					sum = sum * 10 + iNum[idx];
				}
				iNumMin = Math.min(iNumMin, sum);
			}
			
			if(iNumMin < numMin) {
				ts.add(iNumMin);
			}
		}
		
		System.out.print(ts.size() + 1);
	}
}