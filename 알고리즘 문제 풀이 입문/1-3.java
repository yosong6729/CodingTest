import java.util.*;
import java.io.*;

public class Main {
	
	public int solution(int[][] board){
		int answer = 0;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int hd = 0;
		int dd = 0;
		
		int hx = 0;
		int hy = 0;
		int dogx = 0;
		int dogy = 0;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 ;j++) {
				if(board[i][j] == 2) {
					hx = i;
					hy = j;
				}
				
				if(board[i][j] == 3) {
					dogx = i;
					dogy = j;
				}
			}
		}
		
		int time = 0;
		while(time < 10000) {
			time++;
			
			int hnx = hx + dx[hd];
			int hny = hy + dy[hd];
			
			int dnx = dogx + dx[dd];
			int dny = dogy + dy[dd];
			
			if(hnx >= 0 && hnx < 10 && hny >= 0 && hny < 10) {
				if(board[hnx][hny] == 0 || board[hnx][hny] == 3) {
					hx = hnx;
					hy = hny;
				}
				
				if(board[hnx][hny] == 1) {
					hd = (hd + 1) % 4;
				}
			}else {
				hd = (hd + 1) % 4;
			}
			
			if(dnx >= 0 && dnx < 10 && dny >= 0 && dny < 10) {
				if(board[dnx][dny] == 0 || board[dnx][dny] == 3) {
					dogx = dnx;
					dogy = dny;
				}
				
				if(board[dnx][dny] == 1) {
					dd = (dd + 1) % 4;
				}
			}else {
				dd = (dd + 1) % 4;
			}
			
			if(dogx == hx && dogy == hy) {
				answer = time;
				break;
			}
		}
		
		return answer;		
	}

	public static void main(String[] args){
		Main T = new Main();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}
