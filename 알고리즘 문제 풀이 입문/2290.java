import java.util.*;
import java.io.*;

class Main {
	
	static int curX, curY;
	static int s;
	static char[][] arr;
	static String n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		
		arr = new char[2 * s + 3][(s + 2) * n.length() + n.length()];
		
		for(int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		curX = 0;
		curY = 0;
		
		for(int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			switch(num) {
				case 1:
					one();
					break;
				case 2:
					two();
					break;
				case 3:
					three();
					break;
				case 4:
					four();
					break;
				case 5:
					five();
					break;
				case 6:
					six();
					break;
				case 7:
					seven();
					break;
				case 8:
					eight();
					break;
				case 9:
					nine();
					break;
				case 0:
					zero();
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2 * s + 3; i++) {
			for(int j = 0; j < (s + 2) * n.length() + n.length(); j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void one(){
		h2();
		h4();
		curY += (s + 3);
	}
	
	public static void two() {
		w1();w2();w3();
			h2();h3();
		curY += (s + 3);
	}
	
	public static void three() {
		w1();
		w2();
		w3();
		h2();
		h4();
		curY += (s + 3);
	}
	
	public static void four() {
		h1();
		h2();
		h4();
		w2();
		curY += (s + 3);
	}
	
	public static void h1(){
		for(int i = 0; i < s; i++) {
			arr[curX + 1 + i][curY] = '|';
		}
	}
	
	public static void h2() {
		for(int i = 0; i < s; i++) {
			arr[curX + 1 + i][curY + s + 1] = '|';
		}
	}
	
	public static void h3() {
		for(int i = 0; i < s; i++) {
			arr[curX + s + 2 + i][curY] = '|';
		}
	}
	
	public static void h4() {
		for(int i = 0; i < s; i++) {
			arr[curX + s + 2 + i][curY + s + 1] = '|';
		}
	}
	
	public static void w1() {
		for(int i = 0; i < s; i++) {
			arr[curX][curY + 1 + i] = '-';
		}
	}
	
	public static void w2() {
		for(int i = 0; i < s; i++) {
			arr[curX + s + 1][curY + 1 + i] = '-';
		}
	}
	
	public static void w3() {
		for(int i = 0; i < s; i++) {
			arr[curX + 2 * s + 2][curY + 1 + i] = '-';
		}
	}
	public static void five() {
		w1();
		w2();
		w3();
		h1();
		h4();
		curY += (s + 3);
	}
	
	public static void six() {
		w1(); w2(); w3();
		h1(); h3(); h4();
		curY += (s + 3);
	}
	
	public static void seven() {
		w1();
		h2(); h4();
		curY += (s + 3);
	}
	
	public static void eight() {
		w1(); w2(); w3();
		h1(); h2(); h3(); h4();
		curY += (s + 3);
	}
	
	public static void nine() {
		w1(); w2(); w3();
		h1(); h2(); h4();
		curY += (s + 3);
	}
	
	public static void zero() {
		w1(); w3();
		h1(); h2(); h3(); h4();
		curY += (s + 3);
	}
	
	
}