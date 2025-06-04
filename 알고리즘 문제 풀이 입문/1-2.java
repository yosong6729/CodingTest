import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] d = {0, 1, 2, 3};
	static int[] answer;
	static int n;
	static boolean flag = false;
	
	public static void DFS(int[][] board, int x, int y, int d, int cnt, int k) {
		if(flag) {
			return;
		}
		
		if(cnt == k) {
			answer[0] = x;
			answer[1] = y;
			flag = true;
			return;
		}else {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n
					&& board[nx][ny] == 0) {
				DFS(board, nx, ny, d, cnt+ 1, k);
			}else {
				DFS(board, x, y, (d + 1) % 4, cnt + 1, k);
			}
		}
	}
	
	public int[] solution(int[][] board, int k){
		answer = new int[2]; 
		flag = false;
		n = board[0].length;
		
		DFS(board, 0, 0, 1, 0, k);
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}


}
