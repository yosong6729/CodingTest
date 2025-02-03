import java.util.*;

class Time implements Comparable<Time>{
	int s;
	int e;
	
	Time(int s, int e){
		this.s = s;
		this.e = e;
	}
	
	@Override
	public int compareTo(Time o) {
		if(this.e != o.e) {
			return this.e - o.e;
		}else {
			return this.s - o.s;
		}
	}
}

public class Main {
	
	public void solution(int n, Time[] arr) {
		
		Arrays.sort(arr);
		
		Time last = arr[0];
		int cnt = 1;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].s >= last.e) {
				last = arr[i];
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		Time[] arr = new Time[n];
		
		for(int i = 0; i < n; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			arr[i] = new Time(s, e);
		}
		
		T.solution(n, arr);
	}
}
