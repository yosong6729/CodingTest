import java.util.*;
import java.io.*;

class Team implements Comparable<Team>{
	int t;
	int cnt;
	int sum;
	int five;
	
	Team(int t, int cnt, int sum, int five){
		this.t = t;
		this.cnt = cnt;
		this.sum = sum;
		this.five = five;
	}
	
	@Override
	public int compareTo(Team o) {
		if(this.sum == o.sum) {
			return this.five - o.five;
		}
		return this.sum - o.sum;
	}
	
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			}
			
			ArrayList<Integer> notTeam = new ArrayList<>();
			
			for(int x : map.keySet()) {
				if(map.get(x) != 6) {
					notTeam.add(x);
				}
			}

			ArrayList<Team> teamList = new ArrayList<>();
			
			for(int j = 0; j <= 200; j++) {
				teamList.add(new Team(j, 0, 0, 0));
			}
			int score = 1;
			
			for(int x : arr) {
				if(!notTeam.contains(x)) {
					Team team = teamList.get(x);
					team.cnt++;
					if(team.cnt == 5) {
						team.five = score;
					}
					if(team.cnt <= 4) {
						team.sum += score;
					}
					score++;
				}
			}
			
			Collections.sort(teamList);
			
			for(Team team : teamList) {
				if(team.cnt != 0) {
					sb.append(team.t).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}