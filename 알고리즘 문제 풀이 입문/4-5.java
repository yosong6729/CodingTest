import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[][] board){
		int answer=0;
		int n = board.length;
		
		ArrayList<Integer> xList = new ArrayList<>();
		ArrayList<Integer> yList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					xList.add(i);
					yList.add(j);
				}
			}
		}
		
		Collections.sort(xList);
		Collections.sort(yList);
		
		int mid = xList.size() / 2;
		int midX = xList.get(mid);
		int midY = yList.get(mid);
	
		for(int i = 0; i < xList.size(); i++) {
			answer += (Math.abs(xList.get(i) - midX) 
					+ Math.abs(yList.get(i) - midY));
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
	}
}
