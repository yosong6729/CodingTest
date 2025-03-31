import java.util.*;
import java.io.*;

class Score implements Comparable<Score>{
	int doc;
	int interview;
	
	Score(int doc, int interview){
		this.doc = doc;
		this.interview = interview;
	}
	
	@Override
	public int compareTo(Score o) {
		return this.interview - o.interview;
	}
	
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			Score[] arr = new Score[n];
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[j] = new Score(a, b);
			}
			
			Arrays.sort(arr);
			
			int docMin = arr[0].doc;
			int result = 1;
			
			for(int j = 1; j < n; j++) {
				Score score = arr[j];
				if(docMin > score.doc) {
					docMin = score.doc;
					result++;
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}