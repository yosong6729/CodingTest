import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		
		long result = Long.MAX_VALUE;
		
		result = Math.min(result, (x + y) * w);
		
		result = Math.min(result,  Math.min(x, y) * s + Math.abs(x -y) * w);
		
		if(Math.abs(x - y) % 2 == 0) {
			result = Math.min(result, Math.max(x, y) * s);
		}else {
			result = Math.min(result, (Math.max(x,  y) - 1) * s + w);
		}
		
		System.out.print(result);
	}
}