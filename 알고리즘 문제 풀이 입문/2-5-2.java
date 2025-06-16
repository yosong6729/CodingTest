import java.util.*;
import java.io.*;

public class Main {

	public String solution(String[] votes, int k){
		String answer = " ";
		
		HashMap<String, HashSet<String>> vote = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String x : votes) {
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			
			vote.putIfAbsent(a, new HashSet<>());
			vote.get(a).add(b);
			candidate.put(b, candidate.getOrDefault(b, 0) + 1);
		}
		
		int max = 0;
		
		for(String x : vote.keySet()) {
			for(String s : vote.get(x)) {
				if(candidate.get(s) >= k) {
					map.put(x, map.getOrDefault(x, 0) + 1);
					max = Math.max(max, map.get(x));
				}
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String s : map.keySet()) {
			if(max == map.get(s)) {
				list.add(s);
			}
		}
		list.sort((a , b) -> a.compareTo(b));
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
