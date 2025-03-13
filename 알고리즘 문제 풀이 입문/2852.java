import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int score1 = 0, score2 = 0;
		int score1Time = 0, score2Time = 0;
		
		int lastTime = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			int currentTime = changeTime(st.nextToken());
			
			if(score1 > score2) {
				score1Time += (currentTime - lastTime);
			}else if(score2 > score1){
				score2Time += (currentTime - lastTime);
			}
			
			if(team == 1) {
				score1++;
			}else {
				score2++;
			}
			
			lastTime = currentTime;
		}
		
		
		if(score1 > score2) {
			score1Time += (2880 - lastTime);
		}else if(score2 > score1){
			score2Time += (2880 - lastTime);
		}
		
		System.out.println(timeFormat(score1Time));
		System.out.print(timeFormat(score2Time));
	}
	
	public static int changeTime(String s) {
		
		String[] parts = s.split(":");
		
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);
		
		return minutes * 60 + seconds; 
	}
	
	public static String timeFormat(int n) {
		
		int minutes = n / 60;
		int seconds = n % 60;
		
		return String.format("%02d:%02d", minutes, seconds);
	}
}