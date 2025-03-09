import java.util.*;
import java.io.*;

class Main {
	

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Integer> removeList = new ArrayList<>();
		
		for(int i = 123; i <= 987; i++) {
			int num = i;
			int firstNum = num / 100  % 10;
			int secondNum = num / 10 % 10;
			int thirdNum = num % 10;
			
			if(firstNum == 0 || secondNum == 0 || thirdNum == 0) {
				continue;
			}else if(firstNum == secondNum || firstNum == thirdNum
					|| secondNum == thirdNum) {
				continue;
			}else {
				numList.add(num);
			}
		}
		
		for(int i = 0; i < n; i++) {
			int num = kb.nextInt();
			int strike = kb.nextInt();
			int ball = kb.nextInt();
			
			int firstNum = num / 100  % 10;
			int secondNum = num / 10 % 10;
			int thirdNum = num % 10;
			
			for(int x : numList) {
				
				int s = 0;
				int b = 0;
				
				int xFirstNum = x / 100  % 10;
				int xSecondNum = x / 10 % 10;
				int xThirdNum = x % 10;
				
				
				// 스트라이크: 같은 자리 비교
				if(xFirstNum == firstNum) s++;
				if(xSecondNum == secondNum) s++;
				if(xThirdNum == thirdNum) s++;

				// 볼: 다른 자리 비교
				if(xFirstNum == secondNum || xFirstNum == thirdNum) b++;
				if(xSecondNum == firstNum || xSecondNum == thirdNum) b++;
				if(xThirdNum == firstNum || xThirdNum == secondNum) b++;
				
				if(s != strike || b != ball) {
					removeList.add(x);
				}
			}
		}	
		
		for(int x : removeList) {
			if(numList.contains(x)) {
				numList.remove(Integer.valueOf(x));
			}
		}
		
		System.out.print(numList.size());
	}	
}