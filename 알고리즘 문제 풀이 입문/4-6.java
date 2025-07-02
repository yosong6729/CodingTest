import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] tasks, long k) {
    	int answer = 0;
    	
    	ArrayList<int[]> list = new ArrayList<>();
    	
    	int n = tasks.length;
    	
    	for(int i = 0; i < n; i++) {
    		int time = tasks[i];
    		list.add(new int[] {time, i + 1});
    	}
    	
    	Collections.sort(list, (a, b) -> a[0] - b[0]);
    	
    	int minusSum = 0;
    	int time = 0;
    	int len = n;
    	int startIdx = 0;
    	
    	for(int i = 0; i < n; i++) {
    		time = list.get(i)[0];
    		
    		if(time * len <= k) {
    			k -= (time * len);
    			minusSum += time;
    			len--;
    			startIdx++;
    		}else {
    			break;
    		}
    	}
    	
    	Collections.sort(list, (a, b) -> a[1] - b[1]);
    	
    	for(int i = startIdx; i < n; i++) {
    		list.get(i)[0] -= minusSum;
    	}
    	
    	for(int i = startIdx; i < n; i++) {
    		if(k - list.get(i)[0] >= 0) {
    			k -= list.get(i)[0];
    		}else {
    			answer = list.get(i)[1];
    			break;
    		}
    	}
	
    	return answer;
	}	
	
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{1, 2, 3}, 5));
		System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}
}
