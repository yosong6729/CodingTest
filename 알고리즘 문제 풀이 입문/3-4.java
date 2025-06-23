import java.util.*;
import java.io.*;

public class Main {
	
	public static int getTime(String s) {
		
		int h = Integer.parseInt(s.split(":")[0]);
		int m = Integer.parseInt(s.split(":")[1]);
		
		return h * 60 + m;
	}
	
	public int solution(int[] laser, String[] enter){
		int answer = 0;
		
		Queue<String> Q = new LinkedList<>();
		int n = enter.length;
		Q.offer(enter[0]);
		
		int i = 1;
		
		while(true) {
			
			String s = Q.poll();
			int time = getTime(s.split(" ")[0]);
			int l = time + laser[Integer.parseInt(s.split(" ")[1])];
			
			while(i < n && getTime(enter[i].split(" ")[0]) < l) {
				Q.offer(enter[i]);
				i++;
			}
			
			answer = Math.max(Q.size(), answer);
			
			if(i < n && Q.isEmpty()) {
				Q.offer(enter[i]);
				i++;
			}
			
			if(i == n) {
				break;
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
	}
}
