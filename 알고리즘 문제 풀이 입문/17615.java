import java.util.*;
import java.io.*;

class Main {
	
	static int n, min, totalRedCnt, totalBlueCnt;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		
		char[] arr = str.toCharArray();
		min = Integer.MAX_VALUE;
		totalRedCnt = 0;
		totalBlueCnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == 'R') {
				totalRedCnt++;
			}else if(arr[i] == 'B') {
				totalBlueCnt++;
			}
		}
		
		firstRed(arr.clone());
		lastRed(arr.clone());
		firstBlue(arr.clone());
		lastBlue(arr.clone());
		
		System.out.print(min);
	}
	
	public static void firstRed(char[] arr) {
		int sum = 0;
		
		for(int i = 0; i < n ; i++) {
			if(arr[i] == 'R') {
				sum++;
			}else {
				break;
			}
		}
		min = Math.min(min, totalRedCnt - sum);
	}
	
	public static void lastRed(char[] arr) {
		int sum = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(arr[i] == 'R') {
				sum++;
			}else {
				break;
			}
		}
		min = Math.min(min, totalRedCnt - sum);
	}
	
	public static void firstBlue(char[] arr) {
		int sum = 0;
		for(int i = 0; i < n ; i++) {
			if(arr[i] == 'B') {
				sum++;
			}else {
				break;
			}
		}
		min = Math.min(min, totalBlueCnt - sum);
	}
	
	public static void lastBlue(char[] arr) {
		int sum = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(arr[i] == 'B') {
				sum++;
			}else {
				break;
			}
		}
		min = Math.min(min, totalBlueCnt - sum);
	}
	
}