import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char[] strChar = s.toCharArray();
		
		int zeroNum = 0;
		int oneNum = 0;
		
		
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') {
				zeroNum++;
			}else {
				oneNum++;
			}
		}
		int i = 0;
		int oneTotal = 0;
		
		while(oneTotal < oneNum / 2) {
			if(strChar[i] == '1') {
				strChar[i] = '2';
				oneTotal++;
			}
			i++;
		}
		
		i = s.length() - 1;
		int zeroTotal = 0;
		while(zeroTotal < zeroNum / 2) {
			if(strChar[i] == '0') {
				strChar[i] = '2';
				zeroTotal++;
			}
			i--;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(i = 0; i < s.length(); i++) {
			if(strChar[i] == '1' || strChar[i] == '0') {
				sb.append(strChar[i]);
			}
		}
		
		System.out.print(sb);
	}
}