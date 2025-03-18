import java.util.*;
import java.io.*;

class Member implements Comparable<Member>{
	int l;
	String name;
	Member(int l, String name){
		this.l = l;
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return this.name.compareTo(o.name);
	}
}

class Room{
	int l;
	ArrayList<Member> members = new ArrayList<>();
	
	Room(int l, Member member){
		this.l = l;
		this.members.add(member);
	}
}

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Room> roomList = new ArrayList<>();
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if(roomList.isEmpty()) {
				roomList.add(new Room(l, new Member(l, name)));
			}else{
				boolean flag = true;
				for(Room r : roomList) {
					if(l >= r.l - 10 && l <= r.l + 10 && r.members.size() < m) {
						r.members.add(new Member(l, name));
						flag = false;
						break;
					}
				}
				
				if(flag) {
					roomList.add(new Room(l, new Member(l, name)));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Room r : roomList) {
			if(r.members.size() == m) {
				sb.append("Started!").append("\n");
			}else {
				sb.append("Waiting!").append("\n");
			}
			
			ArrayList<Member> members = r.members;
			Collections.sort(members);
			
			for(Member member : members) {
				sb.append(member.l).append(" ").append(member.name).append("\n");
			}
		}
		
		System.out.print(sb);		
	}
}