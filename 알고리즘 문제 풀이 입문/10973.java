import java.util.*;
import java.io.*;

class Main {
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static boolean findPrevNum(int[] arr) {
		int i = arr.length - 1;
		
		while(i >= 1 && arr[i - 1] <= arr[i]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		int j = arr.length - 1;
	
		while(i <= j &&arr[i - 1] <= arr[j]) {
			j--;
		}
		
		swap(arr, i - 1, j);
		
		j = arr.length - 1;
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(!findPrevNum(arr)) {
			System.out.print(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int x : arr) {
			sb.append(x).append(" ");
		}
		
		System.out.print(sb);
	}
}