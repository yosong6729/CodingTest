import java.util.*;
import java.io.*;

class Tree implements Comparable<Tree>{
	int h;
	int a;
	
	Tree(int h, int a){
		this.h = h;
		this.a = a;
	}
	
	@Override
	public int compareTo(Tree o) {
		return this.a - o.a;
	}
}


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Tree[] arr = new Tree[n];
		int[] h = new int[n];
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = new Tree(h[i], a[i]);
		}
		
		Arrays.sort(arr);
		
		long result = 0;
		
		for(int i = 0; i < n; i++) {
			result += (long)arr[i].a * i + (long)arr[i].h;
		}

		System.out.print(result);
	}
}