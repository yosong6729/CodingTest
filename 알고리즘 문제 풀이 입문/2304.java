import java.util.*;
import java.io.*;

class Roof implements Comparable<Roof>{
	int x;
	int h;
	Roof(int x, int h){
		this.x = x;
		this.h = h;
	}
	
	@Override
	public int compareTo(Roof o) {
		return this.x - o.x;
	}
	
}

class Main {
	

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		Roof[] roofList = new Roof[n];
		
		for(int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int h = kb.nextInt();
			roofList[i] = new Roof(x, h);
		}
		
		Arrays.sort(roofList);
	
		int roofMaxH = 0;
		int roofMaxHL = 0;
		int roofMaxHR = 0;
		
		for(int i = 0; i < n; i++) {
			if(roofMaxH < roofList[i].h) {
				roofMaxH = roofList[i].h;
				roofMaxHL = roofMaxHR = i;
			}else if(roofMaxH == roofList[i].h) {
				roofMaxHR = i;
			}
		}
		
		int curL = roofList[0].x;
		int curH = roofList[0].h;
		int leftSum = 0;
		
		for(int i = 1; i <= roofMaxHL; i++) {
			if(curH < roofList[i].h) {
				leftSum += (roofList[i].x - curL) * curH;
				curH = roofList[i].h;
				curL = roofList[i].x;
			}
		}
		
		curL = roofList[n - 1].x;
		curH = roofList[n - 1].h;
		int rightSum = 0;
		
		for(int i = n - 1; i >= roofMaxHR ; i--) {
			if(curH < roofList[i].h) {
				rightSum += curH * (curL - roofList[i].x);
				curL = roofList[i].x;
				curH = roofList[i].h;
			}
		}
		
		int midSum = roofMaxH * ((roofList[roofMaxHR].x - roofList[roofMaxHL].x + 1));
		
		System.out.print(leftSum + rightSum + midSum);
	}	
}