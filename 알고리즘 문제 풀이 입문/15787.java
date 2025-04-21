import java.util.*;
import java.io.*;

class IntArray{
	int[] arr;
	
	IntArray(int[] arr){
		this.arr = arr;
	}
	@Override
	public boolean equals(Object o) {
		return o instanceof IntArray
				&& Arrays.equals(arr, ((IntArray)o).arr);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(arr);
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<IntArray> set = new HashSet<>();
		
		ArrayList<IntArray> list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new IntArray(new int[21]));
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = 0;
			int c = 0;
			int arr[];
			switch(a) {
			case 1:
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				arr = list.get(b).arr;
				arr[c] = 1;
				list.get(b).arr = arr;
				break;
			case 2:
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				arr = list.get(b).arr;
				arr[c] = 0;
				list.get(b).arr = arr;
				break;
			case 3:
				b = Integer.parseInt(st.nextToken());
				arr = list.get(b).arr;
				if(arr[20] == 1) {
					arr[20] = 0;
				}
				for(int j = 20; j >= 2; j--) {
					arr[j] = arr[j - 1];
				}
				arr[1] = 0;
				list.get(b).arr = arr;
				break;
			case 4:
				b = Integer.parseInt(st.nextToken());
				arr = list.get(b).arr;
				if(arr[1] == 1) {
					arr[1] = 0;
				}
				for(int j = 1; j <= 19; j++) {
					arr[j] = arr[j + 1];
				}
				arr[20] = 0;
				list.get(b).arr = arr;
				
				break;
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			set.add(list.get(i));
		}
		
		System.out.print(set.size());
	}
}