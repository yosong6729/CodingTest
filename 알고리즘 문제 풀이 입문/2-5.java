import java.util.*;
import java.io.*;

public class Main {

	public String solution(String[] votes, int k){
		String answer = " ";
		
		HashMap<String, Integer> vote = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < votes.length; i++) {
			String s = votes[i];
			String[] str = s.split(" ");
			
			vote.put(str[1], vote.getOrDefault(str[1], 0) + 1);
		}
		
		
		for(String s : vote.keySet()) {
			if(vote.get(s) >= k) {
				for(String x : votes) {
					String[] str = x.split(" ");
					
					if(str[1].equals(s)) {
						map.put(str[0], map.getOrDefault(str[0], 0) + 1);
					}
				}
			}
		}
		
		int max = 0;
		for(String s : map.keySet()) {
			max = Math.max(max, map.get(s));
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String s : map.keySet()) {
			if(max == map.get(s)) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		answer = list.get(0);
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}
