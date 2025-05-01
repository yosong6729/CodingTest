import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] count = new int[8001];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		double sum = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
			count[num + 4000]++;
			map.put(num, map.getOrDefault(num, 0) + 1);
			min = Math.min(min, num);
			max = Math.max(max,  num);
		}
		
		System.out.println(Math.round(sum / n));
		
		Arrays.sort(arr);
		System.out.println(arr[n / 2]);
		
		int maxCount = Integer.MIN_VALUE;
		for(int x : count) {
			maxCount = Math.max(maxCount, x);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i <= 8000; i++) {
			if(count[i] == maxCount) {
				list.add(i - 4000);
			}
		}
		
		Collections.sort(list);
		if(list.size() > 1) {
			System.out.println(list.get(1));
		}else {
			System.out.println(list.get(0));
		}
		
		System.out.println(max - min);
				
	}
}