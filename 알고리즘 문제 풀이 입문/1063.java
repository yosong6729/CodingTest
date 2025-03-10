import java.util.*;
import java.io.*;

class Main {
	
	static char[] king, rock;
	
 
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		king = kb.next().toCharArray();
		rock = kb.next().toCharArray();
		
		int n = kb.nextInt();
		
		for(int i = 0; i < n; i++) {
			String s = kb.next();
			char[] k_pos = king.clone();
			char[] r_pos = rock.clone();
			
			move(s, k_pos);
			if(!rangeCheck(k_pos)) {
				continue;
			}
			if(Arrays.equals(k_pos, r_pos)) {
				move(s, r_pos);
				if(!rangeCheck(r_pos)) {
					continue;
				}
			}
			
			king = k_pos;
			rock = r_pos;
		}
		
		System.out.println(king);
		System.out.print(rock);
	}
	
	public static void move(String s, char[] pos) {
		
		switch(s){
		case "T":
			pos[1]++;
			break;
		case "RT":
			pos[0]++;
			pos[1]++;
			break;
		case "R":
			pos[0]++;
			break;
		case "RB":
			pos[0]++;
			pos[1]--;
			break;
		case "B":
			pos[1]--;
			break;
		case "LB":
			pos[1]--;
			pos[0]--;
			break;
		case "L":
			pos[0]--;
			break;
		case "LT":
			pos[0]--;
			pos[1]++;
			break;
		}
	}
	
	public static boolean rangeCheck(char[] pos) {
		if(pos[0] >= 'A' && pos[0] <= 'H' && pos[1] >= '1' && pos[1] <= '8') {
			return true;
		}else {
			return false;
		}
	}
	
}