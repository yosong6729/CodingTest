import java.util.*;
import java.io.*;

class Oper{
	int cnt;
	ArrayList<Integer> list = new ArrayList<>();
	
	Oper(int cnt, ArrayList<Integer> list){
		this.cnt = cnt;
		this.list = list;
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Oper[] dp = new Oper[n + 1];
		ArrayList<Integer> first = new ArrayList<>();
		first.add(1);
		dp[1] = new Oper(0, first);
		
		for(int i = 2; i <= n ; i++) {
			
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			if(i % 2 == 0) {
				if(min > dp[i / 2].cnt) {
					min = dp[i / 2].cnt;
					minIdx = i / 2;
				}
			}
			
			if(i % 3 == 0) {
				if(min > dp[i / 3].cnt) {
					min = dp[i / 3].cnt;
					minIdx = i / 3;
				}
			}
			
			if(min > dp[i - 1].cnt) {
				min = dp[i - 1].cnt;
				minIdx = i - 1;
			}
			
			ArrayList<Integer> list = new ArrayList<>(dp[minIdx].list);
			list.add(i);
			
			dp[i] = new Oper(min + 1, list);
		}
		
		System.out.println(dp[n].cnt);
		Collections.sort(dp[n].list, Collections.reverseOrder());
		for(int x : dp[n].list) {
			System.out.print(x + " ");
		}
	}
}