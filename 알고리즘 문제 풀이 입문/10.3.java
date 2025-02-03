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
		if(o.e == this.e) {
			return  this.s - o.s;
		}else{
			return this.e - o.e;
		}
	}
}

public class Main {
	
	public void solution(int n, ArrayList<Time> list) {
	
		Collections.sort(list);
		int cnt = 0;
		int max = 0;
		int[] st = new int[list.get(list.size() - 1).e + 1];
		int[] et = new int[list.get(list.size() - 1).e + 1];
				
		
		for(int i = 0; i < list.size(); i++) {
			st[list.get(i).s] += 1;
			et[list.get(i).e] += 1;
		}
		
		for(int i = 0; i < list.get(list.size() - 1).e; i++) {
			if(et[i] != 0) {
				cnt -= et[i];
			}
			
			if(st[i] != 0) {
				cnt += st[i];
			}
			max = Math.max(max, cnt);
		}

		System.out.print(max);
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ArrayList<Time> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			list.add(new Time(s, e));
		}
		
		T.solution(n, list);
	}
}
