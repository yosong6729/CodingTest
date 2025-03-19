import java.util.*;
import java.io.*;

class Problem{
	int proNum;
	int score;
	
	Problem(int proNum, int score){
		this.proNum = proNum;
		this.score = score;
	}
}

class KCPC implements Comparable<KCPC>{
	int teamId;
	int totalScore;
	int subNum;
	int subTime;
	ArrayList<Problem> problems = new ArrayList<>();
	
	KCPC(int teamId, int totalScore, int subNum, int subTime, Problem problem){
		this.teamId = teamId;
		this.totalScore = totalScore;
		this.subNum = subNum;
		this.subTime = subTime;
		this.problems.add(problem);
	}
	
	@Override
	public int compareTo(KCPC o) {
		if(this.totalScore != o.totalScore) {
			return o.totalScore - this.totalScore;
		}
		
		if(this.subNum != o.subNum) {
			return this.subNum - o.subNum;
		}
		
		return this.subTime - o.subTime;
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<KCPC> list = new ArrayList<>();
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int teamId = Integer.parseInt(st.nextToken());
				int proNum = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				boolean flag = true;
				boolean flag2 = true;
				
				for(KCPC K : list) {
					if(K.teamId == teamId) {
						flag = false;
						K.subNum++;
						K.subTime = j + 1;
						for(Problem p : K.problems) {
							if(p.proNum == proNum) {
								flag2 = false;
								if(p.score < score) {
									K.totalScore += score - p.score;
									p.score = score;
								}
								break;
							}
						}
						
						if(flag2) {
							K.problems.add(new Problem(proNum, score));
							K.totalScore += score;
						}
					}
				}
				
				if(flag) {
					list.add(new KCPC(teamId, score, 1, j + 1, new Problem(proNum, score)));
				}
			}
			
			Collections.sort(list);
			for(int q = 0; q < list.size(); q++) {
				if(list.get(q).teamId == t) {
					sb.append(q + 1).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}