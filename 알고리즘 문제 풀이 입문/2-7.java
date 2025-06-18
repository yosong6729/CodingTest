import java.util.*;
import java.io.*;

public class Main {
	
	public static int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		
		return H * 60 + M;
		
	}

	public String[] solution(String[] reports, int time){
		String[] answer = {};
		
		HashMap<String, Integer> inTime = new HashMap<>();
		HashMap<String, Integer> sumTime = new HashMap<>();
		
		for(String x : reports) {
			String name = x.split(" ")[0];
			int t = getTime(x.split(" ")[1]);
			String v = x.split(" ")[2];
			if(v.equals("in")) {
				inTime.put(name, t);
			}
			
			if(v.equals("out")) {
				sumTime.put(name, sumTime.getOrDefault(name, 0) + t - inTime.get(name));
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String x : sumTime.keySet()) {
			if(sumTime.get(x) > time) {
				list.add(x);
			}
		}
		
		Collections.sort(list);
		answer = new String[list.size()];
		
		int i = 0;
		for(String x : list) {
			answer[i] = x;
			i++;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));	
		System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}
}
