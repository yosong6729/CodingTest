import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		double l = Integer.parseInt(st.nextToken());
		double w = Integer.parseInt(st.nextToken());
		double h = Integer.parseInt(st.nextToken());
		
		
		double lt = 0;
		double rt = Math.max(Math.max(l,  w), h);
		
		for(int i = 0; i < 100; i++) {
			double mid = (lt + rt) / 2;
			
			long total = ((long)(l / mid)) * ((long)(w / mid)) * ((long)(h / mid));
			if(total >= n) {
				lt = mid;
			}else {
				rt = mid;
			}
		}
		
		System.out.print(lt);
	}
}