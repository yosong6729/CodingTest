import java.util.*;
import java.io.*;

class A implements Comparable<A>{
	String name;
	int time;
	
	public A(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public int compareTo(A o) {
		return this.time - o.time;
	}

	
	
}

public class Main {

	public String[] solution(String[] reports, String times){
		String[] answer = {};
		ArrayList<A> list = new ArrayList<>(); 
		
		int start = Integer.parseInt(times.split(" ")[0].split(":")[0] + 
				times.split(" ")[0].split(":")[1]);
		int end = Integer.parseInt(times.split(" ")[1].split(":")[0] + 
				times.split(" ")[1].split(":")[1]);
		
		for(String x : reports) {
			String name = x.split(" ")[0];
			int time = Integer.parseInt(x.split(" ")[1].split(":")[0] + 
					x.split(" ")[1].split(":")[1]);
			
			if(time >= start && time <= end) {
				list.add(new A(name, time));
			}
		}
		
		Collections.sort(list);
		answer = new String[list.size()];
		
		int i = 0;
		for(A x : list) {
			answer[i] = x.name;
			i++;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}
