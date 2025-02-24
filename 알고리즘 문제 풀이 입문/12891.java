import java.util.*;

class Main {
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int s = kb.nextInt();
		int p = kb.nextInt();
		char[] arr = new char[s];
		int result = 0;
		
		String dna = kb.next();
		arr = dna.toCharArray();
		
		int AN = kb.nextInt();
		int CN = kb.nextInt();
		int GN = kb.nextInt();
		int TN = kb.nextInt();
		
		int aN = AN;
		int cN = CN;
		int gN = GN;
		int tN = TN;
		
		for(int i = 0; i < p; i++) {
			if(arr[i] == 'A') {
				aN--;
			}else if(arr[i] == 'C') {
				cN--;
			}else if(arr[i] == 'G') {
				gN--;
			}else if(arr[i] == 'T') {
				tN--;
			}
		}
		
		if(aN <= 0 && cN <= 0 && gN <= 0 &&  tN <= 0) {
			result++;
		}
		
		int j = 0;
		
		for(int i = p; i < s ; i++) {
			if(arr[i] == 'A') {
				aN--;
			}else if(arr[i] == 'C') {
				cN--;
			}else if(arr[i] == 'G') {
				gN--;
			}else if(arr[i] == 'T') {
				tN--;
			}
			
			if(arr[j] == 'A') {
				aN++;
			}else if(arr[j] == 'C') {
				cN++;
			}else if(arr[j] == 'G') {
				gN++;
			}else if(arr[j] == 'T') {
				tN++;
			}
			j++;
			
			if(aN <= 0 && cN <= 0 && gN <= 0 &&  tN <= 0) {
				result++;
			}
		}
		
		System.out.print(result);
	}
}