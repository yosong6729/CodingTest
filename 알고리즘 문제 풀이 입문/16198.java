import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] arr;
	static ArrayList<Integer> list;
	static int max = Integer.MIN_VALUE;
	
	public static void DFS(int total) {
		if(list.size() == 2) {
			max = Math.max(max, total);
			return;
		}else {
			for(int i = 1;  i < list.size() - 1; i++) {
				int sum = (list.get(i - 1) * list.get(i + 1));
				int removedNum = list.get(i);
				list.remove(i);
				
				DFS(total + sum);
				
				list.add(i, removedNum);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		
		DFS(0);
		
		System.out.print(max);;
	}
}
