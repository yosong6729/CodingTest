import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[] score, int k){
		int answer = 0;

		Integer[] sortedScore = new Integer[score.length];
		
		for(int i = 0; i < score.length; i++) {
			sortedScore[i] = score[i];
		}
		
		Arrays.sort(sortedScore, (a, b) -> a - b);
		
		for(int i = 0; i < score.length - k + 1; i++) {
			if(sortedScore[i + k - 1] - sortedScore[i] <= 10){
				int sum = 0;
				for(int j = 0; j < k; j++) {
					sum += sortedScore[i + j];
				}
				
				answer = (int)(sum / k);
				break;
			}
			
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
		System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
		System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
		System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
	}
}
