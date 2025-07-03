import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] tasks, long k) {
    	int answer = 0;
    	
    	int[] sT = new int[tasks.length + 1];
    	
    	for(int i = 0; i < tasks.length; i++) {
    		sT[i + 1] = tasks[i]; 
    	}
    	
    	Arrays.sort(sT);
    	
    	int len = tasks.length;
    	for(int i = 1; i < sT.length; i++) {
    		int timeDiff = (sT[i] - sT[i - 1]) * len;
    		
    		if(timeDiff > k) {
    			long idx = (long) k % len;
    			
    			int cnt = 0;
    			for(int j = 0; j < tasks.length; j++) {
    				if(tasks[j] >= sT[i]) {
    					if(idx == cnt) {
    						return j + 1;
    					}
    					cnt++;
    				}
    			}
    		}else{
    			k -= timeDiff;
    			len--;
    		}
    	}
	
		return -1;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{1, 2, 3}, 5));
		System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}
}
