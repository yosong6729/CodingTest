import java.util.*;
import java.io.*;

class Main {
	

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		kb.nextLine();
		String[] list = new String[n];
		ArrayList<Character> alpha = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list[i] = kb.nextLine();
		}
		
		for(String s : list) {
			
			String[] splitStr = s.split(" ");
			int includeAlpha = -1;
			
			int i = 0;
			for(String str : splitStr) {
				char c = Character.toUpperCase(str.charAt(0));
				if(!alpha.contains(c)) {
					alpha.add(c);
					i = s.indexOf(str);
					includeAlpha = i;
					break;
				}
			}
			
			
			if(includeAlpha == -1) {
				i = 0;
				for(char c : s.toCharArray()) {
					char upC = Character.toUpperCase(c);
					if(!alpha.contains(upC) && upC !=  ' ') {
						alpha.add(upC);
						includeAlpha = i;
						break;
					}
					i++;
				}
			}
			StringBuilder sb = new StringBuilder(s);
			
			if(includeAlpha == -1) {
				result.add(s);
			}else {
				sb.insert(includeAlpha, "[");
				sb.insert(includeAlpha + 2, "]");
				result.add(sb.toString());
			}
		}
		
		for(String s : result) {
			System.out.println(s);
		}
	}	
}