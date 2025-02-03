import java.util.*;

class Time implements Comparable<Time>{
	int time;
	char state;
	
	Time(int time, char state){
		this.time = time;
		this.state = state;
	}
	
	@Override
	public int compareTo(Time o) {
		if(o.time == this.time) {
			return this.state - o.state;
		}else {
			return this.time - o.time;
		}
	}
}

public class Main {
	
	public void solution(int n, ArrayList<Time> list) {
	
		Collections.sort(list);
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).state == 's') {
				cnt++;
			}else {
				cnt--;
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
			int st = kb.nextInt();
			list.add(new Time(st, 's'));
			int et = kb.nextInt();
			list.add(new Time(et, 'e'));
		}
		
		T.solution(n, list);
	}
}
